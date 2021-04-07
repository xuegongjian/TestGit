package leecode155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

public class Leecode126 {

	public static class Node {
		public String curWord;
		public Node parentNode;

		public Node(String curWord, Node parentNode) {
			this.curWord = curWord;
			this.parentNode = parentNode;
		}
	}

	List<List<String>> returnList = new ArrayList<>();

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return new ArrayList<>();
		}
		int currentDep = Integer.MAX_VALUE;
		Queue<Pair<Node, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<Node, Integer>(new Node(beginWord, null), 0));
		Set<String> de = new HashSet<>();
		while (!queue.isEmpty()) {
			Pair<Node, Integer> curWord = queue.poll();
			List<String> nextWords = isDifOne(curWord.getKey().curWord, wordList, de);
			if (currentDep < curWord.getValue()) {
				continue;
			}
			if (nextWords.contains(endWord) && currentDep >= curWord.getValue()) {
				List<String> tmpList = conList(curWord.getKey());
				tmpList.add(endWord);
				returnList.add(tmpList);
				currentDep = curWord.getValue();
			} else {
				for (String word : nextWords) {
					queue.add(new Pair<Node, Integer>(new Node(word, curWord.getKey()), curWord.getValue() + 1));
				}
			}
			de.addAll(nextWords);
		}
		return returnList;
	}

	private List<String> conList(Node curWord) {
		List<String> result = new ArrayList<>();
		while (curWord != null) {
			result.add(0, curWord.curWord);
			curWord = curWord.parentNode;
		}
		return result;
	}

	private List<String> isDifOne(String word1, List<String> wordList, Set<String> de) {
		List<String> result = new ArrayList<>();
		for (String word2 : wordList) {
//			if (de.contains(word2)) {
//				continue;
//			}
			int i = 0;
			int difCnt = 0;
			while (i < word1.length()) {
				if (word1.charAt(i) != word2.charAt(i)) {
					difCnt++;
				}
				if (difCnt > 1) {
					break;
				}
				i++;
			}
			if (difCnt == 1) {
				result.add(word2);
			}
		}
		return result;
	}

	public static void main(String[] args){
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		new Leecode126().findLadders(beginWord, endWord, wordList);
	}

}
