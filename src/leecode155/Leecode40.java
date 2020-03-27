package leecode155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leecode40 {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (null == candidates)
			return null;
		Arrays.sort(candidates);

		for (int i = 0; i < candidates.length; i++) {
			if (target - candidates[i] < 0) {
				break;
			}
            if(i> 0 && candidates[i] == candidates[i-1]){
                continue;
            }
			List<Integer> currentComs = new ArrayList<>();
			currentComs.add(candidates[i]);
			backTrace(candidates, currentComs, i+1, target - candidates[i]);
		}
		return result;
	}

	private void backTrace(int[] candidates, List<Integer> currentComs, int nextStep, int target) {
		if (target == 0) {
			getKey(currentComs);
			return;
		}
		for (int i = nextStep; i < candidates.length; i++) {
			if (target - candidates[i] < 0) {
				return;
			}

            if(i> nextStep && candidates[i] == candidates[i-1]){
                continue;
            }
            
			currentComs.add(candidates[i]);
			backTrace(candidates, currentComs, i + 1, target - candidates[i]);
			currentComs.remove(currentComs.size() - 1);
		}
	}

	private void getKey(List<Integer> currentComs) {
		result.add(new ArrayList<>(currentComs));
	}

	public static void main(String[] s) {

		System.out.println(new Leecode40().combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));

	}
}
