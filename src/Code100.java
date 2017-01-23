/**
 * 100. Same Tree
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * @author shenpengyan
 *
 * link:
 */
public class Code100 {

	public static void main(String[] args) {
		Code100 code = new Code100();
		Solution sol = code.new Solution();
		TreeNode t1 = code.new TreeNode(1);
		TreeNode t2 = code.new TreeNode(1);
		System.out.println(sol.isSameTree(t1, t2));
	}

	class Solution {
		public boolean isSameTree(TreeNode p, TreeNode q) {
			if ((p == null) && (q == null)) {
				return true;
			}
			if ((p != null) && (q != null)) {
				if (p.val == q.val)
					if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
						return true;
			}
			return false;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
