package com.auefly.service;


import com.auefly.dao.UserMapper;
import com.auefly.pojo.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
public class UserService implements IService<User> {
    @Autowired
    UserMapper mapper;

    public List<User> selectUser() {
        return mapper.list();
    }

    @Override
    public boolean save(User entity) {
        return IService.super.save(entity);
    }

    @Override
    public boolean saveBatch(Collection<User> entityList) {
        return IService.super.saveBatch(entityList);
    }

    @Override
    public boolean saveBatch(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<User> entityList) {
        return IService.super.saveOrUpdateBatch(entityList);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return IService.super.removeById(id);
    }

    @Override
    public boolean removeById(Serializable id, boolean useFill) {
        return IService.super.removeById(id, useFill);
    }

    @Override
    public boolean removeById(User entity) {
        return IService.super.removeById(entity);
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return IService.super.removeByMap(columnMap);
    }

    @Override
    public boolean remove(Wrapper<User> queryWrapper) {
        return IService.super.remove(queryWrapper);
    }

    @Override
    public boolean removeByIds(Collection<?> list) {
        return IService.super.removeByIds(list);
    }

    @Override
    public boolean removeByIds(Collection<?> list, boolean useFill) {
        return IService.super.removeByIds(list, useFill);
    }

    @Override
    public boolean removeBatchByIds(Collection<?> list) {
        return IService.super.removeBatchByIds(list);
    }

    @Override
    public boolean removeBatchByIds(Collection<?> list, boolean useFill) {
        return IService.super.removeBatchByIds(list, useFill);
    }

    @Override
    public boolean removeBatchByIds(Collection<?> list, int batchSize) {
        return IService.super.removeBatchByIds(list, batchSize);
    }

    @Override
    public boolean removeBatchByIds(Collection<?> list, int batchSize, boolean useFill) {
        return IService.super.removeBatchByIds(list, batchSize, useFill);
    }

    @Override
    public boolean updateById(User entity) {
        return IService.super.updateById(entity);
    }

    @Override
    public boolean update(Wrapper<User> updateWrapper) {
        return IService.super.update(updateWrapper);
    }

    @Override
    public boolean update(User entity, Wrapper<User> updateWrapper) {
        return IService.super.update(entity, updateWrapper);
    }

    @Override
    public boolean updateBatchById(Collection<User> entityList) {
        return IService.super.updateBatchById(entityList);
    }

    @Override
    public boolean updateBatchById(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(User entity) {
        return false;
    }

    @Override
    public User getById(Serializable id) {
        return IService.super.getById(id);
    }

    @Override
    public Optional<User> getOptById(Serializable id) {
        return IService.super.getOptById(id);
    }

    @Override
    public List<User> listByIds(Collection<? extends Serializable> idList) {
        return IService.super.listByIds(idList);
    }

    @Override
    public List<User> listByMap(Map<String, Object> columnMap) {
        return IService.super.listByMap(columnMap);
    }

    @Override
    public User getOne(Wrapper<User> queryWrapper) {
        return IService.super.getOne(queryWrapper);
    }

    @Override
    public Optional<User> getOneOpt(Wrapper<User> queryWrapper) {
        return IService.super.getOneOpt(queryWrapper);
    }

    @Override
    public User getOne(Wrapper<User> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Optional<User> getOneOpt(Wrapper<User> queryWrapper, boolean throwEx) {
        return Optional.empty();
    }

    @Override
    public Map<String, Object> getMap(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<User> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public boolean exists(Wrapper<User> queryWrapper) {
        return IService.super.exists(queryWrapper);
    }

    @Override
    public long count() {
        return IService.super.count();
    }

    @Override
    public long count(Wrapper<User> queryWrapper) {
        return IService.super.count(queryWrapper);
    }

    @Override
    public List<User> list(Wrapper<User> queryWrapper) {
        return IService.super.list(queryWrapper);
    }

    @Override
    public List<User> list(IPage<User> page, Wrapper<User> queryWrapper) {
        return IService.super.list(page, queryWrapper);
    }

    @Override
    public List<User> list() {
        return IService.super.list();
    }

    @Override
    public List<User> list(IPage<User> page) {
        return IService.super.list(page);
    }

    @Override
    public <E extends IPage<User>> E page(E page, Wrapper<User> queryWrapper) {
        return IService.super.page(page, queryWrapper);
    }

    @Override
    public <E extends IPage<User>> E page(E page) {
        return IService.super.page(page);
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<User> queryWrapper) {
        return IService.super.listMaps(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps(IPage<? extends Map<String, Object>> page, Wrapper<User> queryWrapper) {
        return IService.super.listMaps(page, queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps() {
        return IService.super.listMaps();
    }

    @Override
    public List<Map<String, Object>> listMaps(IPage<? extends Map<String, Object>> page) {
        return IService.super.listMaps(page);
    }

    @Override
    public List<Object> listObjs() {
        return IService.super.listObjs();
    }

    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return IService.super.listObjs(mapper);
    }

    @Override
    public List<Object> listObjs(Wrapper<User> queryWrapper) {
        return IService.super.listObjs(queryWrapper);
    }

    @Override
    public <V> List<V> listObjs(Wrapper<User> queryWrapper, Function<? super Object, V> mapper) {
        return IService.super.listObjs(queryWrapper, mapper);
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<User> queryWrapper) {
        return IService.super.pageMaps(page, queryWrapper);
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page) {
        return IService.super.pageMaps(page);
    }

    @Override
    public BaseMapper<User> getBaseMapper() {
        return null;
    }

    @Override
    public Class<User> getEntityClass() {
        return null;
    }

    @Override
    public QueryChainWrapper<User> query() {
        return IService.super.query();
    }

    @Override
    public LambdaQueryChainWrapper<User> lambdaQuery() {
        return IService.super.lambdaQuery();
    }

    @Override
    public LambdaQueryChainWrapper<User> lambdaQuery(User entity) {
        return IService.super.lambdaQuery(entity);
    }

    @Override
    public KtQueryChainWrapper<User> ktQuery() {
        return IService.super.ktQuery();
    }

    @Override
    public KtUpdateChainWrapper<User> ktUpdate() {
        return IService.super.ktUpdate();
    }

    @Override
    public UpdateChainWrapper<User> update() {
        return IService.super.update();
    }

    @Override
    public LambdaUpdateChainWrapper<User> lambdaUpdate() {
        return IService.super.lambdaUpdate();
    }
}
