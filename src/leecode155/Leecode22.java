package leecode155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Leecode22 {
	private Map<Integer, List<String>> map = new HashMap<>();

	public List<String> generateParenthesis(int n) {
		if (n == 1)
			return Arrays.asList("()");
		if (n == 2)
			return Arrays.asList("()()", "(())");

		map.put(1, new ArrayList<String>(Arrays.asList("()")));
		map.put(2, new ArrayList<String>(Arrays.asList("(())", "()()")));

		List<String> set = generate(n);
		return new ArrayList<String>(new HashSet<String>(set));

	}

	private List<String> generate(int n) {
		List<String> newList = map.get(n);
		if (null != newList)
			return newList;
		newList = new ArrayList<String>();
		for (int i = 1; i < n; i++) {
			newList.addAll(merge(generate(i), generate(n - i)));
		}
		List<String> set = generate(n - 1);
		for (String str : set) {
			newList.add("(" + str + ")");
		}

		map.put(n, newList);
		return newList;
	}

	private List<String> merge(List<String> list1, List<String> list2) {
		List<String> newList = new ArrayList<String>();
		for (String str : list1) {
			for (String str1 : list2) {
				newList.add(str + str1);
			}
		}
		return newList;
	}

	public static void main(String[] s) {

		System.out.println(new Leecode22().generateParenthesis(3));

	}
}
