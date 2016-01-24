package sfk.bbs.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sfk.bbs.admin.entity.FatherModule;
import sfk.bbs.admin.service.AdminIndexService;
import sfk.bbs.common.constance.ActionURL;
import sfk.bbs.common.constance.PagePath;

/**
 * 后台管理页面
 * @author rocky
 *
 */
@Controller
public class AdminIndexAction
{
    private static Logger log = Logger.getLogger(AdminIndexAction.class);
    @Autowired
    private AdminIndexService adminIndexService; 
    /**
     * 显示后台管理页面
     * @param request request
     * @param response response
     * @param model model
     * @return 页面连接
     */
    @RequestMapping(value = ActionURL.ADMIN_INDEX)
    public String showAdminIndex(HttpServletRequest request, HttpServletResponse response,
                          Model model)
    {
        List<FatherModule> fatherModules = adminIndexService.findAllFatherModule();
        model.addAttribute("fatherModules", fatherModules);
        //log.info(fatherModules);
        return PagePath.ADMIN_INDEX;
    }
}
