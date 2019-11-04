package ca.costsaver.listener;

import ca.costsaver.service.ServiceManager;
import org.slf4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.slf4j.LoggerFactory.getLogger;

@WebListener
public class CostSaverApplicationListener implements ServletContextListener {

    private static final Logger log = getLogger(CostSaverApplicationListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("CostSaver application Initialized");
        ServiceManager.getInstance(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("CostSaver application destroyed");
    }
}
