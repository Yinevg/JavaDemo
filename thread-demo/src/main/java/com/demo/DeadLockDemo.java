package com.demo;

/**
 * Created by Yinevg on 2020/4/13
 */
public class DeadLockDemo {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1000);
                    synchronized (lock2) {
                        System.out.println("thread1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1000);
                    synchronized (lock1) {
                        System.out.println("thread2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("main");
    }
}
