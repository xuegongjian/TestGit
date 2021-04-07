package leecode155;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leecode395 {
	public int longestSubstring(String s, int k) {
		if (k == 1) {
			return s.length();
		}
		int[] std = new int[26];
		for (char c : s.toCharArray()) {
			std[c - 'a']++;
		}
		int start = 0;
		int end = 0;

		int n = s.length();
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();

		while (end < n) {
			char c = s.charAt(end);
			if (std[c - 'a'] < k) {
				end++;
				start = end;
				map.clear();
				continue;
			}
			int value = map.getOrDefault(c, 0);
			value++;
			map.put(c, value);
			if (value >= k) {
				boolean all = true;
                for(int perValue : map.values()){
                   if(perValue < k){
                       all = false;
                       break;
                   }
               }
               if(all){
                   max =  Math.max(max,end-start+1);
               }else {
					//
            	   if(end-start+1 > max){
            		   max = Math.max(max ,longestSubstring(s.substring(start,end-start+1),k));
            	   }
				}

			}
			end++;
		}
		return max;
	}

	public static void main(String[] s) {
		 int mask = 0;
		 System.out.println(mask | (1<<2));
		// System.out.println(new Leecode739().leastInterval(new char[] { 'A',
		// 'A', 'A', 'B', 'B', 'B' }, 2));

	}
}
