package com.lxy.dao;

import com.lxy.vo.UserVO;
import org.springframework.stereotype.Repository;

/**
 * @author lxy
 * @time 2018-12-26 22:41
 **/
@Repository
public class UserDao {
    public void insert(UserVO vo){
        System.out.println("insert");
    }

    public void update(UserVO vo){
        System.out.println("update");
    }

    public void delete(UserVO vo){
        System.out.println("delete");
    }
}
