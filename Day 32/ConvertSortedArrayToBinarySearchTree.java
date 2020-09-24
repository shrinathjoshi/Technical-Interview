/**
 * 
 * @author Shrinath Joshi
 * 
 *         Problem statement :-
 *         https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 */
public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		int n = nums.length;

		if (n == 0)
			return null;
		if (n == 1)
			return new TreeNode(nums[0]);

		return sortedtArrayToBST(nums, 0, n - 1);
	}

	private TreeNode sortedtArrayToBST(int[] nums, int left, int right) {

		// Recurrance Releation :- T(n) = 2T(n/2) + O(1)
		// Time Complexity :- O(N)
		// Space Complexity :- O(log N)

		if (left > right)
			return null;

		if (left == right)
			return new TreeNode(nums[left]);

		int middle = left + (right - left) / 2;

		TreeNode root = new TreeNode(nums[middle]);
		root.left = sortedtArrayToBST(nums, left, middle - 1);
		root.right = sortedtArrayToBST(nums, middle + 1, right);

		return root;
	}

}
