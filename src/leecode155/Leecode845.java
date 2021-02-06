package leecode155;

public class Leecode845 {
	public int longestMountain(int[] A) {
		if (null == A || A.length == 0) {
			return 0;
		}
		int max = 0;
		int currentIndex = 0;
		boolean isLeft = true;
		boolean canM = false;
		for (int i = 0; i < A.length - 1; i++) {
			if (isLeft) {
				if (A[i] < A[i + 1]) {
					canM = true;
				} else if (A[i] == A[i + 1]) {
					currentIndex = i + 1;
					canM = false;
				} else {
					if (canM) {
						isLeft = false;
						max = Math.max(i - currentIndex + 2, max);

					} else {
						currentIndex = i + 1;
					}
				}
			} else {
				if (A[i] > A[i + 1]) {
					if (i == A.length - 2) {
						max = Math.max(i - currentIndex + 2, max);
					} else {
						max = Math.max(i - currentIndex + 1, max);
					}
				} else if (A[i] == A[i + 1]) {
					currentIndex = i + 1;
					isLeft = true;

				} else {
					max = Math.max(i - currentIndex + 1, max);
					currentIndex = i;
					isLeft = true;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] A = { 875,884,239,731,723,685};
		System.out.println(new Leecode845().longestMountain(A));
	}
}
