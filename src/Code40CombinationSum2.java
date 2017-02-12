import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [10, 1, 2, 7, 6, 1, 5] and target 8, A solution set is: [ [1, 7], [1, 2, 5],
 * [2, 6], [1, 1, 6] ]
 * 
 * link: https://leetcode.com/problems/combination-sum-ii/ 
 * 
 * @author shenpengyan
 *
 */

public class Code40CombinationSum2 {
	public static void main(String[] args) {
		Code40CombinationSum2 code = new Code40CombinationSum2();
		Solution sol = code.new Solution();
		System.out.println(sol.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
	}

	class Solution {
		public List<List<Integer>> combinationSum2(int[] candidates, int target) {
			List<List<Integer>> list = new ArrayList<>();
			Arrays.sort(candidates);
			backtrack(list, new ArrayList<>(), candidates, target, 0);
			return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
			if (remain < 0)
				return;
			else if (remain == 0)
				list.add(new ArrayList<>(tempList));
			else {
				for (int i = start; i < nums.length; i++) {
					if (i > start && nums[i] == nums[i - 1])
						continue; // skip duplicates
					tempList.add(nums[i]);
					backtrack(list, tempList, nums, remain - nums[i], i + 1); 
					tempList.remove(tempList.size() - 1); // 回溯最重要的去除痕迹
				}
			}
		}

	}

}
