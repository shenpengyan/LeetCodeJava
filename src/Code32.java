import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * 
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * link: https://leetcode.com/problems/longest-valid-parentheses/
 * 
 * @author shenpengyan
 *
 */

public class Code32 {
	public static void main(String[] args) {
		Code32 code = new Code32();
		Solution sol = code.new Solution();
		System.out.println(sol.longestValidParentheses(")()(()("));
	}

	/**
	 * 括号匹配必须用栈Stack
	 * 
	 * @author shenpengyan
	 *
	 */
	class Solution {
		public int longestValidParentheses(String s) {
			Stack<Integer> stack = new Stack<Integer>();
			int max = 0;
			int left = -1;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '(')
					stack.push(j);
				else {
					if (stack.isEmpty())
						left = j;
					else {
						stack.pop();
						if (stack.isEmpty())
							max = Math.max(max, j - left);
						else
							max = Math.max(max, j - stack.peek());
					}
				}
			}
			return max;

		}
	}
}
