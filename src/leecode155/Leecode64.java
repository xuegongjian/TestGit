package leecode155;

public class Leecode64 {
	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < m; j++) {
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1])+ grid[i][j];
			}
		}
		int min = Integer.MAX_VALUE;
		for(int j = 0;j<m;j++){
			if(dp[n-1][j]<min){
				min = dp[n-1][j];
			}
		}
		return min;
	}

	public static void main(String[] s) {
		// System.out.println(new Leecode437().findDuplicate(new int[] { 1, 2,
		// 3, 4, 3 }));

	}
}
