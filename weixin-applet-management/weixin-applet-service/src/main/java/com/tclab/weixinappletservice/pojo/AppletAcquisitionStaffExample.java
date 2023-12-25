package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletAcquisitionStaffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletAcquisitionStaffExample() {
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

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(String value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(String value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(String value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(String value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(String value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLike(String value) {
            addCriterion("staff_id like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotLike(String value) {
            addCriterion("staff_id not like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<String> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<String> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(String value1, String value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(String value1, String value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("staff_name is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("staff_name =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("staff_name <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("staff_name >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("staff_name >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("staff_name <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("staff_name <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("staff_name like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("staff_name not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("staff_name in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("staff_name not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("staff_name between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("staff_name not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffSexIsNull() {
            addCriterion("staff_sex is null");
            return (Criteria) this;
        }

        public Criteria andStaffSexIsNotNull() {
            addCriterion("staff_sex is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSexEqualTo(String value) {
            addCriterion("staff_sex =", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotEqualTo(String value) {
            addCriterion("staff_sex <>", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexGreaterThan(String value) {
            addCriterion("staff_sex >", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexGreaterThanOrEqualTo(String value) {
            addCriterion("staff_sex >=", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLessThan(String value) {
            addCriterion("staff_sex <", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLessThanOrEqualTo(String value) {
            addCriterion("staff_sex <=", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLike(String value) {
            addCriterion("staff_sex like", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotLike(String value) {
            addCriterion("staff_sex not like", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexIn(List<String> values) {
            addCriterion("staff_sex in", values, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotIn(List<String> values) {
            addCriterion("staff_sex not in", values, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexBetween(String value1, String value2) {
            addCriterion("staff_sex between", value1, value2, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotBetween(String value1, String value2) {
            addCriterion("staff_sex not between", value1, value2, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIsNull() {
            addCriterion("staff_phone is null");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIsNotNull() {
            addCriterion("staff_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneEqualTo(String value) {
            addCriterion("staff_phone =", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotEqualTo(String value) {
            addCriterion("staff_phone <>", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneGreaterThan(String value) {
            addCriterion("staff_phone >", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("staff_phone >=", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLessThan(String value) {
            addCriterion("staff_phone <", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLessThanOrEqualTo(String value) {
            addCriterion("staff_phone <=", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLike(String value) {
            addCriterion("staff_phone like", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotLike(String value) {
            addCriterion("staff_phone not like", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIn(List<String> values) {
            addCriterion("staff_phone in", values, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotIn(List<String> values) {
            addCriterion("staff_phone not in", values, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneBetween(String value1, String value2) {
            addCriterion("staff_phone between", value1, value2, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotBetween(String value1, String value2) {
            addCriterion("staff_phone not between", value1, value2, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardIsNull() {
            addCriterion("staff_id_card is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardIsNotNull() {
            addCriterion("staff_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardEqualTo(String value) {
            addCriterion("staff_id_card =", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardNotEqualTo(String value) {
            addCriterion("staff_id_card <>", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardGreaterThan(String value) {
            addCriterion("staff_id_card >", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("staff_id_card >=", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardLessThan(String value) {
            addCriterion("staff_id_card <", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardLessThanOrEqualTo(String value) {
            addCriterion("staff_id_card <=", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardLike(String value) {
            addCriterion("staff_id_card like", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardNotLike(String value) {
            addCriterion("staff_id_card not like", value, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardIn(List<String> values) {
            addCriterion("staff_id_card in", values, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardNotIn(List<String> values) {
            addCriterion("staff_id_card not in", values, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardBetween(String value1, String value2) {
            addCriterion("staff_id_card between", value1, value2, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andStaffIdCardNotBetween(String value1, String value2) {
            addCriterion("staff_id_card not between", value1, value2, "staffIdCard");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdIsNull() {
            addCriterion("acquisition_id is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdIsNotNull() {
            addCriterion("acquisition_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdEqualTo(String value) {
            addCriterion("acquisition_id =", value, "acquisitionId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdNotEqualTo(String value) {
            addCriterion("acquisition_id <>", value, "acquisitionId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdGreaterThan(String value) {
            addCriterion("acquisition_id >", value, "acquisitionId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_id >=", value, "acquisitionId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdLessThan(String value) {
            addCriterion("acquisition_id <", value, "acquisitionId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdLessThanOrEqualTo(String value) {
            addCriterion("acquisition_id <=", value, "acquisitionId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdLike(String value) {
            addCriterion("acquisition_id like", value, "acquisitionId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdNotLike(String value) {
            addCriterion("acquisition_id not like", value, "acquisitionId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdIn(List<String> values) {
            addCriterion("acquisition_id in", values, "acquisitionId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdNotIn(List<String> values) {
            addCriterion("acquisition_id not in", values, "acquisitionId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdBetween(String value1, String value2) {
            addCriterion("acquisition_id between", value1, value2, "acquisitionId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionIdNotBetween(String value1, String value2) {
            addCriterion("acquisition_id not between", value1, value2, "acquisitionId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIsNull() {
            addCriterion("staff_type is null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIsNotNull() {
            addCriterion("staff_type is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeEqualTo(Integer value) {
            addCriterion("staff_type =", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNotEqualTo(Integer value) {
            addCriterion("staff_type <>", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeGreaterThan(Integer value) {
            addCriterion("staff_type >", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_type >=", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeLessThan(Integer value) {
            addCriterion("staff_type <", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeLessThanOrEqualTo(Integer value) {
            addCriterion("staff_type <=", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIn(List<Integer> values) {
            addCriterion("staff_type in", values, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNotIn(List<Integer> values) {
            addCriterion("staff_type not in", values, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeBetween(Integer value1, Integer value2) {
            addCriterion("staff_type between", value1, value2, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_type not between", value1, value2, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffRankIsNull() {
            addCriterion("staff_rank is null");
            return (Criteria) this;
        }

        public Criteria andStaffRankIsNotNull() {
            addCriterion("staff_rank is not null");
            return (Criteria) this;
        }

        public Criteria andStaffRankEqualTo(String value) {
            addCriterion("staff_rank =", value, "staffRank");
            return (Criteria) this;
        }

        public Criteria andStaffRankNotEqualTo(String value) {
            addCriterion("staff_rank <>", value, "staffRank");
            return (Criteria) this;
        }

        public Criteria andStaffRankGreaterThan(String value) {
            addCriterion("staff_rank >", value, "staffRank");
            return (Criteria) this;
        }

        public Criteria andStaffRankGreaterThanOrEqualTo(String value) {
            addCriterion("staff_rank >=", value, "staffRank");
            return (Criteria) this;
        }

        public Criteria andStaffRankLessThan(String value) {
            addCriterion("staff_rank <", value, "staffRank");
            return (Criteria) this;
        }

        public Criteria andStaffRankLessThanOrEqualTo(String value) {
            addCriterion("staff_rank <=", value, "staffRank");
            return (Criteria) this;
        }

        public Criteria andStaffRankLike(String value) {
            addCriterion("staff_rank like", value, "staffRank");
            return (Criteria) this;
        }

        public Criteria andStaffRankNotLike(String value) {
            addCriterion("staff_rank not like", value, "staffRank");
            return (Criteria) this;
        }

        public Criteria andStaffRankIn(List<String> values) {
            addCriterion("staff_rank in", values, "staffRank");
            return (Criteria) this;
        }

        public Criteria andStaffRankNotIn(List<String> values) {
            addCriterion("staff_rank not in", values, "staffRank");
            return (Criteria) this;
        }

        public Criteria andStaffRankBetween(String value1, String value2) {
            addCriterion("staff_rank between", value1, value2, "staffRank");
            return (Criteria) this;
        }

        public Criteria andStaffRankNotBetween(String value1, String value2) {
            addCriterion("staff_rank not between", value1, value2, "staffRank");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageIsNull() {
            addCriterion("staff_rank_image is null");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageIsNotNull() {
            addCriterion("staff_rank_image is not null");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageEqualTo(String value) {
            addCriterion("staff_rank_image =", value, "staffRankImage");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageNotEqualTo(String value) {
            addCriterion("staff_rank_image <>", value, "staffRankImage");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageGreaterThan(String value) {
            addCriterion("staff_rank_image >", value, "staffRankImage");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageGreaterThanOrEqualTo(String value) {
            addCriterion("staff_rank_image >=", value, "staffRankImage");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageLessThan(String value) {
            addCriterion("staff_rank_image <", value, "staffRankImage");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageLessThanOrEqualTo(String value) {
            addCriterion("staff_rank_image <=", value, "staffRankImage");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageLike(String value) {
            addCriterion("staff_rank_image like", value, "staffRankImage");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageNotLike(String value) {
            addCriterion("staff_rank_image not like", value, "staffRankImage");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageIn(List<String> values) {
            addCriterion("staff_rank_image in", values, "staffRankImage");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageNotIn(List<String> values) {
            addCriterion("staff_rank_image not in", values, "staffRankImage");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageBetween(String value1, String value2) {
            addCriterion("staff_rank_image between", value1, value2, "staffRankImage");
            return (Criteria) this;
        }

        public Criteria andStaffRankImageNotBetween(String value1, String value2) {
            addCriterion("staff_rank_image not between", value1, value2, "staffRankImage");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageIsNull() {
            addCriterion("staff_job_image is null");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageIsNotNull() {
            addCriterion("staff_job_image is not null");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageEqualTo(String value) {
            addCriterion("staff_job_image =", value, "staffJobImage");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageNotEqualTo(String value) {
            addCriterion("staff_job_image <>", value, "staffJobImage");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageGreaterThan(String value) {
            addCriterion("staff_job_image >", value, "staffJobImage");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageGreaterThanOrEqualTo(String value) {
            addCriterion("staff_job_image >=", value, "staffJobImage");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageLessThan(String value) {
            addCriterion("staff_job_image <", value, "staffJobImage");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageLessThanOrEqualTo(String value) {
            addCriterion("staff_job_image <=", value, "staffJobImage");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageLike(String value) {
            addCriterion("staff_job_image like", value, "staffJobImage");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageNotLike(String value) {
            addCriterion("staff_job_image not like", value, "staffJobImage");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageIn(List<String> values) {
            addCriterion("staff_job_image in", values, "staffJobImage");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageNotIn(List<String> values) {
            addCriterion("staff_job_image not in", values, "staffJobImage");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageBetween(String value1, String value2) {
            addCriterion("staff_job_image between", value1, value2, "staffJobImage");
            return (Criteria) this;
        }

        public Criteria andStaffJobImageNotBetween(String value1, String value2) {
            addCriterion("staff_job_image not between", value1, value2, "staffJobImage");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionIsNull() {
            addCriterion("staff_introduction is null");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionIsNotNull() {
            addCriterion("staff_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionEqualTo(String value) {
            addCriterion("staff_introduction =", value, "staffIntroduction");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionNotEqualTo(String value) {
            addCriterion("staff_introduction <>", value, "staffIntroduction");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionGreaterThan(String value) {
            addCriterion("staff_introduction >", value, "staffIntroduction");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("staff_introduction >=", value, "staffIntroduction");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionLessThan(String value) {
            addCriterion("staff_introduction <", value, "staffIntroduction");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionLessThanOrEqualTo(String value) {
            addCriterion("staff_introduction <=", value, "staffIntroduction");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionLike(String value) {
            addCriterion("staff_introduction like", value, "staffIntroduction");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionNotLike(String value) {
            addCriterion("staff_introduction not like", value, "staffIntroduction");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionIn(List<String> values) {
            addCriterion("staff_introduction in", values, "staffIntroduction");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionNotIn(List<String> values) {
            addCriterion("staff_introduction not in", values, "staffIntroduction");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionBetween(String value1, String value2) {
            addCriterion("staff_introduction between", value1, value2, "staffIntroduction");
            return (Criteria) this;
        }

        public Criteria andStaffIntroductionNotBetween(String value1, String value2) {
            addCriterion("staff_introduction not between", value1, value2, "staffIntroduction");
            return (Criteria) this;
        }

        public Criteria andStaffExpertIsNull() {
            addCriterion("staff_expert is null");
            return (Criteria) this;
        }

        public Criteria andStaffExpertIsNotNull() {
            addCriterion("staff_expert is not null");
            return (Criteria) this;
        }

        public Criteria andStaffExpertEqualTo(String value) {
            addCriterion("staff_expert =", value, "staffExpert");
            return (Criteria) this;
        }

        public Criteria andStaffExpertNotEqualTo(String value) {
            addCriterion("staff_expert <>", value, "staffExpert");
            return (Criteria) this;
        }

        public Criteria andStaffExpertGreaterThan(String value) {
            addCriterion("staff_expert >", value, "staffExpert");
            return (Criteria) this;
        }

        public Criteria andStaffExpertGreaterThanOrEqualTo(String value) {
            addCriterion("staff_expert >=", value, "staffExpert");
            return (Criteria) this;
        }

        public Criteria andStaffExpertLessThan(String value) {
            addCriterion("staff_expert <", value, "staffExpert");
            return (Criteria) this;
        }

        public Criteria andStaffExpertLessThanOrEqualTo(String value) {
            addCriterion("staff_expert <=", value, "staffExpert");
            return (Criteria) this;
        }

        public Criteria andStaffExpertLike(String value) {
            addCriterion("staff_expert like", value, "staffExpert");
            return (Criteria) this;
        }

        public Criteria andStaffExpertNotLike(String value) {
            addCriterion("staff_expert not like", value, "staffExpert");
            return (Criteria) this;
        }

        public Criteria andStaffExpertIn(List<String> values) {
            addCriterion("staff_expert in", values, "staffExpert");
            return (Criteria) this;
        }

        public Criteria andStaffExpertNotIn(List<String> values) {
            addCriterion("staff_expert not in", values, "staffExpert");
            return (Criteria) this;
        }

        public Criteria andStaffExpertBetween(String value1, String value2) {
            addCriterion("staff_expert between", value1, value2, "staffExpert");
            return (Criteria) this;
        }

        public Criteria andStaffExpertNotBetween(String value1, String value2) {
            addCriterion("staff_expert not between", value1, value2, "staffExpert");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkIsNull() {
            addCriterion("staff_remark is null");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkIsNotNull() {
            addCriterion("staff_remark is not null");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkEqualTo(String value) {
            addCriterion("staff_remark =", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkNotEqualTo(String value) {
            addCriterion("staff_remark <>", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkGreaterThan(String value) {
            addCriterion("staff_remark >", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("staff_remark >=", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkLessThan(String value) {
            addCriterion("staff_remark <", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkLessThanOrEqualTo(String value) {
            addCriterion("staff_remark <=", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkLike(String value) {
            addCriterion("staff_remark like", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkNotLike(String value) {
            addCriterion("staff_remark not like", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkIn(List<String> values) {
            addCriterion("staff_remark in", values, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkNotIn(List<String> values) {
            addCriterion("staff_remark not in", values, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkBetween(String value1, String value2) {
            addCriterion("staff_remark between", value1, value2, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkNotBetween(String value1, String value2) {
            addCriterion("staff_remark not between", value1, value2, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagIsNull() {
            addCriterion("verify_flag is null");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagIsNotNull() {
            addCriterion("verify_flag is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagEqualTo(Integer value) {
            addCriterion("verify_flag =", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagNotEqualTo(Integer value) {
            addCriterion("verify_flag <>", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagGreaterThan(Integer value) {
            addCriterion("verify_flag >", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("verify_flag >=", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagLessThan(Integer value) {
            addCriterion("verify_flag <", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagLessThanOrEqualTo(Integer value) {
            addCriterion("verify_flag <=", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagIn(List<Integer> values) {
            addCriterion("verify_flag in", values, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagNotIn(List<Integer> values) {
            addCriterion("verify_flag not in", values, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagBetween(Integer value1, Integer value2) {
            addCriterion("verify_flag between", value1, value2, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("verify_flag not between", value1, value2, "verifyFlag");
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

        public Criteria andStaffStatusIsNull() {
            addCriterion("staff_status is null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIsNotNull() {
            addCriterion("staff_status is not null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusEqualTo(Integer value) {
            addCriterion("staff_status =", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNotEqualTo(Integer value) {
            addCriterion("staff_status <>", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusGreaterThan(Integer value) {
            addCriterion("staff_status >", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_status >=", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusLessThan(Integer value) {
            addCriterion("staff_status <", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusLessThanOrEqualTo(Integer value) {
            addCriterion("staff_status <=", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIn(List<Integer> values) {
            addCriterion("staff_status in", values, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNotIn(List<Integer> values) {
            addCriterion("staff_status not in", values, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusBetween(Integer value1, Integer value2) {
            addCriterion("staff_status between", value1, value2, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_status not between", value1, value2, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffLogoIsNull() {
            addCriterion("staff_logo is null");
            return (Criteria) this;
        }

        public Criteria andStaffLogoIsNotNull() {
            addCriterion("staff_logo is not null");
            return (Criteria) this;
        }

        public Criteria andStaffLogoEqualTo(String value) {
            addCriterion("staff_logo =", value, "staffLogo");
            return (Criteria) this;
        }

        public Criteria andStaffLogoNotEqualTo(String value) {
            addCriterion("staff_logo <>", value, "staffLogo");
            return (Criteria) this;
        }

        public Criteria andStaffLogoGreaterThan(String value) {
            addCriterion("staff_logo >", value, "staffLogo");
            return (Criteria) this;
        }

        public Criteria andStaffLogoGreaterThanOrEqualTo(String value) {
            addCriterion("staff_logo >=", value, "staffLogo");
            return (Criteria) this;
        }

        public Criteria andStaffLogoLessThan(String value) {
            addCriterion("staff_logo <", value, "staffLogo");
            return (Criteria) this;
        }

        public Criteria andStaffLogoLessThanOrEqualTo(String value) {
            addCriterion("staff_logo <=", value, "staffLogo");
            return (Criteria) this;
        }

        public Criteria andStaffLogoLike(String value) {
            addCriterion("staff_logo like", value, "staffLogo");
            return (Criteria) this;
        }

        public Criteria andStaffLogoNotLike(String value) {
            addCriterion("staff_logo not like", value, "staffLogo");
            return (Criteria) this;
        }

        public Criteria andStaffLogoIn(List<String> values) {
            addCriterion("staff_logo in", values, "staffLogo");
            return (Criteria) this;
        }

        public Criteria andStaffLogoNotIn(List<String> values) {
            addCriterion("staff_logo not in", values, "staffLogo");
            return (Criteria) this;
        }

        public Criteria andStaffLogoBetween(String value1, String value2) {
            addCriterion("staff_logo between", value1, value2, "staffLogo");
            return (Criteria) this;
        }

        public Criteria andStaffLogoNotBetween(String value1, String value2) {
            addCriterion("staff_logo not between", value1, value2, "staffLogo");
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