package timeComplexity_test1;

public class sameOrder {

	public static boolean checkSequence(String a, String b) {
		if(b.length()==0)
			return true;
		if(a.length()==0)
			return false;
		
		if(a.charAt(0)==b.charAt(0)) {
			a=a.substring(1);
			b=b.substring(1);
			return checkSequence(a, b);
		}
		else {
			a=a.substring(1);
			return checkSequence(a, b);
		}
			
	}
	
	public static void main(String[] args) {
		System.out.println(checkSequence("breuid", "rbd"));
	}
    
}




