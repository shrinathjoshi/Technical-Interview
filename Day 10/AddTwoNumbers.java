/*
Problem Statement:- https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode head = new ListNode(-1);
		ListNode current = head;
		int carry = 0;
		while (l1 != null || l2 != null) {

			ListNode newNode = new ListNode();

			l1 = l1 != null ? l1 : new ListNode(0);
			l2 = l2 != null ? l2 : new ListNode(0);

			int ans = (l1.val + l2.val) + carry;
			newNode.val = ans % 10;
			carry = ans / 10;

			current.next = newNode;

			l1 = l1.next;
			l2 = l2.next;
			current = current.next;
		}

		if (carry == 1)
			current.next = new ListNode(1);

		return head.next;
	}
}
