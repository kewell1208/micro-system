package com.tclab.weixinappletservice.service.adminService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.LogisticsConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletservice.dao.AppletLogisticsMapper;
import com.tclab.weixinappletservice.model.query.OrderQueryParam;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.*;
import com.tclab.weixinappletservice.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class AdminLogisticsService {

    @Autowired
    private AppletLogisticsMapper logisticsMapper;
    @Autowired
    private AdminOrderService adminOrderService;
    @Autowired
    private AdminGoodService adminGoodService;
    @Autowired
    private AdminAcquisitionService adminAcquisitionService;
    @Autowired
    private AdminStaffService adminStaffService;
    @Autowired
    private AdminMessageService adminMessageService;
    @Autowired
    private AdminClerkService adminClerkService;

    private static final Logger logger = LoggerFactory.getLogger(AdminLogisticsService.class);

    public LogisticsPageVo queryLogisticsPageVoByQueryReq(QueryLogisticsReqVo req){

        if (req==null){
            return null;
        }

        LogisticsPageVo logisticsPageVo=new LogisticsPageVo();

        AppletLogisticsExample logisticsExample = new AppletLogisticsExample();
        AppletLogisticsExample.Criteria logisticsExampleCriteria =logisticsExample.createCriteria();
        if (StringUtils.isNotBlank(req.getLogisticsId()))
            logisticsExampleCriteria.andLogisticsIdEqualTo(req.getLogisticsId());
        if (StringUtils.isNotBlank(req.getAcquisitionName()))
            logisticsExampleCriteria.andSourceNameLike("%"+req.getAcquisitionName()+"%");
        if (req.getLogisticsStatus()!=null)
            logisticsExampleCriteria.andLogisticsStatusEqualTo(req.getLogisticsStatus());
        if (req.getLogisticsType()!=null)
            logisticsExampleCriteria.andLogisticsTypeEqualTo(req.getLogisticsType());

        List<Integer> logisticsTypeList = new ArrayList<>();
        logisticsTypeList.add(LogisticsConstants.LOGISTICS_TYPE_TC);
        logisticsTypeList.add(LogisticsConstants.LOGISTICS_TYPE_THIRD_ACQUISITION);
        logisticsExampleCriteria.andLogisticsTypeIn(logisticsTypeList);

        logisticsExample.setOrderByClause("create_date DESC");

        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        List<AppletLogistics> logisticsList = logisticsMapper.selectByExample(logisticsExample);
        PageInfo<AppletLogistics> logisticsPageInfo = new PageInfo<>(logisticsList);

        logisticsPageVo.setCurrentPageNo(logisticsPageInfo.getPageNum());
        logisticsPageVo.setOrderNum(logisticsPageInfo.getTotal());
        logisticsPageVo.setPageNum(logisticsPageInfo.getPages());

        //转换pojo对象listVo
        if (logisticsPageInfo.getList()!=null){
            List<LogisticsListVo> logisticsListVoList = new ArrayList<>();
            for (AppletLogistics logistics:logisticsPageInfo.getList()) {
                LogisticsListVo logisticsListVo = new LogisticsListVo();
                logisticsListVo.setSourceId(logistics.getSourceId());
                logisticsListVo.setSourceName(logistics.getSourceName());
                logisticsListVo.setLogisticId(logistics.getLogisticsId());
                logisticsListVo.setLogisticsStatus(logistics.getLogisticsStatus());
                logisticsListVo.setCreateDate(DateUtils.convertToStandardDate(logistics.getCreateDate()));
                logisticsListVo.setExpressName(logistics.getExpressName());
                logisticsListVo.setWaybillNo(logistics.getWaybillNo());
                logisticsListVoList.add(logisticsListVo);
            }
            logisticsListVoList.sort(new Comparator<LogisticsListVo>() {
                @Override
                public int compare(LogisticsListVo o1, LogisticsListVo o2) {
                    return -o1.getCreateDate().compareTo(o2.getCreateDate());
                }
            });
            logisticsPageVo.setLogisticsListVoList(logisticsListVoList);
        }

        return logisticsPageVo;
    }

    public AppletLogistics getLogisticsById(String logisticsId){

        if (StringUtils.isBlank(logisticsId)){
            return null;
        }

        AppletLogisticsExample logisticsExample = new AppletLogisticsExample();
        AppletLogisticsExample.Criteria logisticsExampleCriteria =logisticsExample.createCriteria();
        if (StringUtils.isBlank(logisticsId))
            throw new IllegalArgumentException("根据物流ID查询物流参数为空");
        logisticsExampleCriteria.andLogisticsIdEqualTo(logisticsId);
        List<AppletLogistics> logisticsList = logisticsMapper.selectByExample(logisticsExample);
        if (logisticsList!=null&&logisticsList.size()!=0){
            return logisticsList.get(0);
        } else {
            return null;
        }
    }

    public LogisticsDetailVo queryLogisticsDetailById(String logisticsId, String acquisitionId){

        if (StringUtils.isBlank(logisticsId)){
            logger.info("物流单号为空");
            return null;
        }

        AppletLogistics logistics = getLogisticsById(logisticsId);
        if (logistics==null){
            logger.info("物流单 "+logisticsId+"对应的物流信息为空");
            return null;
        }

        LogisticsDetailVo logisticsDetailVo = new LogisticsDetailVo();
        BeanUtils.copyProperties(logistics,logisticsDetailVo);

        AppletAcquisitionStaff staff;
        if (StringUtils.isNotBlank(logistics.getOperatorId())){
            staff = adminStaffService.getStaffById(logistics.getOperatorId());
            if (staff!=null){
                logisticsDetailVo.setOperatorPhone(staff.getStaffPhone());
                logisticsDetailVo.setOperatorId(staff.getStaffId());
                logisticsDetailVo.setOperatorName(staff.getStaffName());
            }
        }

        logisticsDetailVo.setCreateDate(DateUtils.convertToStandardDate(logistics.getCreateDate()));
        logisticsDetailVo.setLogisticsApplyDate(DateUtils.convertToStandardDate(logistics.getLogisticsApplyDate()));
        logisticsDetailVo.setLogisticsArrivedDate(DateUtils.convertToStandardDate(logistics.getLogisticsArrivedDate()));
        logisticsDetailVo.setLogisticsPickDate(DateUtils.convertToStandardDate(logistics.getLogisticsPickDate()));

        AppletAcquisition appletAcquisition = adminAcquisitionService.getAcquisitionById(acquisitionId);
        if (appletAcquisition!=null){
            logisticsDetailVo.setAcquisitionAddress(appletAcquisition.getAcquisitionAddress());
            logisticsDetailVo.setAcquisitionId(appletAcquisition.getAcquisitionId());
            logisticsDetailVo.setAcquisitionName(appletAcquisition.getAcquisitionName());
        }

        OrderQueryParam orderQueryParam = new OrderQueryParam();
        orderQueryParam.setLogisticsId(logisticsId);
        List<AppletOrder> orderList = adminOrderService.getOrderByParam(orderQueryParam);
        if (orderList!=null) {
            List<OrderBaseVo> orderBaseVoList = new ArrayList<>();
            for (AppletOrder order : orderList) {
                OrderBaseVo orderBaseVo = new OrderBaseVo();
                orderBaseVo.setOrderNo(order.getOrderNo());
                orderBaseVo.setParticipantName(order.getParticipantName());
                orderBaseVo.setParticipantPhone(order.getParticipantPhone());
                orderBaseVo.setWriteOffDate(DateUtils.convertToStandardDate(order.getWriteOffDate()));
                orderBaseVo.setPackageNum(adminGoodService.getGoodCountForOrder(order.getOrderNo()));
                orderBaseVoList.add(orderBaseVo);
            }
            logisticsDetailVo.setOrderBaseVoList(orderBaseVoList);
        }
        return logisticsDetailVo;
    }

    @Transactional
    public boolean receiveThirdLogisticsBySelf(String orderNo){

        if (StringUtils.isBlank(orderNo)){
            throw new RuntimeException("接收自采用户发送的第三方物流失败: 订单号为空");
        }

        AppletOrder order = adminOrderService.getOrderByOrderNo(orderNo);
        if (order==null){
            throw new RuntimeException("接收自采用户物流单订单不存在: orderNo"+orderNo);
        }
        if (order.getLogisticsStatus()!=null&&!order.getLogisticsStatus().equals(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC)){
            throw new RuntimeException("接收自采用户物流单订单必须是已发送的物流单: orderNo"+orderNo);
        }
        String logisticsId = order.getLogisticsId();
        //该订单必须是自采送检而且必须是已发送的物流单
        AppletLogisticsExample thirdExample = new AppletLogisticsExample();
        AppletLogisticsExample.Criteria thirdExampleCriteria = thirdExample.createCriteria();
        thirdExampleCriteria.andLogisticsIdEqualTo(logisticsId);
        thirdExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        thirdExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);
        thirdExampleCriteria.andLogisticsTypeEqualTo(LogisticsConstants.LOGISTICS_TYPE_THIRD_SELF);

        AppletLogistics updateThird = new AppletLogistics();
        updateThird.setUpdateDate(new Date());
        updateThird.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_RECEIVED);
        updateThird.setLogisticsArrivedDate(new Date());
        int i = logisticsMapper.updateByExampleSelective(updateThird,thirdExample);
        if (i==0){
            throw new RuntimeException("接收自采用户发送第三方物流失败: orderNo: "+orderNo);
        }

        //更新订单和商品的物流状态
        adminOrderService.updateOrderLogisticsReceiveStatus(logisticsId);


        return true;
    }

    @Transactional
    public boolean receiveThirdLogistics(String logisticsId,String acquisitionId){

        if (StringUtils.isBlank(logisticsId)){
            throw new RuntimeException("接收第三方物流失败: 物流ID为空");
        }

        if (StringUtils.isBlank(acquisitionId)){
            List<AppletOrder> orderList = adminOrderService.getOrderListByLogisticsId(logisticsId);
            if (orderList!=null&&orderList.size()!=0){
                acquisitionId = orderList.get(0).getAcquisitionId();
            }
        }

        //修改物流单状态
        AppletLogisticsExample thirdExample = new AppletLogisticsExample();
        AppletLogisticsExample.Criteria thirdExampleCriteria = thirdExample.createCriteria();
        thirdExampleCriteria.andLogisticsIdEqualTo(logisticsId);
        thirdExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        thirdExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);
//        thirdExampleCriteria.andLogisticsTypeEqualTo(LogisticsConstants.LOGISTICS_TYPE_THIRD_ACQUISITION);

        AppletLogistics updateThird = new AppletLogistics();
        updateThird.setUpdateDate(new Date());
        updateThird.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_RECEIVED);
        updateThird.setLogisticsArrivedDate(new Date());

        int i = logisticsMapper.updateByExampleSelective(updateThird,thirdExample);
        if (i==0){
            throw new RuntimeException("接收采集点用户发送第三方物流失败: logisticsId: "+logisticsId);
        }

        //修改订单状态
        adminOrderService.updateOrderLogisticsReceiveStatus(logisticsId);

        adminMessageService.createMessageByBack(acquisitionId,"已接收第三方物流","物流单号: "+logisticsId+"， 请确认物流信息,及时同工作人员联系");

        return true;
    }

    @Transactional
    public boolean receiveTcLogistics(String logisticsId,String acquisitionId){

        if (StringUtils.isBlank(logisticsId)){
            throw new RuntimeException("接收同创物流失败: 物流ID为空");
        }

        if (StringUtils.isBlank(acquisitionId)){
            List<AppletOrder> orderList = adminOrderService.getOrderListByLogisticsId(logisticsId);
            if (orderList!=null&&orderList.size()!=0){
                acquisitionId = orderList.get(0).getAcquisitionId();
            }
        }

        //修改物流单已接收
        AppletLogisticsExample tcExample = new AppletLogisticsExample();
        AppletLogisticsExample.Criteria tcExampleCriteria = tcExample.createCriteria();
        //同创物流单是根据物流单号来接收物流
        tcExampleCriteria.andLogisticsIdEqualTo(logisticsId);
        tcExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);

        AppletLogistics updateTc = new AppletLogistics();
        updateTc.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_RECEIVED);
        updateTc.setUpdateDate(new Date());
        updateTc.setLogisticsArrivedDate(new Date());

        int i = logisticsMapper.updateByExampleSelective(updateTc,tcExample);
        if (i==0){
            throw new RuntimeException("接收同创物流失败: 物流ID: "+logisticsId);
        }

        //修改订单商品已接收
        boolean check = adminOrderService.updateOrderLogisticsReceiveStatus(logisticsId);
        if (!check){
            throw new RuntimeException("接收同创物流: 物流ID: "+logisticsId);
        }

//        messageService.createMessageByBack(acquisitionId,"已接收同创物流","物流单号: "+logisticsId+" ，请确认物流信息,及时同工作人员联系");

        return true;
    }

}
