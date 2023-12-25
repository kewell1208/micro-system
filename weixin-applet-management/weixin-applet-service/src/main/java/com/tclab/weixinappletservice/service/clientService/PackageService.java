package com.tclab.weixinappletservice.service.clientService;

import static com.tclab.weixinappletcommon.constant.PackageConstants.PACKAGE_TYPE_INIT;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.AcquisitionConstants;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletcommon.constant.PackageConstants;
import com.tclab.weixinappletcommon.utils.LocationUtils;
import com.tclab.weixinappletcommon.utils.NumberUtils;
import com.tclab.weixinappletservice.dao.AppletAcquisitionMapper;
import com.tclab.weixinappletservice.dao.AppletPackageMapper;
import com.tclab.weixinappletservice.dao.AppletPackagePurposeFilterMapper;
import com.tclab.weixinappletservice.dao.AppletPackageSubMapper;
import com.tclab.weixinappletservice.model.query.QueryIdParam;
import com.tclab.weixinappletservice.model.result.PackageListForDoctorVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.AcquisitionBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.PackageBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.PackageDetailVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.PackageListQueryReqVo;
import com.tclab.weixinappletservice.pojo.*;
import com.tclab.weixinappletservice.pojo.AppletPackageExample.Criteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

  @Autowired
  private AppletPackageMapper packageMapper;
  @Autowired
  private AppletAcquisitionMapper acquisitionMapper;
  @Autowired
  private AppletPackageSubMapper subMapper;
  @Autowired
  private AppletPackagePurposeFilterMapper purposeFilterMapper;
  @Autowired
  private SourceService sourceService;

  private static final Logger logger = LoggerFactory.getLogger(PackageService.class);

  public List<AppletPackage> getAllPackageByPage(Integer pageNo, Integer pageSize) {
    AppletPackageExample example = new AppletPackageExample();
    AppletPackageExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andPackageTypeEqualTo(PACKAGE_TYPE_INIT);
    PageHelper.startPage(pageNo, pageSize);
    List<AppletPackage> docs = packageMapper.selectByExample(example);
    PageInfo<AppletPackage> pageInfo = new PageInfo<>(docs);
    return pageInfo.getList();
  }

  public List<PackageBaseVo> getPackageByPurposeByPage(String purposeId, String populationId, Integer pageNo, Integer pageSize) {
    AppletPackageExample example = new AppletPackageExample();
    AppletPackageExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (StringUtils.isNotBlank(purposeId)) {
      criteria.andPackagePurposeIdEqualTo(purposeId);
    }
    if (StringUtils.isNotBlank(populationId)) {
      criteria.andPackagePopulationIdEqualTo(populationId);
    }
    criteria.andPackageTypeEqualTo(PACKAGE_TYPE_INIT);
    if (pageNo == null || pageSize == null) {
      List<AppletPackage> packages = packageMapper.selectByExample(example);
      List<PackageBaseVo> packageBaseVos = new ArrayList<>();
      for (AppletPackage appletPackage : packages) {
        PackageBaseVo packageBaseVo = new PackageBaseVo();
        BeanUtils.copyProperties(appletPackage, packageBaseVo);
        packageBaseVos.add(packageBaseVo);
      }
      return packageBaseVos;
    }
    PageHelper.startPage(pageNo, pageSize);
    List<AppletPackage> docs = packageMapper.selectByExample(example);
    PageInfo<AppletPackage> pageInfo = new PageInfo<>(docs);
    List<PackageBaseVo> packageBaseVos = new ArrayList<>();
    for (AppletPackage appletPackage : pageInfo.getList()) {
      PackageBaseVo packageBaseVo = new PackageBaseVo();
      BeanUtils.copyProperties(appletPackage, packageBaseVo);
      packageBaseVos.add(packageBaseVo);
    }
    return packageBaseVos;
  }

  public List<PackageBaseVo> getPackageByPurposeByPageNew(String purposeId, String populationId, String catalogId, String sourceId, String sourceName, String queryParam, Integer pageNo,
      Integer pageSize) {
    AppletPackageExample example = new AppletPackageExample();
    AppletPackageExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (StringUtils.isNotBlank(purposeId)) {
      criteria.andPackagePurposeIdEqualTo(purposeId);
    }
    if (StringUtils.isNotBlank(populationId)) {
      criteria.andPackagePopulationIdEqualTo(populationId);
    }
    if (StringUtils.isNotBlank(catalogId)) {
      criteria.andPackageCatalogIdEqualTo(catalogId);
    }
    if (StringUtils.isNotBlank(sourceId)) {
      criteria.andPackageSourceIdEqualTo(sourceId);
    }
    if (StringUtils.isNotBlank(sourceName)) {
      criteria.andPackageSourceNameEqualTo(sourceName);
    }
    if (StringUtils.isNotBlank(queryParam)) {
      criteria.andPackageNameLike("%" + queryParam + "%");
    }
    criteria.andPackageTypeEqualTo(PACKAGE_TYPE_INIT);
    if (pageNo == null || pageSize == null) {
      List<AppletPackage> packages = packageMapper.selectByExample(example);
      List<PackageBaseVo> packageBaseVos = new ArrayList<>();

      int recommendNum = 0;
      int priority = 0;

      for (AppletPackage appletPackage : packages) {
        PackageBaseVo packageBaseVo = new PackageBaseVo();
        BeanUtils.copyProperties(appletPackage, packageBaseVo);

        //定制参检人数
//        Integer packageRecommendNum = appletPackage.getPackageRecommendation();
//        if (packageRecommendNum==null){
//          packageRecommendNum = 0;
//        }
        recommendNum = NumberUtils.null2num(packageBaseVo.getPackageRecommendation());
        priority = NumberUtils.null2num(packageBaseVo.getPackagePriority());
        packageBaseVo.setPackageRecommendation(
            60 + priority + recommendNum + Integer.valueOf(appletPackage.getPackageId().substring(appletPackage.getPackageId().length() - 2, appletPackage.getPackageId().length())));

        packageBaseVos.add(packageBaseVo);
      }
      return packageBaseVos;
    }
    PageHelper.startPage(pageNo, pageSize);
    List<AppletPackage> docs = packageMapper.selectByExample(example);
    PageInfo<AppletPackage> pageInfo = new PageInfo<>(docs);
    List<PackageBaseVo> packageBaseVos = new ArrayList<>();
    for (AppletPackage appletPackage : pageInfo.getList()) {
      PackageBaseVo packageBaseVo = new PackageBaseVo();
      BeanUtils.copyProperties(appletPackage, packageBaseVo);
      AppletPackageSource source = sourceService.getSourceById(appletPackage.getPackageSourceId());
      if (source != null) {
        packageBaseVo.setSourcePic(source.getSourcePic());
      }
      packageBaseVos.add(packageBaseVo);
    }
    return packageBaseVos;
  }

  //获取订单采集服务方式
  public List<Integer> getOrderServiceType(String acquisitionId, List<String> packageIds) {
    List<AppletPackage> packages = new ArrayList<>();
    AppletPackageExample example = new AppletPackageExample();
    AppletPackageExample.Criteria criteria = example.createCriteria();
    for (String id : packageIds) {
      criteria.andPackageIdEqualTo(id);
      criteria.andDelFlagEqualTo(CommonConstants.INIT);
      packages.addAll(packageMapper.selectByExample(example));
    }

    Integer acquisitionCollectType = 0;

    if (StringUtils.isNotBlank(acquisitionId)) {
      AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
      AppletAcquisitionExample.Criteria acquisitionExampleCriteria = acquisitionExample.createCriteria();
      acquisitionExampleCriteria.andAcquisitionIdEqualTo(acquisitionId);
      acquisitionExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
      List<AppletAcquisition> acquisitions = acquisitionMapper.selectByExample(acquisitionExample);
      if (acquisitions.size() != 0) {
        acquisitionCollectType = acquisitions.get(0).getAcquisitionCollectType();
      } else {
        return null;
      }
    }
    Integer packageCollectType = 0;
    List<Integer> result = new ArrayList<>();
    result.add(OrderConstants.ORDER_SERVICE_TYPE_SELF);
    result.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
    result.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);

    for (AppletPackage p : packages) {
      packageCollectType = p.getPackageCollectType();

      //如果医院都支持到院采集和上门采集
      if (acquisitionCollectType.equals(AcquisitionConstants.ACQUISITION_SERVICE_TYPE_HOME_AND_ONLINE)) {
        //如果套餐支持线上自行采集和线下采集
        if (p.getPackageCollectType().equals(PackageConstants.PACKAGE_SERVICE_TYPE_SELF_AND_OFFLINE)) {

        }
        //如果套餐只支持线下采集
        if (p.getPackageCollectType().equals(PackageConstants.PACKAGE_SERVICE_TYPE_OFFLINE)) {
//                    if (result.contains(OrderConstants.ORDER_SERVICE_TYPE_SELF)){
//                        result.remove(OrderConstants.ORDER_SERVICE_TYPE_SELF);
//                    }
          for (Iterator iter = result.iterator(); iter.hasNext(); ) {
            int a = (int) iter.next();
            if (a == OrderConstants.ORDER_SERVICE_TYPE_SELF) {
              iter.remove();
              break;
            }
          }
        }
      }

      //如果医院只支持到院采集
      if (acquisitionCollectType.equals(AcquisitionConstants.ACQUISITION_SERVICE_TYPE_ONLINE)) {
        //如果套餐支持线上自行采集和线下采集
        if (p.getPackageCollectType().equals(PackageConstants.PACKAGE_SERVICE_TYPE_SELF_AND_OFFLINE)) {
//                    if (result.contains(OrderConstants.ORDER_SERVICE_TYPE_HOME)){
//                        result.remove(OrderConstants.ORDER_SERVICE_TYPE_HOME);
//                    }
          for (Iterator iter = result.iterator(); iter.hasNext(); ) {
            int a = (int) iter.next();
            if (a == OrderConstants.ORDER_SERVICE_TYPE_HOME) {
              iter.remove();
              break;
            }
          }
        }
        //如果套餐只支持线下采集
        if (p.getPackageCollectType().equals(PackageConstants.PACKAGE_SERVICE_TYPE_OFFLINE)) {
//                    if (result.contains(OrderConstants.ORDER_SERVICE_TYPE_SELF)){
//                        result.remove(OrderConstants.ORDER_SERVICE_TYPE_SELF);
//                    }
          for (Iterator iter = result.iterator(); iter.hasNext(); ) {
            int a = (int) iter.next();
            if (a == OrderConstants.ORDER_SERVICE_TYPE_SELF) {
              iter.remove();
              break;
            }
          }
//                    if (result.contains(OrderConstants.ORDER_SERVICE_TYPE_HOME)){
//                        result.remove(OrderConstants.ORDER_SERVICE_TYPE_HOME);
//                    }
          for (Iterator iter = result.iterator(); iter.hasNext(); ) {
            int a = (int) iter.next();
            if (a == OrderConstants.ORDER_SERVICE_TYPE_HOME) {
              iter.remove();
              break;
            }
          }
        }
      }
    }
    logger.info("客户端查询订单服务方式结果: " + result);
    return result;
  }

  public List<Integer> getOrderServiceTypeNew(List<String> packageIds) {
    //套餐列表
    AppletPackageExample example = new AppletPackageExample();
    AppletPackageExample.Criteria criteria = example.createCriteria();
    criteria.andPackageIdIn(packageIds);
    List<AppletPackage> packageList = packageMapper.selectByExample(example);
    //订单采集方式默认含有到院采集
    List<Integer> orderCollectType = new ArrayList<>();
    orderCollectType.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
    //获取不重复的套餐采集方式
    Set<Integer> packageCollectSet = new HashSet();
    for (AppletPackage appletPackage : packageList) {
      packageCollectSet.add(appletPackage.getPackageCollectType());
    }
    //如果套餐采集方式中包含到院采集则订单的采集方式只能是到院采集
    boolean checkType = false;
    for (Integer packageCollectType : packageCollectSet) {
      if (packageCollectType.equals(PackageConstants.PACKAGE_SERVICE_TYPE_OFFLINE)) {
        checkType = true;
      }
    }
    if (!checkType) {
      orderCollectType.add(OrderConstants.ORDER_SERVICE_TYPE_SELF);
    }
    return orderCollectType;
  }

  public List<AcquisitionBaseVo> getOrderAcquisition(List<String> packageIds, Integer sortType, Double latitude, Double longitude, String queryParam) {
    //判断套餐有没有除了肠道微生态的套餐
    AppletPackageExample example = new AppletPackageExample();
    AppletPackageExample.Criteria criteria = example.createCriteria();
    criteria.andPackageIdIn(packageIds);
    criteria.andPackageCollectTypeEqualTo(PackageConstants.PACKAGE_SERVICE_TYPE_SELF_AND_OFFLINE);
    criteria.andPackageSourceNameLike("%tclab%");
    criteria.andPackageTypeEqualTo(PACKAGE_TYPE_INIT);
    List<AppletPackage> packageList = packageMapper.selectByExample(example);

    List<AcquisitionBaseVo> acquisitionBaseVoList = new ArrayList<>();

    //如果不存在肠道微生态套餐则需要去树兰检验科或者其他支持全采集的采集点去
    if (packageList.size() == 0) {
      AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
      AppletAcquisitionExample.Criteria acquisitionExampleCriteria = acquisitionExample.createCriteria();
      acquisitionExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
      acquisitionExampleCriteria.andAcquisitionStatusEqualTo(CommonConstants.INIT);
      acquisitionExampleCriteria.andAcquisitionSampleTypeEqualTo(AcquisitionConstants.ACQUISITION_COLLECT_SAMPLE_TYPE_ALL);
      if (StringUtils.isNotBlank(queryParam)) {
        acquisitionExampleCriteria.andAcquisitionNameLike("%" + queryParam + "%");
      }
      List<AppletAcquisition> acquisitionList = acquisitionMapper.selectByExample(acquisitionExample);
      for (AppletAcquisition acquisition : acquisitionList) {
        AcquisitionBaseVo acquisitionBaseVo = new AcquisitionBaseVo();
        BeanUtils.copyProperties(acquisition, acquisitionBaseVo);
        if (acquisition.getAcquisitionRecommendation() != null) {
          acquisitionBaseVo.setOrderCount(acquisition.getAcquisitionRecommendation());
        }

        Integer acquisitionPriority = acquisition.getAcquisitionPriority();
        if (acquisitionPriority == null) {
          acquisitionPriority = 50;
        }
        int extraCount = (50 - acquisitionPriority + 1) * 3 - 1;

        Integer recommendNum = acquisition.getAcquisitionRecommendation();
        if (recommendNum == null) {
          recommendNum = 0;
        }

        acquisitionBaseVo.setOrderCount(recommendNum + extraCount + acquisition.getId() % 10);

        Double longitude1 = acquisition.getLongitude();
        Double latitude1 = acquisition.getLatitude();
        Double distance = LocationUtils.getDistance(latitude1, longitude1, latitude, longitude);
        acquisitionBaseVo.setDistance(distance);
        acquisitionBaseVoList.add(acquisitionBaseVo);
      }
      acquisitionBaseVoList.sort(new Comparator<AcquisitionBaseVo>() {
        @Override
        public int compare(AcquisitionBaseVo o1, AcquisitionBaseVo o2) {
          if (sortType.equals(0)) {
            return o1.getAcquisitionPriority().compareTo(o2.getAcquisitionPriority());
          } else if (sortType.equals(1)) {
            if (o1.getOrderCount() > o2.getOrderCount()) {
              return -1;
            } else if (o1.getOrderCount() == o2.getOrderCount()) {
              return 0;
            } else {
              return 1;
            }
          } else if (sortType.equals(2)) {
            if (o1.getDistance() < o2.getDistance()) {
              return -1;
            } else if (o1.getDistance() > o2.getDistance()) {
              return 1;
            } else {
              return 0;
            }
          } else {
            return o1.getAcquisitionPriority().compareTo(o2.getAcquisitionPriority());
          }
        }
      });
    } else {
      //如果存在肠道微生态套餐
      if (packageList.size() != packageIds.size()) {
        //判断肠道微生态的套餐是否是等于全部的套餐数，如果不是则还存在其他套餐则必须去树兰检验科
        AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria acquisitionExampleCriteria = acquisitionExample.createCriteria();
        acquisitionExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        acquisitionExampleCriteria.andAcquisitionStatusEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(queryParam)) {
          acquisitionExampleCriteria.andAcquisitionNameLike("%" + queryParam + "%");
        }
        acquisitionExampleCriteria.andAcquisitionSampleTypeEqualTo(AcquisitionConstants.ACQUISITION_COLLECT_SAMPLE_TYPE_ALL);
        acquisitionExampleCriteria.andAcquisitionTypeEqualTo(PACKAGE_TYPE_INIT);
        List<AppletAcquisition> acquisitionList = acquisitionMapper.selectByExample(acquisitionExample);
        for (AppletAcquisition acquisition : acquisitionList) {
          AcquisitionBaseVo acquisitionBaseVo = new AcquisitionBaseVo();
          BeanUtils.copyProperties(acquisition, acquisitionBaseVo);
          if (acquisition.getAcquisitionRecommendation() != null) {
            acquisitionBaseVo.setOrderCount(acquisition.getAcquisitionRecommendation());
          }

          Integer acquisitionPriority = acquisition.getAcquisitionPriority();
          if (acquisitionPriority == null) {
            acquisitionPriority = 50;
          }
          int extraCount = (50 - acquisitionPriority + 1) * 3 - 1;

          Integer recommendNum = acquisition.getAcquisitionRecommendation();
          if (recommendNum == null) {
            recommendNum = 0;
          }

          acquisitionBaseVo.setOrderCount(recommendNum + extraCount);

          Double longitude1 = acquisition.getLongitude();
          Double latitude1 = acquisition.getLatitude();
          Double distance = LocationUtils.getDistance(latitude1, longitude1, latitude, longitude);
          acquisitionBaseVo.setDistance(distance);
          acquisitionBaseVoList.add(acquisitionBaseVo);
        }
        acquisitionBaseVoList.sort(new Comparator<AcquisitionBaseVo>() {
          @Override
          public int compare(AcquisitionBaseVo o1, AcquisitionBaseVo o2) {
            if (sortType.equals(0)) {
              return o1.getAcquisitionPriority().compareTo(o2.getAcquisitionPriority());
            } else if (sortType.equals(1)) {
              if (o1.getOrderCount() > o2.getOrderCount()) {
                return -1;
              } else if (o1.getOrderCount() == o2.getOrderCount()) {
                return 0;
              } else {
                return 1;
              }
            } else if (sortType.equals(2)) {
              if (o1.getDistance() < o2.getDistance()) {
                return -1;
              } else if (o1.getDistance() > o2.getDistance()) {
                return 1;
              } else {
                return 0;
              }
            } else {
              return o1.getAcquisitionPriority().compareTo(o2.getAcquisitionPriority());
            }
          }
        });
      } else {
        //如果肠道微生态的套餐等于全部套参数，则可以去全部的采集点
        AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria acquisitionExampleCriteria = acquisitionExample.createCriteria();
        acquisitionExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        acquisitionExampleCriteria.andAcquisitionStatusEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(queryParam)) {
          acquisitionExampleCriteria.andAcquisitionNameLike("%" + queryParam + "%");
        }
        acquisitionExampleCriteria.andAcquisitionTypeEqualTo(PACKAGE_TYPE_INIT);
        List<AppletAcquisition> acquisitionList = acquisitionMapper.selectByExample(acquisitionExample);
        for (AppletAcquisition acquisition : acquisitionList) {
          AcquisitionBaseVo acquisitionBaseVo = new AcquisitionBaseVo();
          BeanUtils.copyProperties(acquisition, acquisitionBaseVo);
          if (acquisition.getAcquisitionRecommendation() != null) {
            acquisitionBaseVo.setOrderCount(acquisition.getAcquisitionRecommendation());
          }

          Integer acquisitionPriority = acquisition.getAcquisitionPriority();
          if (acquisitionPriority == null) {
            acquisitionPriority = 50;
          }
          int extraCount = (50 - acquisitionPriority + 1) * 3 - 1;

          Integer recommendNum = acquisition.getAcquisitionRecommendation();
          if (recommendNum == null) {
            recommendNum = 0;
          }

          acquisitionBaseVo.setOrderCount(recommendNum + extraCount);

          Double longitude1 = acquisition.getLongitude();
          Double latitude1 = acquisition.getLatitude();
          Double distance = LocationUtils.getDistance(latitude1, longitude1, latitude, longitude);
          acquisitionBaseVo.setDistance(distance);
          acquisitionBaseVoList.add(acquisitionBaseVo);
        }
        acquisitionBaseVoList.sort(new Comparator<AcquisitionBaseVo>() {
          @Override
          public int compare(AcquisitionBaseVo o1, AcquisitionBaseVo o2) {
            if (sortType.equals(0)) {
              return o1.getAcquisitionPriority().compareTo(o2.getAcquisitionPriority());
            } else if (sortType.equals(1)) {
              if (o1.getOrderCount() > o2.getOrderCount()) {
                return -1;
              } else if (o1.getOrderCount() == o2.getOrderCount()) {
                return 0;
              } else {
                return 1;
              }
            } else if (sortType.equals(2)) {
              if (o1.getDistance() < o2.getDistance()) {
                return -1;
              } else if (o1.getDistance() > o2.getDistance()) {
                return 1;
              } else {
                return 0;
              }
            } else {
              return o1.getAcquisitionPriority().compareTo(o2.getAcquisitionPriority());
            }
          }
        });
      }
    }
    return acquisitionBaseVoList;
  }


  public AppletPackage getPackageById(String packageId) {
    AppletPackageExample example = new AppletPackageExample();
    AppletPackageExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (packageId != null) {
      criteria.andPackageIdEqualTo(packageId);
    } else {
      return null;
    }
    List<AppletPackage> packages = packageMapper.selectByExample(example);
    if (packages.size() != 0) {
      return packages.get(0);
    } else {
      return null;
    }
  }

  public PackageDetailVo getPackageByIdNew(String packageId) {

    PackageDetailVo detailVo = new PackageDetailVo();

    AppletPackageExample example = new AppletPackageExample();
    AppletPackageExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (packageId != null) {
      criteria.andPackageIdEqualTo(packageId);
    } else {
      return null;
    }
    List<AppletPackage> packages = packageMapper.selectByExample(example);
    if (packages.size() != 0) {
      AppletPackage queryPackage = packages.get(0);
      BeanUtils.copyProperties(queryPackage, detailVo);
      if (StringUtils.isNotBlank(queryPackage.getPackageSourceId())) {
        AppletPackageSource source = sourceService.getSourceById(queryPackage.getPackageSourceId());
        if (source != null) {
          detailVo.setSourcePic(source.getSourcePic());
        }
      }
    } else {
      return null;
    }

    AppletPackageSubExample subExample = new AppletPackageSubExample();
    AppletPackageSubExample.Criteria subCriteria = subExample.createCriteria();
    subCriteria.andPackageIdEqualTo(packageId);
    subCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    List<AppletPackageSub> subList = subMapper.selectByExample(subExample);
    detailVo.setPackageSubList(subList);
    return detailVo;
  }

  public List<AppletPackage> getPackageByParam(String queryParam) {
    AppletPackageExample example = new AppletPackageExample();
    AppletPackageExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (queryParam != null) {
      criteria.andPackageNameLike("%" + queryParam + "%");
    }
    criteria.andPackageTypeEqualTo(PACKAGE_TYPE_INIT);
    List<AppletPackage> packages = packageMapper.selectByExample(example);
    return packages;
  }

//  public List<PackageBaseVo> getTopPackage() {
//
//    List<PackageBaseVo> packageBaseVos = new ArrayList<>();
//    AppletPackageExample example = new AppletPackageExample();
//    AppletPackageExample.Criteria criteria = example.createCriteria();
//    criteria.andDelFlagEqualTo(CommonConstants.INIT);
//    List<Integer> prioritys = new ArrayList<>();
//    prioritys.add(0);
//    prioritys.add(1);
////    prioritys.add(2);
////    prioritys.add(3);
//    criteria.andPackagePriorityIn(prioritys);
//    criteria.andDelFlagEqualTo(CommonConstants.INIT);
//    List<AppletPackage> docs = packageMapper.selectByExample(example);
//
//    List<String> packageIds = new ArrayList<>();
//
//    int i = 0;
//    for (AppletPackage appletPackage : docs) {
//      PackageBaseVo packageBaseVo = new PackageBaseVo();
//      BeanUtils.copyProperties(docs.get(i), packageBaseVo);
//      packageBaseVo.setNum(i);
//      packageIds.add(appletPackage.getPackageId());
//      i++;
//      packageBaseVos.add(packageBaseVo);
//    }
//
//    example.clear();
//    criteria = example.createCriteria();
//
//    criteria.andDelFlagEqualTo(CommonConstants.INIT);
//    criteria.andPackageIdNotIn(packageIds);
//    example.setOrderByClause("package_recommendation DESC");
//    PageHelper.startPage(1, 2);
//    docs = packageMapper.selectByExample(example);
//    PageInfo<AppletPackage> pageInfo = new PageInfo<>(docs);
//
//    for (AppletPackage appletPackage : pageInfo.getList()) {
//      PackageBaseVo packageBaseVo = new PackageBaseVo();
//      BeanUtils.copyProperties(appletPackage, packageBaseVo);
//      packageBaseVo.setNum(i);
//      i++;
//      packageBaseVos.add(packageBaseVo);
//    }
//
//    return packageBaseVos;
//  }

  public List<PackageBaseVo> getTopPackage() {
//        AppletPackageExample example = new AppletPackageExample();
//        AppletPackageExample.Criteria criteria = example.createCriteria();
//        criteria.andDelFlagEqualTo(CommonConstants.INIT);
//        example.setOrderByClause("package_recommendation DESC");
//        PageHelper.startPage(1, 2);
//        List<AppletPackage> docs = packageMapper.selectByExample(example);
//        PageInfo<AppletPackage> pageInfo = new PageInfo<>(docs);
//        List<PackageBaseVo> packageBaseVos = new ArrayList<>();
//        int i = 1;
//        for (AppletPackage appletPackage:pageInfo.getList()) {
//            PackageBaseVo packageBaseVo = new PackageBaseVo();
//            BeanUtils.copyProperties(appletPackage,packageBaseVo);
//            packageBaseVo.setNum(i);
//            i++;
//            packageBaseVos.add(packageBaseVo);
//        }
//
//        example.clear();
//        criteria = example.createCriteria();

    List<PackageBaseVo> packageBaseVos = new ArrayList<>();

    AppletPackageExample example = new AppletPackageExample();
    AppletPackageExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andPackageStatusEqualTo(CommonConstants.INIT);
    criteria.andPackageTypeEqualTo(PACKAGE_TYPE_INIT);
    List<Integer> prioritys = new ArrayList<>();
    prioritys.add(0);
//    prioritys.add(1);
//        prioritys.add(2);
//        prioritys.add(3);
    criteria.andPackagePriorityIn(prioritys);
//        criteria.andDelFlagEqualTo(CommonConstants.INIT);
//        List<AppletPackage> docs = packageMapper.selectByExample(example);
//
//        List<String> packageIds = new ArrayList<>();
//
    int i = 0;
//        for (AppletPackage appletPackage:docs) {
//            PackageBaseVo packageBaseVo = new PackageBaseVo();
//            BeanUtils.copyProperties(docs.get(i),packageBaseVo);
//            packageBaseVo.setNum(i);
//            packageIds.add(appletPackage.getPackageId());
//            i++;
//            packageBaseVos.add(packageBaseVo);
//        }
//
//        example.clear();
//        criteria = example.createCriteria();

//        criteria.andDelFlagEqualTo(CommonConstants.INIT);
//        criteria.andPackageIdNotIn(packageIds);
    example.setOrderByClause("package_recommendation DESC");
    PageHelper.startPage(1, 6);
    List<AppletPackage> docs = packageMapper.selectByExample(example);
    PageInfo<AppletPackage> pageInfo = new PageInfo<>(docs);

    int recommnend = 0;
    int priority = 0;

    for (AppletPackage appletPackage : pageInfo.getList()) {
      PackageBaseVo packageBaseVo = new PackageBaseVo();
      BeanUtils.copyProperties(appletPackage, packageBaseVo);
      packageBaseVo.setNum(i);
      recommnend = NumberUtils.null2num(appletPackage.getPackageRecommendation());
      priority = NumberUtils.null2num(packageBaseVo.getPackagePriority());
//      packageBaseVo.setPackageRecommendation(10*(5-appletPackage.getPackagePriority()+1)+recommnend);
      packageBaseVo.setPackageRecommendation(
          60 + priority + recommnend + Integer.valueOf(appletPackage.getPackageId().substring(appletPackage.getPackageId().length() - 2, appletPackage.getPackageId().length())));
      i++;
      AppletPackageSource source = sourceService.getSourceById(appletPackage.getPackageSourceId());
      if (source != null) {
        packageBaseVo.setSourcePic(source.getSourcePic());
      }
      packageBaseVos.add(packageBaseVo);
    }

    return packageBaseVos;
  }

  public List<PackageListForDoctorVo> getAllPackageByLimit(String queryParam, Integer pageNo, Integer pageSize) {
    AppletPackageExample example = new AppletPackageExample();
    AppletPackageExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (StringUtils.isNotBlank(queryParam)) {
      criteria.andPackageNameLike("%" + queryParam + "%");
    }
    criteria.andPackageTypeEqualTo(PACKAGE_TYPE_INIT);
    PageHelper.startPage(pageNo, pageSize);
    List<AppletPackage> docs = packageMapper.selectByExample(example);
    PageInfo<AppletPackage> pageInfo = new PageInfo<>(docs);

    List<PackageListForDoctorVo> shulanVos = new ArrayList<>();
    for (AppletPackage p : pageInfo.getList()) {
      PackageListForDoctorVo shulanVo = new PackageListForDoctorVo();
      shulanVo.setPackageCurrentPrice(p.getPackageCurrentPrice());
      shulanVo.setPackageId(p.getPackageId());
      shulanVo.setPackageName(p.getPackageName());
      shulanVo.setPackageRecommendationNum(p.getPackageRecommendation());
      shulanVo.setPackageRemark(p.getPackageRemark());
      shulanVo.setPackageSpecialRequirement(p.getPackageSpecialRequirement());
      shulanVos.add(shulanVo);
    }
    return shulanVos;
  }

  public List<PackageListForDoctorVo> getPackageByFilter(String purposeId, String sourceId, String queryParam, Integer pageNo, Integer pageSize) {
    List<PackageListForDoctorVo> shulanVos = new ArrayList<>();
    QueryIdParam param = new QueryIdParam();
    param.setPurposeId(purposeId);
    param.setSourceId(sourceId);
    param.setQueryParam(queryParam);
    shulanVos = purposeFilterMapper.selectPackageListResult(param);
    return shulanVos;
  }

  public List<AppletPackage> getPackageByTag(String tagId, String queryParam) {
    QueryIdParam param = new QueryIdParam();
    if (StringUtils.isNotBlank(tagId)) {
      param.setTagId(tagId);
    }
    if (StringUtils.isNotBlank(queryParam)) {
      param.setQueryParam(queryParam);
    }
    return packageMapper.selectByTag(param);
  }

  public List<AppletPackage> getPackageList(PackageListQueryReqVo vo) {
    AppletPackageExample example = new AppletPackageExample();
    Criteria criteria = example.createCriteria();
    if (StringUtils.isNotBlank(vo.getPackageSourceId())) {
      criteria.andPackageSourceIdEqualTo(vo.getPackageSourceId());
    }
    if (StringUtils.isNotBlank(vo.getPackageNo())) {
      criteria.andPackageIdIn(Arrays.asList(vo.getPackageNo().split(",")));
    }
    if (StringUtils.isNotBlank(vo.getPackageName())) {
      criteria.andPackageNameLike("%" + vo.getPackageName() + "%");
    }
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andPackageTypeEqualTo(PACKAGE_TYPE_INIT);
    if (vo.getPageNo() != null && vo.getPageSize() != null) {
      PageHelper.startPage(vo.getPageNo(), vo.getPageSize());
    }
    if (vo.getPageNo() != null && vo.getPageSize() != null) {
      PageHelper.startPage(vo.getPageNo(), vo.getPageSize());
    }
    return packageMapper.selectByExample(example);
  }

  public List<AppletPackage> getPackageByIdList(List<String> packageIdList) {
    AppletPackageExample example = new AppletPackageExample();
    Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (packageIdList != null && packageIdList.size() != 0) {
      criteria.andPackageIdIn(packageIdList);
    }
    return packageMapper.selectByExample(example);
  }

  public List<AppletPackage> getPackageByIds(List<Integer> idsList) {
    if (idsList == null || idsList.size() <= 0) {
      return null;
    }
    AppletPackageExample example = new AppletPackageExample();
    Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andIdIn(idsList);
    return packageMapper.selectByExample(example);
  }
}
