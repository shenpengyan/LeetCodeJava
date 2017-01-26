import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * what is ZigZang?
 * 
 * 
 *0	 	 	 	8	 	 	 	16	 	 	 
 *1	 	 	7	9	 	 	15	17	 	 	 
 *2	 	6	 	10	 	14	 	18	 	 	 
 *3	 5	 	 	11	13	 	 	19	 	 	 
 *4	 	 	 	12	 	 	 	20	 	 	 
 * 
 * link: https://leetcode.com/problems/zigzag-conversion/
 * 
 * @author shenpengyan
 *
 */
public class Code6 {
	public static void main(String[] args) {
		Code6 code = new Code6();
		Solution sol = code.new Solution();
		System.out.println(sol.convert("PAYPALISHIRING", 3));
		System.out.println(sol.convert("ABCD", 1));
	}

	class Solution {
		public String convert(String s, int numRows) {
			if (numRows == 1) {
				return s;
			}
			List[] lists = new List[numRows];
			for (int i = 0; i < lists.length; i++) {
				lists[i] = new ArrayList<Character>();
			}
			int mediumRow = (numRows - 1) / 2;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				lists[getRowNumber(i, numRows)].add(c);
			}
			StringBuilder rs = new StringBuilder();
			for (int i = 0; i < lists.length; i++) {
				for (int j = 0; j < lists[i].size(); j++) {
					rs.append(lists[i].get(j));
				}
			}
			return rs.toString();
		}

		public int getRowNumber(int i, int numRows) {
			int mod = (i + 1) % (2 * numRows - 2);
			if (mod > 0 && mod <= numRows) {
				return mod - 1;
			} else if (mod == 0) {
				return 1;
			} else {
				return 2 * numRows - 1 - mod;
			}
		}
	}
}
