package cn.hlb.platform.admin.web.controller;

import com.github.pagehelper.PageInfo;
import cn.hlb.platform.admin.web.common.controller.BaseController;
import cn.hlb.platform.common.api.Paging;
import cn.hlb.platform.common.upload.util.FileManager;
import cn.hlb.platform.system.api.entity.AppUser;
import cn.hlb.platform.system.api.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * The type Trip user controller.
 *
 * @author hlb
 */
@Validated
@RestController
@RequestMapping("/trip/user")
public class AppUserController extends BaseController {
    /**
     * 用户服务
     */
    @Autowired
    private IAppUserService appUserService;
    /**
     * 文件管理
     */
    @Autowired
    private FileManager fileManager;

    /**
     * List page info.
     *
     * @param page  the page
     * @param query the query
     * @return the page info
     */
    @PreAuthorize("hasAuthority('trip:user:view')")
    @GetMapping(value = "/list")
    public PageInfo<AppUser> list(Paging page, @RequestParam Map<String, Object> query) {
        return appUserService.queryPage(page, query);
    }

    /**
     * Get trip user.
     *
     * @param id the id
     * @return the trip user
     */
    @PreAuthorize("hasAuthority('trip:user:view')")
    @GetMapping(value = "/{id}")
    public AppUser get(@PathVariable("id") String id) {
        AppUser user = appUserService.get(id);
        user.setPhoto(fileManager.getFileUrlByRealPath(user.getPhoto()));

        return user;
    }

}
