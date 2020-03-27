package leecode155;

import java.util.ArrayDeque;
import java.util.LinkedList;

import javafx.util.Pair;

public class Leecode365 {
	int ret = 0;

	public int orangesRotting(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
		int current = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Pair(i, j));
				} else if (grid[i][j] == 1) {
					current++;
				}
			}
		}
		int[][] dis = new int[n][m];
		int max = 0;
		while (!queue.isEmpty()) {
			Pair<Integer, Integer> pair = queue.removeFirst();
			int i = pair.getKey();
			int j = pair.getValue();


			if (i > 0) {
				if (grid[i - 1][j] == 1) {
					dis[i - 1][j] = dis[i][j] + 1;
					queue.add(new Pair(i - 1, j));
					max = dis[i][j] + 1;
					current--;
					if (current == 0)
						break;
					grid[i-1][j] = 2;
				}
			}
			if (i < n - 1) {
				if (grid[i + 1][j] == 1) {
					dis[i + 1][j] = dis[i][j] + 1;
					queue.add(new Pair(i + 1, j));
					max = dis[i][j] + 1;
					current--;
					if (current == 0)
						break;
					grid[i+1][j] = 2;
				}
			}
			if (j > 0) {
				if (grid[i][j - 1] == 1) {
					dis[i][j - 1] = dis[i][j] + 1;
					queue.add(new Pair(i, j - 1));
					max = dis[i][j] + 1;
					current--;
					if (current == 0)
						break;
					grid[i][j-1] = 2;
				}
			}
			if (j < m - 1) {
				if (grid[i][j + 1] == 1) {
					dis[i][j + 1] = dis[i][j] + 1;
					queue.add(new Pair(i, j + 1));
					max = dis[i][j] + 1;
					current--;
					if (current == 0)
						break;
					grid[i][j+1] = 2;
				}
			}

			
		}
		return current > 0 ? -1 : max;
	}

	public static void main(String[] s) {
		System.out.println(new Leecode365().orangesRotting(new int[][] 
				{{2,2},{1,1},{0,0},{2,0}}));

	}
}
