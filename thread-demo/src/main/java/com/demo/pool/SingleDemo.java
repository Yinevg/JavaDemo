package com.demo.pool;

import java.util.concurrent.Executors;

/**
 * Created by Yinevg on 2020/4/20
 */
public class SingleDemo {

    public static void main(String[] args) {
        Helper.help(Executors.newSingleThreadExecutor());
    }
}
