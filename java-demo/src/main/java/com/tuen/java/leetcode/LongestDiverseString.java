package com.tuen.java.leetcode;


import java.util.Arrays;

/**
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 *
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 *
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 * 示例 2：
 *
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 * 示例 3：
 *
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 *  
 *
 * 提示：
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 *
 *
 *
 **/
public class LongestDiverseString {
    public static void main(String[] args) {
        LongestDiverseString longestDiverseString = new LongestDiverseString();
        System.out.println(longestDiverseString.solution(2,2,4));
    }

    class Pair {
        int freq; //用于记录剩字符的余个数，加入结果集后减一
        char ch; //字符

        public Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }


    public String solution(int a, int b, int c){
        StringBuilder sb = new StringBuilder("");
        Pair[] pairs = new Pair[]{new Pair(a, 'a'),new Pair(b, 'b'),new Pair(c, 'c')};
        while (true){
            //根据元素的数量进行排序，并在循环体中对数量最多或次多的元素进行处理
            Arrays.sort(pairs, (p1, p2) -> (p2.freq - p1.freq));
            boolean hasNext = false;
            for(Pair pair : pairs){
                // 如果数量最多的为0， 则跳出循环
                if(pair.freq<=0){
                    break;
                }
                int m = sb.length();
                // 如果数量最多的字符加入结果集会导致出现"快乐字符串"，则使用次多的字符，即对下个字符进行操作
                if(m >= 2 && sb.charAt(m-2) == pair.ch && sb.charAt(m-1)==pair.ch){
                    continue;
                }
                //标记是否有元素待处理
                hasNext = true;
                //将字符拼接到结果集中
                sb.append(pair.ch);
                //字符数量减一
                pair.freq--;
                //加入结果集后结束本次寻找，进入下一次寻找
                break;
            }
            //如果没有元素，则退出查找
            if(!hasNext){
                break;
            }
        }
        return sb.toString();
    }
}
