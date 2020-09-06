/*
Problem Statement:- https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedListTwo {
	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode current = head;
		ListNode previous = dummy;

		while (current != null && current.next != null) {

			if (current.val == current.next.val) {

				while (current != null && current.next != null && current.val == current.next.val)
					current.next = current.next.next;

				previous.next = current.next;
				current = current.next;
			} else {
				previous = current;
				current = current.next;
			}

		}

		return dummy.next;

	}
}
