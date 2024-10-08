package com.wissen.codingtemplate;

public class Trie {
	public static class Node {
	    char value;
	    HashMap<Character, Node> children = new HashMap<>();
	    public Node(char value) {
	        this.value = value;
	    }
	    void insert(String s, int idx) {   
	        if (idx == s.length()) {
	            return;
	        }
	        if (children.containsKey(s.charAt(idx))) {
	            children.get(s.charAt(idx)).insert(s, idx + 1);
	        }
	        else {
	            children.put(s.charAt(idx), new Node(s.charAt(idx)));
	            children.get(s.charAt(idx)).insert(s, idx + 1);
	        }
	    }
	}
}
