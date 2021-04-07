package leecode155;

public class Leecode466 {
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		int index = 0; // 匹配s2字符串中的位置
		int cnt = 0; // 出现的总次数
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < arr1.length; j++) {
				if (arr1[j] == arr2[index]) {
					index++;
				}
				// 匹配一个，重置s2
				if (index == arr2.length) {
					index = 0;
					++cnt;
				}
			}
		}
		return (cnt / n2);
	}
}
