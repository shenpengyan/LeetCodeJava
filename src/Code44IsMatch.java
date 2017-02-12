/**
 * 44. Wildcard Matching
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "*") → true isMatch("aa", "a*") →
 * true isMatch("ab", "?*") → true isMatch("aab", "c*a*b") → false
 * 
 * link: https://leetcode.com/problems/wildcard-matching/
 * 
 * @author shenpengyan
 *
 */
public class Code44IsMatch {

	public static void main(String[] args) {
		Code44IsMatch code = new Code44IsMatch();
		Solution sol = code.new Solution();
		System.out.println(sol.isMatch("aa", "a"));
		System.out.println(sol.isMatch("aa", "aa"));
		System.out.println(sol.isMatch("aaa", "a"));
		System.out.println(sol.isMatch("aa", "*"));
		System.out.println(sol.isMatch("aa", "a*"));
		System.out.println(sol.isMatch("ab", "?*"));
		System.out.println(sol.isMatch("aab", "c*a*b"));
		System.out.println(sol.isMatch("aa", "*b"));
		System.out.println(sol.isMatch("c", "*?*"));
	}

	class Solution {
		boolean isMatch(String s, String p) {
			boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
			dp[0][0] = true;
			for (int j = 0; j < p.length(); j++) {
				if (dp[0][j] && p.charAt(j) == '*') {
					dp[0][j + 1] = true;
				}
			}
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < p.length(); j++) {
					if (p.charAt(j) == '*') {
						dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
					} else if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
						dp[i + 1][j + 1] = dp[i][j];
					}

				}
			}
			return dp[s.length()][p.length()];
		}
	}
}

// 思路：
// 1. 回溯算法，itmeout。2.
// 使用动态规划,设置一个二维数组，可以很快求出值，注意二维数组的大小位i+1,j+1，为什么最开始要循环一波，不是很懂。
