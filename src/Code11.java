import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * 11. Container With Most Water
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 *
 * link: https://leetcode.com/problems/container-with-most-water/
 * 
 * @author shenpengyan
 *
 */
public class Code11 {
	public static void main(String[] args) {
		Code11 code = new Code11();
		Solution sol = code.new Solution();
		System.out.println(sol.maxArea(new int[] { 2, 9, 9, 8, 2 }));
	}

	class Solution {
		public int maxArea(int[] height) {
			int left = 0, right = height.length - 1, maxArea = 0;
			while (left < right) {
				maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
				if (height[left] < height[right]) {
					left++;
				} else {
					right--;
				}
			}
			return maxArea;
		}

	}
}
