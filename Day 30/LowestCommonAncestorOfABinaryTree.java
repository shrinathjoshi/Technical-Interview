/**
 * @author Shrinath Joshi
 * 
 *         Problem statement:-
 *         https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *         Recursive Approach
 * 
 *         Time complexity:- O(n) Space complexity :- O(h) , where h =height of
 *         binary tree and in worst case h=n (skew trees)
 * 
 * 
 *
 */
public class LowestCommonAncestorOfABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null)
			return null;
		if (root.val == p.val || root.val == q.val)
			return root;

		TreeNode leftSubtreeResult = lowestCommonAncestor(root.left, p, q);
		TreeNode rightSubtreeResult = lowestCommonAncestor(root.right, p, q);

		if (leftSubtreeResult != null && rightSubtreeResult != null)
			return root;

		if (leftSubtreeResult == null && rightSubtreeResult == null)
			return null;

		return leftSubtreeResult == null ? rightSubtreeResult : leftSubtreeResult;

	}
}
