/*
Problem Statement:- https://leetcode.com/problems/sort-list/
 */

public class SortList {
	public static ListNode sortList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode fast = head, slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode secondList = slow.next;
		slow.next = null;

		ListNode l1 = sortList(head);
		ListNode l2 = sortList(secondList);

		return merge(l1, l2);

	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0);
		ListNode newList = l;

		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				newList.next = l2;
				l2 = l2.next;
			} else {
				newList.next = l1;
				l1 = l1.next;
			}

			newList = newList.next;
		}

		if (l1 != null) {
			newList.next = l1;
		}

		if (l2 != null) {
			newList.next = l2;
		}

		return l.next;
	}

	public static void main(String[] args) {

		ListNode five = new ListNode(1, null);
		ListNode four = new ListNode(2, five);
		ListNode three = new ListNode(3, four);
		ListNode two = new ListNode(4, three);
		ListNode one = new ListNode(5, two);

		ListNode result = SortList.sortList(one);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}

	}

}
