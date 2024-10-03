package com.wissen.round2;

import java.util.HashMap;

class Book {
    int id;
    String title;
    Book prev;
    Book next;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }
}

class LRUCache {
    private HashMap<Integer, Book> map;
    private int capacity;
    private Book head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Book(0, "");
        this.tail = new Book(0, "");
        head.next = tail;
        tail.prev = head;
    }

    public String get(int id) {
        if (map.containsKey(id)) {
            Book book = map.get(id);
            remove(book);
            insert(book);
            return book.title;
        }
        return null;
    }

    public void put(int id, String title) {
        if (map.containsKey(id)) {
            Book book = map.get(id);
            book.title = title;
            remove(book);
            insert(book);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.id);
                remove(tail.prev);
            }
            Book newBook = new Book(id, title);
            map.put(id, newBook);
            insert(newBook);
        }
    }

    public void delete(int id) {
        if (map.containsKey(id)) {
            Book book = map.get(id);
            remove(book);
            map.remove(id);
        }
    }

    private void remove(Book book) {
        book.prev.next = book.next;
        book.next.prev = book.prev;
    }

    private void insert(Book book) {
        book.next = head.next;
        book.prev = head;
        head.next.prev = book;
        head.next = book;
    }
}

public class Shelf {
    public static void main(String[] args) {
        LRUCache shelf = new LRUCache(50);
        shelf.put(1, "Book 1");
        shelf.put(2, "Book 2");
        System.out.println(shelf.get(1)); // Should print "Book 1"
        shelf.delete(1);
        System.out.println(shelf.get(1)); // Should print null
    }
}

