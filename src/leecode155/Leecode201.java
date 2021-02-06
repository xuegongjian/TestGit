package leecode155;

import java.util.Arrays;

public class Leecode201 {
	public int rangeBitwiseAnd(int m, int n) {
		if(m==n) return m;
		int k = 0;
		while (m > 0) {
			m = m >> 1;
			k++;
		}
		int f = 0;
		while (n > 0) {
			n = n >> 1;
			f++;
		}
		if (k == f) {
			return 1 << (f - 1);
		} else {
			return 0;
		}

	}

	public static void main(String[] s) {
		System.out.println(new Leecode201().rangeBitwiseAnd(0, 1));
	}
}
