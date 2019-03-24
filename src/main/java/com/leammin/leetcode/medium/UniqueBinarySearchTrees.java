package com.leammin.leetcode.medium;

/**
 * 96. 不同的二叉搜索树
 *
 * <div><p>给定一个整数 <em>n</em>，求以&nbsp;1 ...&nbsp;<em>n</em>&nbsp;为节点组成的二叉搜索树有多少种？</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> 3
 * <strong>输出:</strong> 5
 * <strong>解释:
 * </strong>给定 <em>n</em> = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3</pre>
 * </div>
 *
 *
 * @author Leammin
 * @date 2019-03-24
 */
public class UniqueBinarySearchTrees {
    // TODO: 2019/3/24 todo
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        return 0;
    }
}
