package com.leammin.leetcode.easy;

/**
 * 88. 合并两个有序数组
 *
 * <div><p>给定两个有序整数数组&nbsp;<em>nums1 </em>和 <em>nums2</em>，将 <em>nums2 </em>合并到&nbsp;<em>nums1&nbsp;</em>中<em>，</em>使得&nbsp;<em>num1 </em>成为一个有序数组。</p>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * <li>初始化&nbsp;<em>nums1</em> 和 <em>nums2</em> 的元素数量分别为&nbsp;<em>m</em> 和 <em>n</em>。</li>
 * <li>你可以假设&nbsp;<em>nums1&nbsp;</em>有足够的空间（空间大小大于或等于&nbsp;<em>m + n</em>）来保存 <em>nums2</em> 中的元素。</li>
 * </ul>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * <strong>输出:</strong>&nbsp;[1,2,2,3,5,6]</pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-08-26
 */
public interface MergeSortedArray {
    void merge(int[] nums1, int m, int[] nums2, int n);

    class Solution implements MergeSortedArray {
        @Override
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int mIndex = 0;
            int nIndex = 0;
            int[] res = new int[m + n];
            for (int i = 0; i < res.length; i++) {
                if (mIndex >= m) {
                    res[i] = nums2[nIndex++];
                } else if (nIndex >= n) {
                    res[i] = nums1[mIndex++];
                } else {
                    int mTemp = nums1[mIndex];
                    int nTemp = nums2[nIndex];
                    if (mTemp <= nTemp) {
                        res[i] = mTemp;
                        mIndex++;
                    } else {
                        res[i] = nTemp;
                        nIndex++;
                    }
                }
            }
            System.arraycopy(res, 0, nums1, 0, res.length);
        }
    }

}
