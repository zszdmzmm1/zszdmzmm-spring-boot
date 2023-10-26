package com.auefly.sb07actuator;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.condition.ConditionsReportEndpoint;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest(properties = "management.endpoints.web.exposure.include=*")
@AutoConfigureMockMvc
public class ActuatorExposeAllTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("management.endpoints.web.exposure.include=* /actuator")
    void actuatorAllTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/actuator"))
                .andExpect(MockMvcResultMatchers.jsonPath("_links").value(Matchers.aMapWithSize(Matchers.greaterThan(3))))
                .andExpect(MockMvcResultMatchers.jsonPath("_links").value(Matchers.hasKey("beans")))
                .andExpect(MockMvcResultMatchers.jsonPath("_links").value(Matchers.hasKey("conditions")))
                .andExpect(MockMvcResultMatchers.jsonPath("_links").value(Matchers.hasKey("mappings")));
    }


    @Test
    @DisplayName("management.endpoints.web.exposure.include=* /actuator/beans")
    void actuatorBeansTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/actuator/beans"))
                .andExpect(MockMvcResultMatchers.jsonPath("contexts.application.beans").value(Matchers.hasKey("dispatcherServlet")))
                .andExpect(MockMvcResultMatchers.jsonPath("contexts.application.beans").value(Matchers.hasKey("sb07ActuatorApplication")))
                .andExpect(MockMvcResultMatchers.jsonPath("contexts.application.beans").value(Matchers.hasKey("healthEndpoint")))
                .andExpect(MockMvcResultMatchers.jsonPath("contexts.application.beans").value(Matchers.hasKey("defaultServletHandlerMapping")))
                .andExpect(MockMvcResultMatchers.jsonPath("contexts.application.beans").value(Matchers.hasKey("viewResolver")));
    }


    @Test
    @DisplayName("management.endpoints.web.exposure.include=* /actuator/conditions")
    void actuatorConditionsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/actuator/conditions"))
                .andExpect(MockMvcResultMatchers.jsonPath("contexts.application").value(Matchers.aMapWithSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("contexts.application").value(Matchers.hasKey("unconditionalClasses")))
                .andExpect(MockMvcResultMatchers.jsonPath("contexts.application.positiveMatches").value(Matchers.hasKey(Matchers.containsStringIgnoringCase("tomcat"))))
                .andExpect(MockMvcResultMatchers.jsonPath("contexts.application.negativeMatches").value(Matchers.hasKey(Matchers.containsStringIgnoringCase("netty"))))
                .andExpect(MockMvcResultMatchers.jsonPath("contexts.application.negativeMatches").value(Matchers.hasKey(Matchers.containsStringIgnoringCase("jetty"))));
    }

    @Test
    @DisplayName("management.endpoints.web.exposure.include=* /actuator/mappings")
    void actuatorMappingsTest(@Autowired ConditionsReportEndpoint conditionsReportEndpoint) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/actuator/mappings"))
                .andExpect(MockMvcResultMatchers.jsonPath("contexts.application.mappings.servlets").exists());
    }


}
