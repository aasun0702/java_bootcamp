package A5;

import java.util.Arrays;

public class PerfectSquares {
	public int numSquares(int n) {
		if (n <= 0) {
			return 0;
		}

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = 1; i * i <= n; i++) {
			dp[i * i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j * j < i; j++) {
				dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);//以防a + b * b本身是个完全平方数
			}
		}

		return dp[n];
	}
}
