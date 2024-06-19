package com.wissen;

import java.security.Key;
import java.util.*;

// int -> 2^32 to 2^31-1
public class BookShelf {
	private static final int capacity = 50;
	private static Map<String, Integer> hmap = new HashMap<>();
	
	//add as new books
	public void addBook(List<String> books) {
		int size = books.size();
		
//		int remainingBooksAsReplacement = capacity - books.size();
		
		if(hmap.size() <= capacity) {
			
		}
		
		for(int i=0; i<size; i++) {
			String key = books.get(i);
			if(hmap.size() <= capacity) {
				//keeping the book as new
				hmap.put(key, 0);
			}
			else {
				//remove least frequently used books & then add new books
				//leastFreuquently used books
				//2 3
			}
		}
	}
	
	//addBook(List<String> books)
	//getTotalBooks()
	//getReplacementBook(String oldBookd, String newBook)
	//removeBooks(String bookName)
	//removeAllBooks();

	public static void main(String[] args) {
		hmap.put("book1", 2);
		hmap.put("book2", 4);
		hmap.put("book3", 3);
		hmap.put("book4", 6);
		hmap.put("book5", 5);
		hmap.put("book6", 9);
		hmap.put("book7", 7);
		hmap.put("book8", 11);
		hmap.put("book9", 10);
		hmap.put("book10", 12);
		
		
	}

}
