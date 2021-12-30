package com.wenpc.unittest.tddlab.labTdd.controller;

import com.wenpc.unittest.tddlab.labTdd.service.IShowMessageService;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowMessageController {
    @Autowired
    private IShowMessageService showMessage;

    @GetMapping("/showMessage")
    public String showMessage(String msg){
        RestResult restResult = RestResult.create();
        String result = showMessage.ShowMessage(restResult,msg);

        return result;
    }
}
