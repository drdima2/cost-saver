//package ca.costsaver.repository.impl;
//
//import ca.costsaver.entity.Product;
//import ca.costsaver.repository.ProductRepository;
//import ca.costsaver.exception.productRepository.ProductNotFoundException;
//import org.slf4j.Logger;
//
//import java.util.Collection;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicInteger;
//
//import static org.slf4j.LoggerFactory.getLogger;
//
//public class ProductRepositoryImplInMemory implements ProductRepository {
//
//    private static final Logger log = getLogger(ProductRepositoryImplInMemory.class);
//    private Map<Integer, Product> repository = new ConcurrentHashMap<>();
//    private AtomicInteger counter = new AtomicInteger(0);
//
//
//    @Override
//    public Product save(Product product) {
//        if (product.isNew()) product.setId(counter.incrementAndGet());
//        repository.put(product.getId(), product);
//        return product;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        return repository.remove(id) != null;
//    }
//
//    @Override
//    public Product get(int id) {
//        Product p = repository.get(id);
//        if (p==null) {
//            log.warn("Product id={} not found. ",id);
//            throw new ProductNotFoundException("product with id" + id + " not avaliable");
//        }
//        return p;
//    }
//
//    @Override
//    public Collection<Product> getAll() {
//        return repository.values();
//    }
//}
