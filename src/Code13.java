import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * link: https://leetcode.com/problems/roman-to-integer/
 * 
 * @author shenpengyan
 *
 */
public class Code13 {
	public static void main(String[] args) {
		Code13 code = new Code13();
		Solution sol = code.new Solution();
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

		public int romanToInt(String s) {
			int indexOfM, indexOfD, indexOfC, indexOfL, indexOfX, indexOfV = -1;
			int number = 0;
			indexOfM = s.lastIndexOf("M");
			indexOfD = s.lastIndexOf("D");
			indexOfC = s.lastIndexOf("C");
			indexOfL = s.lastIndexOf("L");
			indexOfX = s.lastIndexOf("X");
			indexOfV = s.lastIndexOf("V");

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				switch (c) {
				case 'M':
					number += 1000;
					break;
				case 'C':
					if(i < indexOfM || i < indexOfD)
						number -= 100;
					else
						number += 100;
					break;
				case 'D':
					number += 500;
					break;
				case 'X':
					if(i < indexOfC || i< indexOfL)
						number -= 10;
					else
						number += 10;
					break;
				case 'L':
					number += 50;
					break;
				case 'I':
					if(i < indexOfX || i< indexOfV)
						number -= 1;
					else
						number += 1;
					break;
				case 'V':
					number += 5;
					break;
				default:
					break;
				}
			}
			return number;
			
		}
	}
}
