/*
Problem Statement:- https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
	public static ListNode reverseList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		return reverseLinkedListUsingIterativeApproach(head);
		// return reverseLinkedListUsingRecursiveApproach(head);
	}

	private static ListNode reverseLinkedListUsingIterativeApproach(ListNode head) {

		ListNode previous = null;
		ListNode current = head;
		ListNode nextNode = current;

		while (current != null) {
			nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}

		return previous;
	}

	private static ListNode reverseLinkedListUsingRecursiveApproach(ListNode head) {

		ListNode temp = reverseLinkedListUsingRecursiveApproach(head.next);
		head.next.next = head;
		head.next = null;

		return temp;
	}

	public static void main(String args[]) {
		// ListNode five = new ListNode(1, null);
		ListNode four = new ListNode(2, null);
		ListNode three = new ListNode(3, four);
		ListNode two = new ListNode(4, three);
		ListNode one = new ListNode(5, two);

		ListNode result = ReverseLinkedList.reverseList(one);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
