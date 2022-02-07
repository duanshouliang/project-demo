package com.tuen.java.current;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch await = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new Thread(new CountDownLatchThread(countDownLatch, await)).start();
        }

        System.out.println("主线程处理自己的事情");
        Thread.sleep(3000);
        //计数器的值减1
        countDownLatch.countDown();
        System.out.println("主线程处理结束");
        //当await的计数器值为1的时候，自动执行await方法，唤醒被锁的线程（这里重新唤醒main线程）
        //await计数器的值不为0时，是不会执行最后一个输出的
        await.await();
        System.out.println("子线程处理完毕");
    }
}
