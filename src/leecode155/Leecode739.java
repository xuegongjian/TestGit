package leecode155;

import java.util.Stack;

public class Leecode739 {
	public int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		for (int i = 1; i < T.length; i++) {
			int cur = stack.peek();
			
			while (!stack.isEmpty() && T[cur] < T[i]) {
				stack.pop();
				result[cur] = i - cur;
				cur = stack.peek();
			}
			stack.add(i);
		}
		return result;

	}

	public static void main(String[] s) {
//		System.out.println(new Leecode739().leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));

	}
}
