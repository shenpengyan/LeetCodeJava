import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 46. Permutations
 * 
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [ [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 * 
 * 
 * @author shenpengyan
 *
 */
public class Code46Permutations {

	public static void main(String[] args) {
		Code46Permutations code = new Code46Permutations();
		Solution sol = code.new Solution();
		System.out.println(sol.permute(new int[] { 1, 2, 3 }));
	}

	class Solution {
		public List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> list = new ArrayList<>();
			backtrack(list, new ArrayList<>(), nums);
			return list;
		}

		public void backtrack(List<List<Integer>> list, List<Integer> tempList, int nums[]) {
			if (tempList.size() == nums.length) {
				list.add(new ArrayList<>(tempList));
			}
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}

// 回溯算法