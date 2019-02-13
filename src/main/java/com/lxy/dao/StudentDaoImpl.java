package com.lxy.dao;

import com.lxy.vo.StudentVO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * @author lxy
 * @time 2019-02-12 16:00
 **/
@Repository
@Transactional
public class StudentDaoImpl implements IStudentDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(StudentVO t) {
        em.persist(t);
    }

    @Override
    public void update(StudentVO t) {
        em.merge(t);
    }

    @Override
    public void delete(Long id) {
        em.remove(id);
    }

    @Override
    public StudentVO findById(Long id) {
        return em.find(StudentVO.class,id);
    }

    @Override
    public List<StudentVO> findAll() {
        String sql = "select o from StudentVO o";
        Query query = em.createQuery(sql);

        query.getResultList().forEach(System.out::println);
        return null;
    }
}
