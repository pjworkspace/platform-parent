package cn.hlb.platform.mobile.client.common.annotation;

import cn.hlb.platform.system.api.exception.base.BusinessException;

/**
 * The type Request limit exception.
 *
 * @author hlb
 */
public class RequestLimitException extends BusinessException {

    private static final long serialVersionUID = 1364225358754654702L;

    /**
     * Instantiates a new Request limit exception.
     */
    public RequestLimitException() {
        super("HTTP请求超出设定的限制");
    }

    /**
     * Instantiates a new Request limit exception.
     *
     * @param message the message
     */
    public RequestLimitException(String message) {
        super(message);
    }

}