package sfk.bbs.portal.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 门户的控制器，处理登陆，注册，退出等action
 * @author rocky
 *
 */
@Controller
public class PortalAction
{
    @RequestMapping(value="/register")
    public String register()
    {
        return "portal/register";
    }
}
