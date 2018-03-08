/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * 两个点：记录最终结果，抓住变化因子：前一个值为负数且当前值大于前一值，没有继续累加的必要，从当前值开始累加即可。
 * 
 * @author shenpengyan
 *
 */
public class Code53 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxSubArray(new int[] { -2, -1 }));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (sum < 0 && nums[i] > sum) {
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
                if (sum > max) {
                    max = sum;
                }
            }
            return max;
        }

    }
}
