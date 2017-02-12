import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or
 * equal to m + n) to hold additional elements from nums2. The number of
 * elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * link: https://leetcode.com/problems/merge-sorted-array/
 * 
 * @author shenpengyan
 *
 */
public class Code88Merge {

	public static void main(String[] args) {
		Code88Merge code = new Code88Merge();
		Solution sol = code.new Solution();
		int[] nums1 = new int[3];
		nums1[0] = 1;
		int[] nums2 = new int[0];
		sol.merge(nums1, 1, nums2, 0);
		System.out.println(Arrays.toString(nums1));
	}

	class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			for (int i = m + n - 1; i >= 0; i--) {
				if (m > 0 && n > 0) {
					if (nums1[m - 1] > nums2[n - 1]) {
						nums1[i] = nums1[m - 1];
						m--;
					} else {
						nums1[i] = nums2[n - 1];
						n--;
					}
				} else {
					if (m > 0) {
						nums1[i] = nums1[m - 1];
						m--;
					} else {
						nums1[i] = nums2[n - 1];
						n--;
					}
				}
			}
		}
	}
}

// 分析：两点法，找到两个关键点，两个数组的最后一位，然后进行循环即可。