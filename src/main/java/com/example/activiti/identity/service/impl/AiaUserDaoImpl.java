package com.example.activiti.identity.service.impl;


import com.example.activiti.identity.dao.AiaUserDao;
import com.example.activiti.identity.entity.AiaUser;
import org.activiti.engine.identity.User;

import java.util.List;

/**
 * @author: Henry Yan
 */
public class AiaUserDaoImpl implements AiaUserDao {
    @Override
    public void save(AiaUser user) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public AiaUser get(String id) {
        return new AiaUser("123", "zhouheng", "zhouheng", "userName", "15893883888@163.com", "deptId");
    }

    @Override
    public AiaUser findByLoginName(String loginName) {
        return null;
    }

    @Override
    public List<User> getAllUserAndRole() {
        return null;
    }

    @Override
    public List<AiaUser> getdepartment() {
        return null;
    }

    @Override
    public AiaUser findUserById(String userId) {
        return null;
    }
}
