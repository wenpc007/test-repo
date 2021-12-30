package com.wenpc.unittest.tddlab.labTdd.controller;

import com.wenpc.unittest.tddlab.labTdd.service.IRechargeService;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
@RestController
public class RechargeController {

    @Autowired
    private IRechargeService rechargeService;

    @PostMapping("/addMoney")
    public Map<String, Object> addMoney(int id, int addMoney) {
        RestResult restResult = RestResult.create();
        rechargeService.addMoney(restResult, id, addMoney);
        return restResult.outResult();
    }
}
