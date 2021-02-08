package com.leammin.leetcode.easy;

/**
 * 665. 非递减数列
 *
 * <p>给定一个长度为&nbsp;<code>n</code>&nbsp;的整数数组，你的任务是判断在<strong>最多</strong>改变&nbsp;<code>1</code> 个元素的情况下，该数组能否变成一个非递减数列。</p>
 *
 * <p>我们是这样定义一个非递减数列的：&nbsp;对于数组中所有的&nbsp;<code>i</code> (1 &lt;= i &lt; n)，满足&nbsp;<code>array[i] &lt;= array[i + 1]</code>。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> [4,2,3]
 * <strong>输出:</strong> True
 * <strong>解释:</strong> 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> [4,2,1]
 * <strong>输出:</strong> False
 * <strong>解释:</strong> 你不能在只改变一个元素的情况下将其变为非递减数列。
 * </pre>
 *
 * <p><strong>说明:&nbsp;&nbsp;</strong><code>n</code> 的范围为 [1, 10,000]。</p>
 *
 * @author Leammin
 * @date 2021-02-08
 */
public interface NonDecreasingArray {
    boolean checkPossibility(int[] nums);

    class Solution implements NonDecreasingArray {

        @Override
        public boolean checkPossibility(int[] nums) {
            boolean updated = false;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] > nums[i]) {
                    if (updated) {
                        return false;
                    }
                    if (i == nums.length - 1) {
                        return true;
                    }
                    if (i == 1 || nums[i - 2] <= nums[i] || nums[i + 1] >= nums[i - 1]) {
                        updated = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}