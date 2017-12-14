package com.zy.crm.entity;

public class Linkman {
    private Integer lkmId;
    private String lkmName;
    private Integer lkmGender;
    private String lkmPhone;
    private String lkmMobile;
    private Customer customer = new Customer();

    public Integer getLkmId() {
        return lkmId;
    }

    public void setLkmId(Integer lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public Integer getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(Integer lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
