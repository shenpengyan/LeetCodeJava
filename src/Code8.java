/**
 * 
 * 8. String to Integer (atoi)
 * 
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * link：https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * @author shenpengyan
 *
 */
public class Code8 {
	public static void main(String[] args) {
		Code8 code = new Code8();
		Solution sol = code.new Solution();
		System.out.println(sol.myAtoi("  - 010"));
	}

	/**
	 * Top Solusion 这道题不难，但是麻烦，各种异常情况。
	 * 
	 * 
	 * 
	 * @author shenpengyan
	 *
	 */
	class Solution {
		public int myAtoi(String str) {
			if (str == null || str.length() == 0)
				return 0;//
			str = str.trim();
			char firstChar = str.charAt(0);
			int sign = 1, start = 0, len = str.length();
			long sum = 0;
			if (firstChar == '+') {
				sign = 1;
				start++;
			} else if (firstChar == '-') {
				sign = -1;
				start++;
			}
			for (int i = start; i < len; i++) {
				if (!Character.isDigit(str.charAt(i)))
					return (int) sum * sign;
				sum = sum * 10 + str.charAt(i) - '0';
				if (sign == 1 && sum > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			}

			return (int) sum * sign;
		}
	}
}
