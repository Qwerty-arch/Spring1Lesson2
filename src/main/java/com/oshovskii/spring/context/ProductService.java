package com.oshovskii.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(int id) {
        for (Product product : productRepository.getProducts()) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }


}
