package com.wissen.twopointers;

public class Dictionary {
	String word;
	int length;
	
	public Dictionary(String word, int length) {
		this.word = word;
		this.length = length;
	}

	@Override
	public String toString() {
		return "Dictionary [word=" + word + ", length=" + length + "]";
	}
	
}
