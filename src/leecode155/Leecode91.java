package leecode155;

public class Leecode91 {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.startsWith("0"))
			return 0;
		int[] dp = new int[s.length() + 1];
		dp[s.length()] = 1;
		boolean isLastZero = false;
		boolean isLastThanSix = false;
		boolean notAdd = true; // 不能合并
		for (int i = s.length() - 1; i >= 0; i--) {
			dp[i] = dp[i + 1];
			if (isLastZero) {
				if (Integer.parseInt(String.valueOf(s.charAt(i))) == 1
						|| Integer.parseInt(String.valueOf(s.charAt(i))) == 2) {
					dp[i] = dp[i + 1];
					isLastZero = false;
					isLastThanSix = true;
					notAdd = true;
					continue;
				} else {
					return 0;
				}
			} else if (notAdd) {
				dp[i] = dp[i + 1];
			} else {
				if (Integer.parseInt(String.valueOf(s.charAt(i))) == 1 && i < s.length() - 1) {
					dp[i] = dp[i + 1] + dp[i + 2];
				} else if (Integer.parseInt(String.valueOf(s.charAt(i))) == 2 && i < s.length() - 1) {
					if (isLastThanSix) {
						dp[i] = dp[i + 1];
					} else {
						dp[i] = dp[i + 1] + dp[i + 2];
					}
				}
			}
			isLastZero = isLastThanSix = notAdd = false;
			if (Integer.parseInt(String.valueOf(s.charAt(i))) > 6) {
				isLastThanSix = true;
			}

			if (Integer.parseInt(String.valueOf(s.charAt(i))) == 0) {
				isLastZero = true;
			}

		}
		return dp[0];
	}

	public static void main(String[] s) {
		System.out.println(Integer.parseInt(String.valueOf('1')));

	}
}
