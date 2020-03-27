package leecode155;

import java.util.Arrays;

public class Leecode945 {
	public int minIncrementForUnique(int[] A) {
		// 防止都是40000
		int[] tmp = new int[80000];
		for (int i = 0; i < A.length; i++) {
			tmp[A[i]] = tmp[A[i]] + 1;
		}
		int N = A.length;
		int start = 0;
		int times = 0;
		for (int i = 0; i < tmp.length; i++) {
			if(start == N) break;
			if(tmp[i]==1) {
				start = start + 1;
				continue;
			}
			if(tmp[i]==0) {
				continue;
			}
			while(tmp[i]> 1){
				for(int j = i+1;j<tmp.length;j++){
					if(tmp[j] == 0){
						times = times + (j-i);
						tmp[j] = 1;
						break;
					}
				}
				tmp[i] = tmp[i] - 1;
			}
			start = start + 1;
		}
		return times; 
	}

	public static void main(String[] s) {
		new Leecode945().minIncrementForUnique(new int[] { 37,19,20,13,26,36,34,23,2,46,20,19,0,6,43,25,36,7,16,42,41,12,1,40,8,39,34,8,3,46,29,31,22,7,30,12,40,36,1,46,1,4,14,7,11,17,36,20,13,24});
	}
}
