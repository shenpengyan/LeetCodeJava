import java.util.ArrayList;
import java.util.List;

/**
 * 42. Trapping Rain Water
 * 
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * link: https://leetcode.com/problems/trapping-rain-water/
 * 
 * @author shenpengyan
 *
 */
public class Code42Trap {

	public static void main(String[] args) {
		Code42Trap code = new Code42Trap();
		Solution sol = code.new Solution();
		System.out.println(sol.trap(new int[] { 5, 5, 1, 7, 1, 1, 5, 2, 7, 6 }));
	}

	class Solution {

		public int trap(int[] height) {
			List<Integer> list = new ArrayList<Integer>();
			int water = 0;
			int length = height.length;
			for (int i = 0; i < length; i++) {
				if ((i == 0 && i < length - 1 && height[i] >= height[i + 1])
						|| (i == length - 1 && i != 0 && height[i] >= height[i - 1])
						|| (i != length - 1 && i != 0 && height[i] >= height[i - 1] && height[i] >= height[i + 1])) {
					list.add(i);
					if (i < length - 1 && height[i] == height[i + 1])
						i++;
				}
			}
			if (list.size() < 2)
				return 0;
			int startListIndex = 0;

			while (true) {
				int endListIndex = getEnd(list, startListIndex, height);
				if (endListIndex != -1) {
					int min = Math.min(height[list.get(startListIndex)], height[list.get(endListIndex)]);

					for (int i = list.get(startListIndex) + 1; i < list.get(endListIndex); i++) {
						if (height[i] < min) {
							water += min - height[i];
						}
					}
					startListIndex = endListIndex;
				} else {
					break;
				}

			}
			return water;
		}

		public int getEnd(List<Integer> list, int startListIndex, int[] height) {
			int start = height[list.get(startListIndex)];
			if (startListIndex + 1 >= list.size()) {
				return -1;
			}
			int endListIndex = startListIndex + 1;
			int end = height[list.get(endListIndex)];
			for (int i = endListIndex; i < list.size(); i++) {
				if (height[list.get(i)] >= end) {
					end = height[list.get(i)];
					endListIndex = i;
					if (end >= start) {
						break;
					}
				}
			}
			return endListIndex;
		}
	}
}

// 分析：思路：先找到所有突出的点，即不小于左右两边的点，然后找到匹配的下一个突出的点，然后计算面积。不能找到一个突出的点就计算，因为下一个点可能更好。