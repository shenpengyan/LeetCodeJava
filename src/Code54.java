import java.util.ArrayList;
import java.util.List;

/**
 * 放值，转向
 * 
 * @author shenpengyan
 *
 */
public class Code54 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = new int[][] { { 2, 5 }, { 8, 4 }, { 0, -1 } };
        System.out.println(sol.spiralOrder(matrix));
    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<Integer>();
            if (matrix.length == 0 || matrix[0].length == 0) {
                return list;
            }
            int rowStart = 0;
            int rowEnd = matrix.length - 1;
            int colStart = 0;
            int colEnd = matrix[0].length - 1;
            while (true) {
                // 向右
                for (int i = colStart; i <= colEnd; i++) {
                    list.add(matrix[rowStart][i]);
                }
                rowStart++;
                if (rowStart > rowEnd || colStart > colEnd)
                    break;
                // 向下
                for (int i = rowStart; i <= rowEnd; i++) {
                    list.add(matrix[i][colEnd]);
                }
                colEnd--;
                if (rowStart > rowEnd || colStart > colEnd)
                    break;
                // 向左
                for (int i = colEnd; i >= colStart; i--) {
                    list.add(matrix[rowEnd][i]);
                }
                rowEnd--;
                if (rowStart > rowEnd || colStart > colEnd)
                    break;
                // 向上
                for (int i = rowEnd; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);
                }
                colStart++;
                if (rowStart > rowEnd || colStart > colEnd)
                    break;
            }
            
            return list;
        }
    }

}
