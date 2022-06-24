package Recursion;
import java.util.*;
public class QuickSort {

	// best case:   time= O(nlogn)  	space= O(logn)
	// worst case:  time= O(n^2)		space= O(n)
	public static void quickSort(int[] input, int si, int ei) {
		if(si>=ei)
			return;
		int pivPos= partition(input,si,ei);
		quickSort(input,si,pivPos-1);
		quickSort(input,pivPos+1,ei);    
	}
	
	private static int partition(int[] input, int si, int ei) { 
		//time :O(n)    space :O(1)
		int piv = input[si];
		
		int count=0,i,j;
		for(i=si+1;i<=ei;i++) {
			if(input[i] <= piv)  //if equals is used here use equals in line 30
				count++;
		}
		int pivPos= si + count;
		
		input[si]=input[pivPos];
		input[pivPos]= piv; //now pivot is at pivPos
		
		i=si;
		j=ei;
		while(i<pivPos && j>pivPos){
            if(input[i]<=piv)
                i++;
            else if(input[j]>piv)// if no equals in line 19, use equals here
                j--;
            else{
                int temp= input[i];
				input[i]=input[j];
				input[j]=temp;
				i++;
				j--; 
            }
        }
		return pivPos;
	}
	
	public static void quickSort(int[] input) {
		quickSort(input, 0, input.length - 1);
	}
	

	static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		quickSort(input);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

}
