package Graphs;

import java.util.*;

public class hasPath {

	//Approach 1 :DFS
	//Time: O(V+E) as in worst case all edges and vertices will be traversed
	//Space: O(V) as the max stack space can be equal to no. of vertices 
	public static boolean isPathDFS(int[][] edges, int v1, int v2) {
		boolean[] visited = new boolean[edges.length];  
		return isPathDFS(edges, visited,v1, v2);
	}
	
    
	public static boolean isPathDFS(int[][] edges, boolean[] visited, int v1, int v2) {
		if(v2 >= edges.length || v2 < 0)
            return false;

        if(edges[v1][v2] == 1)
        	return true;
        
        visited[v1] = true; 
        
		for(int j=0; j<edges.length; j++) {
			if(edges[v1][j] == 1 && !visited[j]){
                if( isPathDFS(edges, visited, j, v2) == true)
                    return true;
            }				
		}
        
        return false;
	}
	
	
	//Approach 1: BFS
	public static boolean isPathBFS(int[][] edges, int v1, int v2) {
		//visited array is always required to prevent cycles and infinite looping
		boolean[] visited = new boolean[edges.length];  		
		return isPathBFS(edges, visited, v1, v2);
	}
	
	public static boolean isPathBFS(int[][] edges, boolean[] visited, int v1, int v2) {

		Queue<Integer> q  = new LinkedList<Integer>();
		q.add(v1);
		visited[v1] = true;
		
		while(!q.isEmpty()) {
			int vertex = q.poll();
			for(int j=0; j<edges.length; j++) {
				if(edges[vertex][j] == 1 && !visited[j]) {
					if(j == v2)
						return true;
					q.add(j);
					visited[j] = true;
				}				
			}
		}
		
		return false;
		
	}
	
	
	
	//Approach 2
    public static boolean isPathDFS2(int[][] edges, int v1, int v2) {
		boolean[] visited = new boolean[edges.length];  
		visited[v1] = true;
        
		for(int j=0; j<edges.length ; j++) { 
			if(!visited[j] && edges[v1][j] == 1){
                if(isPathDFS2(edges, visited, j, v2) == true)
                    return true;
            }
		}
        
        return false;
	}
	
    
	public static boolean isPathDFS2(int[][] edges, boolean[] visited, int v1, int v2) {
		visited[v1] = true; 
        if(v1 == v2)
            return true;
        
		for(int j=0; j<edges.length; j++) {
			if(edges[v1][j] == 1 && !visited[j]){
                if( isPathDFS2(edges, visited, j, v2) == true)
                    return true;
            }				
		}
        
        return false;
	}
	
}
