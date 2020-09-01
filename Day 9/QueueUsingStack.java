import java.util.Stack;

/**
 * @author Shrinath Joshi
 * 
 *         problem Statement:-
 *         https://leetcode.com/problems/implement-queue-using-stacks/
 *
 */
class MyQueue {

	// Push is O(n) , pop is O(1)

	private Stack<Integer> stack;
	private Stack<Integer> tempStack;

	/** Initialize your data structure here. */
	public MyQueue() {
		stack = new Stack<Integer>();
		tempStack = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		while (!stack.isEmpty()) {
			tempStack.push(stack.pop());
		}

		stack.push(x);

		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return stack.pop();
	}

	/** Get the front element. */
	public int peek() {
		return stack.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack.isEmpty();
	}
}

public class QueueUsingStack {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();

		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek()); // returns 1
		System.out.println(queue.pop()); // returns 1
		System.out.println(queue.empty()); // returns false
	}

}
