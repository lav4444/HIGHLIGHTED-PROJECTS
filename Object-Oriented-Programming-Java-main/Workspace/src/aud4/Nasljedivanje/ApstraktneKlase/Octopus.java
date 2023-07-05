package aud4.Nasljedivanje.ApstraktneKlase;

public class Octopus extends SeaAnimal {
	
	private SeaSpecies vrsta;
	
	public Octopus() {
		this.vrsta = SeaSpecies.CEPHALOPOD;
	}
	public SeaSpecies getVrsta() {
		return vrsta;
	}

	@Override
	void wayOfMovement() {
		System.out.println("I move by moving my 8 legs!");
		
	}

	@Override
	void printSpecies() {
		System.out.println("Species: "+ getVrsta() );
		
	}

}
