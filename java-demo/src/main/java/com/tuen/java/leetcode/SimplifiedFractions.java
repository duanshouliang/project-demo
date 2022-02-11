package com.tuen.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 最简分数
 * <p>
 * 输入一个整数n，输出（0，1）内所有最简分数
 */
public class SimplifiedFractions {

    public static void main(String[] args) {
        System.out.println(simplifiedFractions(4));
    }

    public static List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                //最大公约数为1即为最简分数，则加入结果集中
                if(GreatestCommonDivisor.gcd2(i,j) == 1){
                    res.add(i + "/" + j);
                }
            }
        }
        return res;
    }
}
