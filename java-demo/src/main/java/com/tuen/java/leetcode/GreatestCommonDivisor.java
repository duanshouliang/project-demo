package com.tuen.java.leetcode;

/**
 * 最大公约数（greatest common divisor, gcd）
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(gcd2(12,24));
    }

    /**
     * 辗转相除法，即用a和b中的大数除以小数，如果余数为零则返回b，否则将余数复制给b，将b复制给a
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        while (a != 0) {
            if (a % b == 0) {
                return b;
            } else {
                b = a % b;
                a = b;
            }
        }
        return b;
    }

    public static int gcd2(int a, int b){
        if(a%b == 0){
            return b;
        }else{
            return gcd2(b, a%b);
        }

    }
}
