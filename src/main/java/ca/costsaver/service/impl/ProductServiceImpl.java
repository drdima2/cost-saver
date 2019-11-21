package ca.costsaver.service.impl;

import ca.costsaver.entity.Product;
import ca.costsaver.repository.ProductRepository;
import ca.costsaver.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product product){
       return repository.save(product);
    }
    public boolean delete(int id){
        repository.deleteById(id);
        return true;
    }
    public Product get(int id){
        return repository.findById(id).get();
    }
    public Collection<Product> getAll(){
        List<Product> actualList = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(actualList::add);
        return actualList;
    }

}
