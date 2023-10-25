package com.auefly.sb06doc.controller;


import com.auefly.sb06doc.service.PostService;
import com.auefly.sb06doc.pojo.Post;
import com.auefly.sb06doc.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    R store(@RequestBody Post post) {
        return R.ok(postService.save(post));
    }

    @GetMapping("/{id}")
    R show(@PathVariable long id) {
        return R.ok(postService.getById(id));
    }

    @PutMapping("/{id}")
    R update(@PathVariable long id, @RequestBody Post post) {
        post.setPid(id);
        return R.ok(postService.update(post));
    }

    @DeleteMapping("/{id}")
    R delete(@PathVariable long id) {
        return R.ok(postService.deleteById(id));
    }
}
