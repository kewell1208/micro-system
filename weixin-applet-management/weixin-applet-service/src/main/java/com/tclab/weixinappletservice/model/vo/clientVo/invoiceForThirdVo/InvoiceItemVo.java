package com.tclab.weixinappletservice.model.vo.clientVo.invoiceForThirdVo;

public class InvoiceItemVo {

    /***
     * 商品名称
     * 如fphxz=1，则此商品⾏为折扣⾏，此版本折扣⾏不允许多⾏折扣，折扣⾏必须紧邻被折扣⾏，项⽬名称必须与被折扣⾏⼀致
     * 是否必填：必填
     */
    private String goodsname;
    /**
     * 数量；
     * 数量、单价必须都不填，或者都必填，不可只填⼀个；
     * 当数量、单价都不填时，不含税⾦额、税额、含税⾦额都必填。
     * 建议保留⼩数点后8位。
     * 医疗检验服务费选择都不填，填写不含税⾦额、税额、含税⾦额
     * 是否必填：不必填
     */
    private String num;
    /**
     * 单价；
     * 数量、单价必须都不填，或者都必填，不可只填⼀个；
     * 当数量、单价都不填时，不含税⾦额、税额、含税⾦额都必填。
     * 建议保留⼩数点后8位。
     * 医疗检验服务费选择都不填，填写不含税⾦额、税额、含税⾦额
     * 是否必填：不必填
     */
    private String price;
    /**
     * 单价含税标志
     * 0表示不含税；1表示含税
     * 是否必填：必填
     */
    private String hsbz;
    /**
     * 税率
     * 是否必填：必填
     */
    private String taxrate;
    /**
     * 规格型号
     * 是否必填：不必填
     */
    private String spec;
    /**
     * 单位
     * 是否必填：不必填
     */
    private String unit;
    /**
     * 税收分类编码
     * 签订免责协议客户可不传⼊，由接⼜进⾏匹配，如对接⼜速度敏感的企业，建议传⼊该字段
     * 是否必填：必填
     */
    private String spbm;
    /**
     * 自行编码
     * 是否必填：不必填
     */
    private String zsbm;
    /**
     * 发票⾏性质:
     * 0,正常⾏;1,折扣⾏;2,被折扣⾏
     * 是否必填：必填
     */
    private String fphxz;
    /**
     * 优惠政策标识:
     * 0,不使⽤;1,使⽤
     * 是否必填：不必填
     */
    private String yhzcbs;
    /**
     * 增值税特殊管理，
     * 如：即征即退、免税、简易征收等
     * 当yhzcbs为1时，此项必填
     * 是否必填：不必填
     */
    private String zzstsgl;
    /**
     * 零税率标识:
     * 空,⾮零税率;1,免税;2,不征税;3,普通零税率
     * 是否必填：不必填
     */
    private String lslbs;
    /**
     * 扣除额，
     * ⼩数点后两位。差额征收的发票⽬前只⽀持⼀⾏明细。
     * 不含税差额 = 不含税⾦额 - 扣除额；
     * 税额 = 不含税差额*税率
     * 是否必填：不必填
     */
    private String kce;
    /**
     * 不含税⾦额
     * 精确到⼩数点后⾯两位，
     * 红票为负。
     * 不含税⾦额、税额、含税⾦额任何⼀个不传时，会根据传⼊的单价，数量进⾏计算，可能和实际数值存在误差，建议都传⼊
     * 是否必填：不必填
     */
    private String taxfreeamt;
    /**
     * 税额
     * 精确到⼩数点后⾯两位，
     * 红票为负。
     * 不含税⾦额、税额、含税⾦额任何⼀个不传时，会根据传⼊的单价，数量进⾏计算，可能和实际数值存在误差，建议都传⼊
     * 是否必填：不必填
     */
    private String tax;
    /**
     * 含税⾦额
     * 精确到⼩数点后⾯两位，
     * 红票为负。
     * 不含税⾦额、税额、含税⾦额任何⼀个不传时，会根据传⼊的单价，数量进⾏计算，可能和实际数值存在误差，建议都传⼊
     * 是否必填：不必填
     */
    private String taxamt;

    @Override
    public String toString() {
        return "InvoiceItemVo{" +
                "goodsname='" + goodsname + '\'' +
                ", num='" + num + '\'' +
                ", price='" + price + '\'' +
                ", hsbz='" + hsbz + '\'' +
                ", taxrate='" + taxrate + '\'' +
                ", spec='" + spec + '\'' +
                ", unit='" + unit + '\'' +
                ", spbm='" + spbm + '\'' +
                ", zsbm='" + zsbm + '\'' +
                ", fphxz='" + fphxz + '\'' +
                ", yhzcbs='" + yhzcbs + '\'' +
                ", zzstsgl='" + zzstsgl + '\'' +
                ", lslbs='" + lslbs + '\'' +
                ", kce='" + kce + '\'' +
                ", taxfreeamt='" + taxfreeamt + '\'' +
                ", tax='" + tax + '\'' +
                ", taxamt='" + taxamt + '\'' +
                '}';
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHsbz() {
        return hsbz;
    }

    public void setHsbz(String hsbz) {
        this.hsbz = hsbz;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpbm() {
        return spbm;
    }

    public void setSpbm(String spbm) {
        this.spbm = spbm;
    }

    public String getZsbm() {
        return zsbm;
    }

    public void setZsbm(String zsbm) {
        this.zsbm = zsbm;
    }

    public String getFphxz() {
        return fphxz;
    }

    public void setFphxz(String fphxz) {
        this.fphxz = fphxz;
    }

    public String getYhzcbs() {
        return yhzcbs;
    }

    public void setYhzcbs(String yhzcbs) {
        this.yhzcbs = yhzcbs;
    }

    public String getZzstsgl() {
        return zzstsgl;
    }

    public void setZzstsgl(String zzstsgl) {
        this.zzstsgl = zzstsgl;
    }

    public String getLslbs() {
        return lslbs;
    }

    public void setLslbs(String lslbs) {
        this.lslbs = lslbs;
    }

    public String getKce() {
        return kce;
    }

    public void setKce(String kce) {
        this.kce = kce;
    }

    public String getTaxfreeamt() {
        return taxfreeamt;
    }

    public void setTaxfreeamt(String taxfreeamt) {
        this.taxfreeamt = taxfreeamt;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTaxamt() {
        return taxamt;
    }

    public void setTaxamt(String taxamt) {
        this.taxamt = taxamt;
    }
}
