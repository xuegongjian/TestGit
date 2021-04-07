package leecode155;

import java.util.HashMap;
import java.util.Map;

public class Leecode992 {
	public boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s1.length() == 0) {
			return false;
		}
		int[] dict1 = new int[26];
		for (char c : s1.toCharArray()) {
			dict1[c - 'a']++;
		}
		int[] dict2 = new int[26];
		int start = 0;
		int end = 0;
		while (end < s2.length()) {
			dict2[s2.charAt(end) - 'a']++;
			if (dict2[s2.charAt(end) - 'a'] > dict1[s2.charAt(end) - 'a']) {
				if (dict1[s2.charAt(end) - 'a'] == 0) { // 说明1里不存在，直接跳过
					dict2 = new int[26];
					end = end + 1;
					start = end;
					continue;
				} else {
					// left前移
					for (; start < end; start++) {
						if (s2.charAt(start) == s2.charAt(end)) {
							break;
						} else {
							dict2[s2.charAt(start) - 'a']--;
						}
					}
					start++;
					dict2[s2.charAt(end) - 'a']--;

				}
			} else if (dict2[s2.charAt(end) - 'a'] == dict1[s2.charAt(end) - 'a']) {
				boolean isMatch = true;
				for (int i = 0; i < 26; i++) {
					if (dict1[i] != dict2[i]) {
						isMatch = false;
						break;
					}
				}
				if (isMatch) {
					return true;
				}
			}
			end++;
		}

		return false;
	}
}
