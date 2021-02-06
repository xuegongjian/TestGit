package leecode155;

public class Leecode72 {
	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		if (m == 0 || n == 0) {
			return Math.max(m, n);
		}
		char[] char1 = word1.toCharArray();
		char[] char2 = word2.toCharArray();
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (char1[i] == char2[j]) {
					if (i >= 1 && j >= 1) {
						dist[i][j] = dist[i - 1][j - 1];
					}
				} else {
					//
					int t1 = ((j >= 1) ? dist[i][j - 1] : 0) + 1;
					int t2 = ((i >= 1) ? dist[i - 1][j] : 0) + 1;
					int t3 = ((i >= 1 && j >= 1) ? dist[i - 1][j - 1] : 0) + 1;

					dist[i][j] = Math.min(Math.min(t1, t2), t3);
				}
			}
		}
		return dist[n - 1][m - 1];
	}

	public static void main(String[] s) {
		System.out.println(new Leecode72().minDistance("horse", "ros"));

	}

}
