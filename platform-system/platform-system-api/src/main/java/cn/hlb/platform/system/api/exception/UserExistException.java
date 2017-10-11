package cn.hlb.platform.system.api.exception;


import cn.hlb.platform.system.api.exception.base.BusinessException;

/**
 * 用户已存在
 *
 * @author hlb
 */
public class UserExistException extends BusinessException {

    public UserExistException(String message) {
        super(message);
    }

}
