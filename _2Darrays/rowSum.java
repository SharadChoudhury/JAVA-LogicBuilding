package _2Darrays;

public class rowSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat= {};		
		int m= mat.length;
        
        if(m>0){			
        	//gives array index out of bounds exception for mat={}
               	int n= mat[0].length;             	
                for(int i=0;i<m;i++){
                int sum=0;
                for(int j=0;j<n;j++){
                    sum+=mat[i][j];
                }
                System.out.print(sum+" ");
            }
        }
        
	}

}
