package entity.dao;

import java.util.List;

/**
 * dao接口的基础类
 * @author lxy
 * @create 2019-02-12 12:49
 **/
public interface IBaseDao<T> {

    void save(T t);

    void update(T t);

    void delete(Long id);

    T findById(Long id);

    List<T> findAll();
}
