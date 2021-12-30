package com.wenpc.unittest.tddlab.labTdd.entity;

import java.io.Serializable;

/**
 * @Author wenpc
 * @Date 2021-01-10 17:16
 **/
public class LabAddMoney implements Serializable {
    private int id;
    private int userId;
    private int addMoney;
    private String createTime;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAddMoney() {
        return addMoney;
    }

    public void setAddMoney(int addMoney) {
        this.addMoney = addMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
