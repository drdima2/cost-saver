package ca.costsaver.service;

import ca.costsaver.entity.Product;
import ca.costsaver.entity.Store;

import java.util.Collection;

public interface StoreService {



    public Store save(Store store);
    public boolean delete(int id);
    public Store get(int id);
    public Collection<Store> getAll();
    public Collection<Store> getByBrand(int brandId);


}
