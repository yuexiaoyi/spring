package entity.dao;

import entity.vo.User;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @author lxy
 * @time 2019-02-12 11:14
 **/
public class UserDaoImpl implements IUserDao{
    @Override
    public void save(User user) {
        EntityManager entityManager = JPAUtil.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(user);
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public void update(User user) {
        EntityManager entityManager = JPAUtil.getInstance();
        User vo = this.findById(user.getId());
        if(vo != null){
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(user);
            entityTransaction.commit();
        }
        entityManager.close();
    }

    @Override
    public void delete(User user) {
        EntityManager entityManager = JPAUtil.getInstance();
        User vo = this.findById(user.getId());
        if(vo != null){
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(user);
            entityTransaction.commit();
        }
        entityManager.close();
    }

    @Override
    public User findById(Long id) {
        EntityManager entityManager = JPAUtil.getInstance();
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }


    @Override
    public List<User> findAll() {

        String sql = "select o from User o ";
        EntityManager entityManager = JPAUtil.getInstance();
        Query query= entityManager.createQuery(sql);
        List<User> result =  query.getResultList();
        entityManager.close();
        return result;
    }
}
