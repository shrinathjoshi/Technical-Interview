/*
Problem Statement :- https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListTwo {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		boolean reverseHeadNode = false;
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode startOfReverseList = dummy;

		for (int i = 0; i < m - 1; i++)
			startOfReverseList = startOfReverseList.next;

		ListNode previous = null;
		ListNode current = startOfReverseList.next;
		ListNode nextNode = current;

		for (int i = 0; i < n - m + 1; i++) {
			nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}

		if (startOfReverseList != null && startOfReverseList.next == head)
			reverseHeadNode = true;

		ListNode nxt = startOfReverseList.next;
		startOfReverseList.next = previous;
		nxt.next = current;

		return reverseHeadNode ? startOfReverseList.next : head;
	}

	public static void main(String args[]) {

		ListNode five = new ListNode(5, null);
		ListNode four = new ListNode(4, five);
		ListNode three = new ListNode(3, four);
		ListNode two = new ListNode(2, three);
		ListNode one = new ListNode(1, two);

		ListNode empty = new ListNode();

		ListNode result = new ReverseLinkedListTwo().reverseBetween(empty, 1, 4);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}

		System.out.println();

		result = new ReverseLinkedListTwo().reverseBetween(one, 1, 4);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}

	}
}
