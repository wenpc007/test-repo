package com.wenpc.unittest.tddlab.labTdd.service.impl;

import com.wenpc.unittest.tddlab.labTdd.dao.IConsumeDao;
import com.wenpc.unittest.tddlab.labTdd.dao.IUserDao;
import com.wenpc.unittest.tddlab.labTdd.entity.LabUser;
import com.wenpc.unittest.tddlab.labTdd.service.IConsumeService;
import com.wenpc.unittest.tddlab.labTdd.service.IScoreService;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
@Service
public class ConsumeService implements IConsumeService {

    @Autowired
    private IConsumeDao consumeDao;
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IScoreService scoreService;

    @Override
    public int buyGood(RestResult opResult, int id, int useMoney, String goodName) {

        LabUser labUser = userDao.getUser(opResult, id);
        if (labUser == null) {
            opResult.addError("未取得这个用户资料：id=" + id);
            return 0;
        }
        int update = consumeDao.buyGood(opResult, id, useMoney, goodName);
        labUser = userDao.getUser(opResult, id);
        int score = scoreService.calcScore(labUser.getTotalUseMoney());
        scoreService.updateUserScore(opResult, id, score);
        return update;
    }
}
