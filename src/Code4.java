/**
 * 4. Median of Two Sorted Arrays
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * @author shenpengyan
 * 
 * link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 */
public class Code4 {
	public static void main(String[] args) {
		Code4 code = new Code4();
		Solution sol = code.new Solution();
		int[] nums1 = new int[] { 1, 2 };
		int[] nums2 = new int[] { 3, 4 };
		System.out.println(sol.findMedianSortedArrays(nums1, nums2));
	}

	class Solution {
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int[] nums = new int[nums1.length + nums2.length];
			if (nums1.length == 0 && nums2.length == 0) {
				return 0;
			} else if (nums2.length == 0) {
				nums = nums1;
			} else if (nums1.length == 0) {
				nums = nums2;
			} else {
				int i1 = 0;
				int i2 = 0;
				int index = 0;
				boolean nums1End = false;
				boolean nums2End = false;
				while (true) {
					if (!nums1End && !nums2End) {
						if (nums1[i1] < nums2[i2]) {
							nums[index++] = nums1[i1];
							if (i1 == nums1.length - 1) {
								nums1End = true;
							} else {
								i1++;
							}
						} else {
							nums[index++] = nums2[i2];
							if (i2 == nums2.length - 1) {
								nums2End = true;
							} else {
								i2++;
							}
						}
					}
					else if(nums1End && !nums2End){
						nums[index++] = nums2[i2];

						if (i2 == nums2.length - 1) {
							nums2End = true;
						} else {
							i2++;
						}
					}
					else if(!nums1End && nums2End){
						nums[index++] = nums1[i1];

						if (i1 == nums1.length - 1) {
							nums1End = true;
						} else {
							i1++;
						}
					}
					else{
						break;
					}
					if (index > nums.length / 2) {
						break;
					}
					
				}
			}

			return nums.length % 2 == 1 ? nums[nums.length / 2]
					: (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
		}
	}

}
