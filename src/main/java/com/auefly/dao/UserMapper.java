package com.auefly.dao;

import com.auefly.pojo.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select(value = "SELECT * FROM user")
    List<User> list();


    //-------------------------------------------

    @Override
    int insert(User entity);

    @Override
    int deleteById(Serializable id);

    @Override
    int deleteById(User entity);

    @Override
    default int deleteByMap(Map<String, Object> columnMap) {
        return BaseMapper.super.deleteByMap(columnMap);
    }

    @Override
    int delete(Wrapper<User> queryWrapper);

    @Override
    int deleteBatchIds(Collection<?> idList);

    @Override
    int updateById(User entity);

    @Override
    int update(User entity, Wrapper<User> updateWrapper);

    @Override
    User selectById(Serializable id);

    @Override
    List<User> selectBatchIds(Collection<? extends Serializable> idList);

    @Override
    default List<User> selectByMap(Map<String, Object> columnMap) {
        return BaseMapper.super.selectByMap(columnMap);
    }

    @Override
    default User selectOne(Wrapper<User> queryWrapper) {
        return BaseMapper.super.selectOne(queryWrapper);
    }

    @Override
    default User selectOne(Wrapper<User> queryWrapper, boolean throwEx) {
        return BaseMapper.super.selectOne(queryWrapper, throwEx);
    }

    @Override
    default boolean exists(Wrapper<User> queryWrapper) {
        return BaseMapper.super.exists(queryWrapper);
    }

    @Override
    Long selectCount(Wrapper<User> queryWrapper);

    @Override
    List<User> selectList(Wrapper<User> queryWrapper);

    @Override
    List<User> selectList(IPage<User> page, Wrapper<User> queryWrapper);

    @Override
    List<Map<String, Object>> selectMaps(Wrapper<User> queryWrapper);

    @Override
    List<Map<String, Object>> selectMaps(IPage<? extends Map<String, Object>> page, Wrapper<User> queryWrapper);

    @Override
    List<Object> selectObjs(Wrapper<User> queryWrapper);

    @Override
    default <P extends IPage<User>> P selectPage(P page, Wrapper<User> queryWrapper) {
        return BaseMapper.super.selectPage(page, queryWrapper);
    }

    @Override
    default <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<User> queryWrapper) {
        return BaseMapper.super.selectMapsPage(page, queryWrapper);
    }
}
