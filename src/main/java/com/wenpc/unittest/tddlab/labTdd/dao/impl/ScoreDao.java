package com.wenpc.unittest.tddlab.labTdd.dao.impl;

import com.wenpc.unittest.tddlab.labTdd.dao.IScoreDao;
import com.wenpc.unittest.tddlab.utils.RestResult;
import com.wenpc.unittest.tddlab.utils.StringUtilsEx;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
@Repository
public class ScoreDao implements IScoreDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public String space() {
        return StringUtilsEx.rightStr(this.getClass().getName(), ".");
    }

    @Override
    public int updateUserScore(RestResult restResult, int userId, int score) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("score", score);
        return sqlSessionTemplate.update(space() + ".updateUserScore", params);
    }
}
