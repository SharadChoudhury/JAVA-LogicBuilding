package Graphs;

public class findWordInMatrix {

	int solve(String[] Graph , int N, int M) {
		//Time:  O(M*N)				Space:O(M*N)
		
		String s = "CODINGNINJA";
        char[][] grid = new char[N][M];
        for(int i=0; i<N; i++){
            grid[i] = Graph[i].toCharArray();  //converting input Graph to grid format
        }
        
        //	O(N*M)
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(grid[i][j] == 'C'){   //we have to first find 'C' to check if word exists
                	// in the grid
                    if( search(grid,i,j,s) == true)  
                        return 1;
                }
            }
        }
        
        return 0;
	}
    
	// O(k)  , k=11
    boolean search (char[][] grid, int i, int j, String s){
        //in the end, if the word is found, then string will be empty, so return true
        if(s.length() == 0)
            return true;
        
        int M = grid[0].length;
        int N = grid.length;
        
        if(i<0 || i>=N || j<0 || j>=M) 			//if i or j beyond grid size
            return false;
           
        if(grid[i][j] == s.charAt(0)){			//if the grid(i,j) is equal to the 1st character
        	// of the given word to be found, then check if the 2nd char can be found in any of the 
        	// 8 directions from this cell
        	
        	//mark this cell as visited till all the calls on this cell are done
            char temp = grid[i][j];
            grid[i][j] = '#'; 			//to mark as visited just change the cell value 
            
            boolean res = 
                search(grid, i-1, j,   s.substring(1)) ||  	//above cell
                search(grid, i-1, j-1, s.substring(1)) ||	//diagonally above and left
                search(grid, i-1, j+1, s.substring(1)) ||	//diagonally above and right
                search(grid, i,   j-1, s.substring(1)) ||	//left cell
                search(grid, i,   j+1, s.substring(1)) ||	//right cell
                search(grid, i+1, j-1, s.substring(1)) ||	//below left diagonal cell
                search(grid, i+1, j,   s.substring(1)) ||	//below cell
                search(grid, i+1, j+1, s.substring(1)) ;	//below right diagonal cell
                
            grid[i][j] = temp;  //restore the actual value of the cell, after all calls
            //This is done so that if the word is not found in this traversal, then we can traverse
            //this cell again from another starting cell where 'C' will be found
            return res;
        }
        
        return false;
    }
	
}
