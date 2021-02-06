package leecode155;

public class Leecode97 {
	public boolean isInterleave(String s1, String s2, String s3) {
		int k = s3.length();
		int m = s1.length();
		int n = s2.length();

		if (k != m + n) {
			return false;
		}
		StringBuilder sb = new StringBuilder();

		int j = 0;
		int i = 0;
		while (i < m && j < k) {
			if (s3.charAt(j) == s1.charAt(i)) {
				i++;
				j++;
				continue;
			} else {
				sb.append(s3.charAt(j));
				j++;
			}
		}
		if(i==m){
			while (j < k) {
				sb.append(s3.charAt(j));
				j++;
			}
		}
		boolean result =  i==m && sb.toString().equals(s2);
		if(result){
			return result;
		}
		
		sb.setLength(0);
		j = k-1;
		i = m-1;
		while (i >= 0 && j >= 0) {
			if (s3.charAt(j) == s1.charAt(i)) {
				i--;
				j--;
				continue;
			} else {
				sb.append(s3.charAt(j));
				j--;
			}
		}
		if(i==-1){
			while (j >= 0) {
				sb.append(s3.charAt(j));
				j++;
			}
		}
		return  i==-1 && sb.reverse().toString().equals(s2);
	}

	public static void main(String[] s) {
		// System.out.println(new Leecode11().findTargetSumWays(new
		// int[]{1,1,1,1,1},5));

	}
}
