package com.tclab.weixinappletservice.service.adminService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.LogisticsConstants;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletservice.dao.AppletOrderMapper;
import com.tclab.weixinappletservice.model.query.OrderQueryParam;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.*;
import com.tclab.weixinappletservice.pojo.AppletLogistics;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletOrderExample;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class AdminOrderService {

    private static final Logger logger = LoggerFactory.getLogger(AdminOrderService.class);

    @Autowired
    private AppletOrderMapper orderMapper;
    @Autowired
    private AdminGoodService adminGoodService;
    @Autowired
    private AdminParticipantService adminParticipantService;
    @Autowired
    private AdminServiceInfoService adminServiceInfoService;
    @Autowired
    private AdminExceptionService adminExceptionService;
    @Autowired
    private AdminThirdSelfLogisticsService selfLogisticsService;
    @Autowired
    private AdminLogisticsService adminLogisticsService;

    /**
     * 根据订单号获取订单(无论是否删除)
     * @param orderNo
     * @return
     */
    public AppletOrder getOrderByOrderNo(String orderNo){

        if (StringUtils.isBlank(orderNo)){
            return null;
        }

        AppletOrderExample orderExample = new AppletOrderExample();
        AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
        orderExampleCriteria.andOrderNoEqualTo(orderNo);
        List<AppletOrder> orderList = orderMapper.selectByExample(orderExample);
        if (orderList.size()!=0){
            return orderList.get(0);
        }
        return null;
    }

    /**
     * 查询订单列表
     * @param param
     * @return
     */
    public List<AppletOrder> getOrderByParam(OrderQueryParam param){

        if (param==null){
            return null;
        }

        AppletOrderExample example = new AppletOrderExample();
        AppletOrderExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotBlank(param.getOrderNo()))
            criteria.andOrderNoEqualTo(param.getOrderNo());

        if (StringUtils.isNotBlank(param.getParticipantPhone()))
            criteria.andParticipantPhoneLike("%"+param.getParticipantPhone()+"%");

        if (param.getServiceTypes()!=null&&param.getServiceTypes().size()!=0)
            criteria.andServiceTypeIn(param.getServiceTypes());

        if (param.getLogisticsStatus()!=null&&param.getLogisticsStatus().size()!=0)
            criteria.andLogisticsStatusIn(param.getLogisticsStatus());

        if (param.getOrderExceptionReason()!=null)
            criteria.andOrderExceptionReasonEqualTo(param.getOrderExceptionReason());

        if (param.getOrderExceptionStatus()!=null)
            criteria.andOrderExceptionStatusEqualTo(param.getOrderExceptionStatus());

        if (StringUtils.isNotBlank(param.getAcquisitionId()))
            criteria.andAcquisitionIdEqualTo(param.getAcquisitionId());

        if (StringUtils.isNotBlank(param.getAcquisitionName()))
            criteria.andAcquisitionNameLike("%"+param.getAcquisitionName()+"%");

        if (param.getOrderStatus()!=null)
            criteria.andOrderStatusEqualTo(param.getOrderStatus());

        if (StringUtils.isNotBlank(param.getStaffId()))
            criteria.andStaffIdEqualTo(param.getStaffId());

        if (StringUtils.isNotBlank(param.getStaffName()))
            criteria.andStaffNameLike("%"+param.getStaffName()+"%");

        if (StringUtils.isNotBlank(param.getLogisticsId()))
            criteria.andLogisticsIdEqualTo(param.getLogisticsId());

        List<AppletOrder> orders = orderMapper.selectByExample(example);
        return orders;
    }

    /**
     * 查询订单模块订单列表
     * @param param
     * @return
     */
    public OrderPageVo queryOrderByParam(OrderQueryParam param){

        if (param==null){
            return null;
        }

        AppletOrderExample example = new AppletOrderExample();
        AppletOrderExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotBlank(param.getOrderNo()))
        criteria.andOrderNoEqualTo(param.getOrderNo());

        if (StringUtils.isNotBlank(param.getParticipantPhone()))
        criteria.andParticipantPhoneLike("%"+param.getParticipantPhone()+"%");

        if (param.getServiceTypes()!=null&&param.getServiceTypes().size()!=0)
        criteria.andServiceTypeIn(param.getServiceTypes());

        if (param.getLogisticsStatus()!=null&&param.getLogisticsStatus().size()!=0)
        criteria.andLogisticsStatusIn(param.getLogisticsStatus());

        if (param.getOrderExceptionReason()!=null)
        criteria.andOrderExceptionReasonEqualTo(param.getOrderExceptionReason());

        if (param.getOrderExceptionStatus()!=null)
        criteria.andOrderExceptionStatusEqualTo(param.getOrderExceptionStatus());

        if (StringUtils.isNotBlank(param.getAcquisitionId()))
        criteria.andAcquisitionIdEqualTo(param.getAcquisitionId());

        if (StringUtils.isNotBlank(param.getAcquisitionName()))
        criteria.andAcquisitionNameLike("%"+param.getAcquisitionName()+"%");

        if (param.getOrderStatus()!=null) {
            criteria.andOrderStatusEqualTo(param.getOrderStatus());
        }

        //查询订单不能是未付款的订单
//        criteria.andOrderStatusNotEqualTo(OrderConstants.ORDER_STATUS_UNPAY);

        criteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);

        if (StringUtils.isNotBlank(param.getStaffId()))
        criteria.andStaffIdEqualTo(param.getStaffId());

        if (StringUtils.isNotBlank(param.getStaffName()))
        criteria.andStaffNameLike("%"+param.getStaffName()+"%");

        if (param.getRefundStatus()!=null){
            criteria.andRefundStatusEqualTo(param.getRefundStatus());
        }

        example.setOrderByClause("order_no DESC");

        PageHelper.startPage(param.getPageNo(),param.getPageSize());
        List<AppletOrder> orders = orderMapper.selectByExample(example);
        PageInfo<AppletOrder> orderPageInfo = new PageInfo<>(orders);

        if (orderPageInfo!=null&&orderPageInfo.getList()!=null&&orderPageInfo.getList().size()!=0) {
            OrderPageVo orderListVo = new OrderPageVo();
            orderListVo.setOrderNum(orderPageInfo.getTotal());
            orderListVo.setPageNum(orderPageInfo.getPages());
            orderListVo.setCurrentPageNo(orderPageInfo.getPageNum());

            List<OrderListVo> orderDetailVos = new ArrayList<>();
            for (AppletOrder order:orderPageInfo.getList()) {
                OrderListVo listVo = new OrderListVo();
                BeanUtils.copyProperties(order,listVo);
                listVo.setCreateDate(DateUtils.convertToStandardDate(order.getCreateDate()));
                listVo.setGoodNum(adminGoodService.getGoodCountForOrder(order.getOrderNo()));
                listVo.setComStats(getComStats(order.getOrderExceptionStatus(),order.getServiceType()));
                orderDetailVos.add(listVo);
            }

            orderDetailVos.sort(new Comparator<OrderListVo>() {
                @Override
                public int compare(OrderListVo o1, OrderListVo o2) {
                    return -o1.getCreateDate().compareTo(o2.getCreateDate());
                }
            });

            orderListVo.setOrderDetailVoList(orderDetailVos);

            logger.info("后台查询订单结果: "+orderListVo.toString());

            return orderListVo;
        }
        return null;
    }

    /**
     * 前台显示状态
     * @param orderExceptionStatus
     * @param serviceType
     * @return
     */
    private Integer getComStats(Integer orderExceptionStatus,Integer serviceType){
        if (orderExceptionStatus.equals(OrderConstants.ORDER_EXCEPTION_ERROR)){
            return 1;
        }
        if (serviceType.equals(OrderConstants.ORDER_SERVICE_TYPE_SELF)){
            return 2;
        }
        return 0;
    }

    /**
     * 后台整单退款
     * @param orderNo
     * @param refundAmount
     * @return
     */
    @Transactional
    public boolean backRefundOrder(String orderNo,BigDecimal refundAmount,Integer refundReason){

        if (StringUtils.isBlank(orderNo)){
            throw new IllegalArgumentException("后台订单退款订单号不能为空");
        }

            //支付状态为已支付状态
            //退款状态为正在退款
            //退款原因
            AppletOrderExample orderExample = new AppletOrderExample();
            AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
            orderExampleCriteria.andOrderNoEqualTo(orderNo);
            orderExampleCriteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
            orderExampleCriteria.andRefundStatusEqualTo(OrderConstants.ORDER_REFUND_STATUS_PAYING);
            orderExampleCriteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);

            //设置订单退款状态为已退款,订单状态为已完成
            AppletOrder updateOrder = new AppletOrder();
            updateOrder.setUpdateDate(new Date());
            updateOrder.setRefundStatus(OrderConstants.ORDER_REFUND_STATUS_PAYED);

            //设置退款金额
            //判断退款金额是否可以满足条件
            //退款单可以是已删除的订单
            AppletOrder order = getOrderByOrderNo(orderNo);
            BigDecimal lastRefundAmount;
            BigDecimal allRefundAmount;
            if (order.getRefundAmount() != null) {
                allRefundAmount = order.getRefundAmount().add(refundAmount);
                lastRefundAmount = order.getPayAmount().subtract(order.getRefundAmount()).subtract(refundAmount);
            } else {
                allRefundAmount = refundAmount;
                lastRefundAmount = order.getPayAmount().subtract(refundAmount);
            }
            int check = lastRefundAmount.compareTo(BigDecimal.ZERO);
            if (check < 0) {
                throw new RuntimeException("订单退款金额超过实际可退款的金额: orderNo: " + orderNo);
            } else {
                updateOrder.setRefundAmount(allRefundAmount);
            }

            //设置订单状态已退款
            //设置订单退款状态已退款
            updateOrder.setOrderStatus(OrderConstants.ORDER_STATUS_COMPLETED);
            updateOrder.setRefundStatus(OrderConstants.ORDER_REFUND_STATUS_PAYED);
            if (refundReason!=null)
                updateOrder.setRefundReason(refundReason);
            int updateNum =orderMapper.updateByExampleSelective(updateOrder, orderExample);
            if (updateNum==0){
                throw new RuntimeException("后台整单退款更新订单状态失败");
            }

            //更新商品退款状态
            adminGoodService.updateRefundGoodByOrderNo(orderNo);

            return true;
    }

    /**
     * 获取订单详情
     * @param orderNo
     * @return
     */
    public OrderDetailVo getOrderDetailVo(String orderNo){

        if (StringUtils.isBlank(orderNo))
            throw new IllegalArgumentException("后台查询订单详情订单号为空");

        AppletOrder order;
        AppletOrderExample orderExample = new AppletOrderExample();
        AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
        orderExampleCriteria.andOrderNoEqualTo(orderNo);
        List<AppletOrder> orderList = orderMapper.selectByExample(orderExample);
        if (orderList.size()!=0){
            order = orderList.get(0);
        } else {
            return null;
        }

        //基本订单信息
        OrderDetailVo orderDetailVo = new OrderDetailVo();
        BeanUtils.copyProperties(order,orderDetailVo);
        orderDetailVo.setOrderApplyDate(DateUtils.convertToStandardDate(order.getOrderApplyDate()));
        orderDetailVo.setCreateDate(DateUtils.convertToStandardDate(order.getCreateDate()));
        orderDetailVo.setPayDate(DateUtils.convertToStandardDate(order.getPayDate()));
        orderDetailVo.setOrderApplyDate(DateUtils.convertToStandardDate(order.getOrderApplyDate()));
        orderDetailVo.setWriteOffDate(DateUtils.convertToStandardDate(order.getWriteOffDate()));
        orderDetailVo.setOrderCompleteApplyDate(DateUtils.convertToStandardDate(order.getOrderCompleteApplyDate()));

        //商品列表信息
        List<GoodBaseVo> goodBaseVoList = adminGoodService.getGoodsByOrderNo(orderNo);
        orderDetailVo.setGoodBaseVos(goodBaseVoList);

        logger.info("参检人ID: "+order.getParticipantId());

        //参检人信息
        if (StringUtils.isNotBlank(order.getParticipantId())) {
            ParticipantBaseVo participantBaseVo = adminParticipantService.getParticipantByParticipantId(order.getParticipantId());
            orderDetailVo.setParticipantVo(participantBaseVo);
        } else {
            orderDetailVo.setParticipantVo(null);
        }

        //服务地址信息
        if (StringUtils.isNotBlank(order.getServiceInfoId())) {
            orderDetailVo.setServiceInfoVo(adminServiceInfoService.getServiceInfoByServiceInfoId(order.getServiceInfoId()));
        } else {
            orderDetailVo.setServiceInfoVo(null);
        }

        //异常信息
        orderDetailVo.setExceptionBaseVo(adminExceptionService.getExceptionByOrderNo(orderNo));

        //样本盒信息
        orderDetailVo.setThirdSelfLogisticsBaseVo(selfLogisticsService.getThirdSelfLogisticsByOrderNo(orderNo));

        //用户回寄信息
        AppletLogistics logistics = adminLogisticsService.getLogisticsById(order.getLogisticsId());
        if (logistics!=null){
            ThirdLogisticsBaseVo logisticsBaseVo = new ThirdLogisticsBaseVo();
            BeanUtils.copyProperties(logistics,logisticsBaseVo);
            logisticsBaseVo.setCreateDate(DateUtils.convertToStandardDate(logistics.getCreateDate()));
            logisticsBaseVo.setLogisticsArrivedDate(DateUtils.convertToStandardDate(logistics.getLogisticsArrivedDate()));
            logisticsBaseVo.setLogisticsApplyDate(DateUtils.convertToStandardDate(logistics.getLogisticsApplyDate()));
            orderDetailVo.setThirdLogisticsBaseVo(logisticsBaseVo);
        }


        return orderDetailVo;
    }

    /**
     * 获取订单详情
     * @param orderNo
     * @return
     */
    public OrderDetailVo getSelfOrderDetailVo(String orderNo){

        if (StringUtils.isBlank(orderNo))
            throw new IllegalArgumentException("后台查询订单详情订单号为空");

        AppletOrder order;
        AppletOrderExample orderExample = new AppletOrderExample();
        AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
        orderExampleCriteria.andOrderNoEqualTo(orderNo);
        List<AppletOrder> orderList = orderMapper.selectByExample(orderExample);
        if (orderList.size()!=0){
            order = orderList.get(0);
        } else {
            return null;
        }

        //基本订单信息
        OrderDetailVo orderDetailVo = new OrderDetailVo();
        BeanUtils.copyProperties(order,orderDetailVo);
        orderDetailVo.setCreateDate(DateUtils.convertToStandardDate(order.getCreateDate()));
        orderDetailVo.setPayDate(DateUtils.convertToStandardDate(order.getPayDate()));
        orderDetailVo.setOrderApplyDate(DateUtils.convertToStandardDate(order.getOrderApplyDate()));
        orderDetailVo.setWriteOffDate(DateUtils.convertToStandardDate(order.getWriteOffDate()));
        orderDetailVo.setOrderCompleteApplyDate(DateUtils.convertToStandardDate(order.getOrderCompleteApplyDate()));

        //商品列表信息
        List<GoodBaseVo> goodBaseVoList = adminGoodService.getGoodsByOrderNo(orderNo);
        orderDetailVo.setGoodBaseVos(goodBaseVoList);

        //参检人信息
        if (StringUtils.isNotBlank(order.getParticipantId())) {
            ParticipantBaseVo participantBaseVo = adminParticipantService.getParticipantByParticipantId(order.getParticipantId());
            orderDetailVo.setParticipantVo(participantBaseVo);
        } else {
            orderDetailVo.setParticipantVo(null);
        }

        //服务地址信息
        if (StringUtils.isNotBlank(order.getServiceInfoId())) {
            orderDetailVo.setServiceInfoVo(adminServiceInfoService.getServiceInfoByServiceInfoId(order.getServiceInfoId()));
        } else {
            orderDetailVo.setParticipantVo(null);
        }

        //样本盒信息
        orderDetailVo.setThirdSelfLogisticsBaseVo(selfLogisticsService.getThirdSelfLogisticsByOrderNo(orderNo));

        //用户回寄信息
        AppletLogistics logistics = adminLogisticsService.getLogisticsById(order.getLogisticsId());
        if (logistics!=null){
            ThirdLogisticsBaseVo logisticsBaseVo = new ThirdLogisticsBaseVo();
            BeanUtils.copyProperties(logistics,logisticsBaseVo);
            logisticsBaseVo.setExpressName(logistics.getExpressName());
            logisticsBaseVo.setLogisticsArrivedDate(DateUtils.convertToSlashAndMinDate(logistics.getLogisticsArrivedDate()));
            logisticsBaseVo.setLogisticsApplyDate(DateUtils.convertToSlashAndMinDate(logistics.getLogisticsApplyDate()));
            logisticsBaseVo.setCreateDate(DateUtils.convertToSlashAndMinDate(logistics.getCreateDate()));
            orderDetailVo.setThirdLogisticsBaseVo(logisticsBaseVo);
        }


        return orderDetailVo;
    }

    /**
     * 根据物流单号获取全部订单
     * @param logisticsId
     * @return
     */
    public List<AppletOrder> getOrderListByLogisticsId(String logisticsId){

        if (StringUtils.isBlank(logisticsId)){
            return null;
        }

        AppletOrderExample orderExample = new AppletOrderExample();
        AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
        if (StringUtils.isNotBlank(logisticsId))
        orderExampleCriteria.andLogisticsIdEqualTo(logisticsId);
        List<AppletOrder> orderList = orderMapper.selectByExample(orderExample);
        return orderList;
    }

    /**
     * 接收物流单后更新订单物流状态和商品状态
     * @param logisticsId
     * @return
     */
    @Transactional
    public boolean updateOrderLogisticsReceiveStatus(String logisticsId){
        if (StringUtils.isBlank(logisticsId)) {
            throw new RuntimeException("更新的物流单号不存在");
        }

        //更新订单状态
        AppletOrderExample orderExample = new AppletOrderExample();
        AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
        orderExampleCriteria.andLogisticsIdEqualTo(logisticsId);
        orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);

        AppletOrder updateOrder = new AppletOrder();
        updateOrder.setUpdateDate(new Date());
        updateOrder.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_RECEIVED);
        updateOrder.setOrderStatus(OrderConstants.ORDER_STATUS_COLLECTED);
        int i = orderMapper.updateByExampleSelective(updateOrder,orderExample);
        if (i==0){
            throw new RuntimeException("更新订单已接受物流状态失败: logisticsId: "+logisticsId);
        }

        //更新商品状态
        List<AppletOrder> orderList = getOrderListByLogisticsId(logisticsId);
        //更新商品状态
        for (AppletOrder order:orderList) {
            adminGoodService.updateGoodReceiveStatus(order.getOrderNo());
        }
        return true;
    }


    public LogisticsPageVo querySelfOrderList(String orderNo,String userPhone,Integer logisticsStatus,Integer pageNo,Integer pageSize){

        AppletOrderExample example = new AppletOrderExample();
        AppletOrderExample.Criteria criteria = example.createCriteria();

        criteria.andServiceTypeEqualTo(OrderConstants.ORDER_SERVICE_TYPE_SELF);

        if (StringUtils.isNotBlank(orderNo))
            criteria.andOrderNoEqualTo(orderNo);

        if (StringUtils.isNotBlank(userPhone))
            criteria.andUserPhoneEqualTo(userPhone);

        if (logisticsStatus!=null)
            criteria.andLogisticsStatusEqualTo(logisticsStatus);

        example.setOrderByClause("create_date DESC");

        PageHelper.startPage(pageNo,pageSize);
        List<AppletOrder> orders = orderMapper.selectByExample(example);
        PageInfo<AppletOrder> orderPageInfo = new PageInfo<>(orders);

        LogisticsPageVo logisticsPageVo=new LogisticsPageVo();

        logisticsPageVo.setCurrentPageNo(orderPageInfo.getPageNum());
        logisticsPageVo.setOrderNum(orderPageInfo.getTotal());
        logisticsPageVo.setPageNum(orderPageInfo.getPages());

        //转换pojo对象listVo
        if (orderPageInfo.getList()!=null){
            List<LogisticsListVo> logisticsListVoList = new ArrayList<>();
            for (AppletOrder order:orderPageInfo.getList()) {
                LogisticsListVo logisticsListVo = new LogisticsListVo();
                logisticsListVo.setOrderNo(order.getOrderNo());
                logisticsListVo.setParticipantName(order.getParticipantName());
                logisticsListVo.setParticipantPhone(order.getParticipantPhone());
                logisticsListVo.setPayAmount(order.getPayAmount());
                logisticsListVo.setLogisticsStatus(order.getLogisticsStatus());
                logisticsListVo.setOrderDate(DateUtils.convertToStandardDate(order.getCreateDate()));
                logisticsListVoList.add(logisticsListVo);
            }
            logisticsPageVo.setLogisticsListVoList(logisticsListVoList);
            logisticsListVoList.sort(new Comparator<LogisticsListVo>() {
                @Override
                public int compare(LogisticsListVo o1, LogisticsListVo o2) {
                    return -o1.getOrderDate().compareTo(o2.getOrderDate());
                }
            });
        }

        return logisticsPageVo;

    }
}
