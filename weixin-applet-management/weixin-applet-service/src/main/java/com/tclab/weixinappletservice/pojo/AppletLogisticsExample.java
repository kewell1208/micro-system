package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletLogisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletLogisticsExample() {
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

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(String value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(String value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(String value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(String value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(String value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLike(String value) {
            addCriterion("source_id like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotLike(String value) {
            addCriterion("source_id not like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<String> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<String> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(String value1, String value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(String value1, String value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceNameIsNull() {
            addCriterion("source_name is null");
            return (Criteria) this;
        }

        public Criteria andSourceNameIsNotNull() {
            addCriterion("source_name is not null");
            return (Criteria) this;
        }

        public Criteria andSourceNameEqualTo(String value) {
            addCriterion("source_name =", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotEqualTo(String value) {
            addCriterion("source_name <>", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameGreaterThan(String value) {
            addCriterion("source_name >", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("source_name >=", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLessThan(String value) {
            addCriterion("source_name <", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLessThanOrEqualTo(String value) {
            addCriterion("source_name <=", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLike(String value) {
            addCriterion("source_name like", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotLike(String value) {
            addCriterion("source_name not like", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameIn(List<String> values) {
            addCriterion("source_name in", values, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotIn(List<String> values) {
            addCriterion("source_name not in", values, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameBetween(String value1, String value2) {
            addCriterion("source_name between", value1, value2, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotBetween(String value1, String value2) {
            addCriterion("source_name not between", value1, value2, "sourceName");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(String value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(String value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(String value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(String value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(String value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLike(String value) {
            addCriterion("operator_id like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotLike(String value) {
            addCriterion("operator_id not like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<String> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<String> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(String value1, String value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(String value1, String value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNull() {
            addCriterion("operator_name is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("operator_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("operator_name =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("operator_name <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("operator_name >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("operator_name >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("operator_name <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("operator_name <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("operator_name like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("operator_name not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("operator_name in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("operator_name not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("operator_name between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("operator_name not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(Integer value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(Integer value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(Integer value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(Integer value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<Integer> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<Integer> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkIsNull() {
            addCriterion("logistics_remark is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkIsNotNull() {
            addCriterion("logistics_remark is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkEqualTo(String value) {
            addCriterion("logistics_remark =", value, "logisticsRemark");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkNotEqualTo(String value) {
            addCriterion("logistics_remark <>", value, "logisticsRemark");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkGreaterThan(String value) {
            addCriterion("logistics_remark >", value, "logisticsRemark");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_remark >=", value, "logisticsRemark");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkLessThan(String value) {
            addCriterion("logistics_remark <", value, "logisticsRemark");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkLessThanOrEqualTo(String value) {
            addCriterion("logistics_remark <=", value, "logisticsRemark");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkLike(String value) {
            addCriterion("logistics_remark like", value, "logisticsRemark");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkNotLike(String value) {
            addCriterion("logistics_remark not like", value, "logisticsRemark");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkIn(List<String> values) {
            addCriterion("logistics_remark in", values, "logisticsRemark");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkNotIn(List<String> values) {
            addCriterion("logistics_remark not in", values, "logisticsRemark");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkBetween(String value1, String value2) {
            addCriterion("logistics_remark between", value1, value2, "logisticsRemark");
            return (Criteria) this;
        }

        public Criteria andLogisticsRemarkNotBetween(String value1, String value2) {
            addCriterion("logistics_remark not between", value1, value2, "logisticsRemark");
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

        public Criteria andExpressNameIsNull() {
            addCriterion("express_name is null");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNotNull() {
            addCriterion("express_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNameEqualTo(String value) {
            addCriterion("express_name =", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotEqualTo(String value) {
            addCriterion("express_name <>", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThan(String value) {
            addCriterion("express_name >", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            addCriterion("express_name >=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThan(String value) {
            addCriterion("express_name <", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThanOrEqualTo(String value) {
            addCriterion("express_name <=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLike(String value) {
            addCriterion("express_name like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotLike(String value) {
            addCriterion("express_name not like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameIn(List<String> values) {
            addCriterion("express_name in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotIn(List<String> values) {
            addCriterion("express_name not in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameBetween(String value1, String value2) {
            addCriterion("express_name between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotBetween(String value1, String value2) {
            addCriterion("express_name not between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andWaybillNoIsNull() {
            addCriterion("waybill_no is null");
            return (Criteria) this;
        }

        public Criteria andWaybillNoIsNotNull() {
            addCriterion("waybill_no is not null");
            return (Criteria) this;
        }

        public Criteria andWaybillNoEqualTo(String value) {
            addCriterion("waybill_no =", value, "waybillNo");
            return (Criteria) this;
        }

        public Criteria andWaybillNoNotEqualTo(String value) {
            addCriterion("waybill_no <>", value, "waybillNo");
            return (Criteria) this;
        }

        public Criteria andWaybillNoGreaterThan(String value) {
            addCriterion("waybill_no >", value, "waybillNo");
            return (Criteria) this;
        }

        public Criteria andWaybillNoGreaterThanOrEqualTo(String value) {
            addCriterion("waybill_no >=", value, "waybillNo");
            return (Criteria) this;
        }

        public Criteria andWaybillNoLessThan(String value) {
            addCriterion("waybill_no <", value, "waybillNo");
            return (Criteria) this;
        }

        public Criteria andWaybillNoLessThanOrEqualTo(String value) {
            addCriterion("waybill_no <=", value, "waybillNo");
            return (Criteria) this;
        }

        public Criteria andWaybillNoLike(String value) {
            addCriterion("waybill_no like", value, "waybillNo");
            return (Criteria) this;
        }

        public Criteria andWaybillNoNotLike(String value) {
            addCriterion("waybill_no not like", value, "waybillNo");
            return (Criteria) this;
        }

        public Criteria andWaybillNoIn(List<String> values) {
            addCriterion("waybill_no in", values, "waybillNo");
            return (Criteria) this;
        }

        public Criteria andWaybillNoNotIn(List<String> values) {
            addCriterion("waybill_no not in", values, "waybillNo");
            return (Criteria) this;
        }

        public Criteria andWaybillNoBetween(String value1, String value2) {
            addCriterion("waybill_no between", value1, value2, "waybillNo");
            return (Criteria) this;
        }

        public Criteria andWaybillNoNotBetween(String value1, String value2) {
            addCriterion("waybill_no not between", value1, value2, "waybillNo");
            return (Criteria) this;
        }

        public Criteria andExpressImageIsNull() {
            addCriterion("express_image is null");
            return (Criteria) this;
        }

        public Criteria andExpressImageIsNotNull() {
            addCriterion("express_image is not null");
            return (Criteria) this;
        }

        public Criteria andExpressImageEqualTo(String value) {
            addCriterion("express_image =", value, "expressImage");
            return (Criteria) this;
        }

        public Criteria andExpressImageNotEqualTo(String value) {
            addCriterion("express_image <>", value, "expressImage");
            return (Criteria) this;
        }

        public Criteria andExpressImageGreaterThan(String value) {
            addCriterion("express_image >", value, "expressImage");
            return (Criteria) this;
        }

        public Criteria andExpressImageGreaterThanOrEqualTo(String value) {
            addCriterion("express_image >=", value, "expressImage");
            return (Criteria) this;
        }

        public Criteria andExpressImageLessThan(String value) {
            addCriterion("express_image <", value, "expressImage");
            return (Criteria) this;
        }

        public Criteria andExpressImageLessThanOrEqualTo(String value) {
            addCriterion("express_image <=", value, "expressImage");
            return (Criteria) this;
        }

        public Criteria andExpressImageLike(String value) {
            addCriterion("express_image like", value, "expressImage");
            return (Criteria) this;
        }

        public Criteria andExpressImageNotLike(String value) {
            addCriterion("express_image not like", value, "expressImage");
            return (Criteria) this;
        }

        public Criteria andExpressImageIn(List<String> values) {
            addCriterion("express_image in", values, "expressImage");
            return (Criteria) this;
        }

        public Criteria andExpressImageNotIn(List<String> values) {
            addCriterion("express_image not in", values, "expressImage");
            return (Criteria) this;
        }

        public Criteria andExpressImageBetween(String value1, String value2) {
            addCriterion("express_image between", value1, value2, "expressImage");
            return (Criteria) this;
        }

        public Criteria andExpressImageNotBetween(String value1, String value2) {
            addCriterion("express_image not between", value1, value2, "expressImage");
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

        public Criteria andLogisticsApplyDateIsNull() {
            addCriterion("logistics_apply_date is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsApplyDateIsNotNull() {
            addCriterion("logistics_apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsApplyDateEqualTo(Date value) {
            addCriterion("logistics_apply_date =", value, "logisticsApplyDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsApplyDateNotEqualTo(Date value) {
            addCriterion("logistics_apply_date <>", value, "logisticsApplyDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsApplyDateGreaterThan(Date value) {
            addCriterion("logistics_apply_date >", value, "logisticsApplyDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("logistics_apply_date >=", value, "logisticsApplyDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsApplyDateLessThan(Date value) {
            addCriterion("logistics_apply_date <", value, "logisticsApplyDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("logistics_apply_date <=", value, "logisticsApplyDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsApplyDateIn(List<Date> values) {
            addCriterion("logistics_apply_date in", values, "logisticsApplyDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsApplyDateNotIn(List<Date> values) {
            addCriterion("logistics_apply_date not in", values, "logisticsApplyDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsApplyDateBetween(Date value1, Date value2) {
            addCriterion("logistics_apply_date between", value1, value2, "logisticsApplyDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("logistics_apply_date not between", value1, value2, "logisticsApplyDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsPickDateIsNull() {
            addCriterion("logistics_pick_date is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsPickDateIsNotNull() {
            addCriterion("logistics_pick_date is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsPickDateEqualTo(Date value) {
            addCriterion("logistics_pick_date =", value, "logisticsPickDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsPickDateNotEqualTo(Date value) {
            addCriterion("logistics_pick_date <>", value, "logisticsPickDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsPickDateGreaterThan(Date value) {
            addCriterion("logistics_pick_date >", value, "logisticsPickDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsPickDateGreaterThanOrEqualTo(Date value) {
            addCriterion("logistics_pick_date >=", value, "logisticsPickDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsPickDateLessThan(Date value) {
            addCriterion("logistics_pick_date <", value, "logisticsPickDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsPickDateLessThanOrEqualTo(Date value) {
            addCriterion("logistics_pick_date <=", value, "logisticsPickDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsPickDateIn(List<Date> values) {
            addCriterion("logistics_pick_date in", values, "logisticsPickDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsPickDateNotIn(List<Date> values) {
            addCriterion("logistics_pick_date not in", values, "logisticsPickDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsPickDateBetween(Date value1, Date value2) {
            addCriterion("logistics_pick_date between", value1, value2, "logisticsPickDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsPickDateNotBetween(Date value1, Date value2) {
            addCriterion("logistics_pick_date not between", value1, value2, "logisticsPickDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsArrivedDateIsNull() {
            addCriterion("logistics_arrived_date is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsArrivedDateIsNotNull() {
            addCriterion("logistics_arrived_date is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsArrivedDateEqualTo(Date value) {
            addCriterion("logistics_arrived_date =", value, "logisticsArrivedDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsArrivedDateNotEqualTo(Date value) {
            addCriterion("logistics_arrived_date <>", value, "logisticsArrivedDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsArrivedDateGreaterThan(Date value) {
            addCriterion("logistics_arrived_date >", value, "logisticsArrivedDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsArrivedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("logistics_arrived_date >=", value, "logisticsArrivedDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsArrivedDateLessThan(Date value) {
            addCriterion("logistics_arrived_date <", value, "logisticsArrivedDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsArrivedDateLessThanOrEqualTo(Date value) {
            addCriterion("logistics_arrived_date <=", value, "logisticsArrivedDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsArrivedDateIn(List<Date> values) {
            addCriterion("logistics_arrived_date in", values, "logisticsArrivedDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsArrivedDateNotIn(List<Date> values) {
            addCriterion("logistics_arrived_date not in", values, "logisticsArrivedDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsArrivedDateBetween(Date value1, Date value2) {
            addCriterion("logistics_arrived_date between", value1, value2, "logisticsArrivedDate");
            return (Criteria) this;
        }

        public Criteria andLogisticsArrivedDateNotBetween(Date value1, Date value2) {
            addCriterion("logistics_arrived_date not between", value1, value2, "logisticsArrivedDate");
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