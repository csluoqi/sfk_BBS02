package sfk.bbs.test.Jquery.form.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 学习JqueryForm的测试类
 * @author rocky
 *
 */
@Controller
public class JqueryFormAction
{
    private static Logger log = Logger.getLogger(JqueryFormAction.class);
   /**
    * 进入表单页面 
    * @return 表单页面
    */
    @RequestMapping(value="/jqueryForm")
    public String jqueryForm()
    {
        return "testPage/jqueryForm";
    }
   
}
