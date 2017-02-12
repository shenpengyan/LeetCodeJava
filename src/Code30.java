import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 30. Substring with Concatenation of All Words
 * 
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * link： http://blog.csdn.net/hcbbt/article/details/44106103
 * 
 * @author shenpengyan
 *
 */
public class Code30 {
	public static void main(String[] args) {
		Code30 code = new Code30();
		Solution sol = code.new Solution();
		System.out.println(sol.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
	}

	// 太难了,看不懂
	class Solution {
		public List<Integer> findSubstring(String s, String[] words) {
			List<Integer> ret = new ArrayList<Integer>();
			int sLen = s.length();
			int lLen = words.length;
			if (sLen <= 0 || lLen <= 0) {
				return ret;
			}
			int wLen = words[0].length();

			// get the words's map
			HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();
			for (String word : words) {
				if (wordsMap.containsKey(word)) {
					wordsMap.put(word, wordsMap.get(word) + 1);
				} else {
					wordsMap.put(word, 1);
				}
			}

			for (int i = 0; i < wLen; i++) {
				int left = i, count = 0;
				HashMap<String, Integer> tmap = new HashMap<String, Integer>();

				for (int j = i; j <= sLen - wLen; j += wLen) {
					String str = s.substring(j, j + wLen);
					if (wordsMap.containsKey(str)) {
						if (tmap.containsKey(str)) {
							tmap.put(str, tmap.get(str) + 1);
						} else {
							tmap.put(str, 1);
						}

						if (tmap.get(str) <= wordsMap.get(str)) {
							count++;
						} else {
							while (tmap.get(str) > wordsMap.get(str)) {
								String tmps = s.substring(left, left + wLen);
								tmap.put(tmps, tmap.get(tmps) - 1);
								if (tmap.get(tmps) < wordsMap.get(tmps)) {
									count--;
								}
								left += wLen;
							}
						}

						// get the answer

						if (count == lLen) {
							ret.add(left);
							// it's better to push forward once
							String tmps = s.substring(left, left + wLen);
							tmap.put(tmps, tmap.get(tmps) - 1);
							count--;
							left += wLen;

						}
					} else {
						// not any match word
						tmap.clear();
						count = 0;
						left = j + wLen;
					}

				}
			}
			return ret;

		}

	}
}
