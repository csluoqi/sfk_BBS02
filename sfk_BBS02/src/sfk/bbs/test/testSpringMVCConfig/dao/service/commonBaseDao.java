package sfk.bbs.test.testSpringMVCConfig.dao.service;

import java.sql.ResultSet;
import java.util.List;
/**
 * 主要是封装的了jdbc的方法
 * @author rocky
 *
 */
public interface commonBaseDao
{
    /**
     * executeQuery,主要用于查询
     * @param sql sql
     * @param params params
     * @return ResultSet
     */
    public ResultSet executeQuery(String sql,List<Object> params);
    /**
     * executeUpdate 
     * @param sql sql
     * @param params params
     * @return 影响的行数
     */
    public boolean executeUpdate(String sql,List<Object> params);
    /**
     * executeUpdate,并获取新增过程中的主见
     * @param sql sql
     * @param params params
     * @return 影响的行数
     */
    public int getPrimaryKey(String sql,List<Object> params);
    
}









