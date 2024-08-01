package com.wissen.graph;

public class NoOfProvincesII {
	
	 //TC: O(V+E)
    //SC: O(V+E)
    public static int findCircleNum(int[][] mat) {
        int n = mat.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int sr=0; sr<n; sr++) {
            if(!visited[sr]) {
                dfs(sr, visited, mat);
                provinces++;
            }
        }
        return provinces;
    }
    
    public static void dfs(int sr, boolean[] visited, int[][] mat) {
        int n = mat.length;
        //mark curr node as visited
        visited[sr] = true;
        for(int j=0; j<n; j++) {
            if(!visited[j] && mat[sr][j] == 1) {
                dfs(j, visited, mat);
            }
        }
    }
    
	public static void main(String[] args) {
		int[][] mat = {{1,0,0}, {0,1,0}, {0,0,1}}; //3 disconnected component
		System.out.println(findCircleNum(mat));
		
		int[][] mat1 = {{1,1,0}, {1,1,0}, {0,0,1}}; //2 disconnected component
		System.out.println(findCircleNum(mat1)); 

	}

}
