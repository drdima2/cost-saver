package ca.costsaver.repository;

import ca.costsaver.entity.Store;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryStoreRepository implements StoreRepository {


    private Map<Integer, Store> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Store save(Store store) {
        if (store.isNew()) store.setStoreId(counter.incrementAndGet());
        repository.put(store.getStoreId(), store);
        return store;
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Store get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<Store> getAll() {
        return repository.values();
    }
}
