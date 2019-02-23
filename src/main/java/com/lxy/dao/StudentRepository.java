package com.lxy.dao;

import com.lxy.vo.StudentVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lxy
 * @create 2019-02-23 11:13
 **/
@Repository
public interface StudentRepository extends JpaRepository<StudentVO,Integer>{
}
