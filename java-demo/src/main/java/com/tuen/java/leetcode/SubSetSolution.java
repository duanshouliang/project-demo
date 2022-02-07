package com.tuen.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSetSolution {

    public static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> result = new ArrayList<>();


    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        subset(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> subset(int[] nums) {
        dfs(0, nums);
        return result;
    }

    public static void dfs(int start, int[] nums) {
        result.add(new ArrayList<>(path));
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i+1, nums);
            path.remove(path.size() -1);
        }
    }
}

