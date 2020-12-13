/*
Problem Statement :- https://leetcode.com/problems/reverse-nodes-in-k-group/
 */

public class ReverseNodesInKGroup {
	public static ListNode reverseKGroup(ListNode head, int k) {

		if (head == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode start = dummy;
		ListNode end = head;
		int count = 0;

		while (end != null) {
			count++;

			if (count % (k) == 0) {
				// Need to reverse from start to end
				ListNode newTail = start.next;
				ListNode newEnd = end.next;
				start.next = getReverseLinkedList(start.next, end.next);
				newTail.next = newEnd;
				start = newTail;
				end = newEnd;
			} else {
				end = end.next;
			}
		}

		return dummy.next;
	}

	private static ListNode getReverseLinkedList(ListNode start, ListNode end) {

		ListNode previous = null;
		ListNode current = start;
		ListNode thenNext = current;

		while (current != end) {
			thenNext = current.next;
			current.next = previous;
			previous = current;
			current = thenNext;
		}

		return previous;
	}

	public static void main(String[] args) {
		ListNode five = new ListNode(5, null);
		ListNode four = new ListNode(4, five);
		ListNode three = new ListNode(3, four);
		ListNode two = new ListNode(2, three);
		ListNode one = new ListNode(1, two);

		ListNode result = ReverseNodesInKGroup.reverseKGroup(one, 2);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}

	}

}
