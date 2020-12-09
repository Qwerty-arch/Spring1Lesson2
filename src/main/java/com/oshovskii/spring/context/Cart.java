package com.oshovskii.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Scope(scopeName = "prototype")
public class Cart {

    private ProductService productService;
    private List<Product> productsInCart;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public Cart() {
        productsInCart = new ArrayList<>();
    }

    public void addProductInCart(Product product) {
        if (product.getId() < 0 || product.getCost() < 0) {
            throw new IllegalArgumentException("bad product");
        }
        productsInCart.add(product);

    }

    public List<Product> getProductsInCart() {
        return Collections.unmodifiableList(productsInCart);
    }

    public List<Product> getProducts() {
        return productsInCart;
    }

    public void removeProductFromCart(int id) {
        productsInCart.remove(id);
    }

    @Override
    public String toString() {
        return "Cart have: \n" + getProductsInCart().toString();
    }


}
