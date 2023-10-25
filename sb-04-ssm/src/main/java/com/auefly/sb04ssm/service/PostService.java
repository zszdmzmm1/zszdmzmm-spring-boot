package com.auefly.sb04ssm.service;

import com.auefly.sb04ssm.pojo.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll();

    List<Post> getByPage(int rowCount, int offset);

    Post getById(long id);

    int save(Post post);

    int update(Post post);

    int deleteById(long id);
}
