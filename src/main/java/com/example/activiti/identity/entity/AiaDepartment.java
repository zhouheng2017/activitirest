package com.example.activiti.identity.entity;

import java.util.List;

/**
 * 部门实体
 * @author: Henry Yan
 */
public class AiaDepartment {

    private String id;
    private String name;
    private String parentId;

    /**
     * 一对多，一个部门多个用户
     */
    private List<AiaUser> users;

    public AiaDepartment() {
    }

    public AiaDepartment(String id, String name, String parentId, List<AiaUser> users) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<AiaUser> getUsers() {
        return users;
    }

    public void setUsers(List<AiaUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "AiaDepartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", users=" + users +
                '}';
    }
}
