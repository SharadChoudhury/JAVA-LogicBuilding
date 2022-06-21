package Recursion;

public class PrintAllCodesString {// top to bottom approach for printing

	public static void printAllPossibleCodes(String input, String output) {
		// time: O(2^n)			space:O(2^n)
		if(input.length()==0){
			System.out.println(output);
        	return;
        }
        
        String out1 = output + (char)(96 + input.charAt(0)-'0');
        printAllPossibleCodes(input.substring(1),out1);
        
        if(input.length()>=2 && Integer.parseInt(input.substring(0,2))>=10 && Integer.parseInt(input.substring(0,2))<=26){
            String out2 = output +  (char)(96 + Integer.parseInt(input.substring(0,2))) ;
            printAllPossibleCodes(input.substring(2), out2);
        }
	}
    
    public static void printAllPossibleCodes(String input){
        printAllPossibleCodes(input, "");
    }
	
	public static void main(String[] args) {
		printAllPossibleCodes("1123");
	}

}
