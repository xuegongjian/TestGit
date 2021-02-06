package leecode155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leecode16 {
	public int threeSumClosest(int[] nums, int target) {
		
		int result = Integer.MAX_VALUE;
		int retVal = 0;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length-2; i++){
            if(i> 0 && nums[i] == nums[i-1]){
				continue;
			}
			int current = target - nums[i];
			int left =  i+1;
			int right = nums.length-1;
			while(left < right){
				if(nums[left] + nums[right] == current){
					return target;
				} else if(nums[left] + nums[right] < current){
					if(result >  Math.abs(current - (nums[left] + nums[right]))) {
						result = Math.abs(current - (nums[left] + nums[right]));
						retVal = nums[i] + nums[left] + nums[right];
					}
					
					int curLeft = nums[left];
					while(left < nums.length && curLeft == nums[left]){
						left++;
					}
				} else {
					if(result >  Math.abs(current - (nums[left] + nums[right]))) {
						result = Math.abs(current - (nums[left] + nums[right]));
						retVal = nums[i] + nums[left] + nums[right];
					}
					
					
					int curright = nums[right];
					while(left < right && curright == nums[right]){
						right--;
					}
				}
			}
		}
		return retVal;
	}

	public static void main(String[] s) {

//		System.out.println(new Leecode23().generateParenthesis(3));

	}
}
