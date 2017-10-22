package cn.hlb.platform.system.provider.serviceimpl;

import cn.hlb.platform.common.service.service.CrudService;
import cn.hlb.platform.system.api.entity.AppUser;
import cn.hlb.platform.system.api.service.IAppUserService;
import cn.hlb.platform.system.provider.mapper.AppUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务实现
 *
 * @author hlb
 */
@Service
@Transactional(readOnly = true)
public class AppUserService extends CrudService<AppUserMapper, AppUser> implements IAppUserService {

    @Override
    public AppUser getByMobile(String mobile) {
        return getDao().getByMobile(mobile);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateInfo(AppUser tripUser) {
        tripUser.preUpdate();
        getDao().updateInfo(tripUser);
    }

    @Override
    @Transactional(readOnly = false)
    public void registryUser(String mobile, String password) {
        // 用户已存在不做处理，防止客户端重复提交
        AppUser oldUser = getByMobile(mobile);
        if (oldUser != null) {
            return;
        }

        //插入用户信息
        AppUser user = new AppUser();
        user.preInsert();
        user.setMobile(mobile);
        user.setPassword(password);
        getDao().insert(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void updatePasswordByMobile(String mobile, String password) {
        getDao().updatePasswordByMobile(mobile, password);
    }

    @Override
    @Transactional(readOnly = false)
    public void updatePhotoByUserId(String userId, String photo) {
        getDao().updatePhotoByUser(userId, photo);
    }

}
