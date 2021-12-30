package com.wenpc.unittest.tddlab.dao;

import com.wenpc.unittest.tddlab.labTdd.dao.IRechargeDao;
import com.wenpc.unittest.tddlab.labTdd.dao.IUserDao;
import com.wenpc.unittest.tddlab.labTdd.dao.impl.RechargeDao;
import com.wenpc.unittest.tddlab.labTdd.entity.LabAddMoney;
import com.wenpc.unittest.tddlab.utils.ReflectionTddUtils;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
@SpringBootTest
public class RechargeDaoTest {

    private static IRechargeDao rechargeDao;
    private static SqlSessionTemplate sqlSessionTemplate;
    private static IUserDao userDao;
    private static RestResult restResult = RestResult.create();

    @BeforeClass
    public static void beforeClass() throws NoSuchFieldException, IllegalAccessException {
        sqlSessionTemplate = mock(SqlSessionTemplate.class);
        rechargeDao = new RechargeDao();
        userDao = mock(IUserDao.class);
        ReflectionTddUtils.setFieldValue(rechargeDao, "sqlSessionTemplate", sqlSessionTemplate);
        ReflectionTddUtils.setFieldValue(rechargeDao, "userDao", userDao);
    }

    @Test
    public void space() {
        assertThat(rechargeDao.space(), Matchers.equalTo("RechargeDao"));
    }

    @Test
    public void addMoney() {
        LabAddMoney labAddMoney = new LabAddMoney();
        labAddMoney.setUserId(1);
        labAddMoney.setAddMoney(1000);
        labAddMoney.setCreateTime("2020-12-10 13:12:02");
        when(sqlSessionTemplate.insert(rechargeDao.space() + ".insertAddMoney", labAddMoney)).thenReturn(1);
        when(userDao.userMoneyUpdate(restResult, 1, 1000)).thenReturn(1);
        int update = rechargeDao.addMoney(restResult, 1, 1000);
        assertThat(update, equalTo(1));
    }


}
