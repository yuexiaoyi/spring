package com.lxy.service.impl;

import com.lxy.dao.UserDao;
import com.lxy.service.UserService;
import com.lxy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lxy
 * @time 2018-12-26 22:42
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int insertUser(UserVO vo) {
        int flag = 1;
        userDao.insert(vo);
        if(flag == 1){
            throw new RuntimeException("insert exception!");
        }
        return 0;
    }

    @Override
    public int insertUser() {
        return 0;
    }

    @Override
    public void deleteUser(UserVO vo) {
        userDao.delete(vo);
    }

    @Override
    public void updateUser(UserVO vo) {
        userDao.update(vo);
    }
}
