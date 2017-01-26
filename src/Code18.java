import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * 
 * link: https://leetcode.com/problems/4sum/
 * 
 * @author shenpengyan
 *
 */
public class Code18 {
	public static void main(String[] args) {
		Code18 code = new Code18();
		Solution sol = code.new Solution();
		System.out.println(sol.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
	}

	class Solution {
		public List<List<Integer>> fourSum(int[] nums, int target) {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			Arrays.sort(nums);
			for (int i = 0; i + 3 < nums.length; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				for (int m = i + 1; m + 2 < nums.length; m++) {
					int j = m + 1, k = nums.length - 1;
					int targetT = target - nums[i] - nums[m];
					while (j < k) {
						if (nums[j] + nums[k] == targetT) {
							List list = Arrays.asList(new Integer[] { nums[i], nums[m], nums[j], nums[k] });
							if (!res.contains(list)) {
								res.add(list);
							}
							j++;
							k--;
							while (j < k && nums[j] == nums[j - 1])
								j++;
							while (j < k && nums[k] == nums[k + 1])
								k--;
						} else if (nums[j] + nums[k] > targetT) {
							k--;
						} else {
							j++;
						}
					}

				}

			}
			return res;
		}
	}
}
