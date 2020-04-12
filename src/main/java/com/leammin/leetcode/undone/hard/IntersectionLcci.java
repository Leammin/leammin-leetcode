package com.leammin.leetcode.undone.hard;

/**
 * 面试题 16.03. 交点
 * 
 * <p>给定两条线段（表示为起点<code>start = {X1, Y1}</code>和终点<code>end = {X2, Y2}</code>），如果它们有交点，请计算其交点，没有交点则返回空值。</p>
 * </p>要求浮点型误差不超过<code>10^-6</code>。若有多个交点（线段重叠）则返回X值最小的点，X坐标相同则返回Y值最小的点。</p>
 * <p><strong>示例 1：</strong></p>
 * <pre><strong>输入：</strong>
 * line1 = {0, 0}, {1, 0}
 * line2 = {1, 1}, {0, -1}
 * <strong>输出：</strong> {0.5, 0}
 * </pre>
 * <p><strong>示例 2：</strong></p>
 * <pre><strong>输入：</strong>
 * line1 = {0, 0}, {3, 3}
 * line2 = {1, 1}, {2, 2}
 * <strong>输出：</strong> {1, 1}
 * </pre>
 * <p><strong>示例 3：</strong></p>
 * <pre><strong>输入：</strong>
 * line1 = {0, 0}, {1, 1}
 * line2 = {1, 0}, {2, 1}
 * <strong>输出：</strong> {}，两条线段没有交点
 * </pre>
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li>坐标绝对值不会超过2^7</li>
 * <li>输入的坐标均是有效的二维坐标</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-04-13
 */
public interface IntersectionLcci {
    double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2);

    class Solution implements IntersectionLcci {

        @Override
        public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
            return new double[0];
        }
    }
}
