package sfk.bbs.test.testSpringMVCConfig.dao.service;

import java.util.List;

import sfk.bbs.test.testSpringMVCConfig.domain.StudentOfTestSpringMVC;

/**
 * 面向接口编程,这里只写两个方法仅用于测试
 * @author rocky
 *
 */
public interface StudentDaoService
{
    /**
     * 查询所有的学生
     * @return 学生集合
     */
    List<StudentOfTestSpringMVC> findAll();
    /**
     * 通过Id获取一个学生的据记录
     * @param id
     * @return
     */
    StudentOfTestSpringMVC getById(Long id);
    
    
        
  
    
}
