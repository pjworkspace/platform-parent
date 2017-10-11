package cn.hlb.platform.system.api.exception;


import cn.hlb.platform.system.api.exception.base.BusinessException;

/**
 * 短信发送太频繁
 *
 * @author hlb
 */
public class SmsTooMuchException extends BusinessException {

    public SmsTooMuchException(String message) {
        super(message);
    }

}
