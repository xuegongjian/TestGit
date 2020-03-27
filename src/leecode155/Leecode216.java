package leecode155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leecode216 {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum3(int target,int k) {
		int [] candidates =  new int[]{1,2,3,4,5,6,7,8,9};
		for (int i = 0; i < candidates.length; i++) {
			if (target - candidates[i] < 0) {
				break;
			}
			List<Integer> currentComs = new ArrayList<>();
			currentComs.add(candidates[i]);
			backTrace(candidates, currentComs, i+1, target - candidates[i],k);
		}
		return result;
	}

	private void backTrace(int[] candidates, List<Integer> currentComs, int nextStep, int target, int k) {
		if (target == 0) {
			if(currentComs.size()== k){
				getKey(currentComs);
			}
			return;
		}
		for (int i = nextStep; i < candidates.length; i++) {
			if (target - candidates[i] < 0) {
				return;
			}
			if(currentComs.size()== k) return;
			currentComs.add(candidates[i]);
			backTrace(candidates, currentComs, i + 1, target - candidates[i], k);
			currentComs.remove(currentComs.size() - 1);
		}
	}

	private void getKey(List<Integer> currentComs) {
		result.add(new ArrayList<>(currentComs));
	}

	public static void main(String[] s) {

		System.out.println(new Leecode216().combinationSum3(9,3));

	}
}
