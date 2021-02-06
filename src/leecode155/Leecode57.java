package leecode155;

import java.util.Stack;

import javafx.util.Pair;

public class Leecode57 {
	public int longestValidParentheses(String s) {
		if (null == s)
			return 0;
		int max = 0;

		int currentLeftNum = 0;
		Stack<Pair<Integer, Character>> stack = new Stack<>();
		stack.add(new Pair<>(-1,'1'));
		for (int i = 0; i < s.toCharArray().length; i++) {
			char v = s.charAt(i);
			if (v == '(') {
				Pair<Integer, Character> pair = new Pair<>(i, v);
				stack.add(pair);
				currentLeftNum++;
			} else {
				if (currentLeftNum > 0) {
					stack.pop();
					currentLeftNum--;
					max = Math.max(max, i-stack.peek().getKey());
				} else {
					stack.clear();
					stack.add(new Pair<>(i,'1'));
				}
			}
		}

		return max;
	}

	public static void main(String[] s) {
		System.out.println(new Leecode57().longestValidParentheses("()(()"));

	}
}
