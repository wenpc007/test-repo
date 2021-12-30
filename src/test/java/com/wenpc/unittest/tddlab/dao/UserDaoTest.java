package com.wenpc.unittest.tddlab.dao;

import com.wenpc.unittest.tddlab.labTdd.dao.IUserDao;
import com.wenpc.unittest.tddlab.labTdd.dao.impl.UserDao;
import com.wenpc.unittest.tddlab.labTdd.entity.LabUser;
import com.wenpc.unittest.tddlab.utils.ReflectionTddUtils;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
@SpringBootTest
public class UserDaoTest {

    private static SqlSessionTemplate sqlSessionTemplate;
    private static IUserDao userDao;
    private static RestResult restResult = RestResult.create();

    @BeforeClass
    public static void beforeClass() throws NoSuchFieldException, IllegalAccessException {
        sqlSessionTemplate = mock(SqlSessionTemplate.class);
        userDao = new UserDao();
        ReflectionTddUtils.setFieldValue(userDao, "sqlSessionTemplate", sqlSessionTemplate);
    }


    @Test
    public void space() {
        assertThat(userDao.space(), equalTo("UserDao"));
    }

    @Test
    public void addUser() {
        LabUser labUser = new LabUser();
        labUser.setId(1);
        labUser.setUsername("张三");
        when(sqlSessionTemplate.insert(userDao.space() + ".insertUser", labUser)).thenReturn(1);
        int update = userDao.addUser(restResult, labUser);
        assertThat(update, equalTo(1));
    }

    @Test
    public void getUser() {
        Map<Object, Object> params = new HashMap<>();
        params.put("condition", " and id = 1");
        LabUser labUser = new LabUser();
        labUser.setId(1);
        labUser.setUsername("张三");
        List<Object> rows = new ArrayList<>();
        rows.add(labUser);
        when(sqlSessionTemplate.selectList(userDao.space() + ".queryLabUsers", params)).thenReturn(rows);
        LabUser labUserReturn = userDao.getUser(restResult, 1);
        assertThat(labUserReturn.getId(), equalTo(labUser.getId()));
    }


    @Test
    public void queryLabUsers() {
        Map<Object, Object> params = new HashMap<>();
        params.put("condition", " and id = 1");
        LabUser labUser = new LabUser();
        labUser.setId(1);
        labUser.setUsername("张三");
        List<Object> rows = new ArrayList<>();
        rows.add(labUser);
        when(sqlSessionTemplate.selectList(userDao.space() + ".queryLabUsers", params)).thenReturn(rows);
        List<LabUser> rowsReturn = userDao.queryLabUsers(restResult, " and id = 1");
        assertThat(rowsReturn.get(0).getId(), equalTo(labUser.getId()));
    }
}
