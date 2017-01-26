import java.util.ArrayList;
import java.util.List;

/**
 * 12. Integer to Roman
 * 
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * link: https://leetcode.com/problems/integer-to-roman/
 * 
 * @author shenpengyan
 *
 */
public class Code12 {

	public static void main(String[] args) {
		Code12 code = new Code12();
		Solution sol = code.new Solution();
		System.out.println(sol.intToRoman(3009));
	}

	/**
	 * 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	 * 
	 * 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	 * 
	 * 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	 * 
	 * 1000~3000: {"M", "MM", "MMM"}.
	 * 
	 * 
	 * @author shenpengyan
	 *
	 */
	class Solution {
		public String intToRoman(int num) {
			int[] bits = new int[4];
			String[] bs = new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XX", "XXX", "XL",
					"L", "LX", "LXX", "LXXX", "XC", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M", "MM",
					"MMM" };
			String str = "";
			for (int i = 0; i < 4; i++) {
				bits[i] = num % 10;
				num /= 10;
				if(bits[i]!= 0){
					str = bs[i * 9 + bits[i] - 1] + str;
				}
			}
			return str;
		}
	}
}
