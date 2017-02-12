import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses Given n pairs of parentheses, write a function to
 * generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * link: https://leetcode.com/problems/generate-parentheses/
 * 
 * @author shenpengyan
 *
 */
public class Code22 {
	public static void main(String[] args) {
		Code22 code = new Code22();
		Solution sol = code.new Solution();
	}

	class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> list = new ArrayList<String>();
			generateOneByOne("", list, n, n);
			return list;
		}

		public void generateOneByOne(String sublist, List<String> list, int left, int right) {
			if (left > right) {
				return;
			}
			if (left > 0) {
				generateOneByOne(sublist + "(", list, left - 1, right);
			}
			if (right > 0) {
				generateOneByOne(sublist + ")", list, left, right - 1);
			}
			if (left == 0 && right == 0) {
				list.add(sublist);
				return;
			}
		}
	}
}
