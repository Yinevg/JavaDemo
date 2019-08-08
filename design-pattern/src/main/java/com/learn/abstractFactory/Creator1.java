package com.learn.abstractFactory;

/**
 * Created by Yinevg on 2019/8/8
 * 产品等级1的实现类
 */
public class Creator1 extends AbstractCreator {
    // 只生产产品等级为1的A产品
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    // 只生产产品等级为1的B产品
    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
