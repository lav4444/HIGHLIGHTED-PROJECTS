package aud6Exceptions;

public class ExtremeWays {

	static void method1() throws TomahawkException {
		method2();
		method4();
	}
	static void method2() throws TomahawkException {
		try {
			method3();
		} catch(ArithmeticException ae) {
			System.err.println("Stranded arithmetic error!");
		}
		
	}
	static void method3() throws TomahawkException {
		throw new TomahawkException("TH");
		
	}
	static void method4() {
		throw new UpException("UE");
	}
	static void method5() {
		
	}
	public static void main(String[] args) {
		
		 //method1();
		
		try{
			
			method1();
			
		} catch(TomahawkException | UpException ex) {
			System.out.println(ex.getMessage());
		} 
	}
	
}
