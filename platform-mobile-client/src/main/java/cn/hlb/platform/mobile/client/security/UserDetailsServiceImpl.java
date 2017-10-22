package cn.hlb.platform.mobile.client.security;

import cn.hlb.platform.mobile.client.security.model.AuthUserFactory;
import cn.hlb.platform.system.api.entity.SysUser;
import cn.hlb.platform.system.api.entity.AppUser;
import cn.hlb.platform.system.api.service.ISystemService;
import cn.hlb.platform.system.api.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Security User Detail Service
 *
 * @author hlb
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 用户服务
     */
    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private ISystemService systemService;

    @Override
    public UserDetails loadUserByUsername(String loginName) {
        AppUser user = appUserService.getByMobile(loginName);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", loginName));
        } else {
            return AuthUserFactory.create(user);
        }
    }
}
