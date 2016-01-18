package sfk.bbs.test.testSpringMVCConfig.aop.dao;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
@Aspect
public class BaseDaoAop
{
    @After("execution(* sfk.bbs.test.testSpringMVCConfig.dao.serviceImpl.CommonBasedaoImpl.executeQuery(..))")
    public void closeResultset(JoinPoint jointPoint)
    {
        
        System.out.println("close ResultSet");
    }
    
    @AfterReturning("execution(* sfk.bbs.test.testSpringMVCConfig.dao.serviceImpl.CommonBasedaoImpl.executeQuery(..))")
    public void closeResultset2(JoinPoint jointPoint)
    {
        
        System.out.println("close ResultSet");
    }
}
