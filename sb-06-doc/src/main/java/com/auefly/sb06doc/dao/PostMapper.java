package com.auefly.sb06doc.dao;

import com.auefly.sb06doc.pojo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
@Mapper
public interface PostMapper {
    List<Post> selectAll();

    List<Post> selectByPage(@Param("rowCount") int rowCount, @Param("offset") int offset);

    @Select("select * from post where pid = #{id}")
    Post selectById(long id);

    List<Post> selectByCondition(@Param("status") int status, @Param("title") String title, @Param("content") String content);

    List<Post> selectByCondition(Post post);

    List<Post> selectByCondition(Map<String, Object> map);

    List<Post> selectByConditionWithDynamicSQL(Map<String, Object> map);

    List<Post> selectByOneCondition(Map<String, Object> map);

    int add(Post post);

    int update(Post post);

    int deleteById(long id);

    int deleteByIds(long[] ids);
}
