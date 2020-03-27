package leecode155;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Leecode399 {
	Map<String, Double> map = new HashMap<>();
	boolean[] visit = null;
	boolean first = true;
	int cnt = 0;
	private void generateData(List<List<String>> equations, double[] values){
		int i = 0;
		for (List<String> list : equations) {
			if (visit[i])
				continue;
			String a = list.get(0);
			String b = list.get(1);
			double value = values[i];
			Double aValue = map.get(a);
			Double bValue = map.get(b);
			if (null == bValue && null == aValue && first) {
				bValue = 1.0;
				map.put(b, bValue);
				map.put(a, bValue * value);
				first = false;
				visit[i] = true;
				cnt = cnt + 1;
			} else if (null == aValue) {
				map.put(a, bValue * value);
				cnt = cnt + 1;
			} else if (null == bValue) {
				map.put(b, aValue / value);
				cnt = cnt + 1;
			}
			i++;
		}
		if(cnt != values.length){
			generateData(equations, values);
		}
	}
	
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		visit = new boolean[values.length];
		generateData(equations, values);
		
		

		for (Entry<String, Double> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		int i = 0;
		double[] result = new double[queries.size()];
		for (List<String> list : queries) {
			String a = list.get(0);
			String b = list.get(1);
			Double aValue = map.get(a);
			Double bValue = map.get(b);
			if (null == bValue || null == aValue) {
				result[i] = -1;
			} else {
				result[i] = aValue / bValue;
			}
			i++;
		}

		return result;
	}

	public static void main(String[] s) {
		// System.out.println(new Leecode11().findTargetSumWays(new
		// int[]{1,1,1,1,1},5));

	}
}
