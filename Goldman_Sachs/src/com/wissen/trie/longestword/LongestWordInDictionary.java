package com.wissen.trie.longestword;

public class LongestWordInDictionary {
static String ans = "";
    
    static class Node {
        Node[] childs = new Node[26];
        String str; //null until word is not ended while inserting characters
        
        public static void insert(Node curr, String s) {
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                
                if(curr.childs[ch-'a'] == null) {
                    curr.childs[ch-'a'] = new Node();
                }
                //move curr to next reference
                curr = curr.childs[ch-'a'];
            }
            //mark end of word, assigning s(word) to curr node str field
            //which all character indexes is pointing to null
            curr.str = s;
        }
    }
    
    public static String longestWord(String[] words) {
        //instantiate root node
        Node root = new Node();
        for(String s : words) {
            Node.insert(root, s);
        }
        //Peform dfs on root node
        dfs(root);
        return ans;
    }
    
    public static void dfs(Node root) {
        //iterate through childs node of current node(character indexs)
        for(Node child : root.childs) {
            //if curr child is not null & it is end of the word
            if(child != null && child.str != null) {
                if(child.str.length() > ans.length()) {
                    ans = child.str;
                }
                //apply dfs on connected node(character indexes)
                dfs(child);
            }
        }
    }
    
    public static void main(String[] args) {
		String[] words = {"a","banana","app","appl","ap","apply","apple"};
		System.out.println(longestWord(words));
	}
}
