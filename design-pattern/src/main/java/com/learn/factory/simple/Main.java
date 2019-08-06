package com.learn.factory.simple;

/**
 * Created by Yinevg on 2019/8/6
 */
public class Main {
    public static void main(String[] args) {
        Product product = Creator.createProduct(ConcreteProduct1.class);
        product.method2();
        Product product2 = Creator.createProduct(ConcreteProduct2.class);
        product2.method2();
    }
}
