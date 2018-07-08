package com.example.activiti.identity.dao;


import com.example.activiti.identity.entity.AiaRole;

import java.util.List;

/**
 * @author: Henry Yan
 */
public interface AiaRoleDao {

    // 根据ID查询角色
    AiaRole get(String id);

    // 根据用户ID查询拥有的角色
    List<AiaRole> findByUserId(String userId);

    // 保存角色
    void save(AiaRole role);

    // 删除角色
    void delete(String id);



}
