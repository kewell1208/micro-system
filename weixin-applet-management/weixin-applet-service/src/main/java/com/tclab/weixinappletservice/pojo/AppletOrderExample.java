package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletOrderExample() {
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
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

        public Criteria andMerchantIdIsNull() {
            addCriterion("merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(String value) {
            addCriterion("merchant_id =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(String value) {
            addCriterion("merchant_id <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(String value) {
            addCriterion("merchant_id >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_id >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(String value) {
            addCriterion("merchant_id <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("merchant_id <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLike(String value) {
            addCriterion("merchant_id like", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotLike(String value) {
            addCriterion("merchant_id not like", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<String> values) {
            addCriterion("merchant_id in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<String> values) {
            addCriterion("merchant_id not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(String value1, String value2) {
            addCriterion("merchant_id between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(String value1, String value2) {
            addCriterion("merchant_id not between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
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

        public Criteria andGoodNameIsNull() {
            addCriterion("good_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNotNull() {
            addCriterion("good_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodNameEqualTo(String value) {
            addCriterion("good_name =", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotEqualTo(String value) {
            addCriterion("good_name <>", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThan(String value) {
            addCriterion("good_name >", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("good_name >=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThan(String value) {
            addCriterion("good_name <", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThanOrEqualTo(String value) {
            addCriterion("good_name <=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLike(String value) {
            addCriterion("good_name like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotLike(String value) {
            addCriterion("good_name not like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameIn(List<String> values) {
            addCriterion("good_name in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotIn(List<String> values) {
            addCriterion("good_name not in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameBetween(String value1, String value2) {
            addCriterion("good_name between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotBetween(String value1, String value2) {
            addCriterion("good_name not between", value1, value2, "goodName");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserIdCardIsNull() {
            addCriterion("user_id_card is null");
            return (Criteria) this;
        }

        public Criteria andUserIdCardIsNotNull() {
            addCriterion("user_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdCardEqualTo(String value) {
            addCriterion("user_id_card =", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardNotEqualTo(String value) {
            addCriterion("user_id_card <>", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardGreaterThan(String value) {
            addCriterion("user_id_card >", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("user_id_card >=", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardLessThan(String value) {
            addCriterion("user_id_card <", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardLessThanOrEqualTo(String value) {
            addCriterion("user_id_card <=", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardLike(String value) {
            addCriterion("user_id_card like", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardNotLike(String value) {
            addCriterion("user_id_card not like", value, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardIn(List<String> values) {
            addCriterion("user_id_card in", values, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardNotIn(List<String> values) {
            addCriterion("user_id_card not in", values, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardBetween(String value1, String value2) {
            addCriterion("user_id_card between", value1, value2, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andUserIdCardNotBetween(String value1, String value2) {
            addCriterion("user_id_card not between", value1, value2, "userIdCard");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdIsNull() {
            addCriterion("service_info_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdIsNotNull() {
            addCriterion("service_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdEqualTo(String value) {
            addCriterion("service_info_id =", value, "serviceInfoId");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdNotEqualTo(String value) {
            addCriterion("service_info_id <>", value, "serviceInfoId");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdGreaterThan(String value) {
            addCriterion("service_info_id >", value, "serviceInfoId");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("service_info_id >=", value, "serviceInfoId");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdLessThan(String value) {
            addCriterion("service_info_id <", value, "serviceInfoId");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdLessThanOrEqualTo(String value) {
            addCriterion("service_info_id <=", value, "serviceInfoId");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdLike(String value) {
            addCriterion("service_info_id like", value, "serviceInfoId");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdNotLike(String value) {
            addCriterion("service_info_id not like", value, "serviceInfoId");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdIn(List<String> values) {
            addCriterion("service_info_id in", values, "serviceInfoId");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdNotIn(List<String> values) {
            addCriterion("service_info_id not in", values, "serviceInfoId");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdBetween(String value1, String value2) {
            addCriterion("service_info_id between", value1, value2, "serviceInfoId");
            return (Criteria) this;
        }

        public Criteria andServiceInfoIdNotBetween(String value1, String value2) {
            addCriterion("service_info_id not between", value1, value2, "serviceInfoId");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressIsNull() {
            addCriterion("service_info_address is null");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressIsNotNull() {
            addCriterion("service_info_address is not null");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressEqualTo(String value) {
            addCriterion("service_info_address =", value, "serviceInfoAddress");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressNotEqualTo(String value) {
            addCriterion("service_info_address <>", value, "serviceInfoAddress");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressGreaterThan(String value) {
            addCriterion("service_info_address >", value, "serviceInfoAddress");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressGreaterThanOrEqualTo(String value) {
            addCriterion("service_info_address >=", value, "serviceInfoAddress");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressLessThan(String value) {
            addCriterion("service_info_address <", value, "serviceInfoAddress");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressLessThanOrEqualTo(String value) {
            addCriterion("service_info_address <=", value, "serviceInfoAddress");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressLike(String value) {
            addCriterion("service_info_address like", value, "serviceInfoAddress");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressNotLike(String value) {
            addCriterion("service_info_address not like", value, "serviceInfoAddress");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressIn(List<String> values) {
            addCriterion("service_info_address in", values, "serviceInfoAddress");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressNotIn(List<String> values) {
            addCriterion("service_info_address not in", values, "serviceInfoAddress");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressBetween(String value1, String value2) {
            addCriterion("service_info_address between", value1, value2, "serviceInfoAddress");
            return (Criteria) this;
        }

        public Criteria andServiceInfoAddressNotBetween(String value1, String value2) {
            addCriterion("service_info_address not between", value1, value2, "serviceInfoAddress");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonIsNull() {
            addCriterion("service_info_person is null");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonIsNotNull() {
            addCriterion("service_info_person is not null");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonEqualTo(String value) {
            addCriterion("service_info_person =", value, "serviceInfoPerson");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonNotEqualTo(String value) {
            addCriterion("service_info_person <>", value, "serviceInfoPerson");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonGreaterThan(String value) {
            addCriterion("service_info_person >", value, "serviceInfoPerson");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonGreaterThanOrEqualTo(String value) {
            addCriterion("service_info_person >=", value, "serviceInfoPerson");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonLessThan(String value) {
            addCriterion("service_info_person <", value, "serviceInfoPerson");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonLessThanOrEqualTo(String value) {
            addCriterion("service_info_person <=", value, "serviceInfoPerson");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonLike(String value) {
            addCriterion("service_info_person like", value, "serviceInfoPerson");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonNotLike(String value) {
            addCriterion("service_info_person not like", value, "serviceInfoPerson");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonIn(List<String> values) {
            addCriterion("service_info_person in", values, "serviceInfoPerson");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonNotIn(List<String> values) {
            addCriterion("service_info_person not in", values, "serviceInfoPerson");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonBetween(String value1, String value2) {
            addCriterion("service_info_person between", value1, value2, "serviceInfoPerson");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPersonNotBetween(String value1, String value2) {
            addCriterion("service_info_person not between", value1, value2, "serviceInfoPerson");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneIsNull() {
            addCriterion("service_info_phone is null");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneIsNotNull() {
            addCriterion("service_info_phone is not null");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneEqualTo(String value) {
            addCriterion("service_info_phone =", value, "serviceInfoPhone");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneNotEqualTo(String value) {
            addCriterion("service_info_phone <>", value, "serviceInfoPhone");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneGreaterThan(String value) {
            addCriterion("service_info_phone >", value, "serviceInfoPhone");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("service_info_phone >=", value, "serviceInfoPhone");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneLessThan(String value) {
            addCriterion("service_info_phone <", value, "serviceInfoPhone");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneLessThanOrEqualTo(String value) {
            addCriterion("service_info_phone <=", value, "serviceInfoPhone");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneLike(String value) {
            addCriterion("service_info_phone like", value, "serviceInfoPhone");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneNotLike(String value) {
            addCriterion("service_info_phone not like", value, "serviceInfoPhone");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneIn(List<String> values) {
            addCriterion("service_info_phone in", values, "serviceInfoPhone");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneNotIn(List<String> values) {
            addCriterion("service_info_phone not in", values, "serviceInfoPhone");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneBetween(String value1, String value2) {
            addCriterion("service_info_phone between", value1, value2, "serviceInfoPhone");
            return (Criteria) this;
        }

        public Criteria andServiceInfoPhoneNotBetween(String value1, String value2) {
            addCriterion("service_info_phone not between", value1, value2, "serviceInfoPhone");
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

        public Criteria andOrderApplyDateIsNull() {
            addCriterion("order_apply_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderApplyDateIsNotNull() {
            addCriterion("order_apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderApplyDateEqualTo(Date value) {
            addCriterion("order_apply_date =", value, "orderApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderApplyDateNotEqualTo(Date value) {
            addCriterion("order_apply_date <>", value, "orderApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderApplyDateGreaterThan(Date value) {
            addCriterion("order_apply_date >", value, "orderApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("order_apply_date >=", value, "orderApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderApplyDateLessThan(Date value) {
            addCriterion("order_apply_date <", value, "orderApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("order_apply_date <=", value, "orderApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderApplyDateIn(List<Date> values) {
            addCriterion("order_apply_date in", values, "orderApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderApplyDateNotIn(List<Date> values) {
            addCriterion("order_apply_date not in", values, "orderApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderApplyDateBetween(Date value1, Date value2) {
            addCriterion("order_apply_date between", value1, value2, "orderApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("order_apply_date not between", value1, value2, "orderApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentApplyDateIsNull() {
            addCriterion("order_current_apply_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentApplyDateIsNotNull() {
            addCriterion("order_current_apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentApplyDateEqualTo(Date value) {
            addCriterion("order_current_apply_date =", value, "orderCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentApplyDateNotEqualTo(Date value) {
            addCriterion("order_current_apply_date <>", value, "orderCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentApplyDateGreaterThan(Date value) {
            addCriterion("order_current_apply_date >", value, "orderCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("order_current_apply_date >=", value, "orderCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentApplyDateLessThan(Date value) {
            addCriterion("order_current_apply_date <", value, "orderCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("order_current_apply_date <=", value, "orderCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentApplyDateIn(List<Date> values) {
            addCriterion("order_current_apply_date in", values, "orderCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentApplyDateNotIn(List<Date> values) {
            addCriterion("order_current_apply_date not in", values, "orderCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentApplyDateBetween(Date value1, Date value2) {
            addCriterion("order_current_apply_date between", value1, value2, "orderCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCurrentApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("order_current_apply_date not between", value1, value2, "orderCurrentApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCompleteApplyDateIsNull() {
            addCriterion("order_complete_apply_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderCompleteApplyDateIsNotNull() {
            addCriterion("order_complete_apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCompleteApplyDateEqualTo(Date value) {
            addCriterion("order_complete_apply_date =", value, "orderCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCompleteApplyDateNotEqualTo(Date value) {
            addCriterion("order_complete_apply_date <>", value, "orderCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCompleteApplyDateGreaterThan(Date value) {
            addCriterion("order_complete_apply_date >", value, "orderCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCompleteApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("order_complete_apply_date >=", value, "orderCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCompleteApplyDateLessThan(Date value) {
            addCriterion("order_complete_apply_date <", value, "orderCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCompleteApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("order_complete_apply_date <=", value, "orderCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCompleteApplyDateIn(List<Date> values) {
            addCriterion("order_complete_apply_date in", values, "orderCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCompleteApplyDateNotIn(List<Date> values) {
            addCriterion("order_complete_apply_date not in", values, "orderCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCompleteApplyDateBetween(Date value1, Date value2) {
            addCriterion("order_complete_apply_date between", value1, value2, "orderCompleteApplyDate");
            return (Criteria) this;
        }

        public Criteria andOrderCompleteApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("order_complete_apply_date not between", value1, value2, "orderCompleteApplyDate");
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

        public Criteria andDiscountTypeIsNull() {
            addCriterion("discount_type is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIsNotNull() {
            addCriterion("discount_type is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeEqualTo(Integer value) {
            addCriterion("discount_type =", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotEqualTo(Integer value) {
            addCriterion("discount_type <>", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeGreaterThan(Integer value) {
            addCriterion("discount_type >", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("discount_type >=", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLessThan(Integer value) {
            addCriterion("discount_type <", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("discount_type <=", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIn(List<Integer> values) {
            addCriterion("discount_type in", values, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotIn(List<Integer> values) {
            addCriterion("discount_type not in", values, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeBetween(Integer value1, Integer value2) {
            addCriterion("discount_type between", value1, value2, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("discount_type not between", value1, value2, "discountType");
            return (Criteria) this;
        }

        public Criteria andPromotionIdIsNull() {
            addCriterion("promotion_id is null");
            return (Criteria) this;
        }

        public Criteria andPromotionIdIsNotNull() {
            addCriterion("promotion_id is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionIdEqualTo(String value) {
            addCriterion("promotion_id =", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdNotEqualTo(String value) {
            addCriterion("promotion_id <>", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdGreaterThan(String value) {
            addCriterion("promotion_id >", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_id >=", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdLessThan(String value) {
            addCriterion("promotion_id <", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdLessThanOrEqualTo(String value) {
            addCriterion("promotion_id <=", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdLike(String value) {
            addCriterion("promotion_id like", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdNotLike(String value) {
            addCriterion("promotion_id not like", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdIn(List<String> values) {
            addCriterion("promotion_id in", values, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdNotIn(List<String> values) {
            addCriterion("promotion_id not in", values, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdBetween(String value1, String value2) {
            addCriterion("promotion_id between", value1, value2, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdNotBetween(String value1, String value2) {
            addCriterion("promotion_id not between", value1, value2, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionNameIsNull() {
            addCriterion("promotion_name is null");
            return (Criteria) this;
        }

        public Criteria andPromotionNameIsNotNull() {
            addCriterion("promotion_name is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionNameEqualTo(String value) {
            addCriterion("promotion_name =", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameNotEqualTo(String value) {
            addCriterion("promotion_name <>", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameGreaterThan(String value) {
            addCriterion("promotion_name >", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_name >=", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameLessThan(String value) {
            addCriterion("promotion_name <", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameLessThanOrEqualTo(String value) {
            addCriterion("promotion_name <=", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameLike(String value) {
            addCriterion("promotion_name like", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameNotLike(String value) {
            addCriterion("promotion_name not like", value, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameIn(List<String> values) {
            addCriterion("promotion_name in", values, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameNotIn(List<String> values) {
            addCriterion("promotion_name not in", values, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameBetween(String value1, String value2) {
            addCriterion("promotion_name between", value1, value2, "promotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionNameNotBetween(String value1, String value2) {
            addCriterion("promotion_name not between", value1, value2, "promotionName");
            return (Criteria) this;
        }

        public Criteria andDiscountIdIsNull() {
            addCriterion("discount_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIdIsNotNull() {
            addCriterion("discount_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountIdEqualTo(String value) {
            addCriterion("discount_id =", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotEqualTo(String value) {
            addCriterion("discount_id <>", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdGreaterThan(String value) {
            addCriterion("discount_id >", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdGreaterThanOrEqualTo(String value) {
            addCriterion("discount_id >=", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdLessThan(String value) {
            addCriterion("discount_id <", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdLessThanOrEqualTo(String value) {
            addCriterion("discount_id <=", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdLike(String value) {
            addCriterion("discount_id like", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotLike(String value) {
            addCriterion("discount_id not like", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdIn(List<String> values) {
            addCriterion("discount_id in", values, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotIn(List<String> values) {
            addCriterion("discount_id not in", values, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdBetween(String value1, String value2) {
            addCriterion("discount_id between", value1, value2, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotBetween(String value1, String value2) {
            addCriterion("discount_id not between", value1, value2, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountNameIsNull() {
            addCriterion("discount_name is null");
            return (Criteria) this;
        }

        public Criteria andDiscountNameIsNotNull() {
            addCriterion("discount_name is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountNameEqualTo(String value) {
            addCriterion("discount_name =", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameNotEqualTo(String value) {
            addCriterion("discount_name <>", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameGreaterThan(String value) {
            addCriterion("discount_name >", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameGreaterThanOrEqualTo(String value) {
            addCriterion("discount_name >=", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameLessThan(String value) {
            addCriterion("discount_name <", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameLessThanOrEqualTo(String value) {
            addCriterion("discount_name <=", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameLike(String value) {
            addCriterion("discount_name like", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameNotLike(String value) {
            addCriterion("discount_name not like", value, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameIn(List<String> values) {
            addCriterion("discount_name in", values, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameNotIn(List<String> values) {
            addCriterion("discount_name not in", values, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameBetween(String value1, String value2) {
            addCriterion("discount_name between", value1, value2, "discountName");
            return (Criteria) this;
        }

        public Criteria andDiscountNameNotBetween(String value1, String value2) {
            addCriterion("discount_name not between", value1, value2, "discountName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIsNull() {
            addCriterion("verify_status is null");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIsNotNull() {
            addCriterion("verify_status is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusEqualTo(Integer value) {
            addCriterion("verify_status =", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotEqualTo(Integer value) {
            addCriterion("verify_status <>", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusGreaterThan(Integer value) {
            addCriterion("verify_status >", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("verify_status >=", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLessThan(Integer value) {
            addCriterion("verify_status <", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("verify_status <=", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIn(List<Integer> values) {
            addCriterion("verify_status in", values, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotIn(List<Integer> values) {
            addCriterion("verify_status not in", values, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusBetween(Integer value1, Integer value2) {
            addCriterion("verify_status between", value1, value2, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("verify_status not between", value1, value2, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyDateIsNull() {
            addCriterion("verify_date is null");
            return (Criteria) this;
        }

        public Criteria andVerifyDateIsNotNull() {
            addCriterion("verify_date is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyDateEqualTo(Date value) {
            addCriterion("verify_date =", value, "verifyDate");
            return (Criteria) this;
        }

        public Criteria andVerifyDateNotEqualTo(Date value) {
            addCriterion("verify_date <>", value, "verifyDate");
            return (Criteria) this;
        }

        public Criteria andVerifyDateGreaterThan(Date value) {
            addCriterion("verify_date >", value, "verifyDate");
            return (Criteria) this;
        }

        public Criteria andVerifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("verify_date >=", value, "verifyDate");
            return (Criteria) this;
        }

        public Criteria andVerifyDateLessThan(Date value) {
            addCriterion("verify_date <", value, "verifyDate");
            return (Criteria) this;
        }

        public Criteria andVerifyDateLessThanOrEqualTo(Date value) {
            addCriterion("verify_date <=", value, "verifyDate");
            return (Criteria) this;
        }

        public Criteria andVerifyDateIn(List<Date> values) {
            addCriterion("verify_date in", values, "verifyDate");
            return (Criteria) this;
        }

        public Criteria andVerifyDateNotIn(List<Date> values) {
            addCriterion("verify_date not in", values, "verifyDate");
            return (Criteria) this;
        }

        public Criteria andVerifyDateBetween(Date value1, Date value2) {
            addCriterion("verify_date between", value1, value2, "verifyDate");
            return (Criteria) this;
        }

        public Criteria andVerifyDateNotBetween(Date value1, Date value2) {
            addCriterion("verify_date not between", value1, value2, "verifyDate");
            return (Criteria) this;
        }

        public Criteria andAuditorIdIsNull() {
            addCriterion("auditor_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIdIsNotNull() {
            addCriterion("auditor_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorIdEqualTo(String value) {
            addCriterion("auditor_id =", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdNotEqualTo(String value) {
            addCriterion("auditor_id <>", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdGreaterThan(String value) {
            addCriterion("auditor_id >", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdGreaterThanOrEqualTo(String value) {
            addCriterion("auditor_id >=", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdLessThan(String value) {
            addCriterion("auditor_id <", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdLessThanOrEqualTo(String value) {
            addCriterion("auditor_id <=", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdLike(String value) {
            addCriterion("auditor_id like", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdNotLike(String value) {
            addCriterion("auditor_id not like", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdIn(List<String> values) {
            addCriterion("auditor_id in", values, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdNotIn(List<String> values) {
            addCriterion("auditor_id not in", values, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdBetween(String value1, String value2) {
            addCriterion("auditor_id between", value1, value2, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdNotBetween(String value1, String value2) {
            addCriterion("auditor_id not between", value1, value2, "auditorId");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPreNoIsNull() {
            addCriterion("pre_no is null");
            return (Criteria) this;
        }

        public Criteria andPreNoIsNotNull() {
            addCriterion("pre_no is not null");
            return (Criteria) this;
        }

        public Criteria andPreNoEqualTo(String value) {
            addCriterion("pre_no =", value, "preNo");
            return (Criteria) this;
        }

        public Criteria andPreNoNotEqualTo(String value) {
            addCriterion("pre_no <>", value, "preNo");
            return (Criteria) this;
        }

        public Criteria andPreNoGreaterThan(String value) {
            addCriterion("pre_no >", value, "preNo");
            return (Criteria) this;
        }

        public Criteria andPreNoGreaterThanOrEqualTo(String value) {
            addCriterion("pre_no >=", value, "preNo");
            return (Criteria) this;
        }

        public Criteria andPreNoLessThan(String value) {
            addCriterion("pre_no <", value, "preNo");
            return (Criteria) this;
        }

        public Criteria andPreNoLessThanOrEqualTo(String value) {
            addCriterion("pre_no <=", value, "preNo");
            return (Criteria) this;
        }

        public Criteria andPreNoLike(String value) {
            addCriterion("pre_no like", value, "preNo");
            return (Criteria) this;
        }

        public Criteria andPreNoNotLike(String value) {
            addCriterion("pre_no not like", value, "preNo");
            return (Criteria) this;
        }

        public Criteria andPreNoIn(List<String> values) {
            addCriterion("pre_no in", values, "preNo");
            return (Criteria) this;
        }

        public Criteria andPreNoNotIn(List<String> values) {
            addCriterion("pre_no not in", values, "preNo");
            return (Criteria) this;
        }

        public Criteria andPreNoBetween(String value1, String value2) {
            addCriterion("pre_no between", value1, value2, "preNo");
            return (Criteria) this;
        }

        public Criteria andPreNoNotBetween(String value1, String value2) {
            addCriterion("pre_no not between", value1, value2, "preNo");
            return (Criteria) this;
        }

        public Criteria andPayNoIsNull() {
            addCriterion("pay_no is null");
            return (Criteria) this;
        }

        public Criteria andPayNoIsNotNull() {
            addCriterion("pay_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayNoEqualTo(String value) {
            addCriterion("pay_no =", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotEqualTo(String value) {
            addCriterion("pay_no <>", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoGreaterThan(String value) {
            addCriterion("pay_no >", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoGreaterThanOrEqualTo(String value) {
            addCriterion("pay_no >=", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLessThan(String value) {
            addCriterion("pay_no <", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLessThanOrEqualTo(String value) {
            addCriterion("pay_no <=", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLike(String value) {
            addCriterion("pay_no like", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotLike(String value) {
            addCriterion("pay_no not like", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoIn(List<String> values) {
            addCriterion("pay_no in", values, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotIn(List<String> values) {
            addCriterion("pay_no not in", values, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoBetween(String value1, String value2) {
            addCriterion("pay_no between", value1, value2, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotBetween(String value1, String value2) {
            addCriterion("pay_no not between", value1, value2, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNull() {
            addCriterion("pay_date is null");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNotNull() {
            addCriterion("pay_date is not null");
            return (Criteria) this;
        }

        public Criteria andPayDateEqualTo(Date value) {
            addCriterion("pay_date =", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotEqualTo(Date value) {
            addCriterion("pay_date <>", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThan(Date value) {
            addCriterion("pay_date >", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_date >=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThan(Date value) {
            addCriterion("pay_date <", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThanOrEqualTo(Date value) {
            addCriterion("pay_date <=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateIn(List<Date> values) {
            addCriterion("pay_date in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotIn(List<Date> values) {
            addCriterion("pay_date not in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateBetween(Date value1, Date value2) {
            addCriterion("pay_date between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotBetween(Date value1, Date value2) {
            addCriterion("pay_date not between", value1, value2, "payDate");
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

        public Criteria andRefundAmountIsNull() {
            addCriterion("refund_amount is null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNotNull() {
            addCriterion("refund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountEqualTo(BigDecimal value) {
            addCriterion("refund_amount =", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotEqualTo(BigDecimal value) {
            addCriterion("refund_amount <>", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThan(BigDecimal value) {
            addCriterion("refund_amount >", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_amount >=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThan(BigDecimal value) {
            addCriterion("refund_amount <", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_amount <=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIn(List<BigDecimal> values) {
            addCriterion("refund_amount in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotIn(List<BigDecimal> values) {
            addCriterion("refund_amount not in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_amount between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_amount not between", value1, value2, "refundAmount");
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

        public Criteria andLogisticsStatusIsNull() {
            addCriterion("logistics_status is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusIsNotNull() {
            addCriterion("logistics_status is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusEqualTo(Integer value) {
            addCriterion("logistics_status =", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusNotEqualTo(Integer value) {
            addCriterion("logistics_status <>", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusGreaterThan(Integer value) {
            addCriterion("logistics_status >", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("logistics_status >=", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusLessThan(Integer value) {
            addCriterion("logistics_status <", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusLessThanOrEqualTo(Integer value) {
            addCriterion("logistics_status <=", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusIn(List<Integer> values) {
            addCriterion("logistics_status in", values, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusNotIn(List<Integer> values) {
            addCriterion("logistics_status not in", values, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusBetween(Integer value1, Integer value2) {
            addCriterion("logistics_status between", value1, value2, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("logistics_status not between", value1, value2, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeIsNull() {
            addCriterion("logistics_type is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeIsNotNull() {
            addCriterion("logistics_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeEqualTo(Integer value) {
            addCriterion("logistics_type =", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeNotEqualTo(Integer value) {
            addCriterion("logistics_type <>", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeGreaterThan(Integer value) {
            addCriterion("logistics_type >", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("logistics_type >=", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeLessThan(Integer value) {
            addCriterion("logistics_type <", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeLessThanOrEqualTo(Integer value) {
            addCriterion("logistics_type <=", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeIn(List<Integer> values) {
            addCriterion("logistics_type in", values, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeNotIn(List<Integer> values) {
            addCriterion("logistics_type not in", values, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeBetween(Integer value1, Integer value2) {
            addCriterion("logistics_type between", value1, value2, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("logistics_type not between", value1, value2, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIsNull() {
            addCriterion("logistics_id is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIsNotNull() {
            addCriterion("logistics_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdEqualTo(String value) {
            addCriterion("logistics_id =", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotEqualTo(String value) {
            addCriterion("logistics_id <>", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThan(String value) {
            addCriterion("logistics_id >", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_id >=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThan(String value) {
            addCriterion("logistics_id <", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThanOrEqualTo(String value) {
            addCriterion("logistics_id <=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLike(String value) {
            addCriterion("logistics_id like", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotLike(String value) {
            addCriterion("logistics_id not like", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIn(List<String> values) {
            addCriterion("logistics_id in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotIn(List<String> values) {
            addCriterion("logistics_id not in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdBetween(String value1, String value2) {
            addCriterion("logistics_id between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotBetween(String value1, String value2) {
            addCriterion("logistics_id not between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andWriteOffStatusIsNull() {
            addCriterion("write_off_status is null");
            return (Criteria) this;
        }

        public Criteria andWriteOffStatusIsNotNull() {
            addCriterion("write_off_status is not null");
            return (Criteria) this;
        }

        public Criteria andWriteOffStatusEqualTo(Integer value) {
            addCriterion("write_off_status =", value, "writeOffStatus");
            return (Criteria) this;
        }

        public Criteria andWriteOffStatusNotEqualTo(Integer value) {
            addCriterion("write_off_status <>", value, "writeOffStatus");
            return (Criteria) this;
        }

        public Criteria andWriteOffStatusGreaterThan(Integer value) {
            addCriterion("write_off_status >", value, "writeOffStatus");
            return (Criteria) this;
        }

        public Criteria andWriteOffStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("write_off_status >=", value, "writeOffStatus");
            return (Criteria) this;
        }

        public Criteria andWriteOffStatusLessThan(Integer value) {
            addCriterion("write_off_status <", value, "writeOffStatus");
            return (Criteria) this;
        }

        public Criteria andWriteOffStatusLessThanOrEqualTo(Integer value) {
            addCriterion("write_off_status <=", value, "writeOffStatus");
            return (Criteria) this;
        }

        public Criteria andWriteOffStatusIn(List<Integer> values) {
            addCriterion("write_off_status in", values, "writeOffStatus");
            return (Criteria) this;
        }

        public Criteria andWriteOffStatusNotIn(List<Integer> values) {
            addCriterion("write_off_status not in", values, "writeOffStatus");
            return (Criteria) this;
        }

        public Criteria andWriteOffStatusBetween(Integer value1, Integer value2) {
            addCriterion("write_off_status between", value1, value2, "writeOffStatus");
            return (Criteria) this;
        }

        public Criteria andWriteOffStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("write_off_status not between", value1, value2, "writeOffStatus");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeIsNull() {
            addCriterion("write_off_code is null");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeIsNotNull() {
            addCriterion("write_off_code is not null");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeEqualTo(String value) {
            addCriterion("write_off_code =", value, "writeOffCode");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeNotEqualTo(String value) {
            addCriterion("write_off_code <>", value, "writeOffCode");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeGreaterThan(String value) {
            addCriterion("write_off_code >", value, "writeOffCode");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeGreaterThanOrEqualTo(String value) {
            addCriterion("write_off_code >=", value, "writeOffCode");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeLessThan(String value) {
            addCriterion("write_off_code <", value, "writeOffCode");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeLessThanOrEqualTo(String value) {
            addCriterion("write_off_code <=", value, "writeOffCode");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeLike(String value) {
            addCriterion("write_off_code like", value, "writeOffCode");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeNotLike(String value) {
            addCriterion("write_off_code not like", value, "writeOffCode");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeIn(List<String> values) {
            addCriterion("write_off_code in", values, "writeOffCode");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeNotIn(List<String> values) {
            addCriterion("write_off_code not in", values, "writeOffCode");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeBetween(String value1, String value2) {
            addCriterion("write_off_code between", value1, value2, "writeOffCode");
            return (Criteria) this;
        }

        public Criteria andWriteOffCodeNotBetween(String value1, String value2) {
            addCriterion("write_off_code not between", value1, value2, "writeOffCode");
            return (Criteria) this;
        }

        public Criteria andWriteOffDateIsNull() {
            addCriterion("write_off_date is null");
            return (Criteria) this;
        }

        public Criteria andWriteOffDateIsNotNull() {
            addCriterion("write_off_date is not null");
            return (Criteria) this;
        }

        public Criteria andWriteOffDateEqualTo(Date value) {
            addCriterion("write_off_date =", value, "writeOffDate");
            return (Criteria) this;
        }

        public Criteria andWriteOffDateNotEqualTo(Date value) {
            addCriterion("write_off_date <>", value, "writeOffDate");
            return (Criteria) this;
        }

        public Criteria andWriteOffDateGreaterThan(Date value) {
            addCriterion("write_off_date >", value, "writeOffDate");
            return (Criteria) this;
        }

        public Criteria andWriteOffDateGreaterThanOrEqualTo(Date value) {
            addCriterion("write_off_date >=", value, "writeOffDate");
            return (Criteria) this;
        }

        public Criteria andWriteOffDateLessThan(Date value) {
            addCriterion("write_off_date <", value, "writeOffDate");
            return (Criteria) this;
        }

        public Criteria andWriteOffDateLessThanOrEqualTo(Date value) {
            addCriterion("write_off_date <=", value, "writeOffDate");
            return (Criteria) this;
        }

        public Criteria andWriteOffDateIn(List<Date> values) {
            addCriterion("write_off_date in", values, "writeOffDate");
            return (Criteria) this;
        }

        public Criteria andWriteOffDateNotIn(List<Date> values) {
            addCriterion("write_off_date not in", values, "writeOffDate");
            return (Criteria) this;
        }

        public Criteria andWriteOffDateBetween(Date value1, Date value2) {
            addCriterion("write_off_date between", value1, value2, "writeOffDate");
            return (Criteria) this;
        }

        public Criteria andWriteOffDateNotBetween(Date value1, Date value2) {
            addCriterion("write_off_date not between", value1, value2, "writeOffDate");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountIsNull() {
            addCriterion("cost_department_commission_amount is null");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountIsNotNull() {
            addCriterion("cost_department_commission_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountEqualTo(String value) {
            addCriterion("cost_department_commission_amount =", value, "costDepartmentCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountNotEqualTo(String value) {
            addCriterion("cost_department_commission_amount <>", value, "costDepartmentCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountGreaterThan(String value) {
            addCriterion("cost_department_commission_amount >", value, "costDepartmentCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountGreaterThanOrEqualTo(String value) {
            addCriterion("cost_department_commission_amount >=", value, "costDepartmentCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountLessThan(String value) {
            addCriterion("cost_department_commission_amount <", value, "costDepartmentCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountLessThanOrEqualTo(String value) {
            addCriterion("cost_department_commission_amount <=", value, "costDepartmentCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountLike(String value) {
            addCriterion("cost_department_commission_amount like", value, "costDepartmentCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountNotLike(String value) {
            addCriterion("cost_department_commission_amount not like", value, "costDepartmentCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountIn(List<String> values) {
            addCriterion("cost_department_commission_amount in", values, "costDepartmentCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountNotIn(List<String> values) {
            addCriterion("cost_department_commission_amount not in", values, "costDepartmentCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountBetween(String value1, String value2) {
            addCriterion("cost_department_commission_amount between", value1, value2, "costDepartmentCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionAmountNotBetween(String value1, String value2) {
            addCriterion("cost_department_commission_amount not between", value1, value2, "costDepartmentCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionAmountIsNull() {
            addCriterion("cost_organization_commission_amount is null");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionAmountIsNotNull() {
            addCriterion("cost_organization_commission_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionAmountEqualTo(BigDecimal value) {
            addCriterion("cost_organization_commission_amount =", value, "costOrganizationCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionAmountNotEqualTo(BigDecimal value) {
            addCriterion("cost_organization_commission_amount <>", value, "costOrganizationCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionAmountGreaterThan(BigDecimal value) {
            addCriterion("cost_organization_commission_amount >", value, "costOrganizationCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_organization_commission_amount >=", value, "costOrganizationCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionAmountLessThan(BigDecimal value) {
            addCriterion("cost_organization_commission_amount <", value, "costOrganizationCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_organization_commission_amount <=", value, "costOrganizationCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionAmountIn(List<BigDecimal> values) {
            addCriterion("cost_organization_commission_amount in", values, "costOrganizationCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionAmountNotIn(List<BigDecimal> values) {
            addCriterion("cost_organization_commission_amount not in", values, "costOrganizationCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_organization_commission_amount between", value1, value2, "costOrganizationCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_organization_commission_amount not between", value1, value2, "costOrganizationCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountIsNull() {
            addCriterion("platform_commission_amount is null");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountIsNotNull() {
            addCriterion("platform_commission_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountEqualTo(BigDecimal value) {
            addCriterion("platform_commission_amount =", value, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountNotEqualTo(BigDecimal value) {
            addCriterion("platform_commission_amount <>", value, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountGreaterThan(BigDecimal value) {
            addCriterion("platform_commission_amount >", value, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_commission_amount >=", value, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountLessThan(BigDecimal value) {
            addCriterion("platform_commission_amount <", value, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_commission_amount <=", value, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountIn(List<BigDecimal> values) {
            addCriterion("platform_commission_amount in", values, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountNotIn(List<BigDecimal> values) {
            addCriterion("platform_commission_amount not in", values, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_commission_amount between", value1, value2, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_commission_amount not between", value1, value2, "platformCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNull() {
            addCriterion("order_remark is null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNotNull() {
            addCriterion("order_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkEqualTo(String value) {
            addCriterion("order_remark =", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotEqualTo(String value) {
            addCriterion("order_remark <>", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThan(String value) {
            addCriterion("order_remark >", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("order_remark >=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThan(String value) {
            addCriterion("order_remark <", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThanOrEqualTo(String value) {
            addCriterion("order_remark <=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLike(String value) {
            addCriterion("order_remark like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotLike(String value) {
            addCriterion("order_remark not like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIn(List<String> values) {
            addCriterion("order_remark in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotIn(List<String> values) {
            addCriterion("order_remark not in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkBetween(String value1, String value2) {
            addCriterion("order_remark between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotBetween(String value1, String value2) {
            addCriterion("order_remark not between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStatusIsNull() {
            addCriterion("order_exception_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStatusIsNotNull() {
            addCriterion("order_exception_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStatusEqualTo(Integer value) {
            addCriterion("order_exception_status =", value, "orderExceptionStatus");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStatusNotEqualTo(Integer value) {
            addCriterion("order_exception_status <>", value, "orderExceptionStatus");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStatusGreaterThan(Integer value) {
            addCriterion("order_exception_status >", value, "orderExceptionStatus");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_exception_status >=", value, "orderExceptionStatus");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStatusLessThan(Integer value) {
            addCriterion("order_exception_status <", value, "orderExceptionStatus");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_exception_status <=", value, "orderExceptionStatus");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStatusIn(List<Integer> values) {
            addCriterion("order_exception_status in", values, "orderExceptionStatus");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStatusNotIn(List<Integer> values) {
            addCriterion("order_exception_status not in", values, "orderExceptionStatus");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_exception_status between", value1, value2, "orderExceptionStatus");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_exception_status not between", value1, value2, "orderExceptionStatus");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionReasonIsNull() {
            addCriterion("order_exception_reason is null");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionReasonIsNotNull() {
            addCriterion("order_exception_reason is not null");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionReasonEqualTo(Integer value) {
            addCriterion("order_exception_reason =", value, "orderExceptionReason");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionReasonNotEqualTo(Integer value) {
            addCriterion("order_exception_reason <>", value, "orderExceptionReason");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionReasonGreaterThan(Integer value) {
            addCriterion("order_exception_reason >", value, "orderExceptionReason");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionReasonGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_exception_reason >=", value, "orderExceptionReason");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionReasonLessThan(Integer value) {
            addCriterion("order_exception_reason <", value, "orderExceptionReason");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionReasonLessThanOrEqualTo(Integer value) {
            addCriterion("order_exception_reason <=", value, "orderExceptionReason");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionReasonIn(List<Integer> values) {
            addCriterion("order_exception_reason in", values, "orderExceptionReason");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionReasonNotIn(List<Integer> values) {
            addCriterion("order_exception_reason not in", values, "orderExceptionReason");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionReasonBetween(Integer value1, Integer value2) {
            addCriterion("order_exception_reason between", value1, value2, "orderExceptionReason");
            return (Criteria) this;
        }

        public Criteria andOrderExceptionReasonNotBetween(Integer value1, Integer value2) {
            addCriterion("order_exception_reason not between", value1, value2, "orderExceptionReason");
            return (Criteria) this;
        }

        public Criteria andOrderCancelStatusIsNull() {
            addCriterion("order_cancel_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderCancelStatusIsNotNull() {
            addCriterion("order_cancel_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCancelStatusEqualTo(Integer value) {
            addCriterion("order_cancel_status =", value, "orderCancelStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCancelStatusNotEqualTo(Integer value) {
            addCriterion("order_cancel_status <>", value, "orderCancelStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCancelStatusGreaterThan(Integer value) {
            addCriterion("order_cancel_status >", value, "orderCancelStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCancelStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_cancel_status >=", value, "orderCancelStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCancelStatusLessThan(Integer value) {
            addCriterion("order_cancel_status <", value, "orderCancelStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCancelStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_cancel_status <=", value, "orderCancelStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCancelStatusIn(List<Integer> values) {
            addCriterion("order_cancel_status in", values, "orderCancelStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCancelStatusNotIn(List<Integer> values) {
            addCriterion("order_cancel_status not in", values, "orderCancelStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCancelStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_cancel_status between", value1, value2, "orderCancelStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCancelStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_cancel_status not between", value1, value2, "orderCancelStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTypeIsNull() {
            addCriterion("order_cancel_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTypeIsNotNull() {
            addCriterion("order_cancel_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTypeEqualTo(Integer value) {
            addCriterion("order_cancel_type =", value, "orderCancelType");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTypeNotEqualTo(Integer value) {
            addCriterion("order_cancel_type <>", value, "orderCancelType");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTypeGreaterThan(Integer value) {
            addCriterion("order_cancel_type >", value, "orderCancelType");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_cancel_type >=", value, "orderCancelType");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTypeLessThan(Integer value) {
            addCriterion("order_cancel_type <", value, "orderCancelType");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_cancel_type <=", value, "orderCancelType");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTypeIn(List<Integer> values) {
            addCriterion("order_cancel_type in", values, "orderCancelType");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTypeNotIn(List<Integer> values) {
            addCriterion("order_cancel_type not in", values, "orderCancelType");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_cancel_type between", value1, value2, "orderCancelType");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_cancel_type not between", value1, value2, "orderCancelType");
            return (Criteria) this;
        }

        public Criteria andOrderCancelReasonIsNull() {
            addCriterion("order_cancel_reason is null");
            return (Criteria) this;
        }

        public Criteria andOrderCancelReasonIsNotNull() {
            addCriterion("order_cancel_reason is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCancelReasonEqualTo(Integer value) {
            addCriterion("order_cancel_reason =", value, "orderCancelReason");
            return (Criteria) this;
        }

        public Criteria andOrderCancelReasonNotEqualTo(Integer value) {
            addCriterion("order_cancel_reason <>", value, "orderCancelReason");
            return (Criteria) this;
        }

        public Criteria andOrderCancelReasonGreaterThan(Integer value) {
            addCriterion("order_cancel_reason >", value, "orderCancelReason");
            return (Criteria) this;
        }

        public Criteria andOrderCancelReasonGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_cancel_reason >=", value, "orderCancelReason");
            return (Criteria) this;
        }

        public Criteria andOrderCancelReasonLessThan(Integer value) {
            addCriterion("order_cancel_reason <", value, "orderCancelReason");
            return (Criteria) this;
        }

        public Criteria andOrderCancelReasonLessThanOrEqualTo(Integer value) {
            addCriterion("order_cancel_reason <=", value, "orderCancelReason");
            return (Criteria) this;
        }

        public Criteria andOrderCancelReasonIn(List<Integer> values) {
            addCriterion("order_cancel_reason in", values, "orderCancelReason");
            return (Criteria) this;
        }

        public Criteria andOrderCancelReasonNotIn(List<Integer> values) {
            addCriterion("order_cancel_reason not in", values, "orderCancelReason");
            return (Criteria) this;
        }

        public Criteria andOrderCancelReasonBetween(Integer value1, Integer value2) {
            addCriterion("order_cancel_reason between", value1, value2, "orderCancelReason");
            return (Criteria) this;
        }

        public Criteria andOrderCancelReasonNotBetween(Integer value1, Integer value2) {
            addCriterion("order_cancel_reason not between", value1, value2, "orderCancelReason");
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

        public Criteria andCostReportChargeAmountIsNull() {
            addCriterion("cost_report_charge_amount is null");
            return (Criteria) this;
        }

        public Criteria andCostReportChargeAmountIsNotNull() {
            addCriterion("cost_report_charge_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCostReportChargeAmountEqualTo(BigDecimal value) {
            addCriterion("cost_report_charge_amount =", value, "costReportChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostReportChargeAmountNotEqualTo(BigDecimal value) {
            addCriterion("cost_report_charge_amount <>", value, "costReportChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostReportChargeAmountGreaterThan(BigDecimal value) {
            addCriterion("cost_report_charge_amount >", value, "costReportChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostReportChargeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_report_charge_amount >=", value, "costReportChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostReportChargeAmountLessThan(BigDecimal value) {
            addCriterion("cost_report_charge_amount <", value, "costReportChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostReportChargeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_report_charge_amount <=", value, "costReportChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostReportChargeAmountIn(List<BigDecimal> values) {
            addCriterion("cost_report_charge_amount in", values, "costReportChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostReportChargeAmountNotIn(List<BigDecimal> values) {
            addCriterion("cost_report_charge_amount not in", values, "costReportChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostReportChargeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_report_charge_amount between", value1, value2, "costReportChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostReportChargeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_report_charge_amount not between", value1, value2, "costReportChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeAmountIsNull() {
            addCriterion("cost_acquisition_charge_amount is null");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeAmountIsNotNull() {
            addCriterion("cost_acquisition_charge_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeAmountEqualTo(BigDecimal value) {
            addCriterion("cost_acquisition_charge_amount =", value, "costAcquisitionChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeAmountNotEqualTo(BigDecimal value) {
            addCriterion("cost_acquisition_charge_amount <>", value, "costAcquisitionChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeAmountGreaterThan(BigDecimal value) {
            addCriterion("cost_acquisition_charge_amount >", value, "costAcquisitionChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_acquisition_charge_amount >=", value, "costAcquisitionChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeAmountLessThan(BigDecimal value) {
            addCriterion("cost_acquisition_charge_amount <", value, "costAcquisitionChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_acquisition_charge_amount <=", value, "costAcquisitionChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeAmountIn(List<BigDecimal> values) {
            addCriterion("cost_acquisition_charge_amount in", values, "costAcquisitionChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeAmountNotIn(List<BigDecimal> values) {
            addCriterion("cost_acquisition_charge_amount not in", values, "costAcquisitionChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_acquisition_charge_amount between", value1, value2, "costAcquisitionChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_acquisition_charge_amount not between", value1, value2, "costAcquisitionChargeAmount");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionAmountIsNull() {
            addCriterion("cost_staff_commission_amount is null");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionAmountIsNotNull() {
            addCriterion("cost_staff_commission_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionAmountEqualTo(BigDecimal value) {
            addCriterion("cost_staff_commission_amount =", value, "costStaffCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionAmountNotEqualTo(BigDecimal value) {
            addCriterion("cost_staff_commission_amount <>", value, "costStaffCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionAmountGreaterThan(BigDecimal value) {
            addCriterion("cost_staff_commission_amount >", value, "costStaffCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_staff_commission_amount >=", value, "costStaffCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionAmountLessThan(BigDecimal value) {
            addCriterion("cost_staff_commission_amount <", value, "costStaffCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_staff_commission_amount <=", value, "costStaffCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionAmountIn(List<BigDecimal> values) {
            addCriterion("cost_staff_commission_amount in", values, "costStaffCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionAmountNotIn(List<BigDecimal> values) {
            addCriterion("cost_staff_commission_amount not in", values, "costStaffCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_staff_commission_amount between", value1, value2, "costStaffCommissionAmount");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_staff_commission_amount not between", value1, value2, "costStaffCommissionAmount");
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

        public Criteria andInvoiceStatusIsNull() {
            addCriterion("invoice_status is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusIsNotNull() {
            addCriterion("invoice_status is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusEqualTo(Integer value) {
            addCriterion("invoice_status =", value, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusNotEqualTo(Integer value) {
            addCriterion("invoice_status <>", value, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusGreaterThan(Integer value) {
            addCriterion("invoice_status >", value, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_status >=", value, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusLessThan(Integer value) {
            addCriterion("invoice_status <", value, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_status <=", value, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusIn(List<Integer> values) {
            addCriterion("invoice_status in", values, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusNotIn(List<Integer> values) {
            addCriterion("invoice_status not in", values, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusBetween(Integer value1, Integer value2) {
            addCriterion("invoice_status between", value1, value2, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_status not between", value1, value2, "invoiceStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdIsNull() {
            addCriterion("invoice_apply_id is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdIsNotNull() {
            addCriterion("invoice_apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdEqualTo(String value) {
            addCriterion("invoice_apply_id =", value, "invoiceApplyId");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdNotEqualTo(String value) {
            addCriterion("invoice_apply_id <>", value, "invoiceApplyId");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdGreaterThan(String value) {
            addCriterion("invoice_apply_id >", value, "invoiceApplyId");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_apply_id >=", value, "invoiceApplyId");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdLessThan(String value) {
            addCriterion("invoice_apply_id <", value, "invoiceApplyId");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdLessThanOrEqualTo(String value) {
            addCriterion("invoice_apply_id <=", value, "invoiceApplyId");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdLike(String value) {
            addCriterion("invoice_apply_id like", value, "invoiceApplyId");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdNotLike(String value) {
            addCriterion("invoice_apply_id not like", value, "invoiceApplyId");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdIn(List<String> values) {
            addCriterion("invoice_apply_id in", values, "invoiceApplyId");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdNotIn(List<String> values) {
            addCriterion("invoice_apply_id not in", values, "invoiceApplyId");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdBetween(String value1, String value2) {
            addCriterion("invoice_apply_id between", value1, value2, "invoiceApplyId");
            return (Criteria) this;
        }

        public Criteria andInvoiceApplyIdNotBetween(String value1, String value2) {
            addCriterion("invoice_apply_id not between", value1, value2, "invoiceApplyId");
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

        public Criteria andInterpretStaffIdIsNull() {
            addCriterion("interpret_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdIsNotNull() {
            addCriterion("interpret_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdEqualTo(String value) {
            addCriterion("interpret_staff_id =", value, "interpretStaffId");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdNotEqualTo(String value) {
            addCriterion("interpret_staff_id <>", value, "interpretStaffId");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdGreaterThan(String value) {
            addCriterion("interpret_staff_id >", value, "interpretStaffId");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("interpret_staff_id >=", value, "interpretStaffId");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdLessThan(String value) {
            addCriterion("interpret_staff_id <", value, "interpretStaffId");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdLessThanOrEqualTo(String value) {
            addCriterion("interpret_staff_id <=", value, "interpretStaffId");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdLike(String value) {
            addCriterion("interpret_staff_id like", value, "interpretStaffId");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdNotLike(String value) {
            addCriterion("interpret_staff_id not like", value, "interpretStaffId");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdIn(List<String> values) {
            addCriterion("interpret_staff_id in", values, "interpretStaffId");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdNotIn(List<String> values) {
            addCriterion("interpret_staff_id not in", values, "interpretStaffId");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdBetween(String value1, String value2) {
            addCriterion("interpret_staff_id between", value1, value2, "interpretStaffId");
            return (Criteria) this;
        }

        public Criteria andInterpretStaffIdNotBetween(String value1, String value2) {
            addCriterion("interpret_staff_id not between", value1, value2, "interpretStaffId");
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