package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPA的工具类
 * @author lxy
 * @time 2019-02-01 14:17
 **/
public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpaDataSourcePU");
    }

    public static EntityManager getInstance() {
        return entityManagerFactory.createEntityManager();
    }

    public static void close(){
        entityManagerFactory.close();
    }

}

