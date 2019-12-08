package ca.costsaver.service.impl;

import ca.costsaver.entity.Product;
import ca.costsaver.entity.Store;
import ca.costsaver.repository.ProductRepository;
import ca.costsaver.repository.StoreRepository;
import ca.costsaver.service.ProductService;
import ca.costsaver.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StoreImpl implements StoreService {

    @Autowired
    private StoreRepository repository;


    public Store save(Store store) {
        return repository.save(store);
    }

    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }

    public Store get(int id) {
        return repository.findById(id).get();
    }

    public Collection<Store> getAll() {
        return repository.findAll((Sort.by(Sort.Direction.ASC, "id")));
    }

    @Override
    public Collection<Store> getByBrand(int brandId) {
        return null;
    }
}
