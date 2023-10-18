package com.auefly;

import com.auefly.config.MyProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.UseMainMethod;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MyFirstTest {
    @Test
    @DisplayName("第一个SpringBootTest: @AutoConfigureMockMvc mockMvc.perform()")
    void homePageTest(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is(200))
                //equals to
                .andExpect(status().isOk())
                
                .andExpect(content().string("Hello World!"));
    }

    @Test
    @DisplayName("properties是否与自己写的类呈映射关系")
    void exampleTest(@Autowired MyProperties myProperties) {
        Assertions.assertEquals(myProperties.getAge(), 4);
        Assertions.assertEquals(myProperties.getName(), "myName");
    }
}