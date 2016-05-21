package sfk.bbs.test.Jquery.form.rest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sfk.bbs.admin.action.AdminIndexAction;

@RestController
public class JqueryFormRest
{
    private static Logger log = Logger.getLogger(AdminIndexAction.class);
    /**
     * 表单提交的action
     */
    @RequestMapping(value="/postJqueryForm")
    public void postJqueryForm(HttpServletRequest request,HttpServletResponse response)
    {
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        out.print("success");
        log.info("success");
    }
}
