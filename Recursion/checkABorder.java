package Recursion;
/*
a. The string begins with an 'a'
b. Each 'a' is followed by nothing or an 'a' or "bb"
c. Each "bb" is followed by nothing or an 'a'
*/

public class checkABorder {
	
	public static boolean checkAB(String s) 
	{
		//time: O(n) ; n = s.length
		//space: O(n) ; n = s.length
	    if (s.length()==0) 
	        return true;
	    if (s.charAt(0) != 'a')
	        return false;
	    if (s.length() >= 3 && "abb".equals(s.substring(0,3)))
	        return checkAB(s.substring(3));
	    else
	        return checkAB(s.substring(1));
	}
	
	public static void main(String[] args) {
		System.out.println(checkAB("ab"));
	}

}
