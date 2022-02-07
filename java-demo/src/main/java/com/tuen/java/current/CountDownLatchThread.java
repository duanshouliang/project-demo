package com.tuen.java.current;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread implements Runnable {
    private CountDownLatch countDownLatch;
    private CountDownLatch await;

    public CountDownLatchThread(CountDownLatch countDownLatch, CountDownLatch await) {
        this.countDownLatch = countDownLatch;
        this.await = await;
    }

    @Override
    public void run() {
        try {
            // countDownLatch的计数器为0的时候，自动唤醒当前线程（CountDownLatchThread）
            countDownLatch.await();
            System.out.println("子线程" + Thread.currentThread().getState() + "handle");
            Thread.sleep(1000);
            // await的计数器减1
            await.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
