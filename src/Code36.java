import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku Determine if a Sudoku is valid
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable.
 * 
 * Only the filled cells need to be validated.
 * 
 * @author shenpengyan
 *
 */
public class Code36 {
	public static void main(String[] args) {
		Code36 code = new Code36();
		Solution sol = code.new Solution();
	}

	class Solution {
		public boolean isValidSudoku(char[][] board) {
			for (int i = 0; i < 9; i++) {
				if (!isParticallyValid(board, i, 0, i, 8))
					return false;
				if (!isParticallyValid(board, 0, i, 8, i))
					return false;
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (!isParticallyValid(board, i * 3, j * 3, i * 3 + 2, j * 3 + 2))
						return false;
				}
			}
			return true;
		}

		private boolean isParticallyValid(char[][] board, int x1, int y1, int x2, int y2) {
			Set singleSet = new HashSet();
			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					if (board[i][j] != '.')
						if (!singleSet.add(board[i][j]))
							return false;
				}
			}
			return true;
		}
	}
}

// 几个点：一个有效数独不是一定要解开，只要有数字的地方没错误即可；数独的大小一定是9 * 9，不需要考虑其他情况。数独需满足:横、竖，小方块，都是一到九。然后尽可能复用代码。
