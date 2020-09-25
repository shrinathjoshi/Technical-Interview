import java.util.HashMap;
import java.util.Map;

/**
 * @author Shrinath Joshi
 * 
 *         Problem Statement
 *         :-https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		// Time complexity :- O(n)
		// Space complexity :- O(n)

		if (inorder.length != preorder.length)
			return null;
		if (inorder.length == 0)
			return null;
		if (inorder.length == 1)
			return new TreeNode(inorder[0]);

		Map<Integer, Integer> inorderIndexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++)
			inorderIndexMap.put(inorder[i], i);

		return buildTree(0, 0, inorder.length - 1, inorder, preorder, inorderIndexMap);
	}

	private TreeNode buildTree(int preorderIndex, int inorderStart, int inorderEnd, int[] inorder, int[] preorder,
			Map<Integer, Integer> inorderIndexMap) {

		if (preorderIndex > preorder.length - 1 || inorderStart > inorderEnd)
			return null;

		if (inorderStart == inorderEnd)
			return new TreeNode(inorder[inorderStart]);

		int inorderIndex = inorderIndexMap.get(preorder[preorderIndex]);
		TreeNode root = new TreeNode(preorder[preorderIndex]);
		root.left = buildTree(preorderIndex + 1, inorderStart, inorderIndex - 1, inorder, preorder, inorderIndexMap);
		root.right = buildTree(preorderIndex + (inorderIndex - inorderStart) + 1, inorderIndex + 1, inorderEnd, inorder,
				preorder, inorderIndexMap);

		return root;

	}

}
