package cn.hlb.platform.mobile.client.common.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Swagger config.
 *
 * @author hlb
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Api docket.
     *
     * @return the docket
     */
    @Bean
    public Docket api() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("tokenInfo").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("APP-API")
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
            .paths(PathSelectors.any())
            .build()
            .directModelSubstitute(LocalDate.class, String.class)
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo())
            .globalOperationParameters(pars)
            ;
    }

    /**
     * api info
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            //页面标题
            .title("APP接口")
            //版本号
            .version("1.0")
            //描述
            .description("开发过程中API随时都有可能变化，请密切关注本文档\n" +
                    "                + \"<h1>本系统所有的金额传参数均以分为单位</h1>\"\n" +
                    "                + \"<h1>body提交以post方式提交 提交格式为body:json字符</h1>\"\n" +
                    "                + \"<h1>上传文件接口：IP地址+/upload，上传成功后返回文件存储地址</h1>\"\n" +
                    "                + \"<h1>用户登录信息处理</h1>\"\n" +
                    "                + \"用户登录、注册返回model里面有tokenModel里面含有tokenStr和userId。\"\n" +
                    "                + \"在调用其他接口的时候 header中设置tokenInfo=userId_tokenStr\"\n" +
                    "                + \"header.set('tokenInfo','171107095631041_H5_1f13ea1483c44759a5f61e656b48d9ff'),用来校验用户的有效性以及是否登录\"\n" +
                    "                + \"<h1>状态码说明(http状态码200的情况下)</h1>\"\n" +
                    "                + \"10000  表示业务执行通畅，执行成功\"\n" +
                    "                + \"10001  校验，业务处理出现异常--APP判断 code=10001时拿出后端提示的message提示框提示即可\"\n" +
                    "                + \"10002  请登录--APP判断 code=10002,跳到登录页面\"\n" +
                    "                + \"10003  登录账号被冻结，禁用--APP判断 code=10003,提示用户账号被冻结请联系官方客服处理，弹出拨打官方电话等操作\"\n" +
                    "                + \"10004  请绑定手机号，--APP判断 code=10004,提示用户执行该操作需要绑定手机号，弹出绑定框走绑定流程\"\n" +
                    "                + \"10005  余额不足，--APP判断 code=10005,提示用户余额不足以消费，是否去充值\"\n" +
                    "                + \"SYSTEM_ERROR  系统异常，后端代码抛异常了，直接联系后端开发人员即可")
//                .contact(new Contact("", "http://116.62.199.223:4100", "692706577@qq.com"))
            .version("1.0")
            .build();

    }

}
