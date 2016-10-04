package sfk.bbs.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import sfk.bbs.admin.entity.FatherModule;
import sfk.bbs.admin.entity.SonModule;
import sfk.bbs.common.constance.DbStatus;

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
        int affectrow = 0;
        try
        {
            affectrow = jdbc.update(sql, id);
        } catch (DataAccessException e)
        {
            log.error(e.getMessage());
            log.error("数据库异常");;
            return false;
        }
        
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
    public FatherModule getFatherModuleById(long id)
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
    public boolean updateFatherModule(FatherModule fatherModule)
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

    @Override
    public List<SonModule> findAllSonModules()
    {
        final String sql = "select  t.id, t.module_name,   t.info,   t.member_id, t.sort,  "
                + "t2.id as fatherModuleId,  t2.module_name  as father_module_name from  sfk_son_module as t   "
                + "left join sfk_father_module as t2 ON t.father_module_id = t2.id "
                + "order by t2.id desc;";
        List<SonModule> sonModules = new ArrayList<SonModule>(10);

        jdbc.query(sql, new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                /**
                 * select t.id, t.module_name, t.info, t.member_id, t.sort,
                 * t2.id as fatherModuleId, t2.module_name
                 */
                SonModule sonModule = new SonModule();
                sonModule.setId(rs.getLong("id"));
                sonModule.setSort(rs.getLong("sort"));
                sonModule.setModuleName(rs.getString("module_name"));
                sonModule.setInfo(rs.getString("info"));
                sonModule.setMemberId(rs.getLong("member_id"));

                FatherModule fatherModule = new FatherModule();
                fatherModule.setId(rs.getLong("fatherModuleId"));
                fatherModule.setModuleName(rs.getString("father_module_name"));
                sonModule.setFatherModule(fatherModule);
                sonModules.add(sonModule);
            }

        });
        return sonModules;
    }

    @Override
    public boolean deleteSonModule(SonModule sonModule)
    {
        final String sql = "delete from sfk_son_module where id = ?;";
        int affectRow = jdbc.update(sql, sonModule.getId());
        if (affectRow == DbStatus.NO_AFFECT_ROW)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateSonModule(SonModule sonModule)
    {
        /**
         * update sfk_son_module t set t.module_name = 'module_name',
         * t.info='info',t.member_id = 1,t.sort = 1,t.father_module_id = '8'
         * where t.id = 5;
         */
        final String sql = "update sfk_son_module t set t.module_name = ?, "
                + " t.info=?,t.member_id = ?,t.sort = ?,t.father_module_id = ?"
                + " where t.id = ?;";
        /**
         * int[] paramTypes = new int[] { Types.VARCHAR, Types.INTEGER };
        int affectrow = jdbc.update(sql, params, paramTypes);
         */
        int [] paramTypes = new int[] {Types.VARCHAR,Types.VARCHAR,Types.BIGINT,
                Types.BIGINT,Types.BIGINT,Types.BIGINT};
        Object[] params = {sonModule.getModuleName(),sonModule.getInfo(),sonModule.getSort(),
                sonModule.getMemberId(),
                sonModule.getFatherModule().getId(),sonModule.getId()};
        int affectRow  = jdbc.update(sql,params,paramTypes);
        if(affectRow==DbStatus.NO_AFFECT_ROW)
        {
            return false;
        }
        return true;
    }

    @Override
    public SonModule getSonModuleById(long id)
    {
        /**
         * select t.id,t.module_name,t.sort,t.member_id,t.sort,t.father_module_id
 from sfk_son_module t where  t.id=1;

         */
        String sql = "select t.module_name,t.info,t.sort,t.member_id,t.father_module_id "
                + "from sfk_son_module t where  t.id=?;";
        
        Object[] params = { id };
        int[] paramTypes = new int[] { Types.BIGINT };

        SonModule sonModule = new SonModule();
        sonModule.setId(id);
        
        jdbc.query(sql, params, paramTypes, new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                sonModule.setModuleName(rs.getString("module_name"));
                sonModule.setSort(rs.getInt("sort"));
                sonModule.setMemberId(rs.getLong("member_id"));
                sonModule.setInfo(rs.getString("info"));
                //father_module_id
                FatherModule fatherModule = new FatherModule();
                fatherModule.setId(rs.getLong("father_module_id"));
                sonModule.setFatherModule(fatherModule);
            }
        });
        return sonModule;
    }

    @Override
    public String sortFatherModule(List<FatherModule> fatherModules) 
    {
        Connection conn = null;
        PreparedStatement pstm = null;
        try
        {
            conn = jdbc.getDataSource().getConnection();
            conn.setAutoCommit(false);
        } catch (SQLException e1)
        {
            log.error(e1.getMessage());
            return "服务器错误！";
        }
        FatherModule firstErrorFatherModule = null;
        String sql = null;
        try
        {
            for(FatherModule fatherModule :  fatherModules)
            {
                firstErrorFatherModule = fatherModule; 
                sql = "update sfk_father_module t set t.sort = ? where t.id = ?;";
                pstm = conn.prepareStatement(sql);
               
                pstm.setInt(1, fatherModule.getSort());//注意从1开始
                pstm.setLong(2, fatherModule.getId());
                pstm.executeUpdate();//注意这里为空
                
            }
            conn.commit();
        } catch (SQLException e)
        {
            log.error(e.getMessage());
            try
            {
                conn.rollback();
            } catch (SQLException e1)
            {
               log.error("后台错误");
            }
            return "sortId = "+firstErrorFatherModule.getSort();
        }
        finally
        {
            if(pstm!=null)
            {
                try
                {
                    pstm.close();
                } catch (SQLException e)
                {
                    log.error(e.getMessage());
                }
            }
            
            if(conn!=null)
            {
                try
                {
                    conn.close();
                } catch (SQLException e)
                {
                    log.error(e.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public String sortSonModule(List<SonModule> sonModules)
    {
        Connection conn = null;
        PreparedStatement pstm = null;
        try
        {
            conn = jdbc.getDataSource().getConnection();
            conn.setAutoCommit(false);
        } catch (SQLException e1)
        {
            log.error(e1.getMessage());
            return "服务器错误！";
        }
        SonModule firstErrorFatherModule = null;
        String sql = null;
        try
        {
            for(SonModule sonModule :  sonModules)
            {
                firstErrorFatherModule = sonModule; 
                sql = "update sfk_son_module t set t.sort = ? where t.id = ?;";
                pstm = conn.prepareStatement(sql);
               
                pstm.setLong(1, sonModule.getSort());//注意从1开始
                pstm.setLong(2, sonModule.getId());
                pstm.executeUpdate();//注意这里为空
                
            }
            conn.commit();
        } catch (SQLException e)
        {
            log.error(e.getMessage());
            try
            {
                conn.rollback();
            } catch (SQLException e1)
            {
               log.error("后台错误");
            }
            return "sortId = "+firstErrorFatherModule.getSort();
        }
        finally
        {
            if(pstm!=null)
            {
                try
                {
                    pstm.close();
                } catch (SQLException e)
                {
                    log.error(e.getMessage());
                }
            }
            
            if(conn!=null)
            {
                try
                {
                    conn.close();
                } catch (SQLException e)
                {
                    log.error(e.getMessage());
                }
            }
        }
        return null;
    }
    
}
