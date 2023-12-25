package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletGoodExceptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletGoodExceptionExample() {
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

        public Criteria andGoodDelayApplyDateIsNull() {
            addCriterion("good_delay_apply_date is null");
            return (Criteria) this;
        }

        public Criteria andGoodDelayApplyDateIsNotNull() {
            addCriterion("good_delay_apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andGoodDelayApplyDateEqualTo(Date value) {
            addCriterion("good_delay_apply_date =", value, "goodDelayApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodDelayApplyDateNotEqualTo(Date value) {
            addCriterion("good_delay_apply_date <>", value, "goodDelayApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodDelayApplyDateGreaterThan(Date value) {
            addCriterion("good_delay_apply_date >", value, "goodDelayApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodDelayApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("good_delay_apply_date >=", value, "goodDelayApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodDelayApplyDateLessThan(Date value) {
            addCriterion("good_delay_apply_date <", value, "goodDelayApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodDelayApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("good_delay_apply_date <=", value, "goodDelayApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodDelayApplyDateIn(List<Date> values) {
            addCriterion("good_delay_apply_date in", values, "goodDelayApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodDelayApplyDateNotIn(List<Date> values) {
            addCriterion("good_delay_apply_date not in", values, "goodDelayApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodDelayApplyDateBetween(Date value1, Date value2) {
            addCriterion("good_delay_apply_date between", value1, value2, "goodDelayApplyDate");
            return (Criteria) this;
        }

        public Criteria andGoodDelayApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("good_delay_apply_date not between", value1, value2, "goodDelayApplyDate");
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