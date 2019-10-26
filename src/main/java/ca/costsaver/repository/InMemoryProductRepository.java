package ca.costsaver.repository;

import ca.costsaver.entity.Product;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryProductRepository implements ProductRepository {


    private Map<Integer, Product> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);


    @Override
    public Product save(Product product) {
        if (product.isNew()) product.setId(counter.incrementAndGet());
        repository.put(product.getId(), product);
        return product;
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Product get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<Product> getAll() {
        return repository.values();
    }
}
