package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {

	public int assignBikes(int[][] workers, int[][] bikes) {
		Set<int[]>set=new	HashSet<int[]>();
		
		List<int[]>workerlist=	Arrays.asList(workers);
		List<int[]>bikeList=	Arrays.asList(bikes);
		
		workerlist.sort(new	Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0]==0?o1[1]-o2[1]:o1[0]-o2[0];
			}
				
		});
		
		bikeList.sort(new	Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0]==0?o1[1]-o2[1]:o1[0]-o2[0];
			}
				
		});
		
		
		int tatol = 0;
		  for (int[] worker : workerlist) {
		
			int max = Integer.MAX_VALUE;
			int[]	currentWorker=null;
			for (int[] bike : bikeList) {
            	if(set.contains(bike)){
            		continue;
            	}
				int distance = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
				if (distance < max) {
					max = distance;
					currentWorker=bike;
				}
			}
            set.add(currentWorker);
			tatol = max + tatol;
		}
		return	tatol;
	}

	public static void main(String[] arg) {
		Double	a=Double.valueOf(1.0-0.4);

		Double	b=Double.valueOf("0.4");
		System.out.println(a.equals(b));
	}
}
