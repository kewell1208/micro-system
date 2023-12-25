package com.tclab.weixinappletservice.service.adminService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.LogisticsConstants;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import com.tclab.weixinappletservice.dao.AppletLogisticsThirdSelfMapper;
import com.tclab.weixinappletservice.dao.AppletOrderMapper;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.SelfBarcodeVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.ThirdSelfLogisticsBaseVo;
import com.tclab.weixinappletservice.pojo.AppletLogisticsThirdSelf;
import com.tclab.weixinappletservice.pojo.AppletLogisticsThirdSelfExample;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletOrderExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AdminThirdSelfLogisticsService {

    @Autowired
    private AppletLogisticsThirdSelfMapper thirdSelfMapper;
    @Autowired
    private AdminOrderService adminOrderService;
    @Autowired
    private AppletOrderMapper orderMapper;
    @Autowired
    private AdminGoodService adminGoodService;

    public ThirdSelfLogisticsBaseVo getThirdSelfLogisticsByOrderNo(String orderNo){

        if (StringUtils.isBlank(orderNo)){
            return null;
        }

        AppletLogisticsThirdSelfExample thirdSelfExample = new AppletLogisticsThirdSelfExample();
        AppletLogisticsThirdSelfExample.Criteria thirdSelfExampleCriteria = thirdSelfExample.createCriteria();
        thirdSelfExampleCriteria.andOrderNoEqualTo(orderNo);
        List<AppletLogisticsThirdSelf> thirdSelfList = thirdSelfMapper.selectByExample(thirdSelfExample);
        if (thirdSelfList.size()!=0){

            AppletLogisticsThirdSelf result = thirdSelfList.get(0);
            ThirdSelfLogisticsBaseVo selfLogisticsBaseVo = new ThirdSelfLogisticsBaseVo();
            BeanUtils.copyProperties(result,selfLogisticsBaseVo);
            selfLogisticsBaseVo.setLogisticsArrivedDate(DateUtils.convertToStandardDate(result.getLogisticsArrivedDate()));
            selfLogisticsBaseVo.setCreateDate(DateUtils.convertToSlashAndMinDate(result.getCreateDate()));

            return selfLogisticsBaseVo;
        } else {
            return null;
        }
    }

    @Transactional
    public String sendUserThirdLogistics(String orderNo, String logisticsGood, String logisticsRemark, Integer logisticsOrderNum, String waybillNo, String expressName, List<SelfBarcodeVo> barcodeVoList, String collectorStaffId){

        AppletOrder order = adminOrderService.getOrderByOrderNo(orderNo);
        if (order==null){
            throw new RuntimeException("订单不存在");
        }

        if (order.getLogisticsStatus()!=null&&order.getLogisticsStatus().equals(LogisticsConstants.LOGISTICS_STATUS_PRESEND)){
            throw  new RuntimeException("自采订单已发送样本盒");
        }

        //绑定条码
        adminGoodService.bindSelfBarcode(orderNo,barcodeVoList,collectorStaffId);

        //更新物流单信息
        AppletLogisticsThirdSelf thirdSelf = new AppletLogisticsThirdSelf();
        thirdSelf.setCreateDate(new Date());
        thirdSelf.setDelFlag(CommonConstants.INIT);
        thirdSelf.setExpressName(expressName);
        if (StringUtils.isNotBlank(logisticsGood))
        thirdSelf.setLogisticsGood(logisticsGood);
        if (logisticsOrderNum!=null) {
            thirdSelf.setLogisticsOrderNum(logisticsOrderNum);
        } else {
            thirdSelf.setLogisticsOrderNum(1);
        }
        thirdSelf.setLogisticsRemark(logisticsRemark);
        thirdSelf.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
        thirdSelf.setOrderNo(orderNo);
        thirdSelf.setUpdateDate(new Date());
        thirdSelf.setWaybillNo(waybillNo);
        String logisticsId = NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_LOGISTICS_THIRD);
        thirdSelf.setThirdLogisticsId(logisticsId);
        int i =thirdSelfMapper.insertSelective(thirdSelf);
        if (i==0){
            throw new RuntimeException("自采订单发送物流信息插入失败");
        }

        //更新订单物流信息
        AppletOrderExample orderExample = new AppletOrderExample();
        AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
        orderExampleCriteria.andOrderNoEqualTo(orderNo);
        orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        orderExampleCriteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
        orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_UNSEND);
        orderExampleCriteria.andServiceTypeEqualTo(OrderConstants.ORDER_SERVICE_TYPE_SELF);

        AppletOrder updateOrder = new AppletOrder();
        updateOrder.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
        updateOrder.setUpdateDate(new Date());

        i = orderMapper.updateByExampleSelective(updateOrder,orderExample);
        if (i!=0){
            return logisticsId;
        } else {
            throw new RuntimeException("自采订单发送订单更新失败");
        }
    }
}
