package sfk.bbs.admin.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sfk.bbs.admin.action.AdminIndexAction;
import sfk.bbs.admin.entity.FatherModule;
import sfk.bbs.admin.service.AdminIndexService;
import sfk.bbs.common.constance.ActionURL;
import sfk.bbs.common.constance.PagePath;

/**
 * 后台管理页面中,需要通过ajax发送到后台请求
 * @author rocky
 *
 */
@RestController
@RequestMapping("/rest")
public class AdminIndexRest
{
    private static Logger log = Logger.getLogger(AdminIndexAction.class);
    @Autowired
    private AdminIndexService adminIndexService; 
    
    /**
     * 删除一个父版块
     * @param id
     * @return true 删除成功, false 删除失败
     */
    @RequestMapping(value="/fatherModule/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id)
    {
        log.info("Delete Successfully!");
        //if()
        return new ResponseEntity<Boolean>(adminIndexService.deleteFatherModule(id),HttpStatus.OK);
    }
}
