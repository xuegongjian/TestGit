package leecode155;

import java.util.Arrays;

public class Leecode416 {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		int max = 0;
		for (int value : nums) {
			sum += value;
			max = Math.max(max, value);
		}
		if (sum % 2 != 0) {
			return false;
		}
		int self = sum / 2;
		if (max > self) {
			return false;
		}
		boolean[][] dp = new boolean[nums.length][self + 1];
		for (int i = 0; i < nums.length; i++) {
			int value = nums[i];
			for (int j = 1; j <= self; j++) {
				if (i == 0) {
					if( j == value) {
						dp[i][j] = true;
					}
				} else if (j >= value) {
					dp[i][j] = dp[i - 1][j] || dp[i-1][j - value];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[nums.length - 1][self];
	}

	public static void main(String[] s) {
		int[] nums = new int[] { 1,5,11,5 };
		System.out.println(new Leecode416().canPartition(nums));

	}
}
