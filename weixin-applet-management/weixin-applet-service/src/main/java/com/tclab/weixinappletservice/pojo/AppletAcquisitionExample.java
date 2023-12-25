package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletAcquisitionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletAcquisitionExample() {
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

        public Criteria andAcquisitionPhoneIsNull() {
            addCriterion("acquisition_phone is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneIsNotNull() {
            addCriterion("acquisition_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneEqualTo(String value) {
            addCriterion("acquisition_phone =", value, "acquisitionPhone");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneNotEqualTo(String value) {
            addCriterion("acquisition_phone <>", value, "acquisitionPhone");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneGreaterThan(String value) {
            addCriterion("acquisition_phone >", value, "acquisitionPhone");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_phone >=", value, "acquisitionPhone");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneLessThan(String value) {
            addCriterion("acquisition_phone <", value, "acquisitionPhone");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneLessThanOrEqualTo(String value) {
            addCriterion("acquisition_phone <=", value, "acquisitionPhone");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneLike(String value) {
            addCriterion("acquisition_phone like", value, "acquisitionPhone");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneNotLike(String value) {
            addCriterion("acquisition_phone not like", value, "acquisitionPhone");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneIn(List<String> values) {
            addCriterion("acquisition_phone in", values, "acquisitionPhone");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneNotIn(List<String> values) {
            addCriterion("acquisition_phone not in", values, "acquisitionPhone");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneBetween(String value1, String value2) {
            addCriterion("acquisition_phone between", value1, value2, "acquisitionPhone");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPhoneNotBetween(String value1, String value2) {
            addCriterion("acquisition_phone not between", value1, value2, "acquisitionPhone");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressIsNull() {
            addCriterion("acquisition_address is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressIsNotNull() {
            addCriterion("acquisition_address is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressEqualTo(String value) {
            addCriterion("acquisition_address =", value, "acquisitionAddress");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressNotEqualTo(String value) {
            addCriterion("acquisition_address <>", value, "acquisitionAddress");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressGreaterThan(String value) {
            addCriterion("acquisition_address >", value, "acquisitionAddress");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_address >=", value, "acquisitionAddress");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressLessThan(String value) {
            addCriterion("acquisition_address <", value, "acquisitionAddress");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressLessThanOrEqualTo(String value) {
            addCriterion("acquisition_address <=", value, "acquisitionAddress");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressLike(String value) {
            addCriterion("acquisition_address like", value, "acquisitionAddress");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressNotLike(String value) {
            addCriterion("acquisition_address not like", value, "acquisitionAddress");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressIn(List<String> values) {
            addCriterion("acquisition_address in", values, "acquisitionAddress");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressNotIn(List<String> values) {
            addCriterion("acquisition_address not in", values, "acquisitionAddress");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressBetween(String value1, String value2) {
            addCriterion("acquisition_address between", value1, value2, "acquisitionAddress");
            return (Criteria) this;
        }

        public Criteria andAcquisitionAddressNotBetween(String value1, String value2) {
            addCriterion("acquisition_address not between", value1, value2, "acquisitionAddress");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoIsNull() {
            addCriterion("acquisition_logo is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoIsNotNull() {
            addCriterion("acquisition_logo is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoEqualTo(String value) {
            addCriterion("acquisition_logo =", value, "acquisitionLogo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoNotEqualTo(String value) {
            addCriterion("acquisition_logo <>", value, "acquisitionLogo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoGreaterThan(String value) {
            addCriterion("acquisition_logo >", value, "acquisitionLogo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_logo >=", value, "acquisitionLogo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoLessThan(String value) {
            addCriterion("acquisition_logo <", value, "acquisitionLogo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoLessThanOrEqualTo(String value) {
            addCriterion("acquisition_logo <=", value, "acquisitionLogo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoLike(String value) {
            addCriterion("acquisition_logo like", value, "acquisitionLogo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoNotLike(String value) {
            addCriterion("acquisition_logo not like", value, "acquisitionLogo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoIn(List<String> values) {
            addCriterion("acquisition_logo in", values, "acquisitionLogo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoNotIn(List<String> values) {
            addCriterion("acquisition_logo not in", values, "acquisitionLogo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoBetween(String value1, String value2) {
            addCriterion("acquisition_logo between", value1, value2, "acquisitionLogo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLogoNotBetween(String value1, String value2) {
            addCriterion("acquisition_logo not between", value1, value2, "acquisitionLogo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseIsNull() {
            addCriterion("acquisition_license is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseIsNotNull() {
            addCriterion("acquisition_license is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseEqualTo(String value) {
            addCriterion("acquisition_license =", value, "acquisitionLicense");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseNotEqualTo(String value) {
            addCriterion("acquisition_license <>", value, "acquisitionLicense");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseGreaterThan(String value) {
            addCriterion("acquisition_license >", value, "acquisitionLicense");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_license >=", value, "acquisitionLicense");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseLessThan(String value) {
            addCriterion("acquisition_license <", value, "acquisitionLicense");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseLessThanOrEqualTo(String value) {
            addCriterion("acquisition_license <=", value, "acquisitionLicense");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseLike(String value) {
            addCriterion("acquisition_license like", value, "acquisitionLicense");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseNotLike(String value) {
            addCriterion("acquisition_license not like", value, "acquisitionLicense");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseIn(List<String> values) {
            addCriterion("acquisition_license in", values, "acquisitionLicense");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseNotIn(List<String> values) {
            addCriterion("acquisition_license not in", values, "acquisitionLicense");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseBetween(String value1, String value2) {
            addCriterion("acquisition_license between", value1, value2, "acquisitionLicense");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLicenseNotBetween(String value1, String value2) {
            addCriterion("acquisition_license not between", value1, value2, "acquisitionLicense");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceIsNull() {
            addCriterion("acquisition_business_licence is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceIsNotNull() {
            addCriterion("acquisition_business_licence is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceEqualTo(String value) {
            addCriterion("acquisition_business_licence =", value, "acquisitionBusinessLicence");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceNotEqualTo(String value) {
            addCriterion("acquisition_business_licence <>", value, "acquisitionBusinessLicence");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceGreaterThan(String value) {
            addCriterion("acquisition_business_licence >", value, "acquisitionBusinessLicence");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_business_licence >=", value, "acquisitionBusinessLicence");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceLessThan(String value) {
            addCriterion("acquisition_business_licence <", value, "acquisitionBusinessLicence");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceLessThanOrEqualTo(String value) {
            addCriterion("acquisition_business_licence <=", value, "acquisitionBusinessLicence");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceLike(String value) {
            addCriterion("acquisition_business_licence like", value, "acquisitionBusinessLicence");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceNotLike(String value) {
            addCriterion("acquisition_business_licence not like", value, "acquisitionBusinessLicence");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceIn(List<String> values) {
            addCriterion("acquisition_business_licence in", values, "acquisitionBusinessLicence");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceNotIn(List<String> values) {
            addCriterion("acquisition_business_licence not in", values, "acquisitionBusinessLicence");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceBetween(String value1, String value2) {
            addCriterion("acquisition_business_licence between", value1, value2, "acquisitionBusinessLicence");
            return (Criteria) this;
        }

        public Criteria andAcquisitionBusinessLicenceNotBetween(String value1, String value2) {
            addCriterion("acquisition_business_licence not between", value1, value2, "acquisitionBusinessLicence");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoIsNull() {
            addCriterion("acquisition_info is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoIsNotNull() {
            addCriterion("acquisition_info is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoEqualTo(String value) {
            addCriterion("acquisition_info =", value, "acquisitionInfo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoNotEqualTo(String value) {
            addCriterion("acquisition_info <>", value, "acquisitionInfo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoGreaterThan(String value) {
            addCriterion("acquisition_info >", value, "acquisitionInfo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_info >=", value, "acquisitionInfo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoLessThan(String value) {
            addCriterion("acquisition_info <", value, "acquisitionInfo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoLessThanOrEqualTo(String value) {
            addCriterion("acquisition_info <=", value, "acquisitionInfo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoLike(String value) {
            addCriterion("acquisition_info like", value, "acquisitionInfo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoNotLike(String value) {
            addCriterion("acquisition_info not like", value, "acquisitionInfo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoIn(List<String> values) {
            addCriterion("acquisition_info in", values, "acquisitionInfo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoNotIn(List<String> values) {
            addCriterion("acquisition_info not in", values, "acquisitionInfo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoBetween(String value1, String value2) {
            addCriterion("acquisition_info between", value1, value2, "acquisitionInfo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionInfoNotBetween(String value1, String value2) {
            addCriterion("acquisition_info not between", value1, value2, "acquisitionInfo");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageIsNull() {
            addCriterion("acquisition_message is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageIsNotNull() {
            addCriterion("acquisition_message is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageEqualTo(String value) {
            addCriterion("acquisition_message =", value, "acquisitionMessage");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageNotEqualTo(String value) {
            addCriterion("acquisition_message <>", value, "acquisitionMessage");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageGreaterThan(String value) {
            addCriterion("acquisition_message >", value, "acquisitionMessage");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_message >=", value, "acquisitionMessage");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageLessThan(String value) {
            addCriterion("acquisition_message <", value, "acquisitionMessage");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageLessThanOrEqualTo(String value) {
            addCriterion("acquisition_message <=", value, "acquisitionMessage");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageLike(String value) {
            addCriterion("acquisition_message like", value, "acquisitionMessage");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageNotLike(String value) {
            addCriterion("acquisition_message not like", value, "acquisitionMessage");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageIn(List<String> values) {
            addCriterion("acquisition_message in", values, "acquisitionMessage");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageNotIn(List<String> values) {
            addCriterion("acquisition_message not in", values, "acquisitionMessage");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageBetween(String value1, String value2) {
            addCriterion("acquisition_message between", value1, value2, "acquisitionMessage");
            return (Criteria) this;
        }

        public Criteria andAcquisitionMessageNotBetween(String value1, String value2) {
            addCriterion("acquisition_message not between", value1, value2, "acquisitionMessage");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeIsNull() {
            addCriterion("acquisition_office_time is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeIsNotNull() {
            addCriterion("acquisition_office_time is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeEqualTo(String value) {
            addCriterion("acquisition_office_time =", value, "acquisitionOfficeTime");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeNotEqualTo(String value) {
            addCriterion("acquisition_office_time <>", value, "acquisitionOfficeTime");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeGreaterThan(String value) {
            addCriterion("acquisition_office_time >", value, "acquisitionOfficeTime");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_office_time >=", value, "acquisitionOfficeTime");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeLessThan(String value) {
            addCriterion("acquisition_office_time <", value, "acquisitionOfficeTime");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeLessThanOrEqualTo(String value) {
            addCriterion("acquisition_office_time <=", value, "acquisitionOfficeTime");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeLike(String value) {
            addCriterion("acquisition_office_time like", value, "acquisitionOfficeTime");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeNotLike(String value) {
            addCriterion("acquisition_office_time not like", value, "acquisitionOfficeTime");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeIn(List<String> values) {
            addCriterion("acquisition_office_time in", values, "acquisitionOfficeTime");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeNotIn(List<String> values) {
            addCriterion("acquisition_office_time not in", values, "acquisitionOfficeTime");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeBetween(String value1, String value2) {
            addCriterion("acquisition_office_time between", value1, value2, "acquisitionOfficeTime");
            return (Criteria) this;
        }

        public Criteria andAcquisitionOfficeTimeNotBetween(String value1, String value2) {
            addCriterion("acquisition_office_time not between", value1, value2, "acquisitionOfficeTime");
            return (Criteria) this;
        }

        public Criteria andAcquisitionScoreIsNull() {
            addCriterion("acquisition_score is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionScoreIsNotNull() {
            addCriterion("acquisition_score is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionScoreEqualTo(Float value) {
            addCriterion("acquisition_score =", value, "acquisitionScore");
            return (Criteria) this;
        }

        public Criteria andAcquisitionScoreNotEqualTo(Float value) {
            addCriterion("acquisition_score <>", value, "acquisitionScore");
            return (Criteria) this;
        }

        public Criteria andAcquisitionScoreGreaterThan(Float value) {
            addCriterion("acquisition_score >", value, "acquisitionScore");
            return (Criteria) this;
        }

        public Criteria andAcquisitionScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("acquisition_score >=", value, "acquisitionScore");
            return (Criteria) this;
        }

        public Criteria andAcquisitionScoreLessThan(Float value) {
            addCriterion("acquisition_score <", value, "acquisitionScore");
            return (Criteria) this;
        }

        public Criteria andAcquisitionScoreLessThanOrEqualTo(Float value) {
            addCriterion("acquisition_score <=", value, "acquisitionScore");
            return (Criteria) this;
        }

        public Criteria andAcquisitionScoreIn(List<Float> values) {
            addCriterion("acquisition_score in", values, "acquisitionScore");
            return (Criteria) this;
        }

        public Criteria andAcquisitionScoreNotIn(List<Float> values) {
            addCriterion("acquisition_score not in", values, "acquisitionScore");
            return (Criteria) this;
        }

        public Criteria andAcquisitionScoreBetween(Float value1, Float value2) {
            addCriterion("acquisition_score between", value1, value2, "acquisitionScore");
            return (Criteria) this;
        }

        public Criteria andAcquisitionScoreNotBetween(Float value1, Float value2) {
            addCriterion("acquisition_score not between", value1, value2, "acquisitionScore");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRecommendationIsNull() {
            addCriterion("acquisition_recommendation is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRecommendationIsNotNull() {
            addCriterion("acquisition_recommendation is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRecommendationEqualTo(Integer value) {
            addCriterion("acquisition_recommendation =", value, "acquisitionRecommendation");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRecommendationNotEqualTo(Integer value) {
            addCriterion("acquisition_recommendation <>", value, "acquisitionRecommendation");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRecommendationGreaterThan(Integer value) {
            addCriterion("acquisition_recommendation >", value, "acquisitionRecommendation");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRecommendationGreaterThanOrEqualTo(Integer value) {
            addCriterion("acquisition_recommendation >=", value, "acquisitionRecommendation");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRecommendationLessThan(Integer value) {
            addCriterion("acquisition_recommendation <", value, "acquisitionRecommendation");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRecommendationLessThanOrEqualTo(Integer value) {
            addCriterion("acquisition_recommendation <=", value, "acquisitionRecommendation");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRecommendationIn(List<Integer> values) {
            addCriterion("acquisition_recommendation in", values, "acquisitionRecommendation");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRecommendationNotIn(List<Integer> values) {
            addCriterion("acquisition_recommendation not in", values, "acquisitionRecommendation");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRecommendationBetween(Integer value1, Integer value2) {
            addCriterion("acquisition_recommendation between", value1, value2, "acquisitionRecommendation");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRecommendationNotBetween(Integer value1, Integer value2) {
            addCriterion("acquisition_recommendation not between", value1, value2, "acquisitionRecommendation");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelIsNull() {
            addCriterion("acquisition_label is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelIsNotNull() {
            addCriterion("acquisition_label is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelEqualTo(String value) {
            addCriterion("acquisition_label =", value, "acquisitionLabel");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelNotEqualTo(String value) {
            addCriterion("acquisition_label <>", value, "acquisitionLabel");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelGreaterThan(String value) {
            addCriterion("acquisition_label >", value, "acquisitionLabel");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_label >=", value, "acquisitionLabel");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelLessThan(String value) {
            addCriterion("acquisition_label <", value, "acquisitionLabel");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelLessThanOrEqualTo(String value) {
            addCriterion("acquisition_label <=", value, "acquisitionLabel");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelLike(String value) {
            addCriterion("acquisition_label like", value, "acquisitionLabel");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelNotLike(String value) {
            addCriterion("acquisition_label not like", value, "acquisitionLabel");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelIn(List<String> values) {
            addCriterion("acquisition_label in", values, "acquisitionLabel");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelNotIn(List<String> values) {
            addCriterion("acquisition_label not in", values, "acquisitionLabel");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelBetween(String value1, String value2) {
            addCriterion("acquisition_label between", value1, value2, "acquisitionLabel");
            return (Criteria) this;
        }

        public Criteria andAcquisitionLabelNotBetween(String value1, String value2) {
            addCriterion("acquisition_label not between", value1, value2, "acquisitionLabel");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkIsNull() {
            addCriterion("acquisition_remark is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkIsNotNull() {
            addCriterion("acquisition_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkEqualTo(String value) {
            addCriterion("acquisition_remark =", value, "acquisitionRemark");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkNotEqualTo(String value) {
            addCriterion("acquisition_remark <>", value, "acquisitionRemark");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkGreaterThan(String value) {
            addCriterion("acquisition_remark >", value, "acquisitionRemark");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_remark >=", value, "acquisitionRemark");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkLessThan(String value) {
            addCriterion("acquisition_remark <", value, "acquisitionRemark");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkLessThanOrEqualTo(String value) {
            addCriterion("acquisition_remark <=", value, "acquisitionRemark");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkLike(String value) {
            addCriterion("acquisition_remark like", value, "acquisitionRemark");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkNotLike(String value) {
            addCriterion("acquisition_remark not like", value, "acquisitionRemark");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkIn(List<String> values) {
            addCriterion("acquisition_remark in", values, "acquisitionRemark");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkNotIn(List<String> values) {
            addCriterion("acquisition_remark not in", values, "acquisitionRemark");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkBetween(String value1, String value2) {
            addCriterion("acquisition_remark between", value1, value2, "acquisitionRemark");
            return (Criteria) this;
        }

        public Criteria andAcquisitionRemarkNotBetween(String value1, String value2) {
            addCriterion("acquisition_remark not between", value1, value2, "acquisitionRemark");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPriorityIsNull() {
            addCriterion("acquisition_priority is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPriorityIsNotNull() {
            addCriterion("acquisition_priority is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPriorityEqualTo(Integer value) {
            addCriterion("acquisition_priority =", value, "acquisitionPriority");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPriorityNotEqualTo(Integer value) {
            addCriterion("acquisition_priority <>", value, "acquisitionPriority");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPriorityGreaterThan(Integer value) {
            addCriterion("acquisition_priority >", value, "acquisitionPriority");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("acquisition_priority >=", value, "acquisitionPriority");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPriorityLessThan(Integer value) {
            addCriterion("acquisition_priority <", value, "acquisitionPriority");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("acquisition_priority <=", value, "acquisitionPriority");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPriorityIn(List<Integer> values) {
            addCriterion("acquisition_priority in", values, "acquisitionPriority");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPriorityNotIn(List<Integer> values) {
            addCriterion("acquisition_priority not in", values, "acquisitionPriority");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPriorityBetween(Integer value1, Integer value2) {
            addCriterion("acquisition_priority between", value1, value2, "acquisitionPriority");
            return (Criteria) this;
        }

        public Criteria andAcquisitionPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("acquisition_priority not between", value1, value2, "acquisitionPriority");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateIsNull() {
            addCriterion("acquisition_coordinate is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateIsNotNull() {
            addCriterion("acquisition_coordinate is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateEqualTo(String value) {
            addCriterion("acquisition_coordinate =", value, "acquisitionCoordinate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateNotEqualTo(String value) {
            addCriterion("acquisition_coordinate <>", value, "acquisitionCoordinate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateGreaterThan(String value) {
            addCriterion("acquisition_coordinate >", value, "acquisitionCoordinate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateGreaterThanOrEqualTo(String value) {
            addCriterion("acquisition_coordinate >=", value, "acquisitionCoordinate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateLessThan(String value) {
            addCriterion("acquisition_coordinate <", value, "acquisitionCoordinate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateLessThanOrEqualTo(String value) {
            addCriterion("acquisition_coordinate <=", value, "acquisitionCoordinate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateLike(String value) {
            addCriterion("acquisition_coordinate like", value, "acquisitionCoordinate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateNotLike(String value) {
            addCriterion("acquisition_coordinate not like", value, "acquisitionCoordinate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateIn(List<String> values) {
            addCriterion("acquisition_coordinate in", values, "acquisitionCoordinate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateNotIn(List<String> values) {
            addCriterion("acquisition_coordinate not in", values, "acquisitionCoordinate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateBetween(String value1, String value2) {
            addCriterion("acquisition_coordinate between", value1, value2, "acquisitionCoordinate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCoordinateNotBetween(String value1, String value2) {
            addCriterion("acquisition_coordinate not between", value1, value2, "acquisitionCoordinate");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
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

        public Criteria andAcquisitionCollectTypeIsNull() {
            addCriterion("acquisition_collect_type is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCollectTypeIsNotNull() {
            addCriterion("acquisition_collect_type is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCollectTypeEqualTo(Integer value) {
            addCriterion("acquisition_collect_type =", value, "acquisitionCollectType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCollectTypeNotEqualTo(Integer value) {
            addCriterion("acquisition_collect_type <>", value, "acquisitionCollectType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCollectTypeGreaterThan(Integer value) {
            addCriterion("acquisition_collect_type >", value, "acquisitionCollectType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCollectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("acquisition_collect_type >=", value, "acquisitionCollectType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCollectTypeLessThan(Integer value) {
            addCriterion("acquisition_collect_type <", value, "acquisitionCollectType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCollectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("acquisition_collect_type <=", value, "acquisitionCollectType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCollectTypeIn(List<Integer> values) {
            addCriterion("acquisition_collect_type in", values, "acquisitionCollectType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCollectTypeNotIn(List<Integer> values) {
            addCriterion("acquisition_collect_type not in", values, "acquisitionCollectType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCollectTypeBetween(Integer value1, Integer value2) {
            addCriterion("acquisition_collect_type between", value1, value2, "acquisitionCollectType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionCollectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("acquisition_collect_type not between", value1, value2, "acquisitionCollectType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionSampleTypeIsNull() {
            addCriterion("acquisition_sample_type is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionSampleTypeIsNotNull() {
            addCriterion("acquisition_sample_type is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionSampleTypeEqualTo(Integer value) {
            addCriterion("acquisition_sample_type =", value, "acquisitionSampleType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionSampleTypeNotEqualTo(Integer value) {
            addCriterion("acquisition_sample_type <>", value, "acquisitionSampleType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionSampleTypeGreaterThan(Integer value) {
            addCriterion("acquisition_sample_type >", value, "acquisitionSampleType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionSampleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("acquisition_sample_type >=", value, "acquisitionSampleType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionSampleTypeLessThan(Integer value) {
            addCriterion("acquisition_sample_type <", value, "acquisitionSampleType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionSampleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("acquisition_sample_type <=", value, "acquisitionSampleType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionSampleTypeIn(List<Integer> values) {
            addCriterion("acquisition_sample_type in", values, "acquisitionSampleType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionSampleTypeNotIn(List<Integer> values) {
            addCriterion("acquisition_sample_type not in", values, "acquisitionSampleType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionSampleTypeBetween(Integer value1, Integer value2) {
            addCriterion("acquisition_sample_type between", value1, value2, "acquisitionSampleType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionSampleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("acquisition_sample_type not between", value1, value2, "acquisitionSampleType");
            return (Criteria) this;
        }

        public Criteria andProtocolImgIsNull() {
            addCriterion("protocol_img is null");
            return (Criteria) this;
        }

        public Criteria andProtocolImgIsNotNull() {
            addCriterion("protocol_img is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolImgEqualTo(String value) {
            addCriterion("protocol_img =", value, "protocolImg");
            return (Criteria) this;
        }

        public Criteria andProtocolImgNotEqualTo(String value) {
            addCriterion("protocol_img <>", value, "protocolImg");
            return (Criteria) this;
        }

        public Criteria andProtocolImgGreaterThan(String value) {
            addCriterion("protocol_img >", value, "protocolImg");
            return (Criteria) this;
        }

        public Criteria andProtocolImgGreaterThanOrEqualTo(String value) {
            addCriterion("protocol_img >=", value, "protocolImg");
            return (Criteria) this;
        }

        public Criteria andProtocolImgLessThan(String value) {
            addCriterion("protocol_img <", value, "protocolImg");
            return (Criteria) this;
        }

        public Criteria andProtocolImgLessThanOrEqualTo(String value) {
            addCriterion("protocol_img <=", value, "protocolImg");
            return (Criteria) this;
        }

        public Criteria andProtocolImgLike(String value) {
            addCriterion("protocol_img like", value, "protocolImg");
            return (Criteria) this;
        }

        public Criteria andProtocolImgNotLike(String value) {
            addCriterion("protocol_img not like", value, "protocolImg");
            return (Criteria) this;
        }

        public Criteria andProtocolImgIn(List<String> values) {
            addCriterion("protocol_img in", values, "protocolImg");
            return (Criteria) this;
        }

        public Criteria andProtocolImgNotIn(List<String> values) {
            addCriterion("protocol_img not in", values, "protocolImg");
            return (Criteria) this;
        }

        public Criteria andProtocolImgBetween(String value1, String value2) {
            addCriterion("protocol_img between", value1, value2, "protocolImg");
            return (Criteria) this;
        }

        public Criteria andProtocolImgNotBetween(String value1, String value2) {
            addCriterion("protocol_img not between", value1, value2, "protocolImg");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagIsNull() {
            addCriterion("commission_flag is null");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagIsNotNull() {
            addCriterion("commission_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagEqualTo(Integer value) {
            addCriterion("commission_flag =", value, "commissionFlag");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagNotEqualTo(Integer value) {
            addCriterion("commission_flag <>", value, "commissionFlag");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagGreaterThan(Integer value) {
            addCriterion("commission_flag >", value, "commissionFlag");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("commission_flag >=", value, "commissionFlag");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagLessThan(Integer value) {
            addCriterion("commission_flag <", value, "commissionFlag");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagLessThanOrEqualTo(Integer value) {
            addCriterion("commission_flag <=", value, "commissionFlag");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagIn(List<Integer> values) {
            addCriterion("commission_flag in", values, "commissionFlag");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagNotIn(List<Integer> values) {
            addCriterion("commission_flag not in", values, "commissionFlag");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagBetween(Integer value1, Integer value2) {
            addCriterion("commission_flag between", value1, value2, "commissionFlag");
            return (Criteria) this;
        }

        public Criteria andCommissionFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("commission_flag not between", value1, value2, "commissionFlag");
            return (Criteria) this;
        }

        public Criteria andDirectorNameIsNull() {
            addCriterion("director_name is null");
            return (Criteria) this;
        }

        public Criteria andDirectorNameIsNotNull() {
            addCriterion("director_name is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorNameEqualTo(String value) {
            addCriterion("director_name =", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameNotEqualTo(String value) {
            addCriterion("director_name <>", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameGreaterThan(String value) {
            addCriterion("director_name >", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameGreaterThanOrEqualTo(String value) {
            addCriterion("director_name >=", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameLessThan(String value) {
            addCriterion("director_name <", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameLessThanOrEqualTo(String value) {
            addCriterion("director_name <=", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameLike(String value) {
            addCriterion("director_name like", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameNotLike(String value) {
            addCriterion("director_name not like", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameIn(List<String> values) {
            addCriterion("director_name in", values, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameNotIn(List<String> values) {
            addCriterion("director_name not in", values, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameBetween(String value1, String value2) {
            addCriterion("director_name between", value1, value2, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameNotBetween(String value1, String value2) {
            addCriterion("director_name not between", value1, value2, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneIsNull() {
            addCriterion("director_phone is null");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneIsNotNull() {
            addCriterion("director_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneEqualTo(String value) {
            addCriterion("director_phone =", value, "directorPhone");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneNotEqualTo(String value) {
            addCriterion("director_phone <>", value, "directorPhone");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneGreaterThan(String value) {
            addCriterion("director_phone >", value, "directorPhone");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("director_phone >=", value, "directorPhone");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneLessThan(String value) {
            addCriterion("director_phone <", value, "directorPhone");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneLessThanOrEqualTo(String value) {
            addCriterion("director_phone <=", value, "directorPhone");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneLike(String value) {
            addCriterion("director_phone like", value, "directorPhone");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneNotLike(String value) {
            addCriterion("director_phone not like", value, "directorPhone");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneIn(List<String> values) {
            addCriterion("director_phone in", values, "directorPhone");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneNotIn(List<String> values) {
            addCriterion("director_phone not in", values, "directorPhone");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneBetween(String value1, String value2) {
            addCriterion("director_phone between", value1, value2, "directorPhone");
            return (Criteria) this;
        }

        public Criteria andDirectorPhoneNotBetween(String value1, String value2) {
            addCriterion("director_phone not between", value1, value2, "directorPhone");
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

        public Criteria andAcquisitionStatusIsNull() {
            addCriterion("acquisition_status is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionStatusIsNotNull() {
            addCriterion("acquisition_status is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionStatusEqualTo(Integer value) {
            addCriterion("acquisition_status =", value, "acquisitionStatus");
            return (Criteria) this;
        }

        public Criteria andAcquisitionStatusNotEqualTo(Integer value) {
            addCriterion("acquisition_status <>", value, "acquisitionStatus");
            return (Criteria) this;
        }

        public Criteria andAcquisitionStatusGreaterThan(Integer value) {
            addCriterion("acquisition_status >", value, "acquisitionStatus");
            return (Criteria) this;
        }

        public Criteria andAcquisitionStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("acquisition_status >=", value, "acquisitionStatus");
            return (Criteria) this;
        }

        public Criteria andAcquisitionStatusLessThan(Integer value) {
            addCriterion("acquisition_status <", value, "acquisitionStatus");
            return (Criteria) this;
        }

        public Criteria andAcquisitionStatusLessThanOrEqualTo(Integer value) {
            addCriterion("acquisition_status <=", value, "acquisitionStatus");
            return (Criteria) this;
        }

        public Criteria andAcquisitionStatusIn(List<Integer> values) {
            addCriterion("acquisition_status in", values, "acquisitionStatus");
            return (Criteria) this;
        }

        public Criteria andAcquisitionStatusNotIn(List<Integer> values) {
            addCriterion("acquisition_status not in", values, "acquisitionStatus");
            return (Criteria) this;
        }

        public Criteria andAcquisitionStatusBetween(Integer value1, Integer value2) {
            addCriterion("acquisition_status between", value1, value2, "acquisitionStatus");
            return (Criteria) this;
        }

        public Criteria andAcquisitionStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("acquisition_status not between", value1, value2, "acquisitionStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagIsNull() {
            addCriterion("verify_flag is null");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagIsNotNull() {
            addCriterion("verify_flag is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagEqualTo(Integer value) {
            addCriterion("verify_flag =", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagNotEqualTo(Integer value) {
            addCriterion("verify_flag <>", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagGreaterThan(Integer value) {
            addCriterion("verify_flag >", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("verify_flag >=", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagLessThan(Integer value) {
            addCriterion("verify_flag <", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagLessThanOrEqualTo(Integer value) {
            addCriterion("verify_flag <=", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagIn(List<Integer> values) {
            addCriterion("verify_flag in", values, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagNotIn(List<Integer> values) {
            addCriterion("verify_flag not in", values, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagBetween(Integer value1, Integer value2) {
            addCriterion("verify_flag between", value1, value2, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("verify_flag not between", value1, value2, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andLogisticsFlagIsNull() {
            addCriterion("logistics_flag is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsFlagIsNotNull() {
            addCriterion("logistics_flag is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsFlagEqualTo(Integer value) {
            addCriterion("logistics_flag =", value, "logisticsFlag");
            return (Criteria) this;
        }

        public Criteria andLogisticsFlagNotEqualTo(Integer value) {
            addCriterion("logistics_flag <>", value, "logisticsFlag");
            return (Criteria) this;
        }

        public Criteria andLogisticsFlagGreaterThan(Integer value) {
            addCriterion("logistics_flag >", value, "logisticsFlag");
            return (Criteria) this;
        }

        public Criteria andLogisticsFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("logistics_flag >=", value, "logisticsFlag");
            return (Criteria) this;
        }

        public Criteria andLogisticsFlagLessThan(Integer value) {
            addCriterion("logistics_flag <", value, "logisticsFlag");
            return (Criteria) this;
        }

        public Criteria andLogisticsFlagLessThanOrEqualTo(Integer value) {
            addCriterion("logistics_flag <=", value, "logisticsFlag");
            return (Criteria) this;
        }

        public Criteria andLogisticsFlagIn(List<Integer> values) {
            addCriterion("logistics_flag in", values, "logisticsFlag");
            return (Criteria) this;
        }

        public Criteria andLogisticsFlagNotIn(List<Integer> values) {
            addCriterion("logistics_flag not in", values, "logisticsFlag");
            return (Criteria) this;
        }

        public Criteria andLogisticsFlagBetween(Integer value1, Integer value2) {
            addCriterion("logistics_flag between", value1, value2, "logisticsFlag");
            return (Criteria) this;
        }

        public Criteria andLogisticsFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("logistics_flag not between", value1, value2, "logisticsFlag");
            return (Criteria) this;
        }

        public Criteria andAcquisitionTypeIsNull() {
            addCriterion("acquisition_type is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionTypeIsNotNull() {
            addCriterion("acquisition_type is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionTypeEqualTo(Integer value) {
            addCriterion("acquisition_type =", value, "acquisitionType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionTypeNotEqualTo(Integer value) {
            addCriterion("acquisition_type <>", value, "acquisitionType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionTypeGreaterThan(Integer value) {
            addCriterion("acquisition_type >", value, "acquisitionType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("acquisition_type >=", value, "acquisitionType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionTypeLessThan(Integer value) {
            addCriterion("acquisition_type <", value, "acquisitionType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("acquisition_type <=", value, "acquisitionType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionTypeIn(List<Integer> values) {
            addCriterion("acquisition_type in", values, "acquisitionType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionTypeNotIn(List<Integer> values) {
            addCriterion("acquisition_type not in", values, "acquisitionType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionTypeBetween(Integer value1, Integer value2) {
            addCriterion("acquisition_type between", value1, value2, "acquisitionType");
            return (Criteria) this;
        }

        public Criteria andAcquisitionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("acquisition_type not between", value1, value2, "acquisitionType");
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