package com.learn.factory.common;

/**
 * Created by Yinevg on 2019/8/6
 */
public abstract class Creator {

    /**
     * 创建一个产品对象，其输入参数类型可以自行设置
     * 通常为String、Enum、Class等，也可为空
     */
    public abstract <T extends Product> T createProduct(Class<T> c);
}
