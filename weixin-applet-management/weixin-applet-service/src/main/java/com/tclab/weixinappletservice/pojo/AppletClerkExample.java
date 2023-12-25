package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletClerkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletClerkExample() {
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

        public Criteria andClerkIdIsNull() {
            addCriterion("clerk_id is null");
            return (Criteria) this;
        }

        public Criteria andClerkIdIsNotNull() {
            addCriterion("clerk_id is not null");
            return (Criteria) this;
        }

        public Criteria andClerkIdEqualTo(String value) {
            addCriterion("clerk_id =", value, "clerkId");
            return (Criteria) this;
        }

        public Criteria andClerkIdNotEqualTo(String value) {
            addCriterion("clerk_id <>", value, "clerkId");
            return (Criteria) this;
        }

        public Criteria andClerkIdGreaterThan(String value) {
            addCriterion("clerk_id >", value, "clerkId");
            return (Criteria) this;
        }

        public Criteria andClerkIdGreaterThanOrEqualTo(String value) {
            addCriterion("clerk_id >=", value, "clerkId");
            return (Criteria) this;
        }

        public Criteria andClerkIdLessThan(String value) {
            addCriterion("clerk_id <", value, "clerkId");
            return (Criteria) this;
        }

        public Criteria andClerkIdLessThanOrEqualTo(String value) {
            addCriterion("clerk_id <=", value, "clerkId");
            return (Criteria) this;
        }

        public Criteria andClerkIdLike(String value) {
            addCriterion("clerk_id like", value, "clerkId");
            return (Criteria) this;
        }

        public Criteria andClerkIdNotLike(String value) {
            addCriterion("clerk_id not like", value, "clerkId");
            return (Criteria) this;
        }

        public Criteria andClerkIdIn(List<String> values) {
            addCriterion("clerk_id in", values, "clerkId");
            return (Criteria) this;
        }

        public Criteria andClerkIdNotIn(List<String> values) {
            addCriterion("clerk_id not in", values, "clerkId");
            return (Criteria) this;
        }

        public Criteria andClerkIdBetween(String value1, String value2) {
            addCriterion("clerk_id between", value1, value2, "clerkId");
            return (Criteria) this;
        }

        public Criteria andClerkIdNotBetween(String value1, String value2) {
            addCriterion("clerk_id not between", value1, value2, "clerkId");
            return (Criteria) this;
        }

        public Criteria andClerkNameIsNull() {
            addCriterion("clerk_name is null");
            return (Criteria) this;
        }

        public Criteria andClerkNameIsNotNull() {
            addCriterion("clerk_name is not null");
            return (Criteria) this;
        }

        public Criteria andClerkNameEqualTo(String value) {
            addCriterion("clerk_name =", value, "clerkName");
            return (Criteria) this;
        }

        public Criteria andClerkNameNotEqualTo(String value) {
            addCriterion("clerk_name <>", value, "clerkName");
            return (Criteria) this;
        }

        public Criteria andClerkNameGreaterThan(String value) {
            addCriterion("clerk_name >", value, "clerkName");
            return (Criteria) this;
        }

        public Criteria andClerkNameGreaterThanOrEqualTo(String value) {
            addCriterion("clerk_name >=", value, "clerkName");
            return (Criteria) this;
        }

        public Criteria andClerkNameLessThan(String value) {
            addCriterion("clerk_name <", value, "clerkName");
            return (Criteria) this;
        }

        public Criteria andClerkNameLessThanOrEqualTo(String value) {
            addCriterion("clerk_name <=", value, "clerkName");
            return (Criteria) this;
        }

        public Criteria andClerkNameLike(String value) {
            addCriterion("clerk_name like", value, "clerkName");
            return (Criteria) this;
        }

        public Criteria andClerkNameNotLike(String value) {
            addCriterion("clerk_name not like", value, "clerkName");
            return (Criteria) this;
        }

        public Criteria andClerkNameIn(List<String> values) {
            addCriterion("clerk_name in", values, "clerkName");
            return (Criteria) this;
        }

        public Criteria andClerkNameNotIn(List<String> values) {
            addCriterion("clerk_name not in", values, "clerkName");
            return (Criteria) this;
        }

        public Criteria andClerkNameBetween(String value1, String value2) {
            addCriterion("clerk_name between", value1, value2, "clerkName");
            return (Criteria) this;
        }

        public Criteria andClerkNameNotBetween(String value1, String value2) {
            addCriterion("clerk_name not between", value1, value2, "clerkName");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentIsNull() {
            addCriterion("clerk_department is null");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentIsNotNull() {
            addCriterion("clerk_department is not null");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentEqualTo(String value) {
            addCriterion("clerk_department =", value, "clerkDepartment");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentNotEqualTo(String value) {
            addCriterion("clerk_department <>", value, "clerkDepartment");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentGreaterThan(String value) {
            addCriterion("clerk_department >", value, "clerkDepartment");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("clerk_department >=", value, "clerkDepartment");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentLessThan(String value) {
            addCriterion("clerk_department <", value, "clerkDepartment");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentLessThanOrEqualTo(String value) {
            addCriterion("clerk_department <=", value, "clerkDepartment");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentLike(String value) {
            addCriterion("clerk_department like", value, "clerkDepartment");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentNotLike(String value) {
            addCriterion("clerk_department not like", value, "clerkDepartment");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentIn(List<String> values) {
            addCriterion("clerk_department in", values, "clerkDepartment");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentNotIn(List<String> values) {
            addCriterion("clerk_department not in", values, "clerkDepartment");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentBetween(String value1, String value2) {
            addCriterion("clerk_department between", value1, value2, "clerkDepartment");
            return (Criteria) this;
        }

        public Criteria andClerkDepartmentNotBetween(String value1, String value2) {
            addCriterion("clerk_department not between", value1, value2, "clerkDepartment");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneIsNull() {
            addCriterion("clerk_phone is null");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneIsNotNull() {
            addCriterion("clerk_phone is not null");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneEqualTo(String value) {
            addCriterion("clerk_phone =", value, "clerkPhone");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneNotEqualTo(String value) {
            addCriterion("clerk_phone <>", value, "clerkPhone");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneGreaterThan(String value) {
            addCriterion("clerk_phone >", value, "clerkPhone");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("clerk_phone >=", value, "clerkPhone");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneLessThan(String value) {
            addCriterion("clerk_phone <", value, "clerkPhone");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneLessThanOrEqualTo(String value) {
            addCriterion("clerk_phone <=", value, "clerkPhone");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneLike(String value) {
            addCriterion("clerk_phone like", value, "clerkPhone");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneNotLike(String value) {
            addCriterion("clerk_phone not like", value, "clerkPhone");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneIn(List<String> values) {
            addCriterion("clerk_phone in", values, "clerkPhone");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneNotIn(List<String> values) {
            addCriterion("clerk_phone not in", values, "clerkPhone");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneBetween(String value1, String value2) {
            addCriterion("clerk_phone between", value1, value2, "clerkPhone");
            return (Criteria) this;
        }

        public Criteria andClerkPhoneNotBetween(String value1, String value2) {
            addCriterion("clerk_phone not between", value1, value2, "clerkPhone");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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