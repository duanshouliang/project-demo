package com.tuen.java.leetcode;

import java.util.*;

public class RepeatedNum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,2,1,2,3,4,5,6,0,7,0,1};
        System.out.println(solution(nums));
    }

    public static List<Integer> solution(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> ele = iterator.next();
            if( ele.getValue() > 1){
                res.add(ele.getKey());
            }
        }
        return res;
    }
}
