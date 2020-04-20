package com.demo.pool;

import java.util.concurrent.Executors;

/**
 * Created by Yinevg on 2020/4/20
 */
public class CachedDemo {

    public static void main(String[] args) {
        Helper.help(Executors.newCachedThreadPool());
    }
}
