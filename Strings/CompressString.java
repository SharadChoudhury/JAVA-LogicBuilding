package Strings;

public class CompressString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="aaabbccdsa";
		String s="";
        for(int i=0;i<str.length();){
            int count=1;
            int j=i+1;
            while(j<str.length() && str.charAt(j)==str.charAt(i)){
                count++;
                j++;
            }
            s+=str.charAt(i);
            if(count>1)
                s+=count;
             i=j;   
        }
        System.out.println(s);

	}

}
