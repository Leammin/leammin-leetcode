package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-22
 */
class XuanZhuanShuZuDeZuiXiaoShuZiLcofTest extends AbstractTest<XuanZhuanShuZuDeZuiXiaoShuZiLcof> {
    @Override
    protected Testsuite<XuanZhuanShuZuDeZuiXiaoShuZiLcof> testsuite() {
        return Testsuite.<XuanZhuanShuZuDeZuiXiaoShuZiLcof>builder()
                .add(ExpectedTestcase.of(t -> t.minArray(new int[]{3,4,5,1,2}), 1))
                .add(ExpectedTestcase.of(t -> t.minArray(new int[]{2,2,2,0,1}), 0))
                .build();
    }
}