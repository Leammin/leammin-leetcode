package com.leammin.leetcode.undone.easy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 
 * <p>假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值&nbsp;g<sub>i ，</sub>这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 s<sub>j&nbsp;</sub>。如果 s<sub>j</sub> &gt;= g<sub>i&nbsp;</sub>，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。</p>
 * 
 * <p><strong>注意：</strong></p>
 * 
 * <p>你可以假设胃口值为正。<br />
 * 一个小朋友最多只能拥有一块饼干。</p>
 * 
 * <p><strong>示例&nbsp;1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> [1,2,3], [1,1]
 * 
 * <strong>输出:</strong> 1
 * 
 * <strong>解释:</strong> 
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> [1,2], [1,2,3]
 * 
 * <strong>输出:</strong> 2
 * 
 * <strong>解释:</strong> 
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2019-08-29
 */
public interface AssignCookies {
    int findContentChildren(int[] g, int[] s);

    /**
     * g.length = n
     * s.length = m
     * 时间复杂度: m * log(m) + n * m
     */
    class Solution implements AssignCookies {
        @Override
        public int findContentChildren(int[] g, int[] s) {
            int length = s.length;
            if (length == 0) {
                return 0;
            }
            int res = 0;
            Arrays.sort(s);
            for (int gv : g) {
                int search = Arrays.binarySearch(s,0, length, gv);
                if (search < 0) {
                    search = -search - 1;
                }
                if (search >= length) {
                    continue;
                }
                System.arraycopy(s, search + 1, s, search, length - search - 1);
                res++;
                length--;
            }
            return res;
        }
    }

    /**
     * 时间复杂度: n * log(n) + m * log(n) + min(n, m)
     */
    class Solution2 implements AssignCookies {

        @Override
        public int findContentChildren(int[] g, int[] s) {
            if (s.length == 0) {
                return 0;
            }
            int res = 0;
            Arrays.sort(g);
            Arrays.sort(s);
            int si = 0;
            for (int gi = 0; gi < g.length; gi++, si++) {
                while (si < s.length && g[gi] > s[si]) {
                    si++;
                }
                if (si == s.length) {
                    return res;
                }
                res++;
            }
            return res;
        }
    }
}
