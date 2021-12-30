package com.wenpc.unittest.tddlab.labTdd.service.impl;

import com.wenpc.unittest.tddlab.labTdd.dao.IRechargeDao;
import com.wenpc.unittest.tddlab.labTdd.dao.IUserDao;
import com.wenpc.unittest.tddlab.labTdd.entity.LabUser;
import com.wenpc.unittest.tddlab.labTdd.service.IRechargeService;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
@Service
public class RechargeService implements IRechargeService {

    @Autowired
    private IRechargeDao rechargeDao;

    @Autowired
    private IUserDao userDao;

    @Override
    public int addMoney(RestResult opResult, int id, int addMoney) {
        LabUser user =  userDao.getUser(opResult,id);
        int result = -1;
        if(user==null){
            opResult.addError("用户不存在！");
        }else{
            if(addMoney<=0){
                opResult.addError("充值金额必须大于零！");
            }else if(addMoney>2000){
                opResult.addError("单次充值金额不得大于2000元整！");
            }else
                result = rechargeDao.addMoney(opResult, id, addMoney);
        }

        return result;
    }

}
