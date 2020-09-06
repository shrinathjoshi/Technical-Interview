/*
Problem Statement :- https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}

		return false;
	}
}
