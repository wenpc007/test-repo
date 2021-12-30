package com.wenpc.unittest.tddlab.labTdd.dao;

import com.wenpc.unittest.tddlab.utils.RestResult;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
public interface IScoreDao {
    /**
     * 更新用户积分
     *
     * @param restResult
     * @param userId
     * @param score
     * @return
     */
    public int updateUserScore(RestResult restResult, int userId, int score);

    public String space();
}
