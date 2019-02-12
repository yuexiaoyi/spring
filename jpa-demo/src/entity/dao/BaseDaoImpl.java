package entity.dao;

import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * dao实现的基础类
 * @author lxy
 * @time 2019-02-12 12:52
 **/
public class BaseDaoImpl<T> implements IBaseDao<T>{

    //定义一个class的字节码对象
    public Class<T> entityClass;

    public BaseDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void save(T t) {
        EntityManager entityManager = JPAUtil.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(t);
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public void update(T t) {
        EntityManager entityManager = JPAUtil.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(t);
        entityTransaction.commit();

        entityManager.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = JPAUtil.getInstance();
        T t = this.findById(id);
        if(t != null){
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(t);
            entityTransaction.commit();
        }
        entityManager.close();
    }

    @Override
    public T findById(Long id) {
        EntityManager entityManager = JPAUtil.getInstance();
        T vo = entityManager.find(entityClass, id);
        entityManager.close();
        return vo;
    }

    @Override
    public List<T> findAll() {
        String sql = "select o from "+ entityClass.getName() +" o ";
        EntityManager entityManager = JPAUtil.getInstance();
        Query query= entityManager.createQuery(sql);
        List<T> result =  query.getResultList();
        entityManager.close();
        return result;
    }
}
