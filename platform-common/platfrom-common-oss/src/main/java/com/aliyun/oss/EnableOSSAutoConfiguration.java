package com.aliyun.oss;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 描述: aliyun oss 自动配置注解
 * 包名: com.aliyun.oss.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = {OSSAutoConfiguration.class})
public @interface EnableOSSAutoConfiguration {
}
