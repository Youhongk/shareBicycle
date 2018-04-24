package com.gduf.sbcms.entity;

import java.util.ArrayList;
import java.util.List;

public class BicycleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BicycleExample() {
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

        public Criteria andBicycleIdIsNull() {
            addCriterion("bicycle_id is null");
            return (Criteria) this;
        }

        public Criteria andBicycleIdIsNotNull() {
            addCriterion("bicycle_id is not null");
            return (Criteria) this;
        }

        public Criteria andBicycleIdEqualTo(Integer value) {
            addCriterion("bicycle_id =", value, "bicycleId");
            return (Criteria) this;
        }

        public Criteria andBicycleIdNotEqualTo(Integer value) {
            addCriterion("bicycle_id <>", value, "bicycleId");
            return (Criteria) this;
        }

        public Criteria andBicycleIdGreaterThan(Integer value) {
            addCriterion("bicycle_id >", value, "bicycleId");
            return (Criteria) this;
        }

        public Criteria andBicycleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bicycle_id >=", value, "bicycleId");
            return (Criteria) this;
        }

        public Criteria andBicycleIdLessThan(Integer value) {
            addCriterion("bicycle_id <", value, "bicycleId");
            return (Criteria) this;
        }

        public Criteria andBicycleIdLessThanOrEqualTo(Integer value) {
            addCriterion("bicycle_id <=", value, "bicycleId");
            return (Criteria) this;
        }

        public Criteria andBicycleIdIn(List<Integer> values) {
            addCriterion("bicycle_id in", values, "bicycleId");
            return (Criteria) this;
        }

        public Criteria andBicycleIdNotIn(List<Integer> values) {
            addCriterion("bicycle_id not in", values, "bicycleId");
            return (Criteria) this;
        }

        public Criteria andBicycleIdBetween(Integer value1, Integer value2) {
            addCriterion("bicycle_id between", value1, value2, "bicycleId");
            return (Criteria) this;
        }

        public Criteria andBicycleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bicycle_id not between", value1, value2, "bicycleId");
            return (Criteria) this;
        }

        public Criteria andBicycleStatusIsNull() {
            addCriterion("bicycle_status is null");
            return (Criteria) this;
        }

        public Criteria andBicycleStatusIsNotNull() {
            addCriterion("bicycle_status is not null");
            return (Criteria) this;
        }

        public Criteria andBicycleStatusEqualTo(Integer value) {
            addCriterion("bicycle_status =", value, "bicycleStatus");
            return (Criteria) this;
        }

        public Criteria andBicycleStatusNotEqualTo(Integer value) {
            addCriterion("bicycle_status <>", value, "bicycleStatus");
            return (Criteria) this;
        }

        public Criteria andBicycleStatusGreaterThan(Integer value) {
            addCriterion("bicycle_status >", value, "bicycleStatus");
            return (Criteria) this;
        }

        public Criteria andBicycleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("bicycle_status >=", value, "bicycleStatus");
            return (Criteria) this;
        }

        public Criteria andBicycleStatusLessThan(Integer value) {
            addCriterion("bicycle_status <", value, "bicycleStatus");
            return (Criteria) this;
        }

        public Criteria andBicycleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("bicycle_status <=", value, "bicycleStatus");
            return (Criteria) this;
        }

        public Criteria andBicycleStatusIn(List<Integer> values) {
            addCriterion("bicycle_status in", values, "bicycleStatus");
            return (Criteria) this;
        }

        public Criteria andBicycleStatusNotIn(List<Integer> values) {
            addCriterion("bicycle_status not in", values, "bicycleStatus");
            return (Criteria) this;
        }

        public Criteria andBicycleStatusBetween(Integer value1, Integer value2) {
            addCriterion("bicycle_status between", value1, value2, "bicycleStatus");
            return (Criteria) this;
        }

        public Criteria andBicycleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("bicycle_status not between", value1, value2, "bicycleStatus");
            return (Criteria) this;
        }

        public Criteria andCoordinatesIsNull() {
            addCriterion("coordinates is null");
            return (Criteria) this;
        }

        public Criteria andCoordinatesIsNotNull() {
            addCriterion("coordinates is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinatesEqualTo(Double value) {
            addCriterion("coordinates =", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesNotEqualTo(Double value) {
            addCriterion("coordinates <>", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesGreaterThan(Double value) {
            addCriterion("coordinates >", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesGreaterThanOrEqualTo(Double value) {
            addCriterion("coordinates >=", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesLessThan(Double value) {
            addCriterion("coordinates <", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesLessThanOrEqualTo(Double value) {
            addCriterion("coordinates <=", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesIn(List<Double> values) {
            addCriterion("coordinates in", values, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesNotIn(List<Double> values) {
            addCriterion("coordinates not in", values, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesBetween(Double value1, Double value2) {
            addCriterion("coordinates between", value1, value2, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesNotBetween(Double value1, Double value2) {
            addCriterion("coordinates not between", value1, value2, "coordinates");
            return (Criteria) this;
        }

        public Criteria andRegionalIsNull() {
            addCriterion("regional is null");
            return (Criteria) this;
        }

        public Criteria andRegionalIsNotNull() {
            addCriterion("regional is not null");
            return (Criteria) this;
        }

        public Criteria andRegionalEqualTo(String value) {
            addCriterion("regional =", value, "regional");
            return (Criteria) this;
        }

        public Criteria andRegionalNotEqualTo(String value) {
            addCriterion("regional <>", value, "regional");
            return (Criteria) this;
        }

        public Criteria andRegionalGreaterThan(String value) {
            addCriterion("regional >", value, "regional");
            return (Criteria) this;
        }

        public Criteria andRegionalGreaterThanOrEqualTo(String value) {
            addCriterion("regional >=", value, "regional");
            return (Criteria) this;
        }

        public Criteria andRegionalLessThan(String value) {
            addCriterion("regional <", value, "regional");
            return (Criteria) this;
        }

        public Criteria andRegionalLessThanOrEqualTo(String value) {
            addCriterion("regional <=", value, "regional");
            return (Criteria) this;
        }

        public Criteria andRegionalLike(String value) {
            addCriterion("regional like", value, "regional");
            return (Criteria) this;
        }

        public Criteria andRegionalNotLike(String value) {
            addCriterion("regional not like", value, "regional");
            return (Criteria) this;
        }

        public Criteria andRegionalIn(List<String> values) {
            addCriterion("regional in", values, "regional");
            return (Criteria) this;
        }

        public Criteria andRegionalNotIn(List<String> values) {
            addCriterion("regional not in", values, "regional");
            return (Criteria) this;
        }

        public Criteria andRegionalBetween(String value1, String value2) {
            addCriterion("regional between", value1, value2, "regional");
            return (Criteria) this;
        }

        public Criteria andRegionalNotBetween(String value1, String value2) {
            addCriterion("regional not between", value1, value2, "regional");
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