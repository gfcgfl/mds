package com.zju.nir.stroop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StroopTaskDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StroopTaskDOExample() {
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

        public Criteria andAStroopMisIsNull() {
            addCriterion("a_stroop_mis is null");
            return (Criteria) this;
        }

        public Criteria andAStroopMisIsNotNull() {
            addCriterion("a_stroop_mis is not null");
            return (Criteria) this;
        }

        public Criteria andAStroopMisEqualTo(Integer value) {
            addCriterion("a_stroop_mis =", value, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisNotEqualTo(Integer value) {
            addCriterion("a_stroop_mis <>", value, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisGreaterThan(Integer value) {
            addCriterion("a_stroop_mis >", value, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_stroop_mis >=", value, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisLessThan(Integer value) {
            addCriterion("a_stroop_mis <", value, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisLessThanOrEqualTo(Integer value) {
            addCriterion("a_stroop_mis <=", value, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisIn(List<Integer> values) {
            addCriterion("a_stroop_mis in", values, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisNotIn(List<Integer> values) {
            addCriterion("a_stroop_mis not in", values, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisBetween(Integer value1, Integer value2) {
            addCriterion("a_stroop_mis between", value1, value2, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopMisNotBetween(Integer value1, Integer value2) {
            addCriterion("a_stroop_mis not between", value1, value2, "aStroopMis");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeIsNull() {
            addCriterion("a_stroop_time is null");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeIsNotNull() {
            addCriterion("a_stroop_time is not null");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeEqualTo(Integer value) {
            addCriterion("a_stroop_time =", value, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeNotEqualTo(Integer value) {
            addCriterion("a_stroop_time <>", value, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeGreaterThan(Integer value) {
            addCriterion("a_stroop_time >", value, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_stroop_time >=", value, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeLessThan(Integer value) {
            addCriterion("a_stroop_time <", value, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeLessThanOrEqualTo(Integer value) {
            addCriterion("a_stroop_time <=", value, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeIn(List<Integer> values) {
            addCriterion("a_stroop_time in", values, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeNotIn(List<Integer> values) {
            addCriterion("a_stroop_time not in", values, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeBetween(Integer value1, Integer value2) {
            addCriterion("a_stroop_time between", value1, value2, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andAStroopTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("a_stroop_time not between", value1, value2, "aStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopMisIsNull() {
            addCriterion("b_stroop_mis is null");
            return (Criteria) this;
        }

        public Criteria andBStroopMisIsNotNull() {
            addCriterion("b_stroop_mis is not null");
            return (Criteria) this;
        }

        public Criteria andBStroopMisEqualTo(Integer value) {
            addCriterion("b_stroop_mis =", value, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisNotEqualTo(Integer value) {
            addCriterion("b_stroop_mis <>", value, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisGreaterThan(Integer value) {
            addCriterion("b_stroop_mis >", value, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_stroop_mis >=", value, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisLessThan(Integer value) {
            addCriterion("b_stroop_mis <", value, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisLessThanOrEqualTo(Integer value) {
            addCriterion("b_stroop_mis <=", value, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisIn(List<Integer> values) {
            addCriterion("b_stroop_mis in", values, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisNotIn(List<Integer> values) {
            addCriterion("b_stroop_mis not in", values, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisBetween(Integer value1, Integer value2) {
            addCriterion("b_stroop_mis between", value1, value2, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopMisNotBetween(Integer value1, Integer value2) {
            addCriterion("b_stroop_mis not between", value1, value2, "bStroopMis");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeIsNull() {
            addCriterion("b_stroop_time is null");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeIsNotNull() {
            addCriterion("b_stroop_time is not null");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeEqualTo(Integer value) {
            addCriterion("b_stroop_time =", value, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeNotEqualTo(Integer value) {
            addCriterion("b_stroop_time <>", value, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeGreaterThan(Integer value) {
            addCriterion("b_stroop_time >", value, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_stroop_time >=", value, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeLessThan(Integer value) {
            addCriterion("b_stroop_time <", value, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeLessThanOrEqualTo(Integer value) {
            addCriterion("b_stroop_time <=", value, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeIn(List<Integer> values) {
            addCriterion("b_stroop_time in", values, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeNotIn(List<Integer> values) {
            addCriterion("b_stroop_time not in", values, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeBetween(Integer value1, Integer value2) {
            addCriterion("b_stroop_time between", value1, value2, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andBStroopTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("b_stroop_time not between", value1, value2, "bStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopMisIsNull() {
            addCriterion("c_stroop_mis is null");
            return (Criteria) this;
        }

        public Criteria andCStroopMisIsNotNull() {
            addCriterion("c_stroop_mis is not null");
            return (Criteria) this;
        }

        public Criteria andCStroopMisEqualTo(Integer value) {
            addCriterion("c_stroop_mis =", value, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisNotEqualTo(Integer value) {
            addCriterion("c_stroop_mis <>", value, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisGreaterThan(Integer value) {
            addCriterion("c_stroop_mis >", value, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_stroop_mis >=", value, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisLessThan(Integer value) {
            addCriterion("c_stroop_mis <", value, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisLessThanOrEqualTo(Integer value) {
            addCriterion("c_stroop_mis <=", value, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisIn(List<Integer> values) {
            addCriterion("c_stroop_mis in", values, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisNotIn(List<Integer> values) {
            addCriterion("c_stroop_mis not in", values, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisBetween(Integer value1, Integer value2) {
            addCriterion("c_stroop_mis between", value1, value2, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopMisNotBetween(Integer value1, Integer value2) {
            addCriterion("c_stroop_mis not between", value1, value2, "cStroopMis");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeIsNull() {
            addCriterion("c_stroop_time is null");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeIsNotNull() {
            addCriterion("c_stroop_time is not null");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeEqualTo(Integer value) {
            addCriterion("c_stroop_time =", value, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeNotEqualTo(Integer value) {
            addCriterion("c_stroop_time <>", value, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeGreaterThan(Integer value) {
            addCriterion("c_stroop_time >", value, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_stroop_time >=", value, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeLessThan(Integer value) {
            addCriterion("c_stroop_time <", value, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeLessThanOrEqualTo(Integer value) {
            addCriterion("c_stroop_time <=", value, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeIn(List<Integer> values) {
            addCriterion("c_stroop_time in", values, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeNotIn(List<Integer> values) {
            addCriterion("c_stroop_time not in", values, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeBetween(Integer value1, Integer value2) {
            addCriterion("c_stroop_time between", value1, value2, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andCStroopTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("c_stroop_time not between", value1, value2, "cStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopMisIsNull() {
            addCriterion("d_stroop_mis is null");
            return (Criteria) this;
        }

        public Criteria andDStroopMisIsNotNull() {
            addCriterion("d_stroop_mis is not null");
            return (Criteria) this;
        }

        public Criteria andDStroopMisEqualTo(Integer value) {
            addCriterion("d_stroop_mis =", value, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisNotEqualTo(Integer value) {
            addCriterion("d_stroop_mis <>", value, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisGreaterThan(Integer value) {
            addCriterion("d_stroop_mis >", value, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_stroop_mis >=", value, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisLessThan(Integer value) {
            addCriterion("d_stroop_mis <", value, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisLessThanOrEqualTo(Integer value) {
            addCriterion("d_stroop_mis <=", value, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisIn(List<Integer> values) {
            addCriterion("d_stroop_mis in", values, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisNotIn(List<Integer> values) {
            addCriterion("d_stroop_mis not in", values, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisBetween(Integer value1, Integer value2) {
            addCriterion("d_stroop_mis between", value1, value2, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopMisNotBetween(Integer value1, Integer value2) {
            addCriterion("d_stroop_mis not between", value1, value2, "dStroopMis");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeIsNull() {
            addCriterion("d_stroop_time is null");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeIsNotNull() {
            addCriterion("d_stroop_time is not null");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeEqualTo(Integer value) {
            addCriterion("d_stroop_time =", value, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeNotEqualTo(Integer value) {
            addCriterion("d_stroop_time <>", value, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeGreaterThan(Integer value) {
            addCriterion("d_stroop_time >", value, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_stroop_time >=", value, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeLessThan(Integer value) {
            addCriterion("d_stroop_time <", value, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeLessThanOrEqualTo(Integer value) {
            addCriterion("d_stroop_time <=", value, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeIn(List<Integer> values) {
            addCriterion("d_stroop_time in", values, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeNotIn(List<Integer> values) {
            addCriterion("d_stroop_time not in", values, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeBetween(Integer value1, Integer value2) {
            addCriterion("d_stroop_time between", value1, value2, "dStroopTime");
            return (Criteria) this;
        }

        public Criteria andDStroopTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("d_stroop_time not between", value1, value2, "dStroopTime");
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