package ca.costsaver.service;

import ca.costsaver.repository.ProductRepository;
import ca.costsaver.repository.impl.ProductRepositoryDao;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ServiceManager {



    public static ServiceManager getInstance(ServletContext servletContext){
        ServiceManager serviceManagerInstance = (ServiceManager) servletContext.getAttribute("SERVICE_MANAGER");
        if (serviceManagerInstance==null){
            serviceManagerInstance = new ServiceManager();
            servletContext.setAttribute("SERVICE_MANAGER",serviceManagerInstance);
        }

        return serviceManagerInstance;
    }


    private ProductRepository productRepository;

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    private ServiceManager() {
        loadApplicationProperties();
        Connection connection=null;
        try {
            //Class.forName("org.postgresql.Driver");
            Class.forName(getProperty("db.driver"));
            connection = DriverManager.getConnection(getProperty("db.url"),
                     getProperty("db.username"), getProperty("db.password"));
            //statement = connection.createStatement();
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        productRepository = new ProductRepositoryDao(connection);
    }

    private Properties applicationProperties = new Properties();
    private void loadApplicationProperties() {
        try {
            try(InputStream in = ServiceManager.class.getClassLoader().getResourceAsStream("application.properties")){
                applicationProperties.load(in);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getProperty(String key){
        return applicationProperties.getProperty(key);
    }
}
