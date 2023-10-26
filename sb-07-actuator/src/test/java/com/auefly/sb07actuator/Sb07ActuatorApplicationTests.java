package com.auefly.sb07actuator;

import org.hamcrest.Matchers;
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
class Sb07ActuatorApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("default配置， /actuator")
    void defaultActuator() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/actuator"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("_links").value(Matchers.aMapWithSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("_links.self.href").value("http://localhost/actuator"))
                .andExpect(MockMvcResultMatchers.jsonPath("_links.health.href").value("http://localhost/actuator/health"));
    }

    @Test
    @DisplayName("default配置， /actuator/health")
    void defaultActuatorHealth() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/actuator/health"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("status").value("UP"));
    }

    @Test
    @DisplayName("management.endpoint.health.show-details=always, /actuator/health")
    void ActuatorContainsHealthDetail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/actuator/health"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //拥有两个default Component, 即两个指标
                .andExpect(MockMvcResultMatchers.jsonPath("components").value(Matchers.aMapWithSize(Matchers.greaterThanOrEqualTo(2))))
                .andExpect(MockMvcResultMatchers.jsonPath("components.diskSpace").hasJsonPath())
                .andExpect(MockMvcResultMatchers.jsonPath("components.ping").hasJsonPath())
                .andExpect(MockMvcResultMatchers.jsonPath("components.ping.status").value("UP"));
    }
}
