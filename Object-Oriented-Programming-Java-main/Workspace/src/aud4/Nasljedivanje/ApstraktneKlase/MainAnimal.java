package aud4.Nasljedivanje.ApstraktneKlase;

public class MainAnimal {

	public static void main(String[] args) {
		SeaAnimal o = new Octopus();
		o.printSpecies();
		
		System.out.println();
		System.out.println();
		
		Animal a = new Octopus();
		a.introduceYourself();
		//notice that we cannot write a.wayOfMovement()
		SeaAnimal b = new Octopus();
		b.introduceYourself();
		b.wayOfMovement();		
		Fish c = new Fish();
		c.introduceYourself();
		c.wayOfMovement();
		
		System.out.println();
		System.out.println();
		
		Duck d = new Duck();
		d.introduceYourself();
		d.makeSound();
		
		Lion li = new Lion();
		li.introduceYourself();
		li.makeSound();
	}

}
