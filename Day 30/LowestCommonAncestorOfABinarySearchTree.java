/**
 * @author Shrinath Joshi
 * 
 *         Problem Statement :-
 *         https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 */
public class LowestCommonAncestorOfABinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// Time Complexity :- O(n)
		// Space Complexity :- O(n)

		if (root == null)
			return root;

		if (p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);
		else if (p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		else
			return root;
	}
}
