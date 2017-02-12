
public class Code45Jump {
	public static void main(String[] args) {
		Code45Jump code = new Code45Jump();
		Solution sol = code.new Solution();
		System.out.println(sol.jump(new int[]{2,3,1,1,4}));
	}

	class Solution {
		public int jump(int[] nums) {
			int jumps = 0, curEnd = 0, curFarthest = 0;
			for (int i = 0; i < nums.length - 1; i++) {
				curFarthest = Math.max(curFarthest, i + nums[i]);
				if (i == curEnd) {
					jumps++;
					curEnd = curFarthest;
				}
			}
			return jumps;
		}

	}

}

// 分析：又又又TLE了，唉

// The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest 
// point that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, then keep the above steps, as the following:

// 贪心算法，找到跳一步所能达到的最远一点，然后算作跳一步。
