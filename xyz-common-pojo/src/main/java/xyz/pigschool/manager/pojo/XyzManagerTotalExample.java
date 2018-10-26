package xyz.pigschool.manager.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XyzManagerTotalExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XyzManagerTotalExample() {
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

        public Criteria andRecorddateidIsNull() {
            addCriterion("recordDateId is null");
            return (Criteria) this;
        }

        public Criteria andRecorddateidIsNotNull() {
            addCriterion("recordDateId is not null");
            return (Criteria) this;
        }

        public Criteria andRecorddateidEqualTo(String value) {
            addCriterion("recordDateId =", value, "recorddateid");
            return (Criteria) this;
        }

        public Criteria andRecorddateidNotEqualTo(String value) {
            addCriterion("recordDateId <>", value, "recorddateid");
            return (Criteria) this;
        }

        public Criteria andRecorddateidGreaterThan(String value) {
            addCriterion("recordDateId >", value, "recorddateid");
            return (Criteria) this;
        }

        public Criteria andRecorddateidGreaterThanOrEqualTo(String value) {
            addCriterion("recordDateId >=", value, "recorddateid");
            return (Criteria) this;
        }

        public Criteria andRecorddateidLessThan(String value) {
            addCriterion("recordDateId <", value, "recorddateid");
            return (Criteria) this;
        }

        public Criteria andRecorddateidLessThanOrEqualTo(String value) {
            addCriterion("recordDateId <=", value, "recorddateid");
            return (Criteria) this;
        }

        public Criteria andRecorddateidLike(String value) {
            addCriterion("recordDateId like", value, "recorddateid");
            return (Criteria) this;
        }

        public Criteria andRecorddateidNotLike(String value) {
            addCriterion("recordDateId not like", value, "recorddateid");
            return (Criteria) this;
        }

        public Criteria andRecorddateidIn(List<String> values) {
            addCriterion("recordDateId in", values, "recorddateid");
            return (Criteria) this;
        }

        public Criteria andRecorddateidNotIn(List<String> values) {
            addCriterion("recordDateId not in", values, "recorddateid");
            return (Criteria) this;
        }

        public Criteria andRecorddateidBetween(String value1, String value2) {
            addCriterion("recordDateId between", value1, value2, "recorddateid");
            return (Criteria) this;
        }

        public Criteria andRecorddateidNotBetween(String value1, String value2) {
            addCriterion("recordDateId not between", value1, value2, "recorddateid");
            return (Criteria) this;
        }

        public Criteria andUserLoginIsNull() {
            addCriterion("user_login is null");
            return (Criteria) this;
        }

        public Criteria andUserLoginIsNotNull() {
            addCriterion("user_login is not null");
            return (Criteria) this;
        }

        public Criteria andUserLoginEqualTo(Integer value) {
            addCriterion("user_login =", value, "userLogin");
            return (Criteria) this;
        }

        public Criteria andUserLoginNotEqualTo(Integer value) {
            addCriterion("user_login <>", value, "userLogin");
            return (Criteria) this;
        }

        public Criteria andUserLoginGreaterThan(Integer value) {
            addCriterion("user_login >", value, "userLogin");
            return (Criteria) this;
        }

        public Criteria andUserLoginGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_login >=", value, "userLogin");
            return (Criteria) this;
        }

        public Criteria andUserLoginLessThan(Integer value) {
            addCriterion("user_login <", value, "userLogin");
            return (Criteria) this;
        }

        public Criteria andUserLoginLessThanOrEqualTo(Integer value) {
            addCriterion("user_login <=", value, "userLogin");
            return (Criteria) this;
        }

        public Criteria andUserLoginIn(List<Integer> values) {
            addCriterion("user_login in", values, "userLogin");
            return (Criteria) this;
        }

        public Criteria andUserLoginNotIn(List<Integer> values) {
            addCriterion("user_login not in", values, "userLogin");
            return (Criteria) this;
        }

        public Criteria andUserLoginBetween(Integer value1, Integer value2) {
            addCriterion("user_login between", value1, value2, "userLogin");
            return (Criteria) this;
        }

        public Criteria andUserLoginNotBetween(Integer value1, Integer value2) {
            addCriterion("user_login not between", value1, value2, "userLogin");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIsNull() {
            addCriterion("user_register is null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIsNotNull() {
            addCriterion("user_register is not null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterEqualTo(Integer value) {
            addCriterion("user_register =", value, "userRegister");
            return (Criteria) this;
        }

        public Criteria andUserRegisterNotEqualTo(Integer value) {
            addCriterion("user_register <>", value, "userRegister");
            return (Criteria) this;
        }

        public Criteria andUserRegisterGreaterThan(Integer value) {
            addCriterion("user_register >", value, "userRegister");
            return (Criteria) this;
        }

        public Criteria andUserRegisterGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_register >=", value, "userRegister");
            return (Criteria) this;
        }

        public Criteria andUserRegisterLessThan(Integer value) {
            addCriterion("user_register <", value, "userRegister");
            return (Criteria) this;
        }

        public Criteria andUserRegisterLessThanOrEqualTo(Integer value) {
            addCriterion("user_register <=", value, "userRegister");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIn(List<Integer> values) {
            addCriterion("user_register in", values, "userRegister");
            return (Criteria) this;
        }

        public Criteria andUserRegisterNotIn(List<Integer> values) {
            addCriterion("user_register not in", values, "userRegister");
            return (Criteria) this;
        }

        public Criteria andUserRegisterBetween(Integer value1, Integer value2) {
            addCriterion("user_register between", value1, value2, "userRegister");
            return (Criteria) this;
        }

        public Criteria andUserRegisterNotBetween(Integer value1, Integer value2) {
            addCriterion("user_register not between", value1, value2, "userRegister");
            return (Criteria) this;
        }

        public Criteria andUserVisitIsNull() {
            addCriterion("user_visit is null");
            return (Criteria) this;
        }

        public Criteria andUserVisitIsNotNull() {
            addCriterion("user_visit is not null");
            return (Criteria) this;
        }

        public Criteria andUserVisitEqualTo(Integer value) {
            addCriterion("user_visit =", value, "userVisit");
            return (Criteria) this;
        }

        public Criteria andUserVisitNotEqualTo(Integer value) {
            addCriterion("user_visit <>", value, "userVisit");
            return (Criteria) this;
        }

        public Criteria andUserVisitGreaterThan(Integer value) {
            addCriterion("user_visit >", value, "userVisit");
            return (Criteria) this;
        }

        public Criteria andUserVisitGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_visit >=", value, "userVisit");
            return (Criteria) this;
        }

        public Criteria andUserVisitLessThan(Integer value) {
            addCriterion("user_visit <", value, "userVisit");
            return (Criteria) this;
        }

        public Criteria andUserVisitLessThanOrEqualTo(Integer value) {
            addCriterion("user_visit <=", value, "userVisit");
            return (Criteria) this;
        }

        public Criteria andUserVisitIn(List<Integer> values) {
            addCriterion("user_visit in", values, "userVisit");
            return (Criteria) this;
        }

        public Criteria andUserVisitNotIn(List<Integer> values) {
            addCriterion("user_visit not in", values, "userVisit");
            return (Criteria) this;
        }

        public Criteria andUserVisitBetween(Integer value1, Integer value2) {
            addCriterion("user_visit between", value1, value2, "userVisit");
            return (Criteria) this;
        }

        public Criteria andUserVisitNotBetween(Integer value1, Integer value2) {
            addCriterion("user_visit not between", value1, value2, "userVisit");
            return (Criteria) this;
        }

        public Criteria andManagerPushContentIsNull() {
            addCriterion("manager_push_content is null");
            return (Criteria) this;
        }

        public Criteria andManagerPushContentIsNotNull() {
            addCriterion("manager_push_content is not null");
            return (Criteria) this;
        }

        public Criteria andManagerPushContentEqualTo(Integer value) {
            addCriterion("manager_push_content =", value, "managerPushContent");
            return (Criteria) this;
        }

        public Criteria andManagerPushContentNotEqualTo(Integer value) {
            addCriterion("manager_push_content <>", value, "managerPushContent");
            return (Criteria) this;
        }

        public Criteria andManagerPushContentGreaterThan(Integer value) {
            addCriterion("manager_push_content >", value, "managerPushContent");
            return (Criteria) this;
        }

        public Criteria andManagerPushContentGreaterThanOrEqualTo(Integer value) {
            addCriterion("manager_push_content >=", value, "managerPushContent");
            return (Criteria) this;
        }

        public Criteria andManagerPushContentLessThan(Integer value) {
            addCriterion("manager_push_content <", value, "managerPushContent");
            return (Criteria) this;
        }

        public Criteria andManagerPushContentLessThanOrEqualTo(Integer value) {
            addCriterion("manager_push_content <=", value, "managerPushContent");
            return (Criteria) this;
        }

        public Criteria andManagerPushContentIn(List<Integer> values) {
            addCriterion("manager_push_content in", values, "managerPushContent");
            return (Criteria) this;
        }

        public Criteria andManagerPushContentNotIn(List<Integer> values) {
            addCriterion("manager_push_content not in", values, "managerPushContent");
            return (Criteria) this;
        }

        public Criteria andManagerPushContentBetween(Integer value1, Integer value2) {
            addCriterion("manager_push_content between", value1, value2, "managerPushContent");
            return (Criteria) this;
        }

        public Criteria andManagerPushContentNotBetween(Integer value1, Integer value2) {
            addCriterion("manager_push_content not between", value1, value2, "managerPushContent");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
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