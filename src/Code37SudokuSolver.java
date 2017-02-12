/**
 * 37. Sudoku Solver
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 * link: https://leetcode.com/problems/sudoku-solver/
 * 
 * @author shenpengyan
 *
 */
public class Code37SudokuSolver {
	public static void main(String[] args){
		Code37SudokuSolver code = new Code37SudokuSolver();
		Solution sol = code.new Solution();
	}
	
	
	class Solution{
	    public void solveSudoku(char[][] board) {
	    	solve(board);
	    }
	    
	    //回溯函数
	    public boolean solve(char[][] board){
	        for(int i = 0; i < 9; i++){
	            for(int j = 0; j < 9; j++){
	                if(board[i][j] == '.'){
	                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
	                        if(isValid(board, i, j, c)){
	                            board[i][j] = c; //Put c for this cell
	                            
	                            if(solve(board))
	                                return true; //If it's the solution return true
	                            else
	                                board[i][j] = '.'; //Otherwise go back
	                        }
	                    }
	                    
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	    
	    //剪枝函数
	    private boolean isValid(char[][] board, int row, int col, char c){
	        for(int i = 0; i < 9; i++) {
	            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
	            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
	            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
	board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
	        }
	        return true;
	    }

	}
}

// 分析：解数独：太难了，不会做，抄答案。
// 这个题用到了回溯算法（backtracking），使用深度优先的方式搜索解空间，并且在搜索过程中用剪枝函数避免无效搜索。通过穷举的方式找问题的结果。

// 回溯算法说白了就是穷举法。不过回溯算法使用剪枝函数，剪去一些不可能到达 最终状态（即答案状态）的节点，从而减少状态空间树节点的生成。回溯法是一个既带有系统性又带有跳跃性的的搜索算法。它在包含问题的所有解的解空间树中，按照深度优先的策略，从根结点出发搜索解空间树。算法搜索至解空间树的任一结点时，总是先判断该结点是否肯定不包含问题的解。如果肯定不包含，则跳过对以该结点为根的子树的系统搜索，逐层向其祖先结点回溯。否则，进入该子树，继续按深度优先的策略进行搜索。
