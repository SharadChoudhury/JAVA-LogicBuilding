package oop1;

	public class complexNumbers {
		// Complete this class
	    private int real;
	    private int imaginary;
	    
	    public complexNumbers(int real, int imaginary){
	        this.real=real;
	        this.imaginary=imaginary;
	    }
	    
	    public void plus(complexNumbers c2){
	        this.real= this.real+ c2.real;
	        this.imaginary= this.imaginary+ c2.imaginary;
	    }
	    
	    public void multiply(complexNumbers c2){
	        int new_real= this.real*c2.real - this.imaginary*c2.imaginary;
	        int new_imaginary= this.real*c2.imaginary + this.imaginary*c2.real;
	        this.real = new_real;
	        this.imaginary = new_imaginary;
	    }
	    
	    public void print(){
	        if(imaginary>0)
	            System.out.println(this.real + " + i" + this.imaginary);
	        else
	            System.out.println(this.real + " - i" + (-this.imaginary));
	    }
		
	}
