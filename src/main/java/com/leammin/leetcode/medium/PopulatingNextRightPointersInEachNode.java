package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.Node;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 
 * <p>给定一个<strong>完美二叉树</strong>，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：</p>
 * 
 * <pre>struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }</pre>
 * 
 * <p>填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 <code>NULL</code>。</p>
 * 
 * <p>初始状态下，所有&nbsp;next 指针都被设置为 <code>NULL</code>。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/15/116_sample.png" style="height: 218px; width: 640px;"></p>
 * 
 * <pre><strong>输入：</strong>{&quot;$id&quot;:&quot;1&quot;,&quot;left&quot;:{&quot;$id&quot;:&quot;2&quot;,&quot;left&quot;:{&quot;$id&quot;:&quot;3&quot;,&quot;left&quot;:null,&quot;next&quot;:null,&quot;right&quot;:null,&quot;val&quot;:4},&quot;next&quot;:null,&quot;right&quot;:{&quot;$id&quot;:&quot;4&quot;,&quot;left&quot;:null,&quot;next&quot;:null,&quot;right&quot;:null,&quot;val&quot;:5},&quot;val&quot;:2},&quot;next&quot;:null,&quot;right&quot;:{&quot;$id&quot;:&quot;5&quot;,&quot;left&quot;:{&quot;$id&quot;:&quot;6&quot;,&quot;left&quot;:null,&quot;next&quot;:null,&quot;right&quot;:null,&quot;val&quot;:6},&quot;next&quot;:null,&quot;right&quot;:{&quot;$id&quot;:&quot;7&quot;,&quot;left&quot;:null,&quot;next&quot;:null,&quot;right&quot;:null,&quot;val&quot;:7},&quot;val&quot;:3},&quot;val&quot;:1}
 * 
 * <strong>输出：</strong>{&quot;$id&quot;:&quot;1&quot;,&quot;left&quot;:{&quot;$id&quot;:&quot;2&quot;,&quot;left&quot;:{&quot;$id&quot;:&quot;3&quot;,&quot;left&quot;:null,&quot;next&quot;:{&quot;$id&quot;:&quot;4&quot;,&quot;left&quot;:null,&quot;next&quot;:{&quot;$id&quot;:&quot;5&quot;,&quot;left&quot;:null,&quot;next&quot;:{&quot;$id&quot;:&quot;6&quot;,&quot;left&quot;:null,&quot;next&quot;:null,&quot;right&quot;:null,&quot;val&quot;:7},&quot;right&quot;:null,&quot;val&quot;:6},&quot;right&quot;:null,&quot;val&quot;:5},&quot;right&quot;:null,&quot;val&quot;:4},&quot;next&quot;:{&quot;$id&quot;:&quot;7&quot;,&quot;left&quot;:{&quot;$ref&quot;:&quot;5&quot;},&quot;next&quot;:null,&quot;right&quot;:{&quot;$ref&quot;:&quot;6&quot;},&quot;val&quot;:3},&quot;right&quot;:{&quot;$ref&quot;:&quot;4&quot;},&quot;val&quot;:2},&quot;next&quot;:null,&quot;right&quot;:{&quot;$ref&quot;:&quot;7&quot;},&quot;val&quot;:1}
 * 
 * <strong>解释：</strong>给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li>你只能使用常量级额外空间。</li>
 * 	<li>使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-03-16
 */
public interface PopulatingNextRightPointersInEachNode {
    Node connect(Node root);

    class Solution implements PopulatingNextRightPointersInEachNode {

        @Override
        public Node connect(Node root) {
            if (root == null || root.left == null) {
                return root;
            }
            recursive(root.left, root.right);
            return root;
        }

        private void recursive(Node left, Node right) {
            left.next = right;
            if (left.left != null) {
                recursive(left.left, left.right);
                recursive(left.right, right.left);
                recursive(right.left, right.right);
            }
        }
    }

    class Solution2 implements PopulatingNextRightPointersInEachNode {

        @Override
        public Node connect(Node root) {
            if (root == null || root.left == null) {
                return root;
            }
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
            return root;
        }
    }

    class Solution3 implements PopulatingNextRightPointersInEachNode {

        @Override
        public Node connect(Node root) {
            if (root == null || root.left == null) {
                return root;
            }
            Node parent = root;
            Node first = root.left;
            while (first != null) {
                parent.left.next = parent.right;
                if (parent.next != null) {
                    parent.right.next = parent.next.left;
                    parent = parent.next;
                } else {
                    parent = first;
                    first = parent.left;
                }
            }
            return root;
        }
    }
}
