package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.TreeNode;

import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * <div><p>序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。</p>
 *
 * <p>请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。</p>
 *
 * <p><strong>示例:&nbsp;</strong></p>
 *
 * <pre>你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 <code>"[1,2,3,null,null,4,5]"</code></pre>
 *
 * <p><strong>提示:&nbsp;</strong>这与 LeetCode 目前使用的方式一致，详情请参阅&nbsp;<a href="/faq/#binary-tree">LeetCode 序列化二叉树的格式</a>。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。</p>
 *
 * <p><strong>说明:&nbsp;</strong>不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。</p>
 * </div>
 *
 * @author Leammin
 * @date 2019-05-01
 */
public interface SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    String serialize(TreeNode root);

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data);

    class Solution implements SerializeAndDeserializeBinaryTree {

        @Override
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            LinkedList<TreeNode> level = new LinkedList<>();
            level.add(root);
            StringBuilder result = new StringBuilder();
            while (!level.isEmpty()) {
                TreeNode node = level.pop();
            }
            return null;
        }

        @Override
        public TreeNode deserialize(String data) {
            return null;
        }
    }
}
