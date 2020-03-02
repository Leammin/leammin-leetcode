package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2020-01-04
 */
class AllElementsInTwoBinarySearchTreesTest extends AbstractTest<AllElementsInTwoBinarySearchTrees> {
    @Override
    protected Testsuite<AllElementsInTwoBinarySearchTrees> testsuite() {
        return Testsuite.<AllElementsInTwoBinarySearchTrees>builder()
                .add(ExpectedTestcase.of(List.of(0, 1, 1, 2, 3, 4), s -> s.getAllElements(TreeNode.of(2, 1, 4), TreeNode.of(1, 0, 3))))
                .add(ExpectedTestcase.of(List.of(-10, 0, 0, 1, 2, 5, 7, 10), s -> s.getAllElements(TreeNode.of(0, -10, 10), TreeNode.of(5, 1, 7, 0, 2))))
                .add(ExpectedTestcase.of(List.of(0, 1, 2, 5, 7), s -> s.getAllElements(TreeNode.of(), TreeNode.of(5, 1, 7, 0, 2))))
                .add(ExpectedTestcase.of(List.of(-10, 0, 10), s -> s.getAllElements(TreeNode.of(0, -10, 10), TreeNode.of())))
                .add(ExpectedTestcase.of(List.of(1, 1, 8, 8), s -> s.getAllElements(TreeNode.of(1, null, 8), TreeNode.of(8, 1))))
                .build();
    }
}