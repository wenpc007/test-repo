package com.wenpc.unittest.tddlab.labTdd.service;


import com.wenpc.unittest.tddlab.utils.RestResult;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
public interface IRechargeService {

    /**
     * 充值
     *
     * @param opResult
     * @param id
     * @param addMoney
     * @return
     */
    public int addMoney(RestResult opResult, int id, int addMoney);
}
