package com.wenpc.unittest.tddlab.labTdd.entity;

import java.io.Serializable;

/**
 * @Author wenpc
 * @Date 2021-01-10 16:59
 **/
public class LabBuyGood implements Serializable {
    private int id;
    private int userId;
    private String goodName;
    private int useMoney;
    private String createTime;

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

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getUseMoney() {
        return useMoney;
    }

    public void setUseMoney(int useMoney) {
        this.useMoney = useMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
