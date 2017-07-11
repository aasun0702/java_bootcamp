package L5;

public class HouseRobber {
	public int robDP(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		// dp[i]表示当房屋数为i + 1时，最大可抢钱数
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}

		return dp[nums.length - 1];
	}

	public int robDFS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		return helper(nums, nums.length - 1);
	}

	private int helper(int[] nums, int pos) {
		if (pos == 0) {
			return nums[0];
		}
		if (pos == 1) {
			return Math.max(nums[0], nums[1]);
		}

		return Math.max(helper(nums, pos - 1), helper(nums, pos - 2) + nums[pos]);
	}
}
