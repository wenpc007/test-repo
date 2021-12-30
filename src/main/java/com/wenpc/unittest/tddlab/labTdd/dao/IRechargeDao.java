package com.wenpc.unittest.tddlab.labTdd.dao;

import com.wenpc.unittest.tddlab.utils.RestResult;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
public interface IRechargeDao {
    public int addMoney(RestResult opResult, int id, int addMoney);

    public String space();
}
