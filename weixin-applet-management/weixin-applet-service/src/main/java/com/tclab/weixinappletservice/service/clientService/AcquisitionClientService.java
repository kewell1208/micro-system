package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletservice.dao.AppletOrderMapper;
import com.tclab.weixinappletservice.model.query.AcquisitionNameOrPhoneQueryParam;
import com.tclab.weixinappletservice.model.query.QueryNoParam;
import com.tclab.weixinappletservice.model.result.GoodInfoByNoResult;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.*;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletPackageSource;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.IDCardUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class AcquisitionClientService {

    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private AppletOrderMapper orderMapper;
    @Autowired
    private SourceService sourceService;

    /**
     * 查询今日采集点的订单情况以及最近5条支付完成的采集点订单
     * @param acquisitionId
     * @return
     */
    public TodayOrderVo queryTodayOrderCountAndRecentOrderInfo(String acquisitionId){

        TodayOrderVo todayOrderVo = new TodayOrderVo();

        Map map = orderService.getTodayOrderCountByAcquisitionId(acquisitionId);
        todayOrderVo.setCountForUnCollect((Long)map.get("countForUnCollect"));
        todayOrderVo.setCountForCollected((Long)map.get("countForCollected"));
        todayOrderVo.setCountForException((Long)map.get("countForException"));
        List<RecentOrderInfoVo> recentOrderInfoVos = orderService.getRecentOrderForAcquisitionByAcquisitionId(acquisitionId);
        todayOrderVo.setTodayOrderInfos(recentOrderInfoVos);
        return todayOrderVo;
    }

    /**
     * 查询采集点的患者信息列表以及最近到采集点的日期
     * @param acquisitionId
     * @param queryParam
     * @return
     */
    public List<ParticipantRecentVo> getParticipantHistory(String acquisitionId, String queryParam){
        AcquisitionNameOrPhoneQueryParam phoneQueryParam = new AcquisitionNameOrPhoneQueryParam();
        phoneQueryParam.setAcquisitionId(acquisitionId);
        phoneQueryParam.setQueryParam(queryParam);
        return orderService.getParticipantHistory(phoneQueryParam);
    }

    /**
     * 获取采集点患者的详细订单列表数据
     * @param acquisitionId
     * @param participantId
     * @return
     */
    public List<ParticipantOrderAndPackageVo> getParticipantOrderAndPackage(String acquisitionId, String participantId){
        AcquisitionNameOrPhoneQueryParam phoneQueryParam = new AcquisitionNameOrPhoneQueryParam();
        phoneQueryParam.setAcquisitionId(acquisitionId);
        phoneQueryParam.setQueryParam(participantId);
        List<ParticipantHistoryVo> historyVos = orderService.getParticipantOrder(phoneQueryParam);
        List<ParticipantOrderAndPackageVo> orderAndPackageVos = new ArrayList<>();
        for (ParticipantHistoryVo historyVo:historyVos) {
            ParticipantOrderAndPackageVo orderAndPackageVo = new ParticipantOrderAndPackageVo();
            BeanUtils.copyProperties(historyVo,orderAndPackageVo);
            List<GoodInfoByNoResult> goods = goodService.getGoodPackageByNo(historyVo.getOrderNo(),null);
            orderAndPackageVo.setPackages(goods);
            orderAndPackageVos.add(orderAndPackageVo);
        }
        return orderAndPackageVos;
    }

    /**
     * 查询订单后按照日期时间分组排序
     * @param req
     * @return
     */
    public List<?> getOrderByStatus(AcquisitionQueryOrderByStatusVo req){

        List<AppletOrder> orders = orderService.acquisitionGetOrderByStatus(req.getAcquisitionId(),req.getOrderStatus(),req.getQueryParam(),req.getDayNum());

        if (req.getOrderStatus()!=null) {
            //未采集订单
            if (req.getOrderStatus().equals(OrderConstants.ORDER_STATUS_UNCOLLECT)){
                //异常订单
                if (req.getOrderExceptionStatus().equals(OrderConstants.ORDER_EXCEPTION_ERROR)){
                    List<OrderForDayAndTimeVo> exceptionVos = new ArrayList<>();
                    for (AppletOrder order:orders) {
                        OrderForDayAndTimeVo exceptionVo = new OrderForDayAndTimeVo();
                        exceptionVo.setOrderNo(order.getOrderNo());
                        exceptionVo.setPackageName(order.getGoodName());
                        exceptionVo.setUserName(order.getUserName());
                        exceptionVo.setOrderApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderApplyDate()));
                        exceptionVo.setAppointmentDate(DateUtils.dateToDay(order.getOrderApplyDate(),"/"));
                        exceptionVo.setAppointmentTime(DateUtils.dateToTime(order.getOrderApplyDate()));
                        exceptionVos.add(exceptionVo);
                        return exceptionVos;
                    }
                }else {
                    List<OrderForDayAndTimeVo> exceptionVos = new ArrayList<>();
                    for (AppletOrder order:orders) {
                        OrderForDayAndTimeVo exceptionVo = new OrderForDayAndTimeVo();
                        exceptionVo.setOrderNo(order.getOrderNo());
                        exceptionVo.setPackageName(order.getGoodName());
                        exceptionVo.setUserName(order.getUserName());
                        exceptionVo.setOrderApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderApplyDate()));
                        exceptionVo.setAppointmentDate(DateUtils.dateToDay(order.getOrderApplyDate(),"/"));
                        exceptionVo.setAppointmentTime(DateUtils.dateToTime(order.getOrderApplyDate()));
                        exceptionVos.add(exceptionVo);
                    }
                    List<OrderForGroupByDayVo> result = groupByOrderStatusForExceptionVos(exceptionVos);
                    return result;
                }
            }
            //已采集订单
            if (req.getOrderStatus().equals(OrderConstants.ORDER_STATUS_COLLECTED)){
                List<OrderForDayAndTimeVo> exceptionVos = new ArrayList<>();
                for (AppletOrder order:orders) {
                    OrderForDayAndTimeVo exceptionVo = new OrderForDayAndTimeVo();
                    exceptionVo.setOrderNo(order.getOrderNo());
                    exceptionVo.setPackageName(order.getGoodName());
                    exceptionVo.setUserName(order.getUserName());
                    exceptionVo.setOrderApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderApplyDate()));
                    exceptionVo.setAppointmentDate(DateUtils.dateToDay(order.getOrderApplyDate(),"/"));
                    exceptionVo.setAppointmentTime(DateUtils.dateToTime(order.getOrderApplyDate()));
                    exceptionVos.add(exceptionVo);
                }
                List<OrderForGroupByDayVo> result = groupByOrderStatusForExceptionVos(exceptionVos);
                return result;
            }

        }
        return null;
    }

    /**
     * 分组排序订单
     * @param vos
     * @return
     */
    private List<OrderForGroupByDayVo> groupByOrderStatusForExceptionVos(List<OrderForDayAndTimeVo> vos){
        //创建分类目录
        List<String> groupType = new ArrayList<>();
        //创建排序完成后的数据
        List<OrderForGroupByDayVo> otherVos = new ArrayList<>();

        for (OrderForDayAndTimeVo exceptionVo:vos) {
            boolean check = false;
            for (String type:groupType) {
                if (exceptionVo.getAppointmentDate()!=null) {
                    if (exceptionVo.getAppointmentDate().equals(type)) {
                        check = true;
                        break;
                    }
                }
            }

            if (check) {

            } else {
                OrderForGroupByDayVo otherVo = new OrderForGroupByDayVo();
                otherVo.setDate(exceptionVo.getAppointmentDate());
                otherVos.add(otherVo);
                groupType.add(exceptionVo.getAppointmentDate());
            }
        }

        for (OrderForDayAndTimeVo exceptionVo:vos) {
            for (OrderForGroupByDayVo otherVo:otherVos) {
                if (exceptionVo.getAppointmentDate().equals(otherVo.getDate())){
                    otherVo.getDateDetailListc().add(exceptionVo);
                }
            }
        }

        otherVos.sort(new Comparator<OrderForGroupByDayVo>() {
            //按日期排序
            @Override
            public int compare(OrderForGroupByDayVo o1, OrderForGroupByDayVo o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

        return otherVos;
    }


    /**
     * 查询订单以及订单下的商品套餐
     * @param orderNo
     * @return
     */
    public OrderForParticipantVo getOrderByOrderNo(String orderNo){

        QueryNoParam param = new QueryNoParam();
        param.setOrderNo(orderNo);
        OrderForParticipantVo orderVo = orderMapper.selectOrderForParticipantVo(param);

        if (orderVo==null){
            return null;
        }

        List<GoodInfoByNoResult> goods = goodService.getGoodPackageByNo(orderNo,null);

        for (GoodInfoByNoResult result:goods) {
            if (StringUtils.isNotBlank(result.getPackageSourceId())) {
                AppletPackageSource source = sourceService.getSourceById(result.getPackageSourceId());
                result.setPackageSourceName(source.getPackageSourceRemark());
            }
        }

        if (StringUtils.isNotBlank(orderVo.getIdCard())){
            orderVo.setIdCard(orderVo.getIdCard());
            orderVo.setAge(IDCardUtils.getAge(orderVo.getIdCard()));
            orderVo.setSex(IDCardUtils.getSex(orderVo.getIdCard()));
        }
        orderVo.setPackages(goods);
        return orderVo;
    }

}
