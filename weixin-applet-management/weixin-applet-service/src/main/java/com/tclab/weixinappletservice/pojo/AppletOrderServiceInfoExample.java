package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletOrderServiceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletOrderServiceInfoExample() {
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

        public Criteria andAddressProvinceIsNull() {
            addCriterion("address_province is null");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceIsNotNull() {
            addCriterion("address_province is not null");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceEqualTo(String value) {
            addCriterion("address_province =", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotEqualTo(String value) {
            addCriterion("address_province <>", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceGreaterThan(String value) {
            addCriterion("address_province >", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("address_province >=", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceLessThan(String value) {
            addCriterion("address_province <", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceLessThanOrEqualTo(String value) {
            addCriterion("address_province <=", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceLike(String value) {
            addCriterion("address_province like", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotLike(String value) {
            addCriterion("address_province not like", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceIn(List<String> values) {
            addCriterion("address_province in", values, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotIn(List<String> values) {
            addCriterion("address_province not in", values, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceBetween(String value1, String value2) {
            addCriterion("address_province between", value1, value2, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotBetween(String value1, String value2) {
            addCriterion("address_province not between", value1, value2, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressCityIsNull() {
            addCriterion("address_city is null");
            return (Criteria) this;
        }

        public Criteria andAddressCityIsNotNull() {
            addCriterion("address_city is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCityEqualTo(String value) {
            addCriterion("address_city =", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotEqualTo(String value) {
            addCriterion("address_city <>", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityGreaterThan(String value) {
            addCriterion("address_city >", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityGreaterThanOrEqualTo(String value) {
            addCriterion("address_city >=", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLessThan(String value) {
            addCriterion("address_city <", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLessThanOrEqualTo(String value) {
            addCriterion("address_city <=", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLike(String value) {
            addCriterion("address_city like", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotLike(String value) {
            addCriterion("address_city not like", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityIn(List<String> values) {
            addCriterion("address_city in", values, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotIn(List<String> values) {
            addCriterion("address_city not in", values, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityBetween(String value1, String value2) {
            addCriterion("address_city between", value1, value2, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotBetween(String value1, String value2) {
            addCriterion("address_city not between", value1, value2, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressRegionIsNull() {
            addCriterion("address_region is null");
            return (Criteria) this;
        }

        public Criteria andAddressRegionIsNotNull() {
            addCriterion("address_region is not null");
            return (Criteria) this;
        }

        public Criteria andAddressRegionEqualTo(String value) {
            addCriterion("address_region =", value, "addressRegion");
            return (Criteria) this;
        }

        public Criteria andAddressRegionNotEqualTo(String value) {
            addCriterion("address_region <>", value, "addressRegion");
            return (Criteria) this;
        }

        public Criteria andAddressRegionGreaterThan(String value) {
            addCriterion("address_region >", value, "addressRegion");
            return (Criteria) this;
        }

        public Criteria andAddressRegionGreaterThanOrEqualTo(String value) {
            addCriterion("address_region >=", value, "addressRegion");
            return (Criteria) this;
        }

        public Criteria andAddressRegionLessThan(String value) {
            addCriterion("address_region <", value, "addressRegion");
            return (Criteria) this;
        }

        public Criteria andAddressRegionLessThanOrEqualTo(String value) {
            addCriterion("address_region <=", value, "addressRegion");
            return (Criteria) this;
        }

        public Criteria andAddressRegionLike(String value) {
            addCriterion("address_region like", value, "addressRegion");
            return (Criteria) this;
        }

        public Criteria andAddressRegionNotLike(String value) {
            addCriterion("address_region not like", value, "addressRegion");
            return (Criteria) this;
        }

        public Criteria andAddressRegionIn(List<String> values) {
            addCriterion("address_region in", values, "addressRegion");
            return (Criteria) this;
        }

        public Criteria andAddressRegionNotIn(List<String> values) {
            addCriterion("address_region not in", values, "addressRegion");
            return (Criteria) this;
        }

        public Criteria andAddressRegionBetween(String value1, String value2) {
            addCriterion("address_region between", value1, value2, "addressRegion");
            return (Criteria) this;
        }

        public Criteria andAddressRegionNotBetween(String value1, String value2) {
            addCriterion("address_region not between", value1, value2, "addressRegion");
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

        public Criteria andZipCodeIsNull() {
            addCriterion("zip_code is null");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNotNull() {
            addCriterion("zip_code is not null");
            return (Criteria) this;
        }

        public Criteria andZipCodeEqualTo(String value) {
            addCriterion("zip_code =", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotEqualTo(String value) {
            addCriterion("zip_code <>", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThan(String value) {
            addCriterion("zip_code >", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("zip_code >=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThan(String value) {
            addCriterion("zip_code <", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThanOrEqualTo(String value) {
            addCriterion("zip_code <=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLike(String value) {
            addCriterion("zip_code like", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotLike(String value) {
            addCriterion("zip_code not like", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeIn(List<String> values) {
            addCriterion("zip_code in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotIn(List<String> values) {
            addCriterion("zip_code not in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeBetween(String value1, String value2) {
            addCriterion("zip_code between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotBetween(String value1, String value2) {
            addCriterion("zip_code not between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andDefaultFlagIsNull() {
            addCriterion("default_flag is null");
            return (Criteria) this;
        }

        public Criteria andDefaultFlagIsNotNull() {
            addCriterion("default_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultFlagEqualTo(Integer value) {
            addCriterion("default_flag =", value, "defaultFlag");
            return (Criteria) this;
        }

        public Criteria andDefaultFlagNotEqualTo(Integer value) {
            addCriterion("default_flag <>", value, "defaultFlag");
            return (Criteria) this;
        }

        public Criteria andDefaultFlagGreaterThan(Integer value) {
            addCriterion("default_flag >", value, "defaultFlag");
            return (Criteria) this;
        }

        public Criteria andDefaultFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("default_flag >=", value, "defaultFlag");
            return (Criteria) this;
        }

        public Criteria andDefaultFlagLessThan(Integer value) {
            addCriterion("default_flag <", value, "defaultFlag");
            return (Criteria) this;
        }

        public Criteria andDefaultFlagLessThanOrEqualTo(Integer value) {
            addCriterion("default_flag <=", value, "defaultFlag");
            return (Criteria) this;
        }

        public Criteria andDefaultFlagIn(List<Integer> values) {
            addCriterion("default_flag in", values, "defaultFlag");
            return (Criteria) this;
        }

        public Criteria andDefaultFlagNotIn(List<Integer> values) {
            addCriterion("default_flag not in", values, "defaultFlag");
            return (Criteria) this;
        }

        public Criteria andDefaultFlagBetween(Integer value1, Integer value2) {
            addCriterion("default_flag between", value1, value2, "defaultFlag");
            return (Criteria) this;
        }

        public Criteria andDefaultFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("default_flag not between", value1, value2, "defaultFlag");
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