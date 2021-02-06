package leecode155;

import java.util.List;

public class Leecode1319 {
	public int makeConnected(int n, int[][] connections) {
		if(null == connections){
			return -1;
		}
		if(connections.length < n-1) {
			return -1;
		}
		int[] unionFind = new int[n];
		for(int i =0; i<   n; i++){
			unionFind[i] = i;
			
		}
		
		for(int i = 0; i < connections.length; i++){
			merge(unionFind,connections[i][0],connections[i][1]);
		}
		int cnt = 0;
		for(int i =0; i<  n; i++){
			if(unionFind[i] == i){
				cnt++;
			}
		}
		
		return cnt-1;
		
		
		
    }
	
	private void merge(int[] unionFind, int a, int b){
		
		while(unionFind[a] != a){
			a =unionFind[a];
		}
		
		while(unionFind[b] != b){
			b =unionFind[b];
		}
		
		unionFind[b] = a;
	}
	

	public static void main(String[] s) {
		// System.out.println(new Leecode120().isMatch("aab", "c*a*b"));

	}
}
