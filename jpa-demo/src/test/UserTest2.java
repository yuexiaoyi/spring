package test;

import entity.dao.IUserDao;
import entity.dao.IUserDao2;
import entity.dao.UserDaoImpl;
import entity.dao.UserDaoImpl2;
import entity.vo.User;
import org.junit.Test;

import java.util.List;

/**
 * 抽取实现和接口的测试案例
 * @author lxy
 * @time 2019-02-12 11:26
 **/
public class UserTest2 {

    IUserDao2 userDao = new UserDaoImpl2();

    @Test
    public void testSave(){
        User user = new User("44","44");
        userDao.save(user);
    }

    @Test
    public void testUpdate(){
        User user = new User("11update","11update");
        user.setId(1L);
        userDao.update(user);
    }

    @Test
    public void testFind(){
        System.out.println(userDao.findById(5L));
    }

    @Test
    public void testFindList(){
        List<User> list = userDao.findAll();
        list.forEach(System.out::println);

    }
}
