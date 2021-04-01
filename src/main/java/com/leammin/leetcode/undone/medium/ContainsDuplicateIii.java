package com.leammin.leetcode.undone.medium;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 *
 * <p>给定一个整数数组，判断数组中是否有两个不同的索引 <em>i</em> 和 <em>j</em>，使得&nbsp;<strong>nums [i]</strong> 和&nbsp;<strong>nums [j]</strong>&nbsp;的差的绝对值最大为 <em>t</em>，并且 <em>i</em> 和 <em>j</em> 之间的差的绝对值最大为 <em>ķ</em>。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> nums = [1,2,3,1], k<em> </em>= 3, t = 0
 * <strong>输出:</strong> true</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入: </strong>nums = [1,0,1,1], k<em> </em>=<em> </em>1, t = 2
 * <strong>输出:</strong> true</pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre><strong>输入: </strong>nums = [1,5,9,1,5,9], k = 2, t = 3
 * <strong>输出:</strong> false</pre>
 *
 *
 * @author Leammin
 * @date 2021-03-31
 */
public interface ContainsDuplicateIii {
    boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t);

    class Solution implements ContainsDuplicateIii {

        @Override
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (t < 0 || k <= 0) {
                return false;
            }
            TreeSet<Integer> set = new TreeSet<>();
            for (int j = 0; j < nums.length; j++) {
                Integer ceiling = set.ceiling(nums[j]);
                Integer floor = set.floor(nums[j]);
                if ((ceiling != null && Math.abs((long) nums[j] - ceiling) <= t)
                        || (floor != null && Math.abs((long) nums[j] - floor) <= t)) {
                    return true;
                }
                set.add(nums[j]);
                if (j >= k) {
                    set.remove(nums[j - k]);
                }
            }
            return false;
        }
    }
}
