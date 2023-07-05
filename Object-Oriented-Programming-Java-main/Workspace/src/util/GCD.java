package util;

public class GCD {
	public static Integer GCD (int x, int y) {
		int min = 0;
		if (x >= y) {
			min = y;
		}
		else min = x;
		
		while (1 != 0) {
			//System.out.printf("x = %d, y = %d, min = %d--\n", x, y, min);
			if ( (x%min==0) && (y%min==0) ) {
				break;
			} 
			else min--;
		}
		
		
		return min;
		
	}

}
