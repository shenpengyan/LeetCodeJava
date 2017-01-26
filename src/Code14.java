/**
 * 14. Longest Common Prefix
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 *
 * link: https://leetcode.com/problems/longest-common-prefix/
 * @author shenpengyan
 *
 */
public class Code14 {
	public static void main(String[] args) {
		Code14 code = new Code14();
		Solution sol = code.new Solution();
		System.out.println(sol.longestCommonPrefix(new String[] { "abab", "aba", "a" }));
	}

	class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs == null || strs.length == 0)
				return "";
			String commonPrefix = strs[0];
			for (int i = 1; i < strs.length; i++) {
				while (strs[i].indexOf(commonPrefix) != 0) {
					commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
				}
			}
			return commonPrefix;
		}
	}
}
