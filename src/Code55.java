/**
 * 跳棋问题 思路，最大可达，关键是你要维持什么东西
 * 
 * @author shenpengyan
 *
 */
public class Code55 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canJump(new int[] { 2, 3, 1, 1, 4 }));
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > max)
                    return false;
                max = Math.max(nums[i] + i, max);
            }
            return true;
        }

    }

}
