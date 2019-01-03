package com.lxy.service;

import com.lxy.vo.UserVO;

/**
 * @author lxy
 * @time 2018-12-26 22:41
 **/
public interface UserService {
    int insertUser(UserVO vo);
    int insertUser();
    void deleteUser(UserVO vo);
    void updateUser(UserVO vo);
}
