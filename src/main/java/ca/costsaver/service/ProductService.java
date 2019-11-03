package ca.costsaver.service;

import ca.costsaver.entity.Product;
import ca.costsaver.repository.ProductRepository;
import ca.costsaver.repository.impl.ProductRepositoryDao;

import java.util.Collection;

public class ProductService {

    ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product product){
       return repository.save(product);
    }
    public boolean delete(int id){
        return repository.delete(id);
    }
    public Product get(int id){
        return repository.get(id);
    }
    public Collection<Product> getAll(){
        return repository.getAll();
    }

}
