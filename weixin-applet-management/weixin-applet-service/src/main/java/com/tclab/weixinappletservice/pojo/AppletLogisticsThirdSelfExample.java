package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletLogisticsThirdSelfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletLogisticsThirdSelfExample() {
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

        public Criteria andThirdLogisticsIdIsNull() {
            addCriterion("third_logistics_id is null");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdIsNotNull() {
            addCriterion("third_logistics_id is not null");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdEqualTo(String value) {
            addCriterion("third_logistics_id =", value, "thirdLogisticsId");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdNotEqualTo(String value) {
            addCriterion("third_logistics_id <>", value, "thirdLogisticsId");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdGreaterThan(String value) {
            addCriterion("third_logistics_id >", value, "thirdLogisticsId");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdGreaterThanOrEqualTo(String value) {
            addCriterion("third_logistics_id >=", value, "thirdLogisticsId");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdLessThan(String value) {
            addCriterion("third_logistics_id <", value, "thirdLogisticsId");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdLessThanOrEqualTo(String value) {
            addCriterion("third_logistics_id <=", value, "thirdLogisticsId");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdLike(String value) {
            addCriterion("third_logistics_id like", value, "thirdLogisticsId");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdNotLike(String value) {
            addCriterion("third_logistics_id not like", value, "thirdLogisticsId");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdIn(List<String> values) {
            addCriterion("third_logistics_id in", values, "thirdLogisticsId");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdNotIn(List<String> values) {
            addCriterion("third_logistics_id not in", values, "thirdLogisticsId");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdBetween(String value1, String value2) {
            addCriterion("third_logistics_id between", value1, value2, "thirdLogisticsId");
            return (Criteria) this;
        }

        public Criteria andThirdLogisticsIdNotBetween(String value1, String value2) {
            addCriterion("third_logistics_id not between", value1, value2, "thirdLogisticsId");
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

        public Criteria andLogisticsGoodIsNull() {
            addCriterion("logistics_good is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodIsNotNull() {
            addCriterion("logistics_good is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodEqualTo(String value) {
            addCriterion("logistics_good =", value, "logisticsGood");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodNotEqualTo(String value) {
            addCriterion("logistics_good <>", value, "logisticsGood");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodGreaterThan(String value) {
            addCriterion("logistics_good >", value, "logisticsGood");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_good >=", value, "logisticsGood");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodLessThan(String value) {
            addCriterion("logistics_good <", value, "logisticsGood");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodLessThanOrEqualTo(String value) {
            addCriterion("logistics_good <=", value, "logisticsGood");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodLike(String value) {
            addCriterion("logistics_good like", value, "logisticsGood");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodNotLike(String value) {
            addCriterion("logistics_good not like", value, "logisticsGood");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodIn(List<String> values) {
            addCriterion("logistics_good in", values, "logisticsGood");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodNotIn(List<String> values) {
            addCriterion("logistics_good not in", values, "logisticsGood");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodBetween(String value1, String value2) {
            addCriterion("logistics_good between", value1, value2, "logisticsGood");
            return (Criteria) this;
        }

        public Criteria andLogisticsGoodNotBetween(String value1, String value2) {
            addCriterion("logistics_good not between", value1, value2, "logisticsGood");
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

        public Criteria andLogisticsOrderNumIsNull() {
            addCriterion("logistics_order_num is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsOrderNumIsNotNull() {
            addCriterion("logistics_order_num is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsOrderNumEqualTo(Integer value) {
            addCriterion("logistics_order_num =", value, "logisticsOrderNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsOrderNumNotEqualTo(Integer value) {
            addCriterion("logistics_order_num <>", value, "logisticsOrderNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsOrderNumGreaterThan(Integer value) {
            addCriterion("logistics_order_num >", value, "logisticsOrderNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("logistics_order_num >=", value, "logisticsOrderNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsOrderNumLessThan(Integer value) {
            addCriterion("logistics_order_num <", value, "logisticsOrderNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("logistics_order_num <=", value, "logisticsOrderNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsOrderNumIn(List<Integer> values) {
            addCriterion("logistics_order_num in", values, "logisticsOrderNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsOrderNumNotIn(List<Integer> values) {
            addCriterion("logistics_order_num not in", values, "logisticsOrderNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("logistics_order_num between", value1, value2, "logisticsOrderNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("logistics_order_num not between", value1, value2, "logisticsOrderNum");
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