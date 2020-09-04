/*
Problem Statement:- https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null)
			return head;

		ListNode fast = head;
		ListNode slow = head;

		int count = n;
		while (fast != null && count-- > 0) {
			fast = fast.next;
		}

		if (fast == null) {
			head = head.next;
			return head;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return head;
	}

}
