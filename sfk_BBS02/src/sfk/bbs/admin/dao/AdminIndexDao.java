package sfk.bbs.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import sfk.bbs.admin.entity.FatherModule;
import sfk.bbs.admin.entity.SonModule;

/**
 * 后台管理的Dao层实现
 * 
 * @author rocky
 *
 */
@Repository
public class AdminIndexDao implements AdminIndexDaoService
{
    private static Logger log = Logger.getLogger(AdminIndexDao.class);
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<FatherModule> findAllFatherModule()
    {
        //
        final String sql = "select * from sfk_father_module;";
        List<FatherModule> fatherModules = new ArrayList<FatherModule>(1);
        jdbc.query(sql, new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                FatherModule fatherModule = new FatherModule();
                fatherModule.setId(rs.getLong("id"));
                fatherModule.setModuleName(rs.getString("module_name"));
                fatherModule.setSort(rs.getInt("sort"));
                fatherModules.add(fatherModule);
            }
        });
        // log.info("");
        return fatherModules;
    }

    @Override
    public Boolean deleteFatherModule(Long id)
    {
        final String sql = "delete from sfk_father_module where id = ?;";
        int affectrow = jdbc.update(sql, id);
        if (affectrow == 0)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean saveFatherModule(FatherModule fatherModule)
    {
        final String sql = "insert into sfk_father_module(module_name,sort)values(?,?)";
        Object[] params = { fatherModule.getModuleName(),
                fatherModule.getSort() };
        int[] paramTypes = new int[] { Types.VARCHAR, Types.INTEGER };
        int affectrow = jdbc.update(sql, params, paramTypes);
        if (affectrow != 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public FatherModule getFatherModuelById(long id)
    {
        String sql = "select fm.module_name,fm.sort from sfk_father_module as fm where fm.id = ?;";
        Object[] params = { id };
        int[] paramTypes = new int[] { Types.BIGINT };

        FatherModule fatherModule = new FatherModule();
        fatherModule.setId(id);
        jdbc.query(sql, params, paramTypes, new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                fatherModule.setModuleName(rs.getString("module_name"));
                fatherModule.setSort(rs.getInt("sort"));
            }
        });
        return fatherModule;
    }

    @Override
    public boolean updateFatherModuel(FatherModule fatherModule)
    {
        String sql = "update  sfk_father_module set module_name = ?, sort = ?  where id = ? ";
        Object[] params = new Object[] { fatherModule.getModuleName(),
                fatherModule.getSort(), fatherModule.getId() };
        int affectrow = jdbc.update(sql, params);
        if (affectrow == 1)
        {
            return false;
        }
        return false;
    }

    @Override
    public boolean saveSonModule(SonModule sonModule)
    {

        String sql = "insert into sfk_son_module "
                + " (father_module_id,module_name,info,member_id,sort) "
                + " values(?,?,?,?,?); ";
        Object[] params = new Object[] { sonModule.getFatherModule().getId(),
                sonModule.getModuleName(), sonModule.getInfo(),
                sonModule.getMemberId(), sonModule.getSort() };
        int[] paramTypes = new int[] { Types.BIGINT, Types.VARCHAR,
                Types.VARCHAR, Types.BIGINT, Types.INTEGER };
        int affectrow = jdbc.update(sql, params, paramTypes);
        if (affectrow != 0)
        {
            return true;
        }
        return false;
    }

}
