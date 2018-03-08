public class Code121 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int minPrice = Integer.MAX_VALUE;
            for (int i : prices) {
                if (i < minPrice) {
                    minPrice = i;
                }
                if (i - minPrice > maxProfit) {
                    maxProfit = i - minPrice;
                }
            }
            return maxProfit;
        }
    }

}
