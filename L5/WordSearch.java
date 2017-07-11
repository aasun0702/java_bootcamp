package L5;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0) {
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (helper(board, word, 0, i, j)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean helper(char[][] board, String word, int index, int i, int j) {
		char[] target = word.toCharArray();
		if (index == target.length) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != target[index]) {
			return false;
		}

		char cur = board[i][j];
		board[i][j] = '$';
		boolean res = helper(board, word, index + 1, i - 1, j) || helper(board, word, index + 1, i + 1, j)
				|| helper(board, word, index + 1, i, j - 1) || helper(board, word, index + 1, i, j + 1);

		board[i][j] = cur;

		return res;
	}
}
