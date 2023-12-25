package com.tclab.weixinappletservice.service.clientService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.*;
import com.tclab.weixinappletservice.dao.*;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.*;
import com.tclab.weixinappletservice.pojo.*;
import com.tclab.weixinappletcommon.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class LogisticsService {

    private static final Logger logger = LoggerFactory.getLogger(LogisticsService.class);

    @Autowired
    private AcquisitionService acquisitionService;
    @Autowired
    private ClerkService clerkService;
    @Autowired
    private AppletOrderMapper orderMapper;
    @Autowired
    private AppletGoodMapper goodMapper;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private AppletLogisticsMapper logisticsMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private StaffService staffService;

    @Value("${image.resource.location}")
    private String imageResourcelocation;

    @Transactional
    public int sendOrderToTc(List<String> expressImages,Integer logisticsType,String acquisitionId,String userId,String expressName,String waybillNo,List<String> orderNos,String staffId){
        //同创物流
        int i = 0;
        if (logisticsType.equals(LogisticsConstants.LOGISTICS_TYPE_TC)){

            AppletClerk clerk;

            //创建物流单
            AppletLogistics tc = new AppletLogistics();
            String tcNo = this.generateLogisticsId(CommonConstants.GenerateID_LOGISTICS_TC);
            tc.setCreateDate(new Date());
            tc.setUpdateDate(new Date());
            tc.setLogisticsType(LogisticsConstants.LOGISTICS_TYPE_TC);
            tc.setLogisticsApplyDate(new Date());
            tc.setDelFlag(CommonConstants.INIT);
            tc.setLogisticsId(tcNo);
            tc.setOrderNum(orderNos.size());
            tc.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
            AppletAcquisition acquisition = acquisitionService.getAcquisitionByAcquisitionId(acquisitionId);
            if (acquisition==null){
                logger.info("采集点不存在"+acquisitionId);
                throw new RuntimeException("采集点不存在");
            } else {
                tc.setSourceId(acquisitionId);
                tc.setSourceName(acquisition.getAcquisitionName());
                clerk = clerkService.getClerkByClerkId(acquisition.getClerkId());
                if (clerk!=null){
                    tc.setClerkId(acquisition.getClerkId());
                    tc.setClerkName(clerk.getClerkName());
                    tc.setClerkPhone(clerk.getClerkPhone());
                } else {
                    logger.info("业务员不存在"+acquisition.getClerkId());
                    throw new RuntimeException("业务员不存在");
                }
            }

            AppletAcquisitionStaff staff;
            if (StringUtils.isNotBlank(staffId)) {
                staff = staffService.getStaffByStaffIdOrPhone(staffId, null);
                if (staff != null) {
                    tc.setOperatorId(staff.getStaffId());
                    tc.setOperatorName(staff.getStaffName());
                } else {
                    logger.info("员工不存在"+staffId);
                    throw new RuntimeException("员工不存在");
                }
            } else {
                logger.info("员工ID不存在");
                throw new RuntimeException("员工ID不存在");
            }

            //修改订单物流状态
            for (String orderNo:orderNos) {
                AppletOrderExample orderExample = new AppletOrderExample();
                AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
                orderExampleCriteria.andOrderNoEqualTo(orderNo);
                orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_UNSEND);

                List<Integer> serviceType = new ArrayList<>();
                serviceType.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
                serviceType.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
                orderExampleCriteria.andServiceTypeIn(serviceType);
                orderExampleCriteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COLLECTED);

                AppletOrder order = new AppletOrder();
                order.setUpdateDate(new Date());
                order.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
                order.setLogisticsType(LogisticsConstants.LOGISTICS_TYPE_TC);
                order.setLogisticsId(tcNo);
                i = orderMapper.updateByExampleSelective(order,orderExample);
                if (i==0){
                    logger.info("同创物流更新订单失败 订单号"+orderNo);
                    throw new RuntimeException("同创物流更新订单失败");
                }
                i = changeGoodStatus(orderNo,GoodConstants.GOOD_STATUS_COLLECTED);
                if (i==0){
                    logger.info("同创物流更新商品失败 订单号"+orderNo);
                    throw new RuntimeException("同创物流更新商品失败");
                }
            }


            Map<String,String> map = new HashMap<>();
            map.put("code",tcNo);
            map.put("address",acquisition.getAcquisitionName());
            map.put("phone",staff.getStaffPhone());

            boolean check = SMSUtils.sendSms(clerk.getClerkPhone(),map,SMSUtils.templateCodeTcLogistics);
            if (!check){
                logger.info("通知业务人员短信失败 物流工单号"+tcNo);
                throw new RuntimeException("通知业务人员短信失败: "+tcNo);
            }

            int a =  logisticsMapper.insertSelective(tc);
            if (a==0){
                logger.info("新增同创物流工单失败");
                throw new RuntimeException("新增同创物流工单失败");
            }
            return a;

        } else if (logisticsType.equals(LogisticsConstants.LOGISTICS_TYPE_THIRD_ACQUISITION)){
            //采集点发送三方物流
            AppletLogistics td = new AppletLogistics();
//            String tdNo = NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_LOGISTICS_THIRD);

            String tdNo = generateLogisticsId(CommonConstants.GenerateID_LOGISTICS_THIRD);

            td.setCreateDate(new Date());
            td.setLogisticsType(LogisticsConstants.LOGISTICS_TYPE_THIRD_ACQUISITION);
            td.setDelFlag(CommonConstants.INIT);
            td.setExpressName(expressName);
            td.setOrderNum(orderNos.size());
            td.setUpdateDate(new Date());

            if (StringUtils.isNotBlank(staffId)) {
                AppletAcquisitionStaff staff = staffService.getStaffByStaffIdOrPhone(staffId, null);
                if (staff != null) {
                    td.setOperatorId(staff.getStaffId());
                    td.setOperatorName(staff.getStaffName());
                }
            }

            AppletAcquisition acquisition = acquisitionService.getAcquisitionByAcquisitionId(acquisitionId);
            if (acquisition!=null) {
                td.setSourceId(acquisitionId);
                td.setSourceName(acquisition.getAcquisitionName());
            }
            td.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);
            td.setLogisticsType(logisticsType);
            td.setLogisticsId(tdNo);
            td.setWaybillNo(waybillNo);

            td.setLogisticsApplyDate(new Date());

            //插入图片地址
            StringBuffer stringBuffer = new StringBuffer();
            for (String image:expressImages) {
                stringBuffer.append(image);
                stringBuffer.append(";");
            }
            String tempStr = stringBuffer.toString();
            if (StringUtils.isNotBlank(tempStr)) {
                tempStr = tempStr.substring(0, tempStr.length() - 1);
                td.setExpressImage(tempStr);
            }

            //修改订单物流信息
            for (String orderNo:orderNos) {
                AppletOrderExample orderExample = new AppletOrderExample();
                AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
                orderExampleCriteria.andOrderNoEqualTo(orderNo);
                orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_UNSEND);

                List<Integer> serviceType = new ArrayList<>();
                serviceType.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
                serviceType.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
                orderExampleCriteria.andServiceTypeIn(serviceType);
                orderExampleCriteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COLLECTED);

                AppletOrder order = new AppletOrder();
                order.setUpdateDate(new Date());
                order.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);
                order.setLogisticsType(LogisticsConstants.LOGISTICS_TYPE_THIRD_ACQUISITION);
                order.setLogisticsId(tdNo);
                i = changeGoodStatus(orderNo,GoodConstants.GOOD_STATUS_COLLECTED);
                if (i==0){
                    logger.info("第三方物流更新商品状态失败 订单号"+orderNo);
                    throw new RuntimeException("第三方物流更新商品状态失败 订单号"+orderNo);
                }
                i = orderMapper.updateByExampleSelective(order,orderExample);
                if (i==0){
                    logger.info("第三方物流更新订单状态失败 订单号"+orderNo);
                    throw new RuntimeException("第三方物流更新订单状态失败 订单号"+orderNo);
                }
            }

            //messageService.createMessageByAcquisition(acquisitionId,"已发送第三方物流 - "+expressName,"物流单号: "+tdNo+" 运单号: "+waybillNo+" 请确认物流信息,及时同工作人员联系");

            i = logisticsMapper.insertSelective(td);
            if (i==0){
                logger.info("第三方物流新增工单失败 第三方物流单号"+tdNo);
                throw new RuntimeException("第三方物流新增工单失败 第三方物流单号"+tdNo);
            }
            return i;

            //自采用户物流
        } else if (logisticsType.equals(LogisticsConstants.LOGISTICS_TYPE_THIRD_SELF)){

            AppletLogistics td = new AppletLogistics();
            String sfTdNo = generateLogisticsId(CommonConstants.GenerateID_LOGISTICS_THIRD);
            td.setCreateDate(new Date());
            td.setDelFlag(CommonConstants.INIT);
            td.setExpressName(expressName);
            td.setOrderNum(orderNos.size());
            td.setUpdateDate(new Date());
            td.setLogisticsApplyDate(new Date());
            td.setSourceId(userId);
            AppletUser user = userService.getUserById(userId);
            if (user!=null){
                td.setSourceName(user.getUserName());
            }
            td.setLogisticsType(LogisticsConstants.LOGISTICS_TYPE_THIRD_SELF);
            td.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);
            td.setLogisticsType(logisticsType);
            td.setLogisticsId(sfTdNo);
            td.setWaybillNo(waybillNo);

            //插入图片地址
            StringBuffer stringBuffer = new StringBuffer();
            for (String image:expressImages) {
                stringBuffer.append(image);
                stringBuffer.append(";");
            }
            String tempStr = stringBuffer.toString();
            if (StringUtils.isNotBlank(tempStr)) {
                tempStr = tempStr.substring(0, tempStr.length() - 1);
                td.setExpressImage(tempStr);
            }

            //修改订单物流信息
            for (String orderNo:orderNos) {
                AppletOrderExample orderExample = new AppletOrderExample();
                AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
                orderExampleCriteria.andOrderNoEqualTo(orderNo);
                orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
                AppletOrder order = new AppletOrder();
                order.setUpdateDate(new Date());
                order.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);
                order.setLogisticsType(LogisticsConstants.LOGISTICS_TYPE_THIRD_SELF);
                order.setOrderStatus(OrderConstants.ORDER_STATUS_COLLECTED);
                order.setLogisticsId(sfTdNo);
                i = changeGoodStatus(orderNo,GoodConstants.GOOD_STATUS_COLLECTED);
                if (i==0){
                    logger.info("自采物流更新商品状态失败 订单号"+orderNo);
                    throw new RuntimeException("第三方物流更新商品状态失败 订单号"+orderNo);
                }
                i = orderMapper.updateByExampleSelective(order,orderExample);
                if (i==0){
                    logger.info("自采物流更新订单状态失败 订单号"+orderNo);
                    throw new RuntimeException("自采物流更新订单状态失败 订单号"+orderNo);

                }
            }

            //messageService.createMessageByUser(userId,"已发送第三方物流 - "+expressName,"物流单号: "+sfTdNo+" 运单号: "+waybillNo+" 请确认物流信息,及时同工作人员联系");
            logger.info(orderNos.get(0)+"订单已发送消息");

            i = logisticsMapper.insertSelective(td);
            if (i == 0){
                logger.info("自采物流新增工单失败 第三方物流单号"+sfTdNo);
                throw new RuntimeException("自采物流新增工单失败 第三方物流单号"+sfTdNo);
            }
            return i;
        } else {
            return 0;
        }
    }

    @Transactional
    public int changeGoodStatus(String orderNo,Integer goodStatus){
        AppletGoodExample goodExample = new AppletGoodExample();
        AppletGoodExample.Criteria criteria = goodExample.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        AppletGood good = new AppletGood();
        good.setGoodStatus(goodStatus);
        good.setUpdateDate(new Date());
        return goodMapper.updateByExampleSelective(good,goodExample);
    }

    public List<GeneralLogisticsVo> getSendingLogisticsOrderNew(String acquisitionId){
        List<GeneralLogisticsVo> logisticsVos = new ArrayList<>();

        //获取同创物流订单
        AppletLogisticsExample tcExample = new AppletLogisticsExample();
        AppletLogisticsExample.Criteria tcExampleCriteria = tcExample.createCriteria();
        tcExampleCriteria.andLogisticsTypeEqualTo(LogisticsConstants.LOGISTICS_TYPE_TC);
        if (StringUtils.isNotBlank(acquisitionId))
            tcExampleCriteria.andSourceIdEqualTo(acquisitionId);
        tcExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
        tcExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);

        //分页比较复杂暂时不做
        List<AppletLogistics> tcList = logisticsMapper.selectByExample(tcExample);
        for (AppletLogistics tc:tcList) {
            GeneralLogisticsVo vo = new GeneralLogisticsVo();
            vo.setApplyDate(DateUtils.convertToSlashAndMinDate(tc.getLogisticsApplyDate()));
            vo.setClerkId(tc.getClerkId());
            vo.setClerkName(tc.getClerkName());
            vo.setClerkPhone(tc.getClerkPhone());
            vo.setLogisticsId(tc.getLogisticsId());
            vo.setLogisticsName("同创物流");
            vo.setLogisticsType(LogisticsConstants.LOGISTICS_TYPE_TC);
            vo.setOrderNum(tc.getOrderNum());
            logisticsVos.add(vo);
        }

        logisticsVos.sort(new Comparator<GeneralLogisticsVo>() {
            @Override
            public int compare(GeneralLogisticsVo o1, GeneralLogisticsVo o2) {
                return o1.getApplyDate().compareTo(o2.getApplyDate());
            }
        });

        return logisticsVos;
    }

    public AppletLogistics getLogisticsById(String logisticsId){
        AppletLogisticsExample tcExample = new AppletLogisticsExample();
        AppletLogisticsExample.Criteria tcExampleCriteria = tcExample.createCriteria();
        tcExampleCriteria.andLogisticsIdEqualTo(logisticsId);
        tcExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        List<AppletLogistics> logisticsList = logisticsMapper.selectByExample(tcExample);
        if (logisticsList.size()!=0){
            return logisticsList.get(0);
        } else {
            return null;
        }
    }

    @Transactional
    public boolean cancelSendLogisticsNew(Integer logisticsType,String logisticsId){
        //必须是同创物流单
        boolean check  = false;

        //取消送检只针对同创物流
        if (logisticsType !=null && logisticsType == LogisticsConstants.LOGISTICS_TYPE_TC){
            //修改订单状态为未发送
            AppletOrderExample orderExample = new AppletOrderExample();
            AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
            orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
            orderExampleCriteria.andLogisticsIdEqualTo(logisticsId);
            AppletOrder order = new AppletOrder();
            order.setLogisticsId("");
            order.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_UNSEND);
            int i = orderMapper.updateByExampleSelective(order,orderExample);
            if (i>0){
                check = true;
            } else {
                check = false;
            }
            //修改物流单状态为已取消
            AppletLogisticsExample tcExample = new AppletLogisticsExample();
            AppletLogisticsExample.Criteria tcExampleCriteria = tcExample.createCriteria();
            tcExampleCriteria.andLogisticsIdEqualTo(logisticsId);
            tcExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
            AppletLogistics tc = new AppletLogistics();
            tc.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_CANCEL);
            i = logisticsMapper.updateByExampleSelective(tc,tcExample);
            if (i>0){
                check = true;
            } else {
                check = false;
            }
            return check;
        } else
            return false;
    }

    @Transactional
    public boolean addSendLogisticsNew(Integer logisticsType,String logisticsId,List<String> orederNos){
        //必须是同创物流单
        boolean check  = false;
        //增加送检只针对同创物流
        if (logisticsType !=null && logisticsType == LogisticsConstants.LOGISTICS_TYPE_TC){
            //订单物流状态改为预送检
            AppletOrderExample orderExample = new AppletOrderExample();
            AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
            orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
            orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_UNSEND);
            orderExampleCriteria.andOrderNoIn(orederNos);
            AppletOrder order = new AppletOrder();
            order.setLogisticsId(logisticsId);
            order.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
            int i = orderMapper.updateByExampleSelective(order,orderExample);
            if (i>0){
                check = true;
            } else {
                return false;
            }
            //获取物流单下所有的所有未送检的订单数量
            orderExample.clear();
            orderExampleCriteria = orderExample.createCriteria();
            orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
            orderExampleCriteria.andLogisticsIdEqualTo(logisticsId);
            orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
            Long orderNum = orderMapper.countByExample(orderExample);
            //修改物流单订单数增加
            AppletLogisticsExample tcExample = new AppletLogisticsExample();
            AppletLogisticsExample.Criteria tcExampleCriteria = tcExample.createCriteria();
            tcExampleCriteria.andLogisticsIdEqualTo(logisticsId);
            tcExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
            AppletLogistics tc = new AppletLogistics();
            tc.setOrderNum(orderNum.intValue());
            i = logisticsMapper.updateByExampleSelective(tc,tcExample);
            if (i<0){
                check = false;
            }
            return check;
        } else
            return false;
    }

    @Transactional
    public boolean deleteLogisticsOrderNew(Integer logisticsType,String logisticsId,List<String> orederNos){
        //必须是同创物流单
        boolean check  = false;
        //增加送检只针对同创物流
        if (logisticsType !=null && logisticsType == LogisticsConstants.LOGISTICS_TYPE_TC){
            //订单物流状态改为预送检
            AppletOrderExample orderExample = new AppletOrderExample();
            AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
            orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
            orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
            orderExampleCriteria.andOrderNoIn(orederNos);
            AppletOrder order = new AppletOrder();
            order.setLogisticsId(logisticsId);
            order.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_UNSEND);
            int i = orderMapper.updateByExampleSelective(order,orderExample);
            if (i>0){
                check = true;
            } else {
                logger.info("取消订单物流失败 物流单号"+logisticsId);
                throw new RuntimeException("取消订单物流失败");
            }
            //获取物流单下所有的所有未送检的订单数量
            orderExample.clear();
            orderExampleCriteria = orderExample.createCriteria();
            orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
            orderExampleCriteria.andLogisticsIdEqualTo(logisticsId);
            orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
            Long orderNum = orderMapper.countByExample(orderExample);
            //修改物流单订单数增加
            AppletLogisticsExample tcExample = new AppletLogisticsExample();
            AppletLogisticsExample.Criteria tcExampleCriteria = tcExample.createCriteria();
            tcExampleCriteria.andLogisticsIdEqualTo(logisticsId);
            tcExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
            AppletLogistics tc = new AppletLogistics();
            tc.setOrderNum(orderNum.intValue());
            i = logisticsMapper.updateByExampleSelective(tc,tcExample);
            if (i<0){
                logger.info("取消物流失败 物流单号"+logisticsId);
                throw new RuntimeException("取消物流失败");
            }
            return check;
        } else
            //其他第三方物流还未支持
            return false;
    }

    @Transactional
    public boolean finishLogisticsNew(Integer logisticsType,String logisticsId){

        //完成送检只针对同创物流
        if (logisticsType !=null && logisticsType == LogisticsConstants.LOGISTICS_TYPE_TC){
            //修改订单状态为已接收
            AppletOrderExample orderExample = new AppletOrderExample();
            AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
            orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
            orderExampleCriteria.andLogisticsIdEqualTo(logisticsId);
            orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
            AppletOrder order = new AppletOrder();
            order.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);
            order.setUpdateDate(new Date());
            int i = orderMapper.updateByExampleSelective(order,orderExample);
            if (i>0){
            } else {
                logger.info("更新订单物流状态失败 物流单号"+logisticsId);
                throw new RuntimeException("更新订单物流状态失败 物流单号"+logisticsId);
            }
            //修改商品状态为检验中
            orderExample.clear();
            orderExampleCriteria.andLogisticsIdEqualTo(logisticsId);
            orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_RECEIVED);
            orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
            List<AppletOrder> orders = orderMapper.selectByExample(orderExample);
            List<String> orderNos = new ArrayList<>();
            for (AppletOrder appletOrder:orders) {
                orderNos.add(appletOrder.getOrderNo());
            }
            AppletGoodExample goodExample = new AppletGoodExample();
            AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
            goodExampleCriteria.andOrderNoIn(orderNos);
            goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
            goodExampleCriteria.andGoodStatusEqualTo(GoodConstants.GOOD_STATUS_COLLECTED);
            AppletGood good = new AppletGood();
            good.setGoodStatus(GoodConstants.GOOD_STATUS_TESTING);
            i = goodMapper.updateByExampleSelective(good,goodExample);
            if (i>0){
            } else {
                logger.info("更新商品物流状态失败 物流单号"+logisticsId);
                throw new RuntimeException("更新商品物流状态失败 物流单号"+logisticsId);
            }
            //修改物流单状态为已接收
            AppletLogisticsExample tcExample = new AppletLogisticsExample();
            AppletLogisticsExample.Criteria tcExampleCriteria = tcExample.createCriteria();
            tcExampleCriteria.andLogisticsIdEqualTo(logisticsId);
            tcExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
            AppletLogistics tc = new AppletLogistics();
            tc.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);
            tc.setLogisticsPickDate(new Date());
            i = logisticsMapper.updateByExampleSelective(tc,tcExample);
            if (i<0){
                logger.info("更新物流单物流状态失败 物流单号"+logisticsId);
                throw new RuntimeException("更新物流单物流状态失败 物流单号"+logisticsId);
            }
            logger.info("更新物流单物流状态成功 物流单号"+logisticsId);
            return true;
        } else
            return false;
    }

    public LogisticsOrderVo getTcLogisticsOrderNew(String logisticsId){
        //查询物流单信息
        AppletLogisticsExample tcExample = new AppletLogisticsExample();
        AppletLogisticsExample.Criteria tcExampleCriteria = tcExample.createCriteria();
        tcExampleCriteria.andLogisticsIdEqualTo(logisticsId);
        tcExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        List<AppletLogistics> list = logisticsMapper.selectByExample(tcExample);
        LogisticsOrderVo logisticsOrderVo = new LogisticsOrderVo();
        if (list.size()!=0){
            AppletLogistics tc = list.get(0);
            BeanUtils.copyProperties(tc,logisticsOrderVo);
            logisticsOrderVo.setTcLogisticsApplyDate(DateUtils.convertToSlashAndMinDate(tc.getLogisticsApplyDate()));
        }
        //查询订单信息
        AppletOrderExample orderExample = new AppletOrderExample();
        AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
        orderExampleCriteria.andLogisticsIdEqualTo(logisticsId);
        orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
        orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        List<AppletOrder> orders = orderMapper.selectByExample(orderExample);
        for (AppletOrder order:orders) {
            OrderBaseVo orderBaseVo = new OrderBaseVo();
            BeanUtils.copyProperties(order,orderBaseVo);
            orderBaseVo.setOrderCompleteApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderCompleteApplyDate()));
            logisticsOrderVo.getOrderBaseVos().add(orderBaseVo);
        }
        return logisticsOrderVo;
    }

    public AppletLogistics getTcByIdNew(String tcId){
        AppletLogisticsExample tcExample = new AppletLogisticsExample();
        AppletLogisticsExample.Criteria tcExampleCriteria = tcExample.createCriteria();
        tcExampleCriteria.andLogisticsTypeEqualTo(LogisticsConstants.LOGISTICS_TYPE_TC);
        if (StringUtils.isNotBlank(tcId))
            tcExampleCriteria.andLogisticsIdEqualTo(tcId);
        tcExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        List<AppletLogistics> result = logisticsMapper.selectByExample(tcExample);
        if (result.size()!=0){
            return result.get(0);
        }
        return null;
    }

    public AppletLogistics getThirdByIdNew(String thirdId){
        AppletLogisticsExample thirdExample = new AppletLogisticsExample();
        AppletLogisticsExample.Criteria thirdExampleCriteria = thirdExample.createCriteria();
        thirdExampleCriteria.andLogisticsTypeEqualTo(LogisticsConstants.LOGISTICS_TYPE_TC);
        thirdExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(thirdId))
            thirdExampleCriteria.andLogisticsIdEqualTo(thirdId);
        List<AppletLogistics> result = logisticsMapper.selectByExample(thirdExample);
        if (result.size()!=0){
            return result.get(0);
        }
        return null;
    }

    public String generateLogisticsId(String type){
        String logisticsId;
        String logisticsIdIndexStr;
        String key = RedisConstants.GENERATEID+":"+RedisConstants.LOGISTICSID_INDEX;
        Integer logisticsIdIndex = Integer.parseInt(redisUtils.get(key));
        if (logisticsIdIndex!=null){
            logisticsIdIndex++;
            boolean a = redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.LOGISTICSID_INDEX,logisticsIdIndex.toString());
            logisticsIdIndexStr = String.format("%06d", logisticsIdIndex);
        } else {
            logisticsIdIndexStr = String.format("%06d", 1);
        }
        String day = redisUtils.get(RedisConstants.DAY);
        if (day==null){
            day = DateUtils.formatDayString(new Date());
        }
        logisticsId = type+day+logisticsIdIndexStr;
        return logisticsId;
    }

    public List<GeneralLogisticsVo> getAcquisitionSendedLogistics(String acquisitionId,String queryParam,Integer pageSize){

        List<GeneralLogisticsVo> logisticsVos = new ArrayList<>();

        //获取同创物流订单
        AppletLogisticsExample tcExample = new AppletLogisticsExample();
        AppletLogisticsExample.Criteria tcExampleCriteria = tcExample.createCriteria();
        List<Integer> logisticsType = new ArrayList<>();
        logisticsType.add(LogisticsConstants.LOGISTICS_TYPE_TC);
        logisticsType.add(LogisticsConstants.LOGISTICS_TYPE_THIRD_ACQUISITION);
        tcExampleCriteria.andLogisticsTypeIn(logisticsType);
        if (StringUtils.isNotBlank(acquisitionId))
            tcExampleCriteria.andSourceIdEqualTo(acquisitionId);
        tcExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);
        tcExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(queryParam))
            tcExampleCriteria.andLogisticsIdEqualTo(queryParam);
        PageHelper.startPage(1,pageSize);
        List<AppletLogistics> logisticsList = logisticsMapper.selectByExample(tcExample);
        PageInfo<AppletLogistics> appletLogisticsPageInfo = new PageInfo<>(logisticsList);
        for (AppletLogistics logistics:appletLogisticsPageInfo.getList()) {
            GeneralLogisticsVo generalLogisticsVo = new GeneralLogisticsVo();
            generalLogisticsVo.setWaybillNo(logistics.getWaybillNo());
            generalLogisticsVo.setOrderNum(logistics.getOrderNum());
            generalLogisticsVo.setLogisticsType(logistics.getLogisticsType());
            generalLogisticsVo.setLogisticsName(logistics.getExpressName());
            generalLogisticsVo.setLogisticsId(logistics.getLogisticsId());
            generalLogisticsVo.setClerkPhone(logistics.getClerkPhone());
            generalLogisticsVo.setClerkName(logistics.getClerkName());
            generalLogisticsVo.setClerkId(logistics.getClerkId());
            generalLogisticsVo.setApplyDate(DateUtils.convertToSlashAndMinDate(logistics.getLogisticsApplyDate()));
            logisticsVos.add(generalLogisticsVo);
        }

        return logisticsVos;
    }

    public List<LogisticsMessageVo> getMessageByAcquisitionIdAndStatus(String acquisitionId, Integer pageNo, Integer pageSize){
        AppletLogisticsExample example = new AppletLogisticsExample();
        AppletLogisticsExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(acquisitionId)) {
            criteria.andSourceIdEqualTo(acquisitionId);
        }
        criteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_RECEIVED);
        criteria.andLogisticsArrivedDateIsNotNull();
        example.setOrderByClause("logistics_arrived_date DESC");

        PageHelper.startPage(pageNo,pageSize);
        List<AppletLogistics> logisticsList = logisticsMapper.selectByExample(example);
        PageInfo<AppletLogistics> PageInfo = new PageInfo<>(logisticsList);
        List<AppletLogistics> messageLogistics = PageInfo.getList();

        logger.info("sql长度"+messageLogistics.size());

        List<LogisticsMessageVo> messageVoList = new ArrayList<>();
        for (AppletLogistics logistics:messageLogistics) {
            LogisticsMessageVo vo = new LogisticsMessageVo();
            BeanUtils.copyProperties(logistics,vo);
            vo.setLogisticsArrivedDate(DateUtils.convertToSlashAndMinDate(logistics.getLogisticsArrivedDate()));
            messageVoList.add(vo);
        }

        messageVoList.sort(new Comparator<LogisticsMessageVo>() {
            @Override
            public int compare(LogisticsMessageVo o1, LogisticsMessageVo o2) {
                return -(o1.getLogisticsArrivedDate().compareTo(o2.getLogisticsArrivedDate()));
            }
        });

        logger.info("查询采集点消息结果: "+messageVoList.toString());

        return messageVoList;
    }
}
