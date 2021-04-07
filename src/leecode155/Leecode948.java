package leecode155;

import java.util.Arrays;

public class Leecode948 {
	public int bagOfTokensScore(int[] tokens, int P) {
		Arrays.sort(tokens);
		if (null == tokens || tokens.length == 0 || tokens[0] > P) {
			return 0;
		}
		int cnt = 0;
		int current = 0;
		int last = tokens.length - 1;
		for (int i = 0; i <= last; i++) {
			if (P >= tokens[i]) {
				current = current + 1;
				P = P - tokens[i];
				cnt = Math.max(cnt, current);
			} else if (i < last && current > 0) {
				P = P + tokens[last];
				last = last - 1;
				current = current - 1;
				i = i - 1;
			} else {
				break;
			}
		}

		return cnt;

	}

	public static void main(String[] args) {
		int[] tokens = new int[] { 81, 91, 31 };
		int P = 73;
		System.out.println(new Leecode948().bagOfTokensScore(tokens, P));

	}
}
