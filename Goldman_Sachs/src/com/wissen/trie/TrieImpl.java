package com.wissen.trie;

class Node1 {
	//A single can contains character from a,b,c,.....,z (26 letters)
	Node1[] links = new Node1[26];
	//keep track of word ending
	boolean flag = false;
	
	boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}
	
	void put(char ch, Node1 node1) {
		links[ch - 'a'] = node1;
	}
	
	Node1 get(char ch) {
		return links[ch - 'a'];
	}
	
	void setEnd() {
		this.flag= true;
	}
	
	boolean isEnd() {
		return this.flag;
	}
}

public class TrieImpl {
	
	//root node always be present in Trie irrespective of any character is present or not.
		private Node1 root;
		
		public TrieImpl() {
			root = new Node1();
		}
		
		//Searching
		public void insert(String word) {
			//start with root node
			Node1 node1 = root;
			for(int i=0; i<word.length(); i++) {
				char ch = word.charAt(i);
				if(!node1.containsKey(ch)) {
					node1.put(ch, new Node1());
				}
				//moving to next reference node
				node1 = node1.get(ch);
			}
			//mark the end of word
			node1.setEnd();
		}
		
		public boolean search(String word) {
			//start with root node
			Node1 node1 = root;
			for(int i=0; i<word.length(); i++) {
				char ch = word.charAt(i);
				if(!node1.containsKey(ch)) {
					return false;
				}
				//moving to next reference node
				node1 = node1.get(ch);
			}
			//flag true means the end of word
			return node1.isEnd();
		}
		
		public boolean startsWith(String prefix) {
			//start with root node
			Node1 node1 = root;
			for(int i=0; i<prefix.length(); i++) {
				char ch = prefix.charAt(i);
				if(!node1.containsKey(ch)) {
					// If a letter is not found, there is no word with the given prefix
					return false;
				}
				//moving to next reference node
				node1 = node1.get(ch);
			}
			//flag true means the end of word
			return true;
		}
		
		
		

	public static void main(String[] args) {
		TrieImpl trie = new TrieImpl();
		System.out.println("Inserting words: apple, apps, apxl, bac, bat");
		trie.insert("apple");
		trie.insert("apps");
		trie.insert("apxl");
		trie.insert("bac");
		trie.insert("bat");
		System.out.println("search() operations");
		System.out.println("Is apple word present: " + (trie.search("apple") ? "true" : "false"));
		System.out.println("Is apps word present: " + (trie.search("apps") ? "true" : "false"));
		System.out.println("Is apxl word present: " + (trie.search("apxl") ? "true" : "false"));
		System.out.println("Is bacc word present: " + (trie.search("bacc") ? "true" : "false"));
		System.out.println("Is bate word present: " + (trie.search("bate") ? "true" : "false"));
		System.out.println();
		
		System.out.println("starts with() operations");
		System.out.println("Is any word starts with preifx apz: " + trie.startsWith("apz"));
		System.out.println("Is any word starts with preifx bac: " + trie.startsWith("bac"));
		System.out.println("Is any word starts with preifx bate: " + trie.startsWith("bate"));

	}

}
