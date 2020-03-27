package leecode155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leecode39 {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (null == candidates)
			return null;
		Arrays.sort(candidates);

		for (int i = 0; i < candidates.length; i++) {
			if (target - candidates[i] < 0) {
				break;
			}
			List<Integer> currentComs = new ArrayList<>();
			currentComs.add(candidates[i]);
			backTrace(candidates, currentComs, i, target - candidates[i]);
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
            
			currentComs.add(candidates[i]);
			backTrace(candidates, currentComs, i, target - candidates[i]);
			currentComs.remove(currentComs.size() - 1);
		}
	}

	private void getKey(List<Integer> currentComs) {
		result.add(new ArrayList<>(currentComs));
	}

	public static void main(String[] s) {

		System.out.println(new Leecode39().combinationSum(new int[] { 10, 1, 2, 7, 6, 5 }, 8));

	}
}
