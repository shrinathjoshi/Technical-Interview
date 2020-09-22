/**
 * @author Shrinath Joshi
 * 
 *         Problem Statement :- https://leetcode.com/problems/same-tree/
 */

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {

		// Time complexity :- O(n)
		// Space complexity :- O(log n)

		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;

		if (p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		else
			return false;
	}
}
