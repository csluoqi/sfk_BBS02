package sfk.bbs.admin.action;

import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;
import java.util.Enumeration;
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

import sfk.bbs.admin.entity.FatherModule;
import sfk.bbs.admin.entity.SonModule;
import sfk.bbs.admin.service.AdminIndexService;

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
    @RequestMapping(value =  "/adminIndex", method = RequestMethod.GET)
    public String showAdminIndex(HttpServletRequest request,
            HttpServletResponse response, Model model)
    {
        List<FatherModule> fatherModules = adminIndexService
                .findAllFatherModule();
        model.addAttribute("fatherModules", fatherModules);
        // log.info(fatherModules);
        // log.info("request.getCharacterEncoding() : "+request.getCharacterEncoding());
        return "admin/adminIndex";
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
    @RequestMapping(value = "/newFatherModule", method = RequestMethod.GET)
    public String inputNewFatherModule(HttpServletRequest request,
            HttpServletResponse response, Model model)
    {
        model.addAttribute("fatherModule", new FatherModule());
        return "admin/newFatherModule";
    }

    /**
     * 保存父板块 由于这里使用了POST,如果对数字没有进行校验,那么在页面直接报400 (错误描述:由客户端发送的请求是语法不正确)
     * 所以要用js做一次校验
     * 
     * @return 重定向到显示父板块列表的页面
     */
    @RequestMapping(value =  "/saveFatherModule", method = RequestMethod.POST)
    public String saveFatherModule(FatherModule fatherModule)
    {
        // 这里应该设置if条件，如果成功了跳转到哪里，失败了跳转到哪里
        adminIndexService.saveFatherModule(fatherModule);
        return "redirect:" + "/adminIndex";
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
    @RequestMapping(value =  "/updateFatherModuleGo" + "/{id}", method = RequestMethod.GET)
    public String updateFatherModuleGo(@PathVariable("id") long id, Model model)
    {
        // 因为这里用的是get方式，所以用户可以自己输入
        // 例如localhost:8080/sfk_BBS02/updateFatherModuleGo/80ad，此时页面会报400，所以应该做一个访问出错的页面
        // 最好可以定时跳转到bbs
        model.addAttribute("fatherModule",
                adminIndexService.getFatherModuelById(id));
        return "admin/updateFatherModule";
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
    @RequestMapping(value =  "/updateFatherModule")
    public String updateFatherModule(FatherModule fatherModule, Model model)
    {
        // 视频里讲到了更新操作，和新增操作是对数据进行查重，但是查重逻辑是存在问题的
        // 所以这里没有做，因为还需结合后期对sort作用的理解再做
        boolean updateSuccess = adminIndexService
                .updateFatherModuel(fatherModule);
        if (updateSuccess)
        {
            return "redirect:" +  "/adminIndex";
        } else
        {
            //这里应该将错误原因反馈到页面的
            log.error("新增失败");
            model.addAttribute("fatherModule", fatherModule);
            return "admin/updateFatherModule";
        }
    }

    @RequestMapping(value =  "/newSonModuleGo",method=RequestMethod.GET)
    public String newSonModule(Model model)
    {
        List<FatherModule> fatherModuleList = adminIndexService
                .findAllFatherModule();
        model.addAttribute("fatherModule", fatherModuleList);
        model.addAttribute("sonModule", new SonModule());
        return "admin/newSonModule";
    }

    @RequestMapping(value =  "/newSonModule")
    public String saveSonModule(SonModule sonModule,Model model)
    {
        // save sonModule 会员这里必须输入数字，在前台要改 待续。。。
        //如果保存成功了怎么办，如果保存失败了怎么办
        if(adminIndexService.saveSonModule(sonModule))
        {
            log.info("saveSonModule");
            //保存成功了跳转到子版块列表
            return "redirect:"+ "/sonModuleList";    
        }
        else
        {
            //失败了返回原录入页面
            //未测试，1.因为在前端已经用js验证过了，所以这里一般不会出错
            //       2.这里用了spring的表单对象，如果这里的表单数据转换为表单对象时出错，
            //那么直接在页面报400，在进入action之前就出错了，
            //对应的策略有两个，1，不用表单对象用request获取，2，给予spring的表单对象进行定制，
            //
            
            model.addAttribute("sonModule",sonModule);
            return "/newSonModuleGo";
        }
    }
    
    @RequestMapping(value = "/sonModuleList",method = RequestMethod.GET)
    public String sonModuleList(Model model)
    {
        List<SonModule> sonModuleList = adminIndexService.findAllSonModules();
        
        /*List<FatherModule> fatherModules = adminIndexService
                .findAllFatherModule();*/
        model.addAttribute("sonModuleList", sonModuleList);
        return "admin/sonModuleList";
    }
    //TODO 尝试将restcontroller的方法写在controller这个地方 结果：失败！ js也要按照删除父版块的方法写，
    //已经将代码转移到rest下面去了
    
    /**
     * 更新子版块的链接
     * @param id 子版块Id
     * @param model model
     * @return 更新子版块的页面 
     */
    @RequestMapping(value =  "/updateSonModuleGo" + "/{id}", method = RequestMethod.GET)
    public String updateSonModuleGo(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("fatherModule", adminIndexService
                .findAllFatherModule());
        model.addAttribute("sonModule",
                adminIndexService.getSonModuelById(id));
        return "admin/updateSonModule";
    }
    
    /**
     * 处理更新子版块
     * @param sonModule 子版块
     * @param model model
     * @return 跳转到子版块列表链接
     */
    @RequestMapping(value="/updateSonModule",method=RequestMethod.POST)
    public String updateSonModule(SonModule sonModule,Model model)
    {
        //更新成功之后返回更新页面，
        //更新失败之后返回更新页面
        if(adminIndexService.updateSonModule(sonModule))
        {
          return "redirect:"+"/sonModuleList";
        }
        return "redirect:"+"/updateSonModuleGo/"+sonModule.getId();
    }
    
    /**
     * 父版块排序
     * @param request HttpServletRequest
     * @param model model
     * @return 父版块列表
     */
    @RequestMapping(value="/sortFatherModule",method = RequestMethod.POST)
    public String sortFatherModule(HttpServletRequest request, Model model)
    {   //将request传到下层，然后返回action中需要的数据
        //获取数据
        List<FatherModule> fatherModules = adminIndexService.processParmeters(request);
        if(fatherModules==null)
        {
            return "redirect:"+"/adminIndex";
        }
        //数据库处理返回结果
        log.info(fatherModules);
        //返回结果 在页面的顶部设置错误（来源于底层）提示区域
        String errorInfo = adminIndexService.sortFatherModule(fatherModules);
        log.info(errorInfo);
        return "redirect:"+"/adminIndex";
    }
    
    /**
     * 子版块排序
     * @param request HttpServletRequest
     * @param model model
     * @return 子版块列表
     */
    @RequestMapping(value="/sortSonModule",method = RequestMethod.POST)
    public String sortSonModule(HttpServletRequest request, Model model)
    {   //将request传到下层，然后返回action中需要的数据
        //获取数据
        List<SonModule> sonModules = adminIndexService.processParmetersForSonModule(request);
        if(sonModules==null)
        {
            return "redirect:"+"/sonModuleList";
        }
        //数据库处理返回结果
        log.info(sonModules);
        //返回结果 在页面的顶部设置错误（来源于底层）提示区域
        String errorInfo = adminIndexService.sortSonModule(sonModules);
        log.info(errorInfo);
        return "redirect:"+"/sonModuleList";
    }    
}
