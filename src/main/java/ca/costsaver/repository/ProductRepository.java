package ca.costsaver.repository;

import ca.costsaver.entity.Product;

import java.util.Collection;
import java.util.List;

public interface ProductRepository {

    Product save(Product product);
    boolean delete(int id);
    Product get(int id);
    Collection<Product> getAll();


}
