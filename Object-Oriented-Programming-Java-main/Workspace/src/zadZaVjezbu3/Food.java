package zadZaVjezbu3;

public class Food {
	public FoodType getType() {
		return type;
	}
	public int getWeight() {
		return weight;
	}
	public Food(FoodType type, int weight) {
		this.type = type;
		this.weight = weight;
	}
	FoodType type;
	int weight;
	
	@Override
	public String toString() {
		return type.toString() + ", w - " + getWeight() + "g";
	}
	
	public double getProtein() {
		return (double)(type.getProtein()*1.0/100)*getWeight();
	}
	public double getCarbs() {
		return (double)(type.getCarbs()*1.0/100)*getWeight();
	}
	public double getFat() {
		return (double)(type.getFat()*1.0/100)*getWeight();
	}
	
	public String toStringInGrams() {
		return type.name + ": p - "+Math.round(getProtein() * 10.0) / 10.0+"g, c - "+Math.round(getCarbs() * 10.0) / 10.0+"g, f - "+Math.round(getFat() * 10.0) / 10.0+"g, w - "+Math.round(getWeight() * 10.0) / 10.0+"g";
	}
}
