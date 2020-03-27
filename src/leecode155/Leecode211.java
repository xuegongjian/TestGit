package leecode155;

public class Leecode211 {
	public int maximalSquare(char[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] rows = new int[n][m];

		int[][] cols = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == '0') {
					rows[i][j] = 0;
					cols[i][j] = 0;
				} else {
					if (i - 1 >= 0) {
						rows[i][j] = rows[i - 1][j] + 1;
					} else {
						rows[i][j] = 1;
					}
					if (j - 1 >= 0) {
						cols[i][j] = rows[i][j - 1] + 1;
					} else {
						rows[i][j] = 1;
					}
				}
			}
		}
		
		int maxValue = 0;
		for (int i = n-1; i > 0; i--) {
			for (int j = m-1; j >0; j--) {
				if(rows[i][j] > 0 && rows[i][j] > 0){
					int s = Math.min(rows[i][j] , cols[i][j]);
					maxValue = s * s;
					
				}
			}
		}
		
		return maxValue;
	}

	public static void main(String[] s) {
		// System.out.println(new Leecode211().maximalSquare(new
		// int[]{1,2,3,4,3}));

	}
}
