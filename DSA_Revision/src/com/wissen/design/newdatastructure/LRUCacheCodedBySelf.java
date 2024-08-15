package com.wissen.design.newdatastructure;

import java.util.*;
class LRUCacheCodedBySelf {
    
    class Node {
        int key;
        int value;
        Node prev = null, next = null;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> hmap = new HashMap<>();
    Node head;
    Node tail;
    
    public LRUCacheCodedBySelf(int capacity) {
        this.capacity = capacity;
        //making head & prev dummy node for ease
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            head.prev = null;
            tail.prev = head;
            tail.next = null;
    }
    //insert() method
    public void insert(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
    //delete() method
    public void delete(Node node) {
        Node prevTemp = node.prev;
        Node nextTemp = node.next;
        prevTemp.next = nextTemp;
        nextTemp.prev = prevTemp;
        //set next & prev of to be delete node to null.
        node.next = node.prev = null;
    }
    
    public int get(int key) {
        if(hmap.size() > 0 && !hmap.containsKey(key)) {
            return -1;
        } else if(hmap.size() > 0 && hmap.containsKey(key)) {
            Node node = hmap.get(key);
            //putting this node just right to the head
            //delete node(from tail.prev)
            delete(node);
            //insert node (to head.next)
            insert(node);
            return node.value;
        } else if(hmap.size() == 0) {
            return -1;
        }
        return -1;
    }
    
    public void put(int key, int value) {
       
        if(hmap.size() <= this.capacity && hmap.containsKey(key)) { //if hashmap contains key & hmap size equals to cache capacity
            Node node = hmap.get(key);
            node.value = value;
            delete(node);
            insert(node);
         } 
        else {
            if(hmap.size() >= this.capacity) { //hmap size is full, remove tail.prev node
                Node lru = tail.prev;
                //delete prev node
                delete(lru);
                //remove node key from map
                hmap.remove(lru.key);
            }
            //insert a new node
            //make a new Node with new key & value
            Node node = new Node(key, value);
            //insert node into map as it is new node(doesn't exist before)
            insert(node);
            //put this node into map
            hmap.put(key, node);    
        }
        
    }
}

