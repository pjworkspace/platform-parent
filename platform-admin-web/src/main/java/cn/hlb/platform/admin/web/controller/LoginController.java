package cn.hlb.platform.admin.web.controller;


import cn.hlb.platform.admin.web.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 登录控制器
 *
 * @author fengshuonan
 * @Date 2017年1月10日 下午8:25:24
 */
@Controller
public class LoginController extends BaseController {



    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        return "/index";
    }

    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET )
    public String login(Model model) {
//        //获取菜单列表
//        List<Integer> roleList = ShiroKit.getUser().getRoleList();
//        if(roleList == null || roleList.size() == 0){
//            ShiroKit.getSubject().logout();
//            model.addAttribute("tips", "该用户没有角色，无法登陆");
//            return "/login.html";
//        }
//        List<MenuNode> menus = menuDao.getMenusByRoleIds(roleList);
//        List<MenuNode> titles = MenuNode.buildTitle(menus);
//        model.addAttribute("titles", titles);
//
//        //获取用户头像
//        Integer id = ShiroKit.getUser().getId();
//        User user = userMapper.selectById(id);
//        String avatar = user.getAvatar();
//        model.addAttribute("avatar", avatar);

        return "/login";
    }

}
