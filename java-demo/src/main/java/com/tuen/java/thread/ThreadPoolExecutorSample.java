package com.tuen.java.thread;

import java.util.concurrent.*;

/**
 *
 */
public class ThreadPoolExecutorSample {
    public static void main(String[] args) throws InterruptedException {
//        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool(1);
//        Executors.newScheduledThreadPool();
//        Executors.newSingleThreadExecutor()
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        };

        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
            // 拒绝策略，java线程池包括四种拒接策略：
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
        };

        //当线程数>=corePoolSize，且任务队列已满时。线程池会创建新线程来处理任务。
        //
        //当线程数=maxPoolSize，且任务队列已满时，线程池会拒绝处理任务而抛出异常。

        ExecutorService executorService = new ThreadPoolExecutor(
                50,// 核心池大小，表示的是预创建的线程数，即在没有任务来之前就创建corePoolSize个线程或者一个线程，可通过方法prestartAllCoreThreads或者prestartCoreThread方法实
                               //线程池中会维护一个最小的线程数量，即使这些线程处理空闲状态，他们也不会被销毁，除非设置了allowCoreThreadTimeOut。这里的最小线程数量即是corePoolSize。 现

                100,// 线程池最大线程数量。一个任务被提交到线程池以后，首先会找有没有空闲存活线程，如果有则直接将任务交给这个空闲线程来执行，如果没有则会缓存到工作队列（后面会介绍）中，
                                    // 如果工作队列满了，才会创建一个新线程，然后从工作队列的头部取出一个任务交由新线程来处理，而将刚提交的任务放入工作队列尾部。线程池不会无限制的去创建新线程，
                                    //它会有一个最大线程数量的限制，这个数量即由maximunPoolSize指定。

                0L,// 表示线程没有执行任务时最多保持多长时间后就会终止，默认情况下，只有当线程池中的线程数大于corePoolSize时，keepAliveTime才会起作用
                TimeUnit.MILLISECONDS,// keepAlive的时间单位
                new LinkedBlockingQueue<>(10000),  // 阻塞队列，用来存储等待执行的任务
                threadFactory,
                rejectedExecutionHandler
        );

        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        threadPoolMonitor(executorService);

    }


    /**
     * 线程池执行状态监控
     *
     * @param executorService
     * @throws InterruptedException
     */
    static void threadPoolMonitor(ExecutorService executorService) throws InterruptedException {
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