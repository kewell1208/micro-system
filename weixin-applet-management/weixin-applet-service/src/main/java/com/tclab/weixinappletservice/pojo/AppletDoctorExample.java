package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletDoctorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletDoctorExample() {
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

        public Criteria andDoctorSexIsNull() {
            addCriterion("doctor_sex is null");
            return (Criteria) this;
        }

        public Criteria andDoctorSexIsNotNull() {
            addCriterion("doctor_sex is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorSexEqualTo(String value) {
            addCriterion("doctor_sex =", value, "doctorSex");
            return (Criteria) this;
        }

        public Criteria andDoctorSexNotEqualTo(String value) {
            addCriterion("doctor_sex <>", value, "doctorSex");
            return (Criteria) this;
        }

        public Criteria andDoctorSexGreaterThan(String value) {
            addCriterion("doctor_sex >", value, "doctorSex");
            return (Criteria) this;
        }

        public Criteria andDoctorSexGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_sex >=", value, "doctorSex");
            return (Criteria) this;
        }

        public Criteria andDoctorSexLessThan(String value) {
            addCriterion("doctor_sex <", value, "doctorSex");
            return (Criteria) this;
        }

        public Criteria andDoctorSexLessThanOrEqualTo(String value) {
            addCriterion("doctor_sex <=", value, "doctorSex");
            return (Criteria) this;
        }

        public Criteria andDoctorSexLike(String value) {
            addCriterion("doctor_sex like", value, "doctorSex");
            return (Criteria) this;
        }

        public Criteria andDoctorSexNotLike(String value) {
            addCriterion("doctor_sex not like", value, "doctorSex");
            return (Criteria) this;
        }

        public Criteria andDoctorSexIn(List<String> values) {
            addCriterion("doctor_sex in", values, "doctorSex");
            return (Criteria) this;
        }

        public Criteria andDoctorSexNotIn(List<String> values) {
            addCriterion("doctor_sex not in", values, "doctorSex");
            return (Criteria) this;
        }

        public Criteria andDoctorSexBetween(String value1, String value2) {
            addCriterion("doctor_sex between", value1, value2, "doctorSex");
            return (Criteria) this;
        }

        public Criteria andDoctorSexNotBetween(String value1, String value2) {
            addCriterion("doctor_sex not between", value1, value2, "doctorSex");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneIsNull() {
            addCriterion("doctor_phone is null");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneIsNotNull() {
            addCriterion("doctor_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneEqualTo(String value) {
            addCriterion("doctor_phone =", value, "doctorPhone");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneNotEqualTo(String value) {
            addCriterion("doctor_phone <>", value, "doctorPhone");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneGreaterThan(String value) {
            addCriterion("doctor_phone >", value, "doctorPhone");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_phone >=", value, "doctorPhone");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneLessThan(String value) {
            addCriterion("doctor_phone <", value, "doctorPhone");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneLessThanOrEqualTo(String value) {
            addCriterion("doctor_phone <=", value, "doctorPhone");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneLike(String value) {
            addCriterion("doctor_phone like", value, "doctorPhone");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneNotLike(String value) {
            addCriterion("doctor_phone not like", value, "doctorPhone");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneIn(List<String> values) {
            addCriterion("doctor_phone in", values, "doctorPhone");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneNotIn(List<String> values) {
            addCriterion("doctor_phone not in", values, "doctorPhone");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneBetween(String value1, String value2) {
            addCriterion("doctor_phone between", value1, value2, "doctorPhone");
            return (Criteria) this;
        }

        public Criteria andDoctorPhoneNotBetween(String value1, String value2) {
            addCriterion("doctor_phone not between", value1, value2, "doctorPhone");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardIsNull() {
            addCriterion("doctor_id_card is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardIsNotNull() {
            addCriterion("doctor_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardEqualTo(String value) {
            addCriterion("doctor_id_card =", value, "doctorIdCard");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardNotEqualTo(String value) {
            addCriterion("doctor_id_card <>", value, "doctorIdCard");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardGreaterThan(String value) {
            addCriterion("doctor_id_card >", value, "doctorIdCard");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_id_card >=", value, "doctorIdCard");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardLessThan(String value) {
            addCriterion("doctor_id_card <", value, "doctorIdCard");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardLessThanOrEqualTo(String value) {
            addCriterion("doctor_id_card <=", value, "doctorIdCard");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardLike(String value) {
            addCriterion("doctor_id_card like", value, "doctorIdCard");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardNotLike(String value) {
            addCriterion("doctor_id_card not like", value, "doctorIdCard");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardIn(List<String> values) {
            addCriterion("doctor_id_card in", values, "doctorIdCard");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardNotIn(List<String> values) {
            addCriterion("doctor_id_card not in", values, "doctorIdCard");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardBetween(String value1, String value2) {
            addCriterion("doctor_id_card between", value1, value2, "doctorIdCard");
            return (Criteria) this;
        }

        public Criteria andDoctorIdCardNotBetween(String value1, String value2) {
            addCriterion("doctor_id_card not between", value1, value2, "doctorIdCard");
            return (Criteria) this;
        }

        public Criteria andHospitalIdIsNull() {
            addCriterion("hospital_id is null");
            return (Criteria) this;
        }

        public Criteria andHospitalIdIsNotNull() {
            addCriterion("hospital_id is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalIdEqualTo(String value) {
            addCriterion("hospital_id =", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdNotEqualTo(String value) {
            addCriterion("hospital_id <>", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdGreaterThan(String value) {
            addCriterion("hospital_id >", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdGreaterThanOrEqualTo(String value) {
            addCriterion("hospital_id >=", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdLessThan(String value) {
            addCriterion("hospital_id <", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdLessThanOrEqualTo(String value) {
            addCriterion("hospital_id <=", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdLike(String value) {
            addCriterion("hospital_id like", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdNotLike(String value) {
            addCriterion("hospital_id not like", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdIn(List<String> values) {
            addCriterion("hospital_id in", values, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdNotIn(List<String> values) {
            addCriterion("hospital_id not in", values, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdBetween(String value1, String value2) {
            addCriterion("hospital_id between", value1, value2, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdNotBetween(String value1, String value2) {
            addCriterion("hospital_id not between", value1, value2, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalNameIsNull() {
            addCriterion("hospital_name is null");
            return (Criteria) this;
        }

        public Criteria andHospitalNameIsNotNull() {
            addCriterion("hospital_name is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalNameEqualTo(String value) {
            addCriterion("hospital_name =", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameNotEqualTo(String value) {
            addCriterion("hospital_name <>", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameGreaterThan(String value) {
            addCriterion("hospital_name >", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameGreaterThanOrEqualTo(String value) {
            addCriterion("hospital_name >=", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameLessThan(String value) {
            addCriterion("hospital_name <", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameLessThanOrEqualTo(String value) {
            addCriterion("hospital_name <=", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameLike(String value) {
            addCriterion("hospital_name like", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameNotLike(String value) {
            addCriterion("hospital_name not like", value, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameIn(List<String> values) {
            addCriterion("hospital_name in", values, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameNotIn(List<String> values) {
            addCriterion("hospital_name not in", values, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameBetween(String value1, String value2) {
            addCriterion("hospital_name between", value1, value2, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andHospitalNameNotBetween(String value1, String value2) {
            addCriterion("hospital_name not between", value1, value2, "hospitalName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdIsNull() {
            addCriterion("doctor_department_id is null");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdIsNotNull() {
            addCriterion("doctor_department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdEqualTo(String value) {
            addCriterion("doctor_department_id =", value, "doctorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdNotEqualTo(String value) {
            addCriterion("doctor_department_id <>", value, "doctorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdGreaterThan(String value) {
            addCriterion("doctor_department_id >", value, "doctorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_department_id >=", value, "doctorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdLessThan(String value) {
            addCriterion("doctor_department_id <", value, "doctorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("doctor_department_id <=", value, "doctorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdLike(String value) {
            addCriterion("doctor_department_id like", value, "doctorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdNotLike(String value) {
            addCriterion("doctor_department_id not like", value, "doctorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdIn(List<String> values) {
            addCriterion("doctor_department_id in", values, "doctorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdNotIn(List<String> values) {
            addCriterion("doctor_department_id not in", values, "doctorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdBetween(String value1, String value2) {
            addCriterion("doctor_department_id between", value1, value2, "doctorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("doctor_department_id not between", value1, value2, "doctorDepartmentId");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameIsNull() {
            addCriterion("doctor_department_name is null");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameIsNotNull() {
            addCriterion("doctor_department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameEqualTo(String value) {
            addCriterion("doctor_department_name =", value, "doctorDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameNotEqualTo(String value) {
            addCriterion("doctor_department_name <>", value, "doctorDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameGreaterThan(String value) {
            addCriterion("doctor_department_name >", value, "doctorDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_department_name >=", value, "doctorDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameLessThan(String value) {
            addCriterion("doctor_department_name <", value, "doctorDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("doctor_department_name <=", value, "doctorDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameLike(String value) {
            addCriterion("doctor_department_name like", value, "doctorDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameNotLike(String value) {
            addCriterion("doctor_department_name not like", value, "doctorDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameIn(List<String> values) {
            addCriterion("doctor_department_name in", values, "doctorDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameNotIn(List<String> values) {
            addCriterion("doctor_department_name not in", values, "doctorDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameBetween(String value1, String value2) {
            addCriterion("doctor_department_name between", value1, value2, "doctorDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDoctorDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("doctor_department_name not between", value1, value2, "doctorDepartmentName");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeIsNull() {
            addCriterion("doctor_type is null");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeIsNotNull() {
            addCriterion("doctor_type is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeEqualTo(Integer value) {
            addCriterion("doctor_type =", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeNotEqualTo(Integer value) {
            addCriterion("doctor_type <>", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeGreaterThan(Integer value) {
            addCriterion("doctor_type >", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor_type >=", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeLessThan(Integer value) {
            addCriterion("doctor_type <", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeLessThanOrEqualTo(Integer value) {
            addCriterion("doctor_type <=", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeIn(List<Integer> values) {
            addCriterion("doctor_type in", values, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeNotIn(List<Integer> values) {
            addCriterion("doctor_type not in", values, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeBetween(Integer value1, Integer value2) {
            addCriterion("doctor_type between", value1, value2, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor_type not between", value1, value2, "doctorType");
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

        public Criteria andDoctorRankImageIsNull() {
            addCriterion("doctor_rank_image is null");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageIsNotNull() {
            addCriterion("doctor_rank_image is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageEqualTo(String value) {
            addCriterion("doctor_rank_image =", value, "doctorRankImage");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageNotEqualTo(String value) {
            addCriterion("doctor_rank_image <>", value, "doctorRankImage");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageGreaterThan(String value) {
            addCriterion("doctor_rank_image >", value, "doctorRankImage");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_rank_image >=", value, "doctorRankImage");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageLessThan(String value) {
            addCriterion("doctor_rank_image <", value, "doctorRankImage");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageLessThanOrEqualTo(String value) {
            addCriterion("doctor_rank_image <=", value, "doctorRankImage");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageLike(String value) {
            addCriterion("doctor_rank_image like", value, "doctorRankImage");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageNotLike(String value) {
            addCriterion("doctor_rank_image not like", value, "doctorRankImage");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageIn(List<String> values) {
            addCriterion("doctor_rank_image in", values, "doctorRankImage");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageNotIn(List<String> values) {
            addCriterion("doctor_rank_image not in", values, "doctorRankImage");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageBetween(String value1, String value2) {
            addCriterion("doctor_rank_image between", value1, value2, "doctorRankImage");
            return (Criteria) this;
        }

        public Criteria andDoctorRankImageNotBetween(String value1, String value2) {
            addCriterion("doctor_rank_image not between", value1, value2, "doctorRankImage");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageIsNull() {
            addCriterion("doctor_job_image is null");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageIsNotNull() {
            addCriterion("doctor_job_image is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageEqualTo(String value) {
            addCriterion("doctor_job_image =", value, "doctorJobImage");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageNotEqualTo(String value) {
            addCriterion("doctor_job_image <>", value, "doctorJobImage");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageGreaterThan(String value) {
            addCriterion("doctor_job_image >", value, "doctorJobImage");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_job_image >=", value, "doctorJobImage");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageLessThan(String value) {
            addCriterion("doctor_job_image <", value, "doctorJobImage");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageLessThanOrEqualTo(String value) {
            addCriterion("doctor_job_image <=", value, "doctorJobImage");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageLike(String value) {
            addCriterion("doctor_job_image like", value, "doctorJobImage");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageNotLike(String value) {
            addCriterion("doctor_job_image not like", value, "doctorJobImage");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageIn(List<String> values) {
            addCriterion("doctor_job_image in", values, "doctorJobImage");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageNotIn(List<String> values) {
            addCriterion("doctor_job_image not in", values, "doctorJobImage");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageBetween(String value1, String value2) {
            addCriterion("doctor_job_image between", value1, value2, "doctorJobImage");
            return (Criteria) this;
        }

        public Criteria andDoctorJobImageNotBetween(String value1, String value2) {
            addCriterion("doctor_job_image not between", value1, value2, "doctorJobImage");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionIsNull() {
            addCriterion("doctor_introduction is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionIsNotNull() {
            addCriterion("doctor_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionEqualTo(String value) {
            addCriterion("doctor_introduction =", value, "doctorIntroduction");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionNotEqualTo(String value) {
            addCriterion("doctor_introduction <>", value, "doctorIntroduction");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionGreaterThan(String value) {
            addCriterion("doctor_introduction >", value, "doctorIntroduction");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_introduction >=", value, "doctorIntroduction");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionLessThan(String value) {
            addCriterion("doctor_introduction <", value, "doctorIntroduction");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionLessThanOrEqualTo(String value) {
            addCriterion("doctor_introduction <=", value, "doctorIntroduction");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionLike(String value) {
            addCriterion("doctor_introduction like", value, "doctorIntroduction");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionNotLike(String value) {
            addCriterion("doctor_introduction not like", value, "doctorIntroduction");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionIn(List<String> values) {
            addCriterion("doctor_introduction in", values, "doctorIntroduction");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionNotIn(List<String> values) {
            addCriterion("doctor_introduction not in", values, "doctorIntroduction");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionBetween(String value1, String value2) {
            addCriterion("doctor_introduction between", value1, value2, "doctorIntroduction");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroductionNotBetween(String value1, String value2) {
            addCriterion("doctor_introduction not between", value1, value2, "doctorIntroduction");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertIsNull() {
            addCriterion("doctor_expert is null");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertIsNotNull() {
            addCriterion("doctor_expert is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertEqualTo(String value) {
            addCriterion("doctor_expert =", value, "doctorExpert");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertNotEqualTo(String value) {
            addCriterion("doctor_expert <>", value, "doctorExpert");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertGreaterThan(String value) {
            addCriterion("doctor_expert >", value, "doctorExpert");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_expert >=", value, "doctorExpert");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertLessThan(String value) {
            addCriterion("doctor_expert <", value, "doctorExpert");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertLessThanOrEqualTo(String value) {
            addCriterion("doctor_expert <=", value, "doctorExpert");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertLike(String value) {
            addCriterion("doctor_expert like", value, "doctorExpert");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertNotLike(String value) {
            addCriterion("doctor_expert not like", value, "doctorExpert");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertIn(List<String> values) {
            addCriterion("doctor_expert in", values, "doctorExpert");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertNotIn(List<String> values) {
            addCriterion("doctor_expert not in", values, "doctorExpert");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertBetween(String value1, String value2) {
            addCriterion("doctor_expert between", value1, value2, "doctorExpert");
            return (Criteria) this;
        }

        public Criteria andDoctorExpertNotBetween(String value1, String value2) {
            addCriterion("doctor_expert not between", value1, value2, "doctorExpert");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkIsNull() {
            addCriterion("doctor_remark is null");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkIsNotNull() {
            addCriterion("doctor_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkEqualTo(String value) {
            addCriterion("doctor_remark =", value, "doctorRemark");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkNotEqualTo(String value) {
            addCriterion("doctor_remark <>", value, "doctorRemark");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkGreaterThan(String value) {
            addCriterion("doctor_remark >", value, "doctorRemark");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_remark >=", value, "doctorRemark");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkLessThan(String value) {
            addCriterion("doctor_remark <", value, "doctorRemark");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkLessThanOrEqualTo(String value) {
            addCriterion("doctor_remark <=", value, "doctorRemark");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkLike(String value) {
            addCriterion("doctor_remark like", value, "doctorRemark");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkNotLike(String value) {
            addCriterion("doctor_remark not like", value, "doctorRemark");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkIn(List<String> values) {
            addCriterion("doctor_remark in", values, "doctorRemark");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkNotIn(List<String> values) {
            addCriterion("doctor_remark not in", values, "doctorRemark");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkBetween(String value1, String value2) {
            addCriterion("doctor_remark between", value1, value2, "doctorRemark");
            return (Criteria) this;
        }

        public Criteria andDoctorRemarkNotBetween(String value1, String value2) {
            addCriterion("doctor_remark not between", value1, value2, "doctorRemark");
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

        public Criteria andDoctorStatusIsNull() {
            addCriterion("doctor_status is null");
            return (Criteria) this;
        }

        public Criteria andDoctorStatusIsNotNull() {
            addCriterion("doctor_status is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorStatusEqualTo(Integer value) {
            addCriterion("doctor_status =", value, "doctorStatus");
            return (Criteria) this;
        }

        public Criteria andDoctorStatusNotEqualTo(Integer value) {
            addCriterion("doctor_status <>", value, "doctorStatus");
            return (Criteria) this;
        }

        public Criteria andDoctorStatusGreaterThan(Integer value) {
            addCriterion("doctor_status >", value, "doctorStatus");
            return (Criteria) this;
        }

        public Criteria andDoctorStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor_status >=", value, "doctorStatus");
            return (Criteria) this;
        }

        public Criteria andDoctorStatusLessThan(Integer value) {
            addCriterion("doctor_status <", value, "doctorStatus");
            return (Criteria) this;
        }

        public Criteria andDoctorStatusLessThanOrEqualTo(Integer value) {
            addCriterion("doctor_status <=", value, "doctorStatus");
            return (Criteria) this;
        }

        public Criteria andDoctorStatusIn(List<Integer> values) {
            addCriterion("doctor_status in", values, "doctorStatus");
            return (Criteria) this;
        }

        public Criteria andDoctorStatusNotIn(List<Integer> values) {
            addCriterion("doctor_status not in", values, "doctorStatus");
            return (Criteria) this;
        }

        public Criteria andDoctorStatusBetween(Integer value1, Integer value2) {
            addCriterion("doctor_status between", value1, value2, "doctorStatus");
            return (Criteria) this;
        }

        public Criteria andDoctorStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor_status not between", value1, value2, "doctorStatus");
            return (Criteria) this;
        }

        public Criteria andDoctorScoreIsNull() {
            addCriterion("doctor_score is null");
            return (Criteria) this;
        }

        public Criteria andDoctorScoreIsNotNull() {
            addCriterion("doctor_score is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorScoreEqualTo(Double value) {
            addCriterion("doctor_score =", value, "doctorScore");
            return (Criteria) this;
        }

        public Criteria andDoctorScoreNotEqualTo(Double value) {
            addCriterion("doctor_score <>", value, "doctorScore");
            return (Criteria) this;
        }

        public Criteria andDoctorScoreGreaterThan(Double value) {
            addCriterion("doctor_score >", value, "doctorScore");
            return (Criteria) this;
        }

        public Criteria andDoctorScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("doctor_score >=", value, "doctorScore");
            return (Criteria) this;
        }

        public Criteria andDoctorScoreLessThan(Double value) {
            addCriterion("doctor_score <", value, "doctorScore");
            return (Criteria) this;
        }

        public Criteria andDoctorScoreLessThanOrEqualTo(Double value) {
            addCriterion("doctor_score <=", value, "doctorScore");
            return (Criteria) this;
        }

        public Criteria andDoctorScoreIn(List<Double> values) {
            addCriterion("doctor_score in", values, "doctorScore");
            return (Criteria) this;
        }

        public Criteria andDoctorScoreNotIn(List<Double> values) {
            addCriterion("doctor_score not in", values, "doctorScore");
            return (Criteria) this;
        }

        public Criteria andDoctorScoreBetween(Double value1, Double value2) {
            addCriterion("doctor_score between", value1, value2, "doctorScore");
            return (Criteria) this;
        }

        public Criteria andDoctorScoreNotBetween(Double value1, Double value2) {
            addCriterion("doctor_score not between", value1, value2, "doctorScore");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoIsNull() {
            addCriterion("doctor_logo is null");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoIsNotNull() {
            addCriterion("doctor_logo is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoEqualTo(String value) {
            addCriterion("doctor_logo =", value, "doctorLogo");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoNotEqualTo(String value) {
            addCriterion("doctor_logo <>", value, "doctorLogo");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoGreaterThan(String value) {
            addCriterion("doctor_logo >", value, "doctorLogo");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_logo >=", value, "doctorLogo");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoLessThan(String value) {
            addCriterion("doctor_logo <", value, "doctorLogo");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoLessThanOrEqualTo(String value) {
            addCriterion("doctor_logo <=", value, "doctorLogo");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoLike(String value) {
            addCriterion("doctor_logo like", value, "doctorLogo");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoNotLike(String value) {
            addCriterion("doctor_logo not like", value, "doctorLogo");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoIn(List<String> values) {
            addCriterion("doctor_logo in", values, "doctorLogo");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoNotIn(List<String> values) {
            addCriterion("doctor_logo not in", values, "doctorLogo");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoBetween(String value1, String value2) {
            addCriterion("doctor_logo between", value1, value2, "doctorLogo");
            return (Criteria) this;
        }

        public Criteria andDoctorLogoNotBetween(String value1, String value2) {
            addCriterion("doctor_logo not between", value1, value2, "doctorLogo");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPriceIsNull() {
            addCriterion("doctor_inquiry_price is null");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPriceIsNotNull() {
            addCriterion("doctor_inquiry_price is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPriceEqualTo(BigDecimal value) {
            addCriterion("doctor_inquiry_price =", value, "doctorInquiryPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPriceNotEqualTo(BigDecimal value) {
            addCriterion("doctor_inquiry_price <>", value, "doctorInquiryPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPriceGreaterThan(BigDecimal value) {
            addCriterion("doctor_inquiry_price >", value, "doctorInquiryPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("doctor_inquiry_price >=", value, "doctorInquiryPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPriceLessThan(BigDecimal value) {
            addCriterion("doctor_inquiry_price <", value, "doctorInquiryPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("doctor_inquiry_price <=", value, "doctorInquiryPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPriceIn(List<BigDecimal> values) {
            addCriterion("doctor_inquiry_price in", values, "doctorInquiryPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPriceNotIn(List<BigDecimal> values) {
            addCriterion("doctor_inquiry_price not in", values, "doctorInquiryPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("doctor_inquiry_price between", value1, value2, "doctorInquiryPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("doctor_inquiry_price not between", value1, value2, "doctorInquiryPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryImagePriceIsNull() {
            addCriterion("doctor_inquiry_image_price is null");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryImagePriceIsNotNull() {
            addCriterion("doctor_inquiry_image_price is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryImagePriceEqualTo(BigDecimal value) {
            addCriterion("doctor_inquiry_image_price =", value, "doctorInquiryImagePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryImagePriceNotEqualTo(BigDecimal value) {
            addCriterion("doctor_inquiry_image_price <>", value, "doctorInquiryImagePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryImagePriceGreaterThan(BigDecimal value) {
            addCriterion("doctor_inquiry_image_price >", value, "doctorInquiryImagePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryImagePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("doctor_inquiry_image_price >=", value, "doctorInquiryImagePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryImagePriceLessThan(BigDecimal value) {
            addCriterion("doctor_inquiry_image_price <", value, "doctorInquiryImagePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryImagePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("doctor_inquiry_image_price <=", value, "doctorInquiryImagePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryImagePriceIn(List<BigDecimal> values) {
            addCriterion("doctor_inquiry_image_price in", values, "doctorInquiryImagePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryImagePriceNotIn(List<BigDecimal> values) {
            addCriterion("doctor_inquiry_image_price not in", values, "doctorInquiryImagePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryImagePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("doctor_inquiry_image_price between", value1, value2, "doctorInquiryImagePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryImagePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("doctor_inquiry_image_price not between", value1, value2, "doctorInquiryImagePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPhonePriceIsNull() {
            addCriterion("doctor_inquiry_phone_price is null");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPhonePriceIsNotNull() {
            addCriterion("doctor_inquiry_phone_price is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPhonePriceEqualTo(BigDecimal value) {
            addCriterion("doctor_inquiry_phone_price =", value, "doctorInquiryPhonePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPhonePriceNotEqualTo(BigDecimal value) {
            addCriterion("doctor_inquiry_phone_price <>", value, "doctorInquiryPhonePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPhonePriceGreaterThan(BigDecimal value) {
            addCriterion("doctor_inquiry_phone_price >", value, "doctorInquiryPhonePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPhonePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("doctor_inquiry_phone_price >=", value, "doctorInquiryPhonePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPhonePriceLessThan(BigDecimal value) {
            addCriterion("doctor_inquiry_phone_price <", value, "doctorInquiryPhonePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPhonePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("doctor_inquiry_phone_price <=", value, "doctorInquiryPhonePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPhonePriceIn(List<BigDecimal> values) {
            addCriterion("doctor_inquiry_phone_price in", values, "doctorInquiryPhonePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPhonePriceNotIn(List<BigDecimal> values) {
            addCriterion("doctor_inquiry_phone_price not in", values, "doctorInquiryPhonePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPhonePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("doctor_inquiry_phone_price between", value1, value2, "doctorInquiryPhonePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryPhonePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("doctor_inquiry_phone_price not between", value1, value2, "doctorInquiryPhonePrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryCountIsNull() {
            addCriterion("doctor_inquiry_count is null");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryCountIsNotNull() {
            addCriterion("doctor_inquiry_count is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryCountEqualTo(Integer value) {
            addCriterion("doctor_inquiry_count =", value, "doctorInquiryCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryCountNotEqualTo(Integer value) {
            addCriterion("doctor_inquiry_count <>", value, "doctorInquiryCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryCountGreaterThan(Integer value) {
            addCriterion("doctor_inquiry_count >", value, "doctorInquiryCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor_inquiry_count >=", value, "doctorInquiryCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryCountLessThan(Integer value) {
            addCriterion("doctor_inquiry_count <", value, "doctorInquiryCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryCountLessThanOrEqualTo(Integer value) {
            addCriterion("doctor_inquiry_count <=", value, "doctorInquiryCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryCountIn(List<Integer> values) {
            addCriterion("doctor_inquiry_count in", values, "doctorInquiryCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryCountNotIn(List<Integer> values) {
            addCriterion("doctor_inquiry_count not in", values, "doctorInquiryCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryCountBetween(Integer value1, Integer value2) {
            addCriterion("doctor_inquiry_count between", value1, value2, "doctorInquiryCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInquiryCountNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor_inquiry_count not between", value1, value2, "doctorInquiryCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretPriceIsNull() {
            addCriterion("doctor_interpret_price is null");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretPriceIsNotNull() {
            addCriterion("doctor_interpret_price is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretPriceEqualTo(BigDecimal value) {
            addCriterion("doctor_interpret_price =", value, "doctorInterpretPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretPriceNotEqualTo(BigDecimal value) {
            addCriterion("doctor_interpret_price <>", value, "doctorInterpretPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretPriceGreaterThan(BigDecimal value) {
            addCriterion("doctor_interpret_price >", value, "doctorInterpretPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("doctor_interpret_price >=", value, "doctorInterpretPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretPriceLessThan(BigDecimal value) {
            addCriterion("doctor_interpret_price <", value, "doctorInterpretPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("doctor_interpret_price <=", value, "doctorInterpretPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretPriceIn(List<BigDecimal> values) {
            addCriterion("doctor_interpret_price in", values, "doctorInterpretPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretPriceNotIn(List<BigDecimal> values) {
            addCriterion("doctor_interpret_price not in", values, "doctorInterpretPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("doctor_interpret_price between", value1, value2, "doctorInterpretPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("doctor_interpret_price not between", value1, value2, "doctorInterpretPrice");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretCountIsNull() {
            addCriterion("doctor_interpret_count is null");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretCountIsNotNull() {
            addCriterion("doctor_interpret_count is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretCountEqualTo(Integer value) {
            addCriterion("doctor_interpret_count =", value, "doctorInterpretCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretCountNotEqualTo(Integer value) {
            addCriterion("doctor_interpret_count <>", value, "doctorInterpretCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretCountGreaterThan(Integer value) {
            addCriterion("doctor_interpret_count >", value, "doctorInterpretCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor_interpret_count >=", value, "doctorInterpretCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretCountLessThan(Integer value) {
            addCriterion("doctor_interpret_count <", value, "doctorInterpretCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretCountLessThanOrEqualTo(Integer value) {
            addCriterion("doctor_interpret_count <=", value, "doctorInterpretCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretCountIn(List<Integer> values) {
            addCriterion("doctor_interpret_count in", values, "doctorInterpretCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretCountNotIn(List<Integer> values) {
            addCriterion("doctor_interpret_count not in", values, "doctorInterpretCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretCountBetween(Integer value1, Integer value2) {
            addCriterion("doctor_interpret_count between", value1, value2, "doctorInterpretCount");
            return (Criteria) this;
        }

        public Criteria andDoctorInterpretCountNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor_interpret_count not between", value1, value2, "doctorInterpretCount");
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

        public Criteria andDoctorQrcodeIsNull() {
            addCriterion("doctor_QRcode is null");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeIsNotNull() {
            addCriterion("doctor_QRcode is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeEqualTo(String value) {
            addCriterion("doctor_QRcode =", value, "doctorQrcode");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeNotEqualTo(String value) {
            addCriterion("doctor_QRcode <>", value, "doctorQrcode");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeGreaterThan(String value) {
            addCriterion("doctor_QRcode >", value, "doctorQrcode");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_QRcode >=", value, "doctorQrcode");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeLessThan(String value) {
            addCriterion("doctor_QRcode <", value, "doctorQrcode");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeLessThanOrEqualTo(String value) {
            addCriterion("doctor_QRcode <=", value, "doctorQrcode");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeLike(String value) {
            addCriterion("doctor_QRcode like", value, "doctorQrcode");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeNotLike(String value) {
            addCriterion("doctor_QRcode not like", value, "doctorQrcode");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeIn(List<String> values) {
            addCriterion("doctor_QRcode in", values, "doctorQrcode");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeNotIn(List<String> values) {
            addCriterion("doctor_QRcode not in", values, "doctorQrcode");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeBetween(String value1, String value2) {
            addCriterion("doctor_QRcode between", value1, value2, "doctorQrcode");
            return (Criteria) this;
        }

        public Criteria andDoctorQrcodeNotBetween(String value1, String value2) {
            addCriterion("doctor_QRcode not between", value1, value2, "doctorQrcode");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidIsNull() {
            addCriterion("doctor_uuid is null");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidIsNotNull() {
            addCriterion("doctor_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidEqualTo(String value) {
            addCriterion("doctor_uuid =", value, "doctorUuid");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidNotEqualTo(String value) {
            addCriterion("doctor_uuid <>", value, "doctorUuid");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidGreaterThan(String value) {
            addCriterion("doctor_uuid >", value, "doctorUuid");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_uuid >=", value, "doctorUuid");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidLessThan(String value) {
            addCriterion("doctor_uuid <", value, "doctorUuid");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidLessThanOrEqualTo(String value) {
            addCriterion("doctor_uuid <=", value, "doctorUuid");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidLike(String value) {
            addCriterion("doctor_uuid like", value, "doctorUuid");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidNotLike(String value) {
            addCriterion("doctor_uuid not like", value, "doctorUuid");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidIn(List<String> values) {
            addCriterion("doctor_uuid in", values, "doctorUuid");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidNotIn(List<String> values) {
            addCriterion("doctor_uuid not in", values, "doctorUuid");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidBetween(String value1, String value2) {
            addCriterion("doctor_uuid between", value1, value2, "doctorUuid");
            return (Criteria) this;
        }

        public Criteria andDoctorUuidNotBetween(String value1, String value2) {
            addCriterion("doctor_uuid not between", value1, value2, "doctorUuid");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidIsNull() {
            addCriterion("doctor_openid is null");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidIsNotNull() {
            addCriterion("doctor_openid is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidEqualTo(String value) {
            addCriterion("doctor_openid =", value, "doctorOpenid");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidNotEqualTo(String value) {
            addCriterion("doctor_openid <>", value, "doctorOpenid");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidGreaterThan(String value) {
            addCriterion("doctor_openid >", value, "doctorOpenid");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_openid >=", value, "doctorOpenid");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidLessThan(String value) {
            addCriterion("doctor_openid <", value, "doctorOpenid");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidLessThanOrEqualTo(String value) {
            addCriterion("doctor_openid <=", value, "doctorOpenid");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidLike(String value) {
            addCriterion("doctor_openid like", value, "doctorOpenid");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidNotLike(String value) {
            addCriterion("doctor_openid not like", value, "doctorOpenid");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidIn(List<String> values) {
            addCriterion("doctor_openid in", values, "doctorOpenid");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidNotIn(List<String> values) {
            addCriterion("doctor_openid not in", values, "doctorOpenid");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidBetween(String value1, String value2) {
            addCriterion("doctor_openid between", value1, value2, "doctorOpenid");
            return (Criteria) this;
        }

        public Criteria andDoctorOpenidNotBetween(String value1, String value2) {
            addCriterion("doctor_openid not between", value1, value2, "doctorOpenid");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordIsNull() {
            addCriterion("doctor_password is null");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordIsNotNull() {
            addCriterion("doctor_password is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordEqualTo(String value) {
            addCriterion("doctor_password =", value, "doctorPassword");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordNotEqualTo(String value) {
            addCriterion("doctor_password <>", value, "doctorPassword");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordGreaterThan(String value) {
            addCriterion("doctor_password >", value, "doctorPassword");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_password >=", value, "doctorPassword");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordLessThan(String value) {
            addCriterion("doctor_password <", value, "doctorPassword");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordLessThanOrEqualTo(String value) {
            addCriterion("doctor_password <=", value, "doctorPassword");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordLike(String value) {
            addCriterion("doctor_password like", value, "doctorPassword");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordNotLike(String value) {
            addCriterion("doctor_password not like", value, "doctorPassword");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordIn(List<String> values) {
            addCriterion("doctor_password in", values, "doctorPassword");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordNotIn(List<String> values) {
            addCriterion("doctor_password not in", values, "doctorPassword");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordBetween(String value1, String value2) {
            addCriterion("doctor_password between", value1, value2, "doctorPassword");
            return (Criteria) this;
        }

        public Criteria andDoctorPasswordNotBetween(String value1, String value2) {
            addCriterion("doctor_password not between", value1, value2, "doctorPassword");
            return (Criteria) this;
        }

        public Criteria andDoctorAuthorityIsNull() {
            addCriterion("doctor_authority is null");
            return (Criteria) this;
        }

        public Criteria andDoctorAuthorityIsNotNull() {
            addCriterion("doctor_authority is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorAuthorityEqualTo(Integer value) {
            addCriterion("doctor_authority =", value, "doctorAuthority");
            return (Criteria) this;
        }

        public Criteria andDoctorAuthorityNotEqualTo(Integer value) {
            addCriterion("doctor_authority <>", value, "doctorAuthority");
            return (Criteria) this;
        }

        public Criteria andDoctorAuthorityGreaterThan(Integer value) {
            addCriterion("doctor_authority >", value, "doctorAuthority");
            return (Criteria) this;
        }

        public Criteria andDoctorAuthorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor_authority >=", value, "doctorAuthority");
            return (Criteria) this;
        }

        public Criteria andDoctorAuthorityLessThan(Integer value) {
            addCriterion("doctor_authority <", value, "doctorAuthority");
            return (Criteria) this;
        }

        public Criteria andDoctorAuthorityLessThanOrEqualTo(Integer value) {
            addCriterion("doctor_authority <=", value, "doctorAuthority");
            return (Criteria) this;
        }

        public Criteria andDoctorAuthorityIn(List<Integer> values) {
            addCriterion("doctor_authority in", values, "doctorAuthority");
            return (Criteria) this;
        }

        public Criteria andDoctorAuthorityNotIn(List<Integer> values) {
            addCriterion("doctor_authority not in", values, "doctorAuthority");
            return (Criteria) this;
        }

        public Criteria andDoctorAuthorityBetween(Integer value1, Integer value2) {
            addCriterion("doctor_authority between", value1, value2, "doctorAuthority");
            return (Criteria) this;
        }

        public Criteria andDoctorAuthorityNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor_authority not between", value1, value2, "doctorAuthority");
            return (Criteria) this;
        }

        public Criteria andDoctorOrderCredentialsIsNull() {
            addCriterion("doctor_order_credentials is null");
            return (Criteria) this;
        }

        public Criteria andDoctorOrderCredentialsIsNotNull() {
            addCriterion("doctor_order_credentials is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorOrderCredentialsEqualTo(Integer value) {
            addCriterion("doctor_order_credentials =", value, "doctorOrderCredentials");
            return (Criteria) this;
        }

        public Criteria andDoctorOrderCredentialsNotEqualTo(Integer value) {
            addCriterion("doctor_order_credentials <>", value, "doctorOrderCredentials");
            return (Criteria) this;
        }

        public Criteria andDoctorOrderCredentialsGreaterThan(Integer value) {
            addCriterion("doctor_order_credentials >", value, "doctorOrderCredentials");
            return (Criteria) this;
        }

        public Criteria andDoctorOrderCredentialsGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor_order_credentials >=", value, "doctorOrderCredentials");
            return (Criteria) this;
        }

        public Criteria andDoctorOrderCredentialsLessThan(Integer value) {
            addCriterion("doctor_order_credentials <", value, "doctorOrderCredentials");
            return (Criteria) this;
        }

        public Criteria andDoctorOrderCredentialsLessThanOrEqualTo(Integer value) {
            addCriterion("doctor_order_credentials <=", value, "doctorOrderCredentials");
            return (Criteria) this;
        }

        public Criteria andDoctorOrderCredentialsIn(List<Integer> values) {
            addCriterion("doctor_order_credentials in", values, "doctorOrderCredentials");
            return (Criteria) this;
        }

        public Criteria andDoctorOrderCredentialsNotIn(List<Integer> values) {
            addCriterion("doctor_order_credentials not in", values, "doctorOrderCredentials");
            return (Criteria) this;
        }

        public Criteria andDoctorOrderCredentialsBetween(Integer value1, Integer value2) {
            addCriterion("doctor_order_credentials between", value1, value2, "doctorOrderCredentials");
            return (Criteria) this;
        }

        public Criteria andDoctorOrderCredentialsNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor_order_credentials not between", value1, value2, "doctorOrderCredentials");
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