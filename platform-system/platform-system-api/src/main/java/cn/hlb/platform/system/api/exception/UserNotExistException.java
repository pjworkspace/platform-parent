package cn.hlb.platform.system.api.exception;


import cn.hlb.platform.system.api.exception.base.BusinessException;

/**
 * 用户未存在
 *
 * @author hlb
 */
public class UserNotExistException extends BusinessException {

    public UserNotExistException(String message) {
        super(message);
    }

}
