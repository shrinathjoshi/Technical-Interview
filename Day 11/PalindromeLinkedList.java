import java.util.Stack;

/*
Problem Statement :- https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
	public static boolean isPalindrome(ListNode head) {
		// return isPalindromeUsingStack(head);
		return isPalindromeEfficient(head);

	}

	private static boolean isPalindromeEfficient(ListNode head) {
		// Time complexity :- O(n)
		// Space complexity :- O(1)

		if (head == null)
			return true;

		ListNode fast = head;
		ListNode slow = head;

		// Finding the middle of LL
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		fast = getReverseLinkedList(slow.next);
		slow.next = null;
		slow = head;

		while (fast != null) {
			if (slow.val != fast.val)
				return false;

			slow = slow.next;
			fast = fast.next;
		}

		return true;
	}

	private static ListNode getReverseLinkedList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode temp = getReverseLinkedList(head.next);
		head.next.next = head;
		head.next = null;

		return temp;

	}

	private static boolean isPalindromeUsingStack(ListNode head) {

		// Time complexity :- O(n)
		// Space complexity :- O(n)

		if (head == null)
			return true;

		Stack<Integer> stack = new Stack<Integer>();

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			stack.add(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null)
			slow = slow.next;

		while (slow != null) {
			int top = stack.pop();
			if (slow.val != top)
				return false;
			slow = slow.next;
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// 1->2->2->1

		ListNode one = new ListNode(1, null);
		ListNode two = new ListNode(2, one);
		ListNode three = new ListNode(2, two);
		ListNode four = new ListNode(1, three);

		System.out.println(PalindromeLinkedList.isPalindrome(four));

	}

}
