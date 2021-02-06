package leecode155;

import java.util.HashSet;
import java.util.Set;

public class Leecode424 {
	public int characterReplacement(String s, int k) {
		if (null == s) {
			return 0;
		}
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.toCharArray().length; i++) {
			set.add(s.charAt(i));
		}
		
		int maxLength  = 0;
		for(char c : set) {
			int[] length = new int[s.length()];
			int maxDif = 0;
			for (int i = 0; i < s.toCharArray().length; i++) {
				if (s.charAt(i) != c) {
					length[maxDif] = i + 1;
					maxDif++;
				}
			}
			if (maxDif <= k) {
				return s.length();
			}
			maxLength = Math.max(length[k] ,maxLength);
			for (int i = k; i < maxDif; i++) {
				if (i < maxDif - 1) {
					maxLength = Math.max(length[i + 1] - length[i - k] - 1, maxLength);
				} else {
					maxLength = Math.max(s.length() - length[i - k] - 1 , maxLength);
				}
			}
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		String s = "ABAA";
		int k = 0;
		
		System.out.println(new Leecode424().characterReplacement(s,k));

	}
}
