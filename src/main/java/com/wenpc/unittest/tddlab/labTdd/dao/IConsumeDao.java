package com.wenpc.unittest.tddlab.labTdd.dao;

import com.wenpc.unittest.tddlab.utils.RestResult;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
public interface IConsumeDao {
    public int buyGood(RestResult opResult, int id, int useMoney, String goodName);

    public String space();
}
