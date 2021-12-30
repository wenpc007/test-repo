package com.wenpc.unittest.tddlab.dao;

import com.wenpc.unittest.tddlab.labTdd.dao.IScoreDao;
import com.wenpc.unittest.tddlab.labTdd.dao.impl.ScoreDao;
import com.wenpc.unittest.tddlab.utils.ReflectionTddUtils;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
@SpringBootTest
public class ScoreDaoTest {
    private static SqlSessionTemplate sqlSessionTemplate;
    private static IScoreDao scoreDao;
    private static RestResult restResult = RestResult.create();

    @BeforeClass
    public static void beforeClass() throws NoSuchFieldException, IllegalAccessException {
        sqlSessionTemplate = mock(SqlSessionTemplate.class);
        scoreDao = new ScoreDao();
        ReflectionTddUtils.setFieldValue(scoreDao, "sqlSessionTemplate", sqlSessionTemplate);
    }

    @Test
    public void space() {
        assertThat(scoreDao.space(), equalTo("ScoreDao"));
    }

    @Test
    public void updateUserScore() {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", 1);
        params.put("score", 1000);
        when(sqlSessionTemplate.update(scoreDao.space() + ".updateUserScore", params)).thenReturn(1);
        int update = scoreDao.updateUserScore(restResult, 1, 1000);
        assertThat(update, equalTo(1));
    }
}
