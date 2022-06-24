package Recursion;
import java.util.*;
public class SubsetOfArray {

	public static int[][] subsets(int input[], int start) {
        if(start==input.length-1)
            return new int[][]{{},{input[start]}};
		int[][] small= subsets(input,start+1);
        int[][] out=new int[small.length*2][];
        
        int i=0;
        for(i=0;i<small.length;i++){
			out[i]=small[i];
        }
        
        for(int j=0;j<small.length;j++) {
        	int[] arr= new int[small[j].length+1];
        	arr[0]=input[start];
        	for(int k=0;k<small[j].length;k++) {
        		arr[k+1]=small[j][k];
        	}
        	out[i]=arr;
        	i++;
        }
        
        return out;
	}
	
	public static int[][] subsets(int input[]){
		return subsets(input,0);
	}
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int output[][] = subsets(input);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

}
