package com.oshovskii.spring.context;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private int id;
    private int cost;
    private String title;

    public Product() {
    }

    public Product(int id, int cost, String title) {
        this.id = id;
        this.cost = cost;
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("Product: [%d, %d, %s]", id, cost, title);
    }
}
