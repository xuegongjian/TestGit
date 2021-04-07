package leecode155;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leecode1081 {

	public String smallestSubsequence(String s) {
		if (null == s || "".equals(s)) {
			return s;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char v = s.charAt(i);
			Integer cnt = map.get(v);
			if (null != cnt) {
				map.put(v, cnt + 1);
			} else {
				map.put(v, 1);
			}
		}
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char v = s.charAt(i);
			while (true) {
				if (stack.isEmpty()) {
					stack.add(v);
					sb.append(v);
					break;
				} else {
					char topValue = stack.peek();
					if (sb.toString().indexOf(v) > -1) {
						map.put(v, map.get(v)-1);
						break;
					}
					int cnt = map.get(topValue);
					if (cnt == 1) {
						stack.add(v);
						sb.append(v);
						break;
					}
					if (topValue < v) {
						stack.add(v);
						sb.append(v);
						break;
					} else if (cnt > 1) {
						sb.setLength(sb.length() - 1);
						stack.pop();
						cnt = cnt - 1;
						map.put(topValue, cnt);
					}
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(new Leecode1081().smallestSubsequence("bcbcababa"));
	}
}
