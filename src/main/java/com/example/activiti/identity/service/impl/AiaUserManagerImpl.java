package com.example.activiti.identity.service.impl;


import com.example.activiti.identity.dao.AiaUserDao;
import com.example.activiti.identity.entity.AiaUser;
import com.example.activiti.identity.service.AiaUserManager;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户实体管理实现类
 * @author: Henry Yan
 */
@Service
public class AiaUserManagerImpl implements AiaUserManager {

//    private AiaUserDao aiaUserDao;
//    private IdentityService identityService;

//    public void setDao(AiaUserDao aiaUserDao) {
//        this.aiaUserDao = aiaUserDao;
//    }

    @Autowired
    private AiaUserDao aiaUserDao;
//    public void setIdentityService(IdentityService identityService) {
//        this.identityService = identityService;
//    }

    @Override
    public AiaUser get(String id) {
        return aiaUserDao.get(id);
    }

    @Override
    public AiaUser findByLoginName(String loginName) {
        return aiaUserDao.findByLoginName(loginName);
    }

    @Override
    public AiaUser save(AiaUser user) {
        aiaUserDao.save(user);
        User activitiUser = null;
//        if (user.getId() == null) {
//            activitiUser = identityService.newUser(user.getId().toString());
//        } else {
//            activitiUser = identityService.createUserQuery()
//                    .userId(user.getId().toString()).singleResult();
//            /** 省略代码 -> 复制user的属性到activitiUser */
//            identityService.saveUser(activitiUser);
//        }
        return user;
    }

    @Override
    public void delete(String id) {
        aiaUserDao.delete(id);
    }

    @Override
    public AiaUser findUserById(String userId) {
        return aiaUserDao.findUserById(userId);
    }

    @Override
    public List<User> getAllUserAndRole() {
        return aiaUserDao.getAllUserAndRole();
    }

    @Override
    public List<AiaUser> getdepartment() {
        return aiaUserDao.getdepartment();
    }
}
