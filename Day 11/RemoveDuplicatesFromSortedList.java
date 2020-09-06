/*
Problem Statement :-https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {

		return deleteDuplicatesUsingRecursion(head);
		// return deleteDuplicatesIterativeEfficient(head);
		// return deleteDuplicateIterative(head);
	}

	private ListNode deleteDuplicatesUsingRecursion(ListNode head) {
		if (head == null || head.next == null)
			return head;
		head.next = deleteDuplicatesUsingRecursion(head.next);
		return head.val == head.next.val ? head.next : head;
	}

	private ListNode deleteDuplicatesIterativeEfficient(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode current = head;

		while (current != null && current.next != null) {

			if (current.val == current.next.val) {
				current.next = current.next.next;
			} else
				current = current.next;
		}

		return head;
	}

	private ListNode deleteDuplicateIterative(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode current = head;

		while (current != null && current.next != null) {

			if (current.val == current.next.val) {
				ListNode temp = current.next;

				while (temp != null && temp.val == current.val) {
					temp = temp.next;
				}
				current.next = temp;
				current = temp;
			} else
				current = current.next;
		}

		return head;
	}
}
