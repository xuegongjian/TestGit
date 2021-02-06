package leecode155;

public class Leecode959 {

	public static final int[][] DIRECTION = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int regionsBySlashes(String[] grid) {
		if (null == grid) {
			return 0;
		}
		char[][] charGrid = new char[grid.length][grid[0].length()];

		boolean[][] visit = new boolean[grid.length][grid[0].length()];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].toCharArray().length; j++) {
				charGrid[i][j] = grid[i].charAt(j);
			}
		}
		int cnt = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < charGrid[0].length; j++) {
				if (!visit[i][j] && charGrid[i][j] == ' ') {
					cnt++;
                    dfs(charGrid,visit,i,j,grid.length);
				}
			}
		}
		return cnt;
	}

	public void dfs(char[][] charGrid, boolean[][] visit, int i, int j, int length) {
		if (!visit[i][j] && charGrid[i][j] == ' ') {
			visit[i][j] = true;
			for (int k = 0; k < 4; k++) {
				if(DIRECTION[k][0] + i < 0 || DIRECTION[k][0] + i >= length){
					continue;
				}
				
				if(DIRECTION[k][1] + j < 0 || DIRECTION[k][1] + j >= length){
					continue;
				}
				dfs(charGrid,visit,DIRECTION[k][0] + i,DIRECTION[k][1] + j,length);
			}
		}
	}

	public static void main(String[] args) {
		String[] s = new String[]{"\\/","/\\"};
		System.out.println(new Leecode959().regionsBySlashes(s));

	}
}
