package com.wissen.codingtemplate;

public class UnionFind {
	public static class UnionFind<T> {
	    private HashMap<T, T> id = new HashMap<>();

	    public T find(T x) {
	        T y = id.getOrDefault(x, x);
	        if (y != x) {
	            y = find(y);
	            id.put(x, y);
	        }
	        return y;
	    }

	    public void union(T x, T y) {
	        id.put(find(x), find(y));
	    }
	}
}
