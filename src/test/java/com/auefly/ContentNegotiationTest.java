package com.auefly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class ContentNegotiationTest {
    @Test
    @DisplayName("ContentNegotiation: xml")
    public void requestBody(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/xml-and-json");
        mockMvc.perform(mockHttpServletRequestBuilder.accept(MediaType.APPLICATION_XML))
                .andExpect(MockMvcResultMatchers.content().string("<Pet>" +
                        "<name>jerry</name>" +
                        "<weight>12.7</weight>" +
                        "</Pet>"));
    }

    @Test
    @DisplayName("ContentNegotiation: json")
    public void favorParam(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/xml-and-json?format=json");
        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(MockMvcResultMatchers.content().string(""" 
                        {"name":"jerry","weight":12.7}"""));
    }
}
