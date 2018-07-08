package com.example.activiti.chapter7.dao;

import com.example.activiti.chapter7.entity.Leave;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * @author zhouheng
 */
@Repository
public class LeaveDao {

    //TODO 打開这里
//    @Autowired
//    private SessionFactory sessionFactory;

    /**
     * 保存实体
     */
    public void save(Leave entity) {
        getSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        getSession().delete(get(id));
    }

    public Leave get(Long id) {
        return (Leave) getSession().get(Leave.class, id);
    }

    private Session getSession() {
        return null;//TODO 替換
//        return sessionFactory.getCurrentSession();
    }

}
