import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code78Subsets {

	public static void main(String[] args) {
		Code78Subsets code = new Code78Subsets();
		Solution sol = code.new Solution();
		System.out.println(sol.subsets(new int[] { 1, 2, 3 }));
	}

	class Solution {
		public List<List<Integer>> subsets(int[] nums) {
			Arrays.sort(nums);
			List<List<Integer>> list = new ArrayList<>();
			backtrack(list, new ArrayList<Integer>(), nums, 0);
			return list;
		}

		public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
			list.add(new ArrayList<>(tempList));
			for (int i = start; i < nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}

// 分析: backtrack问题