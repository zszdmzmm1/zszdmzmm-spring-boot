package com.auefly.sb04ssm.controller;

import com.auefly.sb04ssm.pojo.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
@Sql({"/schema.sql", "/data.sql"})
class PostControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("index Matcher.hasSize(), Matcher.hasItems()")
    void index() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/posts"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("*.pid", hasSize(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("*.pid", hasItems(1, 10)));
    }

    @Test
    @DisplayName("pageTest")
    void indexWithPage() throws Exception {
        int perPage = 3;
        mvc.perform(MockMvcRequestBuilders.get("/posts").queryParam("page", "2").queryParam("perPage", perPage+""))
                .andExpect(MockMvcResultMatchers.jsonPath("*.pid", hasSize(perPage)));
    }

    @Test
    @DisplayName("store objectMapper.writeValueAsString()")
    void store() throws Exception {
        Post post = new Post();
        post.setTitle("post-title-11");
        post.setCover("/img/cover/default-cover.png");
        post.setDescription("post-title-11 description");
        post.setContent("## post-title-11 content\\nthe content paragraph 1...");
        post.setStatus(1);
        post.setUserId(1);

        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(MockMvcRequestBuilders.post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    @DisplayName("show")
    void show() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/posts/5"))
                .andExpect(MockMvcResultMatchers.jsonPath("title").value("||||||||||||||||||||||||||||||"));
    }

    @Test
    @DisplayName("update")
    void update() throws Exception {
        Post post = new Post();
        post.setTitle("just-for-wireframes__update");
        post.setStatus(0);

        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(MockMvcRequestBuilders.put("/posts/5")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    @DisplayName("delete")
    void delete() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/posts/5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}