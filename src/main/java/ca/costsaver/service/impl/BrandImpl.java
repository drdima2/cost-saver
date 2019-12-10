package ca.costsaver.service.impl;

import ca.costsaver.entity.Brand;
import ca.costsaver.entity.Store;
import ca.costsaver.repository.BrandRepository;
import ca.costsaver.repository.StoreRepository;
import ca.costsaver.service.BrandService;
import ca.costsaver.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BrandImpl implements BrandService{

    @Autowired
    private BrandRepository repository;





    public Collection<Brand> getAll() {
        return repository.findAll((Sort.by(Sort.Direction.ASC, "id")));

    }

    @Override
    public Brand get(int id) {
        return repository.findById(id).get();
    }
}
