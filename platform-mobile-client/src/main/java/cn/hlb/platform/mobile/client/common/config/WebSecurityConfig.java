package cn.hlb.platform.mobile.client.common.config;

import cn.hlb.platform.common.web.config.AbstractWebSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * spring-security配置
 *
 * @author hlb
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//允许进入页面方法前检验
public class WebSecurityConfig extends AbstractWebSecurityConfig {

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略权限校验的访问路径
        web
            .ignoring()
            .antMatchers(
                "/hello",
                "/favicon.ico",
                "/swagger**/**",
                "/*/api-docs",
                "/webjars/**",
                "/*/sms/captcha",
                "/*/user/password",
                "/*/currency/**",
                "/*/test/**"
            )
            .antMatchers(HttpMethod.POST, "/*/user")
        ;
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/*/auth/token").permitAll();//无需访问权限
        super.configure(security);
    }
}
