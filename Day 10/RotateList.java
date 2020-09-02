
/**
 * @author Shrinath Joshi
 *
 *
 *         Problem Statement :- https://leetcode.com/problems/rotate-list/
 *
 */

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {

		// Time complexity :- O(n)
		// Space complexity :- O(1)

		if (head == null || k == 0 || head.next == null)
			return head;

		int totalLength = 1;

		ListNode fast = head;
		while (fast.next != null) {
			totalLength++;

			fast = fast.next;
		}

		fast.next = head;

		int rotateCount = totalLength - (k % totalLength);

		ListNode slow = head;
		for (int i = 0; i < rotateCount - 1; i++)
			slow = slow.next;

		head = slow.next;
		slow.next = null;

		return head;
	}

	public static void main(String[] args) {

		ListNode two = new ListNode(2, null);

		ListNode one = new ListNode(1, two);

		ListNode result = new RotateList().rotateRight(one, 2);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}

	}

}
