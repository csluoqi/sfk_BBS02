package sfk.bbs.common.databaseUtil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import sfk.bbs.common.springUtil.SpringHelper;


public class DataBaseHelper
{
    private static Logger log = Logger.getLogger(DataBaseHelper.class);
    private static DataBaseHelper databaseInstance;
    private static DataSource  dataSource;
    public  static DataBaseHelper getDbInstance()
    {
        /**
         * 单例模式,
         */
        if (databaseInstance == null)
        {
            synchronized (DataBaseHelper.class)
            {
                if (databaseInstance == null)
                {
                    databaseInstance = new DataBaseHelper();
                    dataSource = (ComboPooledDataSource)SpringHelper.getSpringHelper().getBean("dataSourceLocal");
                }   
            }
        }
        return databaseInstance;
    }

    /**
     * 获取连接
     * @return Connection
     */
    public synchronized  Connection getConnection()
    {
/*        try
        {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e)
        {
            System.out.println(" registerDriver fail");
        }
        
        String url = "jdbc:mysql://localhost:3306/hibernate?useUnicode=true&characterEncoding=utf-8";
        String userName = "root";
        String password = "2011211961";
        */
        
        Connection conn = null;
        try
        {
            conn = dataSource.getConnection();
        } catch (SQLException e)
        {
            log.info("get connection failed");
            log.info(e.getMessage());
            return null;
        }
        return conn;
    }
    /**
     * 关闭连接
     * @param conn conn
     * @param stm  stm 
     * @param rs rs
     */
    public synchronized void CloseConnection(Connection conn,Statement stm,ResultSet rs)
    {
        try
        {
            if (rs != null)
            {
                rs.close();
            }
        } catch (SQLException e)
        {
            log.info(e.getMessage());
        }
        
        try
        {
            if (stm != null)
            {
                stm.close();
            }
        } catch (SQLException e)
        {
            log.info(e.getMessage());
        }
        
        try
        {
            if (conn != null)
            {
                conn.close();
            }
        } catch (SQLException e)
        {
            log.info(e.getMessage());
        }
    }
}
