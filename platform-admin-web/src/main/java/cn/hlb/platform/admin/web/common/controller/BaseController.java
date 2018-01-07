package cn.hlb.platform.admin.web.common.controller;

import cn.hlb.platform.common.web.editor.DateEditor;
import cn.hlb.platform.common.web.editor.StringEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;

/**
 * 控制器支持类
 *
 * @author hlb
 */
public abstract class BaseController {

//    protected HttpServletRequest getHttpServletRequest() {
//        return HttpKit.getRequest();
//    }
//
//    protected HttpServletResponse getHttpServletResponse() {
//        return HttpKit.getResponse();
//    }
//
//    protected HttpSession getSession() {
//        return HttpKit.getRequest().getSession();
//    }
//
//    protected HttpSession getSession(Boolean flag) {
//        return HttpKit.getRequest().getSession(flag);
//    }
//
//    protected String getPara(String name) {
//        return HttpKit.getRequest().getParameter(name);
//    }
//
//    protected void setAttr(String name, Object value) {
//        HttpKit.getRequest().setAttribute(name, value);
//    }

    /**
     * 初始化数据绑定
     * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
     * 2. 将字段中Date类型转换为String类型
     *
     * @param binder the binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new StringEditor());
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

}
