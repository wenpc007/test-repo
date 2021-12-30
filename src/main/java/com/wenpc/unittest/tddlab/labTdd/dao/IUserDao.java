package com.wenpc.unittest.tddlab.labTdd.dao;

import com.wenpc.unittest.tddlab.labTdd.entity.LabUser;
import com.wenpc.unittest.tddlab.utils.RestResult;

import java.util.List;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
public interface IUserDao {
    public int addUser(RestResult opResult, LabUser labUser);

    public LabUser getUser(RestResult opResult, int id);

    public List<LabUser> queryLabUsers(RestResult restResult, String condition);

    public int userMoneyUpdate(RestResult restResult, int userId, int money);

    public String space();
}
