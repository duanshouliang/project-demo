package com.tuen.java.leetcode;

/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * <p>
 * <p>
 * 思路一：循环用a-b，知道a-b<b,则退出循环
 */
public class DivideDemo {
    public static void main(String[] args) {
        System.out.println(divide3(-31, 3));
        System.out.println(1<<2);
    }

    /**
     * 使用减法代替除法:对b进行逐个减
     *
     * @param a
     * @param b
     * @return
     */
    public static int divide(int a, int b) {
        int res = 0;
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }
        while (a <= b) {
            a -= b;
            res++;

        }
        return sign == 1 ? res : -res;
    }

    public static int divide2(int a, int b) {
        int res = 0;
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (b > 0) {
            b = -b;
        }
        if (a > 0) {
            a = -a;
        }
        while (a <= b) {
            int value = b;
            int k = 1;
            while (value >= 0xc0000000 && a <= value + value) {
                value += value;
                k += k;
            }
            a -= value;
            res += k;
        }
        return sign == 1 ? res : -res;

    }


    public static int divide3(int a, int b) {
        int res = 0;
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);
        for (int i = 31; i >= 0; i++) {
            if ((a >>> i) - b >= 0) {
                a -= (b << i);
                res+=1<<1;
            }
        }
        return sign == 1 ? res : -res;
    }
}
