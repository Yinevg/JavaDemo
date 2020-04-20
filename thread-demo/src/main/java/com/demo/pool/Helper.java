package com.demo.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Yinevg on 2020/4/20
 */
public class Helper {

    public static void help(ExecutorService executorService) {
        // 不需要返回值
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> System.out.println(Thread.currentThread().getId() + " " + index));
        }
        // 需要返回值
        List<Future<String>> futureList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            futureList.add(executorService.submit(() -> Thread.currentThread().getId() + " " + index));
        }
        futureList.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
