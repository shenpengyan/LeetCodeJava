/**
 * 7.Reverse Integer
 * 
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * @author shenpengyan
 *
 */
public class Code7 {

	public static void main(String[] args) {
		Code7 code = new Code7();
		Solution sol = code.new Solution();
		System.out.println(sol.reverse(102));
	}

	/**
	 * Top Solutions
	 * 
	 * 注意数字越界问题
	 * 
	 * @author shenpengyan
	 *
	 */
	class Solution {
		public int reverse(int x) {
			int result = 0;

			while (x != 0) {
				int tail = x % 10;
				int newResult = result * 10 + tail;
				if ((newResult - tail) / 10 != result) {
					return 0;
				}
				result = newResult;
				x = x / 10;
			}

			return result;
		}
	}
}
