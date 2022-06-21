package Recursion;
import java.util.*;

public class MergeSort {
	
//method 1		
	public static void mergeSort1(int[] input) {
		mergeSort1(input,0,input.length-1);
	}
	
	private static void mergeSort1(int[] input, int start, int end) {
	//without creating two halves of input each time
	// 	Time: O(nlogn)	,  Space: O(n)
		if(start>=end) 
			return;
		int mid=(start+end)/2;
		mergeSort1(input,start,mid);
		mergeSort1(input,mid+1,end);
		merge1(start,mid,end,input);		
	}

//merge function as per method 1
	private static void merge1(int start, int mid, int end, int[] input) {
		//time: O(n) , space : O(n)
		int i=start, j=mid+1, k=0;
		int[] temp= new int[end-start+1];
		while(i<=mid && j<=end) {
			if(input[i]<=input[j]) {
				temp[k]=input[i];
				k++;
				i++;
			}
			else {
				temp[k]=input[j];
				k++;
				j++;
			}
		}		
		while(i<=mid) {
			temp[k]=input[i];
			i++;
			k++;
		}
		while(j<=end) {
			temp[k]=input[j];
			j++;
			k++;
		}		
		k=0;i=start;
		while(i<=end) {
			input[i]=temp[k];
			k++;
			i++;
		}
	}
	
	
// method 2: without using start and end indexes
	public static void mergeSort2(int[] input) {
//	 	Time: O(nlogn)	,  Space: O(n)
		if(input.length<=1)
			return;
		int mid=input.length/2;
		int[] p1= new int[mid];
		int[] p2= new int[input.length-mid];
		int i=0,j=0;
		while(i<mid){
			p1[i]=input[i];
			i++;
		}
		j=0;
		while(i<input.length) {
			p2[j]=input[i];
			i++;
			j++;
		}
		mergeSort2(p1);
		mergeSort2(p2);
		merge2(p1,p2,input);
	}
	
//merge function as per method 2
	private static void merge2(int arr1[], int arr2[], int input[]) {
//	 	Time: O(n)	,  Space: O(1)
		int i=0,j=0,k=0;
		while(i<arr1.length && j<arr2.length ) {
			if(arr1[i]<=arr2[j]) {
				input[k]=arr1[i];
				k++;
				i++;
			}
			else {
				input[k]=arr2[j];
				k++;
				j++;
			}
		}	
		while(i<arr1.length) {
			input[k]=arr1[i];
			i++;
			k++;
		}
		while(j<arr2.length) {
			input[k]=arr2[j];
			j++;
			k++;
		}		
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
	
	public static void printArray(int input[]) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		mergeSort1(input);
		printArray(input);
	}
}
