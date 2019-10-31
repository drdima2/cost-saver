package ca.costsaver.repository;

import ca.costsaver.entity.Product;
import ca.costsaver.entity.Store;

import java.util.Collection;

public interface StoreRepository {

    Store save(Store store);
    boolean delete(int id);
    Store get(int id);
    Collection<Store> getAll();


}
