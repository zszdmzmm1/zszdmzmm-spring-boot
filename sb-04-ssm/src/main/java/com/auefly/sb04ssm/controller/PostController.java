package com.auefly.sb04ssm.controller;


import com.auefly.sb04ssm.pojo.Post;
import com.auefly.sb04ssm.service.PostService;
import com.auefly.sb04ssm.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    R index(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "perPage", defaultValue = "10") int perPage)
    {
        return R.ok(postService.getByPage(perPage, (page - 1) * perPage));
    }

    @PostMapping
    int store(@RequestBody Post post) {
        return postService.save(post);
    }

    @GetMapping("/{id}")
    Post show(@PathVariable long id) {
        return postService.getById(id);
    }

    @PutMapping("/{id}")
    int update(@PathVariable long id, @RequestBody Post post) {
        post.setPid(id);
        return postService.update(post);
    }

    @DeleteMapping("/{id}")
    int delete(@PathVariable long id) {
        return postService.deleteById(id);
    }
}
