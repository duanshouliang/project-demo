package com.tuen.thread;

import java.util.concurrent.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return newThread(r);
            }
        };


        ExecutorService executorService = new ThreadPoolExecutor(
                50,                 // 核心池大小，表示的是预创建的线程数，即在没有任务来之前就创建corePoolSize个线程或者一个线程，可通过方法prestartAllCoreThreads或者prestartCoreThread方法实现
                100,            // 最大线程数，表示线程池中最多可以创建的额线程个数
                0L,                 // 表示线程没有执行任务时最多保持多长时间后就会终止，默认情况下，只有当线程池中的线程数大于corePoolSize时，keepAliveTime才会起作用
                TimeUnit.MILLISECONDS,          // keepAlive的时间单位
                new LinkedBlockingQueue<>(10000),   // 阻塞队列，用来存储等待执行的任务
                threadFactory,                  // 线程工厂
                new RejectedExecutionHandler() { // 拒绝策略，java线程池包括四种拒接策略：
                                                 // AbortPolicy(默认策略，抛出RejectExecutionException)，
                                                 // CallerRunsPolicy（让当前线程执行任务），
                                                 // DiscardPolicy（直接丢弃任务，不抛出异常），
                                                 // DiscardOldestPolicy（丢弃任务队列最前面的任务，然后重新尝试执行任务）
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        try {
                            executor.getQueue().put(r);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) executorService;


        while (true) {
            System.out.println();
            int queueSize = tpe.getQueue().size();
            System.out.println("当前排队线程数：" + queueSize);
            int activeCount = tpe.getActiveCount();
            System.out.println("当前活动线程数：" + activeCount);
            long completedTaskCount = tpe.getCompletedTaskCount();

            System.out.println("执行完成线程数：" + completedTaskCount);

            long taskCount = tpe.getTaskCount();

            System.out.println("总线程数：" + taskCount);


            Thread.sleep(500L);

        }
    }
}
