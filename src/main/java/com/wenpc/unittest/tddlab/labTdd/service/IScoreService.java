package com.wenpc.unittest.tddlab.labTdd.service;

import com.wenpc.unittest.tddlab.utils.RestResult;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
public interface IScoreService {
    /**
     * 更新用户积分
     *
     * @param restResult
     * @param id
     * @param score
     * @return
     */
    public int updateUserScore(RestResult restResult, int id, int score);

    /**
     * 计算积分
     *
     * @param totalUseMoney
     * @return
     */
    public int calcScore(int totalUseMoney);
}
