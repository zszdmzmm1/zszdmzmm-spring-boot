package com.auefly.sb04ssm.controller;


import com.auefly.sb04ssm.pojo.Post;
import com.auefly.sb04ssm.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    List<Post> index(@RequestParam(value = "page", defaultValue = "1") int page,
                     @RequestParam(value = "perPage", defaultValue = "10") int perPage)
    {
        return postService.getByPage(perPage, (page - 1) * perPage);
    }

    @PostMapping
    void store(@RequestBody Post post) {
        postService.save(post);
    }

    @GetMapping("/{id}")
    Post show(@PathVariable long id) {
        return postService.getById(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable long id, @RequestBody Post post) {
        post.setPid(id);
        postService.update(post);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id) {
        postService.deleteById(id);
    }

}
