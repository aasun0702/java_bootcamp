package A5;

public class MinPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int row = grid.length;
		int col = grid[0].length;
		int[][] dp = new int[row][col];// 最小路径和矩阵

		dp[0][0] = grid[0][0];
		// 首元素
		for (int i = 1; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		} // 第一行

		for (int j = 1; j < row; j++) {
			dp[j][0] = dp[j - 1][0] + grid[j][0];
		} // 第一列

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}
}
