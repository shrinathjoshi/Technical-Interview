/**
 * @author Shrinath Joshi
 *
 *
 *         Problem Statement :- https://leetcode.com/problems/word-search/
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int n = word.length();

		if (n == 0)
			return false;

		Character seed = word.charAt(0);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == seed && chechIfPresentInBoard(i, j, board, word, 0))
					return true;
			}
		}

		return false;
	}

	private boolean chechIfPresentInBoard(int row, int column, char board[][], String word, int index) {

		if (index == word.length())
			return true;
		if (row < 0 || row > board.length - 1 || column < 0 || column > board[0].length - 1
				|| index > word.length() - 1)
			return false;

		if (board[row][column] != word.charAt(index))
			return false;

		char temp = board[row][column];
		board[row][column] = '#';

		boolean ans = chechIfPresentInBoard(row - 1, column, board, word, index + 1)
				|| chechIfPresentInBoard(row + 1, column, board, word, index + 1)
				|| chechIfPresentInBoard(row, column - 1, board, word, index + 1)
				|| chechIfPresentInBoard(row, column + 1, board, word, index + 1);

		board[row][column] = temp;

		return ans;
	}

	public static void main(String[] args) {
		char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCD";

		System.out.println(new WordSearch().exist(board, word));
	}

}
