package sfk.bbs.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
        //判断是否有子版块，有子版块则不能删除，
        
        
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
    
        return adminIndexDao.getFatherModuleById(id);
    }
    @Override
    public boolean updateFatherModuel(FatherModule fatherModule)
    {
        // TODO Auto-generated method stub
        return adminIndexDao.updateFatherModule(fatherModule);
    }
    @Override
    public boolean saveSonModule(SonModule sonModule)
    {
        log.info(sonModule.getFatherModule());
        FatherModule fatherModule = getFatherModuelById(sonModule.getFatherModule().getId());
        sonModule.setFatherModule(fatherModule);
        return adminIndexDao.saveSonModule(sonModule);
    }
    @Override
    public List<SonModule> findAllSonModules()
    {
        return adminIndexDao.findAllSonModules();
    }
    @Override
    public boolean deleteSonModule(SonModule sonModule)
    {
        
        return adminIndexDao.deleteSonModule(sonModule);
    }
    @Override
    public boolean updateSonModule(SonModule sonModule)
    {
        return adminIndexDao.updateSonModule(sonModule);
    }
    @Override
    public SonModule getSonModuelById(long id)
    {
        return adminIndexDao.getSonModuleById(id);
    }
    @Override
    public List<FatherModule> processParmeters(HttpServletRequest request) 
    {
        Enumeration<String> sorts = request.getParameterNames();
        //sorts.
        List<FatherModule> fatherModules = new ArrayList<FatherModule>(10);
        FatherModule fatherModule = null;
        String sortTemp = null;
        
        
            try
            {
                while(sorts.hasMoreElements())
                {
                    
                    fatherModule = new FatherModule();
                    sortTemp = sorts.nextElement();
                    if("submit".equals(sortTemp))
                    {
                        continue;
                    }
                    log.info(sortTemp);
                    fatherModule.setId(Long.parseLong(sortTemp.split("_")[1]));//"_"是在jsp中设置的
                    fatherModule.setSort(Integer.parseInt(request.getParameter(sortTemp)));
                    fatherModules.add(fatherModule);
                }
            } catch (NumberFormatException e)
            {
                log.error(e.getMessage());
                return null;
            }
        

        return fatherModules;
    }
    
    
    @Override
    public List<SonModule> processParmetersForSonModule(
            HttpServletRequest request)
    {
        Enumeration<String> sorts = request.getParameterNames();
        //sorts.
        List<SonModule> sonModules = new ArrayList<SonModule>(10);
        SonModule sonModule = null;
        String sortTemp = null;
        
        
            try
            {
                while(sorts.hasMoreElements())
                {
                    
                    sonModule = new SonModule();
                    sortTemp = sorts.nextElement();
                    if("submit".equals(sortTemp))
                    {
                        continue;
                    }
                    log.info(sortTemp);
                    sonModule.setId(Long.parseLong(sortTemp.split("_")[1]));//"_"是在jsp中设置的
                    sonModule.setSort(Integer.parseInt(request.getParameter(sortTemp)));
                    sonModules.add(sonModule);
                }
            } catch (NumberFormatException e)
            {
                log.error(e.getMessage());
                return null;
            }
        return sonModules;
    }
    @Override
    public String sortFatherModule(List<FatherModule> fatherModules)
    {
        // TODO Auto-generated method stub
        return adminIndexDao.sortFatherModule(fatherModules);
    }
    @Override
    public String sortSonModule(List<SonModule> sonModules)
    {
        
        return adminIndexDao.sortSonModule(sonModules);
    }
    
    
    
}
