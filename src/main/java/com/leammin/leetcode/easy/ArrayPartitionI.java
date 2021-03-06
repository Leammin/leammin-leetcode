package com.leammin.leetcode.easy;

/**
 * 561. 数组拆分 I
 * 
 * <p>给定长度为&nbsp;<strong>2n&nbsp;</strong>的数组, 你的任务是将这些数分成&nbsp;<strong>n </strong>对, 例如 (a<sub>1</sub>, b<sub>1</sub>), (a<sub>2</sub>, b<sub>2</sub>), ..., (a<sub>n</sub>, b<sub>n</sub>) ，使得从1 到&nbsp;n 的 min(a<sub>i</sub>, b<sub>i</sub>) 总和最大。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> [1,4,3,2]
 * 
 * <strong>输出:</strong> 4
 * <strong>解释:</strong> n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * </pre>
 * 
 * <p><strong>提示:</strong></p>
 * 
 * <ol>
 * 	<li><strong>n</strong>&nbsp;是正整数,范围在 [1, 10000].</li>
 * 	<li>数组中的元素范围在 [-10000, 10000].</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2020-06-13
 */
public interface ArrayPartitionI {
    int arrayPairSum(int[] nums);

    class Solution implements ArrayPartitionI {

        @Override
        public int arrayPairSum(int[] nums) {
            int[] count = new int[20001];
            for (int num : nums) {
                count[num + 10000]++;
            }
            int res = 0;
            int l = 0;
            for (int i = -10000; i <= 10000; i++) {
                int c = count[i + 10000];
                if (c > 0) {
                    res += i * ((c + ((l & 1) == 0 ? 1 : 0)) / 2);
                    l += c;
                }
            }
            return res;
        }
    }
}
