package cn.hlb.platform.system.provider.mapper;


import cn.hlb.platform.common.service.dao.CrudDao;
import cn.hlb.platform.system.api.entity.AppUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户
 *
 * @author hlb
 */
@Mapper
public interface AppUserMapper extends CrudDao<AppUser> {

    /**
     * 根据手机号码查询用户
     *
     * @param mobile the mobile
     * @return the by mobile
     */
    AppUser getByMobile(String mobile);

    /**
     * 根据手机号码修改密码
     *
     * @param mobile   the mobile
     * @param password the password
     * @return the int
     */
    int updatePasswordByMobile(@Param("mobile") String mobile, @Param("password") String password);

    /**
     * 更新用户头像
     *
     * @param userId the user id
     * @param photo  the photo
     * @return the int
     */
    int updatePhotoByUser(@Param("userId") String userId, @Param("photo") String photo);

    /**
     * 更新用户信息
     *
     * @param user the user
     * @return the int
     */
    int updateInfo(AppUser user);
}
