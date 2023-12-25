package com.tclab.weixinappletuserclient.controller.front.user_client;

import com.tclab.weixinappletcommon.config.WxConfig;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.PayUtils;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.AcquisitionBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.GoodBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.GoodPlaceReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderDetailVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderPlaceReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderStatusForReportVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderStatusVo;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionStaff;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.service.clientService.GoodService;
import com.tclab.weixinappletservice.service.clientService.ImRecordService;
import com.tclab.weixinappletservice.service.clientService.OrderService;
import com.tclab.weixinappletservice.service.clientService.PackageService;
import com.tclab.weixinappletservice.service.clientService.StaffService;
import com.tclab.weixinappletuserclient.model.req.apiReq.AcquisitionSortReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.CancelOrderReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.GoodPlaceReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.OrderNoReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.OrderPlaceReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.OrderStatusReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.SendOrderReq;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user/order")
public class UcOrderController {

    private static final Logger logger = LoggerFactory.getLogger(UcOrderController.class);

    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private PackageService packageService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private ImRecordService imRecordService;

    /**
     * 下单
     * 初始化全部订单状态
     * @param req
     * @return
     */
    @RequestMapping(value="/place/order",method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo placeOrder(@RequestBody OrderPlaceReq req){

        logger.info("客户端下单 "+req.toString());

        if (StringUtils.isBlank(req.getUserId())
                ||req.getGoods().size()==0
                ||req.getOrderType()==null)
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        if (req.getPlaceType()!=null&&req.getPlaceType().equals(CommonConstants.PLACE_ORDER_FROM_SELF)){

            OrderPlaceReqVo reqVo = new OrderPlaceReqVo();
            BeanUtils.copyProperties(req,reqVo);

            if (reqVo.getGoods()!=null) {

                List<GoodPlaceReqVo> goodPlaceReqVoList = new ArrayList<>();

                for (GoodPlaceReq goodPlaceReq:req.getGoods()){
                    GoodPlaceReqVo goodPlaceReqVo = new GoodPlaceReqVo();
                    BeanUtils.copyProperties(goodPlaceReq,goodPlaceReqVo);
                    goodPlaceReqVoList.add(goodPlaceReqVo);
                }

                reqVo.setGoods(goodPlaceReqVoList);
            }

            String orderNo = orderService.placeOrder(reqVo);
            if (orderNo!=null){
                logger.info("客户端下单成功 "+orderNo);
                return JsonResVo.buildSuccess(orderNo);
            } else {
                logger.info("客户端下单失败");
                return JsonResVo.buildErrorResult(ErrorEnum.ERROR_BIZ_FAIL.getErrorCode(),"下单失败");
            }
        } else {
            return JsonResVo.buildFail(ErrorEnum.SERVICE_NOT_SUPPORT);
        }
    }


    /**
     * 支付
     * @param req
     * @return
     */
    @RequestMapping(value="/pay/order",method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo payOrder(HttpServletRequest request,@RequestBody OrderNoReq req){

        logger.info("客户端订单支付 "+req.toString());

        Map<String, Object> result = orderService.payOrder(request,req.getOrderNo(),req.getOpenid());
        if (result!=null){
            logger.info("客户端订单支付成功 "+req.getOrderNo());
            logger.info("微信回调支付成功地址"+WxConfig.getNotify_url());
            return JsonResVo.buildSuccess(result);
        } else {
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_BIZ_FAIL.getErrorCode(),"客户端发起支付失败");
        }
    }


    /**
     * 查询订单服务方式
     * @return
     */
    @RequestMapping(value="/query/orderServiceType",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryOrderServiceType(@RequestParam List<String> packageId){
//        if (StringUtils.isBlank(req.getAcquisitionId())){
//            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
//        }

        logger.info("客户端查询订单服务方式参数 "+packageId);

//        List<Integer> result = packageService.getOrderServiceType(null,packageId);
        List<Integer> result = packageService.getOrderServiceTypeNew(packageId);
        if (result!=null){
            return JsonResVo.buildSuccess(result);
        } else {
            return JsonResVo.buildFail(ErrorEnum.ERROR_BIZ_FAIL);
        }
    }

    /**
     * 查询订单采集点
     * @return
     */
    @RequestMapping(value="/query/orderAcquisition",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryOrderAcquisition(AcquisitionSortReq req){
//        if (StringUtils.isBlank(req.getAcquisitionId())){
//            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
//        }

        logger.info("客户端查询订单采集点参数 "+req.toString());

//        List<Integer> result = packageService.getOrderServiceType(null,packageId);
        List<AcquisitionBaseVo> result = packageService.getOrderAcquisition(req.getPackageId(),req.getType(),req.getLatitude(),req.getLongitude(),req.getQueryParam());
        if (result!=null){
            return JsonResVo.buildSuccess(result);
        } else {
            return JsonResVo.buildFail(ErrorEnum.ERROR_BIZ_FAIL);
        }
    }


    /**
     * 根据状态查订单
     * @param req
     * @return
     */
    @RequestMapping(value="/query/orderByStatus",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryOrderByStatus(OrderStatusReq req){

        logger.info("客户端查询订单列表 "+req.toString());

        if (StringUtils.isBlank(req.getUserId())){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        List<AppletOrder> orders = orderService.getUserOrderByStatus(req.getUserId(), req.getOrderStatus(), req.getParam(), req.getPageNo(), req.getPageSize());

        Integer orderSize = orders.size();

        if (!req.getOrderStatus().equals(OrderConstants.ORDER_STATUS_COLLECTED)) {
            List<OrderStatusVo> orderVos = new ArrayList<>();
            for (AppletOrder order : orders) {
                OrderStatusVo orderVo = new OrderStatusVo();
                BeanUtils.copyProperties(order, orderVo);
                orderVo.setGoodBaseVos(goodService.getBaseVoByOrderNo(order.getOrderNo()));
                logger.info("订单结果"+orderVo);
                orderVos.add(orderVo);
            }
            return JsonResVo.buildSuccess(orderVos);
        } else {
            List<OrderStatusForReportVo> orderVos = new ArrayList<>();
            for (AppletOrder order : orders) {
                OrderStatusForReportVo orderVo = new OrderStatusForReportVo();
                BeanUtils.copyProperties(order, orderVo);
                orderVo.setGoodBaseVos(goodService.getReportBaseVoByOrderNo(order.getOrderNo()));
                orderVos.add(orderVo);
            }
            return JsonResVo.buildSuccess(orderVos);
        }
    }

    /**
     * 取消订单
     * @param req
     * @return
     */
    @RequestMapping(value="/cancel/order",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo cancelOrder(CancelOrderReq req){

        logger.info("客户端取消订单: "+req.toString());

        if (StringUtils.isBlank(req.getOrderNo())){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        boolean i = orderService.userCancelOrder(req.getOrderNo(),req.getReasonId());
        if (i){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildFail(ErrorEnum.SERVICE_ERROR);
        }
    }

    /**
     * 核销订单
     * 只有已付款未退款审核通过
     * @param orderNo
     * @return
     */
    @RequestMapping(value="/writeOff/order",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo writeOffOrder(@RequestParam String orderNo){

        logger.info("客户端核销订单 "+orderNo);

        if (StringUtils.isBlank(orderNo)){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        String barcode = orderService.userWriteOffOrder(orderNo);
        if (StringUtils.isNotBlank(barcode)){
            return JsonResVo.buildSuccess(barcode);
        } else {
            return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(),"核销码不存在");
        }
    }

    /**
     * 删除订单
     * @param orderNo
     * @return
     */
    @RequestMapping(value="/delete/order",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo deleteOrder(@RequestParam String orderNo){

        logger.info("客户端删除订单: "+orderNo);

        if (StringUtils.isBlank(orderNo)){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        boolean i = orderService.deleteOrder(orderNo);
        if (i){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildFail(ErrorEnum.SERVICE_ERROR);
        }
    }

    /**
     * 申请退款
     * @param orderNo
     * @return
     */
    @RequestMapping(value="/refund/order",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo refundOrder(@RequestParam String orderNo){

        logger.info("客户端申请退款: "+orderNo);

        if (StringUtils.isBlank(orderNo)){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        boolean i = orderService.userApplyRefundOrder(orderNo);
        if (i){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildFail(ErrorEnum.SERVICE_ERROR);
        }
    }

    /**
     * 自采用户去采集
     * 展示自采样本盒的物流和套餐的采集流程
     * @param orderNo
     * @param packageId
     * @return
     */
    @RequestMapping(value="/collect/order",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo collectOrder(@RequestParam String orderNo,@RequestParam String packageId){

        logger.info("客户端自采用户去采集 订单号: "+orderNo+" 套餐号: "+packageId);

        if (StringUtils.isBlank(orderNo)){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        return JsonResVo.buildSuccess(orderService.selfCollectOrder(orderNo,packageId));
    }


    /**
     * 自采用户回寄
     * @param req
     * @return
     */
    @RequestMapping(value="/send/selfOrder",method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo selfSendOrder(@RequestBody SendOrderReq req){

        logger.info("客户端自采用户回寄订单: "+req.toString());

        List<String> selfOrderList = new ArrayList<>();
        selfOrderList.add(req.getOrderNo());

        boolean i =orderService.selfSendOrder(req.getExpressImages(),req.getUserId(),req.getExpressName(),req.getWaybillNo(),selfOrderList);

        if (i){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(),"送检失败，请确认收到采集盒后采集");
        }
    }

    /**
     * 查询订单详情
     * @param orderNo
     * @return
     */
    @RequestMapping(value="/query/orderDetail",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo QueryOrderByOrderNo(@RequestParam String orderNo){

        logger.info("客户端查询订单详情: "+orderNo);

        AppletOrder order = orderService.getOrderByOrderNo(orderNo);
        OrderDetailVo detailVo = new OrderDetailVo();
        BeanUtils.copyProperties(order,detailVo);
        if (order.getOrderApplyDate()!=null) {
            detailVo.setOrderApplyDate(DateUtils.convertToStandardDateNew(order.getOrderApplyDate()) + "之前");
        }
        if (order.getPayDate()!=null) {
            detailVo.setPayDate(DateUtils.convertToStandardDateNew(order.getPayDate()));
        }
        if (order.getWriteOffDate()!=null) {
            detailVo.setWriteOffDate(DateUtils.convertToStandardDateNew(order.getWriteOffDate()));
        }
        if (order.getVerifyDate()!=null){
            detailVo.setVerifyDate(DateUtils.convertToStandardDateNew(order.getVerifyDate()));
        } else {
            detailVo.setVerifyDate(DateUtils.convertToStandardDateNew(order.getUpdateDate()));
        }
        if (StringUtils.isNotBlank(order.getAuditorId())) {
            AppletAcquisitionStaff staff = staffService.getStaffByStaffId(order.getAuditorId());
            if (staff!=null) {
                detailVo.setAuditorStaff(staff.getStaffName());
            }
        }
        List<GoodBaseVo> goods = goodService.getBaseVoByOrderNo(orderNo);
        detailVo.setGoods(goods);
        return JsonResVo.buildSuccess(detailVo);
    }


    /**
     * @Description:微信支付回调
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/wxNotify")
    @ResponseBody
    public void wxNotify(HttpServletRequest request,HttpServletResponse response) throws Exception{

        logger.info("客户端接收微信支付完成回调信息");

        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            sb.append(line);
        }
        br.close();
        //sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";
        logger.info("微信支付收到的报文: "+notityXml);

        Map map = PayUtils.doXMLParse(notityXml);

        String orderNo = (String) map.get("out_trade_no");
        logger.info("微信回调参数外部订单号"+orderNo);
        String transactionId = (String) map.get("transaction_id");
        logger.info("微信回调参数支付订单号"+transactionId);
        String returnCode = (String) map.get("return_code");
        if("SUCCESS".equals(returnCode)){
            //验证签名是否正确
            Map<String, String> validParams = PayUtils.paraFilter(map);  //回调验签时需要去除sign和空值参数
            String validStr = PayUtils.createLinkString(validParams);//把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            String sign = PayUtils.sign(validStr, WxConfig.getKey(), "utf-8").toUpperCase();//拼装生成服务器端验证的签名
            //根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对等
            if(sign.equals(map.get("sign"))){
                /**此处添加自己的业务逻辑代码start**/

                //todo 更新订单支付状态
                if (orderNo!=null) {
                    orderNo = orderNo.substring(0,orderNo.indexOf("_"));
                    logger.info("微信回调参数真实的订单号"+orderNo);
                    if (orderNo.substring(0,1).equals(CommonConstants.GenerateID_ORDER)){
                        orderService.wxUpdatePayStatusSuccessful(orderNo, transactionId);
                        //发送预约成功短信
                        orderService.sendSmsForOrder(orderNo);
                    } else if (orderNo.substring(0,2).equals(CommonConstants.GenerateID_IM)){
                        //IM费用支付成功后回调处理
                        imRecordService.notifyImPayStatus(orderNo, transactionId);
                    }
                }

                /**此处添加自己的业务逻辑代码end**/
                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        }else{
            if (orderNo!=null)
                orderService.wxUpdatePayStatusFail(orderNo,transactionId);
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
//        System.out.println(resXml);
//        System.out.println("微信支付回调数据结束");

        logger.info("微信支付回调数据结束"+resXml);

        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }

}
