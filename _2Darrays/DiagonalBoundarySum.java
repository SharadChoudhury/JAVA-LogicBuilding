package _2Darrays;
import java.util.*;
public class DiagonalBoundarySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int m= s.nextInt();
		int[][] mat= new int[m][m];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				mat[i][j]=s.nextInt();
			}
		}
		
		int sum=0;
		int k=m-1;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				if( (i==0 || i==m-1 || j==0 || j==m-1 || i==j) && j!=k) 
				{	System.out.print(mat[i][j]+" ");
					sum+= mat[i][j];
				}
			}
			sum+=mat[i][k];
			System.out.print(mat[i][k]+" ");
			k--;
		}
		
		System.out.println(sum);
	}

}
