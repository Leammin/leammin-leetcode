package com.leammin.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 895. 最大频率栈
 * 
 * <p>实现 <code>FreqStack</code>，模拟类似栈的数据结构的操作的一个类。</p>
 * 
 * <p><code>FreqStack</code>&nbsp;有两个函数：</p>
 * 
 * <ul>
 * 	<li><code>push(int x)</code>，将整数&nbsp;<code>x</code>&nbsp;推入栈中。</li>
 * 	<li><code>pop()</code>，它<strong>移除</strong>并返回栈中出现最频繁的元素。
 * 	<ul>
 * 		<li>如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。</li>
 * 	</ul>
 * 	</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例：</strong></p>
 * 
 * <pre><strong>输入：</strong>
 * [&quot;FreqStack&quot;,&quot;push&quot;,&quot;push&quot;,&quot;push&quot;,&quot;push&quot;,&quot;push&quot;,&quot;push&quot;,&quot;pop&quot;,&quot;pop&quot;,&quot;pop&quot;,&quot;pop&quot;],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * <strong>输出：</strong>[null,null,null,null,null,null,null,5,7,5,4]
 * <strong>解释：</strong>
 * 执行六次 .push 操作后，栈自底向上为 [5,7,5,7,4,5]。然后：
 * 
 * pop() -&gt; 返回 5，因为 5 是出现频率最高的。
 * 栈变成 [5,7,5,7,4]。
 * 
 * pop() -&gt; 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。
 * 栈变成 [5,7,5,4]。
 * 
 * pop() -&gt; 返回 5 。
 * 栈变成 [5,7,4]。
 * 
 * pop() -&gt; 返回 4 。
 * 栈变成 [5,7]。
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li>对&nbsp;<code>FreqStack.push(int x)</code>&nbsp;的调用中&nbsp;<code>0 &lt;= x &lt;= 10^9</code>。</li>
 * 	<li>如果栈的元素数目为零，则保证不会调用&nbsp; <code>FreqStack.pop()</code>。</li>
 * 	<li>单个测试样例中，对&nbsp;<code>FreqStack.push</code>&nbsp;的总调用次数不会超过&nbsp;<code>10000</code>。</li>
 * 	<li>单个测试样例中，对&nbsp;<code>FreqStack.pop</code>&nbsp;的总调用次数不会超过&nbsp;<code>10000</code>。</li>
 * 	<li>所有测试样例中，对&nbsp;<code>FreqStack.push</code>&nbsp;和 <code>FreqStack.pop</code>&nbsp;的总调用次数不会超过&nbsp;<code>150000</code>。</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * 
 * 
 * @author Leammin
 * @date 2021-02-25
 */
public interface MaximumFrequencyStack {
    void push(int x);

    int pop();

    class Solution implements MaximumFrequencyStack {
        Map<Integer, Integer> numToCount = new HashMap<>();
        List<List<Integer>> countToNum = new ArrayList<>();

        @Override
        public void push(int x) {
            int count = numToCount.getOrDefault(x, 0) + 1;
            numToCount.put(x, count);
            List<Integer> nums;
            if (count - 1 >= countToNum.size()) {
                countToNum.add((nums = new ArrayList<>()));
            } else {
                nums = countToNum.get(count - 1);
            }
            nums.add(x);
        }

        @Override
        public int pop() {
            int count = countToNum.size();
            List<Integer> nums = countToNum.get(count - 1);
            Integer num = nums.remove(nums.size() - 1);
            if (nums.isEmpty()) {
                countToNum.remove(count - 1);
            }
            numToCount.put(num, count - 1);
            return num;
        }
    }
}
