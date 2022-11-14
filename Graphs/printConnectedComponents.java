package Graphs;
import java.util.*;
public class printConnectedComponents {

	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);		
		int vertices = s.nextInt();
		int edges = s.nextInt(); 
		
		int[][] adjMat = new int[vertices][vertices];
		
		for(int i=0; i<edges ; i++) {
			int v1 = s.nextInt();
			int v2= s.nextInt();
			adjMat[v1][v2] = 1;
			adjMat[v2][v1] = 1;
		}
        
        if(vertices > 0){
            ArrayList<ArrayList<Integer>> arr = connectedPart(adjMat);
            for(int i=0; i<arr.size(); i++){
                for(int j=0; j < arr.get(i).size(); j++){
                    System.out.print(arr.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
        
	}
    
    
    public static ArrayList<ArrayList<Integer>> connectedPart(int[][] edges){
        boolean[] visited = new boolean[edges.length];
        
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<edges.length ; i++) { 
			if( ! visited[i] ){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i); 
                connectedPart(edges, visited, i, list);
                Collections.sort(list);
                output.add(list);
            }            
        }
        
        return output;
    }
    
    
    public static void connectedPart(int[][] edges, boolean[] visited, int sv, ArrayList<Integer> list){
        visited[sv] = true;
        for(int j=0; j< edges.length; j++){
            if(!visited[j] && edges[sv][j] == 1){
                list.add(j);
                connectedPart(edges, visited, j, list);
            }
        }
    }
	
}
