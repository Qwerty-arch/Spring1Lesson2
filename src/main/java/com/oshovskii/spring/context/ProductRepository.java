package com.oshovskii.spring.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;


    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public List<Product> getProducts1() {
        return products;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(0, 100, "tomato"));
        products.add(new Product(1, 200, "cake"));
        products.add(new Product(2, 300, "pineapple"));
        products.add(new Product(3, 400, "fish"));
        products.add(new Product(4, 500, "apple"));
    }

    public void add(Product product) {
        if (product.getId() < 0 || product.getCost() < 0) {
            throw new IllegalArgumentException("bad product");
        }
            products.add(product);

    }
}
