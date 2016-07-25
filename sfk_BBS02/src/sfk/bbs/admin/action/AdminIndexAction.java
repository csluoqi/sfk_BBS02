package sfk.bbs.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.HtmlUtils;

import sfk.bbs.admin.entity.FatherModule;
import sfk.bbs.admin.entity.SonModule;
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
        // log.info("request.getCharacterEncoding() : "+request.getCharacterEncoding());
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
     * 保存父板块 由于这里使用了POST,如果对数字没有进行校验,那么在页面直接报400 (错误描述:由客户端发送的请求是语法不正确)
     * 所以要用js做一次校验
     * 
     * @return 重定向到显示父板块列表的页面
     */
    @RequestMapping(value = ActionURL.SAVE_FATHER_MODULE, method = RequestMethod.POST)
    public String saveFatherModule(FatherModule fatherModule)
    {
        // 这里应该设置if条件，如果成功了跳转到哪里，失败了跳转到哪里
        adminIndexService.saveFatherModule(fatherModule);
        return "redirect:" + ActionURL.ADMIN_INDEX;
    }

    /***
     * 转到编辑父版块的页面
     * 
     * @param id
     *            父版块id
     * @param model
     *            model
     * @return 编辑父版块的页面
     */
    @RequestMapping(value = ActionURL.UPDATE_FATHER_MODULE_GO + "/{id}", method = RequestMethod.GET)
    public String updateFatherModuleGo(@PathVariable("id") long id, Model model)
    {
        // 因为这里用的是get方式，所以用户可以自己输入
        // 例如localhost:8080/sfk_BBS02/updateFatherModuleGo/80ad，此时页面会报400，所以应该做一个访问出错的页面
        // 最好可以定时跳转到bbs
        model.addAttribute("fatherModule",
                adminIndexService.getFatherModuelById(id));
        return PagePath.UPDATE_FATHER_MODULE;
    }

    // 之后跳转到首页（因为在前端已经做了验证了不会出现异常，如果出现异常的情况不考虑）
    /**
     * 更新父版块对象
     * 
     * @param fatherModule
     *            父版块对象
     * @param model
     *            model
     * @return 更新成功则跳转到父版块列表，反正，返回更新的页面
     */
    @RequestMapping(value = ActionURL.UPDATE_FATHER_MODULE)
    public String updateFatherModule(FatherModule fatherModule, Model model)
    {
        // 视频里讲到了更新操作，和新增操作是对数据进行查重，但是查重逻辑是存在问题的
        // 所以这里没有做，因为还需结合后期对sort作用的理解再做
        boolean updateSuccess = adminIndexService
                .updateFatherModuel(fatherModule);
        if (updateSuccess)
        {
            return "redirect:" + ActionURL.ADMIN_INDEX;
        } else
        {
            //这里应该将错误原因反馈到页面的
            log.error("新增失败");
            model.addAttribute("fatherModule", fatherModule);
            return PagePath.UPDATE_FATHER_MODULE;
        }
    }

    @RequestMapping(value = ActionURL.NEW_SON_MODULE_GO,method=RequestMethod.GET)
    public String newSonModule(Model model)
    {
        List<FatherModule> fatherModuleList = adminIndexService
                .findAllFatherModule();
        model.addAttribute("fatherModule", fatherModuleList);
        model.addAttribute("sonModule", new SonModule());
        return PagePath.NEW_SON_MODULE;
    }

    @RequestMapping(value = ActionURL.NEW_SON_MODULE)
    public String saveSonModule(SonModule sonModule)
    {
        // save sonModule 会员这里必须输入数字，在前台要改 待续。。。
        //如果保存成功了怎么办，如果保存失败了怎么班
        adminIndexService.saveSonModule(sonModule);
        log.info("saveSonModule");
        //保存成功了跳转到子版块列表
        //失败了返回原录入页面
        return PagePath.ADMIN_INDEX;
    }
    
    @RequestMapping(value = ActionURL.SON_MODULE_LIST,method = RequestMethod.GET)
    public String sonModuleList(Model model)
    {
       // List<SonModule> sonModuleList = adminIndexService.fin
        
        List<FatherModule> fatherModules = adminIndexService
                .findAllFatherModule();
        model.addAttribute("fatherModules", fatherModules);
        return PagePath.SON_MODULE_LIST;
    }
}
