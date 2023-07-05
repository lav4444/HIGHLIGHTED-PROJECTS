package zadZaVjb4;

public class Dessert {
	
	public Dessert(String name, double weight, int calories) {
		super();
		this.name = name;
		this.weight = weight;
		this.calories = calories;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	private String name;
	private double weight;
	private int calories;
	@Override
	public String toString() {
		return name + " - weight: "+getWeight()+"g, calories: "+ getCalories();
	}
	public String getDessertType() {
		return "dessert";
	}
	

}
