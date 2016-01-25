package sfk.bbs.admin.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sfk.bbs.admin.dao.AdminIndexDaoService;
import sfk.bbs.admin.entity.FatherModule;

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
        // TODO Auto-generated method stub
        /**
         * 先做一个简单的校验,后期尝试有验证器做
         */
        if (fatherModule.getModuelName() == null && "".equals(fatherModule.getModuelName()))
        {
            return false;
        }
        return adminIndexDao.saveFatherModule(fatherModule);
    }

    
}
