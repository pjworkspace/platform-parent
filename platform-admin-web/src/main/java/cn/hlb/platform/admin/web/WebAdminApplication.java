package cn.hlb.platform.admin.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Web admin application.
 *
 * @author hlb
 */
@EnableAutoConfiguration
@RestController
@SpringBootApplication
@ComponentScan
@ImportResource("classpath:dubbo-consumer.xml")
public class WebAdminApplication /*extends WebMvcConfigurerAdapter*/{

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WebAdminApplication.class);


//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/**");
//    }
//    @RequestMapping("/")
//    public String greeting() {
//        return "login";
//    }
//
//    /**
//     * Hello string.
//     *
//     * @return the string
//     */
//    @RequestMapping
//    public String hello() {
//        return "Hello World!";
//    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WebAdminApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        LOGGER.info("Web admin started!!!");
    }
}
