package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

/**
 * 129. 求根到叶子节点数字之和
 * 
 * <p>给定一个二叉树，它的每个结点都存放一个&nbsp;<code>0-9</code>&nbsp;的数字，每条从根到叶子节点的路径都代表一个数字。</p>
 * 
 * <p>例如，从根到叶子节点路径 <code>1-&gt;2-&gt;3</code> 代表数字 <code>123</code>。</p>
 * 
 * <p>计算从根到叶子节点生成的所有数字之和。</p>
 * 
 * <p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> [1,2,3]
 *     1
 *    / \
 *   2   3
 * <strong>输出:</strong> 25
 * <strong>解释:</strong>
 * 从根到叶子节点路径 <code>1-&gt;2</code> 代表数字 <code>12</code>.
 * 从根到叶子节点路径 <code>1-&gt;3</code> 代表数字 <code>13</code>.
 * 因此，数字总和 = 12 + 13 = <code>25</code>.</pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入:</strong> [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 * &nbsp;/ \
 * 5   1
 * <strong>输出:</strong> 1026
 * <strong>解释:</strong>
 * 从根到叶子节点路径 <code>4-&gt;9-&gt;5</code> 代表数字 495.
 * 从根到叶子节点路径 <code>4-&gt;9-&gt;1</code> 代表数字 491.
 * 从根到叶子节点路径 <code>4-&gt;0</code> 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = <code>1026</code>.</pre>
 * 
 * 
 * @author Leammin
 * @date 2019-10-05
 */
public interface SumRootToLeafNumbers {
    int sumNumbers(TreeNode root);

    class Solution implements SumRootToLeafNumbers {
        int sum = 0;

        @Override
        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            number(root, 0);
            return sum;
        }

        public void number(TreeNode root, int sumParents) {
            int sumThis = sumParents * 10 + root.val;
            if (root.left == null && root.right == null) {
                sum += sumThis;
            }
            if (root.left != null) {
                number(root.left, sumThis);
            }
            if (root.right != null) {
                number(root.right, sumThis);
            }
        }
    }
}
