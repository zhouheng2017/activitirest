package com.example.activiti.identity.service;


import com.example.activiti.identity.entity.AiaUser;
import org.activiti.engine.identity.User;

import java.util.List;

/**
 * 用户管理
 * @author: Henry Yan
 */
public interface AiaUserManager {

    // 根据ID查询用户
    AiaUser get(String id);

    // 根据登录名查询用户
    AiaUser findByLoginName(String loginName);

    // 保存用户
    AiaUser save(AiaUser user);

    // 删除用户
    void delete(String id);

    AiaUser findUserById(String userId);

    List<User> getAllUserAndRole();

    List<AiaUser> getdepartment();
}
