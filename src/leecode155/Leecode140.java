package leecode155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leecode140 {
	Set<String> set = null;
	List<String> results = new ArrayList<>();
	public List<String> wordBreak(String s, List<String> wordDict) {
		if(null == wordDict) return null;
		set =  new HashSet<>(wordDict);
		
		doBackTrace(s,new ArrayList<String>());
	
		return results;
	}
	
	public void doBackTrace(String s,List<String> result){
		if(set.contains(s)){
			generate(s,result);
			return;
		}
		for(int i = 1;i<s.length(); i++){
			if(set.contains(s.substring(0, i))){
				result.add(s.substring(0, i));
				doBackTrace(s.substring(i),result);
				result.remove(result.size()-1);
			}
		}
	}
	public void generate(String s,List<String> result){
		StringBuffer sb = new StringBuffer();
		for(String v: result){
			sb.append(v).append(" ");
		}
		sb.append(s);
		results.add(sb.toString());
	}
	
	public static void main(String [] args){
		String s = "catsanddog";
		List<String> wordDicts = Arrays.asList("cat", "cats", "and", "sand", "dog");
		System.out.println(new Leecode140().wordBreak(s, wordDicts));
		
	}
}
