package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "InvoiceInfoVo",description = "JsonResNewVo泛型")
public class InvoiceInfoVo {

    @ApiModelProperty(value = "工单号",required = true)
    private String applyId;
    @ApiModelProperty(value = "申请日期",required = true)
    private String applyDate;
    @ApiModelProperty(value = "申请状态",required = true)
    private Integer dealStatus;
    @ApiModelProperty(value = "客户ID",required = true)
    private String userId;
    @ApiModelProperty(value = "客户手机",required = true)
    private String userPhone;
    @ApiModelProperty(value = "客户名",required = true)
    private String userName;
    @ApiModelProperty(value = "文件地址",required = true)
    private String invoiceUrl;
    @ApiModelProperty(value = "接收手机",required = true)
    private String receivePhone;
    @ApiModelProperty(value = "接收电子邮件地址",required = true)
    private String emailAddress;
    @ApiModelProperty(value = "发票类型",required = true)
    private Integer invoiceType;
    @ApiModelProperty(value = "发票金额",required = true)
    private BigDecimal invoiceAmount;
    @ApiModelProperty(value = "抬头类型",required = true)
    private Integer titleType;
    @ApiModelProperty(value = "抬头名称",required = true)
    private String titleName;
    @ApiModelProperty(value = "发票内容",required = true)
    private String invoiceContent;
    @ApiModelProperty(value = "税号",required = true)
    private String taxpayerId;
    @ApiModelProperty(value = "邮寄接收人姓名",required = true)
    private String sendName;
    @ApiModelProperty(value = "邮寄接收人地址",required = true)
    private String sendAddress;
    @ApiModelProperty(value = "邮寄接收人手机",required = true)
    private String sendPhone;
    @ApiModelProperty(value = "开户银行",required = true)
    private String bank;
    @ApiModelProperty(value = "开户银行账户",required = true)
    private String accountId;
    @ApiModelProperty(value = "包含订单数",required = true)
    private Integer orderNum;
    @ApiModelProperty(value = "发票联个人或企业地址",required = true)
    private String companyAddress;
    @ApiModelProperty(value = "发票联个人或企业电话",required = true)
    private String companyPhone;
    @ApiModelProperty(value = "包含订单",required = true)
    private List<OrderAmountListVo> orderAmountListVoList = new ArrayList<>();
}
