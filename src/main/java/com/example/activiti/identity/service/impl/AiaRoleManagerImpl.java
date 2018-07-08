package com.example.activiti.identity.service.impl;


import com.example.activiti.identity.dao.AiaRoleDao;
import com.example.activiti.identity.service.AiaRoleManager;
import com.example.activiti.identity.entity.AiaRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Henry Yan
 */
@Service
public class AiaRoleManagerImpl implements AiaRoleManager {

//    AiaRoleDao dao;

    @Autowired
    private AiaRoleDao aiaRoleDao;

    /*public void setDao(AiaRoleDao dao) {
        this.dao = dao;
    }*/

    @Override
    public AiaRole get(String id) {
        return aiaRoleDao.get(id);
    }

    @Override
    public List<AiaRole> findByUserId(String userId) {
        return aiaRoleDao.findByUserId(userId);
    }

    @Override
    public void save(AiaRole role) {
        aiaRoleDao.save(role);
    }

    @Override
    public void delete(String id) {
        aiaRoleDao.delete(id);

    }
}
