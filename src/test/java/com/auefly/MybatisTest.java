package com.auefly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MybatisTest {


    @Test
    @DisplayName("测试纯注解的mybatis")
    public void test(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/select-user"))
                .andExpect(MockMvcResultMatchers.jsonPath("records.[0].email").value("admin@qq.com"));
    }

    @Test
    @DisplayName("分页查询测试，page里有许多可以用到的信息，查询记录，查询总数，当前页，每页大小等等")
    public void pageTest(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/select-user?page=1&count=2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("records.[1].email").value("user@qq.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("current").value(1));
    }
}
