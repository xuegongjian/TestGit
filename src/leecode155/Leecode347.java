package leecode155;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leecode347 {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (null == s || null == wordDict || wordDict.size()==0)
			return false;

		Collections.sort(wordDict, (a, b) -> {
			if (a.length() >= b.length())
				return 1;
			else
				return -1;
		});
		return backTrace(s,wordDict,0);
	}
	
	
	private boolean backTrace(String s, List<String> wordDict,int step){
		if(step == wordDict.size()) return true;
		
		String cur = wordDict.get(step);
		
		String t = s;
		List<Integer> positons = new ArrayList<>();
		while(t.indexOf(cur) > -1){
			int index = t.indexOf(cur);
			positons.add(index);
			if(t.length()>=index+1) {
				t = t.substring(index+1);
			}
		}
		for(int i : positons){
			t = s.substring(0,i) + s.substring(i+cur.length());
			boolean result =backTrace(t,wordDict,  step+1);
			if(result){
				return result;
			}
		}
		return false;
	}

	public static void main(String[] s) {
		List<String> wordDict = new ArrayList<>();
		wordDict.add("apple");
		wordDict.add("applehear");
		wordDict.add("ear");
		System.out.println(new Leecode347().wordBreak("abcappleearapplehear",wordDict));

	}
}
