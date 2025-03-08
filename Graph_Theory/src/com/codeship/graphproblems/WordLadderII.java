package com.codeship.graphproblems;

import java.util.*;

public class WordLadderII {
	
	public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
		Set<String> set = new HashSet<>();
		int len = wordList.length;
		// Adding all words from wordList into the set
		for (int i = 0; i < len; i++) {
			set.add(wordList[i]);
		}
		Queue<ArrayList<String>> q = new LinkedList<>();
		ArrayList<String> ls = new ArrayList<>();
		// initial configuaration
		// initially add startword into the list & add then into queue
		ls.add(startWord);
		q.offer(ls);
		// keep track of levels while traversing in BFS manner
		ArrayList<String> usedOnLevel = new ArrayList<>();
		usedOnLevel.add(startWord);
		// initially level is 0 because there is nothing in the queue
		int level = 0;
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		while (!q.isEmpty()) {
			ArrayList<String> vec = q.poll();
			// erase all the words that have beed used in the previous levels in transform
			// if current vec has size more than previous list words(stored in queue),
			// then we have to remove all words of previous list from the set.
			if (vec.size() > level) {
				level++;
				for (String itr : usedOnLevel) {
					set.remove(itr);
				}
			}
			// get the last word
			String word = vec.get(vec.size() - 1);
			// if we reached the targetword & found our one sequence
			if (word.equals(targetWord)) {
				// the first sequence where we reached the end
				if (ans.size() == 0) {
					ans.add(vec);
				} else if (ans.get(0).size() == vec.size()) { // Another possible shortest sequence
					ans.add(vec);
				}
			}
			// change each character from a-z in the last word(get from the vec list)
			for (int i = 0; i < word.length(); i++) {
				// for each character i, replace it with a-z & check whethere set contains the
				// tranformed word or not
				// if set contains the transformed word then add that word into vec list & add
				// that list into the queue by creating a copy of vec list
				// because we have to remove the last(tranformed) wordfrom vec list
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char[] replacedCharArray = word.toCharArray();
					replacedCharArray[i] = ch;
					String replacedWord = new String(replacedCharArray);
					if (set.contains(replacedWord)) {
						vec.add(replacedWord);
						// Java work by reference, copy the vec list into temp list to add into the
						// queue
						ArrayList<String> temp = new ArrayList<>(vec);
						q.offer(temp);
						// mark as visited on the level
						usedOnLevel.add(replacedWord);
						// remove the last word
						vec.remove(vec.size() - 1);
					}
				}
			}
		} // q closing braces

		return ans;
	}
}
