package com.wenpc.unittest.tddlab.labTdd.service;

import com.wenpc.unittest.tddlab.utils.RestResult;

/**
 * @Author wenpc
 * @create 2021-01-09
 */

public interface IShowMessageService {

    /**
     * 展示信息
     * @param msg 信息内容
     * @return 加工后的信息
     */
    public String ShowMessage(RestResult opResult, String msg);
}
