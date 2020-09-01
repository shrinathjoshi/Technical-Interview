import java.util.LinkedList;
import java.util.Queue;

class MyOptimizedStack {

	private LinkedList<Integer> queue;

	/** Initialize your data structure here. */
	public MyOptimizedStack() {
		queue = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queue.add(x);
		int size = queue.size();
		while (size > 1) {
			queue.add(queue.remove());
			size--;
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return queue.remove();
	}

	/** Get the top element. */
	public int top() {
		return queue.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}
}

class MyStack {

	// This Approach uses two Queue
	// for More Optimized code check MyOptimizedStack class

	private int size = 0;
	private Queue<Integer> queue;
	private Queue<Integer> tempQueue;

	/** Initialize your data structure here. */
	public MyStack() {
		queue = new LinkedList<Integer>();
		tempQueue = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		while (!queue.isEmpty()) {
			tempQueue.offer(queue.poll());
		}
		queue.add(x);
		size++;
		while (!tempQueue.isEmpty()) {
			queue.offer(tempQueue.poll());
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		if (!empty()) {
			size--;
			return queue.poll();
		}
		return -1;

	}

	/** Get the top element. */
	public int top() {
		return queue.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return size == 0;
	}
}

public class StackUsingQueue {

	public static void main(String[] args) {
		MyStack stack = new MyStack();

		stack.push(1);
		stack.push(2);
		System.out.println(stack.top()); // returns 2
		System.out.println(stack.pop()); // returns 2
		System.out.println(stack.empty()); //
	}

}
