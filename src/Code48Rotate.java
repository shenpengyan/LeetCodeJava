/**
 * 48. Rotate Image
 * 
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * link: https://leetcode.com/problems/rotate-image/
 * 
 * @author shenpengyan
 *
 */
public class Code48Rotate {
	public static void main(String[] args) {
		Code48Rotate code = new Code48Rotate();
		Solution sol = code.new Solution();
	}

	class Solution {
		public void rotate(int[][] matrix) {
			int size = matrix.length;
			int temp = 0;
			for (int i = 0; i < size; i++) { // 转置
				for (int j = i + 1; j < size; j++) {
					temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}

			for (int i = 0; i < size / 2; i++) { // 对称变换
				for (int j = 0; j < size; j++) {
					temp = matrix[j][i];
					matrix[j][i] = matrix[j][size - i - 1];
					matrix[j][size - i - 1] = temp;
				}
			}
		}
	}
}

// 思路：顺时针旋转二维数组90度，通过画图可知，A[i][j] ->
// A[j][n-1-i],详情:https://yq.aliyun.com/articles/3878
