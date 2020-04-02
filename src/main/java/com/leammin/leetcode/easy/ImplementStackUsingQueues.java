package com.leammin.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 
 * <p>使用队列实现栈的下列操作：</p>
 * 
 * <ul>
 * 	<li>push(x) -- 元素 x 入栈</li>
 * 	<li>pop() -- 移除栈顶元素</li>
 * 	<li>top() -- 获取栈顶元素</li>
 * 	<li>empty() -- 返回栈是否为空</li>
 * </ul>
 * 
 * <p><strong>注意:</strong></p>
 * 
 * <ul>
 * 	<li>你只能使用队列的基本操作-- 也就是&nbsp;<code>push to back</code>, <code>peek/pop from front</code>, <code>size</code>, 和&nbsp;<code>is empty</code>&nbsp;这些操作是合法的。</li>
 * 	<li>你所使用的语言也许不支持队列。&nbsp;你可以使用 list 或者 deque（双端队列）来模拟一个队列&nbsp;, 只要是标准的队列操作即可。</li>
 * 	<li>你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-03-31
 */
public abstract class ImplementStackUsingQueues {

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
    }

    /** Push element x onto stack. */
    public abstract void push(int x);

    /** Removes the element on top of the stack and returns that element. */
    public abstract int pop();

    /** Get the top element. */
    public abstract int top();

    /** Returns whether the stack is empty. */
    public abstract boolean empty();

    public static class Solution extends ImplementStackUsingQueues {

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        public Solution() {

        }

        @Override
        public void push(int x) {
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            Queue<Integer> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }

        @Override
        public int pop() {
            return queue2.poll();
        }

        @Override
        public int top() {
            return queue2.peek();
        }

        @Override
        public boolean empty() {
            return queue2.isEmpty();
        }
    }
}
