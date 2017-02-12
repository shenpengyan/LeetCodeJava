import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code90Subset2 {

	public static void main(String[] args) {
		Code90Subset2 code = new Code90Subset2();
		Solution sol = code.new Solution();
		System.out.println(sol.subsetsWithDup(new int[] { 1, 2, 2 }));
	}

	class Solution {
		public List<List<Integer>> subsetsWithDup(int[] nums) {
			Arrays.sort(nums);
			List<List<Integer>> list = new ArrayList<>();
			backtrack(list, new ArrayList<Integer>(), nums, 0);
			return list;
		}

		public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
			list.add(new ArrayList<>(tempList));
			for (int i = start; i < nums.length; i++) {
				if(i > start && nums[i] == nums[i-1]) continue;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}

// backtrack问题