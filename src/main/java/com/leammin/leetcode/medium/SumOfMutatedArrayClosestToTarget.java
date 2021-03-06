package com.leammin.leetcode.medium;

import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 *
 * <p>给你一个整数数组&nbsp;<code>arr</code> 和一个目标值&nbsp;<code>target</code> ，请你返回一个整数&nbsp;<code>value</code>&nbsp;，使得将数组中所有大于&nbsp;<code>value</code> 的值变成&nbsp;<code>value</code> 后，数组的和最接近&nbsp; <code>target</code>&nbsp;（最接近表示两者之差的绝对值最小）。</p>
 *
 * <p>如果有多种使得和最接近&nbsp;<code>target</code>&nbsp;的方案，请你返回这些整数中的最小值。</p>
 *
 * <p>请注意，答案不一定是&nbsp;<code>arr</code> 中的数字。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>arr = [4,9,3], target = 10
 * <strong>输出：</strong>3
 * <strong>解释：</strong>当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>arr = [2,3,5], target = 10
 * <strong>输出：</strong>5
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>arr = [60864,25176,27249,21296,20204], target = 56803
 * <strong>输出：</strong>11361
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= arr.length &lt;= 10^4</code></li>
 * 	<li><code>1 &lt;= arr[i], target &lt;= 10^5</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-06-14
 */
public interface SumOfMutatedArrayClosestToTarget {
    int findBestValue(int[] arr, int target);

    class Solution implements SumOfMutatedArrayClosestToTarget {

        @Override
        public int findBestValue(int[] arr, int target) {

            int[] count = new int[100001];
            int min = 0;
            for (int value : arr) {
                count[value]++;
                min = Math.min(min, value);
            }
            int resSum = Integer.MAX_VALUE;
            int res = 0;
            int r = arr.length;
            int sum = 0;
            for (int i = Math.min(min, target / arr.length); i < count.length && r > 0; i++) {
                sum += count[i] * i;
                r -= count[i];
                int s = Math.abs(target - (sum + i * r));
                if (s < resSum) {
                    resSum = s;
                    res = i;
                } else {
                    return res;
                }
            }
            return res;
        }
    }

    class Solution2 implements SumOfMutatedArrayClosestToTarget {

        @Override
        public int findBestValue(int[] arr, int target) {
            Arrays.sort(arr);
            int[] sum = new int[arr.length];
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                sum[i] = arr[i] + (i == 0 ? 0 : sum[i - 1]);
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }
            int minAbs = Integer.MAX_VALUE;
            int res = Integer.MAX_VALUE;
            int lo = Math.min(min, target / arr.length);
            int hi = max;
            while (lo <= hi) {
                int mid = (lo + hi) >> 1;
                int index = bs(arr, mid);
                int c = (arr.length - index) * mid + (index == 0 ? 0 : sum[index - 1]);
                int abs = Math.abs(target - c);
                if (abs < minAbs) {
                    minAbs = abs;
                    res = mid;
                } else if (abs == minAbs) {
                    res = Math.min(res, mid);
                } else {
                    return res;
                }
                if (c < target) {
                    lo = mid + 1;
                } else if (c > target) {
                    hi = mid - 1;
                } else {
                    return res;
                }
            }
            return res;
        }

        private static int bs(int[] nums, int key) {
            int lo = 0;
            int hi = nums.length;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (nums[mid] < key) {
                    lo = mid + 1;
                } else if (nums[mid] > key) {
                    hi = mid;
                } else {
                    return mid;
                }
            }
            return lo;
        }
    }
}
