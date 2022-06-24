package Recursion;

public class StringPalindromeCheck {

	public static boolean isStringPalindrome(String input) {
		
 /* if string length =1 , return true immediately	
	important test-case: when string is empty,i.e string length=0, return true
	0 <= |S| <= 1000
	where |S| represents length of string S. 
*/
		if(input.length()<=1)
			return true;
		
		if( input.charAt(0) != input.charAt(input.length()-1) ){
			return false;
		}
		return  isStringPalindrome(input.substring(1, input.length()-1));

	}
	
	
	public static void main(String[] args) {
		System.out.print(isStringPalindrome(""));

	}

}
