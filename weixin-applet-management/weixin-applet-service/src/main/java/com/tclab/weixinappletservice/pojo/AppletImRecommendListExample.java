package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletImRecommendListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletImRecommendListExample() {
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

        public Criteria andImRecommendListIdIsNull() {
            addCriterion("im_recommend_list_id is null");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdIsNotNull() {
            addCriterion("im_recommend_list_id is not null");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdEqualTo(String value) {
            addCriterion("im_recommend_list_id =", value, "imRecommendListId");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdNotEqualTo(String value) {
            addCriterion("im_recommend_list_id <>", value, "imRecommendListId");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdGreaterThan(String value) {
            addCriterion("im_recommend_list_id >", value, "imRecommendListId");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdGreaterThanOrEqualTo(String value) {
            addCriterion("im_recommend_list_id >=", value, "imRecommendListId");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdLessThan(String value) {
            addCriterion("im_recommend_list_id <", value, "imRecommendListId");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdLessThanOrEqualTo(String value) {
            addCriterion("im_recommend_list_id <=", value, "imRecommendListId");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdLike(String value) {
            addCriterion("im_recommend_list_id like", value, "imRecommendListId");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdNotLike(String value) {
            addCriterion("im_recommend_list_id not like", value, "imRecommendListId");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdIn(List<String> values) {
            addCriterion("im_recommend_list_id in", values, "imRecommendListId");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdNotIn(List<String> values) {
            addCriterion("im_recommend_list_id not in", values, "imRecommendListId");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdBetween(String value1, String value2) {
            addCriterion("im_recommend_list_id between", value1, value2, "imRecommendListId");
            return (Criteria) this;
        }

        public Criteria andImRecommendListIdNotBetween(String value1, String value2) {
            addCriterion("im_recommend_list_id not between", value1, value2, "imRecommendListId");
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

        public Criteria andParticipantIdIsNull() {
            addCriterion("participant_id is null");
            return (Criteria) this;
        }

        public Criteria andParticipantIdIsNotNull() {
            addCriterion("participant_id is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantIdEqualTo(String value) {
            addCriterion("participant_id =", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdNotEqualTo(String value) {
            addCriterion("participant_id <>", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdGreaterThan(String value) {
            addCriterion("participant_id >", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdGreaterThanOrEqualTo(String value) {
            addCriterion("participant_id >=", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdLessThan(String value) {
            addCriterion("participant_id <", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdLessThanOrEqualTo(String value) {
            addCriterion("participant_id <=", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdLike(String value) {
            addCriterion("participant_id like", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdNotLike(String value) {
            addCriterion("participant_id not like", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdIn(List<String> values) {
            addCriterion("participant_id in", values, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdNotIn(List<String> values) {
            addCriterion("participant_id not in", values, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdBetween(String value1, String value2) {
            addCriterion("participant_id between", value1, value2, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdNotBetween(String value1, String value2) {
            addCriterion("participant_id not between", value1, value2, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantNameIsNull() {
            addCriterion("participant_name is null");
            return (Criteria) this;
        }

        public Criteria andParticipantNameIsNotNull() {
            addCriterion("participant_name is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantNameEqualTo(String value) {
            addCriterion("participant_name =", value, "participantName");
            return (Criteria) this;
        }

        public Criteria andParticipantNameNotEqualTo(String value) {
            addCriterion("participant_name <>", value, "participantName");
            return (Criteria) this;
        }

        public Criteria andParticipantNameGreaterThan(String value) {
            addCriterion("participant_name >", value, "participantName");
            return (Criteria) this;
        }

        public Criteria andParticipantNameGreaterThanOrEqualTo(String value) {
            addCriterion("participant_name >=", value, "participantName");
            return (Criteria) this;
        }

        public Criteria andParticipantNameLessThan(String value) {
            addCriterion("participant_name <", value, "participantName");
            return (Criteria) this;
        }

        public Criteria andParticipantNameLessThanOrEqualTo(String value) {
            addCriterion("participant_name <=", value, "participantName");
            return (Criteria) this;
        }

        public Criteria andParticipantNameLike(String value) {
            addCriterion("participant_name like", value, "participantName");
            return (Criteria) this;
        }

        public Criteria andParticipantNameNotLike(String value) {
            addCriterion("participant_name not like", value, "participantName");
            return (Criteria) this;
        }

        public Criteria andParticipantNameIn(List<String> values) {
            addCriterion("participant_name in", values, "participantName");
            return (Criteria) this;
        }

        public Criteria andParticipantNameNotIn(List<String> values) {
            addCriterion("participant_name not in", values, "participantName");
            return (Criteria) this;
        }

        public Criteria andParticipantNameBetween(String value1, String value2) {
            addCriterion("participant_name between", value1, value2, "participantName");
            return (Criteria) this;
        }

        public Criteria andParticipantNameNotBetween(String value1, String value2) {
            addCriterion("participant_name not between", value1, value2, "participantName");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneIsNull() {
            addCriterion("participant_phone is null");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneIsNotNull() {
            addCriterion("participant_phone is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneEqualTo(String value) {
            addCriterion("participant_phone =", value, "participantPhone");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneNotEqualTo(String value) {
            addCriterion("participant_phone <>", value, "participantPhone");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneGreaterThan(String value) {
            addCriterion("participant_phone >", value, "participantPhone");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("participant_phone >=", value, "participantPhone");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneLessThan(String value) {
            addCriterion("participant_phone <", value, "participantPhone");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneLessThanOrEqualTo(String value) {
            addCriterion("participant_phone <=", value, "participantPhone");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneLike(String value) {
            addCriterion("participant_phone like", value, "participantPhone");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneNotLike(String value) {
            addCriterion("participant_phone not like", value, "participantPhone");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneIn(List<String> values) {
            addCriterion("participant_phone in", values, "participantPhone");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneNotIn(List<String> values) {
            addCriterion("participant_phone not in", values, "participantPhone");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneBetween(String value1, String value2) {
            addCriterion("participant_phone between", value1, value2, "participantPhone");
            return (Criteria) this;
        }

        public Criteria andParticipantPhoneNotBetween(String value1, String value2) {
            addCriterion("participant_phone not between", value1, value2, "participantPhone");
            return (Criteria) this;
        }

        public Criteria andParticipantSexIsNull() {
            addCriterion("participant_sex is null");
            return (Criteria) this;
        }

        public Criteria andParticipantSexIsNotNull() {
            addCriterion("participant_sex is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantSexEqualTo(Integer value) {
            addCriterion("participant_sex =", value, "participantSex");
            return (Criteria) this;
        }

        public Criteria andParticipantSexNotEqualTo(Integer value) {
            addCriterion("participant_sex <>", value, "participantSex");
            return (Criteria) this;
        }

        public Criteria andParticipantSexGreaterThan(Integer value) {
            addCriterion("participant_sex >", value, "participantSex");
            return (Criteria) this;
        }

        public Criteria andParticipantSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("participant_sex >=", value, "participantSex");
            return (Criteria) this;
        }

        public Criteria andParticipantSexLessThan(Integer value) {
            addCriterion("participant_sex <", value, "participantSex");
            return (Criteria) this;
        }

        public Criteria andParticipantSexLessThanOrEqualTo(Integer value) {
            addCriterion("participant_sex <=", value, "participantSex");
            return (Criteria) this;
        }

        public Criteria andParticipantSexIn(List<Integer> values) {
            addCriterion("participant_sex in", values, "participantSex");
            return (Criteria) this;
        }

        public Criteria andParticipantSexNotIn(List<Integer> values) {
            addCriterion("participant_sex not in", values, "participantSex");
            return (Criteria) this;
        }

        public Criteria andParticipantSexBetween(Integer value1, Integer value2) {
            addCriterion("participant_sex between", value1, value2, "participantSex");
            return (Criteria) this;
        }

        public Criteria andParticipantSexNotBetween(Integer value1, Integer value2) {
            addCriterion("participant_sex not between", value1, value2, "participantSex");
            return (Criteria) this;
        }

        public Criteria andParticipantAgeIsNull() {
            addCriterion("participant_age is null");
            return (Criteria) this;
        }

        public Criteria andParticipantAgeIsNotNull() {
            addCriterion("participant_age is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantAgeEqualTo(Integer value) {
            addCriterion("participant_age =", value, "participantAge");
            return (Criteria) this;
        }

        public Criteria andParticipantAgeNotEqualTo(Integer value) {
            addCriterion("participant_age <>", value, "participantAge");
            return (Criteria) this;
        }

        public Criteria andParticipantAgeGreaterThan(Integer value) {
            addCriterion("participant_age >", value, "participantAge");
            return (Criteria) this;
        }

        public Criteria andParticipantAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("participant_age >=", value, "participantAge");
            return (Criteria) this;
        }

        public Criteria andParticipantAgeLessThan(Integer value) {
            addCriterion("participant_age <", value, "participantAge");
            return (Criteria) this;
        }

        public Criteria andParticipantAgeLessThanOrEqualTo(Integer value) {
            addCriterion("participant_age <=", value, "participantAge");
            return (Criteria) this;
        }

        public Criteria andParticipantAgeIn(List<Integer> values) {
            addCriterion("participant_age in", values, "participantAge");
            return (Criteria) this;
        }

        public Criteria andParticipantAgeNotIn(List<Integer> values) {
            addCriterion("participant_age not in", values, "participantAge");
            return (Criteria) this;
        }

        public Criteria andParticipantAgeBetween(Integer value1, Integer value2) {
            addCriterion("participant_age between", value1, value2, "participantAge");
            return (Criteria) this;
        }

        public Criteria andParticipantAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("participant_age not between", value1, value2, "participantAge");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryIsNull() {
            addCriterion("participant_medical_history is null");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryIsNotNull() {
            addCriterion("participant_medical_history is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryEqualTo(String value) {
            addCriterion("participant_medical_history =", value, "participantMedicalHistory");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryNotEqualTo(String value) {
            addCriterion("participant_medical_history <>", value, "participantMedicalHistory");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryGreaterThan(String value) {
            addCriterion("participant_medical_history >", value, "participantMedicalHistory");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("participant_medical_history >=", value, "participantMedicalHistory");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryLessThan(String value) {
            addCriterion("participant_medical_history <", value, "participantMedicalHistory");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryLessThanOrEqualTo(String value) {
            addCriterion("participant_medical_history <=", value, "participantMedicalHistory");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryLike(String value) {
            addCriterion("participant_medical_history like", value, "participantMedicalHistory");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryNotLike(String value) {
            addCriterion("participant_medical_history not like", value, "participantMedicalHistory");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryIn(List<String> values) {
            addCriterion("participant_medical_history in", values, "participantMedicalHistory");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryNotIn(List<String> values) {
            addCriterion("participant_medical_history not in", values, "participantMedicalHistory");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryBetween(String value1, String value2) {
            addCriterion("participant_medical_history between", value1, value2, "participantMedicalHistory");
            return (Criteria) this;
        }

        public Criteria andParticipantMedicalHistoryNotBetween(String value1, String value2) {
            addCriterion("participant_medical_history not between", value1, value2, "participantMedicalHistory");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardIsNull() {
            addCriterion("participant_id_card is null");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardIsNotNull() {
            addCriterion("participant_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardEqualTo(String value) {
            addCriterion("participant_id_card =", value, "participantIdCard");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardNotEqualTo(String value) {
            addCriterion("participant_id_card <>", value, "participantIdCard");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardGreaterThan(String value) {
            addCriterion("participant_id_card >", value, "participantIdCard");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("participant_id_card >=", value, "participantIdCard");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardLessThan(String value) {
            addCriterion("participant_id_card <", value, "participantIdCard");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardLessThanOrEqualTo(String value) {
            addCriterion("participant_id_card <=", value, "participantIdCard");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardLike(String value) {
            addCriterion("participant_id_card like", value, "participantIdCard");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardNotLike(String value) {
            addCriterion("participant_id_card not like", value, "participantIdCard");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardIn(List<String> values) {
            addCriterion("participant_id_card in", values, "participantIdCard");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardNotIn(List<String> values) {
            addCriterion("participant_id_card not in", values, "participantIdCard");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardBetween(String value1, String value2) {
            addCriterion("participant_id_card between", value1, value2, "participantIdCard");
            return (Criteria) this;
        }

        public Criteria andParticipantIdCardNotBetween(String value1, String value2) {
            addCriterion("participant_id_card not between", value1, value2, "participantIdCard");
            return (Criteria) this;
        }

        public Criteria andReviewTypeIsNull() {
            addCriterion("review_type is null");
            return (Criteria) this;
        }

        public Criteria andReviewTypeIsNotNull() {
            addCriterion("review_type is not null");
            return (Criteria) this;
        }

        public Criteria andReviewTypeEqualTo(Integer value) {
            addCriterion("review_type =", value, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeNotEqualTo(Integer value) {
            addCriterion("review_type <>", value, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeGreaterThan(Integer value) {
            addCriterion("review_type >", value, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_type >=", value, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeLessThan(Integer value) {
            addCriterion("review_type <", value, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeLessThanOrEqualTo(Integer value) {
            addCriterion("review_type <=", value, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeIn(List<Integer> values) {
            addCriterion("review_type in", values, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeNotIn(List<Integer> values) {
            addCriterion("review_type not in", values, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeBetween(Integer value1, Integer value2) {
            addCriterion("review_type between", value1, value2, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("review_type not between", value1, value2, "reviewType");
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusIsNull() {
            addCriterion("recommend_status is null");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusIsNotNull() {
            addCriterion("recommend_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusEqualTo(Integer value) {
            addCriterion("recommend_status =", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotEqualTo(Integer value) {
            addCriterion("recommend_status <>", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusGreaterThan(Integer value) {
            addCriterion("recommend_status >", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommend_status >=", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusLessThan(Integer value) {
            addCriterion("recommend_status <", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("recommend_status <=", value, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusIn(List<Integer> values) {
            addCriterion("recommend_status in", values, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotIn(List<Integer> values) {
            addCriterion("recommend_status not in", values, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusBetween(Integer value1, Integer value2) {
            addCriterion("recommend_status between", value1, value2, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("recommend_status not between", value1, value2, "recommendStatus");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkIsNull() {
            addCriterion("recommend_remark is null");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkIsNotNull() {
            addCriterion("recommend_remark is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkEqualTo(String value) {
            addCriterion("recommend_remark =", value, "recommendRemark");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkNotEqualTo(String value) {
            addCriterion("recommend_remark <>", value, "recommendRemark");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkGreaterThan(String value) {
            addCriterion("recommend_remark >", value, "recommendRemark");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_remark >=", value, "recommendRemark");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkLessThan(String value) {
            addCriterion("recommend_remark <", value, "recommendRemark");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkLessThanOrEqualTo(String value) {
            addCriterion("recommend_remark <=", value, "recommendRemark");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkLike(String value) {
            addCriterion("recommend_remark like", value, "recommendRemark");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkNotLike(String value) {
            addCriterion("recommend_remark not like", value, "recommendRemark");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkIn(List<String> values) {
            addCriterion("recommend_remark in", values, "recommendRemark");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkNotIn(List<String> values) {
            addCriterion("recommend_remark not in", values, "recommendRemark");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkBetween(String value1, String value2) {
            addCriterion("recommend_remark between", value1, value2, "recommendRemark");
            return (Criteria) this;
        }

        public Criteria andRecommendRemarkNotBetween(String value1, String value2) {
            addCriterion("recommend_remark not between", value1, value2, "recommendRemark");
            return (Criteria) this;
        }

        public Criteria andImrecordIdIsNull() {
            addCriterion("imrecord_id is null");
            return (Criteria) this;
        }

        public Criteria andImrecordIdIsNotNull() {
            addCriterion("imrecord_id is not null");
            return (Criteria) this;
        }

        public Criteria andImrecordIdEqualTo(String value) {
            addCriterion("imrecord_id =", value, "imrecordId");
            return (Criteria) this;
        }

        public Criteria andImrecordIdNotEqualTo(String value) {
            addCriterion("imrecord_id <>", value, "imrecordId");
            return (Criteria) this;
        }

        public Criteria andImrecordIdGreaterThan(String value) {
            addCriterion("imrecord_id >", value, "imrecordId");
            return (Criteria) this;
        }

        public Criteria andImrecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("imrecord_id >=", value, "imrecordId");
            return (Criteria) this;
        }

        public Criteria andImrecordIdLessThan(String value) {
            addCriterion("imrecord_id <", value, "imrecordId");
            return (Criteria) this;
        }

        public Criteria andImrecordIdLessThanOrEqualTo(String value) {
            addCriterion("imrecord_id <=", value, "imrecordId");
            return (Criteria) this;
        }

        public Criteria andImrecordIdLike(String value) {
            addCriterion("imrecord_id like", value, "imrecordId");
            return (Criteria) this;
        }

        public Criteria andImrecordIdNotLike(String value) {
            addCriterion("imrecord_id not like", value, "imrecordId");
            return (Criteria) this;
        }

        public Criteria andImrecordIdIn(List<String> values) {
            addCriterion("imrecord_id in", values, "imrecordId");
            return (Criteria) this;
        }

        public Criteria andImrecordIdNotIn(List<String> values) {
            addCriterion("imrecord_id not in", values, "imrecordId");
            return (Criteria) this;
        }

        public Criteria andImrecordIdBetween(String value1, String value2) {
            addCriterion("imrecord_id between", value1, value2, "imrecordId");
            return (Criteria) this;
        }

        public Criteria andImrecordIdNotBetween(String value1, String value2) {
            addCriterion("imrecord_id not between", value1, value2, "imrecordId");
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