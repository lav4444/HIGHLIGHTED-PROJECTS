package aud6Exceptions;

import java.util.Arrays;

public class Bankar {
	
	public static void pohlepnoGrabljenje() {
		
		char[] polje = new char[Integer.MAX_VALUE];
		Arrays.fill(polje, '$');
		
		System.out.println("Success!");
	}
	public static void main(String[] args) {
		try {
			pohlepnoGrabljenje();
		} catch (Exception ex) {
			System.err.println("Ha! Uhvacen na djelu!"+ex.getMessage());
		}
	}

}
