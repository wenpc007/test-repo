package com.wenpc.unittest.tddlab.service;

import com.wenpc.unittest.tddlab.labTdd.dao.IConsumeDao;
import com.wenpc.unittest.tddlab.labTdd.dao.IUserDao;
import com.wenpc.unittest.tddlab.labTdd.entity.LabUser;
import com.wenpc.unittest.tddlab.labTdd.service.IConsumeService;
import com.wenpc.unittest.tddlab.labTdd.service.IScoreService;
import com.wenpc.unittest.tddlab.labTdd.service.impl.ConsumeService;
import com.wenpc.unittest.tddlab.utils.ReflectionTddUtils;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
@SpringBootTest
public class ConsumeServiceTest {

    private static IConsumeService consumeService;
    private static IConsumeDao consumeDao;
    private static IUserDao userDao;
    private static IScoreService scoreService;
    private static RestResult restResult = RestResult.create();

    @BeforeClass
    public static void beforeClass() throws NoSuchFieldException, IllegalAccessException {
        consumeService = new ConsumeService();
        consumeDao = mock(IConsumeDao.class);
        userDao = mock(IUserDao.class);
        scoreService = mock(IScoreService.class);
        ReflectionTddUtils.setFieldValue(consumeService, "consumeDao", consumeDao);
        ReflectionTddUtils.setFieldValue(consumeService, "userDao", userDao);
        ReflectionTddUtils.setFieldValue(consumeService, "scoreService", scoreService);
    }

    @Test
    public void test() {
        LabUser labUser = new LabUser();
        labUser.setId(1);
        labUser.setTotalUseMoney(3000);
        when(userDao.getUser(restResult, 1)).thenReturn(labUser);
        when(scoreService.calcScore(3000)).thenReturn(1);
        when(scoreService.updateUserScore(restResult, 1, scoreService.calcScore(3000))).thenReturn(1);
        when(consumeDao.buyGood(restResult, 1, 3000, "apple")).thenReturn(1);
        int update = consumeService.buyGood(restResult, 1, 3000, "apple");
        assertThat(update, equalTo(1));

        //userId = 2   ,msg = 未取得这个用户资料：id=2    except = 0
        when(userDao.getUser(restResult, 2)).thenReturn(null);
        update = consumeService.buyGood(restResult, 2, 3000, "apple");
        assertThat(update,equalTo(0));
    }


}
