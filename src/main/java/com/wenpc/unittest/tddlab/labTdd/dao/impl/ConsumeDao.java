package com.wenpc.unittest.tddlab.labTdd.dao.impl;

import com.wenpc.unittest.tddlab.labTdd.dao.IConsumeDao;
import com.wenpc.unittest.tddlab.labTdd.dao.IUserDao;
import com.wenpc.unittest.tddlab.labTdd.entity.LabBuyGood;
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
public class ConsumeDao implements IConsumeDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public String space() {
        return StringUtilsEx.rightStr(this.getClass().getName(), ".");
    }

    @Autowired
    private IUserDao userDao;

    @Override
    public int buyGood(RestResult opResult, int id, int useMoney, String goodName) {
        LabBuyGood labBuyGood = new LabBuyGood();
        labBuyGood.setUserId(id);
        labBuyGood.setGoodName(goodName);
        labBuyGood.setUseMoney(useMoney);
        int update = sqlSessionTemplate.insert(space() + ".insertBuyGood", labBuyGood);
        update += userDao.userMoneyUpdate(opResult, id, -useMoney);
        return update;
    }
}
