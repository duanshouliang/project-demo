package com.tuen.java.leetcode;

public class MedianMain {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return pointers(nums1, nums2);
    }

    public static double merge(int[] nums1, int[] nums2) {
        return 0.0;
    }

    /**
     * 双指针实现 O（m+n）
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double pointers(int[] nums1, int[] nums2) {
        int middle = (nums1.length + nums2.length) / 2;
        //使用双指针遍历
        int i = 0, j = 0, l = 0, r = 0;

        for (int x = 0; x <= middle; x++) {
            //记录前一个元素的值，当(m+n)%2==0时，则需要使用（l+r）/2.0来获取中位数
            l = r;
            if (i < nums1.length && nums1[i] < nums2[j]) {
                r = nums1[i++];
            } else if (j < nums2.length) {
                r = nums2[j++];
            }
        }
        return (nums1.length + nums2.length) % 2 != 0 ? r : (l + r) / 2.0;
    }

    /**
     * 递归的方式获取第k大的元素
     *
     * @param nums1
     * @param start1
     * @param end1
     * @param nums2
     * @param start2
     * @param end2
     * @param k
     * @return
     */
    public static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = nums1.length - start1 + 1;
        int len2 = nums2.length - start2 + 1;

//        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);

        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }

    }

    /**
     * 二分法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double binary(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        ;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;

        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }


    public static double binary2(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        if (len % 2 == 1) {
            return getKth2(nums1, nums2, len / 2 + 1);
        } else {
            // 为偶数时，中位数为第k和k+1两个数的平均值
            return (getKth2(nums1, nums2, len / 2) + getKth2(nums1, nums2, len / 2 + 1)) * 0.5;
        }
    }


    /**
     * 非递归的方式获取第k大的元素
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int getKth2(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int start1 = 0, start2 = 0;
        while (true) {
            if (start1 == len1) {
                return nums2[start2 + k - 1];
            }

            if (start2 == len2) {
                return nums1[start1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }

            int half = k / 2;
            int i = Math.min(start1 + half, len1) - 1;
            int j = Math.min(start2 + half, len2) - 1;
            if (nums1[i] <= nums2[j]) {
                k -= (i - start1 + 1);
                start1 = i + 1;
            } else {
                k -= (j - start2 + 1);
                start2 = j + 1;
            }
        }
    }

    public static double arraySplit(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return arraySplit(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        int mid1 = 0, mid2 = 0;

        while (left < right) {
            // 前一部分包含nums1[0,..,i-1]和nums2[0,..,j-1]
            // 后一部分包含nums1[i,..,m-1]和nums2[j,..,n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            //一下表示数组nums1和nums2分割后的四个集合的边界
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 < nums_j) {
                mid1 = Math.max(nums_im1, nums_jm1);
                mid2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (mid1 + mid2) / 2.0 : mid1;
    }

    public static void main(String[] args) {
        // 1,2,3,4,6,6,7,9,11;
        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6};
        int[] nums1 = new int[]{7, 8, 9, 11};
        System.out.println(arraySplit(nums1, nums2));
    }
}
