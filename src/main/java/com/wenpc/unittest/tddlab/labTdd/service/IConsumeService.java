package com.wenpc.unittest.tddlab.labTdd.service;


import com.wenpc.unittest.tddlab.utils.RestResult;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
public interface IConsumeService {

    /**
     * 购买商品
     *
     * @param opResult
     * @param id
     * @param useMoney
     * @param goodName
     * @return
     */
    public int buyGood(RestResult opResult, int id, int useMoney, String goodName);
}
