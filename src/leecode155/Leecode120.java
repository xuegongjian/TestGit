package leecode155;

import java.util.List;

public class Leecode120 {
	public int minimumTotal(List<List<Integer>> triangle) {
//		if (null == triangle)
//			return 0;
//		int[][] dp = new int[triangle.size()][triangle.size()];
//		//
//		dp[0][0] = triangle.get(0).get(0);
//		for (int i = 1; i < triangle.size(); i++) {
//			for (int j = 0; j < triangle.get(i).size(); j++) {
//				if (j == 0) {
//					dp[i][j] = dp[i - 1][j]+triangle.get(i).get(j);
//				} else if (j == triangle.get(i).size() - 1) {
//					dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
//				} else {
//					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
//				}
//			}
//		}
//		int min = Integer.MAX_VALUE;
//		for (int i = 0; i < triangle.size(); i++) {
//			min = Math.min(min, dp[triangle.size()-1][i]);
//		}
		
		if (null == triangle)
			return 0;
		int[] dp = new int[triangle.size()];
		//
		for (int i = triangle.size()-1; i >= 0; i--) {
			for (int j = triangle.get(i).size()-1; j >=0; j--) {
				if (j == triangle.get(i).size() - 1) {
					dp[i] = triangle.get(i).get(j);
				} else {
					dp[i-1] = Math.min(dp[i - 1], dp[i]) + triangle.get(i).get(j);
				}
			}
		}
		
		return dp[0];
	}

	public static void main(String[] s) {
		// System.out.println(new Leecode120().isMatch("aab", "c*a*b"));

	}
}
