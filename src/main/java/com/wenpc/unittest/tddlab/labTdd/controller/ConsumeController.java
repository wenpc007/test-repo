package com.wenpc.unittest.tddlab.labTdd.controller;


import com.wenpc.unittest.tddlab.labTdd.service.IConsumeService;
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
public class ConsumeController {

    @Autowired
    private IConsumeService consumeService;

    @PostMapping("/buyGood")
    public Map<String, Object> buyGood(int id, int useMoney, String goodName) {
        RestResult restResult = RestResult.create();
        consumeService.buyGood(restResult, id, useMoney, goodName);
        return restResult.outResult();
    }
}
