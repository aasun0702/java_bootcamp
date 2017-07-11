package A5;

import java.util.ArrayList;
import java.util.List;

public class nQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		int[] queenList = new int[n];// queenList[i]表示第i行放入Q的列数
		placeQueen(queenList, 0, n, res);// 在第0行放Q
		return res;
	}

	private void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
		// 填满所有行时，就生成一个结果
		if (row == n) {
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				String str = "";
				for (int j = 0; j < n; j++) {
					if (j == queenList[i]) {
						str += 'Q';
					} else {
						str += '.';
					}
				}
				list.add(str);
			}
			res.add(list);
		}

		for (int col = 0; col < n; col++) {
			// 遍历每一列，找每一行所有可能填入Q的列数
			if (isValid(queenList, row, col)) {
				queenList[row] = col;
				placeQueen(queenList, row + 1, n, res);
			}
		}
	}

	// 该方法用来判断在(row, col)处填入Q是否合法
	private boolean isValid(int[] queenList, int row, int col) {
		for (int i = 0; i < row; i++) {
			int pos = queenList[i];
			if (pos == col) {// 与之前出现同列
				return false;
			}

			if (pos + i - row == col) {// 与之前在一条左对角线
				return false;
			}

			if (pos + row - i == col) {// 与之前在一条右对角线
				return false;
			}
		}
		return true;
	}
}
