package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletAreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletAreaExample() {
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

        public Criteria andAreaPidIsNull() {
            addCriterion("area_pid is null");
            return (Criteria) this;
        }

        public Criteria andAreaPidIsNotNull() {
            addCriterion("area_pid is not null");
            return (Criteria) this;
        }

        public Criteria andAreaPidEqualTo(String value) {
            addCriterion("area_pid =", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidNotEqualTo(String value) {
            addCriterion("area_pid <>", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidGreaterThan(String value) {
            addCriterion("area_pid >", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidGreaterThanOrEqualTo(String value) {
            addCriterion("area_pid >=", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidLessThan(String value) {
            addCriterion("area_pid <", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidLessThanOrEqualTo(String value) {
            addCriterion("area_pid <=", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidLike(String value) {
            addCriterion("area_pid like", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidNotLike(String value) {
            addCriterion("area_pid not like", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidIn(List<String> values) {
            addCriterion("area_pid in", values, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidNotIn(List<String> values) {
            addCriterion("area_pid not in", values, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidBetween(String value1, String value2) {
            addCriterion("area_pid between", value1, value2, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidNotBetween(String value1, String value2) {
            addCriterion("area_pid not between", value1, value2, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(String value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(String value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(String value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(String value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(String value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(String value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLike(String value) {
            addCriterion("area_id like", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotLike(String value) {
            addCriterion("area_id not like", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<String> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<String> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(String value1, String value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(String value1, String value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("area_name in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("area_name not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceIsNull() {
            addCriterion("area_province is null");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceIsNotNull() {
            addCriterion("area_province is not null");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceEqualTo(String value) {
            addCriterion("area_province =", value, "areaProvince");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceNotEqualTo(String value) {
            addCriterion("area_province <>", value, "areaProvince");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceGreaterThan(String value) {
            addCriterion("area_province >", value, "areaProvince");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("area_province >=", value, "areaProvince");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceLessThan(String value) {
            addCriterion("area_province <", value, "areaProvince");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceLessThanOrEqualTo(String value) {
            addCriterion("area_province <=", value, "areaProvince");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceLike(String value) {
            addCriterion("area_province like", value, "areaProvince");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceNotLike(String value) {
            addCriterion("area_province not like", value, "areaProvince");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceIn(List<String> values) {
            addCriterion("area_province in", values, "areaProvince");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceNotIn(List<String> values) {
            addCriterion("area_province not in", values, "areaProvince");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceBetween(String value1, String value2) {
            addCriterion("area_province between", value1, value2, "areaProvince");
            return (Criteria) this;
        }

        public Criteria andAreaProvinceNotBetween(String value1, String value2) {
            addCriterion("area_province not between", value1, value2, "areaProvince");
            return (Criteria) this;
        }

        public Criteria andAreaCityIsNull() {
            addCriterion("area_city is null");
            return (Criteria) this;
        }

        public Criteria andAreaCityIsNotNull() {
            addCriterion("area_city is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCityEqualTo(String value) {
            addCriterion("area_city =", value, "areaCity");
            return (Criteria) this;
        }

        public Criteria andAreaCityNotEqualTo(String value) {
            addCriterion("area_city <>", value, "areaCity");
            return (Criteria) this;
        }

        public Criteria andAreaCityGreaterThan(String value) {
            addCriterion("area_city >", value, "areaCity");
            return (Criteria) this;
        }

        public Criteria andAreaCityGreaterThanOrEqualTo(String value) {
            addCriterion("area_city >=", value, "areaCity");
            return (Criteria) this;
        }

        public Criteria andAreaCityLessThan(String value) {
            addCriterion("area_city <", value, "areaCity");
            return (Criteria) this;
        }

        public Criteria andAreaCityLessThanOrEqualTo(String value) {
            addCriterion("area_city <=", value, "areaCity");
            return (Criteria) this;
        }

        public Criteria andAreaCityLike(String value) {
            addCriterion("area_city like", value, "areaCity");
            return (Criteria) this;
        }

        public Criteria andAreaCityNotLike(String value) {
            addCriterion("area_city not like", value, "areaCity");
            return (Criteria) this;
        }

        public Criteria andAreaCityIn(List<String> values) {
            addCriterion("area_city in", values, "areaCity");
            return (Criteria) this;
        }

        public Criteria andAreaCityNotIn(List<String> values) {
            addCriterion("area_city not in", values, "areaCity");
            return (Criteria) this;
        }

        public Criteria andAreaCityBetween(String value1, String value2) {
            addCriterion("area_city between", value1, value2, "areaCity");
            return (Criteria) this;
        }

        public Criteria andAreaCityNotBetween(String value1, String value2) {
            addCriterion("area_city not between", value1, value2, "areaCity");
            return (Criteria) this;
        }

        public Criteria andAreaRegionIsNull() {
            addCriterion("area_region is null");
            return (Criteria) this;
        }

        public Criteria andAreaRegionIsNotNull() {
            addCriterion("area_region is not null");
            return (Criteria) this;
        }

        public Criteria andAreaRegionEqualTo(String value) {
            addCriterion("area_region =", value, "areaRegion");
            return (Criteria) this;
        }

        public Criteria andAreaRegionNotEqualTo(String value) {
            addCriterion("area_region <>", value, "areaRegion");
            return (Criteria) this;
        }

        public Criteria andAreaRegionGreaterThan(String value) {
            addCriterion("area_region >", value, "areaRegion");
            return (Criteria) this;
        }

        public Criteria andAreaRegionGreaterThanOrEqualTo(String value) {
            addCriterion("area_region >=", value, "areaRegion");
            return (Criteria) this;
        }

        public Criteria andAreaRegionLessThan(String value) {
            addCriterion("area_region <", value, "areaRegion");
            return (Criteria) this;
        }

        public Criteria andAreaRegionLessThanOrEqualTo(String value) {
            addCriterion("area_region <=", value, "areaRegion");
            return (Criteria) this;
        }

        public Criteria andAreaRegionLike(String value) {
            addCriterion("area_region like", value, "areaRegion");
            return (Criteria) this;
        }

        public Criteria andAreaRegionNotLike(String value) {
            addCriterion("area_region not like", value, "areaRegion");
            return (Criteria) this;
        }

        public Criteria andAreaRegionIn(List<String> values) {
            addCriterion("area_region in", values, "areaRegion");
            return (Criteria) this;
        }

        public Criteria andAreaRegionNotIn(List<String> values) {
            addCriterion("area_region not in", values, "areaRegion");
            return (Criteria) this;
        }

        public Criteria andAreaRegionBetween(String value1, String value2) {
            addCriterion("area_region between", value1, value2, "areaRegion");
            return (Criteria) this;
        }

        public Criteria andAreaRegionNotBetween(String value1, String value2) {
            addCriterion("area_region not between", value1, value2, "areaRegion");
            return (Criteria) this;
        }

        public Criteria andAreaStatusIsNull() {
            addCriterion("area_status is null");
            return (Criteria) this;
        }

        public Criteria andAreaStatusIsNotNull() {
            addCriterion("area_status is not null");
            return (Criteria) this;
        }

        public Criteria andAreaStatusEqualTo(Integer value) {
            addCriterion("area_status =", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusNotEqualTo(Integer value) {
            addCriterion("area_status <>", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusGreaterThan(Integer value) {
            addCriterion("area_status >", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_status >=", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusLessThan(Integer value) {
            addCriterion("area_status <", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusLessThanOrEqualTo(Integer value) {
            addCriterion("area_status <=", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusIn(List<Integer> values) {
            addCriterion("area_status in", values, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusNotIn(List<Integer> values) {
            addCriterion("area_status not in", values, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusBetween(Integer value1, Integer value2) {
            addCriterion("area_status between", value1, value2, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("area_status not between", value1, value2, "areaStatus");
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