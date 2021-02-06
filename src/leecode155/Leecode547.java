package leecode155;

import java.util.List;

public class Leecode547 {
	public int findCircleNum(int[][] M) {
		if(null == M) return 0;
		int[] unfind=new int[M.length];
		for(int i=0;i<M.length; i++){
			unfind[i]=i;
		}
		for(int i = 0; i < M.length; i++){
			for(int j = 0; j< M.length; j++){
				if(M[i][j] == 1){
					
					union(i,j,unfind);
					
				}
			}
		}
		int cnt =0;
		for(int i=0;i<M.length; i++){
			if(i==unfind[i]){
				cnt++;
			}
		}
		return cnt;
		
    }
	public void union(int i, int j, int[] unfind){
		while(unfind[i] != i){
			i=unfind[unfind[i]];
		}
		
		while(unfind[j] != j){
			j=unfind[unfind[j]];
		}
		
		unfind[j] = i;
		
	}
	

	public static void main(String[] s) {
		// System.out.println(new Leecode120().isMatch("aab", "c*a*b"));

	}
}
