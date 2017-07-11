package A5;

public class HouseRobberII {
	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		int max1 = helper(nums, 0, nums.length - 2);
		int max2 = helper(nums, 1, nums.length - 1);
		int max = Math.max(max1, max2);
		return max;
	}

	private static int helper(int[] nums, int beg, int end) {

		if (beg == end) {
			return nums[beg];
		}

		int[] dp = new int[end - beg + 1];
		dp[0] = nums[beg];
		dp[1] = Math.max(nums[beg], nums[beg + 1]);

		for (int i = 2; i < end - beg + 1; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[beg + i]);
		}

		return dp[end - beg];
	}

	public static void main(String[] args) {
		int[] house = { 1, 1, 1, 2 };
		int money = rob(house);
		System.out.print(money);
	}

}
