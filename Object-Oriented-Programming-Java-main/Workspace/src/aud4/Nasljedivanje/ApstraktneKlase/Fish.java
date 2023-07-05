package aud4.Nasljedivanje.ApstraktneKlase;

public class Fish extends SeaAnimal {
	
	private SeaSpecies vrsta;

	public Fish() {
		this.vrsta = SeaSpecies.FISH;
		// TODO Auto-generated constructor stub
	}
	public SeaSpecies getVrsta() {
		return vrsta;
	}

	@Override
	void wayOfMovement() {
		System.out.println("I move by moving my body!");
		
	}

	@Override
	void printSpecies() {
		System.out.println("Species: "+ getVrsta() );
		
	}
	
	
	

}
