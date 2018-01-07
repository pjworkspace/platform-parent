package cn.hlb.platform.admin.web.controller;


import cn.hlb.platform.admin.web.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 登录控制器
 *
 * @author jun
 * @Date 2017年1月10日 下午8:25:24
 */
@Controller
public class LoginController extends BaseController {



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "/login";
    }

    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/indexpages", method = RequestMethod.GET)
    public String main(Model model) {
        return "/index";
    }

}
