package sfk.bbs.test.testSpringMVCConfig.exception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sfk.bbs.common.databaseUtil.DataBaseHelper;

public class DataAccessException extends RuntimeException
{
    /**
     * 
     */
    private static final long serialVersionUID = -5764150035487032327L;

    public DataAccessException()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public DataAccessException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public DataAccessException(String message, Throwable cause)
    {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public DataAccessException(String message)
    {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public DataAccessException(Throwable cause)
    {
        super(cause);
        // TODO Auto-generated constructor stub
    }
    /**
     * 回调接口
     * @author rocky
     *
     * @param <E>
     */
 protected interface CallBack<E>
 {
     E doInCallBack(Connection conn, PreparedStatement pstm, ResultSet rs)throws Throwable;
     
 }
 protected <E> E template(CallBack<E> callback) throws DataAccessException
 {
     Connection conn = null;
     PreparedStatement pstm = null;
     ResultSet rs = null;
     conn = DataBaseHelper.getDbInstance().getConnection();
     try
    {
        return callback.doInCallBack(conn, pstm, rs);
    } catch (Throwable e)
    {
        throw new DataAccessException(e);
    }
     finally
     {
         DataBaseHelper.getDbInstance().CloseConnection(conn, pstm, rs);
     }
 }
}
