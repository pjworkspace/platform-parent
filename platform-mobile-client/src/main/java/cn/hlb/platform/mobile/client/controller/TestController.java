package cn.hlb.platform.mobile.client.controller;

import cn.hlb.platform.mobile.client.common.controller.BaseController;
import cn.hlb.platform.mobile.client.constant.Message;
import cn.hlb.platform.mobile.client.constant.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Currency rate controller.
 *
 * @author hlb
 */
@RestController
@RequestMapping("/{version}/test")
@Api(tags = "测试contrl")
public class TestController extends BaseController {

    /**
     * Gets currency rate.
     *
     * @param version the version
     * @return the currency rate
     */
    @GetMapping(value = "/test1", produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "测试方法1")
    public Map<String, Object> getCurrencyRate(
        @ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version
    ) {

        Map<String, Object> message = new HashMap<>();
        message.put(Message.RETURN_FIELD_CODE, ReturnCode.SUCCESS);
        message.put(Message.RETURN_FIELD_DATA, "test1");
        return message;
    }

}
