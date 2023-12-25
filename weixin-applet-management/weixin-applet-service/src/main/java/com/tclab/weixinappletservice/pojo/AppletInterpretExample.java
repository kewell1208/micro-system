package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletInterpretExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletInterpretExample() {
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

        public Criteria andInterpretIdIsNull() {
            addCriterion("interpret_id is null");
            return (Criteria) this;
        }

        public Criteria andInterpretIdIsNotNull() {
            addCriterion("interpret_id is not null");
            return (Criteria) this;
        }

        public Criteria andInterpretIdEqualTo(String value) {
            addCriterion("interpret_id =", value, "interpretId");
            return (Criteria) this;
        }

        public Criteria andInterpretIdNotEqualTo(String value) {
            addCriterion("interpret_id <>", value, "interpretId");
            return (Criteria) this;
        }

        public Criteria andInterpretIdGreaterThan(String value) {
            addCriterion("interpret_id >", value, "interpretId");
            return (Criteria) this;
        }

        public Criteria andInterpretIdGreaterThanOrEqualTo(String value) {
            addCriterion("interpret_id >=", value, "interpretId");
            return (Criteria) this;
        }

        public Criteria andInterpretIdLessThan(String value) {
            addCriterion("interpret_id <", value, "interpretId");
            return (Criteria) this;
        }

        public Criteria andInterpretIdLessThanOrEqualTo(String value) {
            addCriterion("interpret_id <=", value, "interpretId");
            return (Criteria) this;
        }

        public Criteria andInterpretIdLike(String value) {
            addCriterion("interpret_id like", value, "interpretId");
            return (Criteria) this;
        }

        public Criteria andInterpretIdNotLike(String value) {
            addCriterion("interpret_id not like", value, "interpretId");
            return (Criteria) this;
        }

        public Criteria andInterpretIdIn(List<String> values) {
            addCriterion("interpret_id in", values, "interpretId");
            return (Criteria) this;
        }

        public Criteria andInterpretIdNotIn(List<String> values) {
            addCriterion("interpret_id not in", values, "interpretId");
            return (Criteria) this;
        }

        public Criteria andInterpretIdBetween(String value1, String value2) {
            addCriterion("interpret_id between", value1, value2, "interpretId");
            return (Criteria) this;
        }

        public Criteria andInterpretIdNotBetween(String value1, String value2) {
            addCriterion("interpret_id not between", value1, value2, "interpretId");
            return (Criteria) this;
        }

        public Criteria andImRecordIdIsNull() {
            addCriterion("im_record_id is null");
            return (Criteria) this;
        }

        public Criteria andImRecordIdIsNotNull() {
            addCriterion("im_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andImRecordIdEqualTo(String value) {
            addCriterion("im_record_id =", value, "imRecordId");
            return (Criteria) this;
        }

        public Criteria andImRecordIdNotEqualTo(String value) {
            addCriterion("im_record_id <>", value, "imRecordId");
            return (Criteria) this;
        }

        public Criteria andImRecordIdGreaterThan(String value) {
            addCriterion("im_record_id >", value, "imRecordId");
            return (Criteria) this;
        }

        public Criteria andImRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("im_record_id >=", value, "imRecordId");
            return (Criteria) this;
        }

        public Criteria andImRecordIdLessThan(String value) {
            addCriterion("im_record_id <", value, "imRecordId");
            return (Criteria) this;
        }

        public Criteria andImRecordIdLessThanOrEqualTo(String value) {
            addCriterion("im_record_id <=", value, "imRecordId");
            return (Criteria) this;
        }

        public Criteria andImRecordIdLike(String value) {
            addCriterion("im_record_id like", value, "imRecordId");
            return (Criteria) this;
        }

        public Criteria andImRecordIdNotLike(String value) {
            addCriterion("im_record_id not like", value, "imRecordId");
            return (Criteria) this;
        }

        public Criteria andImRecordIdIn(List<String> values) {
            addCriterion("im_record_id in", values, "imRecordId");
            return (Criteria) this;
        }

        public Criteria andImRecordIdNotIn(List<String> values) {
            addCriterion("im_record_id not in", values, "imRecordId");
            return (Criteria) this;
        }

        public Criteria andImRecordIdBetween(String value1, String value2) {
            addCriterion("im_record_id between", value1, value2, "imRecordId");
            return (Criteria) this;
        }

        public Criteria andImRecordIdNotBetween(String value1, String value2) {
            addCriterion("im_record_id not between", value1, value2, "imRecordId");
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

        public Criteria andInterpretImgIsNull() {
            addCriterion("interpret_img is null");
            return (Criteria) this;
        }

        public Criteria andInterpretImgIsNotNull() {
            addCriterion("interpret_img is not null");
            return (Criteria) this;
        }

        public Criteria andInterpretImgEqualTo(String value) {
            addCriterion("interpret_img =", value, "interpretImg");
            return (Criteria) this;
        }

        public Criteria andInterpretImgNotEqualTo(String value) {
            addCriterion("interpret_img <>", value, "interpretImg");
            return (Criteria) this;
        }

        public Criteria andInterpretImgGreaterThan(String value) {
            addCriterion("interpret_img >", value, "interpretImg");
            return (Criteria) this;
        }

        public Criteria andInterpretImgGreaterThanOrEqualTo(String value) {
            addCriterion("interpret_img >=", value, "interpretImg");
            return (Criteria) this;
        }

        public Criteria andInterpretImgLessThan(String value) {
            addCriterion("interpret_img <", value, "interpretImg");
            return (Criteria) this;
        }

        public Criteria andInterpretImgLessThanOrEqualTo(String value) {
            addCriterion("interpret_img <=", value, "interpretImg");
            return (Criteria) this;
        }

        public Criteria andInterpretImgLike(String value) {
            addCriterion("interpret_img like", value, "interpretImg");
            return (Criteria) this;
        }

        public Criteria andInterpretImgNotLike(String value) {
            addCriterion("interpret_img not like", value, "interpretImg");
            return (Criteria) this;
        }

        public Criteria andInterpretImgIn(List<String> values) {
            addCriterion("interpret_img in", values, "interpretImg");
            return (Criteria) this;
        }

        public Criteria andInterpretImgNotIn(List<String> values) {
            addCriterion("interpret_img not in", values, "interpretImg");
            return (Criteria) this;
        }

        public Criteria andInterpretImgBetween(String value1, String value2) {
            addCriterion("interpret_img between", value1, value2, "interpretImg");
            return (Criteria) this;
        }

        public Criteria andInterpretImgNotBetween(String value1, String value2) {
            addCriterion("interpret_img not between", value1, value2, "interpretImg");
            return (Criteria) this;
        }

        public Criteria andInterpretContentIsNull() {
            addCriterion("interpret_content is null");
            return (Criteria) this;
        }

        public Criteria andInterpretContentIsNotNull() {
            addCriterion("interpret_content is not null");
            return (Criteria) this;
        }

        public Criteria andInterpretContentEqualTo(String value) {
            addCriterion("interpret_content =", value, "interpretContent");
            return (Criteria) this;
        }

        public Criteria andInterpretContentNotEqualTo(String value) {
            addCriterion("interpret_content <>", value, "interpretContent");
            return (Criteria) this;
        }

        public Criteria andInterpretContentGreaterThan(String value) {
            addCriterion("interpret_content >", value, "interpretContent");
            return (Criteria) this;
        }

        public Criteria andInterpretContentGreaterThanOrEqualTo(String value) {
            addCriterion("interpret_content >=", value, "interpretContent");
            return (Criteria) this;
        }

        public Criteria andInterpretContentLessThan(String value) {
            addCriterion("interpret_content <", value, "interpretContent");
            return (Criteria) this;
        }

        public Criteria andInterpretContentLessThanOrEqualTo(String value) {
            addCriterion("interpret_content <=", value, "interpretContent");
            return (Criteria) this;
        }

        public Criteria andInterpretContentLike(String value) {
            addCriterion("interpret_content like", value, "interpretContent");
            return (Criteria) this;
        }

        public Criteria andInterpretContentNotLike(String value) {
            addCriterion("interpret_content not like", value, "interpretContent");
            return (Criteria) this;
        }

        public Criteria andInterpretContentIn(List<String> values) {
            addCriterion("interpret_content in", values, "interpretContent");
            return (Criteria) this;
        }

        public Criteria andInterpretContentNotIn(List<String> values) {
            addCriterion("interpret_content not in", values, "interpretContent");
            return (Criteria) this;
        }

        public Criteria andInterpretContentBetween(String value1, String value2) {
            addCriterion("interpret_content between", value1, value2, "interpretContent");
            return (Criteria) this;
        }

        public Criteria andInterpretContentNotBetween(String value1, String value2) {
            addCriterion("interpret_content not between", value1, value2, "interpretContent");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseIsNull() {
            addCriterion("participant_diagnose is null");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseIsNotNull() {
            addCriterion("participant_diagnose is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseEqualTo(String value) {
            addCriterion("participant_diagnose =", value, "participantDiagnose");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseNotEqualTo(String value) {
            addCriterion("participant_diagnose <>", value, "participantDiagnose");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseGreaterThan(String value) {
            addCriterion("participant_diagnose >", value, "participantDiagnose");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseGreaterThanOrEqualTo(String value) {
            addCriterion("participant_diagnose >=", value, "participantDiagnose");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseLessThan(String value) {
            addCriterion("participant_diagnose <", value, "participantDiagnose");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseLessThanOrEqualTo(String value) {
            addCriterion("participant_diagnose <=", value, "participantDiagnose");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseLike(String value) {
            addCriterion("participant_diagnose like", value, "participantDiagnose");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseNotLike(String value) {
            addCriterion("participant_diagnose not like", value, "participantDiagnose");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseIn(List<String> values) {
            addCriterion("participant_diagnose in", values, "participantDiagnose");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseNotIn(List<String> values) {
            addCriterion("participant_diagnose not in", values, "participantDiagnose");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseBetween(String value1, String value2) {
            addCriterion("participant_diagnose between", value1, value2, "participantDiagnose");
            return (Criteria) this;
        }

        public Criteria andParticipantDiagnoseNotBetween(String value1, String value2) {
            addCriterion("participant_diagnose not between", value1, value2, "participantDiagnose");
            return (Criteria) this;
        }

        public Criteria andInterpretDateIsNull() {
            addCriterion("interpret_date is null");
            return (Criteria) this;
        }

        public Criteria andInterpretDateIsNotNull() {
            addCriterion("interpret_date is not null");
            return (Criteria) this;
        }

        public Criteria andInterpretDateEqualTo(Date value) {
            addCriterion("interpret_date =", value, "interpretDate");
            return (Criteria) this;
        }

        public Criteria andInterpretDateNotEqualTo(Date value) {
            addCriterion("interpret_date <>", value, "interpretDate");
            return (Criteria) this;
        }

        public Criteria andInterpretDateGreaterThan(Date value) {
            addCriterion("interpret_date >", value, "interpretDate");
            return (Criteria) this;
        }

        public Criteria andInterpretDateGreaterThanOrEqualTo(Date value) {
            addCriterion("interpret_date >=", value, "interpretDate");
            return (Criteria) this;
        }

        public Criteria andInterpretDateLessThan(Date value) {
            addCriterion("interpret_date <", value, "interpretDate");
            return (Criteria) this;
        }

        public Criteria andInterpretDateLessThanOrEqualTo(Date value) {
            addCriterion("interpret_date <=", value, "interpretDate");
            return (Criteria) this;
        }

        public Criteria andInterpretDateIn(List<Date> values) {
            addCriterion("interpret_date in", values, "interpretDate");
            return (Criteria) this;
        }

        public Criteria andInterpretDateNotIn(List<Date> values) {
            addCriterion("interpret_date not in", values, "interpretDate");
            return (Criteria) this;
        }

        public Criteria andInterpretDateBetween(Date value1, Date value2) {
            addCriterion("interpret_date between", value1, value2, "interpretDate");
            return (Criteria) this;
        }

        public Criteria andInterpretDateNotBetween(Date value1, Date value2) {
            addCriterion("interpret_date not between", value1, value2, "interpretDate");
            return (Criteria) this;
        }

        public Criteria andInterpretTypeIsNull() {
            addCriterion("interpret_type is null");
            return (Criteria) this;
        }

        public Criteria andInterpretTypeIsNotNull() {
            addCriterion("interpret_type is not null");
            return (Criteria) this;
        }

        public Criteria andInterpretTypeEqualTo(Integer value) {
            addCriterion("interpret_type =", value, "interpretType");
            return (Criteria) this;
        }

        public Criteria andInterpretTypeNotEqualTo(Integer value) {
            addCriterion("interpret_type <>", value, "interpretType");
            return (Criteria) this;
        }

        public Criteria andInterpretTypeGreaterThan(Integer value) {
            addCriterion("interpret_type >", value, "interpretType");
            return (Criteria) this;
        }

        public Criteria andInterpretTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("interpret_type >=", value, "interpretType");
            return (Criteria) this;
        }

        public Criteria andInterpretTypeLessThan(Integer value) {
            addCriterion("interpret_type <", value, "interpretType");
            return (Criteria) this;
        }

        public Criteria andInterpretTypeLessThanOrEqualTo(Integer value) {
            addCriterion("interpret_type <=", value, "interpretType");
            return (Criteria) this;
        }

        public Criteria andInterpretTypeIn(List<Integer> values) {
            addCriterion("interpret_type in", values, "interpretType");
            return (Criteria) this;
        }

        public Criteria andInterpretTypeNotIn(List<Integer> values) {
            addCriterion("interpret_type not in", values, "interpretType");
            return (Criteria) this;
        }

        public Criteria andInterpretTypeBetween(Integer value1, Integer value2) {
            addCriterion("interpret_type between", value1, value2, "interpretType");
            return (Criteria) this;
        }

        public Criteria andInterpretTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("interpret_type not between", value1, value2, "interpretType");
            return (Criteria) this;
        }

        public Criteria andInterpretCostIsNull() {
            addCriterion("interpret_cost is null");
            return (Criteria) this;
        }

        public Criteria andInterpretCostIsNotNull() {
            addCriterion("interpret_cost is not null");
            return (Criteria) this;
        }

        public Criteria andInterpretCostEqualTo(BigDecimal value) {
            addCriterion("interpret_cost =", value, "interpretCost");
            return (Criteria) this;
        }

        public Criteria andInterpretCostNotEqualTo(BigDecimal value) {
            addCriterion("interpret_cost <>", value, "interpretCost");
            return (Criteria) this;
        }

        public Criteria andInterpretCostGreaterThan(BigDecimal value) {
            addCriterion("interpret_cost >", value, "interpretCost");
            return (Criteria) this;
        }

        public Criteria andInterpretCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("interpret_cost >=", value, "interpretCost");
            return (Criteria) this;
        }

        public Criteria andInterpretCostLessThan(BigDecimal value) {
            addCriterion("interpret_cost <", value, "interpretCost");
            return (Criteria) this;
        }

        public Criteria andInterpretCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("interpret_cost <=", value, "interpretCost");
            return (Criteria) this;
        }

        public Criteria andInterpretCostIn(List<BigDecimal> values) {
            addCriterion("interpret_cost in", values, "interpretCost");
            return (Criteria) this;
        }

        public Criteria andInterpretCostNotIn(List<BigDecimal> values) {
            addCriterion("interpret_cost not in", values, "interpretCost");
            return (Criteria) this;
        }

        public Criteria andInterpretCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("interpret_cost between", value1, value2, "interpretCost");
            return (Criteria) this;
        }

        public Criteria andInterpretCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("interpret_cost not between", value1, value2, "interpretCost");
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

        public Criteria andParticipantDescribeIsNull() {
            addCriterion("participant_describe is null");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeIsNotNull() {
            addCriterion("participant_describe is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeEqualTo(String value) {
            addCriterion("participant_describe =", value, "participantDescribe");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeNotEqualTo(String value) {
            addCriterion("participant_describe <>", value, "participantDescribe");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeGreaterThan(String value) {
            addCriterion("participant_describe >", value, "participantDescribe");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("participant_describe >=", value, "participantDescribe");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeLessThan(String value) {
            addCriterion("participant_describe <", value, "participantDescribe");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeLessThanOrEqualTo(String value) {
            addCriterion("participant_describe <=", value, "participantDescribe");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeLike(String value) {
            addCriterion("participant_describe like", value, "participantDescribe");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeNotLike(String value) {
            addCriterion("participant_describe not like", value, "participantDescribe");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeIn(List<String> values) {
            addCriterion("participant_describe in", values, "participantDescribe");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeNotIn(List<String> values) {
            addCriterion("participant_describe not in", values, "participantDescribe");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeBetween(String value1, String value2) {
            addCriterion("participant_describe between", value1, value2, "participantDescribe");
            return (Criteria) this;
        }

        public Criteria andParticipantDescribeNotBetween(String value1, String value2) {
            addCriterion("participant_describe not between", value1, value2, "participantDescribe");
            return (Criteria) this;
        }

        public Criteria andParticipantImgIsNull() {
            addCriterion("participant_img is null");
            return (Criteria) this;
        }

        public Criteria andParticipantImgIsNotNull() {
            addCriterion("participant_img is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantImgEqualTo(String value) {
            addCriterion("participant_img =", value, "participantImg");
            return (Criteria) this;
        }

        public Criteria andParticipantImgNotEqualTo(String value) {
            addCriterion("participant_img <>", value, "participantImg");
            return (Criteria) this;
        }

        public Criteria andParticipantImgGreaterThan(String value) {
            addCriterion("participant_img >", value, "participantImg");
            return (Criteria) this;
        }

        public Criteria andParticipantImgGreaterThanOrEqualTo(String value) {
            addCriterion("participant_img >=", value, "participantImg");
            return (Criteria) this;
        }

        public Criteria andParticipantImgLessThan(String value) {
            addCriterion("participant_img <", value, "participantImg");
            return (Criteria) this;
        }

        public Criteria andParticipantImgLessThanOrEqualTo(String value) {
            addCriterion("participant_img <=", value, "participantImg");
            return (Criteria) this;
        }

        public Criteria andParticipantImgLike(String value) {
            addCriterion("participant_img like", value, "participantImg");
            return (Criteria) this;
        }

        public Criteria andParticipantImgNotLike(String value) {
            addCriterion("participant_img not like", value, "participantImg");
            return (Criteria) this;
        }

        public Criteria andParticipantImgIn(List<String> values) {
            addCriterion("participant_img in", values, "participantImg");
            return (Criteria) this;
        }

        public Criteria andParticipantImgNotIn(List<String> values) {
            addCriterion("participant_img not in", values, "participantImg");
            return (Criteria) this;
        }

        public Criteria andParticipantImgBetween(String value1, String value2) {
            addCriterion("participant_img between", value1, value2, "participantImg");
            return (Criteria) this;
        }

        public Criteria andParticipantImgNotBetween(String value1, String value2) {
            addCriterion("participant_img not between", value1, value2, "participantImg");
            return (Criteria) this;
        }

        public Criteria andInterpretStatusIsNull() {
            addCriterion("interpret_status is null");
            return (Criteria) this;
        }

        public Criteria andInterpretStatusIsNotNull() {
            addCriterion("interpret_status is not null");
            return (Criteria) this;
        }

        public Criteria andInterpretStatusEqualTo(Integer value) {
            addCriterion("interpret_status =", value, "interpretStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretStatusNotEqualTo(Integer value) {
            addCriterion("interpret_status <>", value, "interpretStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretStatusGreaterThan(Integer value) {
            addCriterion("interpret_status >", value, "interpretStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("interpret_status >=", value, "interpretStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretStatusLessThan(Integer value) {
            addCriterion("interpret_status <", value, "interpretStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretStatusLessThanOrEqualTo(Integer value) {
            addCriterion("interpret_status <=", value, "interpretStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretStatusIn(List<Integer> values) {
            addCriterion("interpret_status in", values, "interpretStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretStatusNotIn(List<Integer> values) {
            addCriterion("interpret_status not in", values, "interpretStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretStatusBetween(Integer value1, Integer value2) {
            addCriterion("interpret_status between", value1, value2, "interpretStatus");
            return (Criteria) this;
        }

        public Criteria andInterpretStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("interpret_status not between", value1, value2, "interpretStatus");
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