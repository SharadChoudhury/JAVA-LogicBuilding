package Graphs;

public class isGraphConnected {

	public static boolean isConnected(int[][] edges){
        if(edges.length == 0)
            return true;
        
        boolean[] visited = new boolean[edges.length]; 
        isConnected(edges, visited, 0);  //if it is a connected graph, then all nodes will be 
        //marked true in visited array after this call
        
        for(int i=0; i<edges.length; i++){
            if(!visited[i]) //if still any node remains unvisited means it's a disconnected graph
                return false;
        }
        
        return true; //if all nodes visited, then connected graph
    }

	
	
    public static void isConnected(int[][] edges, boolean[] visited, int start){
        visited[start] = true;
        
        for(int j=0; j<edges.length; j++){
            if(edges[start][j] == 1  &&  !visited[j])
                isConnected(edges, visited, j);
        }
        
    }
	
}
