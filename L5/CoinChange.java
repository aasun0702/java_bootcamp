package L5;

import java.util.Arrays;

public class CoinChange {
	public int coinChangeDFS(int[] coins, int amount) {
		// count[i]表示兑换值为i的钱币所需要的已有面额钱币最小数量
		int[] count = new int[amount + 1];
		Arrays.fill(count, Integer.MAX_VALUE);
		count[0] = 0;

		helper(coins, amount, count);
		return count[amount];
	}

	private int helper(int[] coins, int remain, int[] count) {
		if (count[remain] != Integer.MAX_VALUE) {
			return count[remain];
		}

		int res = Integer.MAX_VALUE;

		for (int i = 0; i < coins.length; i++) {
			if (remain < coins[i]) {
				continue;
			}

			int temp = helper(coins, remain - coins[i], count);
			if (temp != -1) {
				res = Math.min(res, temp + 1);
			}

		}

		count[remain] = (res == Integer.MAX_VALUE) ? -1 : res;
		return count[remain];
	}

	public int coinChangeDP(int[] coins, int amount) {
		if (amount <= 0) {
			return 0;
		}
		// dp[i]表示兑换值为i的钱币所需要的已有面额钱币最小数量
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin > i) {
					continue;
				}
				if (dp[i - coin] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
	}
}
