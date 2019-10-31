package ca.costsaver.main;

import ca.costsaver.entity.Product;

import java.sql.*;

public class Main02JDBC {
    public static void main(String[] args) throws SQLException {
        //BasicDataSource dataSource = new BasicDataSource();

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/costsaver"
                ,"costsaver","password");

        String sql;
        Statement statement = connection.createStatement();

        //sql="CREATE SEQUENCE table_name_id_seq";
        //connection.commit();




        sql="CREATE TABLE IF NOT EXISTS product" +
                "(ID SERIAL PRIMARY KEY    ," +
                " BARCODE        TEXT   NOT NULL," +
                " PRODUCTNAME    TEXT   NOT NULL)";

        statement.executeUpdate(sql);
        statement.close();

        connection.setAutoCommit(false);

        statement = connection.createStatement();
        sql="INSERT INTO product (barcode, productName) VALUES (123,'Cola')";
        statement.executeUpdate(sql);
        statement.close();
        connection.commit();


        selectAndPrint(statement,connection);


        statement = connection.createStatement();
        sql="UPDATE product set productname='Pepsi' where id=18";
        statement.executeUpdate(sql);
        connection.commit();
        statement.close();


        selectAndPrint(statement,connection);


        statement = connection.createStatement();
        sql="DELETE FROM product where id=18";
        statement.executeUpdate(sql);
        connection.commit();
        statement.close();

        selectAndPrint(statement, connection);



        sql="INSERT INTO product (barcode, productName) VALUES (?,?)";
        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        preparedStatement.setString(1,"455");
        preparedStatement.setString(2,"Beer");
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.commit();


        selectAndPrint(statement, connection);

        connection.close();

    }

    public static void selectAndPrint(Statement statement,Connection connection) throws SQLException {
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM product");
        while (rs.next()){
            int id = rs.getInt("id");
            String barcode = rs.getString("barcode");
            String productName = rs.getString("productName");
            Product p = new Product(id, barcode, productName);
            System.out.println(p);


        }
        rs.close();
        statement.close();
    }


}
