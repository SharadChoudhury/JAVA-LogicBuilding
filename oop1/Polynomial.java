package oop1;

public class Polynomial {
	private int[] coefficient;
		
	public Polynomial() {
		coefficient = new int[0];
	}
	
	public void setCoefficient(int degree, int coeff){
		if(degree>=coefficient.length)
			this.restruct(degree);
		coefficient[degree]=coeff;
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
		for(int i=0;i<coefficient.length;i++) {
			if(coefficient[i]!=0)
				System.out.print(coefficient[i]+"x"+i+" ");
		}
	}

	
	 //Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){			
		if(coefficient.length < p.coefficient.length) {
			Polynomial newp= new Polynomial();
			int i;
			for(i=0;i<coefficient.length;i++) {
				newp.setCoefficient(i, this.coefficient[i]+ p.coefficient[i]);
			}	
			for(;i<p.coefficient.length;i++) {
				newp.setCoefficient(i, p.coefficient[i]);
			}
			return newp;
		}
		else {
			Polynomial newp= new Polynomial();
			int i;
			for(i=0;i<p.coefficient.length;i++) {
				newp.setCoefficient(i, this.coefficient[i]+ p.coefficient[i]);
			}	
			for(;i<coefficient.length;i++) {
				newp.setCoefficient(i, this.coefficient[i]);
			}
			return newp;
		}
		
	}
	
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
		if(coefficient.length < p.coefficient.length) {
			Polynomial newp= new Polynomial();
			int i;
			for(i=0;i<coefficient.length;i++) {
				newp.setCoefficient(i, this.coefficient[i] - p.coefficient[i]);
			}	
			for(;i<p.coefficient.length;i++) {
				newp.setCoefficient(i, -p.coefficient[i]);
			}
			return newp;
		}
		else {
			Polynomial newp= new Polynomial();
			int i;
			for(i=0;i<p.coefficient.length;i++) {
				newp.setCoefficient(i, this.coefficient[i] - p.coefficient[i]);
			}	
			for(;i<coefficient.length;i++) {
				newp.setCoefficient(i, this.coefficient[i]);
			}
			return newp;
		}
		
	}

	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){

			Polynomial newp= new Polynomial();
			newp.coefficient = new int[coefficient.length + p.coefficient.length];
			
			int i,j;
			for(i=0 ; i < this.coefficient.length ; i++) {
				for(j=0 ; j < p.coefficient.length ; j++) {
					newp.setCoefficient(i+j, newp.coefficient[i+j] + this.coefficient[i] * p.coefficient[j]);
				}
			}	
			return newp;
	}
	
	
	public void restruct(int degree) {
		int temp[] = coefficient;
		coefficient= new int[degree+1];
		for(int i=0;i<temp.length;i++) {
			coefficient[i]=temp[i];
		}
	}
	
}
