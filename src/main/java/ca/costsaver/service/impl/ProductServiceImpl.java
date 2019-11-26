package ca.costsaver.service.impl;

import ca.costsaver.entity.Product;
import ca.costsaver.repository.ProductRepository;
import ca.costsaver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;


    public Product save(Product product) {
        return repository.save(product);
    }

    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }

    public Product get(int id) {
        return repository.findById(id).get();
    }

    public Collection<Product> getAll() {
        return repository.findAll((Sort.by(Sort.Direction.ASC, "id")));
    }

}
