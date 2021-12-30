package com.wenpc.unittest.tddlab.service;

import com.wenpc.unittest.tddlab.labTdd.dao.IUserDao;
import com.wenpc.unittest.tddlab.labTdd.entity.LabUser;
import com.wenpc.unittest.tddlab.labTdd.service.impl.UserService;
import com.wenpc.unittest.tddlab.utils.ReflectionTddUtils;
import com.wenpc.unittest.tddlab.utils.RestResult;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author wenpc
 * @create 2021-01-09
 */
@SpringBootTest
@RunWith(Parameterized.class)   //junit4 参数化测试需要加这个，而且参数需要在构造函数中初始化
public class UserServiceTest {

    private static UserService userService;
    private static RestResult opResult = RestResult.create();
    private static IUserDao userDao;
    private final String userId;
    private final String name;
    private final String age;
    private String exception;

    //构造函数，与参数collection对应
    public UserServiceTest(String userId,String name,String age,String exception){
        this.userId = userId;  //通过构造方法对参数初始化
        this.name = name;
        this.age = age;
        this.exception = exception;
    }

    @BeforeClass
    public static void beforeTest() throws NoSuchFieldException, IllegalAccessException {
        userDao = mock(IUserDao.class);
        userService = new UserService();
        ReflectionTddUtils.setFieldValue(userService, "userDao", userDao);
    }

    /**
     * 创建用户测试
     */
    @Test
    public void addUser() {
        LabUser labUser = new LabUser();
        labUser.setUsername("张三");
        labUser.setAge(12);
        when(userDao.addUser(opResult, labUser)).thenReturn(1);
        int update = userService.addUser(opResult, labUser);
        assertThat(update, equalTo(1));
    }

    @Parameterized.Parameters   //此注解标注的方法，返回参数化数据，注意返回类型是Collection
    public static Collection data(){
        return Arrays.asList(
            new String[][]{
                    {String.valueOf(54),"name1",String.valueOf(12),"成功"},
                    {String.valueOf(2),"name2", String.valueOf(12),"成功"},
                    {String.valueOf(3),"name3", String.valueOf(12),"成功"}
            }
        );
    }

    /**
     * 查询用户测试
     */
    @Test
    public void getUser() {
        int testUserId = Integer.valueOf(this.userId);

        LabUser labUserReturn = new LabUser();
        labUserReturn.setId(testUserId);
        labUserReturn.setUsername(this.name);
        when(userDao.getUser(opResult, testUserId)).thenReturn(labUserReturn);
        LabUser labUser = userService.getUser(opResult, testUserId);
        assertThat(labUser.getUsername(), equalTo(this.name));
    }

    //junit5 的参数化测试
    /*
    //硬编码数组参数
    @org.junit.jupiter.api.Test
    @ParameterizedTest
    @CsvSource({
            "1, 张三",
            "1, 李四",
            "1, 110"
    })
    public void getUserParameters(int userId,String expectUName) {
        LabUser labUserReturn = new LabUser();
        labUserReturn.setId(userId);
        labUserReturn.setUsername(expectUName);
        when(userDao.getUser(opResult, userId)).thenReturn(labUserReturn);  //桩代码
        LabUser labUser = userService.getUser(opResult, userId);
        assertThat(labUser.getUsername(), equalTo(expectUName));
    }

    //通过设置一个csv格式的文件（需要放在test下的resources目录中），来获取数据源。
    //csv文件内容为3列，id,name,exceptValue  与测试方法参数相同
    @ParameterizedTest
    @CsvFileSource(resources = "/param.csv",numLinesToSkip = 1)
    void cvsunit(int id,String name,Object exceptValue){
        System.out.println(id+"|"+name);
    }

    //最粗暴的做法，直接指向一个static方法，通过这个功能可以非常方便的获取各种数据。
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        assertEquals(5, str.length());
        assertTrue(num >=1 && num <=2);
        assertEquals(2, list.size());
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("apple", 1, Arrays.asList("a", "b")),
                arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }
    */

}
