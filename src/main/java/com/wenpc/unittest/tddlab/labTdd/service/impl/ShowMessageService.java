package com.wenpc.unittest.tddlab.labTdd.service.impl;

import com.wenpc.unittest.tddlab.labTdd.service.IShowMessageService;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.springframework.stereotype.Service;

@Service
public class ShowMessageService implements IShowMessageService {

    @Override
    public String ShowMessage(RestResult opResult, String msg) {
        String result = "Hello,";
        return result.concat(msg);
    }
}
