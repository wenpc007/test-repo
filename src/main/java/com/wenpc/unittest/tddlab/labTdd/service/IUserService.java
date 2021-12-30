package com.wenpc.unittest.tddlab.labTdd.service;


import com.wenpc.unittest.tddlab.labTdd.entity.LabUser;
import com.wenpc.unittest.tddlab.utils.RestResult;

import java.util.List;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
public interface IUserService {

    /**
     * 新增用户
     *
     * @param opResult
     * @param labUser
     * @return
     */
    public int addUser(RestResult opResult, LabUser labUser);

    /**
     * 查询用户
     *
     * @param opResult
     * @param id
     * @return
     */
    public LabUser getUser(RestResult opResult, int id);

    public List<LabUser> queryLabUsers(RestResult restResult, String condition);
}
