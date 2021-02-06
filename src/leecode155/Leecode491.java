package leecode155;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leecode491 {
	List<List<Integer>> results = new ArrayList<>();
	Set<String> set = new HashSet<>();
	public List<List<Integer>> findSubsequences(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(nums[i]);
			dfs(nums, tmp, i);
		}
		return results;
	}

	private void dfs(int[] nums, List<Integer> tmp, int index) {
		if (tmp.size() > 1) {
			String key = key(tmp);
			if(!set.contains(key)){
				set.add(key);
				results.add(new ArrayList<>(tmp));
			}
			
		}
		for (int i = index + 1; i < nums.length; i++) {
			if (tmp.get(tmp.size() - 1) <= nums[i]) {
				tmp.add(nums[i]);
				dfs(nums, tmp, i);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
	
	private String key(List<Integer> tmp){
		StringBuilder sb = new StringBuilder();
		for(int value : tmp){
			sb.append(value).append("_");
		}
		return sb.toString();
	}

	public static void main(String[] s) {
		System.out.println(new Leecode491().findSubsequences(new int[] {4, 6, 7, 7}));

	}
}
