package leecode155;

import java.util.ArrayList;
import java.util.List;

public class Leecode93 {
	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		if (s == null) {
			return list;
		}
		doBackTrace(s, list, 0, new ArrayList<String>());
		return list;
	}

	public void doBackTrace(String s, List<String> list, int step, List<String> tmpList) {
		if (s.length() > (4 - step) * 3 || s.length()==0) {
			return;
		}
		if (step == 3) {
			if (Integer.parseInt(s) <= 255) {
				if( s.length() > 1 && s.startsWith("0")){
					return;
				}
				list.add(joint(tmpList, s));
			} else {
				return;
			}
		}
		int end = 3;
		if (s.startsWith("0")) {
			end = 1;
		}
		for (int i = 1; i <= end && i <= s.length(); i++) {
			String tmpS = s.substring(0, i);
			if (Integer.parseInt(tmpS) <= 255) {
				tmpList.add(tmpS);
				doBackTrace(s.substring(i), list, step + 1, tmpList);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

	private String joint(List<String> tmpList, String s) {
		StringBuilder sb = new StringBuilder();
		for (String v : tmpList) {
			sb.append(v).append(".");
		}
		return sb.append(s).toString();
	}

	public static void main(String[] s) {
		System.out.println(new Leecode93().restoreIpAddresses("1111"));

	}
}
