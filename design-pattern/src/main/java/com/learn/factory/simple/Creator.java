package com.learn.factory.simple;

/**
 * Created by Yinevg on 2019/8/6
 */
public class Creator {
    public static <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = (Product) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
