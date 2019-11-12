package ca.costsaver.main;

import ca.costsaver.entity.Product;
import ca.costsaver.repository.impl.ProductRepositoryImplDao;
import ca.costsaver.repository.impl.ProductRepositoryImplInMemory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main04Spring {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/context.xml");
        //ProductRepositoryImplInMemory inMemory = (ProductRepositoryImplInMemory) ctx.getBean("productRepositoryImplInMemory");
        ProductRepositoryImplInMemory inMemory = ctx.getBean(ProductRepositoryImplInMemory.class);

        System.out.println(inMemory.getClass().getSimpleName());

        List<Product> productList = Arrays.asList(
                new Product(null,"123","Cola"),
                new Product(null,"124","Pepsi"),
                new Product(null,"125","Root Beer")
        );


        productList.forEach(inMemory::save);
        //print product with id 2
        System.out.println(inMemory.get(2));


        ProductRepositoryImplDao dao = ctx.getBean(ProductRepositoryImplDao.class);
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/costsaver?user=costsaver&password=password");
        connection.setAutoCommit(false);
        dao.setConnection(connection);


        //productList.forEach(dao::save);
        //print product with id 2
        System.out.println(dao.get(53));


    }
}
