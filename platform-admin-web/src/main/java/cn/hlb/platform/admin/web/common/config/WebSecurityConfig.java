package cn.hlb.platform.admin.web.common.config;

import cn.hlb.platform.common.web.config.AbstractWebSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

/**
 * spring-security配置
 *
 * @author hlb
 */
@Configuration
public class WebSecurityConfig extends AbstractWebSecurityConfig {

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略权限校验的访问路径
        web
            .ignoring()
            .antMatchers(
                    "/login",
                    "/static/**",
                    "/favicon.ico"
            );
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
//        security
//            .authorizeRequests()
//            .antMatchers("/login").permitAll()//无需登录认证权限
//            .anyRequest().authenticated()////其他所有资源都需要认证，登陆后访问
//            .antMatchers(HttpMethod.POST, "/auth/token","/login","/*/view/**").permitAll()
//            .and()
//            .formLogin()
//            .loginPage("/login")//指定登录页是”/login”
//            .permitAll()
////            .successHandler(loginSuccessHandler())
//            .and()
//            .logout()
//            .logoutSuccessUrl("/login") //退出登录后的默认网址是”/home”
        security
                .authorizeRequests()
                .antMatchers("/", "/home","/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        super.configure(security);
    }
}
