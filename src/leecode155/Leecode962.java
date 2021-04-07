package leecode155;

import java.util.Arrays;

public class Leecode962 {
	public int maxWidthRamp(int[] A) {
		if (A == null) {
			return 0;
		}
		int N = A.length;
		Integer[] B = new Integer[A.length];
		for (int i = 0; i < A.length; i++) {
			B[i] = i;
		}

		Arrays.sort(B, (i, j) -> {
			return A[i] - A[j];
		});

		int ans = 0;
        int m = N;
        for (int i: B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;

		

	}

	public static void main(String[] args) {
		int[] tokens = new int[] {1,2,3,4,5};
		int P = 73;
		 System.out.println(new Leecode962().maxWidthRamp(tokens));

	}
}
