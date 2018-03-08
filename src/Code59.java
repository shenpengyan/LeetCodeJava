
public class Code59 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = sol.generateMatrix(0);
    }

    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            if (n == 0) {
                return matrix;
            }
            int num = 1;
            int rowStart = 0;
            int rowEnd = n - 1;
            int colStart = 0;
            int colEnd = n - 1;
            while (true) {
                // 向右
                for (int i = colStart; i <= colEnd; i++) {
                    matrix[rowStart][i] = num++;
                }
                rowStart++;
                if (rowStart > rowEnd || colStart > colEnd)
                    break;
                // 向下
                for (int i = rowStart; i <= rowEnd; i++) {
                    matrix[i][colEnd] = num++;
                }
                colEnd--;
                if (rowStart > rowEnd || colStart > colEnd)
                    break;
                // 向左
                for (int i = colEnd; i >= colStart; i--) {
                    matrix[rowEnd][i] = num++;
                }
                rowEnd--;
                if (rowStart > rowEnd || colStart > colEnd)
                    break;
                // 向上
                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = num++;
                }
                colStart++;
                if (rowStart > rowEnd || colStart > colEnd)
                    break;
            }
            return matrix;
        }
    }
}
