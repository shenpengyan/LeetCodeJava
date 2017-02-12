/**
 * 33. Search in Rotated Sorted Array
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * @author shenpengyan
 *
 */
public class Code33 {
	public static void main(String[] args) {
		Code33 code = new Code33();
		Solution sol = code.new Solution();
		BinarySearchSolution bss = code.new BinarySearchSolution();
		int [] array = new int[100000001];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		long startTime = System.currentTimeMillis();
//		for (int i = 0; i < 100; i++) {
//			sol.search(array, 1000000001);
//		}
		System.out.println(sol.search(array, 1000000001));
		System.out.println(System.currentTimeMillis() - startTime);
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			bss.search(array, 1000000001);
		}
		System.out.println(bss.search(array, 1000000001));
		System.out.println(System.currentTimeMillis() - startTime);
	}

	class Solution {
		public int search(int[] nums, int target) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == target) {
					return i;
				}
			}
			return -1;
		}
	}
	
	class BinarySearchSolution {
		public int search(int[] nums, int target) {
			int start = 0, end = nums.length - 1;
			while ( start <= end){
				int mid = (start + end) / 2;
				if(nums[mid] == target){
					return mid;
				}
				
				if(nums[start] <= nums[mid]){
					if (target < nums[mid] && target >= nums[start])
						end = mid - 1;
					else
						start = mid + 1;
				}
				
				if(nums[mid] <= nums[end]){
					if(target > nums[mid] && target <= nums[end])
						start = mid + 1;
					else
						end = mid - 1;
				}
			}
			return -1;
		}
	}
}


//分析：这道题虽然说要搜索一个翻转的有序数组，但是直接顺序搜索，就可以AC了。二分查找应该更好一点。如 6 7 1 2 3 4 5，它虽然在某个点被翻转了，但是一定有一半是有序的，到这一半中去判断。这才是这道题的魅力所在。
//
//虽然在leetcode上，直接搜索比二分搜素运行时间短，但是在数据很大的时候，明星二分搜素用时更少。


