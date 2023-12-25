package com.tclab.weixinappletuserclient.controller.front.user_client;

import com.alibaba.fastjson.JSONObject;
import com.tclab.weixinappletcommon.constant.BannerConstants;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletcommon.utils.Aes;
import com.tclab.weixinappletcommon.utils.NumberUtils;
import com.tclab.weixinappletcommon.utils.WxTencentUtils;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.AcquisitionDetailVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.AlphabetPurposeVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.PackageBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.PackageDetailVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.PurposePackageVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.SourceCatalogPurposeListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.shulanVo.PackageListForShulanVo;
import com.tclab.weixinappletservice.pojo.AppletAcquisition;
import com.tclab.weixinappletservice.pojo.AppletBanner;
import com.tclab.weixinappletservice.pojo.AppletPackage;
import com.tclab.weixinappletservice.pojo.AppletPackagePurpose;
import com.tclab.weixinappletservice.pojo.AppletPackageTag;
import com.tclab.weixinappletservice.service.clientService.AcquisitionService;
import com.tclab.weixinappletservice.service.clientService.BannerService;
import com.tclab.weixinappletservice.service.clientService.CatalogService;
import com.tclab.weixinappletservice.service.clientService.PackageService;
import com.tclab.weixinappletservice.service.clientService.PopulationService;
import com.tclab.weixinappletservice.service.clientService.PurposeService;
import com.tclab.weixinappletservice.service.clientService.SourceService;
import com.tclab.weixinappletservice.service.clientService.TagService;
import com.tclab.weixinappletuserclient.model.req.apiReq.AcquisitionSortReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.QrReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.QueryPackageReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.QueryPurposeReq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user/home")
public class UcHomeController {

  private static final Logger logger = LoggerFactory.getLogger(UcHomeController.class);

  @Autowired
  private PackageService packageService;
  @Autowired
  private PurposeService purposeService;
  @Autowired
  private PopulationService populationService;
  @Autowired
  private CatalogService catalogService;
  @Autowired
  private AcquisitionService acquisitionService;
  @Autowired
  private BannerService bannerService;
  @Autowired
  private SourceService sourceService;
  @Autowired
  private TagService tagService;

  /**
   * 查询检查目的首字母目录
   */
  @RequestMapping(value = "/query/purposes", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPurpose(QueryPurposeReq req) {

    logger.info("客户端查询检验目的并按字母排序 " + req.toString());

    List<AlphabetPurposeVo> result = purposeService.groupByPurpose(purposeService.getPurpose(req.getPurposeId(), req.getCatalogId()));
    return JsonResVo.buildSuccess(result);
  }

  /**
   * 查询检查目及相关套餐
   */
  @RequestMapping(value = "/query/purposesWithPackage", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPurposeWithPackage(QueryPurposeReq req) {

    logger.info("客户端查询检验目的并按字母排序 " + req.toString());

    List<AppletPackagePurpose> result = purposeService.getPurpose(req.getPurposeId(), req.getCatalogId());
    List<PackageBaseVo> packageBaseVos = packageService.getPackageByPurposeByPage(req.getPurposeId(), null, null, null);
    PurposePackageVo purposePackageVo = new PurposePackageVo();
    purposePackageVo.setPackageBaseVos(packageBaseVos);
    purposePackageVo.setPackagePurpose(result.get(0));
    return JsonResVo.buildSuccess(purposePackageVo);
  }

  /**
   * 查询检查目的
   */
  @RequestMapping(value = "/query/purposesByCatalog", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPurposeByCatalog(QueryPurposeReq req) {

    logger.info("客户端查询检验目的根据科室 " + req.toString());

    if (StringUtils.isBlank(req.getCatalogId())) {
      return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
    }
    List<AppletPackagePurpose> list = purposeService.getPurpose(null, req.getCatalogId());
    return JsonResVo.buildSuccess(list);
  }

  /**
   * 查询套餐
   */
  @RequestMapping(value = "/query/package", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPackage(QueryPackageReq req) {

    logger.info("客户端查询套餐列表 " + req.toString());

    List<PackageBaseVo> result = packageService.getPackageByPurposeByPage(req.getPurposeId(), req.getPopulationId(), req.getPageNo(), req.getPageSize());
    return JsonResVo.buildSuccess(result);
  }

  /**
   * 查询套餐详细信息
   */
  @RequestMapping(value = "/query/packageById", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPackageById(@RequestParam String packageId) {

    logger.info("客户端查询套餐详情 " + packageId);

    AppletPackage result = packageService.getPackageById(packageId);
    int recommendNum = NumberUtils.null2num(result.getPackageRecommendation());
    int priority = NumberUtils.null2num(result.getPackagePriority());
    result.setPackageRecommendation(60 + priority + recommendNum + Integer.valueOf(result.getPackageId().substring(result.getPackageId().length() - 2, result.getPackageId().length())));
//        if (result.getPackageSourceId().equals(PackageConstants.SOURCE_TYPE_SHULAN)){
////            result.setPackageRecommendation(60+recommendNum);
//            result.setPackageRecommendation(60+priority+recommendNum+Integer.valueOf(result.getPackageId().substring(result.getPackageId().length()-2,result.getPackageId().length())));
//        } else if (result.getPackageSourceId().equals(PackageConstants.SOURCE_TYPE_TCLAB)){
////            result.setPackageRecommendation(10*(5-priority+1)+recommendNum);
//            result.setPackageRecommendation(60+priority+recommendNum+Integer.valueOf(result.getPackageId().substring(result.getPackageId().length()-2,result.getPackageId().length())));
//        } else {
//            result.setPackageRecommendation(recommendNum);
//        }
    return JsonResVo.buildSuccess(result);
  }

  /**
   * 首页顶部根据套餐名模糊查询套餐
   */
  @RequestMapping(value = "/query/packageByParam", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPackageByParam(@RequestParam String queryParam) {

    logger.info("客户端首页查询套餐 " + queryParam);

    List<AppletPackage> result = packageService.getPackageByParam(queryParam);
    List<PackageBaseVo> resultBaseVos = new ArrayList<>();
    for (AppletPackage appletPackage : result) {
      PackageBaseVo packageBaseVo = new PackageBaseVo();
      BeanUtils.copyProperties(appletPackage, packageBaseVo);
      resultBaseVos.add(packageBaseVo);
    }
    return JsonResVo.buildSuccess(resultBaseVos);
  }

  /**
   * 查询所有人群
   */
  @RequestMapping(value = "/query/population", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPopulation() {
    logger.info("客户端查询所有人群");
    return JsonResVo.buildSuccess(populationService.getAllPopulation());
  }

  /**
   * 查询所有科室
   */
  @RequestMapping(value = "/query/catalog", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryCatalog() {
    logger.info("客户端查询所有科室");
    return JsonResVo.buildSuccess(catalogService.getAllCatalog());
  }

  /**
   * 根据不同的条件查询采集点
   */
  @RequestMapping(value = "/query/acquisition", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryAcquisition(AcquisitionSortReq req) {
    logger.info("客户端查询采集点 " + req.toString());
    return JsonResVo.buildSuccess(
        acquisitionService.sortAcquisition(req.getType(), req.getCityName(), req.getLongitude(), req.getLatitude(), req.getServiceType(), req.getQueryParam(), req.getPageNo(), req.getPageSize()));
  }

  /**
   * 查询采集点详情
   */
  @RequestMapping(value = "/query/acquisitionById", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryAcquisition(@RequestParam String acquisitionId) {

    logger.info("客户端查询采集点详情 " + acquisitionId);

    if (StringUtils.isBlank(acquisitionId)) {
      return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
    }
    AppletAcquisition acquisition = acquisitionService.getAcquisitionByAcquisitionId(acquisitionId);

    AcquisitionDetailVo acquisitionDetailVo = new AcquisitionDetailVo();
    if (acquisition != null) {
      BeanUtils.copyProperties(acquisition, acquisitionDetailVo);
      String locationStr = acquisition.getAcquisitionCoordinate();
      JSONObject jsonObject = JSONObject.parseObject(locationStr);
      Double longitude = jsonObject.getDouble("Longitude");
      Double latitude = jsonObject.getDouble("latitude");
      acquisitionDetailVo.setLatitude(latitude);
      acquisitionDetailVo.setLongitude(longitude);
      return JsonResVo.buildSuccess(acquisitionDetailVo);
    } else {
      return JsonResVo.buildFail(ErrorEnum.USER_NOT_EXIST);
    }
  }

  /**
   * 查询首页套餐
   */
  @RequestMapping(value = "/query/topPackage", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryTopPackage() {

    logger.info("客户端查询首页推荐套餐");

    List<PackageBaseVo> result = packageService.getTopPackage();
    return JsonResVo.buildSuccess(result);
  }

  /**
   * 查询首页banner
   */
  @RequestMapping(value = "/query/topBanner", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryTopBanner() {

    logger.info("客户端查询首页banner");

    List<AppletBanner> banners = bannerService.GetBannerByFieldOrType(BannerConstants.BANNER_FIELD_USER_HOME, null);
    return JsonResVo.buildSuccess(bannerService.GetTopBannerVo(banners));
  }

  /**
   * 查询套餐
   */
  @RequestMapping(value = "/query/packageNew", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPackageNew(QueryPackageReq req) {

    logger.info("客户端查询套餐列表新 " + req.toString());

    List<PackageBaseVo> result = packageService
        .getPackageByPurposeByPageNew(req.getPurposeId(), req.getPopulationId(), req.getCatalogId(), req.getSourceId(), req.getSourceName(), req.getQueryParam(), req.getPageNo(), req.getPageSize());
    return JsonResVo.buildSuccess(result);
  }

  /**
   * 查询套餐
   */
  @RequestMapping(value = "/query/catalogNew", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryCatalogNew() {

    logger.info("客户端查询所有科室新");

    return JsonResVo.buildSuccess(catalogService.getAllCatalogNew());
  }

  /**
   * 查询套餐详细信息
   */
  @RequestMapping(value = "/query/packageByIdNew", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPackageByIdNew(@RequestParam String packageId) {

    logger.info("客户端查询套餐详情新 " + packageId);

    PackageDetailVo result = packageService.getPackageByIdNew(packageId);
    return JsonResVo.buildSuccess(result);
  }

  /**
   * 新查询检查目的
   */
  @RequestMapping(value = "/query/purposesNew", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPurposeNew() {

    logger.info("新客户端查询检验目列表");
    List<SourceCatalogPurposeListVo> result = sourceService.getAllSource2Purpose();
    logger.info("新客户端查询检验目列表结果: " + result);
    return JsonResVo.buildSuccess(result);
  }

  /**
   * 新查询套餐
   */
  @RequestMapping(value = "/query/packageByFilter", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPackageByFilter(QueryPackageReq req) {

    logger.info("客户端根据检验目的过滤器查询套餐列表 " + req.toString());
//        List<PackageListForShulanVo> result = packageService.getPackageByFilter(req.getPurposeId(),req.getSourceId(),req.getQueryParam(),req.getPageNo(),req.getPageSize());
    List<PackageBaseVo> packageBaseVoList = packageService.getPackageByPurposeByPageNew(null, null, null, req.getSourceId(), null, req.getQueryParam(), req.getPageNo(), req.getPageSize());
    List<PackageListForShulanVo> result = new ArrayList<>();
    int recommendNum = 0;
    int priority = 0;
    for (PackageBaseVo packageBaseVo : packageBaseVoList) {
      PackageListForShulanVo shulanVo = new PackageListForShulanVo();
      recommendNum = NumberUtils.null2num(packageBaseVo.getPackageRecommendation());
      priority = NumberUtils.null2num(packageBaseVo.getPackagePriority());
//            if (packageBaseVo.getPackageSourceId().equals(PackageConstants.SOURCE_TYPE_SHULAN)){
//                shulanVo.setPackageRecommendationNum(60+recommendNum);
//            } else if (packageBaseVo.getPackageSourceId().equals(PackageConstants.SOURCE_TYPE_TCLAB)){
////                shulanVo.setPackageRecommendationNum(10*(5-priority+1)+recommendNum);
//                shulanVo.setPackageRecommendationNum(10*(5-priority+1)+recommendNum);
//            } else {
//                shulanVo.setPackageRecommendationNum(recommendNum);
//            }
//            int recommendNum = NumberUtils.null2num(result.getPackageRecommendation());
//            int priority = NumberUtils.null2num(result.getPackagePriority());
      shulanVo.setPackageRecommendationNum(
          60 + priority + recommendNum + Integer.valueOf(packageBaseVo.getPackageId().substring(packageBaseVo.getPackageId().length() - 2, packageBaseVo.getPackageId().length())));

      shulanVo.setPackageCurrentPrice(packageBaseVo.getPackageCurrentPrice());
      shulanVo.setPackageId(packageBaseVo.getPackageId());
      shulanVo.setPackageName(packageBaseVo.getPackageName());
      shulanVo.setPackageRemark(packageBaseVo.getPackageRemark());
      shulanVo.setPackageSpecialRequirement(packageBaseVo.getPackageSpecialRequirement());
      shulanVo.setSourceId(packageBaseVo.getPackageSourceId());
      shulanVo.setPackageLabel(packageBaseVo.getPackageLabel());
      shulanVo.setClinicalSignificance(packageBaseVo.getClinicalSignificance());
      result.add(shulanVo);
    }
    logger.info("客户端根据检验目的过滤器查询套餐列表结果: " + result.size());
    return JsonResVo.buildSuccess(result);
  }

  @RequestMapping(value = "/query/packageSourceByPackageId", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPackageSourceByPackageId(@RequestParam String packageId) {

    logger.info("查询套餐来源 " + packageId);
    if (StringUtils.isBlank(packageId)) {
      return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(), "套餐编号为空");
    }
    AppletPackage appletPackage = packageService.getPackageById(packageId);
    logger.info("查询套餐来源结果: " + appletPackage);
    return JsonResVo.buildSuccess(appletPackage.getPackageSourceId());
  }


  @RequestMapping(value = "/query/tag", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryTag(@RequestParam String sourceId) {
    List<AppletPackageTag> tagList = tagService.getPackageTagListBySource(sourceId);
    return JsonResVo.buildSuccess(tagList);
  }

  @RequestMapping(value = "/query/packageByTag", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryPackageByTag(QueryPackageReq req) {
    logger.info("客户端根据标签查询套餐 " + req);
    List<AppletPackage> packageList = packageService.getPackageByTag(req.getTagId(), req.getQueryParam());
    logger.info("客户端根据标签查询套餐结果长度" + packageList.size());
    List<PackageListForShulanVo> result = new ArrayList<>();
    for (AppletPackage packageBaseVo : packageList) {
      PackageListForShulanVo shulanVo = new PackageListForShulanVo();
      shulanVo.setPackageRecommendationNum(packageBaseVo.getPackageRecommendation());
      shulanVo.setPackageCurrentPrice(packageBaseVo.getPackageCurrentPrice());
      shulanVo.setPackageId(packageBaseVo.getPackageId());
      shulanVo.setPackageName(packageBaseVo.getPackageName());
      shulanVo.setPackageRemark(packageBaseVo.getPackageRemark());
      shulanVo.setPackageSpecialRequirement(packageBaseVo.getPackageSpecialRequirement());
      shulanVo.setSourceId(packageBaseVo.getPackageSourceId());
      result.add(shulanVo);
    }
    return JsonResVo.buildSuccess(result);
  }

  @RequestMapping(value = "/create/miniqrQr", method = RequestMethod.POST)
  @ResponseBody
  public JsonResVo miniqrQr(QrReq qrReq) throws Exception {
    logger.info("客户端生成小程序码参数 " + qrReq);
    WxTencentUtils wxTencentUtils = new WxTencentUtils();
    String data = qrReq.getPackageIds() + "+" + qrReq.getAcquisitionId();
    data = Aes.aesEncrypt(data).replaceAll("\\+","\\-");
    wxTencentUtils.getminiqrQr(data, qrReq.getFileName());
    return JsonResVo.buildSuccess(data);
  }

  @RequestMapping(value = "/query/qrInfo", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryQrInfo(@RequestParam String data) {
    logger.info("客户端用id查询套餐详情 " + data);
    data = Aes.aesDecrypt(data.replaceAll("\\-","\\+"));
    int index = data.indexOf("+");
    List<String> pIdsStringList = Arrays.asList(data.substring(0, index).split(","));
    List<Integer> pIdsList = new ArrayList<>();
    for (String s : pIdsStringList) {
      pIdsList.add(Integer.parseInt(s));
    }
    List<AppletPackage> packageList = packageService.getPackageByIds(pIdsList);
    List<String> aIdsStringList = Arrays.asList(data.substring(index + 1, data.length()).split(","));
    List<Integer> aIdsList = new ArrayList<>();
    for (String s : aIdsStringList) {
      aIdsList.add(Integer.parseInt(s));
    }
    List<AppletAcquisition> acquisitionList = acquisitionService.getAcquisitionByIds(aIdsList);
    Map<String, Object> result = new HashMap<>();
    result.put("packages", packageList);
    result.put("acquisition", acquisitionList);
    return JsonResVo.buildSuccess(result);
  }

}
