package com.tclab.weixinappletadminclient.controller;

import com.tclab.weixinappletadminclient.model.req.*;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.constant.RedisConstants;
import com.tclab.weixinappletcommon.constant.SampleTypeEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.EditPackageReqVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.PackagePageVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.QueryPackageReqVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.TagVo;
import com.tclab.weixinappletservice.pojo.AppletPackage;
import com.tclab.weixinappletservice.pojo.AppletPackageCatalog;
import com.tclab.weixinappletservice.pojo.AppletPackagePurpose;
import com.tclab.weixinappletservice.pojo.AppletPackageSub;
import com.tclab.weixinappletservice.service.adminService.AdminPackageService;
import com.tclab.weixinappletservice.service.adminService.AdminSourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Package：com.tclab.wxmabackapi.controller
 * @Class：PackageController
 * @Description： TODO
 * @Author：yuzh
 * @Date：Created in 2019/4/3 14:05
 * @Company:
 * @Version：
 * @Modified By:
 */
@Api(description = "套餐管理模块",tags = "后台-套餐管理")
@RestController
@RequestMapping(value = "/back/package")
public class PackageController {

    private static final Logger logger = LoggerFactory.getLogger(PackageController.class);

    @Autowired
    private AdminPackageService adminPackageService;
    @Autowired
    private AdminSourceService adminSourceService;
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "查询套餐列表" ,  notes="套餐列表")
    @RequestMapping(value="/queryList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<PackagePageVo> queryPackageList(@ApiParam(name="QueryPackageReq",value="套餐查询参数",required=true) QueryPackageReq req){
        logger.info("后台查询套餐列表: "+ req.toString());

        QueryPackageReqVo reqVo = new QueryPackageReqVo();
        BeanUtils.copyProperties(req,reqVo);

        PackagePageVo packagePageVo = adminPackageService.getPackagePageVoByQueryReqNew(reqVo);
        return JsonResNewVo.buildSuccess(packagePageVo);
    }

    @ApiOperation(value = "查询套餐详情" ,  notes="查询套餐详情")
    @ApiImplicitParam(paramType = "path",name = "packageId", value = "套餐Id", required = true, dataType = "String")
    @RequestMapping(value="/queryDetail", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<AppletPackage> queryPackageDetail(@RequestParam String packageId){
        logger.info("后台查询套餐详情: "+ packageId);
        if (StringUtils.isBlank(packageId)){
            return JsonResNewVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"套餐编号为空");
        }
        return JsonResNewVo.buildSuccess(adminPackageService.getPackageById(packageId));
    }

    @ApiOperation(value = "编辑套餐" ,  notes="新编辑套餐页面")
    @RequestMapping(value="/editPackageNew", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo editPackage(@RequestBody @ApiParam(name="editPackageReq",value="编辑套餐参数",required=true) EditPackageReq req){
        logger.info("后台套餐编辑: " + req.toString());
        EditPackageReqVo reqVo = new EditPackageReqVo();
        BeanUtils.copyProperties(req,reqVo);
        if (StringUtils.isNotBlank(req.getPackageId())) {
            return JsonResVo.buildSuccess(adminPackageService.editPackageNew(reqVo));
        } else {
            return JsonResVo.buildSuccess(adminPackageService.insertPackage(reqVo));
        }
    }

    @ApiOperation(value = "查询套餐编辑信息" ,  notes="新套餐详情编辑页面")
    @RequestMapping(value="/editPackageInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo editPackageInfo(@ApiParam(name="QueryPackageReq",value="套餐查询参数",required=true) QueryPackageReq req){
        logger.info("后台查询套餐编辑信息: " + req.toString());
        if (StringUtils.isBlank(req.getPackageId())) {
            logger.info("套餐ID为空");
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"套餐ID为空");
        }
        return JsonResVo.buildSuccess(adminPackageService.getPackageEditInfoById(req.getPackageId()));
    }

    @ApiOperation(value = "停用套餐" ,  notes="停用套餐")
//    @ApiImplicitParam(paramType = "path",name = "packageIds", value = "套餐Id", required = true, dataType = "Array")
    @RequestMapping(value="/stopPackage", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResNewVo stopPackage(@RequestBody @ApiParam(name="stopReq",value="停用套餐参数",required=true) StopReq req){
        logger.info("停用套餐: "+ req.getPackageIds());
        if (req.getPackageIds() == null || req.getPackageIds().size() == 0){
            return JsonResNewVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"套餐编号为空");
        }
        return JsonResNewVo.buildSuccess(adminPackageService.stopPackage(req.getPackageIds(),req.getStatus()));
    }

    @ApiOperation(value = "查询科室" ,  notes="查询科室")
    @RequestMapping(value="/queryCatalog", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryCatalog(@ApiParam(name="queryCatalogAndPurposeReq",value="查询科室目的参数",required=true) QueryCatalogAndPurposeReq req){
        logger.info("后台查询科室: " + req.toString());
        return JsonResVo.buildSuccess(adminPackageService.queryCatalogList(req.getSourceId()));
    }

    @ApiOperation(value = "查询检验目的" ,  notes="查询检验目的(疾病)")
    @RequestMapping(value="/queryPurpose", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryPurpose(@ApiParam(name="queryCatalogAndPurposeReq",value="查询科室目的参数",required=true) QueryCatalogAndPurposeReq req){
        logger.info("后台查询检验目的: " + req.toString());
        return JsonResVo.buildSuccess(adminPackageService.queryPurposeList(req.getCatalogId()));
    }

    @ApiOperation(value = "编辑科室" ,  notes="编辑科室")
    @RequestMapping(value="/editCatalog", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo editCatalog(@RequestBody @ApiParam(name="ditCatalogAndPurposeReq",value="查询科室目的参数",required=true) EditCatalogAndPurposeReq req){
        logger.info("后台编辑科室: " + req.toString());
        AppletPackageCatalog obj = new AppletPackageCatalog();
        BeanUtils.copyProperties(req,obj);
        return JsonResVo.buildSuccess(adminPackageService.editCatalog(obj));
    }

    @ApiOperation(value = "编辑检验目的" ,  notes="编辑检验目的")
    @RequestMapping(value="/editPurpose", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo editPurpose(@RequestBody @ApiParam(name="ditCatalogAndPurposeReq",value="查询科室目的参数",required=true) EditCatalogAndPurposeReq req){
        logger.info("后台编辑检验目的: " + req.toString());
        AppletPackagePurpose obj = new AppletPackagePurpose();
        BeanUtils.copyProperties(req,obj);
        return JsonResVo.buildSuccess(adminPackageService.editPurpose(obj));
    }

    @ApiOperation(value = "查询分类标签" ,  notes="查询分类标签")
    @RequestMapping(value="/queryTag", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryTag(@ApiParam(name="queryCatalogAndPurposeReq",value="查询参数",required=true) QueryCatalogAndPurposeReq req){
        logger.info("后台查询科室: " + req.toString());
        return JsonResVo.buildSuccess(adminPackageService.queryTagList(req.getSourceId()));
    }

    @ApiOperation(value = "编辑分类标签" ,  notes="编辑分类标签")
    @RequestMapping(value="/editTag", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo editTag(@RequestBody @ApiParam(name="TagVo",value="标签基本参数",required=true) TagVo req){
        logger.info("后台编辑分类标签: " + req.toString());
        AppletPackageCatalog obj = new AppletPackageCatalog();
        BeanUtils.copyProperties(req,obj);
        return JsonResVo.buildSuccess(adminPackageService.editCatalog(obj));
    }

    @ApiOperation(value = "查询样本类型列表" ,  notes="查询样本类型列表")
    @RequestMapping(value="/querySource", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo querySampleType(){
        logger.info("后台查询样本类型");
        return JsonResVo.buildSuccess(SampleTypeEnum.getListVoByDelFlag(false));
    }

    @Transactional
    @ApiOperation(value = "上传浙一格式套餐excel文档" ,  notes="上传浙一格式套餐excel文档")
    @RequestMapping(value = "/uploadZheyiExcel", method = RequestMethod.POST)
    @ResponseBody
    public JsonResVo testUploadZheyiPackageExcel(HttpServletRequest request) {

        logger.info("上传package_excel文档");

        logger.info("文件名");
        StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
        for (Map.Entry<String, MultipartFile> entry:req.getFileMap().entrySet()) {
            logger.info("key------"+entry.getKey());
            logger.info("value------"+entry.getValue());
        }
        MultipartFile excel = req.getFile("file");

        String excelName = excel.getOriginalFilename();
        logger.info("excel名称: "+excel.getOriginalFilename());

        //判断是否是excel文件
        if(!excelName.endsWith(".xls")&&!excelName.endsWith(".xlsx"))
        {
            logger.info(excelName+"文件不是excel类型");
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"上传文件不是excel类型");
        }

        try {
            XSSFWorkbook wb = new XSSFWorkbook(excel.getInputStream());
            XSSFSheet sheet = wb.getSheetAt(0);

            //获取最后一行的行号
            int rowNum = sheet.getLastRowNum() + 1;
            //获取数据源的数据位于工作簿的哪一行开始
            int startRow = 1;

            for (int i = startRow; i < rowNum; i++) {
                //取出每行数据
                XSSFRow row = sheet.getRow(i);
                if(isRowEmpty(row)) {
                    break;
                }

                AppletPackage appletPackage = new AppletPackage();
                List<AppletPackageSub> packageSubList = new ArrayList<>();

                //创建套餐ID
                String packageIdIndexStr;
                Integer packageIdIndex = Integer.parseInt(redisUtils.get(RedisConstants.GENERATEID+":"+RedisConstants.PACKAGE_INDEX));
                if (packageIdIndex!=null){
                    packageIdIndex++;
                    boolean a = redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.PACKAGE_INDEX,packageIdIndex.toString());
                    if (!a){
                        logger.info("后台套餐ID标签自增失败: "+packageIdIndex);
                        return JsonResVo.buildErrorResult(ErrorEnum.SYSTEM_ERROR.getErrorCode(),"后台套餐ID标签自增失败: "+packageIdIndex);
                    }
                    packageIdIndexStr = String.format("%04d", packageIdIndex);
                } else {
                    redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.PACKAGE_INDEX,"1");
                    packageIdIndexStr = String.format("%06d", 1);
                }
                String day = redisUtils.get(RedisConstants.DAY);
                if (day==null){
                    day = DateUtils.formatDayString(new Date());
                }
                String packageId = CommonConstants.GenerateID_PACKAGE+day+packageIdIndexStr;

                appletPackage.setPackageId(packageId);

                //每行数据的第1个单元格数据表示套餐名
                XSSFCell cell0 = row.getCell(0);
                String packageName = cell0.getStringCellValue();
                if (StringUtils.isNotBlank(packageName)){
                    appletPackage.setPackageName(packageName);
                }

                //每行数据的第4个单元格数据表示临床意义
                XSSFCell cell3 = row.getCell(3);
                String clinicalSignificance = cell3.getStringCellValue();
                appletPackage.setClinicalSignificance(clinicalSignificance);

                //每行数据的第5个单元格数据表示套餐来源ID
//                XSSFCell cell4 = row.getCell(4);
//                String packageSourceId = cell4.getStringCellValue();
//                appletPackage.setPackageSourceId(packageSourceId);
                appletPackage.setPackageSourceId("DS201905170003");

                //每行数据的第6个单元格数据表示套餐备注
                XSSFCell cell5 = row.getCell(5);
                String packageRemark = cell5.getStringCellValue();
                appletPackage.setPackageRemark(packageRemark);

                //每行数据的第7，8个单元格数据表示套餐原价和现价
                //如果没有原价就用现价代替
                XSSFCell cell6 = row.getCell(6);
                XSSFCell cell7 = row.getCell(7);

//                Double packagePrimePriceDou = cell6.getNumericCellValue();
//                logger.info("转换获取的原价"+packagePrimePriceDou);
                String packageCurrentPriceDou = cell7.getStringCellValue();
                logger.info("转换获取的现价"+packageCurrentPriceDou);
                String packageCurrentPriceStr = String.valueOf(packageCurrentPriceDou);
                BigDecimal packageCurrentPrice = new BigDecimal(packageCurrentPriceStr);
                logger.info("转换获取的现价"+packageCurrentPrice);
                appletPackage.setPackageCurrentPrice(packageCurrentPrice);
                appletPackage.setPackagePrimePrice(packageCurrentPrice);

                //每行数据的第14个单元格数据表示套餐报告时间表述
                XSSFCell cell13 = row.getCell(13);
                String reportTimeDesc = cell13.getStringCellValue();
                logger.info("套餐报告时间为"+reportTimeDesc);
                appletPackage.setReportTimeDesc(reportTimeDesc);

                //每行数据的第15个单元格数据表示样本名称
                XSSFCell cell14 = row.getCell(14);
                String sampleTypeName = cell14.getStringCellValue();
                logger.info("套餐样本名称为"+sampleTypeName);
                appletPackage.setSampleTypeName(sampleTypeName);

                //每行数据的第16个单元格数据表示样本类型
                XSSFCell cell15 = row.getCell(15);
                String sampleTypeStr = cell15.getStringCellValue();
                if (StringUtils.isNotBlank(sampleTypeStr)) {
                    Integer sampleType = Integer.valueOf(sampleTypeStr);
                    logger.info("套餐样本类型为"+sampleType);
                    appletPackage.setSampleType(sampleType);
                }

                //每行数据的第17个单元格数据表示套餐特殊要求
                XSSFCell cell16 = row.getCell(16);
                String packageSpecialRequirement = cell16.getStringCellValue();
                if (StringUtils.isNotBlank(packageSpecialRequirement)) {
                    logger.info("套餐特殊要求为"+packageSpecialRequirement);
                    appletPackage.setPackageSpecialRequirement(packageSpecialRequirement);
                }

                //每行数据的第18个单元格数据表示套餐耗材
                XSSFCell cell17 = row.getCell(17);
                String packageEquipment = cell17.getStringCellValue();
                if (StringUtils.isNotBlank(packageEquipment)) {
                    logger.info("套餐耗材"+packageEquipment);
                    appletPackage.setPackageEquipment(packageEquipment);
                }

                //每行数据的第19个单元格数据表示套餐存储条件
                XSSFCell cell18 = row.getCell(18);
                String storageCondition = cell18.getStringCellValue();
                if (StringUtils.isNotBlank(storageCondition)) {
                    logger.info("存储条件"+storageCondition);
                    appletPackage.setStorageCondition(storageCondition);
                }

                //每行数据的第21个单元格数据表示实验室分组
                XSSFCell cell20 = row.getCell(20);
                String labGroup = cell20.getStringCellValue();
                if (StringUtils.isNotBlank(labGroup)) {
                    logger.info("实验室分组"+labGroup);
                    appletPackage.setLabGroup(labGroup);
                }

                //每行数据的第22个单元格数据表示物价编码
                XSSFCell cell21 = row.getCell(21);
                String priceCode = cell21.getStringCellValue();
                if (StringUtils.isNotBlank(priceCode)) {
                    logger.info("套餐物价编码为"+priceCode);
                    appletPackage.setPriceCode(priceCode);
                }

                //每行数据的第23个单元格数据表示套餐子项
                XSSFCell cell22 = row.getCell(22);
                String subListStr = cell22.getStringCellValue();

                logger.info("--"+subListStr+"--");

                if (StringUtils.isNotBlank(subListStr)) {
                    String[] subList = subListStr.split(";");

                    for (String s : subList) {
                        logger.info("细项: " + s);
                    }

                    for (String sub : subList) {
                        logger.info(sub);
                        AppletPackageSub packageSub = new AppletPackageSub();
                        packageSub.setSubPackageName(sub);
                        packageSub.setPackageId(packageId);
                        packageSub.setDelFlag(CommonConstants.INIT);
                        packageSub.setUpdateDate(new Date());
                        packageSub.setCreateDate(new Date());
                        packageSubList.add(packageSub);
                    }
                }

                appletPackage.setCreateDate(new Date());
                appletPackage.setUpdateDate(new Date());
                appletPackage.setPackagePriority(6);
                appletPackage.setPackageCollectType(0);
                appletPackage.setPackageStatus(CommonConstants.INIT);
                appletPackage.setPackageReportType(0);
                appletPackage.setPackageReportCharge(BigDecimal.ZERO);
                appletPackage.setDelFlag(CommonConstants.INIT);

                logger.info("appletPackage的转换结果是"+appletPackage);

                boolean check = adminPackageService.insertByObj(appletPackage);
                if (!check){
                    throw new RuntimeException("插入套餐失败");
                }
                if (packageSubList.size()!=0){
                    check = adminPackageService.insertSub(packageSubList);
                    if (!check){
                        throw new RuntimeException("插入子套餐失败");
                    }
                }
            }

        } catch (IOException e){
            logger.info("IO异常");
            throw new RuntimeException("IO异常");
        }

        return JsonResVo.buildSuccess();
    }

    @Transactional
    @ApiOperation(value = "上传树兰格式套餐excel文档" ,  notes="上传树兰格式套餐excel文档")
    @RequestMapping(value = "/uploadShulanExcel", method = RequestMethod.POST)
    @ResponseBody
    public JsonResVo testUploadShulanPackageExcel(HttpServletRequest request) {

        logger.info("上传package_excel文档");

        logger.info("文件名");
        StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
        for (Map.Entry<String, MultipartFile> entry:req.getFileMap().entrySet()) {
            logger.info("key------"+entry.getKey());
            logger.info("value------"+entry.getValue());
        }
        MultipartFile excel = req.getFile("file");

        String excelName = excel.getOriginalFilename();
        logger.info("excel名称: "+excel.getOriginalFilename());

        //判断是否是excel文件
        if(!excelName.endsWith(".xls")&&!excelName.endsWith(".xlsx"))
        {
            logger.info(excelName+"文件不是excel类型");
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"上传文件不是excel类型");
        }

        try {
            XSSFWorkbook wb = new XSSFWorkbook(excel.getInputStream());
            XSSFSheet sheet = wb.getSheetAt(0);

            //获取最后一行的行号
            int rowNum = sheet.getLastRowNum() + 1;
            //获取数据源的数据位于工作簿的哪一行开始
            int startRow = 1;

            for (int i = startRow; i < rowNum; i++) {
                //取出每行数据
                XSSFRow row = sheet.getRow(i);
                if(isRowEmpty(row)) {
                    break;
                }

                AppletPackage appletPackage = new AppletPackage();
                List<AppletPackageSub> packageSubList = new ArrayList<>();

                //创建套餐ID
                String packageIdIndexStr;
                Integer packageIdIndex = Integer.parseInt(redisUtils.get(RedisConstants.GENERATEID+":"+RedisConstants.PACKAGE_INDEX));
                if (packageIdIndex!=null){
                    packageIdIndex++;
                    boolean a = redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.PACKAGE_INDEX,packageIdIndex.toString());
                    if (!a){
                        logger.info("后台套餐ID标签自增失败: "+packageIdIndex);
                        return JsonResVo.buildErrorResult(ErrorEnum.SYSTEM_ERROR.getErrorCode(),"后台套餐ID标签自增失败: "+packageIdIndex);
                    }
                    packageIdIndexStr = String.format("%04d", packageIdIndex);
                } else {
                    redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.PACKAGE_INDEX,"1");
                    packageIdIndexStr = String.format("%06d", 1);
                }
                String day = redisUtils.get(RedisConstants.DAY);
                if (day==null){
                    day = DateUtils.formatDayString(new Date());
                }
                String packageId = CommonConstants.GenerateID_PACKAGE+day+packageIdIndexStr;

                appletPackage.setPackageId(packageId);

                //每行数据的第3个单元格数据表示套餐名
                XSSFCell cell2 = row.getCell(2);
                String packageName = cell2.getStringCellValue();
                if (StringUtils.isNotBlank(packageName)){
                    appletPackage.setPackageName(packageName);
                }

                appletPackage.setPackageSourceId("DS201905170001");
                appletPackage.setPackageSourceName("shulan");

                //每行数据的第4个单元格数据表示套餐原价和现价
                //如果没有原价就用现价代替
                XSSFCell cell3 = row.getCell(3);
                String packageCurrentPriceDou = cell3.getStringCellValue();
                logger.info("转换获取的现价"+packageCurrentPriceDou);
                String packageCurrentPriceStr = String.valueOf(packageCurrentPriceDou);
                BigDecimal packageCurrentPrice = new BigDecimal(packageCurrentPriceStr);
                logger.info("转换获取的现价"+packageCurrentPrice);
                appletPackage.setPackageCurrentPrice(packageCurrentPrice);
                appletPackage.setPackagePrimePrice(packageCurrentPrice);

                //每行数据的第5个单元格数据表示套餐报告时间表述
                XSSFCell cell4 = row.getCell(4);
                String reportTimeDesc = cell4.getStringCellValue();
                logger.info("套餐报告时间为"+reportTimeDesc);
                appletPackage.setReportTimeDesc(reportTimeDesc);

                //每行数据的第6个单元格数据表示样本类型
                XSSFCell cell5 = row.getCell(5);
                String sampleTypeStr = cell5.getStringCellValue();
                if (StringUtils.isNotBlank(sampleTypeStr)) {
                    Integer sampleType = Integer.valueOf(sampleTypeStr);
                    logger.info("套餐样本类型为"+sampleType);
                    appletPackage.setSampleType(sampleType);
                }

                //每行数据的第7个单元格数据表示样本名称
                XSSFCell cell6 = row.getCell(6);
                String sampleTypeName = cell6.getStringCellValue();
                logger.info("套餐样本名称为"+sampleTypeName);
                appletPackage.setSampleTypeName(sampleTypeName);
                appletPackage.setPackageEquipment(sampleTypeName);

                //每行数据的第8个单元格数据表示套餐备注
                XSSFCell cell7 = row.getCell(7);
                String packageRemark = cell7.getStringCellValue();
                if (StringUtils.isNotBlank(packageRemark)) {
                    appletPackage.setPackageRemark(packageRemark);
                    appletPackage.setPackageSpecialRequirement(packageRemark);
                }

                //每行数据的第9个单元格数据表示套餐存储条件
                XSSFCell cell8 = row.getCell(8);
                String storageCondition = cell8.getStringCellValue();
                if (StringUtils.isNotBlank(storageCondition)) {
                    logger.info("存储条件"+storageCondition);
                    appletPackage.setStorageCondition(storageCondition);
                }

                //每行数据的第10个单元格数据表示临床意义
                XSSFCell cell9 = row.getCell(9);
                String clinicalSignificance = cell9.getStringCellValue();
                appletPackage.setClinicalSignificance(clinicalSignificance);

                //每行数据的第11个单元格数据表示实验室分组
                XSSFCell cell10 = row.getCell(10);
                String labGroup = cell10.getStringCellValue();
                if (StringUtils.isNotBlank(labGroup)) {
                    logger.info("实验室分组"+labGroup);
                    appletPackage.setLabGroup(labGroup);
                }

                //每行数据的第12个单元格数据表示物价编码
                XSSFCell cell11 = row.getCell(11);
                String priceCode = cell11.getStringCellValue();
                if (StringUtils.isNotBlank(priceCode)) {
                    logger.info("套餐物价编码为"+priceCode);
                    appletPackage.setPriceCode(priceCode);
                }

                //每行数据的第13个单元格数据表示套餐子项
                XSSFCell cell12 = row.getCell(12);
                String subListStr = cell12.getStringCellValue();

                logger.info("--"+subListStr+"--");

                if (StringUtils.isNotBlank(subListStr)) {
                    String[] subList = subListStr.split(";");

                    for (String s : subList) {
                        logger.info("细项: " + s);
                    }

                    for (String sub : subList) {
                        logger.info(sub);
                        AppletPackageSub packageSub = new AppletPackageSub();
                        packageSub.setSubPackageName(sub);
                        packageSub.setPackageId(packageId);
                        packageSub.setDelFlag(CommonConstants.INIT);
                        packageSub.setUpdateDate(new Date());
                        packageSub.setCreateDate(new Date());
                        packageSubList.add(packageSub);
                    }
                }

                appletPackage.setCreateDate(new Date());
                appletPackage.setUpdateDate(new Date());
                appletPackage.setPackagePriority(3);
                appletPackage.setPackageCollectType(0);
                appletPackage.setPackageStatus(CommonConstants.INIT);
                appletPackage.setPackageReportType(0);
                appletPackage.setPackageReportCharge(BigDecimal.ZERO);
                appletPackage.setDelFlag(CommonConstants.INIT);

                logger.info("appletPackage的转换结果是"+appletPackage);

                boolean check = adminPackageService.insertByObj(appletPackage);
                if (!check){
                    throw new RuntimeException("插入套餐失败");
                }
                if (packageSubList.size()!=0){
                    check = adminPackageService.insertSub(packageSubList);
                    if (!check){
                        throw new RuntimeException("插入子套餐失败");
                    }
                }
            }

        } catch (IOException e){
            logger.info("IO异常");
            throw new RuntimeException("IO异常");
        }

        return JsonResVo.buildSuccess();
    }

    //去除空行
    public static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
                return false;
        }
        return true;
    }
}
