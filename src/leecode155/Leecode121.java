package leecode155;

public class Leecode121 {
	public int maxProfit(int[] prices) {
		int[][]dp = new int[prices.length][3];
		dp[0][0] = -prices[0]; //持有
		dp[0][1] = 0; //没有持有
		dp[0][2] = 0; //已经买了一次
		
		
		for(int i = 1; i < prices.length; i++){
			dp[i][0] = Math.max(dp[i-1][0], dp[0][1]-prices[i]);
			dp[i][1] = dp[i-1][1]; 
			dp[i][2]  = Math.max(dp[i-1][2] , dp[i-1][0]+ prices[i]);
		}
		
		return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
		
	}

	public static void main(String[] s) {
		// System.out.println(new Leecode120().isMatch("aab", "c*a*b"));

	}
}
