package com.example.activiti.identity.session;


import com.example.activiti.identity.service.AiaRoleManager;
import com.example.activiti.identity.entity.AiaRole;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Henry Yan
 */
public class AiaGroupEntityManager extends GroupEntityManager {

    private AiaRoleManager aiaRoleManager;

    public void setAiaRoleManager(AiaRoleManager aiaRoleManager) {
        this.aiaRoleManager = aiaRoleManager;
    }


    @Override
    public GroupQuery createNewGroupQuery() {
        return super.createNewGroupQuery();
    }



    @Override
    public List<Group> findGroupsByUser(String userId) {
        List<AiaRole> roles = aiaRoleManager.findByUserId(userId);
        List<Group> groups = new ArrayList<Group>(roles.size());
        for (AiaRole aiaRole : roles) {
            GroupEntity group = new GroupEntity();
            group.setName(aiaRole.getRoleName()); // 角色中文名称
            group.setId(aiaRole.getRoleCode()); // 角色英文名称
            groups.add(group);
        }
        return groups;
    }

    @Override
    public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page) {
        List<AiaRole> roles = aiaRoleManager.findByUserId(query.getUserId());
        List<Group> groups = new ArrayList<Group>(roles.size());
        for (AiaRole aiaRole : roles) {
            GroupEntity group = new GroupEntity();
            group.setName(aiaRole.getRoleName()); // 角色中文名称
            group.setId(aiaRole.getRoleCode()); // 角色英文名称
            groups.add(group);
        }
        return groups;
//        return super.findGroupByQueryCriteria(query, page);
    }
}
