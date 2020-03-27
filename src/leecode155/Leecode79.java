package leecode155;

import java.util.Stack;

public class Leecode79 {
	public boolean exist(char[][] board, String word) {
		if (null == board || board[0].length == 0 || null == word)
			return false;
		char[] chars = word.toCharArray();

		int n = board.length;
		int m = board[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == chars[0]) {
					boolean find = bfs(i, j, board, chars);
					if (find) {
						return find;
					}
				}
			}
		}

		return false;
	}

	private boolean bfs(int r, int c, char[][] board, char[] chars) {
		int n = board.length;
		int m = board[0].length;
		int[][] flag = new int[n][m];
		Stack<String> stack = new Stack<>();
		stack.add(r + "_" + c + "_" + 1);
		while (!stack.empty()) {
			String value = stack.pop();
			String[] cur = value.split("_");
			int step = Integer.valueOf(cur[2]);
			int i = Integer.valueOf(cur[0]);
			int j = Integer.valueOf(cur[1]);
			flag[i][j] = step;
			// 把除直接外的step都清空
			for (int k = 0; k < n; k++) {
				for (int l = 0; l < m; l++) {
					if (k == i && l == j)
						continue;
					if (flag[k][l] >= step) {
						flag[k][l] = 0;
					}
				}
			}

			if (step == chars.length) {
				return true;
			}

			char nextChar = chars[step];
			int nextStep = step + 1;

			if (i - 1 >= 0 && board[i - 1][j] == nextChar && flag[i - 1][j] == 0) {
				stack.add((i - 1) + "_" + j + "_" + nextStep);
			}

			if (i + 1 < n && board[i + 1][j] == nextChar && flag[i + 1][j] == 0) {
				stack.add((i + 1) + "_" + j + "_" + nextStep);
			}

			if (j - 1 >= 0 && board[i][j - 1] == nextChar && flag[i][j - 1] == 0) {
				stack.add(i + "_" + (j - 1) + "_" + nextStep);
			}

			if (j + 1 < m && board[i][j + 1] == nextChar && flag[i][j + 1] == 0) {
				stack.add(i + "_" + (j + 1) + "_" + nextStep);
			}
		}
		return false;
	}

	public static void main(String[] s) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(new Leecode79().exist(board,"ABCCED"));

	}
}
