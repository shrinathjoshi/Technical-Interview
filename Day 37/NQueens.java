import java.util.ArrayList;
import java.util.List;

/**
 * @author Shrinath Joshi
 * 
 *         Problem Statement:- https://leetcode.com/problems/n-queens/
 */
public class NQueens {

	// Time Complexity :- O(N!)
	// Space Complexity :- O(
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<Integer> partialSolution = new ArrayList<Integer>();

		nQueensUsingRecursion(0, partialSolution, result, n);

		return result;
	}

	private void nQueensUsingRecursion(int queenIndex, List<Integer> partialSolution, List<List<String>> result,
			int n) {

		if (partialSolution.size() == n) {
			result.add(new ArrayList<String>(transform(partialSolution, n)));
			return;
		}

		if (partialSolution.size() > n)
			return;

		for (int i = 1; i <= n; i++) {
			if (isValidPosition(i, partialSolution, n)) {
				partialSolution.add(i);
				nQueensUsingRecursion(i + 1, partialSolution, result, n);
				partialSolution.remove(partialSolution.size() - 1);
			}
		}
	}

	private boolean isValidPosition(int possibleindex, List<Integer> partialSolution, int n) {

		for (Integer validSolution : partialSolution) {
			if (validSolution == possibleindex)
				return false;
		}

		int currentIndex = partialSolution.size() - 1;

		int base = 1;
		while (currentIndex >= 0 && (possibleindex + base <= n || possibleindex - base >= 1)) {

			Integer validSolution = partialSolution.get(currentIndex);

			if (validSolution == possibleindex + base || validSolution == possibleindex - base)
				return false;

			currentIndex--;
			base++;
		}

		return true;
	}

	private List<String> transform(List<Integer> partialSolution, int n) {

		List<String> solution = new ArrayList<String>();
		for (Integer in : partialSolution) {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= n; i++) {
				if (i == in)
					sb.append("Q");
				else
					sb.append(".");
			}
			solution.add(sb.toString());
		}

		return solution;
	}

	public static void main(String[] args) {

		List<List<String>> resultList = new NQueens().solveNQueens(4);

		System.out.println(resultList);
	}

}
