/*
Problem Statement :- https://leetcode.com/problems/linked-list-cycle-ii/
 */

public class LinkedListCycleTwo {
	public ListNode detectCycle(ListNode head) {

		if (head == null)
			return null;

		if (head.next == null)
			return null;
		boolean hasCycle = false;
		ListNode slow = head.next;
		ListNode fast = slow.next;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasCycle = true;
				break;
			}
		}

		if (!hasCycle)
			return null;

		fast = head;

		while (fast != slow) {
			slow = slow.next;
			fast = fast.next;
		}

		return fast;

	}
}
