package ca.costsaver.listener;

import ca.costsaver.service.ServiceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class CostSaverApplicationListener implements ServletContextListener {



    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("CostSaver application Initialized");

        ServiceManager.getInstance(sce.getServletContext());





    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("CostSaver application destroyed");
    }
}
