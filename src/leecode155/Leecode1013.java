package leecode155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leecode1013 {
	Set<Integer> set = new HashSet<>();

	public boolean canThreePartsEqualSum(int[] A) {

		if (null == A)
			return true;
		int total = 0;
		for (int num : A) {
			total = total + num;
		}
		if (total % 3 != 0)
			return false;

		int target = total / 3;
		 Arrays.sort(A);
		int[] candidates = A;
		
		List<Integer> currentComs = new ArrayList<>();
		currentComs.add(candidates.length-1);
		boolean result = backTrace(candidates, currentComs, candidates.length-2, target - candidates[candidates.length-1]);
		if(result){
			int size = A.length-currentComs.size();
			if(size <2 ) return false;
			candidates = new int[A.length-currentComs.size()];
			
			int index = 0;
			for(int i = 1; i <A.length; i++){
				if(!set.contains(i)){
					candidates[index++]=A[i];
				}
			}
			set.clear();
			currentComs.clear();
			currentComs.add(candidates.length-1);
			return backTrace(candidates, currentComs, candidates.length-2, target - candidates[candidates.length-1]);
			
		}
		
		
		return result;
	}

	private boolean backTrace(int[] candidates, List<Integer> currentComs, int nextStep, int target) {
		if (target == 0) {
			set.addAll(currentComs);
			return true;
		}
		for (int i = nextStep; i >= 0; i--) {
			currentComs.add(i);
			boolean result = backTrace(candidates, currentComs, i - 1, target - candidates[i]);
			if (result) {
				return result;
			}
			currentComs.remove(currentComs.size() - 1);
		}
		return false;
	}

	

	public static void main(String[] s) {

		System.out.println(new Leecode1013().canThreePartsEqualSum(new int[] {0,2,1,-6,6,7,9,-1,2,0,1}));

	}
}
