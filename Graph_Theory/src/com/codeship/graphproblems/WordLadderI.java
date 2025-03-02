package com.codeship.graphproblems;

import java.util.*;

// m -> |wordList|^2
//n -> |each word|
//TC: O(len) + O(m^2 * n)
//SC: O(len)set + O(len)queue + (n*26)
public class WordLadderI {
	
	class Pair {
        String word;
        int level;
        
        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
    
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int len = wordList.length;
        //insert the elemenet into set DS
        for(int i = 0; i < len; i++) {
            set.add(wordList[i]);
        }
        queue.offer(new Pair(startWord, 1));
        //remove the startWord from the set
        //his method returns True if the specified element is present in the Set otherwise it returns False.
        set.remove(startWord);
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int level = pair.level;
            if(word.equals(targetWord)) {
                return level;
            }
            //word -> hat, hbt, hct, ..............., hzt
            //iterate through each character
            for(int i = 0; i < word.length(); i++) {
                //change each character
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    //convert the word into char array
                    char[] replacedChar = word.toCharArray();
                    //change the character in char array & then again convert it into
                    //String & then check whethere it exists in set or not, if exists then
                    //remove that replaced String from set & insert the same replaced String
                    //into queue with increased level
                    replacedChar[i] = ch;
                    String replacedWord = new String(replacedChar);
                    //if replacedWord exists in the set
                    if(set.contains(replacedWord)) {
                        set.remove(replacedWord);
                        queue.offer(new Pair(replacedWord, level+1));
                    }
                }
            }
        }
        return 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
