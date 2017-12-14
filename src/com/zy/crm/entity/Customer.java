package com.zy.crm.entity;

import java.io.Serializable;

public class Customer implements Serializable {
/*    `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
            `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
            `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
            `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
            `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
            `cust_phone` varchar(64) DEFAULT NULL COMMENT '固定电话',
            `cust_mobile` varchar(16) DEFAULT NULL COMMENT '移动电话',
 */

    private Integer custId;
    private String custName;
    private String custSource;
    private String custIndustry;
    private String custLevel;
    private String custPhone;
    private String custMobile;
//    private Linkman linkman;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

/*    public Linkman getLinkman() {
        return linkman;
    }

    public void setLinkman(Linkman linkman) {
        this.linkman = linkman;
    }*/
}
