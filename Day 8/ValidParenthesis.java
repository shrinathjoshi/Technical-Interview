import java.util.Stack;

/**
 * @author Shrinath Joshi
 * 
 *         Problem Statement:- https://leetcode.com/problems/valid-parentheses/
 *
 */
public class ValidParenthesis {

	public static boolean isValidEfficient(String s) {

		// Time Complexity :- O(n)
		// Space Complexity :- O(n)

		Stack<Character> stack = new Stack<Character>();

		for (char ch : s.toCharArray()) {
			if (ch == '(')
				stack.push(')');
			else if (ch == '{')
				stack.push('}');
			else if (ch == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != ch)
				return false;

		}

		return stack.isEmpty();

	}

	public static boolean isValid(String s) {

		// Time Complexity :- O(n)
		// Space Complexity :- O(n)

		Stack<Character> stack = new Stack<Character>();

		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[')
				stack.push(ch);
			else {
				if (stack.isEmpty())
					return false;

				char top = stack.pop();

				if ((top != '(' && ch == ')') || (top != '{' && ch == '}') || (top != '[' && ch == ']'))
					return false;
			}

		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(ValidParenthesis.isValid("{{]"));
		System.out.println(ValidParenthesis.isValid("{}"));
		System.out.println(ValidParenthesis.isValid("{]]"));

	}

}
