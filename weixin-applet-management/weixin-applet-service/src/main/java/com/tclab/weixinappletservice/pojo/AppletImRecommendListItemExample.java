package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletImRecommendListItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletImRecommendListItemExample() {
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("item_id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("item_id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andPackageNoIsNull() {
            addCriterion("package_no is null");
            return (Criteria) this;
        }

        public Criteria andPackageNoIsNotNull() {
            addCriterion("package_no is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNoEqualTo(String value) {
            addCriterion("package_no =", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoNotEqualTo(String value) {
            addCriterion("package_no <>", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoGreaterThan(String value) {
            addCriterion("package_no >", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoGreaterThanOrEqualTo(String value) {
            addCriterion("package_no >=", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoLessThan(String value) {
            addCriterion("package_no <", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoLessThanOrEqualTo(String value) {
            addCriterion("package_no <=", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoLike(String value) {
            addCriterion("package_no like", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoNotLike(String value) {
            addCriterion("package_no not like", value, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoIn(List<String> values) {
            addCriterion("package_no in", values, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoNotIn(List<String> values) {
            addCriterion("package_no not in", values, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoBetween(String value1, String value2) {
            addCriterion("package_no between", value1, value2, "packageNo");
            return (Criteria) this;
        }

        public Criteria andPackageNoNotBetween(String value1, String value2) {
            addCriterion("package_no not between", value1, value2, "packageNo");
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

        public Criteria andUserConfirmStatusIsNull() {
            addCriterion("user_confirm_status is null");
            return (Criteria) this;
        }

        public Criteria andUserConfirmStatusIsNotNull() {
            addCriterion("user_confirm_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserConfirmStatusEqualTo(Integer value) {
            addCriterion("user_confirm_status =", value, "userConfirmStatus");
            return (Criteria) this;
        }

        public Criteria andUserConfirmStatusNotEqualTo(Integer value) {
            addCriterion("user_confirm_status <>", value, "userConfirmStatus");
            return (Criteria) this;
        }

        public Criteria andUserConfirmStatusGreaterThan(Integer value) {
            addCriterion("user_confirm_status >", value, "userConfirmStatus");
            return (Criteria) this;
        }

        public Criteria andUserConfirmStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_confirm_status >=", value, "userConfirmStatus");
            return (Criteria) this;
        }

        public Criteria andUserConfirmStatusLessThan(Integer value) {
            addCriterion("user_confirm_status <", value, "userConfirmStatus");
            return (Criteria) this;
        }

        public Criteria andUserConfirmStatusLessThanOrEqualTo(Integer value) {
            addCriterion("user_confirm_status <=", value, "userConfirmStatus");
            return (Criteria) this;
        }

        public Criteria andUserConfirmStatusIn(List<Integer> values) {
            addCriterion("user_confirm_status in", values, "userConfirmStatus");
            return (Criteria) this;
        }

        public Criteria andUserConfirmStatusNotIn(List<Integer> values) {
            addCriterion("user_confirm_status not in", values, "userConfirmStatus");
            return (Criteria) this;
        }

        public Criteria andUserConfirmStatusBetween(Integer value1, Integer value2) {
            addCriterion("user_confirm_status between", value1, value2, "userConfirmStatus");
            return (Criteria) this;
        }

        public Criteria andUserConfirmStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("user_confirm_status not between", value1, value2, "userConfirmStatus");
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