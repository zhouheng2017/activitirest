package com.example.activiti.identity.entity;

import java.util.List;

/**
 * 角色实体
 * @author: Henry Yan
 */
public class AiaRole {

    private String id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色的编码
     */
    private String roleCode;
    /**
     * 一个角色关联多个资源
     */
    private List<AiaResource> resources;

    //一个角色可能被多个用户拥有
    private List<AiaUser> users;

    public AiaRole() {
    }

    public AiaRole(String id, String roleName, String roleCode) {
        this.id = id;
        this.roleName = roleName;
        this.roleCode = roleCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public List<AiaResource> getResources() {
        return resources;
    }

    public void setResources(List<AiaResource> resources) {
        this.resources = resources;
    }

    public List<AiaUser> getUsers() {
        return users;
    }

    public void setUsers(List<AiaUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "AiaRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", resources=" + resources +
                ", users=" + users +
                '}';
    }
}
