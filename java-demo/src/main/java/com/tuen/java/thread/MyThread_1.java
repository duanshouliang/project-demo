package com.tuen.java.thread;

public class MyThread_1 extends Thread {
    @Override
    public void run() {
        while (true) {
//            try {
////                Thread.sleep(1L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(MyThread_1.class.getSimpleName());
        }
    }

    public static void main(String[] args) {
        MyThread_1 thread_1 = new MyThread_1();
        thread_1.start();
    }
}
