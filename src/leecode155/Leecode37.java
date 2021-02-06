package leecode155;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leecode37 {
	boolean first = true;
	int empNum = 0;

	public void solveSudoku(char[][] board) {
		doSolveSudoku(board);
	}

	public boolean doSolveSudoku(char[][] board) {
		if (!first && empNum == 0) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board[i][j] == '.') {
						return false;
					}
				}
			}
			return true;
		}

		Map<String, Object> map = next(board);
		if (null == map) {
			return false;
		}
		first = false;
		int[] cor = (int[]) map.get("cor");
		Set<Character> candidate = (Set<Character>) map.get("set");
		
		for (Character ch : candidate) {
			board[cor[0]][cor[1]] = ch;
			empNum--;
			if (doSolveSudoku(board)) {
				return true;
			}
			board[cor[0]][cor[1]] = '.';
			empNum++;
		}
		return false;
	}

	public Map<String, Object> next(char[][] board) {
		Set<Character> candidate = new HashSet<>();
		int max = 9;
		int tmpI = 0;
		int tmpJ = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					if (first) {
						empNum++;
					}
					Set<Character> currnetSet = get(i, j, board);
					if (currnetSet.size() == 0) {
						return null;
					}
					if (currnetSet.size() < max) {
						max = currnetSet.size();
						candidate = currnetSet;
						tmpI = i;
						tmpJ = j;
					}
					
				}
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("cor", new int[] { tmpI, tmpJ });
		map.put("set", candidate);
		return map;
	}

	public Set<Character> get(int i, int j, char[][] board) {
		Set<Character> candidate = new HashSet<>();
		candidate.add('1');
		candidate.add('2');
		candidate.add('3');
		candidate.add('4');
		candidate.add('5');
		candidate.add('6');
		candidate.add('7');
		candidate.add('8');
		candidate.add('9');

		for (int k = 0; k < 9; k++) {
			if (board[i][k] != '.') {
				candidate.remove(board[i][k]);
			}
			if (board[k][j] != '.') {
				candidate.remove(board[k][j]);
			}
		}

		// 当前格子内
		int gridx = (i / 3) * 3;
		int gridy = (j / 3) * 3;

		for (int k = 0; k < 3; k++) {
			for (int t = 0; t < 3; t++) {
				if (board[k + gridx][t + gridy] != '.') {
					candidate.remove(board[k + gridx][t + gridy]);
				}
			}
		}
		return candidate;
	}

	public static void main(String[] s) {
		char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		new Leecode37().solveSudoku(board);

	}
}
