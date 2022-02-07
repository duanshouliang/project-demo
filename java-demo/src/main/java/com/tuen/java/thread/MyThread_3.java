package com.tuen.java.thread;

import java.util.concurrent.*;

public class MyThread_3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return MyThread_3.class.getSimpleName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        FutureTask task = new FutureTask<>(new MyThread_3());
        executorService.submit(task);
        System.out.println(task.get());

    }
}
