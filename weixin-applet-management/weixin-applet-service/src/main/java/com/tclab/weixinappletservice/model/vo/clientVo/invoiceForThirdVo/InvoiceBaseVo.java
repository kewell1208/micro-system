package com.tclab.weixinappletservice.model.vo.clientVo.invoiceForThirdVo;

import java.util.List;

public class InvoiceBaseVo {
    /**
     * 购⽅名称
     * 是否必填：必填
     */
    private String buyername;
    /**
     * 购⽅税号
     * 企业要填，个⼈可为空
     * 是否必填：不必填
     */
    private String taxnum;
    /**
     * 购⽅⼿机
     * 开票成功会短信提醒购⽅
     * 是否必填：必填
     */
    private String phone;
    /**
     * 购⽅地址
     * 企业要填，个⼈可为空
     * 是否必填：不必填
     */
    private String address;
    /**
     * 购⽅银⾏账号
     * 企业要填，个⼈可为空
     * 是否必填：不必填
     */
    private String account;
    /**
     * 购⽅固定电话
     * 是否必填：不必填
     */
    private String telephone;
    /**
     * 订单号
     * 每个企业唯⼀
     * 是否必填：必填
     */
    private String orderno;
    /**
     * 开票时间
     * 时间格式：2016-01-13 12:30:00
     * 是否必填：必填
     */
    private String invoicedate;
    /**
     * 开票员
     * 是否必填：必填
     */
    private String clerk;
    /**
     * 销⽅银⾏账号
     * 是否必填：不必填
     */
    private String saleaccount;
    /**
     * 销⽅电话
     * 是否必填：必填
     */
    private String salephone;
    /**
     * 销⽅地址
     * 是否必填：必填
     */
    private String saleaddress;
    /**
     * 销⽅税号
     * 是否必填：必填
     */
    private String saletaxnum;
    /**
     * 开票类型:
     * 1,正票;2,红票
     * 是否必填：必填
     */
    private String kptype;
    /**
     * 备注
     * 冲红时，必须在备注中注明“对应正数发票代码:XXXXXXXXX号码:YYYYYYYY”⽂案，其中“X”为发票代码， “Y”为发票号码，否则接⼝会⾃动添加该⽂案
     * 是否必填：不必填
     */
    private String message;
    /**
     * 收款⼈
     * 是否必填：不必填
     */
    private String payee;
    /**
     * 复核⼈
     * 是否必填：不必填
     */
    private String checker;
    /**
     * 对应蓝票发票代码
     * 红票必填，不满12位请左补0
     * 是否必填：不必填
     */
    private String fpdm;
    /**
     * 对应蓝票发票号码
     * 红票必填，不满8位请左补0
     * 是否必填：不必填
     */
    private String fphm;
    /**
     * 推送⽅式:
     * -1,不推送;0,邮箱;1,⼿机(默认);2,邮箱、⼿机
     * 是否必填：不必填
     */
    private String tsfs;
    /**
     * 推送邮箱
     * tsfs为 0或 2时，此项为必填
     * 是否必填：不必填
     */
    private String email;
    /**
     * 清单标志:
     * 0,根据项⽬名称数，⾃动产⽣清单;1,将项⽬信息打印⾄清单
     * 默认为0 卷票r不⽀持清单
     * 是否必填：不必填
     */
    private String qdbz;
    /**
     * 清单项⽬名称:
     * 打印清单时对应发票票⾯项⽬名称 ，
     * qdbz为1是，此项为必填
     * 注意：税总要求清单项⽬名称为（详⻅销货清单）
     * 是否必填：不必填
     */
    private String qdxmmc;
    /**
     * 代开标志:
     * 0⾮代开;1代开。
     * 默认为0
     * 代开蓝票备注⽂案要求包含：代开企业税号:***,代开企业名称:***；代开红票备注⽂案要求：对应正数发票代码:***号码:***代开企业税号:***代开企业名称:***。
     * 是否必填：不必填
     */
    private String dkbz;
    /**
     * 部⻔⻔店id（诺诺系统中的id）
     * 是否必填：不必填
     */
    private String deptid;
    /**
     * 开票员id（诺诺系统中的id）
     * 是否必填：不必填
     */
    private String clerkid;
    /**
     * 发票种类，
     * p电⼦增值税普通发票， c增值税普通发票(纸票)， s增值税专⽤发票， e收购发票(电⼦)， f收购发票(纸质)， r增值税普通发票(卷式)
     * 默认为电票p。卷票r只⽀持13⾏明细。
     * 是否必填：不必填
     */
    private String invoiceLine;
    /**
     * 成品油标志：
     * 0⾮成品油， 1成品油
     * 默认为0⾮成品油
     * 是否必填：不必填
     */
    private String cpybz;
    /**
     * 红字信息表编号
     * 专票冲红时，此项必填。且必须在备注中注明“开具红字增值税专⽤发票信息表编号ZZZZZZZZZZZZZZZZ”字样，其中“Z”为开具红字增值税专⽤发票所需要的⻓度为16位信息表编号。
     * 是否必填：不必填
     */
    private String billInfoNo;
    /**
     * 电⼦发票明细
     * 是否必填：必填
     */
    private List<InvoiceItemVo> detail;

    @Override
    public String toString() {
        return "InvoiceBaseVo{" +
                "buyername='" + buyername + '\'' +
                ", taxnum='" + taxnum + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", account='" + account + '\'' +
                ", telephone='" + telephone + '\'' +
                ", orderno='" + orderno + '\'' +
                ", invoicedate='" + invoicedate + '\'' +
                ", clerk='" + clerk + '\'' +
                ", saleaccount='" + saleaccount + '\'' +
                ", salephone='" + salephone + '\'' +
                ", saleaddress='" + saleaddress + '\'' +
                ", saletaxnum='" + saletaxnum + '\'' +
                ", kptype='" + kptype + '\'' +
                ", message='" + message + '\'' +
                ", payee='" + payee + '\'' +
                ", checker='" + checker + '\'' +
                ", fpdm='" + fpdm + '\'' +
                ", fphm='" + fphm + '\'' +
                ", tsfs='" + tsfs + '\'' +
                ", email='" + email + '\'' +
                ", qdbz='" + qdbz + '\'' +
                ", qdxmmc='" + qdxmmc + '\'' +
                ", dkbz='" + dkbz + '\'' +
                ", deptid='" + deptid + '\'' +
                ", clerkid='" + clerkid + '\'' +
                ", invoiceLine='" + invoiceLine + '\'' +
                ", cpybz='" + cpybz + '\'' +
                ", billInfoNo='" + billInfoNo + '\'' +
                ", detail=" + detail +
                '}';
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public String getTaxnum() {
        return taxnum;
    }

    public void setTaxnum(String taxnum) {
        this.taxnum = taxnum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getInvoicedate() {
        return invoicedate;
    }

    public void setInvoicedate(String invoicedate) {
        this.invoicedate = invoicedate;
    }

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

    public String getSaleaccount() {
        return saleaccount;
    }

    public void setSaleaccount(String saleaccount) {
        this.saleaccount = saleaccount;
    }

    public String getSalephone() {
        return salephone;
    }

    public void setSalephone(String salephone) {
        this.salephone = salephone;
    }

    public String getSaleaddress() {
        return saleaddress;
    }

    public void setSaleaddress(String saleaddress) {
        this.saleaddress = saleaddress;
    }

    public String getSaletaxnum() {
        return saletaxnum;
    }

    public void setSaletaxnum(String saletaxnum) {
        this.saletaxnum = saletaxnum;
    }

    public String getKptype() {
        return kptype;
    }

    public void setKptype(String kptype) {
        this.kptype = kptype;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getFpdm() {
        return fpdm;
    }

    public void setFpdm(String fpdm) {
        this.fpdm = fpdm;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public String getTsfs() {
        return tsfs;
    }

    public void setTsfs(String tsfs) {
        this.tsfs = tsfs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQdbz() {
        return qdbz;
    }

    public void setQdbz(String qdbz) {
        this.qdbz = qdbz;
    }

    public String getQdxmmc() {
        return qdxmmc;
    }

    public void setQdxmmc(String qdxmmc) {
        this.qdxmmc = qdxmmc;
    }

    public String getDkbz() {
        return dkbz;
    }

    public void setDkbz(String dkbz) {
        this.dkbz = dkbz;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getClerkid() {
        return clerkid;
    }

    public void setClerkid(String clerkid) {
        this.clerkid = clerkid;
    }

    public String getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(String invoiceLine) {
        this.invoiceLine = invoiceLine;
    }

    public String getCpybz() {
        return cpybz;
    }

    public void setCpybz(String cpybz) {
        this.cpybz = cpybz;
    }

    public String getBillInfoNo() {
        return billInfoNo;
    }

    public void setBillInfoNo(String billInfoNo) {
        this.billInfoNo = billInfoNo;
    }

    public List<InvoiceItemVo> getDetail() {
        return detail;
    }

    public void setDetail(List<InvoiceItemVo> detail) {
        this.detail = detail;
    }
}
