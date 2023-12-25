package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletPackageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletPackageExample() {
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

        public Criteria andLabCodeIsNull() {
            addCriterion("lab_code is null");
            return (Criteria) this;
        }

        public Criteria andLabCodeIsNotNull() {
            addCriterion("lab_code is not null");
            return (Criteria) this;
        }

        public Criteria andLabCodeEqualTo(String value) {
            addCriterion("lab_code =", value, "labCode");
            return (Criteria) this;
        }

        public Criteria andLabCodeNotEqualTo(String value) {
            addCriterion("lab_code <>", value, "labCode");
            return (Criteria) this;
        }

        public Criteria andLabCodeGreaterThan(String value) {
            addCriterion("lab_code >", value, "labCode");
            return (Criteria) this;
        }

        public Criteria andLabCodeGreaterThanOrEqualTo(String value) {
            addCriterion("lab_code >=", value, "labCode");
            return (Criteria) this;
        }

        public Criteria andLabCodeLessThan(String value) {
            addCriterion("lab_code <", value, "labCode");
            return (Criteria) this;
        }

        public Criteria andLabCodeLessThanOrEqualTo(String value) {
            addCriterion("lab_code <=", value, "labCode");
            return (Criteria) this;
        }

        public Criteria andLabCodeLike(String value) {
            addCriterion("lab_code like", value, "labCode");
            return (Criteria) this;
        }

        public Criteria andLabCodeNotLike(String value) {
            addCriterion("lab_code not like", value, "labCode");
            return (Criteria) this;
        }

        public Criteria andLabCodeIn(List<String> values) {
            addCriterion("lab_code in", values, "labCode");
            return (Criteria) this;
        }

        public Criteria andLabCodeNotIn(List<String> values) {
            addCriterion("lab_code not in", values, "labCode");
            return (Criteria) this;
        }

        public Criteria andLabCodeBetween(String value1, String value2) {
            addCriterion("lab_code between", value1, value2, "labCode");
            return (Criteria) this;
        }

        public Criteria andLabCodeNotBetween(String value1, String value2) {
            addCriterion("lab_code not between", value1, value2, "labCode");
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

        public Criteria andPackageLogoIsNull() {
            addCriterion("package_logo is null");
            return (Criteria) this;
        }

        public Criteria andPackageLogoIsNotNull() {
            addCriterion("package_logo is not null");
            return (Criteria) this;
        }

        public Criteria andPackageLogoEqualTo(String value) {
            addCriterion("package_logo =", value, "packageLogo");
            return (Criteria) this;
        }

        public Criteria andPackageLogoNotEqualTo(String value) {
            addCriterion("package_logo <>", value, "packageLogo");
            return (Criteria) this;
        }

        public Criteria andPackageLogoGreaterThan(String value) {
            addCriterion("package_logo >", value, "packageLogo");
            return (Criteria) this;
        }

        public Criteria andPackageLogoGreaterThanOrEqualTo(String value) {
            addCriterion("package_logo >=", value, "packageLogo");
            return (Criteria) this;
        }

        public Criteria andPackageLogoLessThan(String value) {
            addCriterion("package_logo <", value, "packageLogo");
            return (Criteria) this;
        }

        public Criteria andPackageLogoLessThanOrEqualTo(String value) {
            addCriterion("package_logo <=", value, "packageLogo");
            return (Criteria) this;
        }

        public Criteria andPackageLogoLike(String value) {
            addCriterion("package_logo like", value, "packageLogo");
            return (Criteria) this;
        }

        public Criteria andPackageLogoNotLike(String value) {
            addCriterion("package_logo not like", value, "packageLogo");
            return (Criteria) this;
        }

        public Criteria andPackageLogoIn(List<String> values) {
            addCriterion("package_logo in", values, "packageLogo");
            return (Criteria) this;
        }

        public Criteria andPackageLogoNotIn(List<String> values) {
            addCriterion("package_logo not in", values, "packageLogo");
            return (Criteria) this;
        }

        public Criteria andPackageLogoBetween(String value1, String value2) {
            addCriterion("package_logo between", value1, value2, "packageLogo");
            return (Criteria) this;
        }

        public Criteria andPackageLogoNotBetween(String value1, String value2) {
            addCriterion("package_logo not between", value1, value2, "packageLogo");
            return (Criteria) this;
        }

        public Criteria andPackageInfoIsNull() {
            addCriterion("package_info is null");
            return (Criteria) this;
        }

        public Criteria andPackageInfoIsNotNull() {
            addCriterion("package_info is not null");
            return (Criteria) this;
        }

        public Criteria andPackageInfoEqualTo(String value) {
            addCriterion("package_info =", value, "packageInfo");
            return (Criteria) this;
        }

        public Criteria andPackageInfoNotEqualTo(String value) {
            addCriterion("package_info <>", value, "packageInfo");
            return (Criteria) this;
        }

        public Criteria andPackageInfoGreaterThan(String value) {
            addCriterion("package_info >", value, "packageInfo");
            return (Criteria) this;
        }

        public Criteria andPackageInfoGreaterThanOrEqualTo(String value) {
            addCriterion("package_info >=", value, "packageInfo");
            return (Criteria) this;
        }

        public Criteria andPackageInfoLessThan(String value) {
            addCriterion("package_info <", value, "packageInfo");
            return (Criteria) this;
        }

        public Criteria andPackageInfoLessThanOrEqualTo(String value) {
            addCriterion("package_info <=", value, "packageInfo");
            return (Criteria) this;
        }

        public Criteria andPackageInfoLike(String value) {
            addCriterion("package_info like", value, "packageInfo");
            return (Criteria) this;
        }

        public Criteria andPackageInfoNotLike(String value) {
            addCriterion("package_info not like", value, "packageInfo");
            return (Criteria) this;
        }

        public Criteria andPackageInfoIn(List<String> values) {
            addCriterion("package_info in", values, "packageInfo");
            return (Criteria) this;
        }

        public Criteria andPackageInfoNotIn(List<String> values) {
            addCriterion("package_info not in", values, "packageInfo");
            return (Criteria) this;
        }

        public Criteria andPackageInfoBetween(String value1, String value2) {
            addCriterion("package_info between", value1, value2, "packageInfo");
            return (Criteria) this;
        }

        public Criteria andPackageInfoNotBetween(String value1, String value2) {
            addCriterion("package_info not between", value1, value2, "packageInfo");
            return (Criteria) this;
        }

        public Criteria andPackageLabelIsNull() {
            addCriterion("package_label is null");
            return (Criteria) this;
        }

        public Criteria andPackageLabelIsNotNull() {
            addCriterion("package_label is not null");
            return (Criteria) this;
        }

        public Criteria andPackageLabelEqualTo(String value) {
            addCriterion("package_label =", value, "packageLabel");
            return (Criteria) this;
        }

        public Criteria andPackageLabelNotEqualTo(String value) {
            addCriterion("package_label <>", value, "packageLabel");
            return (Criteria) this;
        }

        public Criteria andPackageLabelGreaterThan(String value) {
            addCriterion("package_label >", value, "packageLabel");
            return (Criteria) this;
        }

        public Criteria andPackageLabelGreaterThanOrEqualTo(String value) {
            addCriterion("package_label >=", value, "packageLabel");
            return (Criteria) this;
        }

        public Criteria andPackageLabelLessThan(String value) {
            addCriterion("package_label <", value, "packageLabel");
            return (Criteria) this;
        }

        public Criteria andPackageLabelLessThanOrEqualTo(String value) {
            addCriterion("package_label <=", value, "packageLabel");
            return (Criteria) this;
        }

        public Criteria andPackageLabelLike(String value) {
            addCriterion("package_label like", value, "packageLabel");
            return (Criteria) this;
        }

        public Criteria andPackageLabelNotLike(String value) {
            addCriterion("package_label not like", value, "packageLabel");
            return (Criteria) this;
        }

        public Criteria andPackageLabelIn(List<String> values) {
            addCriterion("package_label in", values, "packageLabel");
            return (Criteria) this;
        }

        public Criteria andPackageLabelNotIn(List<String> values) {
            addCriterion("package_label not in", values, "packageLabel");
            return (Criteria) this;
        }

        public Criteria andPackageLabelBetween(String value1, String value2) {
            addCriterion("package_label between", value1, value2, "packageLabel");
            return (Criteria) this;
        }

        public Criteria andPackageLabelNotBetween(String value1, String value2) {
            addCriterion("package_label not between", value1, value2, "packageLabel");
            return (Criteria) this;
        }

        public Criteria andPackageRecommendationIsNull() {
            addCriterion("package_recommendation is null");
            return (Criteria) this;
        }

        public Criteria andPackageRecommendationIsNotNull() {
            addCriterion("package_recommendation is not null");
            return (Criteria) this;
        }

        public Criteria andPackageRecommendationEqualTo(Integer value) {
            addCriterion("package_recommendation =", value, "packageRecommendation");
            return (Criteria) this;
        }

        public Criteria andPackageRecommendationNotEqualTo(Integer value) {
            addCriterion("package_recommendation <>", value, "packageRecommendation");
            return (Criteria) this;
        }

        public Criteria andPackageRecommendationGreaterThan(Integer value) {
            addCriterion("package_recommendation >", value, "packageRecommendation");
            return (Criteria) this;
        }

        public Criteria andPackageRecommendationGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_recommendation >=", value, "packageRecommendation");
            return (Criteria) this;
        }

        public Criteria andPackageRecommendationLessThan(Integer value) {
            addCriterion("package_recommendation <", value, "packageRecommendation");
            return (Criteria) this;
        }

        public Criteria andPackageRecommendationLessThanOrEqualTo(Integer value) {
            addCriterion("package_recommendation <=", value, "packageRecommendation");
            return (Criteria) this;
        }

        public Criteria andPackageRecommendationIn(List<Integer> values) {
            addCriterion("package_recommendation in", values, "packageRecommendation");
            return (Criteria) this;
        }

        public Criteria andPackageRecommendationNotIn(List<Integer> values) {
            addCriterion("package_recommendation not in", values, "packageRecommendation");
            return (Criteria) this;
        }

        public Criteria andPackageRecommendationBetween(Integer value1, Integer value2) {
            addCriterion("package_recommendation between", value1, value2, "packageRecommendation");
            return (Criteria) this;
        }

        public Criteria andPackageRecommendationNotBetween(Integer value1, Integer value2) {
            addCriterion("package_recommendation not between", value1, value2, "packageRecommendation");
            return (Criteria) this;
        }

        public Criteria andPackagePriorityIsNull() {
            addCriterion("package_priority is null");
            return (Criteria) this;
        }

        public Criteria andPackagePriorityIsNotNull() {
            addCriterion("package_priority is not null");
            return (Criteria) this;
        }

        public Criteria andPackagePriorityEqualTo(Integer value) {
            addCriterion("package_priority =", value, "packagePriority");
            return (Criteria) this;
        }

        public Criteria andPackagePriorityNotEqualTo(Integer value) {
            addCriterion("package_priority <>", value, "packagePriority");
            return (Criteria) this;
        }

        public Criteria andPackagePriorityGreaterThan(Integer value) {
            addCriterion("package_priority >", value, "packagePriority");
            return (Criteria) this;
        }

        public Criteria andPackagePriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_priority >=", value, "packagePriority");
            return (Criteria) this;
        }

        public Criteria andPackagePriorityLessThan(Integer value) {
            addCriterion("package_priority <", value, "packagePriority");
            return (Criteria) this;
        }

        public Criteria andPackagePriorityLessThanOrEqualTo(Integer value) {
            addCriterion("package_priority <=", value, "packagePriority");
            return (Criteria) this;
        }

        public Criteria andPackagePriorityIn(List<Integer> values) {
            addCriterion("package_priority in", values, "packagePriority");
            return (Criteria) this;
        }

        public Criteria andPackagePriorityNotIn(List<Integer> values) {
            addCriterion("package_priority not in", values, "packagePriority");
            return (Criteria) this;
        }

        public Criteria andPackagePriorityBetween(Integer value1, Integer value2) {
            addCriterion("package_priority between", value1, value2, "packagePriority");
            return (Criteria) this;
        }

        public Criteria andPackagePriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("package_priority not between", value1, value2, "packagePriority");
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

        public Criteria andPackageMessageIsNull() {
            addCriterion("package_message is null");
            return (Criteria) this;
        }

        public Criteria andPackageMessageIsNotNull() {
            addCriterion("package_message is not null");
            return (Criteria) this;
        }

        public Criteria andPackageMessageEqualTo(String value) {
            addCriterion("package_message =", value, "packageMessage");
            return (Criteria) this;
        }

        public Criteria andPackageMessageNotEqualTo(String value) {
            addCriterion("package_message <>", value, "packageMessage");
            return (Criteria) this;
        }

        public Criteria andPackageMessageGreaterThan(String value) {
            addCriterion("package_message >", value, "packageMessage");
            return (Criteria) this;
        }

        public Criteria andPackageMessageGreaterThanOrEqualTo(String value) {
            addCriterion("package_message >=", value, "packageMessage");
            return (Criteria) this;
        }

        public Criteria andPackageMessageLessThan(String value) {
            addCriterion("package_message <", value, "packageMessage");
            return (Criteria) this;
        }

        public Criteria andPackageMessageLessThanOrEqualTo(String value) {
            addCriterion("package_message <=", value, "packageMessage");
            return (Criteria) this;
        }

        public Criteria andPackageMessageLike(String value) {
            addCriterion("package_message like", value, "packageMessage");
            return (Criteria) this;
        }

        public Criteria andPackageMessageNotLike(String value) {
            addCriterion("package_message not like", value, "packageMessage");
            return (Criteria) this;
        }

        public Criteria andPackageMessageIn(List<String> values) {
            addCriterion("package_message in", values, "packageMessage");
            return (Criteria) this;
        }

        public Criteria andPackageMessageNotIn(List<String> values) {
            addCriterion("package_message not in", values, "packageMessage");
            return (Criteria) this;
        }

        public Criteria andPackageMessageBetween(String value1, String value2) {
            addCriterion("package_message between", value1, value2, "packageMessage");
            return (Criteria) this;
        }

        public Criteria andPackageMessageNotBetween(String value1, String value2) {
            addCriterion("package_message not between", value1, value2, "packageMessage");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdIsNull() {
            addCriterion("package_purpose_id is null");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdIsNotNull() {
            addCriterion("package_purpose_id is not null");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdEqualTo(String value) {
            addCriterion("package_purpose_id =", value, "packagePurposeId");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdNotEqualTo(String value) {
            addCriterion("package_purpose_id <>", value, "packagePurposeId");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdGreaterThan(String value) {
            addCriterion("package_purpose_id >", value, "packagePurposeId");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdGreaterThanOrEqualTo(String value) {
            addCriterion("package_purpose_id >=", value, "packagePurposeId");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdLessThan(String value) {
            addCriterion("package_purpose_id <", value, "packagePurposeId");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdLessThanOrEqualTo(String value) {
            addCriterion("package_purpose_id <=", value, "packagePurposeId");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdLike(String value) {
            addCriterion("package_purpose_id like", value, "packagePurposeId");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdNotLike(String value) {
            addCriterion("package_purpose_id not like", value, "packagePurposeId");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdIn(List<String> values) {
            addCriterion("package_purpose_id in", values, "packagePurposeId");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdNotIn(List<String> values) {
            addCriterion("package_purpose_id not in", values, "packagePurposeId");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdBetween(String value1, String value2) {
            addCriterion("package_purpose_id between", value1, value2, "packagePurposeId");
            return (Criteria) this;
        }

        public Criteria andPackagePurposeIdNotBetween(String value1, String value2) {
            addCriterion("package_purpose_id not between", value1, value2, "packagePurposeId");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdIsNull() {
            addCriterion("package_population_id is null");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdIsNotNull() {
            addCriterion("package_population_id is not null");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdEqualTo(String value) {
            addCriterion("package_population_id =", value, "packagePopulationId");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdNotEqualTo(String value) {
            addCriterion("package_population_id <>", value, "packagePopulationId");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdGreaterThan(String value) {
            addCriterion("package_population_id >", value, "packagePopulationId");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdGreaterThanOrEqualTo(String value) {
            addCriterion("package_population_id >=", value, "packagePopulationId");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdLessThan(String value) {
            addCriterion("package_population_id <", value, "packagePopulationId");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdLessThanOrEqualTo(String value) {
            addCriterion("package_population_id <=", value, "packagePopulationId");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdLike(String value) {
            addCriterion("package_population_id like", value, "packagePopulationId");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdNotLike(String value) {
            addCriterion("package_population_id not like", value, "packagePopulationId");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdIn(List<String> values) {
            addCriterion("package_population_id in", values, "packagePopulationId");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdNotIn(List<String> values) {
            addCriterion("package_population_id not in", values, "packagePopulationId");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdBetween(String value1, String value2) {
            addCriterion("package_population_id between", value1, value2, "packagePopulationId");
            return (Criteria) this;
        }

        public Criteria andPackagePopulationIdNotBetween(String value1, String value2) {
            addCriterion("package_population_id not between", value1, value2, "packagePopulationId");
            return (Criteria) this;
        }

        public Criteria andPopulationNameIsNull() {
            addCriterion("population_name is null");
            return (Criteria) this;
        }

        public Criteria andPopulationNameIsNotNull() {
            addCriterion("population_name is not null");
            return (Criteria) this;
        }

        public Criteria andPopulationNameEqualTo(String value) {
            addCriterion("population_name =", value, "populationName");
            return (Criteria) this;
        }

        public Criteria andPopulationNameNotEqualTo(String value) {
            addCriterion("population_name <>", value, "populationName");
            return (Criteria) this;
        }

        public Criteria andPopulationNameGreaterThan(String value) {
            addCriterion("population_name >", value, "populationName");
            return (Criteria) this;
        }

        public Criteria andPopulationNameGreaterThanOrEqualTo(String value) {
            addCriterion("population_name >=", value, "populationName");
            return (Criteria) this;
        }

        public Criteria andPopulationNameLessThan(String value) {
            addCriterion("population_name <", value, "populationName");
            return (Criteria) this;
        }

        public Criteria andPopulationNameLessThanOrEqualTo(String value) {
            addCriterion("population_name <=", value, "populationName");
            return (Criteria) this;
        }

        public Criteria andPopulationNameLike(String value) {
            addCriterion("population_name like", value, "populationName");
            return (Criteria) this;
        }

        public Criteria andPopulationNameNotLike(String value) {
            addCriterion("population_name not like", value, "populationName");
            return (Criteria) this;
        }

        public Criteria andPopulationNameIn(List<String> values) {
            addCriterion("population_name in", values, "populationName");
            return (Criteria) this;
        }

        public Criteria andPopulationNameNotIn(List<String> values) {
            addCriterion("population_name not in", values, "populationName");
            return (Criteria) this;
        }

        public Criteria andPopulationNameBetween(String value1, String value2) {
            addCriterion("population_name between", value1, value2, "populationName");
            return (Criteria) this;
        }

        public Criteria andPopulationNameNotBetween(String value1, String value2) {
            addCriterion("population_name not between", value1, value2, "populationName");
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

        public Criteria andPackageSourceNameIsNull() {
            addCriterion("package_source_name is null");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameIsNotNull() {
            addCriterion("package_source_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameEqualTo(String value) {
            addCriterion("package_source_name =", value, "packageSourceName");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameNotEqualTo(String value) {
            addCriterion("package_source_name <>", value, "packageSourceName");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameGreaterThan(String value) {
            addCriterion("package_source_name >", value, "packageSourceName");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("package_source_name >=", value, "packageSourceName");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameLessThan(String value) {
            addCriterion("package_source_name <", value, "packageSourceName");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameLessThanOrEqualTo(String value) {
            addCriterion("package_source_name <=", value, "packageSourceName");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameLike(String value) {
            addCriterion("package_source_name like", value, "packageSourceName");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameNotLike(String value) {
            addCriterion("package_source_name not like", value, "packageSourceName");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameIn(List<String> values) {
            addCriterion("package_source_name in", values, "packageSourceName");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameNotIn(List<String> values) {
            addCriterion("package_source_name not in", values, "packageSourceName");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameBetween(String value1, String value2) {
            addCriterion("package_source_name between", value1, value2, "packageSourceName");
            return (Criteria) this;
        }

        public Criteria andPackageSourceNameNotBetween(String value1, String value2) {
            addCriterion("package_source_name not between", value1, value2, "packageSourceName");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkIsNull() {
            addCriterion("package_remark is null");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkIsNotNull() {
            addCriterion("package_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkEqualTo(String value) {
            addCriterion("package_remark =", value, "packageRemark");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkNotEqualTo(String value) {
            addCriterion("package_remark <>", value, "packageRemark");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkGreaterThan(String value) {
            addCriterion("package_remark >", value, "packageRemark");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("package_remark >=", value, "packageRemark");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkLessThan(String value) {
            addCriterion("package_remark <", value, "packageRemark");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkLessThanOrEqualTo(String value) {
            addCriterion("package_remark <=", value, "packageRemark");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkLike(String value) {
            addCriterion("package_remark like", value, "packageRemark");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkNotLike(String value) {
            addCriterion("package_remark not like", value, "packageRemark");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkIn(List<String> values) {
            addCriterion("package_remark in", values, "packageRemark");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkNotIn(List<String> values) {
            addCriterion("package_remark not in", values, "packageRemark");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkBetween(String value1, String value2) {
            addCriterion("package_remark between", value1, value2, "packageRemark");
            return (Criteria) this;
        }

        public Criteria andPackageRemarkNotBetween(String value1, String value2) {
            addCriterion("package_remark not between", value1, value2, "packageRemark");
            return (Criteria) this;
        }

        public Criteria andPackagePrimePriceIsNull() {
            addCriterion("package_prime_price is null");
            return (Criteria) this;
        }

        public Criteria andPackagePrimePriceIsNotNull() {
            addCriterion("package_prime_price is not null");
            return (Criteria) this;
        }

        public Criteria andPackagePrimePriceEqualTo(BigDecimal value) {
            addCriterion("package_prime_price =", value, "packagePrimePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePrimePriceNotEqualTo(BigDecimal value) {
            addCriterion("package_prime_price <>", value, "packagePrimePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePrimePriceGreaterThan(BigDecimal value) {
            addCriterion("package_prime_price >", value, "packagePrimePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePrimePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("package_prime_price >=", value, "packagePrimePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePrimePriceLessThan(BigDecimal value) {
            addCriterion("package_prime_price <", value, "packagePrimePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePrimePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("package_prime_price <=", value, "packagePrimePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePrimePriceIn(List<BigDecimal> values) {
            addCriterion("package_prime_price in", values, "packagePrimePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePrimePriceNotIn(List<BigDecimal> values) {
            addCriterion("package_prime_price not in", values, "packagePrimePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePrimePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("package_prime_price between", value1, value2, "packagePrimePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePrimePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("package_prime_price not between", value1, value2, "packagePrimePrice");
            return (Criteria) this;
        }

        public Criteria andPackageCurrentPriceIsNull() {
            addCriterion("package_current_price is null");
            return (Criteria) this;
        }

        public Criteria andPackageCurrentPriceIsNotNull() {
            addCriterion("package_current_price is not null");
            return (Criteria) this;
        }

        public Criteria andPackageCurrentPriceEqualTo(BigDecimal value) {
            addCriterion("package_current_price =", value, "packageCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCurrentPriceNotEqualTo(BigDecimal value) {
            addCriterion("package_current_price <>", value, "packageCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCurrentPriceGreaterThan(BigDecimal value) {
            addCriterion("package_current_price >", value, "packageCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCurrentPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("package_current_price >=", value, "packageCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCurrentPriceLessThan(BigDecimal value) {
            addCriterion("package_current_price <", value, "packageCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCurrentPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("package_current_price <=", value, "packageCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCurrentPriceIn(List<BigDecimal> values) {
            addCriterion("package_current_price in", values, "packageCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCurrentPriceNotIn(List<BigDecimal> values) {
            addCriterion("package_current_price not in", values, "packageCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCurrentPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("package_current_price between", value1, value2, "packageCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andPackageCurrentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("package_current_price not between", value1, value2, "packageCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andPackageStatusIsNull() {
            addCriterion("package_status is null");
            return (Criteria) this;
        }

        public Criteria andPackageStatusIsNotNull() {
            addCriterion("package_status is not null");
            return (Criteria) this;
        }

        public Criteria andPackageStatusEqualTo(Integer value) {
            addCriterion("package_status =", value, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusNotEqualTo(Integer value) {
            addCriterion("package_status <>", value, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusGreaterThan(Integer value) {
            addCriterion("package_status >", value, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_status >=", value, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusLessThan(Integer value) {
            addCriterion("package_status <", value, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusLessThanOrEqualTo(Integer value) {
            addCriterion("package_status <=", value, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusIn(List<Integer> values) {
            addCriterion("package_status in", values, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusNotIn(List<Integer> values) {
            addCriterion("package_status not in", values, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusBetween(Integer value1, Integer value2) {
            addCriterion("package_status between", value1, value2, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("package_status not between", value1, value2, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageCollectTypeIsNull() {
            addCriterion("package_collect_type is null");
            return (Criteria) this;
        }

        public Criteria andPackageCollectTypeIsNotNull() {
            addCriterion("package_collect_type is not null");
            return (Criteria) this;
        }

        public Criteria andPackageCollectTypeEqualTo(Integer value) {
            addCriterion("package_collect_type =", value, "packageCollectType");
            return (Criteria) this;
        }

        public Criteria andPackageCollectTypeNotEqualTo(Integer value) {
            addCriterion("package_collect_type <>", value, "packageCollectType");
            return (Criteria) this;
        }

        public Criteria andPackageCollectTypeGreaterThan(Integer value) {
            addCriterion("package_collect_type >", value, "packageCollectType");
            return (Criteria) this;
        }

        public Criteria andPackageCollectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_collect_type >=", value, "packageCollectType");
            return (Criteria) this;
        }

        public Criteria andPackageCollectTypeLessThan(Integer value) {
            addCriterion("package_collect_type <", value, "packageCollectType");
            return (Criteria) this;
        }

        public Criteria andPackageCollectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("package_collect_type <=", value, "packageCollectType");
            return (Criteria) this;
        }

        public Criteria andPackageCollectTypeIn(List<Integer> values) {
            addCriterion("package_collect_type in", values, "packageCollectType");
            return (Criteria) this;
        }

        public Criteria andPackageCollectTypeNotIn(List<Integer> values) {
            addCriterion("package_collect_type not in", values, "packageCollectType");
            return (Criteria) this;
        }

        public Criteria andPackageCollectTypeBetween(Integer value1, Integer value2) {
            addCriterion("package_collect_type between", value1, value2, "packageCollectType");
            return (Criteria) this;
        }

        public Criteria andPackageCollectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("package_collect_type not between", value1, value2, "packageCollectType");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicIsNull() {
            addCriterion("package_sample_pic is null");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicIsNotNull() {
            addCriterion("package_sample_pic is not null");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicEqualTo(String value) {
            addCriterion("package_sample_pic =", value, "packageSamplePic");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicNotEqualTo(String value) {
            addCriterion("package_sample_pic <>", value, "packageSamplePic");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicGreaterThan(String value) {
            addCriterion("package_sample_pic >", value, "packageSamplePic");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicGreaterThanOrEqualTo(String value) {
            addCriterion("package_sample_pic >=", value, "packageSamplePic");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicLessThan(String value) {
            addCriterion("package_sample_pic <", value, "packageSamplePic");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicLessThanOrEqualTo(String value) {
            addCriterion("package_sample_pic <=", value, "packageSamplePic");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicLike(String value) {
            addCriterion("package_sample_pic like", value, "packageSamplePic");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicNotLike(String value) {
            addCriterion("package_sample_pic not like", value, "packageSamplePic");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicIn(List<String> values) {
            addCriterion("package_sample_pic in", values, "packageSamplePic");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicNotIn(List<String> values) {
            addCriterion("package_sample_pic not in", values, "packageSamplePic");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicBetween(String value1, String value2) {
            addCriterion("package_sample_pic between", value1, value2, "packageSamplePic");
            return (Criteria) this;
        }

        public Criteria andPackageSamplePicNotBetween(String value1, String value2) {
            addCriterion("package_sample_pic not between", value1, value2, "packageSamplePic");
            return (Criteria) this;
        }

        public Criteria andPackageStepIsNull() {
            addCriterion("package_step is null");
            return (Criteria) this;
        }

        public Criteria andPackageStepIsNotNull() {
            addCriterion("package_step is not null");
            return (Criteria) this;
        }

        public Criteria andPackageStepEqualTo(String value) {
            addCriterion("package_step =", value, "packageStep");
            return (Criteria) this;
        }

        public Criteria andPackageStepNotEqualTo(String value) {
            addCriterion("package_step <>", value, "packageStep");
            return (Criteria) this;
        }

        public Criteria andPackageStepGreaterThan(String value) {
            addCriterion("package_step >", value, "packageStep");
            return (Criteria) this;
        }

        public Criteria andPackageStepGreaterThanOrEqualTo(String value) {
            addCriterion("package_step >=", value, "packageStep");
            return (Criteria) this;
        }

        public Criteria andPackageStepLessThan(String value) {
            addCriterion("package_step <", value, "packageStep");
            return (Criteria) this;
        }

        public Criteria andPackageStepLessThanOrEqualTo(String value) {
            addCriterion("package_step <=", value, "packageStep");
            return (Criteria) this;
        }

        public Criteria andPackageStepLike(String value) {
            addCriterion("package_step like", value, "packageStep");
            return (Criteria) this;
        }

        public Criteria andPackageStepNotLike(String value) {
            addCriterion("package_step not like", value, "packageStep");
            return (Criteria) this;
        }

        public Criteria andPackageStepIn(List<String> values) {
            addCriterion("package_step in", values, "packageStep");
            return (Criteria) this;
        }

        public Criteria andPackageStepNotIn(List<String> values) {
            addCriterion("package_step not in", values, "packageStep");
            return (Criteria) this;
        }

        public Criteria andPackageStepBetween(String value1, String value2) {
            addCriterion("package_step between", value1, value2, "packageStep");
            return (Criteria) this;
        }

        public Criteria andPackageStepNotBetween(String value1, String value2) {
            addCriterion("package_step not between", value1, value2, "packageStep");
            return (Criteria) this;
        }

        public Criteria andPackageReportTypeIsNull() {
            addCriterion("package_report_type is null");
            return (Criteria) this;
        }

        public Criteria andPackageReportTypeIsNotNull() {
            addCriterion("package_report_type is not null");
            return (Criteria) this;
        }

        public Criteria andPackageReportTypeEqualTo(Integer value) {
            addCriterion("package_report_type =", value, "packageReportType");
            return (Criteria) this;
        }

        public Criteria andPackageReportTypeNotEqualTo(Integer value) {
            addCriterion("package_report_type <>", value, "packageReportType");
            return (Criteria) this;
        }

        public Criteria andPackageReportTypeGreaterThan(Integer value) {
            addCriterion("package_report_type >", value, "packageReportType");
            return (Criteria) this;
        }

        public Criteria andPackageReportTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_report_type >=", value, "packageReportType");
            return (Criteria) this;
        }

        public Criteria andPackageReportTypeLessThan(Integer value) {
            addCriterion("package_report_type <", value, "packageReportType");
            return (Criteria) this;
        }

        public Criteria andPackageReportTypeLessThanOrEqualTo(Integer value) {
            addCriterion("package_report_type <=", value, "packageReportType");
            return (Criteria) this;
        }

        public Criteria andPackageReportTypeIn(List<Integer> values) {
            addCriterion("package_report_type in", values, "packageReportType");
            return (Criteria) this;
        }

        public Criteria andPackageReportTypeNotIn(List<Integer> values) {
            addCriterion("package_report_type not in", values, "packageReportType");
            return (Criteria) this;
        }

        public Criteria andPackageReportTypeBetween(Integer value1, Integer value2) {
            addCriterion("package_report_type between", value1, value2, "packageReportType");
            return (Criteria) this;
        }

        public Criteria andPackageReportTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("package_report_type not between", value1, value2, "packageReportType");
            return (Criteria) this;
        }

        public Criteria andPackageReportChargeIsNull() {
            addCriterion("package_report_charge is null");
            return (Criteria) this;
        }

        public Criteria andPackageReportChargeIsNotNull() {
            addCriterion("package_report_charge is not null");
            return (Criteria) this;
        }

        public Criteria andPackageReportChargeEqualTo(BigDecimal value) {
            addCriterion("package_report_charge =", value, "packageReportCharge");
            return (Criteria) this;
        }

        public Criteria andPackageReportChargeNotEqualTo(BigDecimal value) {
            addCriterion("package_report_charge <>", value, "packageReportCharge");
            return (Criteria) this;
        }

        public Criteria andPackageReportChargeGreaterThan(BigDecimal value) {
            addCriterion("package_report_charge >", value, "packageReportCharge");
            return (Criteria) this;
        }

        public Criteria andPackageReportChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("package_report_charge >=", value, "packageReportCharge");
            return (Criteria) this;
        }

        public Criteria andPackageReportChargeLessThan(BigDecimal value) {
            addCriterion("package_report_charge <", value, "packageReportCharge");
            return (Criteria) this;
        }

        public Criteria andPackageReportChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("package_report_charge <=", value, "packageReportCharge");
            return (Criteria) this;
        }

        public Criteria andPackageReportChargeIn(List<BigDecimal> values) {
            addCriterion("package_report_charge in", values, "packageReportCharge");
            return (Criteria) this;
        }

        public Criteria andPackageReportChargeNotIn(List<BigDecimal> values) {
            addCriterion("package_report_charge not in", values, "packageReportCharge");
            return (Criteria) this;
        }

        public Criteria andPackageReportChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("package_report_charge between", value1, value2, "packageReportCharge");
            return (Criteria) this;
        }

        public Criteria andPackageReportChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("package_report_charge not between", value1, value2, "packageReportCharge");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeIsNull() {
            addCriterion("package_report_time is null");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeIsNotNull() {
            addCriterion("package_report_time is not null");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeEqualTo(String value) {
            addCriterion("package_report_time =", value, "packageReportTime");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeNotEqualTo(String value) {
            addCriterion("package_report_time <>", value, "packageReportTime");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeGreaterThan(String value) {
            addCriterion("package_report_time >", value, "packageReportTime");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeGreaterThanOrEqualTo(String value) {
            addCriterion("package_report_time >=", value, "packageReportTime");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeLessThan(String value) {
            addCriterion("package_report_time <", value, "packageReportTime");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeLessThanOrEqualTo(String value) {
            addCriterion("package_report_time <=", value, "packageReportTime");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeLike(String value) {
            addCriterion("package_report_time like", value, "packageReportTime");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeNotLike(String value) {
            addCriterion("package_report_time not like", value, "packageReportTime");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeIn(List<String> values) {
            addCriterion("package_report_time in", values, "packageReportTime");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeNotIn(List<String> values) {
            addCriterion("package_report_time not in", values, "packageReportTime");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeBetween(String value1, String value2) {
            addCriterion("package_report_time between", value1, value2, "packageReportTime");
            return (Criteria) this;
        }

        public Criteria andPackageReportTimeNotBetween(String value1, String value2) {
            addCriterion("package_report_time not between", value1, value2, "packageReportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescIsNull() {
            addCriterion("report_time_desc is null");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescIsNotNull() {
            addCriterion("report_time_desc is not null");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescEqualTo(String value) {
            addCriterion("report_time_desc =", value, "reportTimeDesc");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescNotEqualTo(String value) {
            addCriterion("report_time_desc <>", value, "reportTimeDesc");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescGreaterThan(String value) {
            addCriterion("report_time_desc >", value, "reportTimeDesc");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescGreaterThanOrEqualTo(String value) {
            addCriterion("report_time_desc >=", value, "reportTimeDesc");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescLessThan(String value) {
            addCriterion("report_time_desc <", value, "reportTimeDesc");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescLessThanOrEqualTo(String value) {
            addCriterion("report_time_desc <=", value, "reportTimeDesc");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescLike(String value) {
            addCriterion("report_time_desc like", value, "reportTimeDesc");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescNotLike(String value) {
            addCriterion("report_time_desc not like", value, "reportTimeDesc");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescIn(List<String> values) {
            addCriterion("report_time_desc in", values, "reportTimeDesc");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescNotIn(List<String> values) {
            addCriterion("report_time_desc not in", values, "reportTimeDesc");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescBetween(String value1, String value2) {
            addCriterion("report_time_desc between", value1, value2, "reportTimeDesc");
            return (Criteria) this;
        }

        public Criteria andReportTimeDescNotBetween(String value1, String value2) {
            addCriterion("report_time_desc not between", value1, value2, "reportTimeDesc");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameIsNull() {
            addCriterion("sample_type_name is null");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameIsNotNull() {
            addCriterion("sample_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameEqualTo(String value) {
            addCriterion("sample_type_name =", value, "sampleTypeName");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameNotEqualTo(String value) {
            addCriterion("sample_type_name <>", value, "sampleTypeName");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameGreaterThan(String value) {
            addCriterion("sample_type_name >", value, "sampleTypeName");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("sample_type_name >=", value, "sampleTypeName");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameLessThan(String value) {
            addCriterion("sample_type_name <", value, "sampleTypeName");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameLessThanOrEqualTo(String value) {
            addCriterion("sample_type_name <=", value, "sampleTypeName");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameLike(String value) {
            addCriterion("sample_type_name like", value, "sampleTypeName");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameNotLike(String value) {
            addCriterion("sample_type_name not like", value, "sampleTypeName");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameIn(List<String> values) {
            addCriterion("sample_type_name in", values, "sampleTypeName");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameNotIn(List<String> values) {
            addCriterion("sample_type_name not in", values, "sampleTypeName");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameBetween(String value1, String value2) {
            addCriterion("sample_type_name between", value1, value2, "sampleTypeName");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNameNotBetween(String value1, String value2) {
            addCriterion("sample_type_name not between", value1, value2, "sampleTypeName");
            return (Criteria) this;
        }

        public Criteria andSampleTypeIsNull() {
            addCriterion("sample_type is null");
            return (Criteria) this;
        }

        public Criteria andSampleTypeIsNotNull() {
            addCriterion("sample_type is not null");
            return (Criteria) this;
        }

        public Criteria andSampleTypeEqualTo(Integer value) {
            addCriterion("sample_type =", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNotEqualTo(Integer value) {
            addCriterion("sample_type <>", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeGreaterThan(Integer value) {
            addCriterion("sample_type >", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sample_type >=", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeLessThan(Integer value) {
            addCriterion("sample_type <", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sample_type <=", value, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeIn(List<Integer> values) {
            addCriterion("sample_type in", values, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNotIn(List<Integer> values) {
            addCriterion("sample_type not in", values, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeBetween(Integer value1, Integer value2) {
            addCriterion("sample_type between", value1, value2, "sampleType");
            return (Criteria) this;
        }

        public Criteria andSampleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sample_type not between", value1, value2, "sampleType");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementIsNull() {
            addCriterion("package_special_requirement is null");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementIsNotNull() {
            addCriterion("package_special_requirement is not null");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementEqualTo(String value) {
            addCriterion("package_special_requirement =", value, "packageSpecialRequirement");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementNotEqualTo(String value) {
            addCriterion("package_special_requirement <>", value, "packageSpecialRequirement");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementGreaterThan(String value) {
            addCriterion("package_special_requirement >", value, "packageSpecialRequirement");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementGreaterThanOrEqualTo(String value) {
            addCriterion("package_special_requirement >=", value, "packageSpecialRequirement");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementLessThan(String value) {
            addCriterion("package_special_requirement <", value, "packageSpecialRequirement");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementLessThanOrEqualTo(String value) {
            addCriterion("package_special_requirement <=", value, "packageSpecialRequirement");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementLike(String value) {
            addCriterion("package_special_requirement like", value, "packageSpecialRequirement");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementNotLike(String value) {
            addCriterion("package_special_requirement not like", value, "packageSpecialRequirement");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementIn(List<String> values) {
            addCriterion("package_special_requirement in", values, "packageSpecialRequirement");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementNotIn(List<String> values) {
            addCriterion("package_special_requirement not in", values, "packageSpecialRequirement");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementBetween(String value1, String value2) {
            addCriterion("package_special_requirement between", value1, value2, "packageSpecialRequirement");
            return (Criteria) this;
        }

        public Criteria andPackageSpecialRequirementNotBetween(String value1, String value2) {
            addCriterion("package_special_requirement not between", value1, value2, "packageSpecialRequirement");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentIsNull() {
            addCriterion("package_equipment is null");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentIsNotNull() {
            addCriterion("package_equipment is not null");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentEqualTo(String value) {
            addCriterion("package_equipment =", value, "packageEquipment");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentNotEqualTo(String value) {
            addCriterion("package_equipment <>", value, "packageEquipment");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentGreaterThan(String value) {
            addCriterion("package_equipment >", value, "packageEquipment");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentGreaterThanOrEqualTo(String value) {
            addCriterion("package_equipment >=", value, "packageEquipment");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentLessThan(String value) {
            addCriterion("package_equipment <", value, "packageEquipment");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentLessThanOrEqualTo(String value) {
            addCriterion("package_equipment <=", value, "packageEquipment");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentLike(String value) {
            addCriterion("package_equipment like", value, "packageEquipment");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentNotLike(String value) {
            addCriterion("package_equipment not like", value, "packageEquipment");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentIn(List<String> values) {
            addCriterion("package_equipment in", values, "packageEquipment");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentNotIn(List<String> values) {
            addCriterion("package_equipment not in", values, "packageEquipment");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentBetween(String value1, String value2) {
            addCriterion("package_equipment between", value1, value2, "packageEquipment");
            return (Criteria) this;
        }

        public Criteria andPackageEquipmentNotBetween(String value1, String value2) {
            addCriterion("package_equipment not between", value1, value2, "packageEquipment");
            return (Criteria) this;
        }

        public Criteria andStorageConditionIsNull() {
            addCriterion("storage_condition is null");
            return (Criteria) this;
        }

        public Criteria andStorageConditionIsNotNull() {
            addCriterion("storage_condition is not null");
            return (Criteria) this;
        }

        public Criteria andStorageConditionEqualTo(String value) {
            addCriterion("storage_condition =", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionNotEqualTo(String value) {
            addCriterion("storage_condition <>", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionGreaterThan(String value) {
            addCriterion("storage_condition >", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionGreaterThanOrEqualTo(String value) {
            addCriterion("storage_condition >=", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionLessThan(String value) {
            addCriterion("storage_condition <", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionLessThanOrEqualTo(String value) {
            addCriterion("storage_condition <=", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionLike(String value) {
            addCriterion("storage_condition like", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionNotLike(String value) {
            addCriterion("storage_condition not like", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionIn(List<String> values) {
            addCriterion("storage_condition in", values, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionNotIn(List<String> values) {
            addCriterion("storage_condition not in", values, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionBetween(String value1, String value2) {
            addCriterion("storage_condition between", value1, value2, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionNotBetween(String value1, String value2) {
            addCriterion("storage_condition not between", value1, value2, "storageCondition");
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

        public Criteria andTestObjectIdIsNull() {
            addCriterion("test_object_id is null");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdIsNotNull() {
            addCriterion("test_object_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdEqualTo(String value) {
            addCriterion("test_object_id =", value, "testObjectId");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdNotEqualTo(String value) {
            addCriterion("test_object_id <>", value, "testObjectId");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdGreaterThan(String value) {
            addCriterion("test_object_id >", value, "testObjectId");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("test_object_id >=", value, "testObjectId");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdLessThan(String value) {
            addCriterion("test_object_id <", value, "testObjectId");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdLessThanOrEqualTo(String value) {
            addCriterion("test_object_id <=", value, "testObjectId");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdLike(String value) {
            addCriterion("test_object_id like", value, "testObjectId");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdNotLike(String value) {
            addCriterion("test_object_id not like", value, "testObjectId");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdIn(List<String> values) {
            addCriterion("test_object_id in", values, "testObjectId");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdNotIn(List<String> values) {
            addCriterion("test_object_id not in", values, "testObjectId");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdBetween(String value1, String value2) {
            addCriterion("test_object_id between", value1, value2, "testObjectId");
            return (Criteria) this;
        }

        public Criteria andTestObjectIdNotBetween(String value1, String value2) {
            addCriterion("test_object_id not between", value1, value2, "testObjectId");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceIsNull() {
            addCriterion("clinical_significance is null");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceIsNotNull() {
            addCriterion("clinical_significance is not null");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceEqualTo(String value) {
            addCriterion("clinical_significance =", value, "clinicalSignificance");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceNotEqualTo(String value) {
            addCriterion("clinical_significance <>", value, "clinicalSignificance");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceGreaterThan(String value) {
            addCriterion("clinical_significance >", value, "clinicalSignificance");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceGreaterThanOrEqualTo(String value) {
            addCriterion("clinical_significance >=", value, "clinicalSignificance");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceLessThan(String value) {
            addCriterion("clinical_significance <", value, "clinicalSignificance");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceLessThanOrEqualTo(String value) {
            addCriterion("clinical_significance <=", value, "clinicalSignificance");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceLike(String value) {
            addCriterion("clinical_significance like", value, "clinicalSignificance");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceNotLike(String value) {
            addCriterion("clinical_significance not like", value, "clinicalSignificance");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceIn(List<String> values) {
            addCriterion("clinical_significance in", values, "clinicalSignificance");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceNotIn(List<String> values) {
            addCriterion("clinical_significance not in", values, "clinicalSignificance");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceBetween(String value1, String value2) {
            addCriterion("clinical_significance between", value1, value2, "clinicalSignificance");
            return (Criteria) this;
        }

        public Criteria andClinicalSignificanceNotBetween(String value1, String value2) {
            addCriterion("clinical_significance not between", value1, value2, "clinicalSignificance");
            return (Criteria) this;
        }

        public Criteria andLabGroupIsNull() {
            addCriterion("lab_group is null");
            return (Criteria) this;
        }

        public Criteria andLabGroupIsNotNull() {
            addCriterion("lab_group is not null");
            return (Criteria) this;
        }

        public Criteria andLabGroupEqualTo(String value) {
            addCriterion("lab_group =", value, "labGroup");
            return (Criteria) this;
        }

        public Criteria andLabGroupNotEqualTo(String value) {
            addCriterion("lab_group <>", value, "labGroup");
            return (Criteria) this;
        }

        public Criteria andLabGroupGreaterThan(String value) {
            addCriterion("lab_group >", value, "labGroup");
            return (Criteria) this;
        }

        public Criteria andLabGroupGreaterThanOrEqualTo(String value) {
            addCriterion("lab_group >=", value, "labGroup");
            return (Criteria) this;
        }

        public Criteria andLabGroupLessThan(String value) {
            addCriterion("lab_group <", value, "labGroup");
            return (Criteria) this;
        }

        public Criteria andLabGroupLessThanOrEqualTo(String value) {
            addCriterion("lab_group <=", value, "labGroup");
            return (Criteria) this;
        }

        public Criteria andLabGroupLike(String value) {
            addCriterion("lab_group like", value, "labGroup");
            return (Criteria) this;
        }

        public Criteria andLabGroupNotLike(String value) {
            addCriterion("lab_group not like", value, "labGroup");
            return (Criteria) this;
        }

        public Criteria andLabGroupIn(List<String> values) {
            addCriterion("lab_group in", values, "labGroup");
            return (Criteria) this;
        }

        public Criteria andLabGroupNotIn(List<String> values) {
            addCriterion("lab_group not in", values, "labGroup");
            return (Criteria) this;
        }

        public Criteria andLabGroupBetween(String value1, String value2) {
            addCriterion("lab_group between", value1, value2, "labGroup");
            return (Criteria) this;
        }

        public Criteria andLabGroupNotBetween(String value1, String value2) {
            addCriterion("lab_group not between", value1, value2, "labGroup");
            return (Criteria) this;
        }

        public Criteria andPriceCodeIsNull() {
            addCriterion("price_code is null");
            return (Criteria) this;
        }

        public Criteria andPriceCodeIsNotNull() {
            addCriterion("price_code is not null");
            return (Criteria) this;
        }

        public Criteria andPriceCodeEqualTo(String value) {
            addCriterion("price_code =", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeNotEqualTo(String value) {
            addCriterion("price_code <>", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeGreaterThan(String value) {
            addCriterion("price_code >", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("price_code >=", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeLessThan(String value) {
            addCriterion("price_code <", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeLessThanOrEqualTo(String value) {
            addCriterion("price_code <=", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeLike(String value) {
            addCriterion("price_code like", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeNotLike(String value) {
            addCriterion("price_code not like", value, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeIn(List<String> values) {
            addCriterion("price_code in", values, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeNotIn(List<String> values) {
            addCriterion("price_code not in", values, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeBetween(String value1, String value2) {
            addCriterion("price_code between", value1, value2, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPriceCodeNotBetween(String value1, String value2) {
            addCriterion("price_code not between", value1, value2, "priceCode");
            return (Criteria) this;
        }

        public Criteria andPdfNumIsNull() {
            addCriterion("pdf_num is null");
            return (Criteria) this;
        }

        public Criteria andPdfNumIsNotNull() {
            addCriterion("pdf_num is not null");
            return (Criteria) this;
        }

        public Criteria andPdfNumEqualTo(Integer value) {
            addCriterion("pdf_num =", value, "pdfNum");
            return (Criteria) this;
        }

        public Criteria andPdfNumNotEqualTo(Integer value) {
            addCriterion("pdf_num <>", value, "pdfNum");
            return (Criteria) this;
        }

        public Criteria andPdfNumGreaterThan(Integer value) {
            addCriterion("pdf_num >", value, "pdfNum");
            return (Criteria) this;
        }

        public Criteria andPdfNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pdf_num >=", value, "pdfNum");
            return (Criteria) this;
        }

        public Criteria andPdfNumLessThan(Integer value) {
            addCriterion("pdf_num <", value, "pdfNum");
            return (Criteria) this;
        }

        public Criteria andPdfNumLessThanOrEqualTo(Integer value) {
            addCriterion("pdf_num <=", value, "pdfNum");
            return (Criteria) this;
        }

        public Criteria andPdfNumIn(List<Integer> values) {
            addCriterion("pdf_num in", values, "pdfNum");
            return (Criteria) this;
        }

        public Criteria andPdfNumNotIn(List<Integer> values) {
            addCriterion("pdf_num not in", values, "pdfNum");
            return (Criteria) this;
        }

        public Criteria andPdfNumBetween(Integer value1, Integer value2) {
            addCriterion("pdf_num between", value1, value2, "pdfNum");
            return (Criteria) this;
        }

        public Criteria andPdfNumNotBetween(Integer value1, Integer value2) {
            addCriterion("pdf_num not between", value1, value2, "pdfNum");
            return (Criteria) this;
        }

        public Criteria andLogoFormIsNull() {
            addCriterion("logo_form is null");
            return (Criteria) this;
        }

        public Criteria andLogoFormIsNotNull() {
            addCriterion("logo_form is not null");
            return (Criteria) this;
        }

        public Criteria andLogoFormEqualTo(Integer value) {
            addCriterion("logo_form =", value, "logoForm");
            return (Criteria) this;
        }

        public Criteria andLogoFormNotEqualTo(Integer value) {
            addCriterion("logo_form <>", value, "logoForm");
            return (Criteria) this;
        }

        public Criteria andLogoFormGreaterThan(Integer value) {
            addCriterion("logo_form >", value, "logoForm");
            return (Criteria) this;
        }

        public Criteria andLogoFormGreaterThanOrEqualTo(Integer value) {
            addCriterion("logo_form >=", value, "logoForm");
            return (Criteria) this;
        }

        public Criteria andLogoFormLessThan(Integer value) {
            addCriterion("logo_form <", value, "logoForm");
            return (Criteria) this;
        }

        public Criteria andLogoFormLessThanOrEqualTo(Integer value) {
            addCriterion("logo_form <=", value, "logoForm");
            return (Criteria) this;
        }

        public Criteria andLogoFormIn(List<Integer> values) {
            addCriterion("logo_form in", values, "logoForm");
            return (Criteria) this;
        }

        public Criteria andLogoFormNotIn(List<Integer> values) {
            addCriterion("logo_form not in", values, "logoForm");
            return (Criteria) this;
        }

        public Criteria andLogoFormBetween(Integer value1, Integer value2) {
            addCriterion("logo_form between", value1, value2, "logoForm");
            return (Criteria) this;
        }

        public Criteria andLogoFormNotBetween(Integer value1, Integer value2) {
            addCriterion("logo_form not between", value1, value2, "logoForm");
            return (Criteria) this;
        }

        public Criteria andPackageTypeIsNull() {
            addCriterion("package_type is null");
            return (Criteria) this;
        }

        public Criteria andPackageTypeIsNotNull() {
            addCriterion("package_type is not null");
            return (Criteria) this;
        }

        public Criteria andPackageTypeEqualTo(Integer value) {
            addCriterion("package_type =", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeNotEqualTo(Integer value) {
            addCriterion("package_type <>", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeGreaterThan(Integer value) {
            addCriterion("package_type >", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_type >=", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeLessThan(Integer value) {
            addCriterion("package_type <", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeLessThanOrEqualTo(Integer value) {
            addCriterion("package_type <=", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeIn(List<Integer> values) {
            addCriterion("package_type in", values, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeNotIn(List<Integer> values) {
            addCriterion("package_type not in", values, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeBetween(Integer value1, Integer value2) {
            addCriterion("package_type between", value1, value2, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("package_type not between", value1, value2, "packageType");
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