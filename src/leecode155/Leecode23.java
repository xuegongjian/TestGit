package leecode155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leecode23 {
	 public List<List<Integer>> threeSumClosest(int[] nums, int target) {
		
		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length-2; i++){
            if(i> 0 && nums[i] == nums[i-1]){
				continue;
			}
			int current = -nums[i];
			int left =  i+1;
			int right = nums.length-1;
			while(left < right){
				if(nums[left] + nums[right] == current){
					List<Integer> dd = new ArrayList<>();
					dd.add(nums[i]);
					dd.add(nums[left]);
					dd.add(nums[right]);
					results.add(dd);
					int curLeft = nums[left];
					while(left < nums.length && curLeft == nums[left]){
						left++;
					}
					int curright = nums[right];
					while(left < right && curright == nums[right]){
						right--;
					}
				} else if(nums[left] + nums[right] < current){
					int curLeft = nums[left];
					while(left < nums.length && curLeft == nums[left]){
						left++;
					}
				} else {
					int curright = nums[right];
					while(left < right && curright == nums[right]){
						right--;
					}
				}
			}
		}
		return results;
	}

	public static void main(String[] s) {

//		System.out.println(new Leecode23().generateParenthesis(3));

	}
}
