package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package：com.tclab.wxmabackapi.model.apiVo
 * @Class：AcquisitionStaffDetailVo
 * @Description： TODO
 * @Author：yuzh
 * @Date：Created in 2019/4/8 14:27
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "AcquisitionStaffPageVo",description = "JsonResNewVo泛型")
public class AcquisitionStaffPageVo {

    @ApiModelProperty(value = "总页数",required = true)
    private Integer pageNum;
    @ApiModelProperty(value = "总员工数",required = true)
    private Long staffNum;
    @ApiModelProperty(value = "当前页数",required = true)
    private Integer currentPageNo;
    @ApiModelProperty(value = "员工列表",required = true)
    private List<AcquisitionStaffListVo> staffListVoList = new ArrayList<>();
}
