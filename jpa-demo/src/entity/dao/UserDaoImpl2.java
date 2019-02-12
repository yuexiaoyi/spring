package entity.dao;

import entity.vo.User;

/**
 * @author lxy
 * @time 2019-02-12 13:04
 **/
public class UserDaoImpl2 extends BaseDaoImpl<User> implements IUserDao2{

    public UserDaoImpl2() {
        super(User.class);
    }
}
