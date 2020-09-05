/*
Problem Statement :- https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesinPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode newStart = head.next;

		ListNode pre = dummy;
		ListNode start = head;
		ListNode thenNext = start.next;

		while (start != null && thenNext != null) {
			start.next = thenNext.next;
			thenNext.next = start;
			pre.next = thenNext;
			pre = start;
			start = start.next;
			if (start != null)
				thenNext = start.next;
		}

		return newStart;
	}

	public static void main(String[] args) {
		// ListNode five = new ListNode(1, null);
		ListNode four = new ListNode(2, null);
		ListNode three = new ListNode(3, four);
		ListNode two = new ListNode(4, three);
		ListNode one = new ListNode(5, two);

		ListNode result = SwapNodesinPairs.swapPairs(one);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

}
