package sfk.bbs.admin.service;

import java.util.List;

import sfk.bbs.admin.entity.FatherModule;
import sfk.bbs.admin.entity.SonModule;
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

    /**
     * 通过Id获取一个父版块对象
     * @param id 父版块id
     * @return 父版块对象
     */
    FatherModule getFatherModuelById(long id);
    
    /**
     * 更新父版块
     * @param fatherModule 父版块对象
     * @return true，更新成功，false，更新失败
     */
    boolean updateFatherModuel(FatherModule fatherModule);
    
    /**
     * 保存父版块
     * @param sonModule {@link SonModule}对象
     * @return true，保存成功，false，保存失败
     */
    boolean saveSonModule(SonModule sonModule);
    
    /**
     * 查找所有的子版块
     * @return 子版块对象的集合
     */
    List<SonModule> findAllSonModules();
/*    
    boolean checkAddReduplicateData();
    
    boolean checkUpdateReduplicateData();*/
    
}
