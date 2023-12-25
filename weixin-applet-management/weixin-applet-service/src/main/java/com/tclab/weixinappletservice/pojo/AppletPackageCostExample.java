package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletPackageCostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletPackageCostExample() {
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

        public Criteria andCommissionTypeIsNull() {
            addCriterion("commission_type is null");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeIsNotNull() {
            addCriterion("commission_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeEqualTo(Integer value) {
            addCriterion("commission_type =", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeNotEqualTo(Integer value) {
            addCriterion("commission_type <>", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeGreaterThan(Integer value) {
            addCriterion("commission_type >", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("commission_type >=", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeLessThan(Integer value) {
            addCriterion("commission_type <", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("commission_type <=", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeIn(List<Integer> values) {
            addCriterion("commission_type in", values, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeNotIn(List<Integer> values) {
            addCriterion("commission_type not in", values, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeBetween(Integer value1, Integer value2) {
            addCriterion("commission_type between", value1, value2, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("commission_type not between", value1, value2, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeIsNull() {
            addCriterion("cost_acquisition_charge is null");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeIsNotNull() {
            addCriterion("cost_acquisition_charge is not null");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeEqualTo(BigDecimal value) {
            addCriterion("cost_acquisition_charge =", value, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeNotEqualTo(BigDecimal value) {
            addCriterion("cost_acquisition_charge <>", value, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeGreaterThan(BigDecimal value) {
            addCriterion("cost_acquisition_charge >", value, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_acquisition_charge >=", value, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeLessThan(BigDecimal value) {
            addCriterion("cost_acquisition_charge <", value, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_acquisition_charge <=", value, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeIn(List<BigDecimal> values) {
            addCriterion("cost_acquisition_charge in", values, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeNotIn(List<BigDecimal> values) {
            addCriterion("cost_acquisition_charge not in", values, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_acquisition_charge between", value1, value2, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostAcquisitionChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_acquisition_charge not between", value1, value2, "costAcquisitionCharge");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionIsNull() {
            addCriterion("cost_staff_commission is null");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionIsNotNull() {
            addCriterion("cost_staff_commission is not null");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionEqualTo(Float value) {
            addCriterion("cost_staff_commission =", value, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionNotEqualTo(Float value) {
            addCriterion("cost_staff_commission <>", value, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionGreaterThan(Float value) {
            addCriterion("cost_staff_commission >", value, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionGreaterThanOrEqualTo(Float value) {
            addCriterion("cost_staff_commission >=", value, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionLessThan(Float value) {
            addCriterion("cost_staff_commission <", value, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionLessThanOrEqualTo(Float value) {
            addCriterion("cost_staff_commission <=", value, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionIn(List<Float> values) {
            addCriterion("cost_staff_commission in", values, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionNotIn(List<Float> values) {
            addCriterion("cost_staff_commission not in", values, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionBetween(Float value1, Float value2) {
            addCriterion("cost_staff_commission between", value1, value2, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostStaffCommissionNotBetween(Float value1, Float value2) {
            addCriterion("cost_staff_commission not between", value1, value2, "costStaffCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionIsNull() {
            addCriterion("cost_department_commission is null");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionIsNotNull() {
            addCriterion("cost_department_commission is not null");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionEqualTo(String value) {
            addCriterion("cost_department_commission =", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionNotEqualTo(String value) {
            addCriterion("cost_department_commission <>", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionGreaterThan(String value) {
            addCriterion("cost_department_commission >", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionGreaterThanOrEqualTo(String value) {
            addCriterion("cost_department_commission >=", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionLessThan(String value) {
            addCriterion("cost_department_commission <", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionLessThanOrEqualTo(String value) {
            addCriterion("cost_department_commission <=", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionLike(String value) {
            addCriterion("cost_department_commission like", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionNotLike(String value) {
            addCriterion("cost_department_commission not like", value, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionIn(List<String> values) {
            addCriterion("cost_department_commission in", values, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionNotIn(List<String> values) {
            addCriterion("cost_department_commission not in", values, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionBetween(String value1, String value2) {
            addCriterion("cost_department_commission between", value1, value2, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostDepartmentCommissionNotBetween(String value1, String value2) {
            addCriterion("cost_department_commission not between", value1, value2, "costDepartmentCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionIsNull() {
            addCriterion("cost_organization_commission is null");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionIsNotNull() {
            addCriterion("cost_organization_commission is not null");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionEqualTo(Float value) {
            addCriterion("cost_organization_commission =", value, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionNotEqualTo(Float value) {
            addCriterion("cost_organization_commission <>", value, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionGreaterThan(Float value) {
            addCriterion("cost_organization_commission >", value, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionGreaterThanOrEqualTo(Float value) {
            addCriterion("cost_organization_commission >=", value, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionLessThan(Float value) {
            addCriterion("cost_organization_commission <", value, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionLessThanOrEqualTo(Float value) {
            addCriterion("cost_organization_commission <=", value, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionIn(List<Float> values) {
            addCriterion("cost_organization_commission in", values, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionNotIn(List<Float> values) {
            addCriterion("cost_organization_commission not in", values, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionBetween(Float value1, Float value2) {
            addCriterion("cost_organization_commission between", value1, value2, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andCostOrganizationCommissionNotBetween(Float value1, Float value2) {
            addCriterion("cost_organization_commission not between", value1, value2, "costOrganizationCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionIsNull() {
            addCriterion("platform_commission is null");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionIsNotNull() {
            addCriterion("platform_commission is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionEqualTo(Float value) {
            addCriterion("platform_commission =", value, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionNotEqualTo(Float value) {
            addCriterion("platform_commission <>", value, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionGreaterThan(Float value) {
            addCriterion("platform_commission >", value, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionGreaterThanOrEqualTo(Float value) {
            addCriterion("platform_commission >=", value, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionLessThan(Float value) {
            addCriterion("platform_commission <", value, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionLessThanOrEqualTo(Float value) {
            addCriterion("platform_commission <=", value, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionIn(List<Float> values) {
            addCriterion("platform_commission in", values, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionNotIn(List<Float> values) {
            addCriterion("platform_commission not in", values, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionBetween(Float value1, Float value2) {
            addCriterion("platform_commission between", value1, value2, "platformCommission");
            return (Criteria) this;
        }

        public Criteria andPlatformCommissionNotBetween(Float value1, Float value2) {
            addCriterion("platform_commission not between", value1, value2, "platformCommission");
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