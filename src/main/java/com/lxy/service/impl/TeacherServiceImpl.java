package com.lxy.service.impl;

import com.lxy.dao.UserDao;
import com.lxy.service.UserService;
import com.lxy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lxy
 * @time 2018-12-29 15:26
 **/
@Service("teacherService")
public class TeacherServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public int insertUser(UserVO vo) {
        userDao.insert(vo);
        System.out.println("insert Teacher");
        return 0;
    }

    @Override
    public int insertUser() {
        userDao.insert(null);
        System.out.println("insert Teacher");
        return 0;
    }

    @Override
    public void deleteUser(UserVO vo) {
        userDao.delete(vo);
        System.out.println("delete Teacher");
    }

    @Override
    public void updateUser(UserVO vo) {
        userDao.update(vo);
        System.out.println("update Teacher");
    }
}
