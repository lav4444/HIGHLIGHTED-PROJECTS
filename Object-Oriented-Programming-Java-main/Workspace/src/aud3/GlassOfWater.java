package aud3;

public class GlassOfWater {
	private int kapacitet;
	private int sadrzajV;
	private int kockeL;
	public GlassOfWater(int zapremnina, int sadrzajV, int kockeL) {
		this.kapacitet = zapremnina;
		this.sadrzajV = sadrzajV;
		this.kockeL = kockeL;
		
	}
	
	public void addWater(int waterAmount) {
		System.out.printf("Status prior(ml): %d\nAmount of Water Added(ml): %d\n", sadrzajV+kockeL*50 , waterAmount);
		sadrzajV += waterAmount;
		if (sadrzajV + kockeL*50 > kapacitet) {
			System.out.printf("Status after(ml): %d\n", kapacitet);
			System.out.println("OVERFLOW!");
			System.out.printf("%d ml of water spilled\n", sadrzajV + kockeL*50 - kapacitet);
			sadrzajV = sadrzajV - (sadrzajV + kockeL*50 - kapacitet);
			
		} else {
			System.out.printf("Status after(ml): %d\n", sadrzajV + kockeL*50);
		}
		System.out.println("-------------------");
		return;
	}
	
	public void addIceCubes(int numberOfIceCubes) {
		System.out.printf("Status prior(ml): %d\nNumber of Ice Cubes Added: %d\n", sadrzajV+kockeL*50 , numberOfIceCubes);
		kockeL += numberOfIceCubes;
		if (sadrzajV + kockeL*50 > kapacitet) {
			
			int prelV = 0;
			int prelL = 0;
			while(sadrzajV + kockeL*50 > kapacitet) {
				if (sadrzajV != 0) {
					prelV++;
					sadrzajV--;
				} else {
					prelL++;
					kockeL--;
				}
				
			}
			System.out.printf("Status after(ml): %d\n", sadrzajV + kockeL*50);
			System.out.println("OVERFLOW!");
			System.out.printf("%d ml of water spilled\n", prelV);
			System.out.printf("%d  ice cubes spilled\n", prelL);
			
		} else {
			System.out.printf("Status after(ml): %d\n", sadrzajV + kockeL*50);
		}
		
		System.out.println("-------------------");
		return;
	}
	

}
