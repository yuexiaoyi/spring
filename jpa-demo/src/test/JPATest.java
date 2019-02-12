package test;

import entity.vo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.JPAUtil;

import javax.persistence.*;

/**
 * 测试CRUD
 *
 * @author lxy
 * @time 2019-01-31 17:12
 **/
public class JPATest {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    @Before
    public void init() {
        entityManager = JPAUtil.getInstance();
        entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
    }

    @After
    public void close() {
        entityTransaction.commit();
        entityManager.close();
        JPAUtil.close();
    }

    @Test
    public void save() {
        /*String persistenceUnitName = "jpaDataSourcePU";

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager entityManager = entityManagerFactory.createEntityManager();*/
        EntityManager entityManager = JPAUtil.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        //jpa默认没有事务提交
        entityTransaction.begin();
        entityManager.persist(new User("22", "22"));
        entityTransaction.commit();
        entityManager.close();
    }


    @Test
    public void update() {
        User user = entityManager.find(User.class, 1L);

        System.out.println(user);

        user.setName("11update");

        System.out.println(user);

    }


    @Test
    public void delete() {
        User user = entityManager.find(User.class, 1L);
        if (user != null) {
            entityManager.remove(user);
        }
    }


    /**
     * Jpal 不能出现表名,是能用对象名
     */
    @Test
    public void findAll() {
        String jpal = "select o from User o";
        Query query = entityManager.createQuery(jpal);
        query.getResultList().forEach(System.out::println);


    }
}
