package com.gduf.sbcms.entity;

import java.util.ArrayList;
import java.util.List;

public class FeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeedbackExample() {
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusIsNull() {
            addCriterion("feedback_status is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusIsNotNull() {
            addCriterion("feedback_status is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusEqualTo(String value) {
            addCriterion("feedback_status =", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusNotEqualTo(String value) {
            addCriterion("feedback_status <>", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusGreaterThan(String value) {
            addCriterion("feedback_status >", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_status >=", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusLessThan(String value) {
            addCriterion("feedback_status <", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusLessThanOrEqualTo(String value) {
            addCriterion("feedback_status <=", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusLike(String value) {
            addCriterion("feedback_status like", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusNotLike(String value) {
            addCriterion("feedback_status not like", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusIn(List<String> values) {
            addCriterion("feedback_status in", values, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusNotIn(List<String> values) {
            addCriterion("feedback_status not in", values, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusBetween(String value1, String value2) {
            addCriterion("feedback_status between", value1, value2, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusNotBetween(String value1, String value2) {
            addCriterion("feedback_status not between", value1, value2, "feedbackStatus");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeIsNull() {
            addCriterion("feedback_type is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeIsNotNull() {
            addCriterion("feedback_type is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeEqualTo(String value) {
            addCriterion("feedback_type =", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeNotEqualTo(String value) {
            addCriterion("feedback_type <>", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeGreaterThan(String value) {
            addCriterion("feedback_type >", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_type >=", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeLessThan(String value) {
            addCriterion("feedback_type <", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeLessThanOrEqualTo(String value) {
            addCriterion("feedback_type <=", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeLike(String value) {
            addCriterion("feedback_type like", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeNotLike(String value) {
            addCriterion("feedback_type not like", value, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeIn(List<String> values) {
            addCriterion("feedback_type in", values, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeNotIn(List<String> values) {
            addCriterion("feedback_type not in", values, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeBetween(String value1, String value2) {
            addCriterion("feedback_type between", value1, value2, "feedbackType");
            return (Criteria) this;
        }

        public Criteria andFeedbackTypeNotBetween(String value1, String value2) {
            addCriterion("feedback_type not between", value1, value2, "feedbackType");
            return (Criteria) this;
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

        public Criteria andDamageTypeIsNull() {
            addCriterion("damage_type is null");
            return (Criteria) this;
        }

        public Criteria andDamageTypeIsNotNull() {
            addCriterion("damage_type is not null");
            return (Criteria) this;
        }

        public Criteria andDamageTypeEqualTo(String value) {
            addCriterion("damage_type =", value, "damageType");
            return (Criteria) this;
        }

        public Criteria andDamageTypeNotEqualTo(String value) {
            addCriterion("damage_type <>", value, "damageType");
            return (Criteria) this;
        }

        public Criteria andDamageTypeGreaterThan(String value) {
            addCriterion("damage_type >", value, "damageType");
            return (Criteria) this;
        }

        public Criteria andDamageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("damage_type >=", value, "damageType");
            return (Criteria) this;
        }

        public Criteria andDamageTypeLessThan(String value) {
            addCriterion("damage_type <", value, "damageType");
            return (Criteria) this;
        }

        public Criteria andDamageTypeLessThanOrEqualTo(String value) {
            addCriterion("damage_type <=", value, "damageType");
            return (Criteria) this;
        }

        public Criteria andDamageTypeLike(String value) {
            addCriterion("damage_type like", value, "damageType");
            return (Criteria) this;
        }

        public Criteria andDamageTypeNotLike(String value) {
            addCriterion("damage_type not like", value, "damageType");
            return (Criteria) this;
        }

        public Criteria andDamageTypeIn(List<String> values) {
            addCriterion("damage_type in", values, "damageType");
            return (Criteria) this;
        }

        public Criteria andDamageTypeNotIn(List<String> values) {
            addCriterion("damage_type not in", values, "damageType");
            return (Criteria) this;
        }

        public Criteria andDamageTypeBetween(String value1, String value2) {
            addCriterion("damage_type between", value1, value2, "damageType");
            return (Criteria) this;
        }

        public Criteria andDamageTypeNotBetween(String value1, String value2) {
            addCriterion("damage_type not between", value1, value2, "damageType");
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