package leecode155;

import java.util.HashMap;
import java.util.Map;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class Leecode76 {
	public String minWindow(String s, String t) {
		if (t.length() == 0 || s.length() == 0) {
			return "";
		}
		String re = "";
		int minLength = s.length()+1;
		Map<Character, Integer> cntMap = new HashMap<>();
		for (Character c : t.toCharArray()) {
			cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
		}

		int start = 0;
		int end = 0;
		Map<Character, Integer> cmpMap = new HashMap<>();
		while (end < s.length()) {
			Character c = s.charAt(end);
			if (!cntMap.containsKey(c)) {
				if (cmpMap.isEmpty()) {
					start++;
				}
				end++;
				continue;
			}
			int orgCnt = cntMap.get(c);
			int nowCnt = cmpMap.getOrDefault(c, 0) + 1;
			cmpMap.put(c, nowCnt);

			if (orgCnt == nowCnt) {
				if (contain(cmpMap, cntMap)) {
					if (end - start + 1 < minLength) {
						re = s.substring(start, end - start + 1);
						minLength = end - start + 1;
					}
					
					int first = cmpMap.get(s.charAt(start));
					cmpMap.put(s.charAt(start), first - 1);
					start++;
					// 移动左边
					while (start < end) {
						if (!cmpMap.containsKey(s.charAt(start))) {
							start++;
							continue;
						}
						int cc = cmpMap.get(s.charAt(start));
						if (cc > cntMap.get(s.charAt(start))) {
							cmpMap.put(s.charAt(start), cc - 1);
							start++;
							continue;
						}
						break;

					}
				}
			}
			if (orgCnt < nowCnt) {
				// 移动左边
				while (start < end) {
					if (!cmpMap.containsKey(s.charAt(start))) {
						start++;
						continue;
					}

					int cc = cmpMap.get(s.charAt(start));
					if (cc > cntMap.get(s.charAt(start))) {
						cmpMap.put(s.charAt(start), cc - 1);
						start++;
						continue;
					}
					break;

				}
			}

			end++;
		}

		return re;
	}

	private boolean contain(Map<Character, Integer> cmpMap, Map<Character, Integer> cntMap) {
		boolean found = true;
		for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
			if (cmpMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
				found = false;
				break;
			}
		}
		return found;
	}

	public static void main(String[] args) {
		System.out.println(new Leecode76().minWindow("abc","ac"));
	}
}
