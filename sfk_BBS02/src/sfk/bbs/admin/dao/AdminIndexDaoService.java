package sfk.bbs.admin.dao;

import java.util.List;

import sfk.bbs.admin.entity.FatherModule;

/**
 * 后台管理Dao层的接口
 * @author rocky
 *
 */
public interface AdminIndexDaoService
{
    /**
     * 查找所有的父板块
     * @return 父板块集合
     */
    List<FatherModule> findAllFatherModule();
    
    Boolean deleteFatherModule(Long id);
}
