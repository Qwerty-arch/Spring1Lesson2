package com.oshovskii.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        ProductService productService = context.getBean("productService", ProductService.class);
        Cart cart = context.getBean("cart", Cart.class);


        Scanner sc = new Scanner(System.in);
        String cmd;
        System.out.println("Enter /exit for exit");
        while(true) {
            cmd = sc.nextLine();
            if (cmd.equals("/tomato")) {
                cart.addProductInCart(productService.getProductRepository().getProducts1().get(0));
            }
            if (cmd.equals("/cake")) {
                cart.addProductInCart(productService.getProductRepository().getProducts1().get(1));
            }
            if (cmd.equals("/deleteId1")) {
                cart.removeProductFromCart(1);
            }
            if (cmd.equals("/exit")) {
                break;
            }
            System.out.println(cart.getProductsInCart().toString());
            System.out.println("*********************");
        }

        context.close();
    }
}
