package zadZaVjb4;

public class Cake extends Dessert {
	
	private boolean containsGluten;
	private String cakeType;

	public Cake(String name, double weight, int calories, boolean containsGluten, String cakeType) {
		super(name, weight, calories);
		this.cakeType = cakeType;
		this.containsGluten = containsGluten;
	}

	public boolean isContainsGluten() {
		return containsGluten;
	}

	public void setContainsGluten(boolean containsGluten) {
		this.containsGluten = containsGluten;
	}

	public String getCakeType() {
		return cakeType;
	}

	public void setCakeType(String cakeType) {
		this.cakeType = cakeType;
	}
	public String toString() {
		return getName() + " - weight: "+getWeight()+"g, calories: "+ getCalories()+", Contains Gluten: "+isContainsGluten()+", Cake Type: "+getCakeType();
	}
	public String getDessertType() {
		return getCakeType()+" cake";
	}

}
