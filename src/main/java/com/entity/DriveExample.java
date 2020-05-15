package com.entity;

import java.util.ArrayList;
import java.util.List;

public class DriveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DriveExample() {
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

        public Criteria andDriverNameIsNull() {
            addCriterion("driver_name is null");
            return (Criteria) this;
        }

        public Criteria andDriverNameIsNotNull() {
            addCriterion("driver_name is not null");
            return (Criteria) this;
        }

        public Criteria andDriverNameEqualTo(String value) {
            addCriterion("driver_name =", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotEqualTo(String value) {
            addCriterion("driver_name <>", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameGreaterThan(String value) {
            addCriterion("driver_name >", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameGreaterThanOrEqualTo(String value) {
            addCriterion("driver_name >=", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameLessThan(String value) {
            addCriterion("driver_name <", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameLessThanOrEqualTo(String value) {
            addCriterion("driver_name <=", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameLike(String value) {
            addCriterion("driver_name like", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotLike(String value) {
            addCriterion("driver_name not like", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameIn(List<String> values) {
            addCriterion("driver_name in", values, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotIn(List<String> values) {
            addCriterion("driver_name not in", values, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameBetween(String value1, String value2) {
            addCriterion("driver_name between", value1, value2, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotBetween(String value1, String value2) {
            addCriterion("driver_name not between", value1, value2, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriveAgeIsNull() {
            addCriterion("drive_age is null");
            return (Criteria) this;
        }

        public Criteria andDriveAgeIsNotNull() {
            addCriterion("drive_age is not null");
            return (Criteria) this;
        }

        public Criteria andDriveAgeEqualTo(String value) {
            addCriterion("drive_age =", value, "driveAge");
            return (Criteria) this;
        }

        public Criteria andDriveAgeNotEqualTo(String value) {
            addCriterion("drive_age <>", value, "driveAge");
            return (Criteria) this;
        }

        public Criteria andDriveAgeGreaterThan(String value) {
            addCriterion("drive_age >", value, "driveAge");
            return (Criteria) this;
        }

        public Criteria andDriveAgeGreaterThanOrEqualTo(String value) {
            addCriterion("drive_age >=", value, "driveAge");
            return (Criteria) this;
        }

        public Criteria andDriveAgeLessThan(String value) {
            addCriterion("drive_age <", value, "driveAge");
            return (Criteria) this;
        }

        public Criteria andDriveAgeLessThanOrEqualTo(String value) {
            addCriterion("drive_age <=", value, "driveAge");
            return (Criteria) this;
        }

        public Criteria andDriveAgeLike(String value) {
            addCriterion("drive_age like", value, "driveAge");
            return (Criteria) this;
        }

        public Criteria andDriveAgeNotLike(String value) {
            addCriterion("drive_age not like", value, "driveAge");
            return (Criteria) this;
        }

        public Criteria andDriveAgeIn(List<String> values) {
            addCriterion("drive_age in", values, "driveAge");
            return (Criteria) this;
        }

        public Criteria andDriveAgeNotIn(List<String> values) {
            addCriterion("drive_age not in", values, "driveAge");
            return (Criteria) this;
        }

        public Criteria andDriveAgeBetween(String value1, String value2) {
            addCriterion("drive_age between", value1, value2, "driveAge");
            return (Criteria) this;
        }

        public Criteria andDriveAgeNotBetween(String value1, String value2) {
            addCriterion("drive_age not between", value1, value2, "driveAge");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNull() {
            addCriterion("capacity is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(String value) {
            addCriterion("capacity =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(String value) {
            addCriterion("capacity <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(String value) {
            addCriterion("capacity >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("capacity >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(String value) {
            addCriterion("capacity <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(String value) {
            addCriterion("capacity <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLike(String value) {
            addCriterion("capacity like", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotLike(String value) {
            addCriterion("capacity not like", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<String> values) {
            addCriterion("capacity in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<String> values) {
            addCriterion("capacity not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(String value1, String value2) {
            addCriterion("capacity between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(String value1, String value2) {
            addCriterion("capacity not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andDriveNumberIsNull() {
            addCriterion("drive_number is null");
            return (Criteria) this;
        }

        public Criteria andDriveNumberIsNotNull() {
            addCriterion("drive_number is not null");
            return (Criteria) this;
        }

        public Criteria andDriveNumberEqualTo(String value) {
            addCriterion("drive_number =", value, "driveNumber");
            return (Criteria) this;
        }

        public Criteria andDriveNumberNotEqualTo(String value) {
            addCriterion("drive_number <>", value, "driveNumber");
            return (Criteria) this;
        }

        public Criteria andDriveNumberGreaterThan(String value) {
            addCriterion("drive_number >", value, "driveNumber");
            return (Criteria) this;
        }

        public Criteria andDriveNumberGreaterThanOrEqualTo(String value) {
            addCriterion("drive_number >=", value, "driveNumber");
            return (Criteria) this;
        }

        public Criteria andDriveNumberLessThan(String value) {
            addCriterion("drive_number <", value, "driveNumber");
            return (Criteria) this;
        }

        public Criteria andDriveNumberLessThanOrEqualTo(String value) {
            addCriterion("drive_number <=", value, "driveNumber");
            return (Criteria) this;
        }

        public Criteria andDriveNumberLike(String value) {
            addCriterion("drive_number like", value, "driveNumber");
            return (Criteria) this;
        }

        public Criteria andDriveNumberNotLike(String value) {
            addCriterion("drive_number not like", value, "driveNumber");
            return (Criteria) this;
        }

        public Criteria andDriveNumberIn(List<String> values) {
            addCriterion("drive_number in", values, "driveNumber");
            return (Criteria) this;
        }

        public Criteria andDriveNumberNotIn(List<String> values) {
            addCriterion("drive_number not in", values, "driveNumber");
            return (Criteria) this;
        }

        public Criteria andDriveNumberBetween(String value1, String value2) {
            addCriterion("drive_number between", value1, value2, "driveNumber");
            return (Criteria) this;
        }

        public Criteria andDriveNumberNotBetween(String value1, String value2) {
            addCriterion("drive_number not between", value1, value2, "driveNumber");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityIsNull() {
            addCriterion("empty_capacity is null");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityIsNotNull() {
            addCriterion("empty_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityEqualTo(String value) {
            addCriterion("empty_capacity =", value, "emptyCapacity");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityNotEqualTo(String value) {
            addCriterion("empty_capacity <>", value, "emptyCapacity");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityGreaterThan(String value) {
            addCriterion("empty_capacity >", value, "emptyCapacity");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("empty_capacity >=", value, "emptyCapacity");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityLessThan(String value) {
            addCriterion("empty_capacity <", value, "emptyCapacity");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityLessThanOrEqualTo(String value) {
            addCriterion("empty_capacity <=", value, "emptyCapacity");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityLike(String value) {
            addCriterion("empty_capacity like", value, "emptyCapacity");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityNotLike(String value) {
            addCriterion("empty_capacity not like", value, "emptyCapacity");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityIn(List<String> values) {
            addCriterion("empty_capacity in", values, "emptyCapacity");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityNotIn(List<String> values) {
            addCriterion("empty_capacity not in", values, "emptyCapacity");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityBetween(String value1, String value2) {
            addCriterion("empty_capacity between", value1, value2, "emptyCapacity");
            return (Criteria) this;
        }

        public Criteria andEmptyCapacityNotBetween(String value1, String value2) {
            addCriterion("empty_capacity not between", value1, value2, "emptyCapacity");
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