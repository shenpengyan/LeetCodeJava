/**
 * 43. Multiply Strings
 * 
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 110. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
 * not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 * 
 * link: https://leetcode.com/problems/multiply-strings/
 * 
 * @author shenpengyan
 *
 */
public class Code43Multiply {

	public static void main(String[] args) {
		Code43Multiply code = new Code43Multiply();
		Solution sol = code.new Solution();
		System.out.println(sol.multiply("9133", "0"));
	}

	class Solution {
		public String multiply(String num1, String num2) {
			if (num1 == null || num2 == null) {
				return null;
			}
			if (num1 == "" || num2 == "") {
				return "";
			}
			if (num1.equals("0") || num2.equals("0")) {
				return "0";
			}

			String resNum1 = reverse(num1);
			String resNum2 = reverse(num2);

			char[] cs1 = resNum1.toCharArray();
			char[] cs2 = resNum2.toCharArray();

			// 定义结果集
			StringBuffer ret = new StringBuffer();
			// 保存进位
			int carry = 0;

			for (int i = 0; i < cs1.length; i++) {
				for (int j = 0; j < cs2.length; j++) {
					// 当前位
					int pos = i + j;
					int temp = (cs1[i] - '0') * (cs2[j] - '0') + carry;
					if (pos < ret.length()) {
						temp = temp + (ret.charAt(pos) - '0');
						ret.setCharAt(pos, (char) (temp % 10 + '0'));
					} else {
						ret.append((char) (temp % 10 + '0'));
					}
					// 计算下一个进位
					carry = temp / 10;
				}
				if (carry > 0) {
					ret.append((char) (carry + '0'));
					carry = 0;
				}
			}
			return reverse(ret.toString());
		}

		public String reverse(String str) {
			String rst = "";
			char[] cs = str.toCharArray();
			for (char c : cs) {
				rst = c + rst;
			}
			return rst;
		}
	}

}

// 思路：按照笔算乘法的原则，由于笔算是从低位往高位计算，所以我们需要先reverse字符串，计算完结果后再reverse回来。注意进位的特殊处理