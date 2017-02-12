import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 47. Permutations II
 * 
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [ [1,1,2],
 * [1,2,1], [2,1,1] ]
 * 
 * 
 * @author shenpengyan
 *
 */
public class Code47PermuteUnique {

	public static void main(String[] args){
		Code47PermuteUnique code = new Code47PermuteUnique();
		Solution sol = code.new Solution();
		System.out.println(sol.permuteUnique(new int[]{1,1,2}));
	}
	
	
	class Solution{
	    
		public List<List<Integer>> permuteUnique(int[] nums) {
			List<List<Integer>> list = new ArrayList<>();
			Arrays.sort(nums);
			backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
			return list;
		}

		public void backtrack(List<List<Integer>> list, List<Integer> tempList, int nums[], boolean[] used) {
			if(tempList.size() == nums.length){
				list.add(new ArrayList<>(tempList));
			}
			for (int i = 0; i < nums.length; i++) {
				if(used[i] || (i > 0 && nums[i] == nums[i - 1] && used[i - 1])) continue;
				tempList.add(nums[i]);
				used[i] = true;
				backtrack(list, tempList, nums, used);
				tempList.remove(tempList.size() - 1);
				used[i] = false;
			}
		}

	}
}

// 使用回溯算法，因为要记录这个index有没有被使用，所以增加一个数组boolean[] used, 如果被使用，或者这个与前一个相同，前一个已经使用了，则跳过