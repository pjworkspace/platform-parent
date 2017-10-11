package cn.hlb.platform.system.api.exception;


import cn.hlb.platform.system.api.exception.base.BusinessException;

/**
 * 无效验证码
 *
 * @author hlb
 */
public class InvalidCaptchaException extends BusinessException {

    public InvalidCaptchaException(String message) {
        super(message);
    }

}
