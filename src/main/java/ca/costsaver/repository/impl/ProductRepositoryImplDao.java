//package ca.costsaver.repository.impl;
//
//import ca.costsaver.entity.Product;
//import ca.costsaver.repository.ProductRepository;
//import org.slf4j.Logger;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import static org.slf4j.LoggerFactory.getLogger;
//
//public class ProductRepositoryImplDao implements ProductRepository {
//
//    private static final Logger log = getLogger(ProductRepositoryImplDao.class);
//
//
//    private Connection connection;
//    public void setConnection(Connection connection) {
//        this.connection = connection;
//    }
//
//    private String sql;
//    private Statement statement;
//
//    public  ProductRepositoryImplDao(){
//
//    }
//
//    public ProductRepositoryImplDao(Connection connection)  {
//        this.connection=connection;
//    }
//
//    @Override
//    public Product save(Product product) {
//        if (!product.isNew()) return update(product);
//        sql = "INSERT INTO product (barcode, productName) VALUES (?,?)";
//        try {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//                preparedStatement.setString(1, product.getBarCode());
//                preparedStatement.setString(2, product.getProductName());
//                int affectedRows = preparedStatement.executeUpdate();
//                connection.commit();
//
//                if (affectedRows == 0) throw new SQLException("Creating user failed, no rows affected.");
//                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
//                    if (generatedKeys.next()) product.setId(generatedKeys.getInt("id"));
//                    else throw new SQLException("Creating user failed, no ID obtained.");
//                }
//
//            }
//
//            //connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return product;
//    }
//
//    private Product update(Product product) {
//        sql = "UPDATE product SET barcode=?, productName=? WHERE id=?";
//        try {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//                preparedStatement.setString(1, product.getBarCode());
//                preparedStatement.setString(2, product.getProductName());
//                preparedStatement.setInt(3, product.getId());
//                int affectedRows = preparedStatement.executeUpdate();
//                connection.commit();
//
//                if (affectedRows == 0) throw new SQLException("Creating user failed, no rows affected.");
//
//
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return product;
//    }
//
//
//    @Override
//    public boolean delete(int id) {
//        sql = "DELETE FROM product WHERE id=?";
//        try {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//                preparedStatement.setInt(1, id);
//
//                int affectedRows = preparedStatement.executeUpdate();
//                connection.commit();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return true;
//    }
//
//    @Override
//    public Product get(int id) {
//        Product product=null;
//        sql = "SELECT * FROM product WHERE id = ?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                product = new Product(
//                        rs.getInt("id"),
//                        rs.getString("barCode"),
//                        rs.getString("productName")
//                );
//            }
//            preparedStatement.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return product;
//    }
//
//    @Override
//    public Collection<Product> getAll() {
//        sql = "SELECT * FROM product ORDER BY ID";
//        List<Product> products = new ArrayList<>();
//        try {
//            statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//
//            while (rs.next()) {
//                products.add(new Product(
//                        rs.getInt("id"),
//                        rs.getString("barCode"),
//                        rs.getString("productName")
//                ));
//            }
//
//
//            //connection.close();
//        } catch (SQLException e) {
//            log.warn("Product not found. {}",e.getMessage(),e);
//        }
//
//        return products;
//    }
//
//
//}
