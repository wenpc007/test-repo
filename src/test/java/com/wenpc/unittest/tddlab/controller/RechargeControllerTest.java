package com.wenpc.unittest.tddlab.controller;


import com.wenpc.unittest.tddlab.base.ControllerTestBase;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * @Author 翁新锋
 * @create
 */
@SpringBootTest
@Transactional
public class RechargeControllerTest extends ControllerTestBase {
    @Override
    public void beforeTest() {
        //测试前环境准备
        //初始化session等
    }

    @Override
    public void afterTest() {
        //测试后恢复现场
    }

    /**
     * 充值
     *
     * @throws Exception
     */
    @Test
    public void addMoney() throws Exception {
        post("/addMoney",
                new HashMap<String, String>() {{
                    put("id", "1");
                    put("addMoney", "1000");
                }},
                new HashMap<String, Object>() {{
                    put("$.success", true);
                }}
        );
    }

    /**
     * 充值Error User
     *
     * @throws Exception
     */
    @Test
    public void addMoney_errorUser() throws Exception {
        post("/addMoney",
                new HashMap<String, String>() {{
                    put("id", "0");
                    put("addMoney", "1000");
                }},
                new HashMap<String, Object>() {{
                    put("$.message", "用户不存在！");
                }}
        );
    }
}
