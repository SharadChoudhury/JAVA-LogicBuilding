package Graphs;

public class islands {

	// An island is a piece of land that is not connected to other lands
	// A group of all connected points form an island. So here, we are asked to find the no. of
	// connected components.
	// so take a visited array and perform dfs on all unvisited points and simultaneously mark the
	// visited points. 

	public static int numConnected(int[][] edges, int n) {
		//Time : O(V^2)  --> on each vertex we run a loop of O(V) to find its neighbors. so O(V*V)
		//Space : O(V^2) --> In worst case, when it is a complete graph and all nodes are connected
		// to each other
		
        boolean visited[] = new boolean[edges.length];
        int count =0;
        for(int i=0; i<visited.length; i++){ 
            if( !visited[i]){ //as soon as we find an unvisited point, increase count because it 
            	// means this vertex is disconnected from its previous group
                count++;
                traverse(edges,visited,i);
            }
        }
        return count;
	}
    
    public static void traverse(int[][] edges, boolean[] visited, int start){
        visited[start] = true;
        for(int i=0; i<edges.length; i++){
            if(!visited[i] && edges[start][i] == 1){
                traverse(edges,visited,i);
            }
        }
    }
		
	
}
