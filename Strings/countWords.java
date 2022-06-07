package Strings;

public class countWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = ""; 
		
////method 1		
//		if(str.length()!=0){
//          	String[] arr= str.split(" ");
//        	int count= arr.length;
//        	System.out.println(count); 
//        }
//        else
//        	System.out.println(0);

//method 2
		if(str.length()!=0) {
			int count=1;
	        int i=0;
	        while(i<str.length()){
	            if(str.charAt(i)==' ')
	            count++;
	            i++;
	        }
	        System.out.println(count);
		}
		else
			System.out.println(0);
        
	}

}
