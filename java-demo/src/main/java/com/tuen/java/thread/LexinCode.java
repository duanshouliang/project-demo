package com.tuen.java.thread;

public class LexinCode {
    private String value;

    public LexinCode(String value) {
        this.value = value;
    }

    public void first() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (value.equals("A")) {
                }
                System.out.println(value);
            }
        };
        value = "B";
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void second() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (value.equals("A")) {
                }
                System.out.println(value);
            }
        };
        value = "B";
        try {
            Thread.sleep(1000L);
            thread.join(1000L);
            thread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(re());

    }

    public static int re() {
        try {
            return 3 / 0;
        } catch (Exception e) {
            return 2;
        } finally {
            return 1;
        }
    }
}
