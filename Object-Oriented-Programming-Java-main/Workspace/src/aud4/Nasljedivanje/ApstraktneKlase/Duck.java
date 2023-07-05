package aud4.Nasljedivanje.ApstraktneKlase;

public class Duck extends Animal implements MakeSound{
	
	@Override
	public void introduceYourself() {
		System.out.println("I am a duck!");
	}

	@Override
	public void makeSound() {
		System.out.println("Quack! Quack!");
		
	}

}
