import java.util.Arrays;

/**
 * 16. 3Sum Closest 
 * 
 * Given an array S of n integers, find three integers in S
 * such that the sum is closest to a given number, target. Return the sum of the
 * three integers. You may assume that each input would have exactly one
 * solution.
 * 
 * link: https://leetcode.com/problems/3sum-closest/
 * 
 * @author shenpengyan
 *
 */
public class Code16 {
	public static void main(String[] args) {
		Code16 code = new Code16();
		Solution sol = code.new Solution();
		System.out.println(sol.threeSumClosest(new int[]{0,2,1,-3}, 1));
	}

	class Solution {
		public int threeSumClosest(int[] nums, int target) {
			Arrays.sort(nums);
			int resSum = nums[0] + nums[1] + nums[2];
			int gap = Math.abs(resSum - target);
			for (int i = 0; i + 2 < nums.length; i++) {
				int j = i + 1, k = nums.length - 1;
				
				while(j < k){
					int temp = nums[i] + nums[j]+ nums[k];
					int tempGap = Math.abs(temp - target);
					if(tempGap == 0){
						return temp;
					}
					if(tempGap < gap){
						resSum = temp;
						gap = tempGap;
						System.out.println(resSum);
						while(j+1 < k && nums[j] == nums[j+1]) j++;
						while(j < k-1 && nums[k] == nums[k-1]) k--;
					}
					if(temp - target < 0){
						j++;
					}
					else{
						k--;
					}
				}
			}
			return resSum;
		}

	}
}
