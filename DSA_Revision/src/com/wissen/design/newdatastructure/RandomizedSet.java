package com.wissen.design.newdatastructure;

import java.util.*;

//380. Insert Delete GetRandom O(1)
public class RandomizedSet {
	//Average time complexity
    //TC: O(1)
    //SC: O(n) //current no. of elements in the list
    
    
    Map<Integer, Integer> hmap;
    List<Integer> list;
    
    public RandomizedSet() {
        hmap = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hmap.containsKey(val)) return false;
        list.add(val);
        hmap.put(val, list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(hmap.containsKey(val) == false) return false;
        //val is present in list & hmap, swap it with last element, update index for last element in hmap. Remove last element from the list & remove val(stored as key) from hmap.
        int index = hmap.get(val);
        Collections.swap(list, index, list.size() - 1);
        int swappedLastElement = list.get(index);
        //update the index of last element into hmap after swapping it with list.get(index) element.
        hmap.put(swappedLastElement, index);
        //remove the last element earlier which is present given index from list & from hmap also as stored key.
        list.remove(list.size() - 1);
        hmap.remove(val);
        return true;
        
    }
    
    public int getRandom() {
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }
}
