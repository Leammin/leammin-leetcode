package com.leammin.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * <div><p>给定一个整数数组，判断是否存在重复元素。</p>
 *
 * <p>如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> [1,2,3,1]
 * <strong>输出:</strong> true</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入: </strong>[1,2,3,4]
 * <strong>输出:</strong> false</pre>
 *
 * <p><strong>示例&nbsp;3:</strong></p>
 *
 * <pre><strong>输入: </strong>[1,1,1,3,3,4,3,2,4,2]
 * <strong>输出:</strong> true</pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-15
 */
public interface ContainsDuplicate {
    boolean containsDuplicate(int[] nums);

    class Solution implements ContainsDuplicate {
        @Override
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>(nums.length);
            for (int num : nums) {
                if (!set.add(num)) {
                    return true;
                }
            }
            return false;
        }
    }
}
