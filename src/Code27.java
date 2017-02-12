import java.util.ArrayList;
import java.util.Arrays;

public class Code27 {
	public static void main(String[] args) {
		Code27 code = new Code27();
		Solution sol = code.new Solution();
		System.out.println(sol.removeElement(new int[] { 2, 2, 3 }, 3));
	}

	class Solution {
		public int removeElement(int[] nums, int val) {
			int m = 0;
			for (int i = 0; i < nums.length; ++i) {
				if(nums[i] != val){
					nums[m] = nums[i];
					m++;
				}
			}
			return m;
		}
	}
}
