package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletPackageCatalogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletPackageCatalogExample() {
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

        public Criteria andPackageCatalogIdIsNull() {
            addCriterion("package_catalog_id is null");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdIsNotNull() {
            addCriterion("package_catalog_id is not null");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdEqualTo(String value) {
            addCriterion("package_catalog_id =", value, "packageCatalogId");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdNotEqualTo(String value) {
            addCriterion("package_catalog_id <>", value, "packageCatalogId");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdGreaterThan(String value) {
            addCriterion("package_catalog_id >", value, "packageCatalogId");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdGreaterThanOrEqualTo(String value) {
            addCriterion("package_catalog_id >=", value, "packageCatalogId");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdLessThan(String value) {
            addCriterion("package_catalog_id <", value, "packageCatalogId");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdLessThanOrEqualTo(String value) {
            addCriterion("package_catalog_id <=", value, "packageCatalogId");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdLike(String value) {
            addCriterion("package_catalog_id like", value, "packageCatalogId");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdNotLike(String value) {
            addCriterion("package_catalog_id not like", value, "packageCatalogId");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdIn(List<String> values) {
            addCriterion("package_catalog_id in", values, "packageCatalogId");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdNotIn(List<String> values) {
            addCriterion("package_catalog_id not in", values, "packageCatalogId");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdBetween(String value1, String value2) {
            addCriterion("package_catalog_id between", value1, value2, "packageCatalogId");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogIdNotBetween(String value1, String value2) {
            addCriterion("package_catalog_id not between", value1, value2, "packageCatalogId");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameIsNull() {
            addCriterion("package_catalog_name is null");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameIsNotNull() {
            addCriterion("package_catalog_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameEqualTo(String value) {
            addCriterion("package_catalog_name =", value, "packageCatalogName");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameNotEqualTo(String value) {
            addCriterion("package_catalog_name <>", value, "packageCatalogName");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameGreaterThan(String value) {
            addCriterion("package_catalog_name >", value, "packageCatalogName");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameGreaterThanOrEqualTo(String value) {
            addCriterion("package_catalog_name >=", value, "packageCatalogName");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameLessThan(String value) {
            addCriterion("package_catalog_name <", value, "packageCatalogName");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameLessThanOrEqualTo(String value) {
            addCriterion("package_catalog_name <=", value, "packageCatalogName");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameLike(String value) {
            addCriterion("package_catalog_name like", value, "packageCatalogName");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameNotLike(String value) {
            addCriterion("package_catalog_name not like", value, "packageCatalogName");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameIn(List<String> values) {
            addCriterion("package_catalog_name in", values, "packageCatalogName");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameNotIn(List<String> values) {
            addCriterion("package_catalog_name not in", values, "packageCatalogName");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameBetween(String value1, String value2) {
            addCriterion("package_catalog_name between", value1, value2, "packageCatalogName");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogNameNotBetween(String value1, String value2) {
            addCriterion("package_catalog_name not between", value1, value2, "packageCatalogName");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkIsNull() {
            addCriterion("package_catalog_remark is null");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkIsNotNull() {
            addCriterion("package_catalog_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkEqualTo(String value) {
            addCriterion("package_catalog_remark =", value, "packageCatalogRemark");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkNotEqualTo(String value) {
            addCriterion("package_catalog_remark <>", value, "packageCatalogRemark");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkGreaterThan(String value) {
            addCriterion("package_catalog_remark >", value, "packageCatalogRemark");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("package_catalog_remark >=", value, "packageCatalogRemark");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkLessThan(String value) {
            addCriterion("package_catalog_remark <", value, "packageCatalogRemark");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkLessThanOrEqualTo(String value) {
            addCriterion("package_catalog_remark <=", value, "packageCatalogRemark");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkLike(String value) {
            addCriterion("package_catalog_remark like", value, "packageCatalogRemark");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkNotLike(String value) {
            addCriterion("package_catalog_remark not like", value, "packageCatalogRemark");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkIn(List<String> values) {
            addCriterion("package_catalog_remark in", values, "packageCatalogRemark");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkNotIn(List<String> values) {
            addCriterion("package_catalog_remark not in", values, "packageCatalogRemark");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkBetween(String value1, String value2) {
            addCriterion("package_catalog_remark between", value1, value2, "packageCatalogRemark");
            return (Criteria) this;
        }

        public Criteria andPackageCatalogRemarkNotBetween(String value1, String value2) {
            addCriterion("package_catalog_remark not between", value1, value2, "packageCatalogRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdIsNull() {
            addCriterion("package_source_id is null");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdIsNotNull() {
            addCriterion("package_source_id is not null");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdEqualTo(String value) {
            addCriterion("package_source_id =", value, "packageSourceId");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdNotEqualTo(String value) {
            addCriterion("package_source_id <>", value, "packageSourceId");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdGreaterThan(String value) {
            addCriterion("package_source_id >", value, "packageSourceId");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("package_source_id >=", value, "packageSourceId");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdLessThan(String value) {
            addCriterion("package_source_id <", value, "packageSourceId");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdLessThanOrEqualTo(String value) {
            addCriterion("package_source_id <=", value, "packageSourceId");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdLike(String value) {
            addCriterion("package_source_id like", value, "packageSourceId");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdNotLike(String value) {
            addCriterion("package_source_id not like", value, "packageSourceId");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdIn(List<String> values) {
            addCriterion("package_source_id in", values, "packageSourceId");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdNotIn(List<String> values) {
            addCriterion("package_source_id not in", values, "packageSourceId");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdBetween(String value1, String value2) {
            addCriterion("package_source_id between", value1, value2, "packageSourceId");
            return (Criteria) this;
        }

        public Criteria andPackageSourceIdNotBetween(String value1, String value2) {
            addCriterion("package_source_id not between", value1, value2, "packageSourceId");
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