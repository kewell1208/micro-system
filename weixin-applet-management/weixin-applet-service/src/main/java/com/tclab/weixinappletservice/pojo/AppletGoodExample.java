package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletGoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletGoodExample() {
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

        public Criteria andPackageIdIsNull() {
            addCriterion("package_id is null");
            return (Criteria) this;
        }

        public Criteria andPackageIdIsNotNull() {
            addCriterion("package_id is not null");
            return (Criteria) this;
        }

        public Criteria andPackageIdEqualTo(String value) {
            addCriterion("package_id =", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotEqualTo(String value) {
            addCriterion("package_id <>", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThan(String value) {
            addCriterion("package_id >", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThanOrEqualTo(String value) {
            addCriterion("package_id >=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThan(String value) {
            addCriterion("package_id <", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThanOrEqualTo(String value) {
            addCriterion("package_id <=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLike(String value) {
            addCriterion("package_id like", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotLike(String value) {
            addCriterion("package_id not like", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdIn(List<String> values) {
            addCriterion("package_id in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotIn(List<String> values) {
            addCriterion("package_id not in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdBetween(String value1, String value2) {
            addCriterion("package_id between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotBetween(String value1, String value2) {
            addCriterion("package_id not between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNull() {
            addCriterion("package_name is null");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNotNull() {
            addCriterion("package_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNameEqualTo(String value) {
            addCriterion("package_name =", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotEqualTo(String value) {
            addCriterion("package_name <>", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThan(String value) {
            addCriterion("package_name >", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            addCriterion("package_name >=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThan(String value) {
            addCriterion("package_name <", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThanOrEqualTo(String value) {
            addCriterion("package_name <=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLike(String value) {
            addCriterion("package_name like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotLike(String value) {
            addCriterion("package_name not like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameIn(List<String> values) {
            addCriterion("package_name in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotIn(List<String> values) {
            addCriterion("package_name not in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameBetween(String value1, String value2) {
            addCriterion("package_name between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotBetween(String value1, String value2) {
            addCriterion("package_name not between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNumIsNull() {
            addCriterion("package_num is null");
            return (Criteria) this;
        }

        public Criteria andPackageNumIsNotNull() {
            addCriterion("package_num is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNumEqualTo(Integer value) {
            addCriterion("package_num =", value, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumNotEqualTo(Integer value) {
            addCriterion("package_num <>", value, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumGreaterThan(Integer value) {
            addCriterion("package_num >", value, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_num >=", value, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumLessThan(Integer value) {
            addCriterion("package_num <", value, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumLessThanOrEqualTo(Integer value) {
            addCriterion("package_num <=", value, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumIn(List<Integer> values) {
            addCriterion("package_num in", values, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumNotIn(List<Integer> values) {
            addCriterion("package_num not in", values, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumBetween(Integer value1, Integer value2) {
            addCriterion("package_num between", value1, value2, "packageNum");
            return (Criteria) this;
        }

        public Criteria andPackageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("package_num not between", value1, value2, "packageNum");
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

        public Criteria andAcquisitionNameIsNull() {
            addCriterion("acquisition_name is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameIsNotNull() {
            addCriterion("acquisition_name is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameEqualTo(String value) {
            addCriterion("acquisition_name =", value, "acquisitionName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameNotEqualTo(String value) {
            addCriterion("acquisition_name <>", value, "acquisitionName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameGreaterThan(String value) {
            addCriterion("acquisition_name >", value, "acquisitionName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_name >=", value, "acquisitionName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameLessThan(String value) {
            addCriterion("acquisition_name <", value, "acquisitionName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameLessThanOrEqualTo(String value) {
            addCriterion("acquisition_name <=", value, "acquisitionName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameLike(String value) {
            addCriterion("acquisition_name like", value, "acquisitionName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameNotLike(String value) {
            addCriterion("acquisition_name not like", value, "acquisitionName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameIn(List<String> values) {
            addCriterion("acquisition_name in", values, "acquisitionName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameNotIn(List<String> values) {
            addCriterion("acquisition_name not in", values, "acquisitionName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameBetween(String value1, String value2) {
            addCriterion("acquisition_name between", value1, value2, "acquisitionName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionNameNotBetween(String value1, String value2) {
            addCriterion("acquisition_name not between", value1, value2, "acquisitionName");
            return (Criteria) this;
        }

        public Criteria andGoodApplyDateIsNull() {
            addCriterion("good_apply_date is null");
            return (Criteria) this;
        }

        public Criteria andGoodApplyDateIsNotNull() {
            addCriterion("good_apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andGoodApplyDateEqualTo(Date value) {
            addCriterion("good_apply_date =", value, "goodApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodApplyDateNotEqualTo(Date value) {
            addCriterion("good_apply_date <>", value, "goodApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodApplyDateGreaterThan(Date value) {
            addCriterion("good_apply_date >", value, "goodApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("good_apply_date >=", value, "goodApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodApplyDateLessThan(Date value) {
            addCriterion("good_apply_date <", value, "goodApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("good_apply_date <=", value, "goodApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodApplyDateIn(List<Date> values) {
            addCriterion("good_apply_date in", values, "goodApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodApplyDateNotIn(List<Date> values) {
            addCriterion("good_apply_date not in", values, "goodApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodApplyDateBetween(Date value1, Date value2) {
            addCriterion("good_apply_date between", value1, value2, "goodApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("good_apply_date not between", value1, value2, "goodApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCurrentApplyDateIsNull() {
            addCriterion("good_current_apply_date is null");
            return (Criteria) this;
        }

        public Criteria andGoodCurrentApplyDateIsNotNull() {
            addCriterion("good_current_apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andGoodCurrentApplyDateEqualTo(Date value) {
            addCriterion("good_current_apply_date =", value, "goodCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCurrentApplyDateNotEqualTo(Date value) {
            addCriterion("good_current_apply_date <>", value, "goodCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCurrentApplyDateGreaterThan(Date value) {
            addCriterion("good_current_apply_date >", value, "goodCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCurrentApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("good_current_apply_date >=", value, "goodCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCurrentApplyDateLessThan(Date value) {
            addCriterion("good_current_apply_date <", value, "goodCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCurrentApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("good_current_apply_date <=", value, "goodCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCurrentApplyDateIn(List<Date> values) {
            addCriterion("good_current_apply_date in", values, "goodCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCurrentApplyDateNotIn(List<Date> values) {
            addCriterion("good_current_apply_date not in", values, "goodCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCurrentApplyDateBetween(Date value1, Date value2) {
            addCriterion("good_current_apply_date between", value1, value2, "goodCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCurrentApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("good_current_apply_date not between", value1, value2, "goodCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCompleteApplyDateIsNull() {
            addCriterion("good_complete_apply_date is null");
            return (Criteria) this;
        }

        public Criteria andGoodCompleteApplyDateIsNotNull() {
            addCriterion("good_complete_apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andGoodCompleteApplyDateEqualTo(Date value) {
            addCriterion("good_complete_apply_date =", value, "goodCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCompleteApplyDateNotEqualTo(Date value) {
            addCriterion("good_complete_apply_date <>", value, "goodCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCompleteApplyDateGreaterThan(Date value) {
            addCriterion("good_complete_apply_date >", value, "goodCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCompleteApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("good_complete_apply_date >=", value, "goodCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCompleteApplyDateLessThan(Date value) {
            addCriterion("good_complete_apply_date <", value, "goodCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCompleteApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("good_complete_apply_date <=", value, "goodCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCompleteApplyDateIn(List<Date> values) {
            addCriterion("good_complete_apply_date in", values, "goodCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCompleteApplyDateNotIn(List<Date> values) {
            addCriterion("good_complete_apply_date not in", values, "goodCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCompleteApplyDateBetween(Date value1, Date value2) {
            addCriterion("good_complete_apply_date between", value1, value2, "goodCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodCompleteApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("good_complete_apply_date not between", value1, value2, "goodCompleteApplyDate");
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

        public Criteria andCostStaffCommissionIsNull() {
            addCriterion("cost_staff_commission is null");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionIsNotNull() {
            addCriterion("cost_staff_commission is not null");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionEqualTo(BigDecimal value) {
            addCriterion("cost_staff_commission =", value, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionNotEqualTo(BigDecimal value) {
            addCriterion("cost_staff_commission <>", value, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionGreaterThan(BigDecimal value) {
            addCriterion("cost_staff_commission >", value, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_staff_commission >=", value, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionLessThan(BigDecimal value) {
            addCriterion("cost_staff_commission <", value, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_staff_commission <=", value, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionIn(List<BigDecimal> values) {
            addCriterion("cost_staff_commission in", values, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionNotIn(List<BigDecimal> values) {
            addCriterion("cost_staff_commission not in", values, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_staff_commission between", value1, value2, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_staff_commission not between", value1, value2, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdIsNull() {
            addCriterion("acquisition_department_id is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdIsNotNull() {
            addCriterion("acquisition_department_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdEqualTo(String value) {
            addCriterion("acquisition_department_id =", value, "acquisitionDepartmentId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdNotEqualTo(String value) {
            addCriterion("acquisition_department_id <>", value, "acquisitionDepartmentId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdGreaterThan(String value) {
            addCriterion("acquisition_department_id >", value, "acquisitionDepartmentId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_department_id >=", value, "acquisitionDepartmentId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdLessThan(String value) {
            addCriterion("acquisition_department_id <", value, "acquisitionDepartmentId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("acquisition_department_id <=", value, "acquisitionDepartmentId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdLike(String value) {
            addCriterion("acquisition_department_id like", value, "acquisitionDepartmentId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdNotLike(String value) {
            addCriterion("acquisition_department_id not like", value, "acquisitionDepartmentId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdIn(List<String> values) {
            addCriterion("acquisition_department_id in", values, "acquisitionDepartmentId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdNotIn(List<String> values) {
            addCriterion("acquisition_department_id not in", values, "acquisitionDepartmentId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdBetween(String value1, String value2) {
            addCriterion("acquisition_department_id between", value1, value2, "acquisitionDepartmentId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("acquisition_department_id not between", value1, value2, "acquisitionDepartmentId");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameIsNull() {
            addCriterion("acquisition_department_name is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameIsNotNull() {
            addCriterion("acquisition_department_name is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameEqualTo(String value) {
            addCriterion("acquisition_department_name =", value, "acquisitionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameNotEqualTo(String value) {
            addCriterion("acquisition_department_name <>", value, "acquisitionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameGreaterThan(String value) {
            addCriterion("acquisition_department_name >", value, "acquisitionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_department_name >=", value, "acquisitionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameLessThan(String value) {
            addCriterion("acquisition_department_name <", value, "acquisitionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("acquisition_department_name <=", value, "acquisitionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameLike(String value) {
            addCriterion("acquisition_department_name like", value, "acquisitionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameNotLike(String value) {
            addCriterion("acquisition_department_name not like", value, "acquisitionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameIn(List<String> values) {
            addCriterion("acquisition_department_name in", values, "acquisitionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameNotIn(List<String> values) {
            addCriterion("acquisition_department_name not in", values, "acquisitionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameBetween(String value1, String value2) {
            addCriterion("acquisition_department_name between", value1, value2, "acquisitionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("acquisition_department_name not between", value1, value2, "acquisitionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionIsNull() {
            addCriterion("cost_department_commission is null");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionIsNotNull() {
            addCriterion("cost_department_commission is not null");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionEqualTo(String value) {
            addCriterion("cost_department_commission =", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionNotEqualTo(String value) {
            addCriterion("cost_department_commission <>", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionGreaterThan(String value) {
            addCriterion("cost_department_commission >", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionGreaterThanOrEqualTo(String value) {
            addCriterion("cost_department_commission >=", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionLessThan(String value) {
            addCriterion("cost_department_commission <", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionLessThanOrEqualTo(String value) {
            addCriterion("cost_department_commission <=", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionLike(String value) {
            addCriterion("cost_department_commission like", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionNotLike(String value) {
            addCriterion("cost_department_commission not like", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionIn(List<String> values) {
            addCriterion("cost_department_commission in", values, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionNotIn(List<String> values) {
            addCriterion("cost_department_commission not in", values, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionBetween(String value1, String value2) {
            addCriterion("cost_department_commission between", value1, value2, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionNotBetween(String value1, String value2) {
            addCriterion("cost_department_commission not between", value1, value2, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdIsNull() {
            addCriterion("recommedd_organization_id is null");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdIsNotNull() {
            addCriterion("recommedd_organization_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdEqualTo(String value) {
            addCriterion("recommedd_organization_id =", value, "recommeddOrganizationId");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdNotEqualTo(String value) {
            addCriterion("recommedd_organization_id <>", value, "recommeddOrganizationId");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdGreaterThan(String value) {
            addCriterion("recommedd_organization_id >", value, "recommeddOrganizationId");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdGreaterThanOrEqualTo(String value) {
            addCriterion("recommedd_organization_id >=", value, "recommeddOrganizationId");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdLessThan(String value) {
            addCriterion("recommedd_organization_id <", value, "recommeddOrganizationId");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdLessThanOrEqualTo(String value) {
            addCriterion("recommedd_organization_id <=", value, "recommeddOrganizationId");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdLike(String value) {
            addCriterion("recommedd_organization_id like", value, "recommeddOrganizationId");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdNotLike(String value) {
            addCriterion("recommedd_organization_id not like", value, "recommeddOrganizationId");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdIn(List<String> values) {
            addCriterion("recommedd_organization_id in", values, "recommeddOrganizationId");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdNotIn(List<String> values) {
            addCriterion("recommedd_organization_id not in", values, "recommeddOrganizationId");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdBetween(String value1, String value2) {
            addCriterion("recommedd_organization_id between", value1, value2, "recommeddOrganizationId");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationIdNotBetween(String value1, String value2) {
            addCriterion("recommedd_organization_id not between", value1, value2, "recommeddOrganizationId");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameIsNull() {
            addCriterion("recommedd_organization_name is null");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameIsNotNull() {
            addCriterion("recommedd_organization_name is not null");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameEqualTo(String value) {
            addCriterion("recommedd_organization_name =", value, "recommeddOrganizationName");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameNotEqualTo(String value) {
            addCriterion("recommedd_organization_name <>", value, "recommeddOrganizationName");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameGreaterThan(String value) {
            addCriterion("recommedd_organization_name >", value, "recommeddOrganizationName");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameGreaterThanOrEqualTo(String value) {
            addCriterion("recommedd_organization_name >=", value, "recommeddOrganizationName");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameLessThan(String value) {
            addCriterion("recommedd_organization_name <", value, "recommeddOrganizationName");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameLessThanOrEqualTo(String value) {
            addCriterion("recommedd_organization_name <=", value, "recommeddOrganizationName");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameLike(String value) {
            addCriterion("recommedd_organization_name like", value, "recommeddOrganizationName");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameNotLike(String value) {
            addCriterion("recommedd_organization_name not like", value, "recommeddOrganizationName");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameIn(List<String> values) {
            addCriterion("recommedd_organization_name in", values, "recommeddOrganizationName");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameNotIn(List<String> values) {
            addCriterion("recommedd_organization_name not in", values, "recommeddOrganizationName");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameBetween(String value1, String value2) {
            addCriterion("recommedd_organization_name between", value1, value2, "recommeddOrganizationName");
            return (Criteria) this;
        }

        public Criteria andRecommeddOrganizationNameNotBetween(String value1, String value2) {
            addCriterion("recommedd_organization_name not between", value1, value2, "recommeddOrganizationName");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionIsNull() {
            addCriterion("cost_organization_commission is null");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionIsNotNull() {
            addCriterion("cost_organization_commission is not null");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionEqualTo(BigDecimal value) {
            addCriterion("cost_organization_commission =", value, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionNotEqualTo(BigDecimal value) {
            addCriterion("cost_organization_commission <>", value, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionGreaterThan(BigDecimal value) {
            addCriterion("cost_organization_commission >", value, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_organization_commission >=", value, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionLessThan(BigDecimal value) {
            addCriterion("cost_organization_commission <", value, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_organization_commission <=", value, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionIn(List<BigDecimal> values) {
            addCriterion("cost_organization_commission in", values, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionNotIn(List<BigDecimal> values) {
            addCriterion("cost_organization_commission not in", values, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_organization_commission between", value1, value2, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_organization_commission not between", value1, value2, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeIsNull() {
            addCriterion("cost_acquisition_charge is null");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeIsNotNull() {
            addCriterion("cost_acquisition_charge is not null");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeEqualTo(BigDecimal value) {
            addCriterion("cost_acquisition_charge =", value, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeNotEqualTo(BigDecimal value) {
            addCriterion("cost_acquisition_charge <>", value, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeGreaterThan(BigDecimal value) {
            addCriterion("cost_acquisition_charge >", value, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_acquisition_charge >=", value, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeLessThan(BigDecimal value) {
            addCriterion("cost_acquisition_charge <", value, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_acquisition_charge <=", value, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeIn(List<BigDecimal> values) {
            addCriterion("cost_acquisition_charge in", values, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeNotIn(List<BigDecimal> values) {
            addCriterion("cost_acquisition_charge not in", values, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_acquisition_charge between", value1, value2, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_acquisition_charge not between", value1, value2, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(BigDecimal value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(BigDecimal value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(BigDecimal value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(BigDecimal value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<BigDecimal> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<BigDecimal> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNull() {
            addCriterion("discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNotNull() {
            addCriterion("discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountEqualTo(BigDecimal value) {
            addCriterion("discount_amount =", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotEqualTo(BigDecimal value) {
            addCriterion("discount_amount <>", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThan(BigDecimal value) {
            addCriterion("discount_amount >", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_amount >=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThan(BigDecimal value) {
            addCriterion("discount_amount <", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_amount <=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIn(List<BigDecimal> values) {
            addCriterion("discount_amount in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotIn(List<BigDecimal> values) {
            addCriterion("discount_amount not in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_amount between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_amount not between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(Integer value) {
            addCriterion("service_type =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(Integer value) {
            addCriterion("service_type <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(Integer value) {
            addCriterion("service_type >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_type >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(Integer value) {
            addCriterion("service_type <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("service_type <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<Integer> values) {
            addCriterion("service_type in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<Integer> values) {
            addCriterion("service_type not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(Integer value1, Integer value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andSampleNoIsNull() {
            addCriterion("sample_no is null");
            return (Criteria) this;
        }

        public Criteria andSampleNoIsNotNull() {
            addCriterion("sample_no is not null");
            return (Criteria) this;
        }

        public Criteria andSampleNoEqualTo(String value) {
            addCriterion("sample_no =", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoNotEqualTo(String value) {
            addCriterion("sample_no <>", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoGreaterThan(String value) {
            addCriterion("sample_no >", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoGreaterThanOrEqualTo(String value) {
            addCriterion("sample_no >=", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoLessThan(String value) {
            addCriterion("sample_no <", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoLessThanOrEqualTo(String value) {
            addCriterion("sample_no <=", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoLike(String value) {
            addCriterion("sample_no like", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoNotLike(String value) {
            addCriterion("sample_no not like", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoIn(List<String> values) {
            addCriterion("sample_no in", values, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoNotIn(List<String> values) {
            addCriterion("sample_no not in", values, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoBetween(String value1, String value2) {
            addCriterion("sample_no between", value1, value2, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoNotBetween(String value1, String value2) {
            addCriterion("sample_no not between", value1, value2, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleCollectDateIsNull() {
            addCriterion("sample_collect_date is null");
            return (Criteria) this;
        }

        public Criteria andSampleCollectDateIsNotNull() {
            addCriterion("sample_collect_date is not null");
            return (Criteria) this;
        }

        public Criteria andSampleCollectDateEqualTo(Date value) {
            addCriterion("sample_collect_date =", value, "sampleCollectDate");
            return (Criteria) this;
        }

        public Criteria andSampleCollectDateNotEqualTo(Date value) {
            addCriterion("sample_collect_date <>", value, "sampleCollectDate");
            return (Criteria) this;
        }

        public Criteria andSampleCollectDateGreaterThan(Date value) {
            addCriterion("sample_collect_date >", value, "sampleCollectDate");
            return (Criteria) this;
        }

        public Criteria andSampleCollectDateGreaterThanOrEqualTo(Date value) {
            addCriterion("sample_collect_date >=", value, "sampleCollectDate");
            return (Criteria) this;
        }

        public Criteria andSampleCollectDateLessThan(Date value) {
            addCriterion("sample_collect_date <", value, "sampleCollectDate");
            return (Criteria) this;
        }

        public Criteria andSampleCollectDateLessThanOrEqualTo(Date value) {
            addCriterion("sample_collect_date <=", value, "sampleCollectDate");
            return (Criteria) this;
        }

        public Criteria andSampleCollectDateIn(List<Date> values) {
            addCriterion("sample_collect_date in", values, "sampleCollectDate");
            return (Criteria) this;
        }

        public Criteria andSampleCollectDateNotIn(List<Date> values) {
            addCriterion("sample_collect_date not in", values, "sampleCollectDate");
            return (Criteria) this;
        }

        public Criteria andSampleCollectDateBetween(Date value1, Date value2) {
            addCriterion("sample_collect_date between", value1, value2, "sampleCollectDate");
            return (Criteria) this;
        }

        public Criteria andSampleCollectDateNotBetween(Date value1, Date value2) {
            addCriterion("sample_collect_date not between", value1, value2, "sampleCollectDate");
            return (Criteria) this;
        }

        public Criteria andReportTypeIsNull() {
            addCriterion("report_type is null");
            return (Criteria) this;
        }

        public Criteria andReportTypeIsNotNull() {
            addCriterion("report_type is not null");
            return (Criteria) this;
        }

        public Criteria andReportTypeEqualTo(Integer value) {
            addCriterion("report_type =", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeNotEqualTo(Integer value) {
            addCriterion("report_type <>", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeGreaterThan(Integer value) {
            addCriterion("report_type >", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_type >=", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeLessThan(Integer value) {
            addCriterion("report_type <", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeLessThanOrEqualTo(Integer value) {
            addCriterion("report_type <=", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeIn(List<Integer> values) {
            addCriterion("report_type in", values, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeNotIn(List<Integer> values) {
            addCriterion("report_type not in", values, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeBetween(Integer value1, Integer value2) {
            addCriterion("report_type between", value1, value2, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("report_type not between", value1, value2, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportCostIsNull() {
            addCriterion("report_cost is null");
            return (Criteria) this;
        }

        public Criteria andReportCostIsNotNull() {
            addCriterion("report_cost is not null");
            return (Criteria) this;
        }

        public Criteria andReportCostEqualTo(BigDecimal value) {
            addCriterion("report_cost =", value, "reportCost");
            return (Criteria) this;
        }

        public Criteria andReportCostNotEqualTo(BigDecimal value) {
            addCriterion("report_cost <>", value, "reportCost");
            return (Criteria) this;
        }

        public Criteria andReportCostGreaterThan(BigDecimal value) {
            addCriterion("report_cost >", value, "reportCost");
            return (Criteria) this;
        }

        public Criteria andReportCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("report_cost >=", value, "reportCost");
            return (Criteria) this;
        }

        public Criteria andReportCostLessThan(BigDecimal value) {
            addCriterion("report_cost <", value, "reportCost");
            return (Criteria) this;
        }

        public Criteria andReportCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("report_cost <=", value, "reportCost");
            return (Criteria) this;
        }

        public Criteria andReportCostIn(List<BigDecimal> values) {
            addCriterion("report_cost in", values, "reportCost");
            return (Criteria) this;
        }

        public Criteria andReportCostNotIn(List<BigDecimal> values) {
            addCriterion("report_cost not in", values, "reportCost");
            return (Criteria) this;
        }

        public Criteria andReportCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("report_cost between", value1, value2, "reportCost");
            return (Criteria) this;
        }

        public Criteria andReportCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("report_cost not between", value1, value2, "reportCost");
            return (Criteria) this;
        }

        public Criteria andReportImgIsNull() {
            addCriterion("report_img is null");
            return (Criteria) this;
        }

        public Criteria andReportImgIsNotNull() {
            addCriterion("report_img is not null");
            return (Criteria) this;
        }

        public Criteria andReportImgEqualTo(String value) {
            addCriterion("report_img =", value, "reportImg");
            return (Criteria) this;
        }

        public Criteria andReportImgNotEqualTo(String value) {
            addCriterion("report_img <>", value, "reportImg");
            return (Criteria) this;
        }

        public Criteria andReportImgGreaterThan(String value) {
            addCriterion("report_img >", value, "reportImg");
            return (Criteria) this;
        }

        public Criteria andReportImgGreaterThanOrEqualTo(String value) {
            addCriterion("report_img >=", value, "reportImg");
            return (Criteria) this;
        }

        public Criteria andReportImgLessThan(String value) {
            addCriterion("report_img <", value, "reportImg");
            return (Criteria) this;
        }

        public Criteria andReportImgLessThanOrEqualTo(String value) {
            addCriterion("report_img <=", value, "reportImg");
            return (Criteria) this;
        }

        public Criteria andReportImgLike(String value) {
            addCriterion("report_img like", value, "reportImg");
            return (Criteria) this;
        }

        public Criteria andReportImgNotLike(String value) {
            addCriterion("report_img not like", value, "reportImg");
            return (Criteria) this;
        }

        public Criteria andReportImgIn(List<String> values) {
            addCriterion("report_img in", values, "reportImg");
            return (Criteria) this;
        }

        public Criteria andReportImgNotIn(List<String> values) {
            addCriterion("report_img not in", values, "reportImg");
            return (Criteria) this;
        }

        public Criteria andReportImgBetween(String value1, String value2) {
            addCriterion("report_img between", value1, value2, "reportImg");
            return (Criteria) this;
        }

        public Criteria andReportImgNotBetween(String value1, String value2) {
            addCriterion("report_img not between", value1, value2, "reportImg");
            return (Criteria) this;
        }

        public Criteria andReportDateIsNull() {
            addCriterion("report_date is null");
            return (Criteria) this;
        }

        public Criteria andReportDateIsNotNull() {
            addCriterion("report_date is not null");
            return (Criteria) this;
        }

        public Criteria andReportDateEqualTo(Date value) {
            addCriterion("report_date =", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotEqualTo(Date value) {
            addCriterion("report_date <>", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateGreaterThan(Date value) {
            addCriterion("report_date >", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateGreaterThanOrEqualTo(Date value) {
            addCriterion("report_date >=", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLessThan(Date value) {
            addCriterion("report_date <", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLessThanOrEqualTo(Date value) {
            addCriterion("report_date <=", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateIn(List<Date> values) {
            addCriterion("report_date in", values, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotIn(List<Date> values) {
            addCriterion("report_date not in", values, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateBetween(Date value1, Date value2) {
            addCriterion("report_date between", value1, value2, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotBetween(Date value1, Date value2) {
            addCriterion("report_date not between", value1, value2, "reportDate");
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

        public Criteria andGoodStatusIsNull() {
            addCriterion("good_status is null");
            return (Criteria) this;
        }

        public Criteria andGoodStatusIsNotNull() {
            addCriterion("good_status is not null");
            return (Criteria) this;
        }

        public Criteria andGoodStatusEqualTo(Integer value) {
            addCriterion("good_status =", value, "goodStatus");
            return (Criteria) this;
        }

        public Criteria andGoodStatusNotEqualTo(Integer value) {
            addCriterion("good_status <>", value, "goodStatus");
            return (Criteria) this;
        }

        public Criteria andGoodStatusGreaterThan(Integer value) {
            addCriterion("good_status >", value, "goodStatus");
            return (Criteria) this;
        }

        public Criteria andGoodStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_status >=", value, "goodStatus");
            return (Criteria) this;
        }

        public Criteria andGoodStatusLessThan(Integer value) {
            addCriterion("good_status <", value, "goodStatus");
            return (Criteria) this;
        }

        public Criteria andGoodStatusLessThanOrEqualTo(Integer value) {
            addCriterion("good_status <=", value, "goodStatus");
            return (Criteria) this;
        }

        public Criteria andGoodStatusIn(List<Integer> values) {
            addCriterion("good_status in", values, "goodStatus");
            return (Criteria) this;
        }

        public Criteria andGoodStatusNotIn(List<Integer> values) {
            addCriterion("good_status not in", values, "goodStatus");
            return (Criteria) this;
        }

        public Criteria andGoodStatusBetween(Integer value1, Integer value2) {
            addCriterion("good_status between", value1, value2, "goodStatus");
            return (Criteria) this;
        }

        public Criteria andGoodStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("good_status not between", value1, value2, "goodStatus");
            return (Criteria) this;
        }

        public Criteria andExceptionStatusIsNull() {
            addCriterion("exception_status is null");
            return (Criteria) this;
        }

        public Criteria andExceptionStatusIsNotNull() {
            addCriterion("exception_status is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionStatusEqualTo(Integer value) {
            addCriterion("exception_status =", value, "exceptionStatus");
            return (Criteria) this;
        }

        public Criteria andExceptionStatusNotEqualTo(Integer value) {
            addCriterion("exception_status <>", value, "exceptionStatus");
            return (Criteria) this;
        }

        public Criteria andExceptionStatusGreaterThan(Integer value) {
            addCriterion("exception_status >", value, "exceptionStatus");
            return (Criteria) this;
        }

        public Criteria andExceptionStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("exception_status >=", value, "exceptionStatus");
            return (Criteria) this;
        }

        public Criteria andExceptionStatusLessThan(Integer value) {
            addCriterion("exception_status <", value, "exceptionStatus");
            return (Criteria) this;
        }

        public Criteria andExceptionStatusLessThanOrEqualTo(Integer value) {
            addCriterion("exception_status <=", value, "exceptionStatus");
            return (Criteria) this;
        }

        public Criteria andExceptionStatusIn(List<Integer> values) {
            addCriterion("exception_status in", values, "exceptionStatus");
            return (Criteria) this;
        }

        public Criteria andExceptionStatusNotIn(List<Integer> values) {
            addCriterion("exception_status not in", values, "exceptionStatus");
            return (Criteria) this;
        }

        public Criteria andExceptionStatusBetween(Integer value1, Integer value2) {
            addCriterion("exception_status between", value1, value2, "exceptionStatus");
            return (Criteria) this;
        }

        public Criteria andExceptionStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("exception_status not between", value1, value2, "exceptionStatus");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonIsNull() {
            addCriterion("exception_reason is null");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonIsNotNull() {
            addCriterion("exception_reason is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonEqualTo(Integer value) {
            addCriterion("exception_reason =", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonNotEqualTo(Integer value) {
            addCriterion("exception_reason <>", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonGreaterThan(Integer value) {
            addCriterion("exception_reason >", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonGreaterThanOrEqualTo(Integer value) {
            addCriterion("exception_reason >=", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonLessThan(Integer value) {
            addCriterion("exception_reason <", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonLessThanOrEqualTo(Integer value) {
            addCriterion("exception_reason <=", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonIn(List<Integer> values) {
            addCriterion("exception_reason in", values, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonNotIn(List<Integer> values) {
            addCriterion("exception_reason not in", values, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonBetween(Integer value1, Integer value2) {
            addCriterion("exception_reason between", value1, value2, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonNotBetween(Integer value1, Integer value2) {
            addCriterion("exception_reason not between", value1, value2, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionSolutionIsNull() {
            addCriterion("exception_solution is null");
            return (Criteria) this;
        }

        public Criteria andExceptionSolutionIsNotNull() {
            addCriterion("exception_solution is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionSolutionEqualTo(Integer value) {
            addCriterion("exception_solution =", value, "exceptionSolution");
            return (Criteria) this;
        }

        public Criteria andExceptionSolutionNotEqualTo(Integer value) {
            addCriterion("exception_solution <>", value, "exceptionSolution");
            return (Criteria) this;
        }

        public Criteria andExceptionSolutionGreaterThan(Integer value) {
            addCriterion("exception_solution >", value, "exceptionSolution");
            return (Criteria) this;
        }

        public Criteria andExceptionSolutionGreaterThanOrEqualTo(Integer value) {
            addCriterion("exception_solution >=", value, "exceptionSolution");
            return (Criteria) this;
        }

        public Criteria andExceptionSolutionLessThan(Integer value) {
            addCriterion("exception_solution <", value, "exceptionSolution");
            return (Criteria) this;
        }

        public Criteria andExceptionSolutionLessThanOrEqualTo(Integer value) {
            addCriterion("exception_solution <=", value, "exceptionSolution");
            return (Criteria) this;
        }

        public Criteria andExceptionSolutionIn(List<Integer> values) {
            addCriterion("exception_solution in", values, "exceptionSolution");
            return (Criteria) this;
        }

        public Criteria andExceptionSolutionNotIn(List<Integer> values) {
            addCriterion("exception_solution not in", values, "exceptionSolution");
            return (Criteria) this;
        }

        public Criteria andExceptionSolutionBetween(Integer value1, Integer value2) {
            addCriterion("exception_solution between", value1, value2, "exceptionSolution");
            return (Criteria) this;
        }

        public Criteria andExceptionSolutionNotBetween(Integer value1, Integer value2) {
            addCriterion("exception_solution not between", value1, value2, "exceptionSolution");
            return (Criteria) this;
        }

        public Criteria andExceptionSolveTimeIsNull() {
            addCriterion("exception_solve_time is null");
            return (Criteria) this;
        }

        public Criteria andExceptionSolveTimeIsNotNull() {
            addCriterion("exception_solve_time is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionSolveTimeEqualTo(Date value) {
            addCriterion("exception_solve_time =", value, "exceptionSolveTime");
            return (Criteria) this;
        }

        public Criteria andExceptionSolveTimeNotEqualTo(Date value) {
            addCriterion("exception_solve_time <>", value, "exceptionSolveTime");
            return (Criteria) this;
        }

        public Criteria andExceptionSolveTimeGreaterThan(Date value) {
            addCriterion("exception_solve_time >", value, "exceptionSolveTime");
            return (Criteria) this;
        }

        public Criteria andExceptionSolveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("exception_solve_time >=", value, "exceptionSolveTime");
            return (Criteria) this;
        }

        public Criteria andExceptionSolveTimeLessThan(Date value) {
            addCriterion("exception_solve_time <", value, "exceptionSolveTime");
            return (Criteria) this;
        }

        public Criteria andExceptionSolveTimeLessThanOrEqualTo(Date value) {
            addCriterion("exception_solve_time <=", value, "exceptionSolveTime");
            return (Criteria) this;
        }

        public Criteria andExceptionSolveTimeIn(List<Date> values) {
            addCriterion("exception_solve_time in", values, "exceptionSolveTime");
            return (Criteria) this;
        }

        public Criteria andExceptionSolveTimeNotIn(List<Date> values) {
            addCriterion("exception_solve_time not in", values, "exceptionSolveTime");
            return (Criteria) this;
        }

        public Criteria andExceptionSolveTimeBetween(Date value1, Date value2) {
            addCriterion("exception_solve_time between", value1, value2, "exceptionSolveTime");
            return (Criteria) this;
        }

        public Criteria andExceptionSolveTimeNotBetween(Date value1, Date value2) {
            addCriterion("exception_solve_time not between", value1, value2, "exceptionSolveTime");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNull() {
            addCriterion("refund_status is null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNotNull() {
            addCriterion("refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusEqualTo(Integer value) {
            addCriterion("refund_status =", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotEqualTo(Integer value) {
            addCriterion("refund_status <>", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThan(Integer value) {
            addCriterion("refund_status >", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_status >=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThan(Integer value) {
            addCriterion("refund_status <", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThanOrEqualTo(Integer value) {
            addCriterion("refund_status <=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIn(List<Integer> values) {
            addCriterion("refund_status in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotIn(List<Integer> values) {
            addCriterion("refund_status not in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusBetween(Integer value1, Integer value2) {
            addCriterion("refund_status between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_status not between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundReasonIsNull() {
            addCriterion("refund_reason is null");
            return (Criteria) this;
        }

        public Criteria andRefundReasonIsNotNull() {
            addCriterion("refund_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReasonEqualTo(Integer value) {
            addCriterion("refund_reason =", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotEqualTo(Integer value) {
            addCriterion("refund_reason <>", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonGreaterThan(Integer value) {
            addCriterion("refund_reason >", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_reason >=", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonLessThan(Integer value) {
            addCriterion("refund_reason <", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonLessThanOrEqualTo(Integer value) {
            addCriterion("refund_reason <=", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonIn(List<Integer> values) {
            addCriterion("refund_reason in", values, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotIn(List<Integer> values) {
            addCriterion("refund_reason not in", values, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonBetween(Integer value1, Integer value2) {
            addCriterion("refund_reason between", value1, value2, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_reason not between", value1, value2, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNull() {
            addCriterion("refund_amount is null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNotNull() {
            addCriterion("refund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountEqualTo(Integer value) {
            addCriterion("refund_amount =", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotEqualTo(Integer value) {
            addCriterion("refund_amount <>", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThan(Integer value) {
            addCriterion("refund_amount >", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_amount >=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThan(Integer value) {
            addCriterion("refund_amount <", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThanOrEqualTo(Integer value) {
            addCriterion("refund_amount <=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIn(List<Integer> values) {
            addCriterion("refund_amount in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotIn(List<Integer> values) {
            addCriterion("refund_amount not in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountBetween(Integer value1, Integer value2) {
            addCriterion("refund_amount between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_amount not between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkIsNull() {
            addCriterion("refund_remark is null");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkIsNotNull() {
            addCriterion("refund_remark is not null");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkEqualTo(String value) {
            addCriterion("refund_remark =", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkNotEqualTo(String value) {
            addCriterion("refund_remark <>", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkGreaterThan(String value) {
            addCriterion("refund_remark >", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("refund_remark >=", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkLessThan(String value) {
            addCriterion("refund_remark <", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkLessThanOrEqualTo(String value) {
            addCriterion("refund_remark <=", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkLike(String value) {
            addCriterion("refund_remark like", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkNotLike(String value) {
            addCriterion("refund_remark not like", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkIn(List<String> values) {
            addCriterion("refund_remark in", values, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkNotIn(List<String> values) {
            addCriterion("refund_remark not in", values, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkBetween(String value1, String value2) {
            addCriterion("refund_remark between", value1, value2, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkNotBetween(String value1, String value2) {
            addCriterion("refund_remark not between", value1, value2, "refundRemark");
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

        public Criteria andCollectorStaffIdIsNull() {
            addCriterion("collector_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdIsNotNull() {
            addCriterion("collector_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdEqualTo(String value) {
            addCriterion("collector_staff_id =", value, "collectorStaffId");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdNotEqualTo(String value) {
            addCriterion("collector_staff_id <>", value, "collectorStaffId");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdGreaterThan(String value) {
            addCriterion("collector_staff_id >", value, "collectorStaffId");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("collector_staff_id >=", value, "collectorStaffId");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdLessThan(String value) {
            addCriterion("collector_staff_id <", value, "collectorStaffId");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdLessThanOrEqualTo(String value) {
            addCriterion("collector_staff_id <=", value, "collectorStaffId");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdLike(String value) {
            addCriterion("collector_staff_id like", value, "collectorStaffId");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdNotLike(String value) {
            addCriterion("collector_staff_id not like", value, "collectorStaffId");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdIn(List<String> values) {
            addCriterion("collector_staff_id in", values, "collectorStaffId");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdNotIn(List<String> values) {
            addCriterion("collector_staff_id not in", values, "collectorStaffId");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdBetween(String value1, String value2) {
            addCriterion("collector_staff_id between", value1, value2, "collectorStaffId");
            return (Criteria) this;
        }

        public Criteria andCollectorStaffIdNotBetween(String value1, String value2) {
            addCriterion("collector_staff_id not between", value1, value2, "collectorStaffId");
            return (Criteria) this;
        }

        public Criteria andPdfUrlIsNull() {
            addCriterion("pdf_url is null");
            return (Criteria) this;
        }

        public Criteria andPdfUrlIsNotNull() {
            addCriterion("pdf_url is not null");
            return (Criteria) this;
        }

        public Criteria andPdfUrlEqualTo(String value) {
            addCriterion("pdf_url =", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlNotEqualTo(String value) {
            addCriterion("pdf_url <>", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlGreaterThan(String value) {
            addCriterion("pdf_url >", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pdf_url >=", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlLessThan(String value) {
            addCriterion("pdf_url <", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlLessThanOrEqualTo(String value) {
            addCriterion("pdf_url <=", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlLike(String value) {
            addCriterion("pdf_url like", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlNotLike(String value) {
            addCriterion("pdf_url not like", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlIn(List<String> values) {
            addCriterion("pdf_url in", values, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlNotIn(List<String> values) {
            addCriterion("pdf_url not in", values, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlBetween(String value1, String value2) {
            addCriterion("pdf_url between", value1, value2, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlNotBetween(String value1, String value2) {
            addCriterion("pdf_url not between", value1, value2, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlIsNull() {
            addCriterion("pdf_merge_url is null");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlIsNotNull() {
            addCriterion("pdf_merge_url is not null");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlEqualTo(String value) {
            addCriterion("pdf_merge_url =", value, "pdfMergeUrl");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlNotEqualTo(String value) {
            addCriterion("pdf_merge_url <>", value, "pdfMergeUrl");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlGreaterThan(String value) {
            addCriterion("pdf_merge_url >", value, "pdfMergeUrl");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pdf_merge_url >=", value, "pdfMergeUrl");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlLessThan(String value) {
            addCriterion("pdf_merge_url <", value, "pdfMergeUrl");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlLessThanOrEqualTo(String value) {
            addCriterion("pdf_merge_url <=", value, "pdfMergeUrl");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlLike(String value) {
            addCriterion("pdf_merge_url like", value, "pdfMergeUrl");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlNotLike(String value) {
            addCriterion("pdf_merge_url not like", value, "pdfMergeUrl");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlIn(List<String> values) {
            addCriterion("pdf_merge_url in", values, "pdfMergeUrl");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlNotIn(List<String> values) {
            addCriterion("pdf_merge_url not in", values, "pdfMergeUrl");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlBetween(String value1, String value2) {
            addCriterion("pdf_merge_url between", value1, value2, "pdfMergeUrl");
            return (Criteria) this;
        }

        public Criteria andPdfMergeUrlNotBetween(String value1, String value2) {
            addCriterion("pdf_merge_url not between", value1, value2, "pdfMergeUrl");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIsNull() {
            addCriterion("message_status is null");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIsNotNull() {
            addCriterion("message_status is not null");
            return (Criteria) this;
        }

        public Criteria andMessageStatusEqualTo(String value) {
            addCriterion("message_status =", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotEqualTo(String value) {
            addCriterion("message_status <>", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusGreaterThan(String value) {
            addCriterion("message_status >", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusGreaterThanOrEqualTo(String value) {
            addCriterion("message_status >=", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusLessThan(String value) {
            addCriterion("message_status <", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusLessThanOrEqualTo(String value) {
            addCriterion("message_status <=", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusLike(String value) {
            addCriterion("message_status like", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotLike(String value) {
            addCriterion("message_status not like", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIn(List<String> values) {
            addCriterion("message_status in", values, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotIn(List<String> values) {
            addCriterion("message_status not in", values, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusBetween(String value1, String value2) {
            addCriterion("message_status between", value1, value2, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotBetween(String value1, String value2) {
            addCriterion("message_status not between", value1, value2, "messageStatus");
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