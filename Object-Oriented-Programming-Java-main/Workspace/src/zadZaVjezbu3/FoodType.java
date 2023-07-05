package zadZaVjezbu3;

public class FoodType {
	
	static int counter = 0;

	public int getProtein() {
		//System.out.println(protein+"\n");
		return protein;
	}
	public int getCarbs() {
		//System.out.println(carbs+"\n");
		return carbs;
	}
	public int getFat() {
		//System.out.println(fat+"\n");
		return fat;
	}
	public FoodType(String name, int protein, int carbs, int fat) {
		this.name = name;
		this.protein = protein;
		this.carbs = carbs;
		this.fat = fat;
		counter++;
	}

	public String name;
	private int protein;
	private int carbs;
	private int fat;
	
	@Override
	public String toString() {
		return name + ": p - "+getProtein()+"%, c - "+getCarbs()+"%, f - "+getFat()+"%";
	}
	public static int getNumberOfCreatedInstances() {
		return counter;
	}
	

}
