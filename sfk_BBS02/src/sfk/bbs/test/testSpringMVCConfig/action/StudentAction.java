package sfk.bbs.test.testSpringMVCConfig.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import sfk.bbs.common.constance.ActionURL;
import sfk.bbs.common.constance.PagePath;
import sfk.bbs.common.springUtil.SpringHelper;
import sfk.bbs.test.testSpringMVCConfig.domain.StudentOfTestSpringMVC;
import sfk.bbs.test.testSpringMVCConfig.service.StudentService;

/**
 * 用于测试搭建的SpringMVC的类
 * 
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
     * 斜杠左边的pages文件夹下面的下一层文件夹,斜杠右边的是jsp文件 2.jsp文件名和requestMapping中的value相同
     * 3.注意:requestMapping不写.do,页面不写.jsp
     * 
     * 查找所有的student列表
     * 
     * @param request
     *            request
     * @param response
     *            response
     * @param model
     *            model
     * @return studentList
     * @throws SQLException
     */
    @RequestMapping(value = ActionURL.STUDENT_LIST)
    public String findAllStudent(HttpServletRequest request,
            HttpServletResponse response, Model model) throws SQLException
    {
        // 查找所有
        // List<StudentOfTestSpringMVC> student =

        List<StudentOfTestSpringMVC> studentList = studentService
                .findAllStudent();
        System.out.println("size : " + studentList.size());
        return PagePath.STUDENT_LIST;
    }

    /**
     * 测试框架实例 转发输入学生的表单
     * 
     * @return ModelAndView
     */
    @RequestMapping(value = ActionURL.INPUT_STUDENT)
    public ModelAndView inputStudent()
    {
        log.info("12345");

        return new ModelAndView(PagePath.INPUT_STUDENT, "studentOfTestSpringMVC",
                new StudentOfTestSpringMVC());
    }

    @RequestMapping(value = ActionURL.SAVE_STUDENT, method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute StudentOfTestSpringMVC studentOfTestSpringMVC,
            BindingResult bindingResult, Model model)
    {
        log.info("into saveStudent!");
        if (bindingResult.hasErrors())
        {
            bindingResult.rejectValue("birthday", "birthday.invalid");
            FieldError fieldError = bindingResult.getFieldError();
            
            //FieldError fieldError = bindingResult.
            
            log.info("Code: " + fieldError.getCode() + ", field: "
                    + fieldError.getField());
            //model.addAttribute("student", student);
            // 如果Formatter转换失败,则返回这个页面
            //model.addAttribute("student", student);
            log.info(model.toString());
            
            return PagePath.INPUT_STUDENT;
        }
        // 如果成功,则重定向到学生的首页
        return "redirect:" + ActionURL.STUDENT_LIST;
    }
    
    @ResponseBody
    @RequestMapping("/getNameList")
    public String getNameList()
    {
        /***
         * {

"suggestions":[{"value":"sunshengli","data":"haahha"},{"value":"sunshengli","data":"haahha"}]

}
         */
        log.info("into getNameList");
        String names = "{\"suggestions\":[\"sunshengli\",\"罗志祥\",\"罗志志\",\"sifangku\"]}";
        String names2 = "{\"suggestions\":[{\"value\":\"sunshengli\",\"data\":\"hahahah\",\"count\":10},{\"value\":\"luozhizhi\",\"data\":\"qq\",\"count\":10}]}";
        return names2;
    }
}
