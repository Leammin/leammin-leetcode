package com.leammin.leetcode.medium;

/**
 * 820. 单词的压缩编码
 *
 * <p>给定一个单词列表，我们将这个列表编码成一个索引字符串&nbsp;<code>S</code>&nbsp;与一个索引列表 <code>A</code>。</p>
 *
 * <p>例如，如果这个列表是 <code>[&quot;time&quot;, &quot;me&quot;, &quot;bell&quot;]</code>，我们就可以将其表示为 <code>S = &quot;time#bell#&quot;</code> 和 <code>indexes = [0, 2, 5]</code>。</p>
 *
 * <p>对于每一个索引，我们可以通过从字符串 <code>S</code>&nbsp;中索引的位置开始读取字符串，直到 &quot;#&quot; 结束，来恢复我们之前的单词列表。</p>
 *
 * <p>那么成功对给定单词列表进行编码的最小字符串长度是多少呢？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入:</strong> words = <code>[&quot;time&quot;, &quot;me&quot;, &quot;bell&quot;]</code>
 * <strong>输出:</strong> 10
 * <strong>说明:</strong> S = <code>&quot;time#bell#&quot; ， indexes = [0, 2, 5</code>] 。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>1 &lt;= words.length&nbsp;&lt;= 2000</code></li>
 * 	<li><code>1 &lt;=&nbsp;words[i].length&nbsp;&lt;= 7</code></li>
 * 	<li>每个单词都是小写字母 。</li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-03-28
 */
public interface ShortEncodingOfWords {
    int minimumLengthEncoding(String[] words);

    class Solution implements ShortEncodingOfWords {
        @Override
        public int minimumLengthEncoding(String[] words) {
            Object[] tree = new Object[26];
            for (String word : words) {
                fillTree(tree, word);
            }
            return count(tree)[0];
        }

        private void fillTree(Object[] tree, String word) {
            Object[] tmp = tree;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (tmp[c - 'a'] == null) {
                    tmp[c - 'a'] = new Object[26];
                }
                tmp = (Object[]) tmp[c - 'a'];
            }
        }

        private int[] count(Object[] tree) {
            int sum = 0;
            int leaf = 0;
            for (Object child : tree) {
                if (child instanceof Object[]) {
                    int[] childCount = count((Object[]) child);
                    sum += childCount[0] + childCount[1];
                    leaf += childCount[1];
                }
            }
            return new int[]{Math.max(sum, 1), Math.max(leaf, 1)};
        }
    }
}
