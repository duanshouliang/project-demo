package com.tuen.java.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        };
        ExecutorService executorService1 = Executors.newFixedThreadPool(2, factory);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(10);
        Executors.newSingleThreadScheduledExecutor();
        executorService1.submit(new MyRunnable());


    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for(int i=0;i<100;i++) {
                System.out.println("Run thread with fixed thread pool " + i);
            }
        }
    }
}
