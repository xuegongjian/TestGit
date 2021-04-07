package leecode155;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leecode1423 {

	public int maxScore(int[] cardPoints, int k) {
		if (cardPoints == null || cardPoints.length == 0) {
			return 0;
		}

		int n = cardPoints.length;

		int maxSum = 0;
		for (int i = 0; i < k && i < n; i++) {
			maxSum = maxSum + cardPoints[i];
		}
		if (k >= n) {
			return maxSum;
		}
		if (k == 1) {
			return Math.max(cardPoints[0], cardPoints[n - 1]);
		}
		int sum = maxSum;
		int totalStep = 0;
		int right = k;
		int left = 1;
		while (totalStep < 2 * n) {
			int lastLeft = 0;
			if(left == 0){
				lastLeft = cardPoints[n-1];
			} else {
				lastLeft = cardPoints[left-1];
			}
			
			sum = sum + cardPoints[right] - lastLeft;
			if (left > 0 && right != n - 1 && right > left) {

			} else {
				maxSum = Math.max(sum, maxSum);
			}

			if (left == n - 1) {
				left = 0;
			} else {
				left++;
			}
			// 如果不加加和先前一样
			if (right == n - 1) {
				right = 0;
			} else {
				right++;
			}

			totalStep++;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] cardPoints = new int[] { 1, 2, 3, 4, 5, 6, 1 };
		int k = 3;
		System.out.println(new Leecode1423().maxScore(cardPoints, k));
	}
}
