package com.tuen.java.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthElementWithHeap {

    /**
     * 使用优先队列实现
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.intValue() - o1.intValue();
            }
        });

        for (int num : nums) {
            maxHeap.offer(num);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }


    /**
     * 构建大根堆实现
     *
     * @param nums
     */
    public static int findKthLargestByMaxHeap(int[] nums, int k){
        int n = nums.length;
        //初始化堆
        buildMaxHeap(nums);
        for(int i=0;i<k-1;i++){
            int tmp = nums[0];
            nums[0] = nums[n-i-1];
            nums[n-i-1] = tmp;
            adjustHeap(nums, 0, n-i-2);//n-i-2，每次将对顶替换掉n-i-2的元素，即将最大值从堆底依次往上排
        }
        return nums[0];
    }



    public static void buildMaxHeap(int[] nums) {
        int n = nums.length;
        for (int root = n / 2; root >= 0; root--) {
            adjustHeap(nums, root, n - 1);
        }
    }

    public static void adjustHeap(int[] nums, int root, int hi) {
        if (root > hi) {
            return;
        }

        int t = nums[root];
        int child = 2 * root + 1;
        while (child <= hi) {
            if (child + 1 <= hi && nums[child] < nums[child + 1]) {
                child++;
            }
            if (t > nums[child]) {
                break;
            }
            nums[root] = nums[child];
            root = child;
            child = 2 * root + 1;
        }
        nums[root] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 0, 3, 2, 4, 9};
        System.out.println(findKthLargest(nums, nums.length));
        System.out.println(findKthLargestByMaxHeap(nums, nums.length));
    }
}
