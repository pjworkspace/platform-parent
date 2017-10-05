package cn.hlb.platform.mobile.client.security.utils;

import cn.hlb.platform.mobile.client.security.model.AuthUser;
import com.google.gson.Gson;
import cn.hlb.platform.common.web.security.AbstractTokenUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * The type Token util.
 *
 * @author hlb
 */
@Component
@ConfigurationProperties("security.jwt")
public class TokenUtil extends AbstractTokenUtil {

    @Override
    public UserDetails getUserDetails(String token) {
        String userDetailsString = getUserDetailsString(token);
        if (userDetailsString != null) {
            return new Gson().fromJson(userDetailsString, AuthUser.class);
        }
        return null;
    }

}