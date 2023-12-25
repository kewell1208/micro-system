package com.tclab.weixinappletservice.model.vo.clientVo.reportLibVo;

public class ThirdSampleInfoVo {

    private String barcode;         //条码号    @@
    private String customBarcode;   //客户条码  @@
    private String sampleType;          //样本类型  血液，尿液 @
    private String testPurposeId;       //检验目的ID @
    private String testPurposeName;     //检验目的名称 @
    private String fee;                  //价格 @
    private String patientAddress;    //病人联系地址 @
    private String patientPhone;        //病人联系方式 @
    private String patientName;         //病人姓名 @
    private String birthday;            //出生日期
    private String age;                 //年龄 @
    private String ageType;             //年龄单位(类型)  //天，周，岁 @
    private String patientIdNumber;    //病人身份证号 @
    private Integer sex;                 //性别   1男，2女 @
    private String requester;           //开单者 @
    private String requestTime;           //开单日期 yyyy-mm-dd 24hh:mi:ss @@
    private String executor;            //采样者 @
    private String executeTime;         //采样时间 @@
    private String receiver;            //接收者 操作人 @ 没有传无同创物流传物流人员
    private String receiveTime;         //接收时间 new Date @@

    private String patientId;       //病人ID，就诊卡号 @
    private String patientFileCode;     //病人唯一号 @
    private String diagnosis;           //诊断  @

    private String testCenter = "J0086571002";      //机构  J0086571002
    private String customId = "K00865710086";        //客户唯一键    @
    private String customName = "诊合联盟小程序";      //客户名称 @
    private Integer stayHospitalMode = 1;    //在院方式 1.门诊 ，2住院 3体检 @

    private String departmentCode;      //病人就诊科室代码
    private String department;          //病人就诊科室
    private String wardCode;            //住院病人病区代码
    private String wardName;            //住院病人病区名称
    private String bedNo;               //床号
    private Integer cycle;               //生理周期
    private String part;                //采集部位
    private String note;                //备注
    private String labDepartment;       //执行科室
    private String labDepartmentCode;   //执行科室代码
    private Integer sampleStatus;           //样本状态
    private String tester;               //检验者
    private String digCode;              //住院开单诊疗小组代码
    private String testItemIds;         //检验项目ID列表，多个用逗号分隔
    private String preBarCode ;         //预制条码
    private String checker;            //报告者
    private String checkTime;         //报告时间
    private String ksreceivetime;     //第三方接收时间
    private String ksreceiver;      //第三方接收人
    private Integer feeStatus;          //计费状态
    private Integer requestMode;        //平急诊
    private String sender;           //发送者
    private String sendTime;         //发送时间
    private String testType;        // 检验目的类型

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCustomBarcode() {
        return customBarcode;
    }

    public void setCustomBarcode(String customBarcode) {
        this.customBarcode = customBarcode;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public String getTestPurposeId() {
        return testPurposeId;
    }

    public void setTestPurposeId(String testPurposeId) {
        this.testPurposeId = testPurposeId;
    }

    public String getTestPurposeName() {
        return testPurposeName;
    }

    public void setTestPurposeName(String testPurposeName) {
        this.testPurposeName = testPurposeName;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAgeType() {
        return ageType;
    }

    public void setAgeType(String ageType) {
        this.ageType = ageType;
    }

    public String getPatientIdNumber() {
        return patientIdNumber;
    }

    public void setPatientIdNumber(String patientIdNumber) {
        this.patientIdNumber = patientIdNumber;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientFileCode() {
        return patientFileCode;
    }

    public void setPatientFileCode(String patientFileCode) {
        this.patientFileCode = patientFileCode;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTestCenter() {
        return testCenter;
    }

    public void setTestCenter(String testCenter) {
        this.testCenter = testCenter;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public Integer getStayHospitalMode() {
        return stayHospitalMode;
    }

    public void setStayHospitalMode(Integer stayHospitalMode) {
        this.stayHospitalMode = stayHospitalMode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLabDepartment() {
        return labDepartment;
    }

    public void setLabDepartment(String labDepartment) {
        this.labDepartment = labDepartment;
    }

    public String getLabDepartmentCode() {
        return labDepartmentCode;
    }

    public void setLabDepartmentCode(String labDepartmentCode) {
        this.labDepartmentCode = labDepartmentCode;
    }

    public Integer getSampleStatus() {
        return sampleStatus;
    }

    public void setSampleStatus(Integer sampleStatus) {
        this.sampleStatus = sampleStatus;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }

    public String getDigCode() {
        return digCode;
    }

    public void setDigCode(String digCode) {
        this.digCode = digCode;
    }

    public String getTestItemIds() {
        return testItemIds;
    }

    public void setTestItemIds(String testItemIds) {
        this.testItemIds = testItemIds;
    }

    public String getPreBarCode() {
        return preBarCode;
    }

    public void setPreBarCode(String preBarCode) {
        this.preBarCode = preBarCode;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getKsreceivetime() {
        return ksreceivetime;
    }

    public void setKsreceivetime(String ksreceivetime) {
        this.ksreceivetime = ksreceivetime;
    }

    public String getKsreceiver() {
        return ksreceiver;
    }

    public void setKsreceiver(String ksreceiver) {
        this.ksreceiver = ksreceiver;
    }

    public Integer getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(Integer feeStatus) {
        this.feeStatus = feeStatus;
    }

    public Integer getRequestMode() {
        return requestMode;
    }

    public void setRequestMode(Integer requestMode) {
        this.requestMode = requestMode;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }
}
