package com.learn.singleton;

/**
 * Created by Yinevg on 2019/7/30
 * 饿汉式单例模式
 */
public class HungerSingleton {

    private static HungerSingleton singleton = null;

    private HungerSingleton() {
    }

    public static HungerSingleton getSingleton() {
        return singleton;
    }
}
