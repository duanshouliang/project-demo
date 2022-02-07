package com.tuen.java.thread;

public class MyThread_2 implements Runnable{
    @Override
    public void run() {
        System.out.println(MyThread_2.class.getSimpleName());
    }

    public static void main(String[] args) {
        Thread t = new Thread(new MyThread_2());
        t.start();
    }
}
