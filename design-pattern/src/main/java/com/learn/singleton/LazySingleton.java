package com.learn.singleton;

/**
 * Created by Yinevg on 2019/7/30
 * 懒汉式单例模式
 */
public class LazySingleton {
    private static LazySingleton singleton = null;

    private LazySingleton() {
    }

    public static LazySingleton getSingleton() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

}
