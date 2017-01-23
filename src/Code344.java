/**
 * 344. Reverse String
 * 
 * Write a function that takes a string as input and returns the string
 * reversed.
 *
 * Example: Given s = "hello", return "olleh".
 *
 * @author shenpengyan
 *
 */
public class Code344 {
	public static void main(String[] args) {
		Code344 code = new Code344();
		Solution sol = code.new Solution();
		System.out.println(sol.reverseString("absad"));
	}

	class Solution {
		public String reverseString(String s) {
			char[] cs = s.toCharArray();
			int start = 0;
			int end = s.length() - 1;
			while (start < end) {
				cs[start] = (char) (cs[start] ^ cs[end]);
				cs[end] = (char) (cs[start] ^ cs[end]);
				cs[start] = (char) (cs[start] ^ cs[end]);
				start++;
				end--;
			}
			return new String(cs);
		}
	}
}


/**
 * 核心思想：通过位运算互换字符
 * 
 **/
