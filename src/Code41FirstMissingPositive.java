/**
 * 41. First Missing Positive
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * link: https://leetcode.com/problems/first-missing-positive/
 * 
 * @author shenpengyan
 *
 */
public class Code41FirstMissingPositive {
	public static void main(String[] args) {
		Code41FirstMissingPositive code = new Code41FirstMissingPositive();
		Solution sol = code.new Solution();
		int i = 0;
		int j = 1;
		System.out.println(sol.firstMissingPositive(new int[] { 1, 1 }));
	}

	public class Solution {
		public int firstMissingPositive(int[] nums) {
			int length = nums.length;
			int i = 0;
			while (i < length) {
				if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= length) {
					int j = nums[i];
					if (nums[i] != nums[j - 1]) {
						nums[i] = nums[i] ^ nums[j - 1];
						nums[j - 1] = nums[i] ^ nums[j - 1];
						nums[i] = nums[i] ^ nums[j - 1];
					} else {
						i++;
					}
				} else {
					i++;
				}
			}
			for (int j = 0; j < length; j++) {
				if (nums[j] != j + 1) {
					return j + 1;
				}
			}
			return length + 1;
		}

	}
}

// 分析：这道题题意比较难以理解，意思是寻找第一个缺失的正数，而且常量空间，O(n)时间复杂度。那么，不能另开数组，只有在当前数组里面做文章，
// 那么就把数字i放到第i个数组index上，第一个没放上去的就是错的。怎么放呢，用swap，只要nums[i] !=
// i+1,就让把第i位和nums[i]-1位做交换。
// 那么为什么时间复杂度可以保证O(n)呢，因为每交换一次，有一个元素一定会变好，所以是O(n).
