package com.jikuodong.plms.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("passWord is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("passWord is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("passWord =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("passWord <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("passWord >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("passWord >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("passWord <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("passWord <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("passWord like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("passWord not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("passWord in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("passWord not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("passWord between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("passWord not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andIsSingleOnIsNull() {
            addCriterion("is_single_on is null");
            return (Criteria) this;
        }

        public Criteria andIsSingleOnIsNotNull() {
            addCriterion("is_single_on is not null");
            return (Criteria) this;
        }

        public Criteria andIsSingleOnEqualTo(Boolean value) {
            addCriterion("is_single_on =", value, "isSingleOn");
            return (Criteria) this;
        }

        public Criteria andIsSingleOnNotEqualTo(Boolean value) {
            addCriterion("is_single_on <>", value, "isSingleOn");
            return (Criteria) this;
        }

        public Criteria andIsSingleOnGreaterThan(Boolean value) {
            addCriterion("is_single_on >", value, "isSingleOn");
            return (Criteria) this;
        }

        public Criteria andIsSingleOnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_single_on >=", value, "isSingleOn");
            return (Criteria) this;
        }

        public Criteria andIsSingleOnLessThan(Boolean value) {
            addCriterion("is_single_on <", value, "isSingleOn");
            return (Criteria) this;
        }

        public Criteria andIsSingleOnLessThanOrEqualTo(Boolean value) {
            addCriterion("is_single_on <=", value, "isSingleOn");
            return (Criteria) this;
        }

        public Criteria andIsSingleOnIn(List<Boolean> values) {
            addCriterion("is_single_on in", values, "isSingleOn");
            return (Criteria) this;
        }

        public Criteria andIsSingleOnNotIn(List<Boolean> values) {
            addCriterion("is_single_on not in", values, "isSingleOn");
            return (Criteria) this;
        }

        public Criteria andIsSingleOnBetween(Boolean value1, Boolean value2) {
            addCriterion("is_single_on between", value1, value2, "isSingleOn");
            return (Criteria) this;
        }

        public Criteria andIsSingleOnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_single_on not between", value1, value2, "isSingleOn");
            return (Criteria) this;
        }

        public Criteria andFailureTimesIsNull() {
            addCriterion("failure_times is null");
            return (Criteria) this;
        }

        public Criteria andFailureTimesIsNotNull() {
            addCriterion("failure_times is not null");
            return (Criteria) this;
        }

        public Criteria andFailureTimesEqualTo(Integer value) {
            addCriterion("failure_times =", value, "failureTimes");
            return (Criteria) this;
        }

        public Criteria andFailureTimesNotEqualTo(Integer value) {
            addCriterion("failure_times <>", value, "failureTimes");
            return (Criteria) this;
        }

        public Criteria andFailureTimesGreaterThan(Integer value) {
            addCriterion("failure_times >", value, "failureTimes");
            return (Criteria) this;
        }

        public Criteria andFailureTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("failure_times >=", value, "failureTimes");
            return (Criteria) this;
        }

        public Criteria andFailureTimesLessThan(Integer value) {
            addCriterion("failure_times <", value, "failureTimes");
            return (Criteria) this;
        }

        public Criteria andFailureTimesLessThanOrEqualTo(Integer value) {
            addCriterion("failure_times <=", value, "failureTimes");
            return (Criteria) this;
        }

        public Criteria andFailureTimesIn(List<Integer> values) {
            addCriterion("failure_times in", values, "failureTimes");
            return (Criteria) this;
        }

        public Criteria andFailureTimesNotIn(List<Integer> values) {
            addCriterion("failure_times not in", values, "failureTimes");
            return (Criteria) this;
        }

        public Criteria andFailureTimesBetween(Integer value1, Integer value2) {
            addCriterion("failure_times between", value1, value2, "failureTimes");
            return (Criteria) this;
        }

        public Criteria andFailureTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("failure_times not between", value1, value2, "failureTimes");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLastLoginOnIsNull() {
            addCriterion("last_login_on is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginOnIsNotNull() {
            addCriterion("last_login_on is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginOnEqualTo(Date value) {
            addCriterion("last_login_on =", value, "lastLoginOn");
            return (Criteria) this;
        }

        public Criteria andLastLoginOnNotEqualTo(Date value) {
            addCriterion("last_login_on <>", value, "lastLoginOn");
            return (Criteria) this;
        }

        public Criteria andLastLoginOnGreaterThan(Date value) {
            addCriterion("last_login_on >", value, "lastLoginOn");
            return (Criteria) this;
        }

        public Criteria andLastLoginOnGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_on >=", value, "lastLoginOn");
            return (Criteria) this;
        }

        public Criteria andLastLoginOnLessThan(Date value) {
            addCriterion("last_login_on <", value, "lastLoginOn");
            return (Criteria) this;
        }

        public Criteria andLastLoginOnLessThanOrEqualTo(Date value) {
            addCriterion("last_login_on <=", value, "lastLoginOn");
            return (Criteria) this;
        }

        public Criteria andLastLoginOnIn(List<Date> values) {
            addCriterion("last_login_on in", values, "lastLoginOn");
            return (Criteria) this;
        }

        public Criteria andLastLoginOnNotIn(List<Date> values) {
            addCriterion("last_login_on not in", values, "lastLoginOn");
            return (Criteria) this;
        }

        public Criteria andLastLoginOnBetween(Date value1, Date value2) {
            addCriterion("last_login_on between", value1, value2, "lastLoginOn");
            return (Criteria) this;
        }

        public Criteria andLastLoginOnNotBetween(Date value1, Date value2) {
            addCriterion("last_login_on not between", value1, value2, "lastLoginOn");
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