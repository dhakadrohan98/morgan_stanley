package com.wissen.codingtemplate;

public class Backtracking1 {
	private static void dfs(int startIndex, List<T> path, List<List<T>> res, [...additional states]) {
	    if (isLeaf(startIndex)) {
	        res.add(new ArrayList<>(path)); // add a copy of the path to the result
	        return;
	    }
	    for (T edge : getEdges(startIndex, [...additional states])) {
	        path.add(choice);
	        if (...additional states) update(...additional states)
	        dfs(startIndex + edge.length(), res, [...additional states]);
	        path.remove(path.size() - 1);
	        // revert(...additional states) if necessary e.g. permutations
	    }
	}
}
