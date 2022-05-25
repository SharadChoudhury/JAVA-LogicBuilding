package _2Darrays;

public class largestRowOrColumn {
	
	public static void findLargest(int mat[][]){
		int rows=mat.length;
		if(rows>0) {
			
			int cols= mat[0].length;
			int maxrow=0;
			int maxcol=0;
			
			int maxrowsum=Integer.MIN_VALUE;
			
			for(int i=0;i<rows;i++) {
				int rowsum=0;
				for(int j=0;j<cols;j++) {
					rowsum+=mat[i][j];
				}
				if(rowsum>maxrowsum) {
					maxrowsum=rowsum;
					maxrow=i;
				}					
			}
			
			int maxcolsum=Integer.MIN_VALUE;
			for(int j=0;j<cols;j++) {
				int colsum=0;
				for(int i=0;i<rows;i++) {
					colsum+=mat[i][j];
				}
				if(colsum>maxcolsum) {
					maxcolsum=colsum;
					maxcol=j;
				}					
			}
			
			if(maxrowsum>=maxcolsum) {
				System.out.println("row "+maxrow+" "+maxrowsum);
			}
			else{
				System.out.println("column "+maxcol+" "+maxcolsum);
			}
		}
		 else{
	         System.out.println("row 0 "+ Integer.MIN_VALUE);
	         return;
	        }
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr= {{1,2,3},{1,2,3}};
		findLargest(arr);
	}

}
