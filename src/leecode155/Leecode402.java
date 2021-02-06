package leecode155;

import java.util.Stack;

public class Leecode402 {
	public String removeKdigits(String num, int k) {
		if (num.length() <= k) {
			return "0";
		}
		if (k == 0) {
			return num;
		}

		Stack<Character> stack = new Stack<Character>();
		int removeIndex = 0;
		int i = 0;
		for (;i<num.toCharArray().length; i++) {
			char c = num.charAt(i);
			if (stack.isEmpty()) {
				stack.add(c);
			} else {
				while (!stack.isEmpty() && stack.peek() > c && removeIndex < k) {
					stack.pop();
					removeIndex++;
				}
				stack.add(c);
			}
		}
		
		while(removeIndex < k){
			stack.pop(); //移除最后的
			removeIndex++;
		}
		
		String s = "";
		while(!stack.isEmpty()){
			s = s + stack.pop();
		}
		i = 0;
		boolean continous = false;
		for(char c : s.toCharArray()){
			if(c == '0' && i == 0){
				continous = true;
				i++;
				continue;
			}
			if(continous && c == '0'){
				i++;
				continue;
			}
			break;
		}
		
		return s.substring(i);
	}

	public static void main(String[] s) {

		System.out.println(new Leecode402().removeKdigits("10200",2));

	}
}
