package leecode155;

public class Trie {

	public class TrieNode {
		
		boolean end =false;
		TrieNode[] trieNodes;

		TrieNode() {
		}
		
		public TrieNode addNode(char c){
			int index = c-'a';
			if(null == trieNodes){
				trieNodes = new TrieNode[26];
			} 
			if(trieNodes[index] == null) {
				trieNodes[index] = new TrieNode();	
			}
			return trieNodes[index];
		}
		
		public TrieNode existsNode(char c){
			int index = c-'a';
			if(null == trieNodes) return null;
			return trieNodes[index];
		}
		
	}

    /** Initialize your data structure here. */
	TrieNode trieNode = null;
    public Trie() {

    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	if(null == word || word.length() == 0) return;
    	if(null == trieNode){
    		trieNode  = new TrieNode();
    	}
    	TrieNode tmpNode = trieNode;
    	for(char c : word.toCharArray()){
    		tmpNode = tmpNode.addNode(c);
    	}
    	tmpNode.end=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	return this.search(word, true);
    }
    
    public boolean search(String word,boolean search) {
    	if(null == word || word.length() == 0) return true;
    	TrieNode tmpNode = trieNode;
    	if(null == trieNode) return false;
    	for(char c : word.toCharArray()){
    		tmpNode = tmpNode.existsNode(c);
    		if(null == tmpNode) return false;
    	}
    	
    	return search? tmpNode.end:true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	return this.search(prefix,false);
    }
}
