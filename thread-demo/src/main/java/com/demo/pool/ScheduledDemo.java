package com.demo.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yinevg on 2020/4/20
 */
public class ScheduledDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.schedule(() -> System.out.println(Thread.currentThread().getId() + " " + index),
                    1, TimeUnit.SECONDS);
        }
    }
}
