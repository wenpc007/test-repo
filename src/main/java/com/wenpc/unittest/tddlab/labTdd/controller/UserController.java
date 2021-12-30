package com.wenpc.unittest.tddlab.labTdd.controller;

import com.wenpc.unittest.tddlab.labTdd.entity.LabUser;
import com.wenpc.unittest.tddlab.labTdd.service.IUserService;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/addUser")
    public Map<String, Object> addUser(LabUser labUser) {
        RestResult restResult = RestResult.create();
        userService.addUser(restResult, labUser);
        return restResult.outResult();
    }

    @GetMapping("/getUser")
    public Map<String, Object> getUser(@RequestParam(name="id", required=false, defaultValue="-1") int id) {
        RestResult restResult = RestResult.create();

        LabUser labUser = userService.getUser(restResult, id);
        if(labUser == null){
            restResult.addError("用户信息不存在！");
        }else
            restResult.setSuccess();
        restResult.addData("labUser", labUser);
        return restResult.outResult();
    }

    @GetMapping("/queryLabUsers")
    public Map<String, Object> queryLabUsers(@RequestParam(name="condition", required=false, defaultValue="") String condition) {
        RestResult restResult = RestResult.create();
        try{
            List<LabUser> rows = userService.queryLabUsers(restResult, condition);
            restResult.setSuccess();
            restResult.addData("rows", rows);
            return restResult.outResult();
        }
        catch (Exception e){
            restResult.addError("参数请求不符合预定格式！");
            return restResult.outResult();
        }

    }
}
