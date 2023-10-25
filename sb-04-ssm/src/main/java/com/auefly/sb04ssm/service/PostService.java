package com.auefly.sb04ssm.service;

import com.auefly.sb04ssm.pojo.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll();

    List<Post> getByPage(int rowCount, int offset);

    Post getById(long id);

    boolean save(Post post);

    boolean update(Post post);

    boolean deleteById(long id);
}
