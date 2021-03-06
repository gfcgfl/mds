package com.zju.nir.link.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LinkingTaskDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LinkingTaskDOExample() {
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

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Integer value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Integer value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Integer value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Integer value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Integer value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Integer> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Integer> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Integer value1, Integer value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andCollectIdIsNull() {
            addCriterion("collect_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectIdIsNotNull() {
            addCriterion("collect_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectIdEqualTo(Integer value) {
            addCriterion("collect_id =", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotEqualTo(Integer value) {
            addCriterion("collect_id <>", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdGreaterThan(Integer value) {
            addCriterion("collect_id >", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_id >=", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdLessThan(Integer value) {
            addCriterion("collect_id <", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdLessThanOrEqualTo(Integer value) {
            addCriterion("collect_id <=", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdIn(List<Integer> values) {
            addCriterion("collect_id in", values, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotIn(List<Integer> values) {
            addCriterion("collect_id not in", values, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdBetween(Integer value1, Integer value2) {
            addCriterion("collect_id between", value1, value2, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_id not between", value1, value2, "collectId");
            return (Criteria) this;
        }

        public Criteria andAWordMisIsNull() {
            addCriterion("a_word_mis is null");
            return (Criteria) this;
        }

        public Criteria andAWordMisIsNotNull() {
            addCriterion("a_word_mis is not null");
            return (Criteria) this;
        }

        public Criteria andAWordMisEqualTo(Integer value) {
            addCriterion("a_word_mis =", value, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisNotEqualTo(Integer value) {
            addCriterion("a_word_mis <>", value, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisGreaterThan(Integer value) {
            addCriterion("a_word_mis >", value, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_word_mis >=", value, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisLessThan(Integer value) {
            addCriterion("a_word_mis <", value, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisLessThanOrEqualTo(Integer value) {
            addCriterion("a_word_mis <=", value, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisIn(List<Integer> values) {
            addCriterion("a_word_mis in", values, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisNotIn(List<Integer> values) {
            addCriterion("a_word_mis not in", values, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisBetween(Integer value1, Integer value2) {
            addCriterion("a_word_mis between", value1, value2, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordMisNotBetween(Integer value1, Integer value2) {
            addCriterion("a_word_mis not between", value1, value2, "aWordMis");
            return (Criteria) this;
        }

        public Criteria andAWordTimeIsNull() {
            addCriterion("a_word_time is null");
            return (Criteria) this;
        }

        public Criteria andAWordTimeIsNotNull() {
            addCriterion("a_word_time is not null");
            return (Criteria) this;
        }

        public Criteria andAWordTimeEqualTo(Integer value) {
            addCriterion("a_word_time =", value, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeNotEqualTo(Integer value) {
            addCriterion("a_word_time <>", value, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeGreaterThan(Integer value) {
            addCriterion("a_word_time >", value, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_word_time >=", value, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeLessThan(Integer value) {
            addCriterion("a_word_time <", value, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeLessThanOrEqualTo(Integer value) {
            addCriterion("a_word_time <=", value, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeIn(List<Integer> values) {
            addCriterion("a_word_time in", values, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeNotIn(List<Integer> values) {
            addCriterion("a_word_time not in", values, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeBetween(Integer value1, Integer value2) {
            addCriterion("a_word_time between", value1, value2, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andAWordTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("a_word_time not between", value1, value2, "aWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordMisIsNull() {
            addCriterion("b_word_mis is null");
            return (Criteria) this;
        }

        public Criteria andBWordMisIsNotNull() {
            addCriterion("b_word_mis is not null");
            return (Criteria) this;
        }

        public Criteria andBWordMisEqualTo(Integer value) {
            addCriterion("b_word_mis =", value, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisNotEqualTo(Integer value) {
            addCriterion("b_word_mis <>", value, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisGreaterThan(Integer value) {
            addCriterion("b_word_mis >", value, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_word_mis >=", value, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisLessThan(Integer value) {
            addCriterion("b_word_mis <", value, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisLessThanOrEqualTo(Integer value) {
            addCriterion("b_word_mis <=", value, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisIn(List<Integer> values) {
            addCriterion("b_word_mis in", values, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisNotIn(List<Integer> values) {
            addCriterion("b_word_mis not in", values, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisBetween(Integer value1, Integer value2) {
            addCriterion("b_word_mis between", value1, value2, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordMisNotBetween(Integer value1, Integer value2) {
            addCriterion("b_word_mis not between", value1, value2, "bWordMis");
            return (Criteria) this;
        }

        public Criteria andBWordTimeIsNull() {
            addCriterion("b_word_time is null");
            return (Criteria) this;
        }

        public Criteria andBWordTimeIsNotNull() {
            addCriterion("b_word_time is not null");
            return (Criteria) this;
        }

        public Criteria andBWordTimeEqualTo(Integer value) {
            addCriterion("b_word_time =", value, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeNotEqualTo(Integer value) {
            addCriterion("b_word_time <>", value, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeGreaterThan(Integer value) {
            addCriterion("b_word_time >", value, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_word_time >=", value, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeLessThan(Integer value) {
            addCriterion("b_word_time <", value, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeLessThanOrEqualTo(Integer value) {
            addCriterion("b_word_time <=", value, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeIn(List<Integer> values) {
            addCriterion("b_word_time in", values, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeNotIn(List<Integer> values) {
            addCriterion("b_word_time not in", values, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeBetween(Integer value1, Integer value2) {
            addCriterion("b_word_time between", value1, value2, "bWordTime");
            return (Criteria) this;
        }

        public Criteria andBWordTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("b_word_time not between", value1, value2, "bWordTime");
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

        public Criteria andBloodoxygenFilePathIsNull() {
            addCriterion("bloodoxygen_file_path is null");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathIsNotNull() {
            addCriterion("bloodoxygen_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathEqualTo(String value) {
            addCriterion("bloodoxygen_file_path =", value, "bloodoxygenFilePath");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathNotEqualTo(String value) {
            addCriterion("bloodoxygen_file_path <>", value, "bloodoxygenFilePath");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathGreaterThan(String value) {
            addCriterion("bloodoxygen_file_path >", value, "bloodoxygenFilePath");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("bloodoxygen_file_path >=", value, "bloodoxygenFilePath");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathLessThan(String value) {
            addCriterion("bloodoxygen_file_path <", value, "bloodoxygenFilePath");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathLessThanOrEqualTo(String value) {
            addCriterion("bloodoxygen_file_path <=", value, "bloodoxygenFilePath");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathLike(String value) {
            addCriterion("bloodoxygen_file_path like", value, "bloodoxygenFilePath");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathNotLike(String value) {
            addCriterion("bloodoxygen_file_path not like", value, "bloodoxygenFilePath");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathIn(List<String> values) {
            addCriterion("bloodoxygen_file_path in", values, "bloodoxygenFilePath");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathNotIn(List<String> values) {
            addCriterion("bloodoxygen_file_path not in", values, "bloodoxygenFilePath");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathBetween(String value1, String value2) {
            addCriterion("bloodoxygen_file_path between", value1, value2, "bloodoxygenFilePath");
            return (Criteria) this;
        }

        public Criteria andBloodoxygenFilePathNotBetween(String value1, String value2) {
            addCriterion("bloodoxygen_file_path not between", value1, value2, "bloodoxygenFilePath");
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