/**
 * 9. Palindrome Number
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * link: https://leetcode.com/problems/palindrome-number/
 * 
 * @author shenpengyan
 *
 */
public class Code9 {
	public static void main(String[] args) {
		Code9 code = new Code9();
		Solution sol = code.new Solution();
		System.out.println(sol.isPalindrome(123321));
		
	}

	class Solution {
		public boolean isPalindrome(int x) {
			if(x < 0) return false;
			int xs = x;
			int px = 0;
			while(x > 0){
				px = px * 10 + x % 10;
				x = x / 10;
			}
			return xs == px;
		}
		
	}
}
