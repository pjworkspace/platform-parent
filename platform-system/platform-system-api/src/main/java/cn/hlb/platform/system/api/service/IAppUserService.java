package cn.hlb.platform.system.api.service;


import com.github.pagehelper.PageInfo;
import cn.hlb.platform.common.api.Paging;
import cn.hlb.platform.system.api.entity.AppUser;

import java.util.Map;

/**
 * 用户接口
 *
 * @author hlb
 */
public interface IAppUserService {

    /**
     * 查询用户列表
     *
     * @param page  分页信息
     * @param query 查询条件
     * @return 用户 page info
     */
    PageInfo<AppUser> queryPage(Paging page, Map<String, Object> query);

    /**
     * 通过id查询用户信息
     *
     * @param id 用户id
     * @return 用户信息 trip user
     */
    AppUser get(String id);

    /**
     * 通过手机号查询用户信息
     *
     * @param mobile 手机号
     * @return 用户信息 by mobile
     */
    AppUser getByMobile(String mobile);

    /**
     * 保存用户
     *
     * @param entity 用户信息
     */
    void updateInfo(AppUser entity);

    /**
     * 注册用户
     *
     * @param mobile   用户手机
     * @param password 密码
     */
    void registryUser(String mobile, String password);

    /**
     * 更新用户密码
     *
     * @param mobile   用户手机号码
     * @param password 密码
     */
    void updatePasswordByMobile(String mobile, String password);

    /**
     * 更新用户头像
     *
     * @param userId 用户ID
     * @param photo  头像
     */
    void updatePhotoByUserId(String userId, String photo);

}
