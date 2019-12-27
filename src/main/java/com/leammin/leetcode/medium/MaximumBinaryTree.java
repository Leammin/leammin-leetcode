package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

/**
 * 654. 最大二叉树
 * 
 * <p>给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：</p>
 * 
 * <ol>
 * 	<li>二叉树的根是数组中的最大元素。</li>
 * 	<li>左子树是通过数组中最大值左边部分构造出的最大二叉树。</li>
 * 	<li>右子树是通过数组中最大值右边部分构造出的最大二叉树。</li>
 * </ol>
 * 
 * <p>通过给定的数组构建最大二叉树，并且输出这个树的根节点。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 ：</strong></p>
 * 
 * <pre><strong>输入：</strong>[3,2,1,6,0,5]
 * <strong>输出：</strong>返回下面这棵树的根节点：
 * 
 *       6
 *     /   \
 *    3     5
 *     \    / 
 *      2  0   
 *        \
 *         1
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li>给定的数组的大小在 [1, 1000] 之间。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2019-12-27
 */
public interface MaximumBinaryTree {
    TreeNode constructMaximumBinaryTree(int[] nums);

    class Solution implements MaximumBinaryTree {

        @Override
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return constructMaximumBinaryTree(nums, 0, nums.length);
        }

        private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
            if (start >= end) {
                return null;
            }
            if (start + 1 == end) {
                return new TreeNode(nums[start]);
            }
            int max = nums[start];
            int maxIndex = start;
            for (int i = start + 1; i < end; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = constructMaximumBinaryTree(nums, start, maxIndex);
            root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
            return root;
        }
    }
}
