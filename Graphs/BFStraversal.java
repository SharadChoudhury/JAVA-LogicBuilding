package Graphs;
import java.util.*;
public class BFStraversal {

	public static void printBFS(int[][] edges) {
        boolean[] visited = new boolean[edges.length];  

        for(int i=0; i<edges.length ; i++) {  //here we loop through entire visited array
        	//to print even the non connected components if they aren't visited yet
            if(!visited[i]){
                printV(edges, visited, i);
            }				
        }		
    }
	
	public static void printV(int[][] edges, boolean[] visited, int sv) {
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(sv);
        visited[sv] = true;
        
        while(!q.isEmpty()){
           int vertex = q.poll();
           System.out.print(vertex+" ");
                      
           for(int j=0; j<edges.length; j++) {
                if( edges[vertex][j] == 1 && !visited[j] ) {
                	visited[j] = true; 
                	q.add(j);
                }        
           }            
        }   
	}
	
}
