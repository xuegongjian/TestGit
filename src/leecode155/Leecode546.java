package leecode155;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leecode546 {
	int ret = 0;

	Map<String, Integer> cache = new HashMap<>();

	// int maxValue = 0;

	public int removeBoxes(int[] boxes) {
		if (boxes.length == 0) {
			return 0;
		}
		int[] mem = new int[boxes.length - 1];
		int ret = doRemoveBoxes(boxes);

		return ret;
	}

	public int doRemoveBoxes(int[] boxes) {
		String key = getKey(boxes);
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		int maxValue = 0;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == 0) {
				continue;
			}
			int value = boxes[i];
			List<Integer> indexs = process(boxes, i);
			key = getKey(boxes);
			maxValue = indexs.size() * indexs.size() + doRemoveBoxes(boxes);
			cache.put(key, maxValue);
			reprocess(boxes, indexs, value);
		}

		return maxValue;
	}

	private String getKey(int[] boxes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < boxes.length; i++) {
			sb.append(i).append(boxes[i]);
		}
		return sb.toString();
	}

	private List<Integer> process(int[] boxes, int i) {
		List<Integer> indexs = new ArrayList<>();
		indexs.add(i);
		int tmp = boxes[i];
		boxes[i] = 0;
		for (int k = i + 1; k < boxes.length; k++) {
			if (boxes[k] == 0) {
				continue;
			}
			if (boxes[k] == tmp) {
				indexs.add(k);
				boxes[k] = 0;
			} else {
				break;
			}
		}
		return indexs;
	}

	private void reprocess(int[] boxes, List<Integer> indexs, int value) {
		for (int i : indexs) {
			boxes[i] = value;
		}
	}

	public static void main(String[] s) {
		System.out.println(new Leecode546().removeBoxes(new int[] { 1, 3, 2 }));

	}
}
