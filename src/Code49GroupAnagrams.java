import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 49. Group Anagrams
 * 
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
 * 
 * [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]
 * 
 * link： https://leetcode.com/problems/anagrams/
 * 
 * @author shenpengyan
 *
 */
public class Code49GroupAnagrams {
	public static void main(String[] args) {
		Code49GroupAnagrams code = new Code49GroupAnagrams();
		Solution sol = code.new Solution();
		System.out.println(sol.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
	}

	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> map = new HashMap<>();
			List<String> list = new ArrayList<>();
			for (String string : strs) {
				char[] cs = string.toCharArray();
				Arrays.sort(cs);
				String cst = new String(cs);
				if (map.containsKey(cst)) {
					list = map.get(cst);
				} else {
					list = new ArrayList<>();
				}
				list.add(string);
				map.put(cst, list);
			}
			return new ArrayList<>(map.values());
		}
	}
}

// 思路：看相同的字母个数，然后把相同的放在一起，一个简单的办法是，字符排序，然后把字符串作为map的key.