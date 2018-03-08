/**
 * 
 * 697. Degree of an Array
 * 
 * 典型的拿空间换时间
 * @author shenpengyan
 *
 */
public class Code697 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findShortestSubArray(new int[] { 1,2,2,3,1 }));
    }

    static class Solution {

        public int findShortestSubArray(int[] nums) {
            int[] count = new int[50001];
            int[] startIndex = new int[50001];
            int[] endIndex = new int[50001];
            for (int i = 0; i < nums.length; i++) {
                if (count[nums[i]] == 0) {
                    startIndex[nums[i]] = i;
                }
                count[nums[i]]++;
                endIndex[nums[i]] = i;

            }
            int maxDegree = 0;
            int minLength = Integer.MAX_VALUE;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > maxDegree) {
                    maxDegree = count[i];
                    minLength = endIndex[i] - startIndex[i] + 1;
                }
                if (count[i] == maxDegree) {
                    minLength = Math.min(minLength, endIndex[i] - startIndex[i] + 1);
                }
            }
            return minLength;
        }
    }
}
