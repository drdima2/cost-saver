package ca.costsaver.listener;

import org.slf4j.Logger;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.net.URI;
import java.net.URISyntaxException;

import static org.slf4j.LoggerFactory.getLogger;

@WebListener
public class CostSaverApplicationListener implements ServletContextListener {

    private static final Logger log = getLogger(CostSaverApplicationListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("CostSaver application Initialized");
        //ServiceManager.getInstance(sce.getServletContext());

        //URI url = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext()).getBean("dbUrl",URI.class);
//        DriverManagerDataSource dataSource = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext()).getBean("dataSource",DriverManagerDataSource.class);
//        String herokuDB = System.getenv("DATABASE_URL");
//        herokuDB = "postgresql://costsaver:password@localhost:5432/costsaver";
//        if (herokuDB!=null){
//            try {
//                URI dbUrl = new URI(herokuDB);
//                dataSource.setUrl("jdbc:postgresql://" + dbUrl.getHost() + ':' + dbUrl.getPort() + dbUrl.getPath());
//                dataSource.setUsername(dbUrl.getUserInfo().split(":")[0] );
//                dataSource.setPassword(dbUrl.getUserInfo().split(":")[1] );
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("CostSaver application destroyed");
    }
}
