package com.learn.singleton;

/**
 * Created by Yinevg on 2019/7/30
 * 枚举单例模式
 */
public enum EnumSingleton {
    SINGLETON;

    public EnumSingleton getSingleton() {
        return SINGLETON;
    }
}
