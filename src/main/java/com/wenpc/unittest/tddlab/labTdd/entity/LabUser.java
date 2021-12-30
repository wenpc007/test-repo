package com.wenpc.unittest.tddlab.labTdd.entity;

import java.io.Serializable;

/**
 * @Author wenpc
 * @Date 2021-01-10 16:59
 **/
public class LabUser implements Serializable {

    public LabUser() {

    }

    public LabUser(int id, String username) {
        this.id = id;
        this.username = username;
    }

    private int id;
    private String username;
    private String password;
    private int age;
    /**
     * 累积充值金额
     */
    private int totalAddMoney;
    /**
     * 累积使用金额
     */
    private int totalUseMoney;
    /**
     * 当前余额
     */
    private int remainMoney;
    /**
     * 积分
     */
    private int score;
    private String createTime;
    private String updateTime;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(int remainMoney) {
        this.remainMoney = remainMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalAddMoney() {
        return totalAddMoney;
    }

    public void setTotalAddMoney(int totalAddMoney) {
        this.totalAddMoney = totalAddMoney;
    }

    public int getTotalUseMoney() {
        return totalUseMoney;
    }

    public void setTotalUseMoney(int totalUseMoney) {
        this.totalUseMoney = totalUseMoney;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
