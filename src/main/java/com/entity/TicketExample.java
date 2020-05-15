package com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketExample() {
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

        public Criteria andLineIdIsNull() {
            addCriterion("line_id is null");
            return (Criteria) this;
        }

        public Criteria andLineIdIsNotNull() {
            addCriterion("line_id is not null");
            return (Criteria) this;
        }

        public Criteria andLineIdEqualTo(Integer value) {
            addCriterion("line_id =", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotEqualTo(Integer value) {
            addCriterion("line_id <>", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdGreaterThan(Integer value) {
            addCriterion("line_id >", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("line_id >=", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLessThan(Integer value) {
            addCriterion("line_id <", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLessThanOrEqualTo(Integer value) {
            addCriterion("line_id <=", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdIn(List<Integer> values) {
            addCriterion("line_id in", values, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotIn(List<Integer> values) {
            addCriterion("line_id not in", values, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdBetween(Integer value1, Integer value2) {
            addCriterion("line_id between", value1, value2, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotBetween(Integer value1, Integer value2) {
            addCriterion("line_id not between", value1, value2, "lineId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andSaleStartTimeIsNull() {
            addCriterion("sale_start_time is null");
            return (Criteria) this;
        }

        public Criteria andSaleStartTimeIsNotNull() {
            addCriterion("sale_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andSaleStartTimeEqualTo(Date value) {
            addCriterion("sale_start_time =", value, "saleStartTime");
            return (Criteria) this;
        }

        public Criteria andSaleStartTimeNotEqualTo(Date value) {
            addCriterion("sale_start_time <>", value, "saleStartTime");
            return (Criteria) this;
        }

        public Criteria andSaleStartTimeGreaterThan(Date value) {
            addCriterion("sale_start_time >", value, "saleStartTime");
            return (Criteria) this;
        }

        public Criteria andSaleStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sale_start_time >=", value, "saleStartTime");
            return (Criteria) this;
        }

        public Criteria andSaleStartTimeLessThan(Date value) {
            addCriterion("sale_start_time <", value, "saleStartTime");
            return (Criteria) this;
        }

        public Criteria andSaleStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("sale_start_time <=", value, "saleStartTime");
            return (Criteria) this;
        }

        public Criteria andSaleStartTimeIn(List<Date> values) {
            addCriterion("sale_start_time in", values, "saleStartTime");
            return (Criteria) this;
        }

        public Criteria andSaleStartTimeNotIn(List<Date> values) {
            addCriterion("sale_start_time not in", values, "saleStartTime");
            return (Criteria) this;
        }

        public Criteria andSaleStartTimeBetween(Date value1, Date value2) {
            addCriterion("sale_start_time between", value1, value2, "saleStartTime");
            return (Criteria) this;
        }

        public Criteria andSaleStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("sale_start_time not between", value1, value2, "saleStartTime");
            return (Criteria) this;
        }

        public Criteria andSaleEndTimeIsNull() {
            addCriterion("sale_end_time is null");
            return (Criteria) this;
        }

        public Criteria andSaleEndTimeIsNotNull() {
            addCriterion("sale_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andSaleEndTimeEqualTo(Date value) {
            addCriterion("sale_end_time =", value, "saleEndTime");
            return (Criteria) this;
        }

        public Criteria andSaleEndTimeNotEqualTo(Date value) {
            addCriterion("sale_end_time <>", value, "saleEndTime");
            return (Criteria) this;
        }

        public Criteria andSaleEndTimeGreaterThan(Date value) {
            addCriterion("sale_end_time >", value, "saleEndTime");
            return (Criteria) this;
        }

        public Criteria andSaleEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sale_end_time >=", value, "saleEndTime");
            return (Criteria) this;
        }

        public Criteria andSaleEndTimeLessThan(Date value) {
            addCriterion("sale_end_time <", value, "saleEndTime");
            return (Criteria) this;
        }

        public Criteria andSaleEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("sale_end_time <=", value, "saleEndTime");
            return (Criteria) this;
        }

        public Criteria andSaleEndTimeIn(List<Date> values) {
            addCriterion("sale_end_time in", values, "saleEndTime");
            return (Criteria) this;
        }

        public Criteria andSaleEndTimeNotIn(List<Date> values) {
            addCriterion("sale_end_time not in", values, "saleEndTime");
            return (Criteria) this;
        }

        public Criteria andSaleEndTimeBetween(Date value1, Date value2) {
            addCriterion("sale_end_time between", value1, value2, "saleEndTime");
            return (Criteria) this;
        }

        public Criteria andSaleEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("sale_end_time not between", value1, value2, "saleEndTime");
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