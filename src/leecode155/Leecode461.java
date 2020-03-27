package leecode155;

import java.util.ArrayList;
import java.util.List;

public class Leecode461 {
	public int hammingDistance(int x, int y) {
		int value = x ^ y;
		int count = 0;
		while (value > 0) {
			int k = value & 1;
			if (k == 1) {
				count++;
			}
			value = value >> 1;
		}
		return count;
	}

	public static void main(String[] s) {
		List<Integer> list = new ArrayList<>(10);
		list.add(5, 10);
	}
}
