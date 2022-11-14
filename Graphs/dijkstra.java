package Graphs;
import java.util.*;

public class dijkstra {

	public static void main(String[] args) {
		//time: O(V^2)			space: O(V^2)
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		//adjacency matrix for input
		int[][] edges = new int[V][V];	//each cell stores the weight to reach j from i	
        for(int i=0; i<E; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            edges[v1][v2] = w;
            edges[v2][v1] = w;
        }       
        
        //Dijkstra's implementation
        //visited array
        boolean visited[] = new boolean[V];
        
        //distance array
        int[] distance = new int[V];
        for(int i=1; i<V; i++)
        	distance[i] = Integer.MAX_VALUE;
        
        for(int i=0; i<V-1; i++) {      	
        	int min = Integer.MAX_VALUE;
        	int v = -1;    //v is the vertex where minimum weight occurs
        	for(int j=0; j<V; j++) {
        		if(!visited[j] && distance[j] < min) {
        			min = distance[j];
        			v = j;
        		}
        	}
        	
        	visited[v] = true;
        	
        	for(int j=0; j<V; j++) {
        		//find unvisited neighbors edges[v][j] > 0 means it is a neighbor
        		if(!visited[j] && edges[v][j] > 0){  
                    if( distance[v] + edges[v][j] < distance[j])  
                      	distance[j] = distance[v]+edges[v][j];  //change distance of j only if
                    //distance calculated from v is less than it its already existing distance
                }        			
        	}
                	
        }

        for(int i=0; i<V; i++) {
        	System.out.println(i +" "+ distance[i]);
        }
        
	}
}