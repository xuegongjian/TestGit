package leecode155;

public class Leecode309 {
	public int maxProfit(int[] prices) {
		if(null == prices){
			return 0;
		}
		
		int[][]dp = new int[prices.length][3];
		dp[0][0] = -prices[0]; //持有
		dp[0][1] = 0; //没有持有 冻结
		dp[0][2] = 0; //没有持有 非冻结
		for(int i = 1; i < prices.length;i++){
			dp[i][0] = Math.max(dp[i - 1][0],dp[i-1][1] - prices[i]);
			
			dp[i][1] = dp[i-1][0] + prices[i];
			
			dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]) ; 
		}
		
		return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
		
		
	}
}
