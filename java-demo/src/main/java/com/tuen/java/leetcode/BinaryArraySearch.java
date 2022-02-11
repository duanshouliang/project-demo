package com.tuen.java.leetcode;

/**
 * 在一个 n * m 的二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryArraySearch {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 2},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(search2(5, nums));
    }

    static boolean search(int target, int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int i = 0, j = 0;
        while (i < n) {
            while (j < m) {
                if (target > nums[i][j]) {
                    j++;
                } else if (target == nums[i][j]) {
                    return true;
                } else {
//                    int pre = j-1;
                    break;
                }
            }
            if (target > nums[i][j - 1]) {
                i++;
            } else if (nums[i][j - 1] == target) {
                return true;
            } else {
                break;
            }
        }
        return false;
    }

    static boolean search2(int target, int[][] nums) {
        if(null == nums || nums.length == 0 || nums[0].length == 0){
            return false;
        }
        int n = nums.length, m = nums.length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (nums[i][j] > target) {
                j--;
            } else if (nums[i][j] == target) {
                return true;
            } else {
                i++;
            }
        }
        return false;
    }
}
