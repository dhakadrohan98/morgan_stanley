package com.wissen.twopointers;

import java.util.Comparator;

public class DictionaryComparator implements Comparator<Dictionary> {
	
	@Override
	public int compare(Dictionary d1, Dictionary d2) {
		int len1 = d1.length;
		int len2 = d2.length;
		
		if(len1 == len2) {
			//length are same then sort on basis of lexicographically small
			return d1.word.compareToIgnoreCase(d2.word);
		} else {
			return len2 - len1;
		}
	}
	
}
