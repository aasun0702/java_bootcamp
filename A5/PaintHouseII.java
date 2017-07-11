package A5;

public class PaintHouseII {
	public int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length == 0) {
			return 0;
		}

		int n = costs.length;
		int k = costs[0].length;
		int[][] dp = new int[n][k];
		int res = Integer.MAX_VALUE;

		for (int j = 0; j < k; j++) {
			dp[0][j] = costs[0][j];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < k; j++) {
				int curMin = Integer.MAX_VALUE;

				for (int t = 0; t < k; t++) {
					if (t == j) {
						continue;
					}
					curMin = Math.min(curMin, dp[i - 1][t]);
				}
				dp[i][j] = costs[i][j] + curMin;
			}
		}

		for (int j = 0; j < k; j++) {
			res = Math.min(res, dp[n - 1][j]);
		}

		return res;
	}
}
