package com.tclab.weixinappletservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppletPackageSourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppletPackageSourceExample() {
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

        public Criteria andPackageSourceRemarkIsNull() {
            addCriterion("package_source_remark is null");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkIsNotNull() {
            addCriterion("package_source_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkEqualTo(String value) {
            addCriterion("package_source_remark =", value, "packageSourceRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkNotEqualTo(String value) {
            addCriterion("package_source_remark <>", value, "packageSourceRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkGreaterThan(String value) {
            addCriterion("package_source_remark >", value, "packageSourceRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("package_source_remark >=", value, "packageSourceRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkLessThan(String value) {
            addCriterion("package_source_remark <", value, "packageSourceRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkLessThanOrEqualTo(String value) {
            addCriterion("package_source_remark <=", value, "packageSourceRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkLike(String value) {
            addCriterion("package_source_remark like", value, "packageSourceRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkNotLike(String value) {
            addCriterion("package_source_remark not like", value, "packageSourceRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkIn(List<String> values) {
            addCriterion("package_source_remark in", values, "packageSourceRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkNotIn(List<String> values) {
            addCriterion("package_source_remark not in", values, "packageSourceRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkBetween(String value1, String value2) {
            addCriterion("package_source_remark between", value1, value2, "packageSourceRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceRemarkNotBetween(String value1, String value2) {
            addCriterion("package_source_remark not between", value1, value2, "packageSourceRemark");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorIsNull() {
            addCriterion("package_source_director is null");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorIsNotNull() {
            addCriterion("package_source_director is not null");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorEqualTo(String value) {
            addCriterion("package_source_director =", value, "packageSourceDirector");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorNotEqualTo(String value) {
            addCriterion("package_source_director <>", value, "packageSourceDirector");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorGreaterThan(String value) {
            addCriterion("package_source_director >", value, "packageSourceDirector");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorGreaterThanOrEqualTo(String value) {
            addCriterion("package_source_director >=", value, "packageSourceDirector");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorLessThan(String value) {
            addCriterion("package_source_director <", value, "packageSourceDirector");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorLessThanOrEqualTo(String value) {
            addCriterion("package_source_director <=", value, "packageSourceDirector");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorLike(String value) {
            addCriterion("package_source_director like", value, "packageSourceDirector");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorNotLike(String value) {
            addCriterion("package_source_director not like", value, "packageSourceDirector");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorIn(List<String> values) {
            addCriterion("package_source_director in", values, "packageSourceDirector");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorNotIn(List<String> values) {
            addCriterion("package_source_director not in", values, "packageSourceDirector");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorBetween(String value1, String value2) {
            addCriterion("package_source_director between", value1, value2, "packageSourceDirector");
            return (Criteria) this;
        }

        public Criteria andPackageSourceDirectorNotBetween(String value1, String value2) {
            addCriterion("package_source_director not between", value1, value2, "packageSourceDirector");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneIsNull() {
            addCriterion("package_source_phone is null");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneIsNotNull() {
            addCriterion("package_source_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneEqualTo(String value) {
            addCriterion("package_source_phone =", value, "packageSourcePhone");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneNotEqualTo(String value) {
            addCriterion("package_source_phone <>", value, "packageSourcePhone");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneGreaterThan(String value) {
            addCriterion("package_source_phone >", value, "packageSourcePhone");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("package_source_phone >=", value, "packageSourcePhone");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneLessThan(String value) {
            addCriterion("package_source_phone <", value, "packageSourcePhone");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneLessThanOrEqualTo(String value) {
            addCriterion("package_source_phone <=", value, "packageSourcePhone");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneLike(String value) {
            addCriterion("package_source_phone like", value, "packageSourcePhone");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneNotLike(String value) {
            addCriterion("package_source_phone not like", value, "packageSourcePhone");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneIn(List<String> values) {
            addCriterion("package_source_phone in", values, "packageSourcePhone");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneNotIn(List<String> values) {
            addCriterion("package_source_phone not in", values, "packageSourcePhone");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneBetween(String value1, String value2) {
            addCriterion("package_source_phone between", value1, value2, "packageSourcePhone");
            return (Criteria) this;
        }

        public Criteria andPackageSourcePhoneNotBetween(String value1, String value2) {
            addCriterion("package_source_phone not between", value1, value2, "packageSourcePhone");
            return (Criteria) this;
        }

        public Criteria andPackageSourceStatusIsNull() {
            addCriterion("package_source_status is null");
            return (Criteria) this;
        }

        public Criteria andPackageSourceStatusIsNotNull() {
            addCriterion("package_source_status is not null");
            return (Criteria) this;
        }

        public Criteria andPackageSourceStatusEqualTo(Integer value) {
            addCriterion("package_source_status =", value, "packageSourceStatus");
            return (Criteria) this;
        }

        public Criteria andPackageSourceStatusNotEqualTo(Integer value) {
            addCriterion("package_source_status <>", value, "packageSourceStatus");
            return (Criteria) this;
        }

        public Criteria andPackageSourceStatusGreaterThan(Integer value) {
            addCriterion("package_source_status >", value, "packageSourceStatus");
            return (Criteria) this;
        }

        public Criteria andPackageSourceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_source_status >=", value, "packageSourceStatus");
            return (Criteria) this;
        }

        public Criteria andPackageSourceStatusLessThan(Integer value) {
            addCriterion("package_source_status <", value, "packageSourceStatus");
            return (Criteria) this;
        }

        public Criteria andPackageSourceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("package_source_status <=", value, "packageSourceStatus");
            return (Criteria) this;
        }

        public Criteria andPackageSourceStatusIn(List<Integer> values) {
            addCriterion("package_source_status in", values, "packageSourceStatus");
            return (Criteria) this;
        }

        public Criteria andPackageSourceStatusNotIn(List<Integer> values) {
            addCriterion("package_source_status not in", values, "packageSourceStatus");
            return (Criteria) this;
        }

        public Criteria andPackageSourceStatusBetween(Integer value1, Integer value2) {
            addCriterion("package_source_status between", value1, value2, "packageSourceStatus");
            return (Criteria) this;
        }

        public Criteria andPackageSourceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("package_source_status not between", value1, value2, "packageSourceStatus");
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

        public Criteria andSourcePicIsNull() {
            addCriterion("source_pic is null");
            return (Criteria) this;
        }

        public Criteria andSourcePicIsNotNull() {
            addCriterion("source_pic is not null");
            return (Criteria) this;
        }

        public Criteria andSourcePicEqualTo(String value) {
            addCriterion("source_pic =", value, "sourcePic");
            return (Criteria) this;
        }

        public Criteria andSourcePicNotEqualTo(String value) {
            addCriterion("source_pic <>", value, "sourcePic");
            return (Criteria) this;
        }

        public Criteria andSourcePicGreaterThan(String value) {
            addCriterion("source_pic >", value, "sourcePic");
            return (Criteria) this;
        }

        public Criteria andSourcePicGreaterThanOrEqualTo(String value) {
            addCriterion("source_pic >=", value, "sourcePic");
            return (Criteria) this;
        }

        public Criteria andSourcePicLessThan(String value) {
            addCriterion("source_pic <", value, "sourcePic");
            return (Criteria) this;
        }

        public Criteria andSourcePicLessThanOrEqualTo(String value) {
            addCriterion("source_pic <=", value, "sourcePic");
            return (Criteria) this;
        }

        public Criteria andSourcePicLike(String value) {
            addCriterion("source_pic like", value, "sourcePic");
            return (Criteria) this;
        }

        public Criteria andSourcePicNotLike(String value) {
            addCriterion("source_pic not like", value, "sourcePic");
            return (Criteria) this;
        }

        public Criteria andSourcePicIn(List<String> values) {
            addCriterion("source_pic in", values, "sourcePic");
            return (Criteria) this;
        }

        public Criteria andSourcePicNotIn(List<String> values) {
            addCriterion("source_pic not in", values, "sourcePic");
            return (Criteria) this;
        }

        public Criteria andSourcePicBetween(String value1, String value2) {
            addCriterion("source_pic between", value1, value2, "sourcePic");
            return (Criteria) this;
        }

        public Criteria andSourcePicNotBetween(String value1, String value2) {
            addCriterion("source_pic not between", value1, value2, "sourcePic");
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