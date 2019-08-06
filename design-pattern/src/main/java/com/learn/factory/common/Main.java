package com.learn.factory.common;

/**
 * Created by Yinevg on 2019/8/6
 */
public class Main {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product = creator.createProduct(ConcreteProduct1.class);
        product.method2();
        Product product2 = creator.createProduct(ConcreteProduct2.class);
        product2.method2();
    }
}
