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
                fatherModule.setModuelName(rs.getString("module_name"));
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
        Object[] params = { fatherModule.getModuelName(),
                fatherModule.getSort() };
        int[] paramTypes = new int[] { Types.VARCHAR, Types.INTEGER };
        int affectrow = jdbc.update(sql, params, paramTypes);
        if (affectrow != 0)
        {
            return true;
        }
        return false;
    }

}
