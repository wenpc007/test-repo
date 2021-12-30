package com.wenpc.unittest.tddlab.service;

import com.wenpc.unittest.tddlab.labTdd.dao.IRechargeDao;
import com.wenpc.unittest.tddlab.labTdd.dao.IUserDao;
import com.wenpc.unittest.tddlab.labTdd.entity.LabUser;
import com.wenpc.unittest.tddlab.labTdd.service.IRechargeService;
import com.wenpc.unittest.tddlab.labTdd.service.impl.RechargeService;
import com.wenpc.unittest.tddlab.utils.ReflectionTddUtils;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class RechargeServiceTest {

    private static IRechargeService rechargeService;
    private static IRechargeDao rechargeDao;
    private static IUserDao userDao;
    private static RestResult opResult = RestResult.create();

    @BeforeClass
    public static void beforeTest() throws NoSuchFieldException, IllegalAccessException {
        rechargeDao = mock(IRechargeDao.class);
        userDao = mock(IUserDao.class);
        rechargeService = new RechargeService();
        ReflectionTddUtils.setFieldValue(rechargeService, "rechargeDao", rechargeDao);
        ReflectionTddUtils.setFieldValue(rechargeService, "userDao", userDao);
    }

    @Test
    public void addMoney() {
        LabUser labUser = new LabUser();
        labUser.setUsername("张三");
        labUser.setAge(12);
        when(userDao.getUser(opResult,1)).thenReturn(labUser);
        when(rechargeDao.addMoney(opResult, 1, 1000)).thenReturn(1);
        int update = rechargeService.addMoney(opResult, 1, 1000);
        assertThat(update, equalTo(1));
    }

}
