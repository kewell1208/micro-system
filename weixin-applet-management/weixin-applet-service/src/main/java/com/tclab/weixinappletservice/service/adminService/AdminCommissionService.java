package com.tclab.weixinappletservice.service.adminService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletPackageCostMapper;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.CommissionListVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.CommissionPageVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.QueryCommissionListReqVo;
import com.tclab.weixinappletservice.pojo.AppletPackage;
import com.tclab.weixinappletservice.pojo.AppletPackageCost;
import com.tclab.weixinappletservice.pojo.AppletPackageCostExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminCommissionService {

    @Autowired
    private AppletPackageCostMapper costMapper;
    @Autowired
    private AdminPackageService adminPackageService;
    @Autowired
    private AdminAcquisitionService adminAcquisitionService;

    public List<AppletPackageCost> getPackageCostByPackageIdAndAcquisitionId(String packageId, String acquisitionId){
        if (StringUtils.isBlank(packageId)&& StringUtils.isBlank(acquisitionId)){
            return null;
        }
        AppletPackageCostExample costExample = new AppletPackageCostExample();
        AppletPackageCostExample.Criteria costExampleCriteria = costExample.createCriteria();
        costExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(packageId)){
            costExampleCriteria.andPackageIdEqualTo(packageId);
        }
        if (StringUtils.isNotBlank(acquisitionId)){
            costExampleCriteria.andAcquisitionIdEqualTo(acquisitionId);
        }
        return costMapper.selectByExample(costExample);
    }

    public CommissionPageVo getCommissionListVoByAcquisitionId(QueryCommissionListReqVo req){
        if (StringUtils.isBlank(req.getAcquisitionId())){
            return null;
        }

        AppletPackageCostExample costExample = new AppletPackageCostExample();
        AppletPackageCostExample.Criteria costExampleCriteria = costExample.createCriteria();
        costExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        costExampleCriteria.andAcquisitionIdEqualTo(req.getAcquisitionId());

        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        List<AppletPackageCost> packageCostList = costMapper.selectByExample(costExample);
        PageInfo<AppletPackageCost> packageCostPageInfo = new PageInfo<>(packageCostList);

        CommissionPageVo pageVo = new CommissionPageVo();
        pageVo.setCurrentPageNo(packageCostPageInfo.getPageNum());
        pageVo.setOrderNum(packageCostPageInfo.getTotal());
        pageVo.setPageNum(packageCostPageInfo.getPages());

        List<CommissionListVo> commissionListVoList = new ArrayList<>();
        for (AppletPackageCost packageCost:packageCostPageInfo.getList()) {
            CommissionListVo commissionListVo = new CommissionListVo();
            commissionListVo.setCostOrganizationCommission(packageCost.getCostOrganizationCommission());
            commissionListVo.setCostStaffCommission(packageCost.getCostStaffCommission());
            commissionListVo.setPackageId(packageCost.getPackageId());

            if (StringUtils.isNotBlank(packageCost.getPackageId())){
                AppletPackage appletPackage = adminPackageService.getPackageById(packageCost.getPackageId());
                if (appletPackage!=null){
                    commissionListVo.setPackageName(appletPackage.getPackageName());
                    commissionListVo.setPackagePrice(appletPackage.getPackageCurrentPrice());
                }
            }

            commissionListVoList.add(commissionListVo);
        }
        pageVo.setCommissionListVoList(commissionListVoList);
        return pageVo;
    }

    @Transactional
    public boolean editCommission(String packageId, String acquisitionId,Float costStaffCommission,Float costOrganizationCommission){

        if (StringUtils.isBlank(packageId)|| StringUtils.isBlank(acquisitionId)){
            throw new RuntimeException("编辑提成失败,参数不能为空");
        }

        AppletPackageCostExample costExample = new AppletPackageCostExample();
        AppletPackageCostExample.Criteria costExampleCriteria = costExample.createCriteria();
        costExampleCriteria.andPackageIdEqualTo(packageId);
        costExampleCriteria.andAcquisitionIdEqualTo(acquisitionId);

        AppletPackageCost cost = new AppletPackageCost();
        cost.setUpdateDate(new Date());
        if (costStaffCommission!=null)
        cost.setCostStaffCommission(costStaffCommission);
        if (costOrganizationCommission!=null)
        cost.setCostOrganizationCommission(costOrganizationCommission);

        int  i = costMapper.updateByExampleSelective(cost,costExample);
        if (i==0){
            throw new RuntimeException("编辑提成失败 packageId: "+packageId+" acquisitionId: "+acquisitionId+" costStaffCommission: "+costStaffCommission+" costOrganizationCommission: "+costOrganizationCommission);
        }

        adminAcquisitionService.updateCommissionFlag(acquisitionId);

        return true;
    }
}
