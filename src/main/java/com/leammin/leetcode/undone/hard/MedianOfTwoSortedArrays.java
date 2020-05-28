package com.leammin.leetcode.undone.hard;

/**
 * 4. 寻找两个有序数组的中位数
 * 
 * <p>给定两个大小为 m 和 n 的有序数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>。</p>
 * 
 * <p>请你找出这两个有序数组的中位数，并且要求算 法的时间复杂度为&nbsp;O(log(m + n))。</p>
 * 
 * <p>你可以假设&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>&nbsp;不会同时为空。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre>nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-05-24
 */
public interface MedianOfTwoSortedArrays {
    double findMedianSortedArrays(int[] nums1, int[] nums2);

    class Solution implements MedianOfTwoSortedArrays {

        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return 0;
        }
    }
}