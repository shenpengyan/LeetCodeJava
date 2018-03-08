import java.util.ArrayList;
import java.util.List;

public class Code448 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
    }

    static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                list.add(i + 1);
            }
            for (int i : nums) {
                list.remove(Integer.valueOf(i));
            }
            return list;
        }
    }

}
