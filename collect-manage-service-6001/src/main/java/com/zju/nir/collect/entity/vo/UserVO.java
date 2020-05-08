package com.zju.nir.collect.entity.vo;

public class UserVO {
    private Integer id;

    private String name;

    private Integer gender;

    private Integer age;

    private Float weight;

    private Float height;

    private Integer adhdType;

    private String doctorName;

//    private Date createTime;
//
//    private Date updateTime;

    private Integer hNumber;

    private String intervene;

    private String interveneMethod;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Integer getAdhdType() {
        return adhdType;
    }

    public void setAdhdType(Integer adhdType) {
        this.adhdType = adhdType;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }

    public Integer gethNumber() {
        return hNumber;
    }

    public void sethNumber(Integer hNumber) {
        this.hNumber = hNumber;
    }

    public String getIntervene() {
        return intervene;
    }

    public void setIntervene(String intervene) {
        this.intervene = intervene == null ? null : intervene.trim();
    }

    public String getInterveneMethod() {
        return interveneMethod;
    }

    public void setInterveneMethod(String interveneMethod) {
        this.interveneMethod = interveneMethod == null ? null : interveneMethod.trim();
    }
}