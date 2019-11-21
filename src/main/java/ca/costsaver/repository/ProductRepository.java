package ca.costsaver.repository;

import ca.costsaver.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product,Integer> {

//    Product save(Product product);
//    boolean delete(int id);
//    Product get(int id);
//    Collection<Product> getAll();


}
