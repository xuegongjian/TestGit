package leecode155;

import java.util.TreeMap;

public class Leecode1438 {
//	public int longestSubarray(int[] nums, int limit) {
////		int n = nums.length;
////		if (n == 0) {
////			return 0;
////		}
////		int start = 0;
////		int end = 0;
//		
//		
//		
////		TreeMap<Integer, Integer> map = new TreeMap<>();
////		int maxLength = 0;
////		while (end < n) {
////			int curValue = nums[end];
////			map.put(curValue, map.getOrDefault(curValue, 0) + 1);
////			while (map.lastKey() - map.firstKey() > limit) {
////				int value = map.get(nums[start]);
////				if(value ==1) {
////					map.remove(nums[start]);
////				} else{
////					map.put(nums[start], value - 1);
////				}
////				start++;
////			}
////            maxLength = Math.max(maxLength, end - start + 1);
////			end++;
////		}
////		return maxLength;
//	}

	public static void main(String[] s) {
		// System.out.println(new Leecode739().leastInterval(new char[] { 'A',
		// 'A', 'A', 'B', 'B', 'B' }, 2));

	}
}
