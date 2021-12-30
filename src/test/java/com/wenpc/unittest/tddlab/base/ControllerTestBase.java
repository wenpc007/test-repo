package com.wenpc.unittest.tddlab.base;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.fail;
/**
 * @Author 翁新锋
 * @create 2021-01-09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class ControllerTestBase {

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mvc;
    protected MockHttpSession session;

    @Before
    public void beforeClass() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
        beforeTest();
    }

    @After
    public void afterClass() {
        afterTest();
    }

    public abstract void beforeTest();

    public abstract void afterTest();


    private void httpCall(HttpMethod method, String uri, Map<String, String> paramObj, Map<String, Object> assertMap) throws Exception {
        HttpHeaders params = new HttpHeaders();
        Set<Map.Entry<String, String>> paramEntries = paramObj.entrySet();
        for (Map.Entry<String, String> entry : paramEntries) {
            params.add(entry.getKey(), entry.getValue());
        }
        MockHttpServletRequestBuilder requestBuilder = null;
        switch (method) {
            case GET:
                requestBuilder = MockMvcRequestBuilders.get(uri);
                break;
            case HEAD:
                requestBuilder = MockMvcRequestBuilders.head(uri);
                break;
            case POST:
                requestBuilder = MockMvcRequestBuilders.post(uri);
                break;
            case PUT:
                requestBuilder = MockMvcRequestBuilders.put(uri);
                break;
            case PATCH:
                requestBuilder = MockMvcRequestBuilders.patch(uri);
                break;
            case DELETE:
                requestBuilder = MockMvcRequestBuilders.delete(uri);
                break;
            case OPTIONS:
                requestBuilder = MockMvcRequestBuilders.options(uri);
                break;
            case TRACE:
                break;
        }
        if (requestBuilder == null) {
            fail("未指定httpMethod!");
            return;
        }
        ResultActions result = mvc.perform(requestBuilder.accept(MediaType.APPLICATION_JSON_UTF8)
                .params(params)
                .session(this.session));
        result.andExpect(MockMvcResultMatchers.status().isOk());
        Set<Map.Entry<String, Object>> entries = assertMap.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            result.andExpect(MockMvcResultMatchers.jsonPath(entry.getKey()).value(entry.getValue()));
        }
        result.andDo(MockMvcResultHandlers.print());
    }

    protected void post(String uri, Map<String, String> paramObj, Map<String, Object> assertMap) throws Exception {
        httpCall(HttpMethod.POST, uri, paramObj, assertMap);
    }

    protected void get(String uri, Map<String, String> paramObj, Map<String, Object> assertMap) throws Exception {
        httpCall(HttpMethod.GET, uri, paramObj, assertMap);
    }

    protected void delete(String uri, Map<String, String> paramObj, Map<String, Object> assertMap) throws Exception {
        httpCall(HttpMethod.DELETE, uri, paramObj, assertMap);
    }

    protected void put(String uri, Map<String, String> paramObj, Map<String, Object> assertMap) throws Exception {
        httpCall(HttpMethod.PUT, uri, paramObj, assertMap);
    }

}
