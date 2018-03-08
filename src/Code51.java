import java.util.ArrayList;
import java.util.List;

public class Code51 {

    public static void main(String[] args) {
        Demo code = new Demo();
        Solution sol = new Solution();
    }

    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            if (n == 1) {
                char[][] matrix = new char[1][1];
                matrix[0][0] = 'Q';
                res.add(transfer2ArraysToStrList(matrix));
                matrix[0][0] = '.';
                res.add(transfer2ArraysToStrList(matrix));
            }
            for (int i = 2; i < n; i++) {
                for (List<String> list : res) {
                    char[][] matrix = transferStrListTo2ArraysAdd(list);
                    int x = i - 1;
                    for (int y = 0; y < matrix.length; y++) {
                        
                    }
                }
            }

            char[][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (check(matrix, i, j, n)) {

                    }
                }
            }
            return null;
        }

        public boolean check(char[][] matrix, int x, int y, int n) {
            if (x > 0) {
                if (y > 0) {
                    if (matrix[x - 1][y - 1] == 'Q') {
                        return false;
                    }
                }
                if (y < n - 1) {
                    if (matrix[x - 1][y + 1] == 'Q') {
                        return false;
                    }
                }
                if (matrix[x - 1][y] == 'Q') {
                    return false;
                }
            }
            if (y > 0) {
                if (matrix[x][y - 1] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        public List<String> transfer2ArraysToStrList(char[][] arrays) {
            List<String> list = new ArrayList<String>();
            for (char[] cs : arrays) {
                list.add(String.valueOf(arrays));
            }
            return list;
        }

        public char[][] transferStrListTo2ArraysAdd(List<String> list) {
            int n = list.size() + 1;
            char[][] arrays = new char[n][n];

            for (int i = 0; i < list.size(); i++) {
                char[] strArr = list.get(i).toCharArray();
                for (int j = 0; j < strArr.length; j++) {
                    arrays[i][j] = strArr[j];
                }
            }
            return arrays;
        }

    }
}
