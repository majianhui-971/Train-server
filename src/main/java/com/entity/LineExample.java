package com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LineExample() {
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

        public Criteria andStartSiteIsNull() {
            addCriterion("start_site is null");
            return (Criteria) this;
        }

        public Criteria andStartSiteIsNotNull() {
            addCriterion("start_site is not null");
            return (Criteria) this;
        }

        public Criteria andStartSiteEqualTo(String value) {
            addCriterion("start_site =", value, "startSite");
            return (Criteria) this;
        }

        public Criteria andStartSiteNotEqualTo(String value) {
            addCriterion("start_site <>", value, "startSite");
            return (Criteria) this;
        }

        public Criteria andStartSiteGreaterThan(String value) {
            addCriterion("start_site >", value, "startSite");
            return (Criteria) this;
        }

        public Criteria andStartSiteGreaterThanOrEqualTo(String value) {
            addCriterion("start_site >=", value, "startSite");
            return (Criteria) this;
        }

        public Criteria andStartSiteLessThan(String value) {
            addCriterion("start_site <", value, "startSite");
            return (Criteria) this;
        }

        public Criteria andStartSiteLessThanOrEqualTo(String value) {
            addCriterion("start_site <=", value, "startSite");
            return (Criteria) this;
        }

        public Criteria andStartSiteLike(String value) {
            addCriterion("start_site like", value, "startSite");
            return (Criteria) this;
        }

        public Criteria andStartSiteNotLike(String value) {
            addCriterion("start_site not like", value, "startSite");
            return (Criteria) this;
        }

        public Criteria andStartSiteIn(List<String> values) {
            addCriterion("start_site in", values, "startSite");
            return (Criteria) this;
        }

        public Criteria andStartSiteNotIn(List<String> values) {
            addCriterion("start_site not in", values, "startSite");
            return (Criteria) this;
        }

        public Criteria andStartSiteBetween(String value1, String value2) {
            addCriterion("start_site between", value1, value2, "startSite");
            return (Criteria) this;
        }

        public Criteria andStartSiteNotBetween(String value1, String value2) {
            addCriterion("start_site not between", value1, value2, "startSite");
            return (Criteria) this;
        }

        public Criteria andEndSiteIsNull() {
            addCriterion("end_site is null");
            return (Criteria) this;
        }

        public Criteria andEndSiteIsNotNull() {
            addCriterion("end_site is not null");
            return (Criteria) this;
        }

        public Criteria andEndSiteEqualTo(String value) {
            addCriterion("end_site =", value, "endSite");
            return (Criteria) this;
        }

        public Criteria andEndSiteNotEqualTo(String value) {
            addCriterion("end_site <>", value, "endSite");
            return (Criteria) this;
        }

        public Criteria andEndSiteGreaterThan(String value) {
            addCriterion("end_site >", value, "endSite");
            return (Criteria) this;
        }

        public Criteria andEndSiteGreaterThanOrEqualTo(String value) {
            addCriterion("end_site >=", value, "endSite");
            return (Criteria) this;
        }

        public Criteria andEndSiteLessThan(String value) {
            addCriterion("end_site <", value, "endSite");
            return (Criteria) this;
        }

        public Criteria andEndSiteLessThanOrEqualTo(String value) {
            addCriterion("end_site <=", value, "endSite");
            return (Criteria) this;
        }

        public Criteria andEndSiteLike(String value) {
            addCriterion("end_site like", value, "endSite");
            return (Criteria) this;
        }

        public Criteria andEndSiteNotLike(String value) {
            addCriterion("end_site not like", value, "endSite");
            return (Criteria) this;
        }

        public Criteria andEndSiteIn(List<String> values) {
            addCriterion("end_site in", values, "endSite");
            return (Criteria) this;
        }

        public Criteria andEndSiteNotIn(List<String> values) {
            addCriterion("end_site not in", values, "endSite");
            return (Criteria) this;
        }

        public Criteria andEndSiteBetween(String value1, String value2) {
            addCriterion("end_site between", value1, value2, "endSite");
            return (Criteria) this;
        }

        public Criteria andEndSiteNotBetween(String value1, String value2) {
            addCriterion("end_site not between", value1, value2, "endSite");
            return (Criteria) this;
        }

        public Criteria andPassSiteIsNull() {
            addCriterion("pass_site is null");
            return (Criteria) this;
        }

        public Criteria andPassSiteIsNotNull() {
            addCriterion("pass_site is not null");
            return (Criteria) this;
        }

        public Criteria andPassSiteEqualTo(String value) {
            addCriterion("pass_site =", value, "passSite");
            return (Criteria) this;
        }

        public Criteria andPassSiteNotEqualTo(String value) {
            addCriterion("pass_site <>", value, "passSite");
            return (Criteria) this;
        }

        public Criteria andPassSiteGreaterThan(String value) {
            addCriterion("pass_site >", value, "passSite");
            return (Criteria) this;
        }

        public Criteria andPassSiteGreaterThanOrEqualTo(String value) {
            addCriterion("pass_site >=", value, "passSite");
            return (Criteria) this;
        }

        public Criteria andPassSiteLessThan(String value) {
            addCriterion("pass_site <", value, "passSite");
            return (Criteria) this;
        }

        public Criteria andPassSiteLessThanOrEqualTo(String value) {
            addCriterion("pass_site <=", value, "passSite");
            return (Criteria) this;
        }

        public Criteria andPassSiteLike(String value) {
            addCriterion("pass_site like", value, "passSite");
            return (Criteria) this;
        }

        public Criteria andPassSiteNotLike(String value) {
            addCriterion("pass_site not like", value, "passSite");
            return (Criteria) this;
        }

        public Criteria andPassSiteIn(List<String> values) {
            addCriterion("pass_site in", values, "passSite");
            return (Criteria) this;
        }

        public Criteria andPassSiteNotIn(List<String> values) {
            addCriterion("pass_site not in", values, "passSite");
            return (Criteria) this;
        }

        public Criteria andPassSiteBetween(String value1, String value2) {
            addCriterion("pass_site between", value1, value2, "passSite");
            return (Criteria) this;
        }

        public Criteria andPassSiteNotBetween(String value1, String value2) {
            addCriterion("pass_site not between", value1, value2, "passSite");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeIsNull() {
            addCriterion("offset_time is null");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeIsNotNull() {
            addCriterion("offset_time is not null");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeEqualTo(String value) {
            addCriterion("offset_time =", value, "offsetTime");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeNotEqualTo(String value) {
            addCriterion("offset_time <>", value, "offsetTime");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeGreaterThan(String value) {
            addCriterion("offset_time >", value, "offsetTime");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeGreaterThanOrEqualTo(String value) {
            addCriterion("offset_time >=", value, "offsetTime");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeLessThan(String value) {
            addCriterion("offset_time <", value, "offsetTime");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeLessThanOrEqualTo(String value) {
            addCriterion("offset_time <=", value, "offsetTime");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeLike(String value) {
            addCriterion("offset_time like", value, "offsetTime");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeNotLike(String value) {
            addCriterion("offset_time not like", value, "offsetTime");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeIn(List<String> values) {
            addCriterion("offset_time in", values, "offsetTime");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeNotIn(List<String> values) {
            addCriterion("offset_time not in", values, "offsetTime");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeBetween(String value1, String value2) {
            addCriterion("offset_time between", value1, value2, "offsetTime");
            return (Criteria) this;
        }

        public Criteria andOffsetTimeNotBetween(String value1, String value2) {
            addCriterion("offset_time not between", value1, value2, "offsetTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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