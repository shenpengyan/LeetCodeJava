import java.util.Arrays;

/**
 * 34. Search for a Range 
 * 
 * Given an array of integers sorted in ascending order,
 * find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * link: https://leetcode.com/problems/search-for-a-range/
 * 
 * @author shenpengyan
 *
 */
public class Code34 {
	public static void main(String[] args) {
		Code34 code = new Code34();
		Solution sol = code.new Solution();
		System.out.println(Arrays.toString(sol.searchRange(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(sol.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
	}

	class Solution {
		public int[] searchRange(int[] nums, int target) {
			int bs = binarySearch(nums, target);
			if (bs == -1)
				return new int[] { -1, -1 };
			int start = bs, end = bs;
			while (start > 0 && nums[start - 1] == target) {
				start--;
			}
			while (end < nums.length - 1 && nums[end + 1] == target) {
				end++;
			}

			return new int[] { start, end };
		}

		public int binarySearch(int[] nums, int target) {
			int start = 0, end = nums.length - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (nums[mid] == target) {
					return mid;
				}

				else if (nums[mid] < target)
					start = mid + 1;
				else
					end = mid - 1;
			}
			return -1;
		}
	}
}

// 分析： 查找一个数字的范围区间，只要先二分查找找到这个数字，然后再向前和向后搜索，直到不等于为止即可。
