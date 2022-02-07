package com.tuen.java.leetcode;

public class JumpStair {

    /**
     * 跳阶梯
     * <p>
     * 一个n级的阶梯，每次只能跳1级或者2级，那么有几种跳法
     */

    public static void main(String[] args) {
        System.out.println(solution3(10));
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int solution3(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * 迭代
     *
     * @param n
     * @return
     */
    public static int solution(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 2) {
            return n;
        }

        int pre2 = 1;
        int pre1 = 2;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = pre2 + pre1;
            pre2 = pre1;
            pre1 = tmp;
        }
        return tmp;
    }


    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static int solution2(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 2) {
            return n;
        }
        return solution2(n - 1) + solution2(n - 2);
    }
}
