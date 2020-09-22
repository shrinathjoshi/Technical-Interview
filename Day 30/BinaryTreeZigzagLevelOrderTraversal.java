import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Shrinath Joshi
 * 
 *         Problem Statement:-
 *         https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		boolean showReverse = false;
		while (!queue.isEmpty()) {

			int count = queue.size();
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < count; i++) {

				TreeNode top = queue.poll();

				if (top.left != null)
					queue.add(top.left);

				if (top.right != null)
					queue.add(top.right);

				if (showReverse)
					list.add(0, top.val);
				else
					list.add(top.val);

			}
			result.add(list);
			showReverse = !showReverse;
		}
		return result;

	}
}
