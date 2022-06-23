package Recursion;

import java.util.Scanner;

public class PrintKeypadCombinations {

	public static void printKeypad(int input, String outputSofar){
	//time: O(4^n) ; n = no.of digits in input n (determine this by counting no of function calls)
	//for n=2, there are max 16 calls if each digit has 4 keypad chars, ie, 4^2= 4^n
	//space: O(4^n)
		if(input==0){
            System.out.println(outputSofar);
        	return;
        }
        String outputPrev= outputSofar;  
        String[] keys= helper(input%10);
        for(int i=0;i<keys.length;i++){
            outputSofar = keys[i]+outputPrev;
            printKeypad(input/10,outputSofar);          
        }
	}
    public static void printKeypad(int input){
        printKeypad(input,"");
    }
    
    public static String[] helper(int n){
        switch(n) {
        case 2:
        	return new String[]{"a","b","c"};
        case 3:
        	return new String[]{"d","e","f"};
        case 4:
        	return new String[]{"g","h","i"};
        case 5:
        	return new String[]{"j","k","l"};
        case 6:
        	return new String[]{"m","n","o"};
        case 7:
        	return new String[]{"p","q","r","s"};
        case 8:
        	return new String[]{"t","u","v"};
        case 9:
        	return new String[]{"w","x","y","z"};
        default:
        	return new String[] {""};
        }
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		printKeypad(input);
	}

}
