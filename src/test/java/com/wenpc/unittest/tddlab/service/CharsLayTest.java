package com.wenpc.unittest.tddlab.service;

import com.wenpc.unittest.tddlab.labTdd.service.impl.CharsLayService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class CharsLayTest {

    private static CharsLayService charLayOutService;

    /**
     * 预处理
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    @BeforeClass
    public static void beforeClass() throws IllegalAccessException,NoSuchFieldException{
        charLayOutService = new CharsLayService();
    }
    
    @Test
    public void 测试1个字符(){
        String input = "a";
        List<String> result = charLayOutService.lay(input);
        assertThat(result,equalTo(Arrays.asList("a")));
    }


    @Test
    public void 测试2个字符(){
        String input = "ab";
        List<String> result = charLayOutService.lay(input);
        assertThat(result,equalTo(Arrays.asList("ab","ba")));
    }

    @Test
    public void 测试3个字符(){
        String input = "abc";
        List<String> result = charLayOutService.lay(input);
        assertThat(result,equalTo(Arrays.asList("abc","acb","bac","bca","cab","cba")));
    }

    @Test
    public void 测试4个字符(){
        String input = "abcd";
        List<String> result = charLayOutService.lay(input);
        assertThat(result.size(),equalTo(24));
        assertThat(result.get(0),equalTo("abcd"));
        assertThat(result.get(23),equalTo("dcba"));
    }

}
