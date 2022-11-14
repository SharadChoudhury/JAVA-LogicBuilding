package Graphs;

public class DFStraversal {

	public static void printDFS(int[][] edges) {
		boolean[] visited = new boolean[edges.length];  //status of visited vertices
		
		for(int i=0; i<edges.length ; i++) {  //traversing through visited list and printing all unvisited vertices
			//this is necessary otherwise unconnected components will not be printed
			if(!visited[i])
				printV(edges, visited, i);
		}		
	}
	
	public static void printV(int[][] edges, boolean[] visited, int startV) {
		System.out.println(startV);
		visited[startV] = true; //once printed, mark as visited
		
		for(int j=0; j<edges.length; j++) {
			if(edges[startV][j] == 1 && !visited[j])	//if an edge exists b/w start vertex(startV) and j and vertex j 
				//is not visited yet call print on it
				printV(edges, visited, j);
		}		
	}
	
}
