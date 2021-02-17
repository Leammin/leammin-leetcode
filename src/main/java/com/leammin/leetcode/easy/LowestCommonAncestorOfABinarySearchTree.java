package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.Execute;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 
 * <p>给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。</p>
 * 
 * <p><a href="https://baike.baidu.com/item/%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/8918834?fr=aladdin" target="_blank">百度百科</a>中最近公共祖先的定义为：&ldquo;对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（<strong>一个节点也可以是它自己的祖先</strong>）。&rdquo;</p>
 * 
 * <p>例如，给定如下二叉搜索树:&nbsp; root =&nbsp;[6,2,8,0,4,7,9,null,null,3,5]</p>
 * 
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/binarysearchtree_improved.png" style="height: 190px; width: 200px;"></p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * <strong>输出:</strong> 6 
 * <strong>解释: </strong>节点 <code>2 </code>和节点 <code>8 </code>的最近公共祖先是 <code>6。</code>
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入:</strong> root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * <strong>输出:</strong> 2
 * <strong>解释: </strong>节点 <code>2</code> 和节点 <code>4</code> 的最近公共祖先是 <code>2</code>, 因为根据定义最近公共祖先节点可以为节点本身。</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ul>
 * 	<li>所有节点的值都是唯一的。</li>
 * 	<li>p、q 为不同节点且均存在于给定的二叉搜索树中。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-02-17
 */
public interface LowestCommonAncestorOfABinarySearchTree {
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);

    @Execute(cases = 1)
    class Solution implements LowestCommonAncestorOfABinarySearchTree {

        @Override
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int a = Math.min(p.val, q.val);
            int b = Math.max(p.val, q.val);
            while (root.val < a || root.val > b) {
                root = root.val < a ? root.right : root.left;
            }
            return root;
        }
    }
}
