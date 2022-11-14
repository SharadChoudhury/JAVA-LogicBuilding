package Graphs;
import java.util.Scanner;

public class primsAlgo {

	public static void main(String[] args) {
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
        
        //Prim's implementation
        //visited array
        boolean visited[] = new boolean[V];
        
        //parent array: each vertex will have a parent
        int[] parent = new int[V];
        parent[0] = -1;   	//if we choose 0 as the source
        
        //weights array
        int[] weight = new int[V];
        weight[0] = 0;		//if we choose 0 as the source
        
        //weight of all other vertices is infinity
        for(int i=1; i<V; i++) {
        	weight[i] = Integer.MAX_VALUE;
        }
        
        
        for(int i=0; i<V; i++) {        	
        	//pick vertex with minimum weight
        	int min = Integer.MAX_VALUE;
        	int v = -1;    //v is the vertex where minimum weight occurs
        	for(int j=0; j<V; j++) {
        		if(!visited[j] && weight[j] < min) {
        			min = weight[j];
        			v = j;
        		}
        	}
        	//mark vertex v as visited
        	visited[v] = true;

        	//checking the unvisited neighbors of v and updating them if their weight from v is less
        	// than their current weight
        	for(int j=0; j<V; j++) {  
        		if(edges[v][j] > 0 && !visited[j]) {
        			if(edges[v][j] < weight[j]) {
        				weight[j] = edges[v][j];
        				parent[j] = v;
        			}
        		}
        	}        	
        }
        
        for(int i=1; i<V; i++) {
        	System.out.println(parent[i] + " " + i + " " + weight[i]);
        }
        
	}
}