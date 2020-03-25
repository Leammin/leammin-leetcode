package com.leammin.leetcode.medium;

/**
 * 75. 颜色分类
 * 
 * <p>给定一个包含红色、白色和蓝色，一共&nbsp;<em>n </em>个元素的数组，<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。</p>
 * 
 * <p>此题中，我们使用整数 0、&nbsp;1 和 2 分别表示红色、白色和蓝色。</p>
 * 
 * <p><strong>注意:</strong><br>
 * 不能使用代码库中的排序函数来解决这道题。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> [2,0,2,1,1,0]
 * <strong>输出:</strong> [0,0,1,1,2,2]</pre>
 * 
 * <p><strong>进阶：</strong></p>
 * 
 * <ul>
 * 	<li>一个直观的解决方案是使用计数排序的两趟扫描算法。<br>
 * 	首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。</li>
 * 	<li>你能想出一个仅使用常数空间的一趟扫描算法吗？</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-03-25
 */
public interface SortColors {
    void sortColors(int[] nums);

    class Solution implements SortColors {

        @Override
        public void sortColors(int[] nums) {
            int[] count = new int[3];
            for (int num : nums) {
                count[num]++;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i < count[0]) {
                    nums[i] = 0;
                } else if (i < count[0] + count[1]) {
                    nums[i] = 1;
                } else {
                    nums[i] = 2;
                }
            }
        }
    }

    class Solution2 implements SortColors {

        @Override
        public void sortColors(int[] nums) {
            int red = 0;
            int blue = nums.length - 1;
            for (int i = 0; i <= blue; i++) {
                if (nums[i] == 0) {
                    swap(nums, red++, i);
                } else if (nums[i] == 2) {
                    swap(nums, blue--, i--);
                }
            }
        }

        private void swap(int[] nums, int x, int y) {
            if (x != y) {
                int tmp = nums[x];
                nums[x] = nums[y];
                nums[y] = tmp;
            }
        }
    }
}
