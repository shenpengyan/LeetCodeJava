import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 15. 3Sum
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * @author shenpengyan
 *
 *         link: https://leetcode.com/problems/3sum/
 */
public class Code15 {
	public static void main(String[] args) {
		Code15 code = new Code15();
		Solution sol = code.new Solution();
		System.out.println(sol.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}

	class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			Arrays.sort(nums);
			for (int i = 0; i + 2 < nums.length; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				int j = i + 1, k = nums.length - 1;
				int target = -nums[i];
				while (j < k) {
					if (nums[j] + nums[k] == target) {
						res.add(Arrays.asList(new Integer[] { nums[i], nums[j], nums[k] }));
						j++;
						k--;
						while (j < k && nums[j] == nums[j - 1])
							j++;
						while (j < k && nums[k] == nums[k + 1])
							k--;
					} else if (nums[j] + nums[k] > target) {
						k--;
					} else {
						j++;
					}
				}

			}
			return res;
		}
	}
}
