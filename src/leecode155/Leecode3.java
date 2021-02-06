package leecode155;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Leecode3 {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;

		Set<Character> valueSet = new LinkedHashSet<>();
		int max = 0;
		int count = 0;
		for (char c : s.toCharArray()) {
			if (valueSet.contains(c)) {
				max = Math.max(max, count);
				// 先调整indexMap
				Iterator<Character> iterator = valueSet.iterator();
				while (iterator.hasNext()) {
					Character t = iterator.next();
					iterator.remove();
					count = count - 1;
					if (c == t) {
						break;
					}
				}
			}
			valueSet.add(c);
			count = count + 1;

		}
		return Math.max(max, count);
	}

	public static void main(String[] s) {
		System.out.println(new Leecode3().lengthOfLongestSubstring("ohomm"));

	}
}
