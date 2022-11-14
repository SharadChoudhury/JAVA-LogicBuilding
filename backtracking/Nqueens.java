package backtracking;

public class Nqueens {

	public static void placeNQueens(int n){
		
		/* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Print output as specified in the question
		 */
			int[][] grid  = new int[n][n];
	    	place(n,grid,0);
		}
    
    public static void place(int n, int[][] grid, int row){
        if(row == n){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
            return ;
        }
        
        for(int i=0; i<n; i++){ //traverse the current row
            //column check           
			int r = row;
            int c = i;
            while(r>=0 && grid[r][c] != 1)
                r--;
            
            if(r != -1)  //some queen present in this column(i)
              continue;  
            
            //diagonal check
            r = row;
            while(r>=0 && c>=0 && grid[r][c] != 1){
                r--;
                c--;               
            }
            
            if(r!= -1 && c!= -1)  //queens present diagonally
                continue;
             
            r = row;
            c = i;
            while(r>=0 && c<n && grid[r][c] != 1){
                r--;
                c++;               
            }
            
            if(r!= -1 && c!= n)	//queens present diagonally
                continue;
            
            else{
                grid[row][i] = 1;
                place(n,grid,row+1);
                grid[row][i] = 0;
            }
                
        }
        
        
    }
	
}
