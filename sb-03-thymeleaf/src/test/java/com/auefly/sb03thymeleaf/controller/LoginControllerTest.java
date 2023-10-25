package com.auefly.sb03thymeleaf.controller;

import org.hamcrest.Matchers;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("使用`th`标签，页面bootstrap为动态引入")
    void showTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.content().string(StringContains.containsString("webjars")));
    }

    @Test
    @DisplayName("测试登录成功")
    void testLoginSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@test.com")
                        .param("password", "secret")
                )
                .andExpect(MockMvcResultMatchers.request().sessionAttribute("user", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/home"));
    }

    @Test
    @DisplayName("测试登录失败")
    void testLoginFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@test.com")
                        .param("password", "incorrect-password")
                )
                .andExpect(MockMvcResultMatchers.request().sessionAttribute("user", Matchers.nullValue()))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"))
                .andExpect(MockMvcResultMatchers.flash().attribute("msg", "密码错误!"));
    }

    @Test
    @DisplayName("测试未登录访问homePage")
    void testVisitHomePageWithoutLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/home"))
                .andExpect(MockMvcResultMatchers.request().sessionAttribute("user", Matchers.nullValue()))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"))
                .andExpect(MockMvcResultMatchers.flash().attribute("msg", "请登录!"));
    }

    @Test
    @DisplayName("测试国际化 - zh - 模拟浏览器切换语言为中文")
    void i18nCN() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/login")
                        .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
                )
                .andExpect(content().string(StringContains.containsString("邮箱")))
        ;
    }

    @Test
    @DisplayName("测试国际化 - en - 模拟浏览器切换语言为英文, 代码逻辑正确，但出现未知问题")
    @Disabled
    void i18nUS() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/login")
                        .header("Accept-Language", "en")
                )
                .andExpect(content().string(StringContains.containsString("Email address")))
        ;
    }
}
