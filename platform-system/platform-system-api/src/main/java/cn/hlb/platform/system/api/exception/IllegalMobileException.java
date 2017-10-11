package cn.hlb.platform.system.api.exception;


import cn.hlb.platform.system.api.exception.base.BusinessException;

/**
 * 手机号码不合法
 *
 * @author hlb
 */
public class IllegalMobileException extends BusinessException {

    public IllegalMobileException(String message) {
        super(message);
    }

}
