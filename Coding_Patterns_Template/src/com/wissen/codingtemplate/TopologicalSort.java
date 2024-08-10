package com.wissen.codingtemplate;

public class TopologicalSort {
	public static <T> Map<T, Integer> findInDegree(Map<T, List<T>> graph) {
	    Map<T, Integer> inDegree = new HashMap<>();
	    graph.keySet().forEach(node -> {
	        inDegree.put(node, 0);
	    });
	    graph.entrySet().forEach(entry -> {
	        for (T neighbor : entry.getValue()) {
	            inDegree.put(neighbor, Indegree.get(neighbor) + 1);
	        }
	    });
	    return inDegree;
	}

	public static <T> List<T> topoSort(Map<T, List<T>> graph) {
	    List<T> res = new ArrayList<>();
	    Queue<T> q = new ArrayDeque<>();
	    Map<T, Integer> inDegree = findInDegree(graph);
	    inDegree.entrySet().forEach(entry -> {
	        if (entry.getValue() == 0) {
	            q.add(entry.getKey());
	        }
	    });
	    while (!q.isEmpty()) {
	        T node = q.poll();
	        res.add(node);
	        for (T neighbor : graph.get(node)) {
	            // subtract one from every neighbour
	            inDegree.put(neighbor, inDegree.get(neighbor) - 1);
	            // once the number of parents reaches zero you add it to the queue
	            if (inDegree.get(neighbor) == 0) {
	                q.add(neighbor);
	            }
	        }
	    }
	    // check for cycle
	    return (graph.size() == res.size()) ? res : null;
	}
}
