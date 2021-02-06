package leecode155;

public class Leecode44 {

	public boolean isMatch(String s, String p) {
		p=processStart(p);
		return doNewMatch(s,p);
	}
	
	private boolean doNewMatch(String s, String p){
		if (s.equals("")) {
			if (p.equals(s)) {
				return true;
			}
			for (char v : p.toCharArray()) {
				if (v != '*') {
					return false;
				}
			}

			return true;
		}

		if (p.equals("")) {
			return false;
		}

		if (s.length() == 1 && p.length() == 1) {
			if ((p.equals(s) || p.equals("*") || p.equals("?"))) {
				return true;
			} else {
				return false;
			}
		}

		boolean result = false;
		char sstart = s.charAt(0);
		char pstart = p.charAt(0);
		if (sstart == pstart || pstart == '?') {
			result = doNewMatch(s.substring(1), p.substring(1));
		} else if (pstart == '*') {
			if (p.length() > 1) {
				if (p.charAt(1) == sstart || p.charAt(1) == '?') {
					result = doNewMatch(s.substring(1), p.substring(2));
				}
			}
			if (!result) {
				result = doNewMatch(s.substring(1), p);
			}
			if (!result) {
				result = doNewMatch(s, p.substring(1));
			}

		} else {
			result = false;
		}
		return result;
	}
	
	public String processStart(String p){
		StringBuffer sb = new StringBuffer();
		boolean lastStar=false;
		for (char v : p.toCharArray()) {
			if (v == '*') {
				if(!lastStar) {
					lastStar= true;
					sb.append(v);
				}
			} else {
				lastStar= false;
				sb.append(v);
			}
		}
		return sb.toString();
	}

	public static void main(String[] s) {

		System.out.println(new Leecode44().isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab",
				"***bba**a*bbba**aab**b"));

	}
}
