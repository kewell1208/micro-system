package com.tclab.weixinappletservice.service.clientService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.AcquisitionConstants;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletservice.dao.AppletAcquisitionMapper;
import com.tclab.weixinappletservice.model.query.AcquisitionDistanceOrderParam;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.AcquisitionBaseVo;
import com.tclab.weixinappletservice.pojo.AppletAcquisition;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionExample;
import com.tclab.weixinappletcommon.utils.LocationUtils;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionExample.Criteria;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class AcquisitionService {

    @Autowired
    private AppletAcquisitionMapper acquisitionMapper;
    @Autowired
    private OrderService orderService;

    /**
     * 根据采集点ID查询采集点
     * @param acquisitionId     采集点ID
     * @return
     */
    public AppletAcquisition getAcquisitionByAcquisitionId(String acquisitionId){
        if (StringUtils.isBlank(acquisitionId)){
            return null;
        }
        AppletAcquisitionExample example = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        criteria.andAcquisitionIdEqualTo(acquisitionId);
        List<AppletAcquisition> acquisitions = acquisitionMapper.selectByExample(example);
        if (acquisitions.size()!=0){
            return acquisitions.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据不同的排序方式进行采集点排序
     * @param sortType      分类方式 0按照优先级 1按照订单数 2按照距离
     * @param cityName      所在城市名称
     * @param longitude     客户所在位置 经度
     * @param latitude      客户所在位置 纬度
     * @param serviceType
     * @param queryParam
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<AcquisitionBaseVo> sortAcquisition(Integer sortType,String cityName,double longitude,double latitude,Integer serviceType,String queryParam,Integer pageNo,Integer pageSize){
        if (sortType.equals(0)){
            //综合排序按照优先级
            return sortAcquisitionByAreaIdAndPriority(cityName, longitude, latitude, serviceType, queryParam, pageNo, pageSize);
        } else if (sortType.equals(1)) {
            //热门排序按订单数
            return sortAcquisitionByAreaIdAndOrderCount(cityName,longitude,latitude,serviceType,queryParam,pageNo,pageSize);
        } else if (sortType.equals(2)){
            //附近排序按距离
            return sortAcquisitionByAreaIdAndDistance(cityName,longitude,latitude,serviceType,queryParam,pageNo,pageSize);
        } else {
            //无排序要求 按照优先级来排序
            return sortAcquisitionByAreaIdAndPriority(cityName, longitude, latitude, serviceType, queryParam, pageNo, pageSize);
        }
    }

    public List<AcquisitionBaseVo> sortAcquisitionByAreaIdAndPriority(String cityName, double longitude, double latitude, Integer serviceType, String queryParam, Integer pageNo, Integer pageSize) {
        List<AcquisitionBaseVo> acquisitionBaseVos = new ArrayList<>();
        List<AppletAcquisition> acquisitions = getAcquisitionByAreaIdAndPriority(cityName,serviceType,queryParam,pageNo,pageSize);
        if (acquisitions==null){
            return null;
        }
        for (AppletAcquisition acquisition:acquisitions) {

            AcquisitionBaseVo baseVo = new AcquisitionBaseVo();
            BeanUtils.copyProperties(acquisition,baseVo);

            Integer acquisitionPriority = acquisition.getAcquisitionPriority();
            if (acquisitionPriority==null){
                acquisitionPriority = 50;
            }
            int extraCount = (50-acquisitionPriority+1)*3-1;

            Integer recommendNum = acquisition.getAcquisitionRecommendation();
            if (recommendNum==null){
                recommendNum = 0;
            }

            baseVo.setOrderCount(recommendNum+extraCount+acquisition.getId()%10);


//            baseVo.setOrderCount(orderService.getOrderCountByAcquisitionId(acquisition.getAcquisitionId()));
            Double longitude1 = acquisition.getLongitude();
            Double latitude1 = acquisition.getLatitude();
            Double distance = LocationUtils.getDistance(latitude1,longitude1,latitude,longitude);
            baseVo.setDistance(distance);

            acquisitionBaseVos.add(baseVo);
        }

        acquisitionBaseVos.sort(new Comparator<AcquisitionBaseVo>() {
            @Override
            public int compare(AcquisitionBaseVo o1, AcquisitionBaseVo o2) {
                return o1.getAcquisitionPriority()-o2.getAcquisitionPriority();
            }
        });

        acquisitionBaseVos.sort(new Comparator<AcquisitionBaseVo>() {
          @Override
          public int compare(AcquisitionBaseVo o1, AcquisitionBaseVo o2) {
            return o1.getAcquisitionStatus()-o2.getAcquisitionStatus();
          }
        });
        return acquisitionBaseVos;
    }

    public List<AppletAcquisition> getAcquisitionByAreaIdAndPriority(String cityName,Integer serviceType,String queryParam,Integer pageNo,Integer pageSize){
        AppletAcquisitionExample example = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(queryParam)){
            criteria.andAcquisitionNameLike("%"+queryParam+"%");
        }
        if (StringUtils.isNotBlank(cityName)){
            criteria.andAreaIdEqualTo(cityName);
        }
        if (serviceType!=null) {
            if (serviceType.equals(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION)){
                List<Integer> serviceTypes = new ArrayList<>();
                serviceTypes.add(AcquisitionConstants.ACQUISITION_SERVICE_TYPE_ONLINE);
                serviceTypes.add(AcquisitionConstants.ACQUISITION_SERVICE_TYPE_HOME_AND_ONLINE);
                criteria.andAcquisitionCollectTypeIn(serviceTypes);
            } else if (serviceType.equals(OrderConstants.ORDER_SERVICE_TYPE_HOME)){
                criteria.andAcquisitionCollectTypeEqualTo(AcquisitionConstants.ACQUISITION_SERVICE_TYPE_HOME_AND_ONLINE);
            } else if (serviceType.equals(OrderConstants.ORDER_SERVICE_TYPE_SELF)){
                return null;
            }
        }
        example.setOrderByClause("acquisition_priority ASC");
        PageHelper.startPage(1,50);
        List<AppletAcquisition> result = acquisitionMapper.selectByExample(example);
        PageInfo<AppletAcquisition> result2 = new PageInfo<>(result);
        return result2.getList();
    }

    public List<AcquisitionBaseVo> sortAcquisitionByAreaIdAndOrderCount(String cityName,double longitude,double latitude,Integer serviceType,String queryParam,Integer pageNo,Integer pageSize){

        List<AcquisitionBaseVo> acquisitionBaseVos = new ArrayList<>();

        AppletAcquisitionExample example = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(queryParam)){
            criteria.andAcquisitionNameLike("%"+queryParam+"%");
        }
        if (StringUtils.isNotBlank(cityName)){
            criteria.andAreaIdEqualTo(cityName);
        }
        if (serviceType!=null) {
            if (serviceType.equals(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION)){
                List<Integer> serviceTypes = new ArrayList<>();
                serviceTypes.add(AcquisitionConstants.ACQUISITION_SERVICE_TYPE_ONLINE);
                serviceTypes.add(AcquisitionConstants.ACQUISITION_SERVICE_TYPE_HOME_AND_ONLINE);
                criteria.andAcquisitionCollectTypeIn(serviceTypes);
            } else if (serviceType.equals(OrderConstants.ORDER_SERVICE_TYPE_HOME)){
                criteria.andAcquisitionCollectTypeEqualTo(AcquisitionConstants.ACQUISITION_SERVICE_TYPE_HOME_AND_ONLINE);
            } else if (serviceType.equals(OrderConstants.ORDER_SERVICE_TYPE_SELF)){
                return null;
            }
        }
        PageHelper.startPage(pageNo,pageSize);
        List<AppletAcquisition> result = acquisitionMapper.selectByExample(example);
        PageInfo<AppletAcquisition> result2 = new PageInfo<>(result);
        for (AppletAcquisition acquisition:result2.getList()) {
            AcquisitionBaseVo baseVo = new AcquisitionBaseVo();
            BeanUtils.copyProperties(acquisition,baseVo);

//            if (acquisition.getAcquisitionRecommendation()==null){
//                baseVo.setOrderCount(0);
//            } else {
//                baseVo.setOrderCount(Long.parseLong(acquisition.getAcquisitionRecommendation()+""));
//            }

            Double longitude1 = acquisition.getLongitude();
            Double latitude1 = acquisition.getLatitude();

            Double distance = LocationUtils.getDistance(latitude1,longitude1,latitude,longitude);
            baseVo.setDistance(distance);

            Integer acquisitionPriority = acquisition.getAcquisitionPriority();
            if (acquisitionPriority==null){
                acquisitionPriority = 50;
            }
            int extraCount = (50-acquisitionPriority+1)*3-1;

            Integer recommendNum = acquisition.getAcquisitionRecommendation();
            if (recommendNum==null){
                recommendNum = 0;
            }

            baseVo.setOrderCount(recommendNum+extraCount+acquisition.getId()%10);

            acquisitionBaseVos.add(baseVo);
        }
        acquisitionBaseVos.sort(new Comparator<AcquisitionBaseVo>() {
            @Override
            public int compare(AcquisitionBaseVo o1, AcquisitionBaseVo o2) {
                if (o1.getOrderCount()>o2.getOrderCount()){
                    return -1;
                } else if (o1.getOrderCount()==o2.getOrderCount()){
                    return 0;
                } else {
                    return 1;
                }
            }
        });
      acquisitionBaseVos.sort(new Comparator<AcquisitionBaseVo>() {
        @Override
        public int compare(AcquisitionBaseVo o1, AcquisitionBaseVo o2) {
          return o1.getAcquisitionStatus()-o2.getAcquisitionStatus();
        }
      });
        return acquisitionBaseVos;
    }

    public List<AcquisitionBaseVo> sortAcquisitionByAreaIdAndDistance(String cityName,double longitude,double latitude,Integer serviceType,String queryParam,Integer pageNo,Integer pageSize){

        List<AcquisitionBaseVo> acquisitionBaseVos = new ArrayList<>();

        AcquisitionDistanceOrderParam param = new AcquisitionDistanceOrderParam();
        param.setCityName(cityName);
        param.setLat(latitude);
        param.setLongt(longitude);
        param.setQueryParam(queryParam);

        PageHelper.startPage(pageNo,pageSize);
        List<AppletAcquisition> result = acquisitionMapper.selectOrderAcquisitionByDistance(param);
        PageInfo<AppletAcquisition> result2 = new PageInfo<>(result);
        for (AppletAcquisition acquisition:result2.getList()) {
            AcquisitionBaseVo baseVo = new AcquisitionBaseVo();
            BeanUtils.copyProperties(acquisition,baseVo);

//            if (acquisition.getAcquisitionRecommendation()==null){
//                baseVo.setOrderCount(0);
//            } else {
//                baseVo.setOrderCount(Long.parseLong(acquisition.getAcquisitionRecommendation()+""));
//            }

            Integer acquisitionPriority = acquisition.getAcquisitionPriority();
            if (acquisitionPriority==null){
                acquisitionPriority = 50;
            }
            int extraCount = (50-acquisitionPriority+1)*3-1;

            Integer recommendNum = acquisition.getAcquisitionRecommendation();
            if (recommendNum==null){
                recommendNum = 0;
            }

            baseVo.setOrderCount(recommendNum+extraCount+acquisition.getId()%10);

            Double longitude1 = acquisition.getLongitude();
            Double latitude1 = acquisition.getLatitude();

            Double distance = LocationUtils.getDistance(latitude1,longitude1,latitude,longitude);
            baseVo.setDistance(distance);

            acquisitionBaseVos.add(baseVo);
        }
        acquisitionBaseVos.sort(new Comparator<AcquisitionBaseVo>() {
            @Override
            public int compare(AcquisitionBaseVo o1, AcquisitionBaseVo o2) {
                if (o1.getDistance()<o2.getDistance()){
                    return -1;
                } else if (o1.getDistance()>o2.getDistance()){
                    return 1;
                } else {
                    return 0;
                }
            }
        });

      acquisitionBaseVos.sort(new Comparator<AcquisitionBaseVo>() {
        @Override
        public int compare(AcquisitionBaseVo o1, AcquisitionBaseVo o2) {
          return o1.getAcquisitionStatus()-o2.getAcquisitionStatus();
        }
      });
        return acquisitionBaseVos;
    }

  public List<AppletAcquisition> getAcquisitionByIds(List<Integer> idsList) {
    if (idsList == null || idsList.size() <= 0) {
      return null;
    }
    AppletAcquisitionExample example = new AppletAcquisitionExample();
    Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andIdIn(idsList);
    return acquisitionMapper.selectByExample(example);
  }
  }
