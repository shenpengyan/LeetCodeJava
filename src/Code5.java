/**
 * 5. Longest Palindromic Substring
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example: Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 * 
 * link：https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * @author shenpengyan
 *
 */
public class Code5 {
	public static void main(String[] args) {
		Code5 code = new Code5();
		Solution sol = code.new Solution();
		System.out.println(sol.longestPalindrome("absdsbaba"));
	}

	/**
	 * From Top Solution 
	 * Example: "xxxbcbxxxxxa", (x is random character, not all x
	 * are equal) now we are dealing with the last character 'a'. The current
	 * longest palindrome is "bcb" with length 3.
	 * 1. check "xxxxa" so if it is
	 * palindrome we could get a new palindrome of length 5. 
	 * 2. check "xxxa" so
	 * if it is palindrome we could get a new palindrome of length 4. 
	 * 3. do NOT check "xxa" or any shorter string since the length of the new string is
	 * no bigger than current longest length. 
	 * 4. do NOT check "xxxxxa" or any longer string because if "xxxxxa" is palindrome then "xxxx" got from
	 * cutting off the head and tail is also palindrom. It has length > 3 which
	 * is impossible.'
	 * 
	 * @author shenpengyan
	 *
	 */
	class Solution {
		public String longestPalindrome(String s) {
			String res = "";
			int currLength = 0;
			for (int i = 0; i < s.length(); i++) {
				if (isPalindrome(s, i - currLength - 1, i)) {
					res = s.substring(i - currLength - 1, i + 1);
					currLength = currLength + 2;
				} else if (isPalindrome(s, i - currLength, i)) {
					res = s.substring(i - currLength, i + 1);
					currLength = currLength + 1;
				}
			}
			return res;
		}

		public boolean isPalindrome(String s, int begin, int end) {
			if (begin < 0)
				return false;
			while (begin < end) {
				if (s.charAt(begin++) != s.charAt(end--))
					return false;
			}
			return true;
		}
	}
}
