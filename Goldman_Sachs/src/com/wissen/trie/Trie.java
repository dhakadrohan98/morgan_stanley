package com.wissen.trie;

// Node structure for Trie
class Node {
	// Array to store links to child nodes,
	// each index represents a letter
	Node[] links = new Node[26];
	// Flag indicating if the node
	// marks the end of a word
	boolean flag = false;

	// Check if the node contains
	// a specific key (letter)
	boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}

	// Insert a new node with a specific
	// key (letter) into the Trie
	void put(char ch, Node node) {
		//put ch into current node & then point links[ch-'a'] -> new reference node.
		links[ch - 'a'] = node;
	}

	// Get the node with a specific
	// key (letter) from the Trie
	Node get(char ch) {
		return links[ch - 'a'];
	}

	// Set the current node
	// as the end of a word
	void setEnd() {
		this.flag = true;
	}

	// Check if the current node
	// marks the end of a word
	boolean isEnd() {
		//last flag has to be true to determine the end of the word
		return this.flag;
	}
}

public class Trie {

	// Trie class
	private Node root;

	// Constructor to initialize the
	// Trie with an empty root node
	public Trie() {
		root = new Node();
	}

	// Inserts a word into the Trie
	//TC : O(len|word|)
	// Time Complexity O(len), where len is the length of the word
	public void insert(String word) {
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			if (!node.containsKey(word.charAt(i))) {
				// put the word & create a new node for reference (from current kept word)
				node.put(word.charAt(i), new Node());
			}
			// Move to the new reference node(with no character)
			node = node.get(word.charAt(i));
		}
		// Mark the end of the word
		node.setEnd();
	}

	// Returns if the word
	// is in the trie
	//TC: O(len)
	public boolean search(String word) {
		//start searching from starting point of the tree(root node)
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			if (!node.containsKey(word.charAt(i))) {
				// If a letter is not found, the word is not in the Trie
				return false;
			}
			// Move to the next reference node
			node = node.get(word.charAt(i));
		}
		// Check if the last node, marks the end of a word
		//last flag has to be true to determine the end of the word
		return node.isEnd();
	}

	// Returns if there is any word in the
	// trie that starts with the given prefix
	//TC: O(len)
	public boolean startsWith(String prefix) {
		Node node = root;
		for (int i = 0; i < prefix.length(); i++) {
			//1. // If a letter is not found, there is no word with the given prefix
			//2. next reference is null, it means when have traversed the word completely, 
			//prefix word doesn't exist
			if (!node.containsKey(prefix.charAt(i))) {
				return false;
			}
			// Move to the next node
			node = node.get(prefix.charAt(i));
			//below condition will never be executed
			//next reference is null, it means when have traversed the word completely, 
			//prefix word doesn't exist
			if(node == null) {
				return false;
			}
		}
		// The prefix is found in the Trie
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println("Inserting words: striver, striving, string, strike");
		trie.insert("striver");
		trie.insert("striving");
		trie.insert("string");
		trie.insert("strike");

		System.out.println("Search if strawberry exists in trie: " + (trie.search("strawberry") ? "True" : "False"));

		System.out.println("Search if strike exists in trie: " + (trie.search("strike") ? "True" : "False"));

		System.out.println("If words in Trie start with stri: " + (trie.startsWith("stri") ? "True" : "False"));
		System.out.println("If words in Trie start with strin: " + (trie.startsWith("strin") ? "True" : "False"));
		System.out.println("If words in Trie start with straw: " + (trie.startsWith("straw") ? "True" : "False"));
	}
}
