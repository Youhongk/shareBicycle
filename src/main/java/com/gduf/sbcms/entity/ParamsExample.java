package com.gduf.sbcms.entity;

import java.util.ArrayList;
import java.util.List;

public class ParamsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParamsExample() {
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

        public Criteria andParamidIsNull() {
            addCriterion("paramid is null");
            return (Criteria) this;
        }

        public Criteria andParamidIsNotNull() {
            addCriterion("paramid is not null");
            return (Criteria) this;
        }

        public Criteria andParamidEqualTo(Integer value) {
            addCriterion("paramid =", value, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidNotEqualTo(Integer value) {
            addCriterion("paramid <>", value, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidGreaterThan(Integer value) {
            addCriterion("paramid >", value, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidGreaterThanOrEqualTo(Integer value) {
            addCriterion("paramid >=", value, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidLessThan(Integer value) {
            addCriterion("paramid <", value, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidLessThanOrEqualTo(Integer value) {
            addCriterion("paramid <=", value, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidIn(List<Integer> values) {
            addCriterion("paramid in", values, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidNotIn(List<Integer> values) {
            addCriterion("paramid not in", values, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidBetween(Integer value1, Integer value2) {
            addCriterion("paramid between", value1, value2, "paramid");
            return (Criteria) this;
        }

        public Criteria andParamidNotBetween(Integer value1, Integer value2) {
            addCriterion("paramid not between", value1, value2, "paramid");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPkeyIsNull() {
            addCriterion("pkey is null");
            return (Criteria) this;
        }

        public Criteria andPkeyIsNotNull() {
            addCriterion("pkey is not null");
            return (Criteria) this;
        }

        public Criteria andPkeyEqualTo(String value) {
            addCriterion("pkey =", value, "pkey");
            return (Criteria) this;
        }

        public Criteria andPkeyNotEqualTo(String value) {
            addCriterion("pkey <>", value, "pkey");
            return (Criteria) this;
        }

        public Criteria andPkeyGreaterThan(String value) {
            addCriterion("pkey >", value, "pkey");
            return (Criteria) this;
        }

        public Criteria andPkeyGreaterThanOrEqualTo(String value) {
            addCriterion("pkey >=", value, "pkey");
            return (Criteria) this;
        }

        public Criteria andPkeyLessThan(String value) {
            addCriterion("pkey <", value, "pkey");
            return (Criteria) this;
        }

        public Criteria andPkeyLessThanOrEqualTo(String value) {
            addCriterion("pkey <=", value, "pkey");
            return (Criteria) this;
        }

        public Criteria andPkeyLike(String value) {
            addCriterion("pkey like", value, "pkey");
            return (Criteria) this;
        }

        public Criteria andPkeyNotLike(String value) {
            addCriterion("pkey not like", value, "pkey");
            return (Criteria) this;
        }

        public Criteria andPkeyIn(List<String> values) {
            addCriterion("pkey in", values, "pkey");
            return (Criteria) this;
        }

        public Criteria andPkeyNotIn(List<String> values) {
            addCriterion("pkey not in", values, "pkey");
            return (Criteria) this;
        }

        public Criteria andPkeyBetween(String value1, String value2) {
            addCriterion("pkey between", value1, value2, "pkey");
            return (Criteria) this;
        }

        public Criteria andPkeyNotBetween(String value1, String value2) {
            addCriterion("pkey not between", value1, value2, "pkey");
            return (Criteria) this;
        }

        public Criteria andPvalueIsNull() {
            addCriterion("pvalue is null");
            return (Criteria) this;
        }

        public Criteria andPvalueIsNotNull() {
            addCriterion("pvalue is not null");
            return (Criteria) this;
        }

        public Criteria andPvalueEqualTo(String value) {
            addCriterion("pvalue =", value, "pvalue");
            return (Criteria) this;
        }

        public Criteria andPvalueNotEqualTo(String value) {
            addCriterion("pvalue <>", value, "pvalue");
            return (Criteria) this;
        }

        public Criteria andPvalueGreaterThan(String value) {
            addCriterion("pvalue >", value, "pvalue");
            return (Criteria) this;
        }

        public Criteria andPvalueGreaterThanOrEqualTo(String value) {
            addCriterion("pvalue >=", value, "pvalue");
            return (Criteria) this;
        }

        public Criteria andPvalueLessThan(String value) {
            addCriterion("pvalue <", value, "pvalue");
            return (Criteria) this;
        }

        public Criteria andPvalueLessThanOrEqualTo(String value) {
            addCriterion("pvalue <=", value, "pvalue");
            return (Criteria) this;
        }

        public Criteria andPvalueLike(String value) {
            addCriterion("pvalue like", value, "pvalue");
            return (Criteria) this;
        }

        public Criteria andPvalueNotLike(String value) {
            addCriterion("pvalue not like", value, "pvalue");
            return (Criteria) this;
        }

        public Criteria andPvalueIn(List<String> values) {
            addCriterion("pvalue in", values, "pvalue");
            return (Criteria) this;
        }

        public Criteria andPvalueNotIn(List<String> values) {
            addCriterion("pvalue not in", values, "pvalue");
            return (Criteria) this;
        }

        public Criteria andPvalueBetween(String value1, String value2) {
            addCriterion("pvalue between", value1, value2, "pvalue");
            return (Criteria) this;
        }

        public Criteria andPvalueNotBetween(String value1, String value2) {
            addCriterion("pvalue not between", value1, value2, "pvalue");
            return (Criteria) this;
        }

        public Criteria andMenoIsNull() {
            addCriterion("meno is null");
            return (Criteria) this;
        }

        public Criteria andMenoIsNotNull() {
            addCriterion("meno is not null");
            return (Criteria) this;
        }

        public Criteria andMenoEqualTo(String value) {
            addCriterion("meno =", value, "meno");
            return (Criteria) this;
        }

        public Criteria andMenoNotEqualTo(String value) {
            addCriterion("meno <>", value, "meno");
            return (Criteria) this;
        }

        public Criteria andMenoGreaterThan(String value) {
            addCriterion("meno >", value, "meno");
            return (Criteria) this;
        }

        public Criteria andMenoGreaterThanOrEqualTo(String value) {
            addCriterion("meno >=", value, "meno");
            return (Criteria) this;
        }

        public Criteria andMenoLessThan(String value) {
            addCriterion("meno <", value, "meno");
            return (Criteria) this;
        }

        public Criteria andMenoLessThanOrEqualTo(String value) {
            addCriterion("meno <=", value, "meno");
            return (Criteria) this;
        }

        public Criteria andMenoLike(String value) {
            addCriterion("meno like", value, "meno");
            return (Criteria) this;
        }

        public Criteria andMenoNotLike(String value) {
            addCriterion("meno not like", value, "meno");
            return (Criteria) this;
        }

        public Criteria andMenoIn(List<String> values) {
            addCriterion("meno in", values, "meno");
            return (Criteria) this;
        }

        public Criteria andMenoNotIn(List<String> values) {
            addCriterion("meno not in", values, "meno");
            return (Criteria) this;
        }

        public Criteria andMenoBetween(String value1, String value2) {
            addCriterion("meno between", value1, value2, "meno");
            return (Criteria) this;
        }

        public Criteria andMenoNotBetween(String value1, String value2) {
            addCriterion("meno not between", value1, value2, "meno");
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