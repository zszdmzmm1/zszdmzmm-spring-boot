package com.auefly.sb06doc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Sql({"/data.sql", "/schema.sql"})
@SpringBootTest
@AutoConfigureMockMvc
public class SwaggerUiTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("从/swagger-ui.html跳转至/swagger-ui/index.html")
    void swaggerUi() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/swagger-ui.html"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/swagger-ui/index.html"));
    }

    @Test
    @DisplayName("真正的地址")
    void swaggerUiIndex() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/swagger-ui/index.html"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
