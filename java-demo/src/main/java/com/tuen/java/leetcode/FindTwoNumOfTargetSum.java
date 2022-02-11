package com.tuen.java.leetcode;

import com.tuen.java.basic.generics.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTwoNumOfTargetSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,8,9};
        int target = 10;
        System.out.println(solution2(nums, target));
    }

    static List<Integer> solution(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> dic = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dic.put(i, nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            if(dic.containsKey(target - nums[i])){
                res.add(i);
                res.add(dic.get(target- nums[i]));
                break;
            }
        }
        return res;
    }
    static List<Integer> solution2(int[] nums, int target) {
        Map<Integer, Integer> dic = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(dic.containsKey(target - nums[i])){
//                return new int[]{i, dic.get(target-nums[i])};
                res.add(i);
                res.add(dic.get(target- nums[i]));
                return res;
            }
            dic.put(nums[i], i);
        }
        return null;
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                System.out.println(hashtable.get(target - nums[i])+"-"+ i);
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


}
