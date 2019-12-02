package ca.costsaver.listener;

import ca.costsaver.service.impl.BrandInit;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static org.slf4j.LoggerFactory.getLogger;

@WebListener
public class CostSaverApplicationListener implements ServletContextListener {

    private static final Logger log = getLogger(CostSaverApplicationListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("CostSaver application Initialized");
        //ServiceManager.getInstance(sce.getServletContext());

        //BrandInit.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("CostSaver application destroyed");
    }
}
