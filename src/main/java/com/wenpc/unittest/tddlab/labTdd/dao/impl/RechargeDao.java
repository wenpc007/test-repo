package com.wenpc.unittest.tddlab.labTdd.dao.impl;

import com.wenpc.unittest.tddlab.labTdd.dao.IRechargeDao;
import com.wenpc.unittest.tddlab.labTdd.dao.IUserDao;
import com.wenpc.unittest.tddlab.labTdd.entity.LabAddMoney;
import com.wenpc.unittest.tddlab.utils.RestResult;
import com.wenpc.unittest.tddlab.utils.StringUtilsEx;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
@Repository
public class RechargeDao implements IRechargeDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public String space() {
        return StringUtilsEx.rightStr(this.getClass().getName(), ".");
    }

    @Autowired
    private IUserDao userDao;

    @Override
    public int addMoney(RestResult opResult, int id, int addMoney) {
        LabAddMoney labAddMoney = new LabAddMoney();
        labAddMoney.setUserId(id);
        labAddMoney.setAddMoney(addMoney);
        int update = sqlSessionTemplate.insert(space() + ".insertAddMoney", labAddMoney);
        update += userDao.userMoneyUpdate(opResult, id, addMoney);
        return update;
    }


}
