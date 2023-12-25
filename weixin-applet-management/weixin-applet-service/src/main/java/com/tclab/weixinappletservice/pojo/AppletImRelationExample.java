package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletImRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletImRelationExample() {
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

        public Criteria andParticipantCommentIsNull() {
            addCriterion("participant_comment is null");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentIsNotNull() {
            addCriterion("participant_comment is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentEqualTo(String value) {
            addCriterion("participant_comment =", value, "participantComment");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentNotEqualTo(String value) {
            addCriterion("participant_comment <>", value, "participantComment");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentGreaterThan(String value) {
            addCriterion("participant_comment >", value, "participantComment");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentGreaterThanOrEqualTo(String value) {
            addCriterion("participant_comment >=", value, "participantComment");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentLessThan(String value) {
            addCriterion("participant_comment <", value, "participantComment");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentLessThanOrEqualTo(String value) {
            addCriterion("participant_comment <=", value, "participantComment");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentLike(String value) {
            addCriterion("participant_comment like", value, "participantComment");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentNotLike(String value) {
            addCriterion("participant_comment not like", value, "participantComment");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentIn(List<String> values) {
            addCriterion("participant_comment in", values, "participantComment");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentNotIn(List<String> values) {
            addCriterion("participant_comment not in", values, "participantComment");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentBetween(String value1, String value2) {
            addCriterion("participant_comment between", value1, value2, "participantComment");
            return (Criteria) this;
        }

        public Criteria andParticipantCommentNotBetween(String value1, String value2) {
            addCriterion("participant_comment not between", value1, value2, "participantComment");
            return (Criteria) this;
        }

        public Criteria andParticipantScoreIsNull() {
            addCriterion("participant_score is null");
            return (Criteria) this;
        }

        public Criteria andParticipantScoreIsNotNull() {
            addCriterion("participant_score is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantScoreEqualTo(Double value) {
            addCriterion("participant_score =", value, "participantScore");
            return (Criteria) this;
        }

        public Criteria andParticipantScoreNotEqualTo(Double value) {
            addCriterion("participant_score <>", value, "participantScore");
            return (Criteria) this;
        }

        public Criteria andParticipantScoreGreaterThan(Double value) {
            addCriterion("participant_score >", value, "participantScore");
            return (Criteria) this;
        }

        public Criteria andParticipantScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("participant_score >=", value, "participantScore");
            return (Criteria) this;
        }

        public Criteria andParticipantScoreLessThan(Double value) {
            addCriterion("participant_score <", value, "participantScore");
            return (Criteria) this;
        }

        public Criteria andParticipantScoreLessThanOrEqualTo(Double value) {
            addCriterion("participant_score <=", value, "participantScore");
            return (Criteria) this;
        }

        public Criteria andParticipantScoreIn(List<Double> values) {
            addCriterion("participant_score in", values, "participantScore");
            return (Criteria) this;
        }

        public Criteria andParticipantScoreNotIn(List<Double> values) {
            addCriterion("participant_score not in", values, "participantScore");
            return (Criteria) this;
        }

        public Criteria andParticipantScoreBetween(Double value1, Double value2) {
            addCriterion("participant_score between", value1, value2, "participantScore");
            return (Criteria) this;
        }

        public Criteria andParticipantScoreNotBetween(Double value1, Double value2) {
            addCriterion("participant_score not between", value1, value2, "participantScore");
            return (Criteria) this;
        }

        public Criteria andParticipantAttentionFlagIsNull() {
            addCriterion("participant_attention_flag is null");
            return (Criteria) this;
        }

        public Criteria andParticipantAttentionFlagIsNotNull() {
            addCriterion("participant_attention_flag is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantAttentionFlagEqualTo(Integer value) {
            addCriterion("participant_attention_flag =", value, "participantAttentionFlag");
            return (Criteria) this;
        }

        public Criteria andParticipantAttentionFlagNotEqualTo(Integer value) {
            addCriterion("participant_attention_flag <>", value, "participantAttentionFlag");
            return (Criteria) this;
        }

        public Criteria andParticipantAttentionFlagGreaterThan(Integer value) {
            addCriterion("participant_attention_flag >", value, "participantAttentionFlag");
            return (Criteria) this;
        }

        public Criteria andParticipantAttentionFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("participant_attention_flag >=", value, "participantAttentionFlag");
            return (Criteria) this;
        }

        public Criteria andParticipantAttentionFlagLessThan(Integer value) {
            addCriterion("participant_attention_flag <", value, "participantAttentionFlag");
            return (Criteria) this;
        }

        public Criteria andParticipantAttentionFlagLessThanOrEqualTo(Integer value) {
            addCriterion("participant_attention_flag <=", value, "participantAttentionFlag");
            return (Criteria) this;
        }

        public Criteria andParticipantAttentionFlagIn(List<Integer> values) {
            addCriterion("participant_attention_flag in", values, "participantAttentionFlag");
            return (Criteria) this;
        }

        public Criteria andParticipantAttentionFlagNotIn(List<Integer> values) {
            addCriterion("participant_attention_flag not in", values, "participantAttentionFlag");
            return (Criteria) this;
        }

        public Criteria andParticipantAttentionFlagBetween(Integer value1, Integer value2) {
            addCriterion("participant_attention_flag between", value1, value2, "participantAttentionFlag");
            return (Criteria) this;
        }

        public Criteria andParticipantAttentionFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("participant_attention_flag not between", value1, value2, "participantAttentionFlag");
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

        public Criteria andUserConversationidIsNull() {
            addCriterion("user_conversationID is null");
            return (Criteria) this;
        }

        public Criteria andUserConversationidIsNotNull() {
            addCriterion("user_conversationID is not null");
            return (Criteria) this;
        }

        public Criteria andUserConversationidEqualTo(String value) {
            addCriterion("user_conversationID =", value, "userConversationid");
            return (Criteria) this;
        }

        public Criteria andUserConversationidNotEqualTo(String value) {
            addCriterion("user_conversationID <>", value, "userConversationid");
            return (Criteria) this;
        }

        public Criteria andUserConversationidGreaterThan(String value) {
            addCriterion("user_conversationID >", value, "userConversationid");
            return (Criteria) this;
        }

        public Criteria andUserConversationidGreaterThanOrEqualTo(String value) {
            addCriterion("user_conversationID >=", value, "userConversationid");
            return (Criteria) this;
        }

        public Criteria andUserConversationidLessThan(String value) {
            addCriterion("user_conversationID <", value, "userConversationid");
            return (Criteria) this;
        }

        public Criteria andUserConversationidLessThanOrEqualTo(String value) {
            addCriterion("user_conversationID <=", value, "userConversationid");
            return (Criteria) this;
        }

        public Criteria andUserConversationidLike(String value) {
            addCriterion("user_conversationID like", value, "userConversationid");
            return (Criteria) this;
        }

        public Criteria andUserConversationidNotLike(String value) {
            addCriterion("user_conversationID not like", value, "userConversationid");
            return (Criteria) this;
        }

        public Criteria andUserConversationidIn(List<String> values) {
            addCriterion("user_conversationID in", values, "userConversationid");
            return (Criteria) this;
        }

        public Criteria andUserConversationidNotIn(List<String> values) {
            addCriterion("user_conversationID not in", values, "userConversationid");
            return (Criteria) this;
        }

        public Criteria andUserConversationidBetween(String value1, String value2) {
            addCriterion("user_conversationID between", value1, value2, "userConversationid");
            return (Criteria) this;
        }

        public Criteria andUserConversationidNotBetween(String value1, String value2) {
            addCriterion("user_conversationID not between", value1, value2, "userConversationid");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidIsNull() {
            addCriterion("doctor_conversationID is null");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidIsNotNull() {
            addCriterion("doctor_conversationID is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidEqualTo(String value) {
            addCriterion("doctor_conversationID =", value, "doctorConversationid");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidNotEqualTo(String value) {
            addCriterion("doctor_conversationID <>", value, "doctorConversationid");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidGreaterThan(String value) {
            addCriterion("doctor_conversationID >", value, "doctorConversationid");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_conversationID >=", value, "doctorConversationid");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidLessThan(String value) {
            addCriterion("doctor_conversationID <", value, "doctorConversationid");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidLessThanOrEqualTo(String value) {
            addCriterion("doctor_conversationID <=", value, "doctorConversationid");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidLike(String value) {
            addCriterion("doctor_conversationID like", value, "doctorConversationid");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidNotLike(String value) {
            addCriterion("doctor_conversationID not like", value, "doctorConversationid");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidIn(List<String> values) {
            addCriterion("doctor_conversationID in", values, "doctorConversationid");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidNotIn(List<String> values) {
            addCriterion("doctor_conversationID not in", values, "doctorConversationid");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidBetween(String value1, String value2) {
            addCriterion("doctor_conversationID between", value1, value2, "doctorConversationid");
            return (Criteria) this;
        }

        public Criteria andDoctorConversationidNotBetween(String value1, String value2) {
            addCriterion("doctor_conversationID not between", value1, value2, "doctorConversationid");
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