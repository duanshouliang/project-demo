package com.tuen.java.thread;

public class ThreadLocalDemo {


    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                threadLocal.set(1);
                while (true){
                    System.out.println("thread1 " + threadLocal.get());
                    threadLocal.set(threadLocal.get() + 2);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                threadLocal.set(2);
                while (true){
                    System.out.println("thread2 " + threadLocal.get());
                    threadLocal.set(threadLocal.get() + 2);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread2.start();
        thread1.start();
    }
}
