package Recursion;
import java.util.Scanner;
public class printSubsetsOfSumK {
	
	public static void printSubsetsSumTok(int input[],int start,int[] output, int k) {
	//time: O(2^n)   		Space: O(2^n)
	//total calls= 2+ 2^2+ 2^3 + ....+2^n,  n = length of input (draw function call tree to understand)
	// no of calls at level i of the tree will be 2^i 
        if(start==input.length){
            if(k==0){
                for(int i:output){
                    System.out.print(i+" ");
                }
                System.out.println();
                return;
            }
            else
                return;
        }
		
        int[] arr= new int[output.length+1];
        int i=0;
        for(i=0;i<output.length;i++){
            arr[i]=output[i];
        }
        arr[i]=input[start];
        
        printSubsetsSumTok(input, start+1, arr, k-input[start] );
        printSubsetsSumTok(input, start+1, output, k);
	}
    
    public static void printSubsetsSumTok(int input[],int k){
        printSubsetsSumTok(input, 0,new int[0], k);
    }
	
    static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int k = s.nextInt();
		printSubsetsSumTok(input, k);
	}
}
