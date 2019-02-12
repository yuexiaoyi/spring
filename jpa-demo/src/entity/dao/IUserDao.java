package entity.dao;

import entity.vo.User;

import java.util.List;

/**
 * @author lxy
 * @create 2019-02-12 11:10
 **/
public interface IUserDao {

    void save(User user);

    void update(User user);

    void delete(User user);

    User findById(Long id);

    List<User> findAll();

}
