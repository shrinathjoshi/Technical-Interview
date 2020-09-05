/*
Problem statement :- https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode current = head;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				current.next = l2;
				l2 = l2.next;
			} else {
				current.next = l1;
				l1 = l1.next;
			}

			current = current.next;
		}

		if (l1 != null)
			current.next = l1;

		if (l2 != null)
			current.next = l2;

		return head.next;
	}
}
