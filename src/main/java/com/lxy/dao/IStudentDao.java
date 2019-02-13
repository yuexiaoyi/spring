package com.lxy.dao;

import com.lxy.vo.StudentVO;

import java.util.List;

/**
 * @author lxy
 * @create 2019-02-12 15:58
 **/
public interface IStudentDao {

    void save(StudentVO t);

    void update(StudentVO t);

    void delete(Long id);

    StudentVO findById(Long id);

    List<StudentVO> findAll();
}
