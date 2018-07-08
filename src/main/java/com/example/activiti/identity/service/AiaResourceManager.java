package com.example.activiti.identity.service;


import com.example.activiti.identity.entity.AiaResource;

/**
 * 资源实体管理器
 * @author: Henry Yan
 */
public interface AiaResourceManager {

    // 根据ID查询资源
    AiaResource get(Long id);

    // 保存资源
    AiaResource save(AiaResource user);

    // 删除资源
    void delete(Long id);

}
