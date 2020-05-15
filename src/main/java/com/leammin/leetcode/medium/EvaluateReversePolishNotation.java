package com.leammin.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.function.IntBinaryOperator;

/**
 * 150. 逆波兰表达式求值
 *
 * <p>根据<a href="https://baike.baidu.com/item/%E9%80%86%E6%B3%A2%E5%85%B0%E5%BC%8F/128437" target="_blank">逆波兰表示法</a>，求表达式的值。</p>
 *
 * <p>有效的运算符包括&nbsp;<code>+</code>,&nbsp;<code>-</code>,&nbsp;<code>*</code>,&nbsp;<code>/</code>&nbsp;。每个运算对象可以是整数，也可以是另一个逆波兰表达式。</p>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ul>
 * 	<li>整数除法只保留整数部分。</li>
 * 	<li>给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。</li>
 * </ul>
 *
 * <p><strong>示例&nbsp;1：</strong></p>
 *
 * <pre><strong>输入:</strong> [&quot;2&quot;, &quot;1&quot;, &quot;+&quot;, &quot;3&quot;, &quot;*&quot;]
 * <strong>输出:</strong> 9
 * <strong>解释:</strong> ((2 + 1) * 3) = 9
 * </pre>
 *
 * <p><strong>示例&nbsp;2：</strong></p>
 *
 * <pre><strong>输入:</strong> [&quot;4&quot;, &quot;13&quot;, &quot;5&quot;, &quot;/&quot;, &quot;+&quot;]
 * <strong>输出:</strong> 6
 * <strong>解释:</strong> (4 + (13 / 5)) = 6
 * </pre>
 *
 * <p><strong>示例&nbsp;3：</strong></p>
 *
 * <pre><strong>输入:</strong> [&quot;10&quot;, &quot;6&quot;, &quot;9&quot;, &quot;3&quot;, &quot;+&quot;, &quot;-11&quot;, &quot;*&quot;, &quot;/&quot;, &quot;*&quot;, &quot;17&quot;, &quot;+&quot;, &quot;5&quot;, &quot;+&quot;]
 * <strong>输出:</strong> 22
 * <strong>解释:</strong>
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22</pre>
 *
 * @author Leammin
 * @date 2020-05-14
 */
public interface EvaluateReversePolishNotation {
    int evalRPN(String[] tokens);

    class Solution implements EvaluateReversePolishNotation {

        @Override
        public int evalRPN(String[] tokens) {
            Map<String, IntBinaryOperator> map = Map.of(
                    "+", (a, b) -> a + b,
                    "-", (a, b) -> a - b,
                    "*", (a, b) -> a * b,
                    "/", (a, b) -> a / b
            );
            ArrayDeque<Integer> stack = new ArrayDeque<>(tokens.length);
            for (String token : tokens) {
                if (map.containsKey(token)) {
                    Integer b = stack.poll();
                    stack.push(map.get(token).applyAsInt(stack.poll(), b));
                } else {
                    stack.push(Integer.valueOf(token));
                }
            }
            return stack.poll();
        }
    }
}
