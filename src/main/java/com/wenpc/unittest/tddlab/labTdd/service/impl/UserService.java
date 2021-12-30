package com.wenpc.unittest.tddlab.labTdd.service.impl;

import com.wenpc.unittest.tddlab.labTdd.dao.IUserDao;
import com.wenpc.unittest.tddlab.labTdd.entity.LabUser;
import com.wenpc.unittest.tddlab.labTdd.service.IUserService;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public int addUser(RestResult opResult, LabUser labUser) {
        int update = userDao.addUser(opResult, labUser);
        if (update == 0) {
            opResult.addError("新增用户失败!");
        }
        opResult.setSuccess("新增成功!");
        return update;
    }

    @Override
    public LabUser getUser(RestResult opResult, int id) {
        LabUser labUser = userDao.getUser(opResult, id);
        if (labUser == null) {
            opResult.addError("未取得这个用户资料：id=" + id);
        }
        return labUser;
    }

    @Override
    public List<LabUser> queryLabUsers(RestResult restResult, String condition) {
        return userDao.queryLabUsers(restResult, condition);
    }
}
