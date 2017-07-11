package A5;

public class BestTimeBuy_SellStock {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int lowest = prices[0];
		int max_p = 0;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < lowest) {
				lowest = prices[i];
			}
			max_p = Math.max(max_p, prices[i] - lowest);
		}

		return max_p;
	}
}
