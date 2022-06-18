package Recursion;

public class addStarsBwIdenticalChar {

	public static String addStars(String s) {
// time: O(n), where n=s.length
// space: O(n)
		
//consider base case first		
		if(s.length()<=1)		
			return s;
//for subproblem
		String small= addStars(s.substring(1)); 		
//processing	
//if current substring(s) first char is equal to the returned string(small)'s first character
// then return (s.first char +"*"+ small)   otherwise ,
// return (s.first char + small)    (no star inserted between them)
		if(s.charAt(0)==small.charAt(0))
			return s.charAt(0)+"*"+small;			
		return s.charAt(0)+small;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addStars("asdss"));
	}

}
