package com.learn.factory.common;

/**
 * Created by Yinevg on 2019/8/6
 */
public abstract class Product {
    // 产品类的公共方法
    public void method1() {
        System.out.println("我是公共方法");
    }

    // 抽象方法
    public abstract void method2();
}
