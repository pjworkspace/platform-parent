package cn.hlb.platform.mobile.client.im.event;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author jun 2017-09-15 12:32
 **/
@WebListener
public class IndexListener2 implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("IndexListener2 contextDestroyed method");
    }
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("IndexListener2 contextInitialized method");
    }
}