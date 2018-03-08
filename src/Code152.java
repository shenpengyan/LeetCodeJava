import javax.print.attribute.standard.NumberUpSupported;

/**
 * 152. Maximum Product Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 * 
 * 置最大和最小的标志位，乘机是连续的，要不然前面的都要，要不然前面的都不要。如果有0，前面的全部舍弃。
 * 
 * @author shenpengyan
 *
 */
public class Code152 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(new int[] { -2,0,-1 }));
    }

    static class Solution {
        public int maxProduct(int[] nums) {
            int max = nums[0];
            int min = nums[0];
            int maxPre = nums[0];
            int minPre = nums[0];
            int tmpMaxPre;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] == 0) {
                    maxPre = 1;
                    minPre = 1;
                    max = Math.max(max, 0);
                    min = Math.min(min, 0);
                }
                else
                {
                    max = Math.max(max, Math.max(Math.max(minPre * nums[i], nums[i]), maxPre * nums[i]));
                    min = Math.min(min, Math.min(Math.min(maxPre * nums[i], nums[i]), minPre * nums[i]));
                    tmpMaxPre = Math.max(Math.max(minPre * nums[i], nums[i]), maxPre * nums[i]);
                    minPre = Math.min(Math.min(maxPre * nums[i], nums[i]), minPre * nums[i]);
                    maxPre = tmpMaxPre;
                }
            }
            return max;
        }
    }

}
