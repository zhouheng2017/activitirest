package com.example.activiti.identity.session;


import com.example.activiti.identity.entity.AiaUser;
import com.example.activiti.identity.service.AiaUserManager;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;

import java.util.List;
import java.util.Map;

/**
 * 自定义的用户实体管理类
 * @author: Henry Yan
 */
public class AiaUserEntityManager extends UserEntityManager {

    private AiaUserManager aiaUserManager;

    @Override
    public Boolean checkPassword(String userId, String password) {
        AiaUser aiaUser = aiaUserManager.get(userId);
        return aiaUser.getPassword().equals(password);
    }


    @Override
    public User createNewUser(String userId) {
        return super.createNewUser(userId);
    }

   /* @Override
    public void insertUser(User user) {
//        AiaUser aiaUser = new AiaUser(user.getId(), user.getId(), user.getPassword(), user.getFirstName() + user.getLastName(), user.getEmail(), "deptId");

        aiaUserManager.save((AiaUser) user);
//        super.insertUser(user);
    }*/

    @Override
    public void updateUser(User updatedUser) {
        super.updateUser(updatedUser);
    }

/*    @Override
    public User findUserById(String userId) {
        return aiaUserManager.findUserById(userId);
    }*/

    /*@Override
    public void deleteUser(String userId) {
        aiaUserManager.delete(userId);

    }*/



    @Override
    public long findUserCountByQueryCriteria(UserQueryImpl query) {
        return super.findUserCountByQueryCriteria(query);
    }
    /*  @Override
        public List<User> findUserByQueryCriteria(UserQueryImpl query, Page page) {

            List<User> allUserAndRole = aiaUserManager.getAllUserAndRole();

            return allUserAndRole;
        }*/
    @Override
    public List<Group> findGroupsByUser(String userId) {
        return super.findGroupsByUser(userId);
    }

    @Override
    public UserQuery createNewUserQuery() {
        return super.createNewUserQuery();
    }

    @Override
    public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId, String key) {
        return super.findUserInfoByUserIdAndKey(userId, key);
    }

    @Override
    public List<String> findUserInfoKeysByUserIdAndType(String userId, String type) {
        return super.findUserInfoKeysByUserIdAndType(userId, type);
    }

    @Override
    public List<User> findPotentialStarterUsers(String proceDefId) {
        return super.findPotentialStarterUsers(proceDefId);
    }

    @Override
    public List<User> findUsersByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        return super.findUsersByNativeQuery(parameterMap, firstResult, maxResults);
    }

    @Override
    public long findUserCountByNativeQuery(Map<String, Object> parameterMap) {
        return super.findUserCountByNativeQuery(parameterMap);
    }

    @Override
    public boolean isNewUser(User user) {
        return super.isNewUser(user);
    }




    public void setAiaUserManager(AiaUserManager aiaUserManager) {
        this.aiaUserManager = aiaUserManager;
    }
}
