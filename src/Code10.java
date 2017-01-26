/**
 * 10. Regular Expression Matching
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples: 
 * isMatch("aa","a") → false 
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false 
 * isMatch("aa", "a*") → true 
 * isMatch("aa", ".*") → true 
 * isMatch("ab", ".*") → true 
 * isMatch("aab", "c*a*b") → true
 * 
 * link：https://leetcode.com/problems/regular-expression-matching/
 * 
 * @author shenpengyan
 *
 */
public class Code10 {
	public static void main(String[] args) {
		Code10 code = new Code10();
		Solution sol = code.new Solution();
		System.out.println(sol.isMatch("aa", "a*"));
		
	}

	/**
	 * java直接有类库处理正则表达式的问题。。。。
	 * @author shenpengyan
	 *
	 */
	class Solution {
		public boolean isMatch(String s, String p) {
			return s.matches(p);
		}
	}
}
