package sfk.bbs.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sfk.bbs.admin.entity.FatherModule;
import sfk.bbs.admin.service.AdminIndexService;
import sfk.bbs.common.constance.ActionURL;
import sfk.bbs.common.constance.PagePath;

/**
 * 后台管理页面
 * 
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
     * 
     * @param request
     *            request
     * @param response
     *            response
     * @param model
     *            model
     * @return 页面连接
     */
    @RequestMapping(value = ActionURL.ADMIN_INDEX, method = RequestMethod.GET)
    public String showAdminIndex(HttpServletRequest request,
            HttpServletResponse response, Model model)
    {
        List<FatherModule> fatherModules = adminIndexService
                .findAllFatherModule();
        model.addAttribute("fatherModules", fatherModules);
        // log.info(fatherModules);
        return PagePath.ADMIN_INDEX;
    }

    /**
     * 新增父板块的链接
     * 
     * @param request
     *            request
     * @param response
     *            response
     * @param model
     *            model
     * @return 父板块的链接
     */
    @RequestMapping(value = ActionURL.NEW_FATHER_MODULE, method = RequestMethod.GET)
    public String inputNewFatherModule(HttpServletRequest request,
            HttpServletResponse response, Model model)
    {
        model.addAttribute("fatherModule", new FatherModule());
        return PagePath.NEW_FATHER_MODULE;
    }

    /**
     * 保存父板块
     * 
     * @return 重定向到显示父板块列表的页面
     */
    @RequestMapping(value = ActionURL.SAVE_FATHER_MODULE, method = RequestMethod.POST)
    public String saveFatherModule(HttpServletRequest request,
            HttpServletResponse response,FatherModule fatherModule)
    {
        
        log.info(fatherModule.getModuelName());
        log.info(fatherModule);
        adminIndexService.saveFatherModule(fatherModule);
        return "redirect:"+ActionURL.ADMIN_INDEX;
    }
}
