import java.util.Stack;

/*
Problem Statement :- https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */

class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;
}

public class FlattenAMultilevelDoublyLinkedList {
	public Node flatten(Node head) {

		if (head == null)
			return head;

		Node temp = head;
		Stack<Node> stack = new Stack<Node>();

		while (temp != null) {

			if (temp.next == null && !stack.isEmpty()) {
				temp.next = stack.pop();
				if (temp.next != null)
					temp.next.prev = temp;
			} else if (temp.child == null) {
				temp = temp.next;
			} else {
				stack.add(temp.next);
				temp.next = temp.child;
				if (temp.next != null)
					temp.next.prev = temp;
				temp.child = null;
			}

		}
		return head;
	}
}
