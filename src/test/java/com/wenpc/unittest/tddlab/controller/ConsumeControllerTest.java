package com.wenpc.unittest.tddlab.controller;


import com.wenpc.unittest.tddlab.base.ControllerTestBase;
import com.wenpc.unittest.tddlab.labTdd.entity.LabUser;
import com.wenpc.unittest.tddlab.labTdd.service.IUserService;
import com.wenpc.unittest.tddlab.utils.ConvertUtils;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @Author 翁新锋
 * @create
 */
@SpringBootTest
@Transactional
public class ConsumeControllerTest extends ControllerTestBase {

    @Autowired
    private IUserService userService;

    private String userId;

    @Override
    public void beforeTest() {
        //测试前环境准备
        userService.addUser(RestResult.create(), new LabUser(1, "张三"));
        List<LabUser> labUsers = userService.queryLabUsers(RestResult.create(), "");
        userId = ConvertUtils.cStr(labUsers.get(0).getId());
    }

    @Override
    public void afterTest() {
        //测试后恢复现场
    }

    /**
     * 消费测试
     *
     * @throws Exception
     */
    @Test
    public void buyGood() throws Exception {
        post("/buyGood",
                new HashMap<String, String>() {{
                    put("id", userId);
                    put("useMoney", "1000");
                    put("goodName", "apple");
                }},
                new HashMap<String, Object>() {{
                    put("$.success", true);
                }}
        );
    }
}
