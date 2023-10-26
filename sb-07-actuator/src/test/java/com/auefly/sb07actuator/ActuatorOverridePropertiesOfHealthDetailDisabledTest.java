package com.auefly.sb07actuator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(properties = "management.endpoint.health.show-details=never")
@AutoConfigureMockMvc
public class ActuatorOverridePropertiesOfHealthDetailDisabledTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("management.endpoint.health.show-details=never, /actuator/health")
    void ActuatorWithoutHealthDetail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/actuator/health"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("components").doesNotHaveJsonPath());
    }
}
