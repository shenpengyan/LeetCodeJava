/**
 * 28. Implement strStr()
 * 
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * @author shenpengyan
 *
 */
public class Code28 {
	public static void main(String[] args) {
		Code28 code = new Code28();
		Solution sol = code.new Solution();
		System.out.println(sol.strStr("abcd", "abc"));
	}

	class Solution {
		public int strStr(String haystack, String needle) {
			return haystack.indexOf(needle);
		}
	}
}
