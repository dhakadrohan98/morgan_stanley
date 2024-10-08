package com.wissen.codingtemplate;

public class BFSOnMatrix {
	public int numRows = grid.length;
	public int numCols = grid[0].length;

	public List<Coordinate> getNeighbors(Coordinate coord) {
	    int row = coord.row;
	    int col = coord.col;
	    int[] deltaRow = {-1, 0, 1, 0};
	    int[] deltaCol = {0, 1, 0, -1};
	    List<Coordinate> res = new ArrayList<>();
	    for (int i = 0; i < deltaRow.length; i++) {
	        int neighborRow = row + deltaRow[i];
	        int neighborCol = col + deltaCol[i];
	        if (0 <= neighborRow && neighborRow < numRows &&
	            0 <= neighborCol && neighborCol < numCols) {
	                res.add(new Coordinate(neighborRow, neighborCol));
	            }
	    }
	    return res;
	}

	public void bfs(Coordinate startingNode) {
	    Deque<Coordinate> queue = new ArrayDeque<>();
	    queue.add(startingNode);
	    Set<Coordinate> visited = new HashSet<>();
	    visited.add(startingNode);

	    while (queue.size() > 0) {
	        Coordinate node = queue.pop();
	        for (Coordinate neighbor : getNeighbors(node)) {
	            if (visited.contains(neighbor)) continue;
	            // Do stuff with the node if required
	            // ...
	            queue.add(neighbor);
	            visited.add(neighbor);
	        }
	    }
	}
}
