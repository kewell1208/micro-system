package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.util.ArrayList;
import java.util.List;

public class ReportListVo {

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    private Integer pageNum = 0;

    private Long reportSize = 0L;

    private List<ReportBaseResultVo> reportBaseResultList = new ArrayList<>();

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Long getReportSize() {
        return reportSize;
    }

    public void setReportSize(Long reportSize) {
        this.reportSize = reportSize;
    }

    public List<ReportBaseResultVo> getReportBaseResultList() {
        return reportBaseResultList;
    }

    public void setReportBaseResultList(List<ReportBaseResultVo> reportBaseResultList) {
        this.reportBaseResultList = reportBaseResultList;
    }
}
