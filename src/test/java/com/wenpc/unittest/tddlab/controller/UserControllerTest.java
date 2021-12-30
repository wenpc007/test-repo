package com.wenpc.unittest.tddlab.controller;

import com.wenpc.unittest.tddlab.base.ControllerTestBase;
import com.wenpc.unittest.tddlab.labTdd.controller.UserController;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional // 事务包裹，自动回滚
public class UserControllerTest extends ControllerTestBase {

    @Autowired
    private static UserController userController;

    @Override
    public void beforeTest() {
        // 测试前环境准备
        // 初始化session等
        userController = mock(UserController.class);
    }

    @Override
    public void afterTest() {
        // 测试后恢复现场
    }

    @Test
    public void addUser() throws Exception{
        // 请求api
        post("/addUser",
                new HashMap<String, String>(){{put("username","王五");put("password","123456");}},
                new HashMap<String, Object>(){{put("$.success", true); put("$.message", "新增成功!");}}
        );
    }

    //实际请求
    @Test
    public void getUser() throws Exception {
        get("/getUser",
                new HashMap<String, String>() {{
                    put("id", "1");
                }},
                new HashMap<String, Object>() {{
                    put("$.success", true);
                }}
        );
    }

    @Test
    public  void queryLabUsers() throws Exception{
        get("/queryLabUsers",
                new HashMap(){{
                    put("condition","");
                }},
                new HashMap(){{
                    put("$.success",true);
                }});
    }

    //mock Api
    @Test
    public void getMockUser() throws Exception {
        when(userController.getUser(2)).thenReturn(RestResult.create().outResult());
        get("/getUser",
                new HashMap<String, String>() {{
                    put("id", "999");
                }},
                new HashMap<String, Object>() {{
                    put("$.success", false);
                    put("$.message","用户信息不存在！");
                }}
        );

    }
}
