package leecode155;

public class Leecode718 {
	public int findLength(int[] A, int[] B) {
		if (null == A || null == B) {
			return 0;
		}
		int m = A.length;
		int n = B.length;
		int[][] dp = new int[m][n];
		int max  =0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(A[i]== B[j]){
					if(i>=1 && j>=1){
						dp[i][j] = dp[i-1][j-1]+1;
					} else {
						dp[i][j] =1;
					}
					max = Math.max(max, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return max;
	}

	public static void main(String[] s) {
//		System.out.println(new Leecode718().findLength("()(()"));

	}
}
