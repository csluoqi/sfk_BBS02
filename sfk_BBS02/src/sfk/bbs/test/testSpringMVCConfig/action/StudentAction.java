package sfk.bbs.test.testSpringMVCConfig.action;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import sfk.bbs.common.constance.ActionURL;
import sfk.bbs.common.constance.PagePath;
import sfk.bbs.common.springUtil.SpringHelper;
import sfk.bbs.test.testSpringMVCConfig.domain.StudentOfTestSpringMVC;
import sfk.bbs.test.testSpringMVCConfig.service.StudentService;
/**
 * 用于测试搭建的SpringMVC的类
 * @author rocky
 *
 */
@Controller
public class StudentAction
{
    @Autowired
    private StudentService studentService;
    public static Logger log = Logger.getLogger(StudentAction.class);
    /**
     * 1.现在的想法是把pages文件夹写在SpringMVC的配置文件中,将后缀.jsp也写在SpringMVC的配置文件中
     * 在Controller中page页面写成这样"testPage/studentList
     * 斜杠左边的pages文件夹下面的下一层文件夹,斜杠右边的是jsp文件
     * 2.jsp文件名和requestMapping中的value相同
     * 3.注意:requestMapping不写.do,页面不写.jsp
     * 
     * 查找所有的student列表
     * @param request request
     * @param response response
     * @param model model
     * @return studentList
     * @throws SQLException 
     */
    @RequestMapping(value=ActionURL.STUDENT_LIST)
    public String findAllStudent(HttpServletRequest request,
            HttpServletResponse response,Model model) throws SQLException
    {
        //查找所有
        //List<StudentOfTestSpringMVC> student =
        
        List<StudentOfTestSpringMVC>  studentList = studentService.findAllStudent();
        System.out.println("size : "+studentList.size());
        return PagePath.STUDENT_LIST;
    }
    
}
