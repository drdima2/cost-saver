package ca.costsaver.exception.productRepository;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class ProductNotFoundException extends RuntimeException{
    private static final Logger log = getLogger(ProductNotFoundException.class);
    public ProductNotFoundException(String message) {
        super(message);


    }
}
