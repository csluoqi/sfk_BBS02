package sfk.bbs.test.testSpringMVCConfig.dao.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import sfk.bbs.common.constance.CommonParams;
import sfk.bbs.common.databaseUtil.DataBaseHelper;
import sfk.bbs.test.testSpringMVCConfig.dao.service.commonBaseDao;

@Repository
public class CommonBasedaoImpl implements commonBaseDao
{
    public static Logger log = Logger.getLogger(CommonBasedaoImpl.class);

    private static CommonBasedaoImpl instance;
    private static Connection conn;
    private static PreparedStatement pstm;

    public static CommonBasedaoImpl getInstance()
    {
        /**
         * 单例模式,
         */
        if (instance == null)
        {
            synchronized (CommonBasedaoImpl.class)
            {
                if (instance == null)
                {
                    instance = new CommonBasedaoImpl();
                }   
            }
        }
        return instance;
    }
    
    
    @Override
    public synchronized ResultSet executeQuery(String sql, List<Object> params)
    {
        ResultSet rs = null;
        conn = DataBaseHelper.getDbInstance().getConnection();
        try
        {
            pstm = conn.prepareStatement(sql);
            int paramSize = params.size();
            if (params != null || !params.isEmpty())
            {
                for (int i = 1; i <= paramSize; i++)
                {
                    pstm.setObject(i, params.get(i));
                }
            }
            rs = pstm.executeQuery();
        } catch (SQLException e)
        {
            log.info(e.getMessage());
        }
        // 在执行后要关闭,现在可以使用AOP,
        return rs;
    }

    @Override
    public synchronized boolean executeUpdate(String sql, List<Object> params)
    {
        conn = DataBaseHelper.getDbInstance().getConnection();
        int affectRow = 0;
        try
        {
            pstm = conn.prepareStatement(sql);
            int paramSize = params.size();
            if (params != null || !params.isEmpty())
            {
                for (int i = 1; i <= paramSize; i++)
                {
                    pstm.setObject(i, params.get(i));
                }
            }
            affectRow = pstm.executeUpdate();
            if (affectRow > CommonParams.NO_AFFECT_ROW)
            {
                return true;
            }
        } 
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        finally{
            DataBaseHelper.getDbInstance().CloseConnection(conn, pstm, null);
        }
        return false;
    }

    @Override
    public synchronized int getPrimaryKey(String sql, List<Object> params)
    {
        conn = DataBaseHelper.getDbInstance().getConnection();
        ResultSet rs = null;
        int primaryKey = 0;
        try
        {
            pstm = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            int paramSize = params.size();
            if (params != null || !params.isEmpty())
            {
                for (int i = 1; i <= paramSize; i++)
                {
                    pstm.setObject(i, params.get(i));
                }
            }
            rs = pstm.executeQuery();
            if(rs == null)
            {
                log.error("rs is null");
                return 0;
                
            }
            //获取自动生成的主键
            primaryKey = rs.getInt(1);
        } 
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        finally{
            DataBaseHelper.getDbInstance().CloseConnection(conn, pstm, null);
        }
        return primaryKey;
    }
}
