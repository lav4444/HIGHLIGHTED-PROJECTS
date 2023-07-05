package aud6Exceptions;

public class Prodavac {
	
	public static double zabiljezi(String zapis) {
		String[] splits = zapis.split(",");
		
		double ukp=99;
		int brElem=1;
		double vraceno=99;
		
		if (splits.length != 3) {
			throw new IllegalArgumentException("Poruka: Krivi broj argumenata!");
		}
		
		try {
			splits[0] = splits[0].trim();
			splits[1] = splits[1].trim();
			splits[2] = splits[2].trim();
			ukp = Double.parseDouble(splits[0]);
			brElem = Integer.parseInt(splits[1]);
			vraceno = Double.parseDouble(splits[2]);
			
		} catch (IllegalArgumentException e) {
			System.out.println("Poruka: "+"Krivi tip podatka!");
		}
		if (ukp < 0 || vraceno < 0 || brElem <= 0) {
			throw new IllegalArgumentException("Poruka: Svi argumenti moraju biti pozitivni!");
		}
		if (vraceno > ukp) {
			throw new IllegalArgumentException("Poruka: Vratili ste više nego dobili!");
		}
		
		return (ukp-vraceno)/(brElem * 1.0);
		
	}
	public static void main(String[] args) {
		System.out.println(zabiljezi(" , , ") );
	}

}
