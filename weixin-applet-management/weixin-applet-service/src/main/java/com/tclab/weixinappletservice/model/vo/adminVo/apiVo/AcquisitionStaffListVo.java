package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Package：com.tclab.wxmabackapi.model.apiVo
 * @Class：AcquisitionStaffListVo
 * @Description： TODO
 * @Author：yuzh
 * @Date：Created in 2019/4/8 14:25
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "AcquisitionStaffListVo",description = "JsonResNewVo泛型")
public class AcquisitionStaffListVo {

    private Integer id;
    @ApiModelProperty(value = "员工编号",required = true)
    private String staffId;
    @ApiModelProperty(value = "员工姓名",required = true)
    private String staffName;
    @ApiModelProperty(value = "手机号",required = true)
    private String staffPhone;
    @ApiModelProperty(value = "员工类型",required = true)
    private Integer staffType;
    @ApiModelProperty(value = "性别",required = false)
    private Integer staffSex;
    @ApiModelProperty(value = "注册时间",required = true)
    private Date createDate;
}
