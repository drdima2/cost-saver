package ca.costsaver.main;

import ca.costsaver.entity.Product;
import ca.costsaver.repository.impl.ProductRepositoryImplInMemory;
import ca.costsaver.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;

public class Main01 {

    public static void main(String[] args) {
        ProductRepository repository = new ProductRepositoryImplInMemory();

        List<Product> productList = Arrays.asList(
                new Product(null,"123","Cola"),
                new Product(null,"124","Pepsi"),
                new Product(null,"125","Root Beer")
        );


        productList.forEach(repository::save);

        //print product with id 2
        System.out.println(repository.get(2));

        //update the product
        repository.save(new Product(2,"124","Pepsi!!!"));
        System.out.println(repository.get(2));

        //delete product
        repository.delete(2);
        System.out.println(repository.get(2));

        repository.getAll().forEach(System.out::println);


    }



}
