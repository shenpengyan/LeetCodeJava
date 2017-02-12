/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * @author shenpengyan
 *
 */
public class Code35 {
	public static void main(String[] args) {
		Code35 code = new Code35();
		Solution sol = code.new Solution();
		int[] nums = new int[]{1,3,5,6};
		System.out.println(sol.searchInsert(nums, 5));
		System.out.println(sol.searchInsert(nums, 2));
		System.out.println(sol.searchInsert(nums, 7));
		System.out.println(sol.searchInsert(nums, 0));
	}

	class Solution {
		public int searchInsert(int[] nums, int target) {
			int start = 0, end = nums.length - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (nums[mid] == target) {
					return mid;
				}
				else if (nums[mid] < target) {
					if (mid == nums.length - 1) {
						return nums.length;
					} else if (nums[mid + 1] > target) {
						return mid + 1;
					}
					start = mid + 1;
				} else {
					if (mid == 0){
						return 0;
					}
					end = mid - 1;
				}
			}
			return -1;
		}
	}

}

//分析：还是二分查找，处理好边界情况即可。