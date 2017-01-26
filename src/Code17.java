import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * 
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/ 
 * 
 * @author shenpengyan
 *
 */
public class Code17 {
	public static void main(String[] args) {
		Code17 code = new Code17();
		Solution sol = code.new Solution();
		System.out.println(sol.letterCombinations("23"));
	}

	class Solution {
		public List<String> letterCombinations(String digits) {
			LinkedList<String> ans = new LinkedList<String>();
			String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
			if (digits == null || digits.equals(""))
				return ans;
			ans.add("");
			for (int i = 0; i < digits.length(); i++) {
				int x = Character.getNumericValue(digits.charAt(i));
				while (ans.peek().length() == i) {
					String t = ans.remove();
					for (char s : mapping[x].toCharArray())
						ans.add(t + s);
				}
			}
			return ans;
		}
	}

	public class MyBadSolution {
		public List<String> letterCombinations(String digits) {
			Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
			map.put('2', Arrays.asList(new Character[] { 'a', 'b', 'c' }));
			map.put('3', Arrays.asList(new Character[] { 'd', 'e', 'f' }));
			map.put('4', Arrays.asList(new Character[] { 'g', 'h', 'i' }));
			map.put('5', Arrays.asList(new Character[] { 'j', 'k', 'l' }));
			map.put('6', Arrays.asList(new Character[] { 'm', 'n', 'o' }));
			map.put('7', Arrays.asList(new Character[] { 'p', 'q', 'r', 's' }));
			map.put('8', Arrays.asList(new Character[] { 't', 'u', 'v' }));
			map.put('9', Arrays.asList(new Character[] { 'w', 'x', 'y', 'z' }));
			List<String> res = new ArrayList<String>();
			for (int i = 0; i < digits.length(); i++) {
				List<Character> charlist = map.get(digits.charAt(i));
				if (i == 0) {
					for (int j = 0; j < charlist.size(); j++) {
						res.add("" + charlist.get(j));
					}

				} else {
					List<String> tempRes = new ArrayList<>(res);
					for (String str : tempRes) {
						res.remove(str);
						for (int j = 0; j < charlist.size(); j++) {
							res.add(str + charlist.get(j));
						}
					}
				}

			}
			return res;

		}
	}
}
