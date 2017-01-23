/**
 * 231. Power of Two
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author shenpengyan
 *
 */
public class Code231 {

	public static void main(String[] args) {
		Code231 code = new Code231();
		Solution sol = code.new Solution();
		System.out.println(sol.isPowerOfTwo(4));
	}

	class Solution {
		public boolean isPowerOfTwo(int n) {
			return n > 0 && (n & (n - 1)) == 0;
		}
	}

}
