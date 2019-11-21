//package ca.costsaver.repository;
//
//import ca.costsaver.entity.Product;
//import ca.costsaver.repository.impl.ProductRepositoryImplInMemory;
//import ca.costsaver.exception.productRepository.ProductNotFoundException;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class ProductRepositoryImplInMemoryTest {
//
//    ProductRepository repository = new ProductRepositoryImplInMemory();
//
//
//    List<Product> productList = Arrays.asList(
//            new Product(null, "123", "Cola"),
//            new Product(null, "124", "Pepsi"),
//            new Product(null, "125", "Root Beer")
//    );
//
//    @Before
//    public void setup() {
//
//        productList.forEach(repository::save);
//
//    }
//
//
//    @Test
//    public void save() {
//
//        Product p = new Product(null, "333", "Beef");
//        Product expected = new Product(4, "333", "Beef");
//        Product actual = repository.save(p);
//        assertThat(actual).isEqualToComparingFieldByField(expected);
//
//
//    }
//
//    @Test(expected = ProductNotFoundException.class)
//    public void delete() {
//        //productList.forEach(repository::save);
//        repository.delete(2);
//        repository.get(2);
//
//    }
//
//    @Test
//    public void get() {
//        Product actual = repository.get(3);
//        Product expected = new Product(3, "125", "Root Beer");
//        assertThat(actual).isEqualToComparingFieldByField(expected);
//    }
//
//    @Test
//    public void getAll() {
//        Collection<Product> actual = repository.getAll();
//        Collection<Product> expected = Arrays.asList(
//                new Product(1, "123", "Cola"),
//                new Product(2, "124", "Pepsi"),
//                new Product(3, "125", "Root Beer")
//        );
//        assertThat(actual).usingElementComparatorIgnoringFields("").isEqualTo(expected);
//    }
//}