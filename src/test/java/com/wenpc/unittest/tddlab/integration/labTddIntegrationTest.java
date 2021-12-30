package com.wenpc.unittest.tddlab.integration;

import com.wenpc.unittest.tddlab.base.ControllerTestBase;
import com.wenpc.unittest.tddlab.labTdd.entity.LabUser;
import com.wenpc.unittest.tddlab.labTdd.service.IConsumeService;
import com.wenpc.unittest.tddlab.labTdd.service.IRechargeService;
import com.wenpc.unittest.tddlab.labTdd.service.IScoreService;
import com.wenpc.unittest.tddlab.labTdd.service.IUserService;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @Author
 * @create 集成测试
 */
@SpringBootTest
@Transactional
public class labTddIntegrationTest extends ControllerTestBase {

    @Autowired
    private IUserService userService;
    @Autowired
    private IConsumeService consumeService;
    @Autowired
    private IRechargeService rechargeService;
    @Autowired
    private IScoreService scoreService;

    private LabUser labUser;


    @Override
    public void beforeTest() {
        RestResult restResult = RestResult.create();
        labUser = new LabUser(1, "张三");
        //新增一个用户
        userService.addUser(restResult, labUser);
        //取出这个用户数据
        List<LabUser> labUsers = userService.queryLabUsers(restResult, String.format(" and id = %s", labUser.getId()));
        labUser = labUsers.get(0);
    }

    private void assertUserInfo(LabUser labUserTmp, int totalAddMoney, int totalUseMoney, int remainMoney, int scoreMoney) {
        assertThat("用户累计充值金额存储错误!", labUserTmp.getTotalAddMoney(), equalTo(totalAddMoney));
        assertThat("用户累计消费金额存储错误!", labUserTmp.getTotalUseMoney(), equalTo(totalUseMoney));
        assertThat("用户可用金额存储错误!", labUserTmp.getRemainMoney(), equalTo(remainMoney));
        assertThat("用户可用积分存储错误!", labUserTmp.getScore(), equalTo(scoreMoney));
    }

    @Override
    public void afterTest() {
    }

    @Test
    public void test() {
        LabUser labUserTmp = null;
        RestResult restResult = RestResult.create();

        //充值1000
        rechargeService.addMoney(restResult, labUser.getId(), 1000);
        labUserTmp = userService.getUser(restResult, labUser.getId());
        assertUserInfo(labUserTmp, 1000, 0, 1000, 0);

        //再充值2000
        rechargeService.addMoney(restResult, labUser.getId(), 2000);
        labUserTmp = userService.getUser(restResult, labUser.getId());
        assertUserInfo(labUserTmp, 3000, 0, 3000, 0);

        //消费1500
        consumeService.buyGood(restResult, labUser.getId(), 1500, "apple");
        labUserTmp = userService.getUser(restResult, labUser.getId());
        assertUserInfo(labUserTmp, 3000, 1500, 3000 - 1500, 100 + 900 * 2 + (1500 - 1000) * 3);

    }
}
