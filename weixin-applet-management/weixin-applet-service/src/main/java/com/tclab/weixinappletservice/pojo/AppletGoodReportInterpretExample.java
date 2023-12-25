package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletGoodReportInterpretExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletGoodReportInterpretExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNull() {
            addCriterion("report_id is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("report_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(String value) {
            addCriterion("report_id =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(String value) {
            addCriterion("report_id <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(String value) {
            addCriterion("report_id >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(String value) {
            addCriterion("report_id >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(String value) {
            addCriterion("report_id <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(String value) {
            addCriterion("report_id <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLike(String value) {
            addCriterion("report_id like", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotLike(String value) {
            addCriterion("report_id not like", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<String> values) {
            addCriterion("report_id in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<String> values) {
            addCriterion("report_id not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(String value1, String value2) {
            addCriterion("report_id between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(String value1, String value2) {
            addCriterion("report_id not between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andGoodNoIsNull() {
            addCriterion("good_no is null");
            return (Criteria) this;
        }

        public Criteria andGoodNoIsNotNull() {
            addCriterion("good_no is not null");
            return (Criteria) this;
        }

        public Criteria andGoodNoEqualTo(String value) {
            addCriterion("good_no =", value, "goodNo");
            return (Criteria) this;
        }

        public Criteria andGoodNoNotEqualTo(String value) {
            addCriterion("good_no <>", value, "goodNo");
            return (Criteria) this;
        }

        public Criteria andGoodNoGreaterThan(String value) {
            addCriterion("good_no >", value, "goodNo");
            return (Criteria) this;
        }

        public Criteria andGoodNoGreaterThanOrEqualTo(String value) {
            addCriterion("good_no >=", value, "goodNo");
            return (Criteria) this;
        }

        public Criteria andGoodNoLessThan(String value) {
            addCriterion("good_no <", value, "goodNo");
            return (Criteria) this;
        }

        public Criteria andGoodNoLessThanOrEqualTo(String value) {
            addCriterion("good_no <=", value, "goodNo");
            return (Criteria) this;
        }

        public Criteria andGoodNoLike(String value) {
            addCriterion("good_no like", value, "goodNo");
            return (Criteria) this;
        }

        public Criteria andGoodNoNotLike(String value) {
            addCriterion("good_no not like", value, "goodNo");
            return (Criteria) this;
        }

        public Criteria andGoodNoIn(List<String> values) {
            addCriterion("good_no in", values, "goodNo");
            return (Criteria) this;
        }

        public Criteria andGoodNoNotIn(List<String> values) {
            addCriterion("good_no not in", values, "goodNo");
            return (Criteria) this;
        }

        public Criteria andGoodNoBetween(String value1, String value2) {
            addCriterion("good_no between", value1, value2, "goodNo");
            return (Criteria) this;
        }

        public Criteria andGoodNoNotBetween(String value1, String value2) {
            addCriterion("good_no not between", value1, value2, "goodNo");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNull() {
            addCriterion("doctor_id is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNotNull() {
            addCriterion("doctor_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdEqualTo(String value) {
            addCriterion("doctor_id =", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotEqualTo(String value) {
            addCriterion("doctor_id <>", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThan(String value) {
            addCriterion("doctor_id >", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_id >=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThan(String value) {
            addCriterion("doctor_id <", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThanOrEqualTo(String value) {
            addCriterion("doctor_id <=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLike(String value) {
            addCriterion("doctor_id like", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotLike(String value) {
            addCriterion("doctor_id not like", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIn(List<String> values) {
            addCriterion("doctor_id in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotIn(List<String> values) {
            addCriterion("doctor_id not in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdBetween(String value1, String value2) {
            addCriterion("doctor_id between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotBetween(String value1, String value2) {
            addCriterion("doctor_id not between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIsNull() {
            addCriterion("doctor_name is null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIsNotNull() {
            addCriterion("doctor_name is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameEqualTo(String value) {
            addCriterion("doctor_name =", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotEqualTo(String value) {
            addCriterion("doctor_name <>", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThan(String value) {
            addCriterion("doctor_name >", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_name >=", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThan(String value) {
            addCriterion("doctor_name <", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThanOrEqualTo(String value) {
            addCriterion("doctor_name <=", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLike(String value) {
            addCriterion("doctor_name like", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotLike(String value) {
            addCriterion("doctor_name not like", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIn(List<String> values) {
            addCriterion("doctor_name in", values, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotIn(List<String> values) {
            addCriterion("doctor_name not in", values, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameBetween(String value1, String value2) {
            addCriterion("doctor_name between", value1, value2, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotBetween(String value1, String value2) {
            addCriterion("doctor_name not between", value1, value2, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIsNull() {
            addCriterion("doctor_department is null");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIsNotNull() {
            addCriterion("doctor_department is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentEqualTo(String value) {
            addCriterion("doctor_department =", value, "doctorDepartment");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNotEqualTo(String value) {
            addCriterion("doctor_department <>", value, "doctorDepartment");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentGreaterThan(String value) {
            addCriterion("doctor_department >", value, "doctorDepartment");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_department >=", value, "doctorDepartment");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentLessThan(String value) {
            addCriterion("doctor_department <", value, "doctorDepartment");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentLessThanOrEqualTo(String value) {
            addCriterion("doctor_department <=", value, "doctorDepartment");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentLike(String value) {
            addCriterion("doctor_department like", value, "doctorDepartment");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNotLike(String value) {
            addCriterion("doctor_department not like", value, "doctorDepartment");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIn(List<String> values) {
            addCriterion("doctor_department in", values, "doctorDepartment");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNotIn(List<String> values) {
            addCriterion("doctor_department not in", values, "doctorDepartment");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentBetween(String value1, String value2) {
            addCriterion("doctor_department between", value1, value2, "doctorDepartment");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNotBetween(String value1, String value2) {
            addCriterion("doctor_department not between", value1, value2, "doctorDepartment");
            return (Criteria) this;
        }

        public Criteria andDoctorRankIsNull() {
            addCriterion("doctor_rank is null");
            return (Criteria) this;
        }

        public Criteria andDoctorRankIsNotNull() {
            addCriterion("doctor_rank is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorRankEqualTo(String value) {
            addCriterion("doctor_rank =", value, "doctorRank");
            return (Criteria) this;
        }

        public Criteria andDoctorRankNotEqualTo(String value) {
            addCriterion("doctor_rank <>", value, "doctorRank");
            return (Criteria) this;
        }

        public Criteria andDoctorRankGreaterThan(String value) {
            addCriterion("doctor_rank >", value, "doctorRank");
            return (Criteria) this;
        }

        public Criteria andDoctorRankGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_rank >=", value, "doctorRank");
            return (Criteria) this;
        }

        public Criteria andDoctorRankLessThan(String value) {
            addCriterion("doctor_rank <", value, "doctorRank");
            return (Criteria) this;
        }

        public Criteria andDoctorRankLessThanOrEqualTo(String value) {
            addCriterion("doctor_rank <=", value, "doctorRank");
            return (Criteria) this;
        }

        public Criteria andDoctorRankLike(String value) {
            addCriterion("doctor_rank like", value, "doctorRank");
            return (Criteria) this;
        }

        public Criteria andDoctorRankNotLike(String value) {
            addCriterion("doctor_rank not like", value, "doctorRank");
            return (Criteria) this;
        }

        public Criteria andDoctorRankIn(List<String> values) {
            addCriterion("doctor_rank in", values, "doctorRank");
            return (Criteria) this;
        }

        public Criteria andDoctorRankNotIn(List<String> values) {
            addCriterion("doctor_rank not in", values, "doctorRank");
            return (Criteria) this;
        }

        public Criteria andDoctorRankBetween(String value1, String value2) {
            addCriterion("doctor_rank between", value1, value2, "doctorRank");
            return (Criteria) this;
        }

        public Criteria andDoctorRankNotBetween(String value1, String value2) {
            addCriterion("doctor_rank not between", value1, value2, "doctorRank");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelIsNull() {
            addCriterion("doctor_label is null");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelIsNotNull() {
            addCriterion("doctor_label is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelEqualTo(String value) {
            addCriterion("doctor_label =", value, "doctorLabel");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelNotEqualTo(String value) {
            addCriterion("doctor_label <>", value, "doctorLabel");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelGreaterThan(String value) {
            addCriterion("doctor_label >", value, "doctorLabel");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_label >=", value, "doctorLabel");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelLessThan(String value) {
            addCriterion("doctor_label <", value, "doctorLabel");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelLessThanOrEqualTo(String value) {
            addCriterion("doctor_label <=", value, "doctorLabel");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelLike(String value) {
            addCriterion("doctor_label like", value, "doctorLabel");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelNotLike(String value) {
            addCriterion("doctor_label not like", value, "doctorLabel");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelIn(List<String> values) {
            addCriterion("doctor_label in", values, "doctorLabel");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelNotIn(List<String> values) {
            addCriterion("doctor_label not in", values, "doctorLabel");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelBetween(String value1, String value2) {
            addCriterion("doctor_label between", value1, value2, "doctorLabel");
            return (Criteria) this;
        }

        public Criteria andDoctorLabelNotBetween(String value1, String value2) {
            addCriterion("doctor_label not between", value1, value2, "doctorLabel");
            return (Criteria) this;
        }

        public Criteria andInterpretationStatusIsNull() {
            addCriterion("interpretation_status is null");
            return (Criteria) this;
        }

        public Criteria andInterpretationStatusIsNotNull() {
            addCriterion("interpretation_status is not null");
            return (Criteria) this;
        }

        public Criteria andInterpretationStatusEqualTo(Integer value) {
            addCriterion("interpretation_status =", value, "interpretationStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretationStatusNotEqualTo(Integer value) {
            addCriterion("interpretation_status <>", value, "interpretationStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretationStatusGreaterThan(Integer value) {
            addCriterion("interpretation_status >", value, "interpretationStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretationStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("interpretation_status >=", value, "interpretationStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretationStatusLessThan(Integer value) {
            addCriterion("interpretation_status <", value, "interpretationStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretationStatusLessThanOrEqualTo(Integer value) {
            addCriterion("interpretation_status <=", value, "interpretationStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretationStatusIn(List<Integer> values) {
            addCriterion("interpretation_status in", values, "interpretationStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretationStatusNotIn(List<Integer> values) {
            addCriterion("interpretation_status not in", values, "interpretationStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretationStatusBetween(Integer value1, Integer value2) {
            addCriterion("interpretation_status between", value1, value2, "interpretationStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretationStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("interpretation_status not between", value1, value2, "interpretationStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretationDateIsNull() {
            addCriterion("interpretation_date is null");
            return (Criteria) this;
        }

        public Criteria andInterpretationDateIsNotNull() {
            addCriterion("interpretation_date is not null");
            return (Criteria) this;
        }

        public Criteria andInterpretationDateEqualTo(Date value) {
            addCriterion("interpretation_date =", value, "interpretationDate");
            return (Criteria) this;
        }

        public Criteria andInterpretationDateNotEqualTo(Date value) {
            addCriterion("interpretation_date <>", value, "interpretationDate");
            return (Criteria) this;
        }

        public Criteria andInterpretationDateGreaterThan(Date value) {
            addCriterion("interpretation_date >", value, "interpretationDate");
            return (Criteria) this;
        }

        public Criteria andInterpretationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("interpretation_date >=", value, "interpretationDate");
            return (Criteria) this;
        }

        public Criteria andInterpretationDateLessThan(Date value) {
            addCriterion("interpretation_date <", value, "interpretationDate");
            return (Criteria) this;
        }

        public Criteria andInterpretationDateLessThanOrEqualTo(Date value) {
            addCriterion("interpretation_date <=", value, "interpretationDate");
            return (Criteria) this;
        }

        public Criteria andInterpretationDateIn(List<Date> values) {
            addCriterion("interpretation_date in", values, "interpretationDate");
            return (Criteria) this;
        }

        public Criteria andInterpretationDateNotIn(List<Date> values) {
            addCriterion("interpretation_date not in", values, "interpretationDate");
            return (Criteria) this;
        }

        public Criteria andInterpretationDateBetween(Date value1, Date value2) {
            addCriterion("interpretation_date between", value1, value2, "interpretationDate");
            return (Criteria) this;
        }

        public Criteria andInterpretationDateNotBetween(Date value1, Date value2) {
            addCriterion("interpretation_date not between", value1, value2, "interpretationDate");
            return (Criteria) this;
        }

        public Criteria andReportContentIsNull() {
            addCriterion("report_content is null");
            return (Criteria) this;
        }

        public Criteria andReportContentIsNotNull() {
            addCriterion("report_content is not null");
            return (Criteria) this;
        }

        public Criteria andReportContentEqualTo(String value) {
            addCriterion("report_content =", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentNotEqualTo(String value) {
            addCriterion("report_content <>", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentGreaterThan(String value) {
            addCriterion("report_content >", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentGreaterThanOrEqualTo(String value) {
            addCriterion("report_content >=", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentLessThan(String value) {
            addCriterion("report_content <", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentLessThanOrEqualTo(String value) {
            addCriterion("report_content <=", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentLike(String value) {
            addCriterion("report_content like", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentNotLike(String value) {
            addCriterion("report_content not like", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentIn(List<String> values) {
            addCriterion("report_content in", values, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentNotIn(List<String> values) {
            addCriterion("report_content not in", values, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentBetween(String value1, String value2) {
            addCriterion("report_content between", value1, value2, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentNotBetween(String value1, String value2) {
            addCriterion("report_content not between", value1, value2, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportReplyIsNull() {
            addCriterion("report_reply is null");
            return (Criteria) this;
        }

        public Criteria andReportReplyIsNotNull() {
            addCriterion("report_reply is not null");
            return (Criteria) this;
        }

        public Criteria andReportReplyEqualTo(String value) {
            addCriterion("report_reply =", value, "reportReply");
            return (Criteria) this;
        }

        public Criteria andReportReplyNotEqualTo(String value) {
            addCriterion("report_reply <>", value, "reportReply");
            return (Criteria) this;
        }

        public Criteria andReportReplyGreaterThan(String value) {
            addCriterion("report_reply >", value, "reportReply");
            return (Criteria) this;
        }

        public Criteria andReportReplyGreaterThanOrEqualTo(String value) {
            addCriterion("report_reply >=", value, "reportReply");
            return (Criteria) this;
        }

        public Criteria andReportReplyLessThan(String value) {
            addCriterion("report_reply <", value, "reportReply");
            return (Criteria) this;
        }

        public Criteria andReportReplyLessThanOrEqualTo(String value) {
            addCriterion("report_reply <=", value, "reportReply");
            return (Criteria) this;
        }

        public Criteria andReportReplyLike(String value) {
            addCriterion("report_reply like", value, "reportReply");
            return (Criteria) this;
        }

        public Criteria andReportReplyNotLike(String value) {
            addCriterion("report_reply not like", value, "reportReply");
            return (Criteria) this;
        }

        public Criteria andReportReplyIn(List<String> values) {
            addCriterion("report_reply in", values, "reportReply");
            return (Criteria) this;
        }

        public Criteria andReportReplyNotIn(List<String> values) {
            addCriterion("report_reply not in", values, "reportReply");
            return (Criteria) this;
        }

        public Criteria andReportReplyBetween(String value1, String value2) {
            addCriterion("report_reply between", value1, value2, "reportReply");
            return (Criteria) this;
        }

        public Criteria andReportReplyNotBetween(String value1, String value2) {
            addCriterion("report_reply not between", value1, value2, "reportReply");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}