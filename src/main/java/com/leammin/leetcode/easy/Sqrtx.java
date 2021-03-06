package com.leammin.leetcode.easy;

/**
 * 69. x 的平方根
 * 
 * <p>实现&nbsp;<code>int sqrt(int x)</code>&nbsp;函数。</p>
 * 
 * <p>计算并返回&nbsp;<em>x</em>&nbsp;的平方根，其中&nbsp;<em>x </em>是非负整数。</p>
 * 
 * <p>由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> 4
 * <strong>输出:</strong> 2
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入:</strong> 8
 * <strong>输出:</strong> 2
 * <strong>说明:</strong> 8 的平方根是 2.82842..., 
 * &nbsp;    由于返回类型是整数，小数部分将被舍去。
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-04-10
 */
public interface Sqrtx {
    int mySqrt(int x);

    class Solution implements Sqrtx {

        @Override
        public int mySqrt(int x) {
            if (x <= 1) {
                return x;
            }
            long lo = 0;
            long hi = x;
            while (lo < hi - 1) {
                long mid = (hi + lo) / 2;
                long m = mid * mid;
                if (m > x) {
                    hi = mid;
                } else if (m < x) {
                    lo = mid;
                } else {
                    return (int) mid;
                }
            }
            return (int) lo;
        }
    }
}
