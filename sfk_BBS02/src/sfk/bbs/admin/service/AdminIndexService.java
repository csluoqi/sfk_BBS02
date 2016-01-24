package sfk.bbs.admin.service;

import java.util.List;

import sfk.bbs.admin.entity.FatherModule;
/**
 * 后台管理页面的service方法
 * @author rocky
 *
 */
public interface AdminIndexService
{
    /**
     * 显示后台管理首页
     * @return 副板块的集合
     */
    List<FatherModule> findAllFatherModule();
    /**
     * 通过Id删除FatherModule
     * @param id fatherModule
     * @return true 删除成功, false, 删除失败
     */
    Boolean deleteFatherModule(Long id);
    /**
     * 新增一个父板块
     * @param fatherModule 父板块对象
     * @return true 添加成功, false 添加失败
     */
    boolean saveFatherModule(FatherModule fatherModule);
    
}