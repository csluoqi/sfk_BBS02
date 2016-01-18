package sfk.bbs.test.testSpringMVCConfig.dao.service;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T>
{
    /**
     * 通过Id查找对象,返回传入的对象
     * @param id 表的主见的ID
     * @return Instance
     */
    T get(Serializable id);
    /**
     * 保存一个对象到数据库
     * @param t 需要保存的对象
     * @return true,保存成功,false,保存失败
     */
    boolean save(T t);
    /**
     * 更新一个对象
     * @param id 需要更新的Id 
     * @return  true,跟新成功,false,更新失败
     */
    boolean delete(Serializable id);
    /**
     * 查找数据库中所有的数据
     * @return 集合
     */
    List<T> findAll();
}
