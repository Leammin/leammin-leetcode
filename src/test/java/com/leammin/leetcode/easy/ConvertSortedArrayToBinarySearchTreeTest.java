package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.EqualTestcase;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.TreeNodeUtils;

/**
 * @author Leammin
 * @date 2019-05-01
 */
class ConvertSortedArrayToBinarySearchTreeTest extends AbstractTest<ConvertSortedArrayToBinarySearchTree> {

    @Override
    protected Testsuite<ConvertSortedArrayToBinarySearchTree> testsuite() {
        return Testsuite.<ConvertSortedArrayToBinarySearchTree>builder()
                .add(EqualTestcase.of(true, s -> TreeNodeUtils.isAvl(s.sortedArrayToBST(new int[]{}))))
                .add(EqualTestcase.of(true, s -> TreeNodeUtils.isAvl(s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}))))
                .add(EqualTestcase.of(true, s -> TreeNodeUtils.isAvl(s.sortedArrayToBST(new int[]{
                        -10, -3, -1, 0, 5, 9, 10, 11, 13, 28, 30,
                        31, 32, 33, 59, 100, 156, 258, 1024, 1025}))))
                .build();
    }
}