import java.util.Arrays;

/**
 * 31. Next Permutation
 * 
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
 * 1,2,3 1,1,5 → 1,5,1
 * 
 * link: https://leetcode.com/problems/next-permutation/
 * 
 * @author shenpengyan
 *
 */
public class Code31 {
	public static void main(String[] args) {
		Code31 code = new Code31();
		Solution sol = code.new Solution();
		sol.nextPermutation(new int[] { 1, 2, 3 });
	}

	class Solution {
		public void nextPermutation(int[] nums) {
			int index = -1;
			for (int i = nums.length - 1; i >= 1; i--) {
				if (nums[i] > nums[i - 1]) {
					index = i;
					int swapi = i - 1;
					for (int j = nums.length - 1; j > swapi; j--) {
						if (nums[j] > nums[swapi]) {
							nums[j] = nums[j] ^ nums[swapi];
							nums[swapi] = nums[j] ^ nums[swapi];
							nums[j] = nums[j] ^ nums[swapi];
							break;
						}
					}
					break;
				}
			}
			if (index == -1) {
				index = 0;
			}
			Arrays.sort(nums, index, nums.length);
			System.out.println();
		}

	}
}
