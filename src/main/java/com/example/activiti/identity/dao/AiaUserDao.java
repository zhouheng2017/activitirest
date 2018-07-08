package com.example.activiti.identity.dao;

import com.example.activiti.identity.entity.AiaUser;
import org.activiti.engine.identity.User;

import java.util.List;

/**
 * @author: Henry Yan
 */
public interface AiaUserDao {

    void save(AiaUser user);

    void delete(String id);

    AiaUser get(String id);

    AiaUser findByLoginName(String loginName);

    AiaUser findUserById(String userId);

    List<User> getAllUserAndRole();

    List<AiaUser> getdepartment();
}
