package ca.costsaver.service;

import ca.costsaver.entity.Product;
import ca.costsaver.repository.ProductRepository;

import java.util.Collection;

public interface ProductService {



    public Product save(Product product);
    public boolean delete(int id);
    public Product get(int id);
    public Collection<Product> getAll();

}
