package com.tuen.java.leetcode;

public class QuickSort {

    public static void main(String[] args) {

        int[] nums = new int[]{3, 1, 6, 9, 3, 10, 0, 4, 8, 1};
        quickSort(nums);
        print(nums);
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length -1 );
    }

    public static void quickSort(int[] nums, int low, int high) {
        if(low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, 0, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];     //枢轴记录
        while (low<high){
            while (low<high && arr[high]>=pivot) --high;
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low<high && arr[low]<=pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }

    private static void swap(int[] nums, int low, int high) {
        int tmp = nums[low];
        nums[low] = nums[high];
        nums[high] = tmp;
    }

    public static void print(int[] nums) {
        for (int ele : nums) {
            System.out.print(ele + ",");
        }
    }
}
