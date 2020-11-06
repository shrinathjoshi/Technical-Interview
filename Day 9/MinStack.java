
/**
 * @author Shrinath Joshi
 * 
 * 		Problem Statement :- https://leetcode.com/problems/min-stack/
 */
import java.util.Stack;

class MinStack {
	private int globalMin = Integer.MAX_VALUE;
	Stack<Integer> stack;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<Integer>();
	}

	public void push(int x) {

		if (x <= globalMin) {
			stack.push(globalMin);
			globalMin = x;
		}
		stack.push(x);

	}

	public void pop() {
		if (stack.pop() == globalMin)
			globalMin = stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return globalMin;
	}
}
