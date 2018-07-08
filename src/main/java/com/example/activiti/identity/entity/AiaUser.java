package com.example.activiti.identity.entity;

import org.activiti.engine.impl.persistence.entity.UserEntity;

import java.util.List;

/**
 * 用户对象
 *
 * @author: Henry Yan
 */
public class AiaUser extends UserEntity{

    private static final long serialVersionUID = 1L;


    /**
     * 登陆名称
     */
    private String loginName;
    /**
     * 用户名称
     */
    private String userName;


    /**
     * 部门id
     */
    private String deptId;
    /**
     * 用户所属部门
     */
    private AiaDepartment dept;

    private List<AiaRole> roles;

    public AiaUser() {
    }

    public AiaUser(String id, String loginName, String password, String userName, String email, String deptId) {

        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.deptId = deptId;
    }


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AiaDepartment getDept() {
        return dept;
    }

    public void setDept(AiaDepartment dept) {
        this.dept = dept;
    }

    public String getDeptId() {

        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public List<AiaRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AiaRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "AiaUser{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", deptId='" + deptId + '\'' +
                ", dept=" + dept +
                ", roles=" + roles +
                '}';
    }
}
