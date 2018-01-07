package cn.hlb.platform.mobile.client;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Client mobile application.
 *
 * @author hlb
 */
@RestController
@SpringBootApplication
@ServletComponentScan
@ImportResource("classpath:dubbo-consumer.xml")
@Slf4j
@ConfigurationProperties(prefix="server")
public class ClientMobileApplication {
    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientMobileApplication.class);

    private static final int DEFAULT_PORT = 8080;

    /**
     * @Fields port: 启动端口
     */
    private static int port = DEFAULT_PORT;


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        SpringApplication application = new SpringApplication(ClientMobileApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        long end = System.currentTimeMillis();
        LOGGER.info("Client mobile started!!!");
        log.info("**********************************************************************");
        log.info("启动成功:" + (end-begin) + "ms");
        log.info("swagger地址: http://127.0.0.1:" + port + "/swagger-ui.html");
        log.info("swagger地址: http://127.0.0.1:" + port + "/doc.html");
        log.info("**********************************************************************");
    }

    public static void setPort(int port) {
        ClientMobileApplication.port = port;
    }
}
