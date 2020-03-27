package leecode155;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javafx.util.Pair;

public class Leecode127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord.length() != endWord.length())
			return 0;
		if (null == wordList)
			return 0;
		if (!wordList.contains(endWord))
			return 0;

		LinkedList<Pair<String, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<String, Integer>(beginWord, 1));
		while (!queue.isEmpty()) {
			Pair<String, Integer> p = queue.removeFirst();
			if (p.getKey().equals(endWord))
				return p.getValue();
			
			List<String> words = getDeltaOneList(wordList,p.getKey());
			wordList.removeAll(words);
			
			for(String tmp : words){
				queue.add(new Pair<String, Integer>(tmp,  p.getValue()+ 1));
			}
		}
		return 0;
	}

	private List<String> getDeltaOneList(List<String> wordList, String word) {
		List<String> tmpList =  new ArrayList<>();
		for (String tmp : wordList) {
			if(isDeltaOne(tmp,word)){
				tmpList.add(tmp);
			}
		}
		return tmpList;
	}

	public boolean isDeltaOne(String word, String other) {
		if (word.length() != other.length()) {
			return false;
		}
		char[] a = word.toCharArray();
		char[] b = other.toCharArray();
		int delta = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				delta++;
			}

		}
		return delta == 1;
	}
}
