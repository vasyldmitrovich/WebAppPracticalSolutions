package org.practicalsolutions.logs;

import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String webAppPath = sce.getServletContext().getRealPath("/");
        System.out.println("This is real patch: "+webAppPath);
        String log4jFilePath = webAppPath+"WEB-INF"+File.separator+"classes"+File.separator+ "log4j.properties";
        DOMConfigurator.configure(log4jFilePath);
        System.out.println("initialized log4j configuration from file:"+log4jFilePath);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
