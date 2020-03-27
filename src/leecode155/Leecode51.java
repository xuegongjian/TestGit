package leecode155;

public class Leecode51 {
	int total = 0;

	public int totalNQueens(int n) {
		int[][] boards = new int[n][n];
		for (int i = 0; i < n; i++) {
			boards[0][i] = 1;
			doPut(boards, 1, n);
			boards[0][i] = 0;
		}
		return total;
	}

	private void doPut(int[][] boards, int step, int n) {
		if (step == n) {
			total = total + 1;
//			System.out.println(total);
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(boards[i][j]);
//				}
//				System.out.println("");
//			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (canPut(step, i, boards, n)) {
				boards[step][i] = 1;
				doPut(boards, step + 1, n);
				boards[step][i] = 0;
			}
		}
	}

	private boolean canPut(int i, int j, int[][] boards, int n) {
		for (int k = 0; k < i; k++) {
			if (boards[k][j] == 1)
				return false;
		}

		for (int k = j + 1; k < n; k++) {
			if (i - (k - j) >= 0 && k < n) {
				if (boards[i - (k - j)][k] == 1)
					return false;
			} else {
				break;
			}
		}

		int index = 0;
		for (int k = j - 1; k >= 0; k--) {
			index=index+1;
			if (i - index >= 0) {
				if (boards[i - index][k] == 1)
					return false;
			} else {
				break;
			}
		}

		return true;
	}

	public static void main(String[] s) {

		System.out.println(new Leecode51().totalNQueens(5));

	}
}
