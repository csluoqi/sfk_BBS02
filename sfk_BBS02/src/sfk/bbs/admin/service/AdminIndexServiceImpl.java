package sfk.bbs.admin.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import sfk.bbs.admin.dao.AdminIndexDaoService;
import sfk.bbs.admin.entity.FatherModule;
import sfk.bbs.admin.entity.SonModule;

/***
 * 后台管理页面service实现类
 * @author rocky
 *
 */
@Service
public class AdminIndexServiceImpl implements AdminIndexService
{
    private static Logger log = Logger.getLogger(AdminIndexServiceImpl.class);
    @Autowired
    private AdminIndexDaoService adminIndexDao;
    @Override
    public List<FatherModule> findAllFatherModule()
    {
        return adminIndexDao.findAllFatherModule();
    }
    @Override
    public Boolean deleteFatherModule(Long id)
    {
        // TODO Auto-generated method stub
        return adminIndexDao.deleteFatherModule(id);
    }
    @Override
    public boolean saveFatherModule(FatherModule fatherModule)
    {
        fatherModule.setModuleName(HtmlUtils.htmlEscape(fatherModule
                .getModuleName()));
        if (fatherModule.getModuleName() == null && "".equals(fatherModule.getModuleName()))
        {
            return false;
        }
        //如果字符长度大于数据库中的250,则后台就要报错,因此要拦截
        if(fatherModule.getModuleName().length()>250)
        {
            return false;
        }
        return adminIndexDao.saveFatherModule(fatherModule);
    }
    @Override
    public FatherModule getFatherModuelById(long id)
    {
    
        return adminIndexDao.getFatherModuelById(id);
    }
    @Override
    public boolean updateFatherModuel(FatherModule fatherModule)
    {
        // TODO Auto-generated method stub
        return adminIndexDao.updateFatherModuel(fatherModule);
    }
    @Override
    public boolean saveSonModule(SonModule sonModule)
    {
        log.info(sonModule.getFatherModule());
        FatherModule fatherModule = getFatherModuelById(sonModule.getFatherModule().getId());
        sonModule.setFatherModule(fatherModule);
        return adminIndexDao.saveSonModule(sonModule);
    }
    
}
