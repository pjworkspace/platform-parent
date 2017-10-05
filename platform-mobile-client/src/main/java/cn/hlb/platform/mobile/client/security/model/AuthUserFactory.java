package cn.hlb.platform.mobile.client.security.model;

import cn.hlb.platform.system.api.entity.TripUser;

/**
 * The type Auth user factory.
 *
 * @author hlb
 */
public final class AuthUserFactory {

    private AuthUserFactory() {
    }

    /**
     * Create auth user.
     *
     * @param user the user
     * @return the auth user
     */
    public static AuthUser create(TripUser user) {
        return new AuthUser(
            user.getId(),
            user.getMobile(),
            user.getPassword(),
            user.getEnabled()
        );
    }

}
