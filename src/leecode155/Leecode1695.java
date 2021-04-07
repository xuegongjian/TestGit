package leecode155;

import java.util.HashSet;
import java.util.Set;

public class Leecode1695 {
	public int maximumUniqueSubarray(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		int start = 0;
		int end = 0;
		int n = nums.length;
		Set<Integer> set =  new HashSet<Integer>();
		int max = 0 ;
		int curValue = 0;
		while(end < n){
			int value = nums[end];
			if(set.contains(value)){
				while(nums[start] != value){
					curValue = curValue - nums[start];
					start++;
					set.remove(nums[start]);
				}
				start++;
			} else {
				curValue = curValue + value;
				max = Math.max(max, curValue);
			}
			set.add(value);
			end++;
		}
		return max;
    }

	public static void main(String[] s) {
//		System.out.println(new Leecode739().leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));

	}
}
