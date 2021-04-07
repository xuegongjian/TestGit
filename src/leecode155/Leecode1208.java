package leecode155;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leecode1208 {

	public int equalSubstring(String s, String t, int maxCost) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();
		int right = 0;
		int left = 0;
		int sum = 0;
		int maxLength = 0;
		while (right < n) {
			sum = sum + Math.abs(s.charAt(right) - t.charAt(right));
			if (sum > maxCost) {
				sum = sum - Math.abs(s.charAt(left) - t.charAt(left));
				left++;
			} else {
				maxLength = Math.max(maxLength, right - left + 1);
			} 
			//如果不加加和先前一样
			right++;
		}

		return maxLength;
	}

	public static void main(String[] args) {

//		System.out.println(new Leecode1208().smallestSubsequence("bcbcababa"));
	}
}
