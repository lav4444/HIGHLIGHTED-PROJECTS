package aud4.Nasljedivanje.ApstraktneKlase;

public abstract class SeaAnimal extends Animal {

	abstract void wayOfMovement();
	
	@Override
	public void introduceYourself() {
		System.out.println("I am a sea animal!");
	}
	abstract void printSpecies();


}
