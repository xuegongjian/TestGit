package leecode155;

public class Leecode279 {
	int minStep = 100;

	public int numSquares(int n) {
		dfs(n, 0);
		System.out.println(minStep);
		if(n==1) return 1;
		if(n==2) return 2;
		return dp(n);
	}

	private int dp(int n){
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <=n; i++){
			dp[i] = Integer.MAX_VALUE;
		}
		for(int i = 3; i <=n; i++){
			for(int j = 1; j <= (int)Math.sqrt(i);j++)
			
				dp[i] = Math.min(dp[i- j*j]+1,dp[i]);
		}
		return dp[n];
	}
	
	private void dfs(int n, int step) {
		if (n == 0) {
			minStep = Math.min(minStep, step);
		}
		if (step >= minStep)
			return;

		for (int i = (int)Math.sqrt(n); i >= 1; i--) {
			dfs(n - i * i, step+1);
		}

	}

	public static void main(String[] s) {
		System.out.println(new Leecode279().numSquares(4093));
	}
}
