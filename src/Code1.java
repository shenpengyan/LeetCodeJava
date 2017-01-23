import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1. Two Sum
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution.
 * 
 * link: https://leetcode.com/problems/two-sum/
 * 
 * @author shenpengyan
 *
 */

public class Code1 {
	public static void main(String[] args) {
		Code1 code = new Code1();
		Solution sol = code.new Solution();
		int[]resInts = sol.twoSum(new int[] { 1, 5, 4 }, 5);
		for (int i : resInts) {
			System.out.println(i);
		}
	}

	class Solution {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++) {
				if (numMap.containsKey(target - nums[i])) {
					return new int[] { numMap.get(target - nums[i]), i };
				} else {
					numMap.put(nums[i], i);
				}
			}
			return null;
		}
	}
}
