package com.auefly;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MapAndModelTest {
    @Test
    public void mapAndModelTest(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/map-and-model"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("map-and-model-show"))
                .andExpect(MockMvcResultMatchers.request().attribute("modelAttribute", "modelAttributeValue"));

        mockMvc.perform(MockMvcRequestBuilders.get("/map-and-model"))
                .andExpect(MockMvcResultMatchers.request().attribute("mapAttribute", "mapAttributeValue"))
                .andExpect(MockMvcResultMatchers.request().attribute("modelAttribute", "modelAttributeValue"));
    }
}
