package zadZaVjezbu3;

public class Meal {
	

	private Food[] hrane;
	public Meal(Food ... hrane) {
		this.hrane = hrane;
	}
	public void printIngredients() {
		if (weight == 0) {
			for (int i=0; i<hrane.length; i++) {
				System.out.println("Ingredient["+ (int)i +"] = " + hrane[i].toStringInGrams());
			}
		} else {
			int tezina = 0;
			for (int i=0; i<obrok.hrane.length; i++) {
				tezina += obrok.hrane[i].getWeight();
			}
			float mltp = (float) ((weight*1.0)/(tezina*1.0));
			for (int i=0; i<obrok.hrane.length; i++) {
				System.out.println("Ingredient["+ (int)i +"] = " + obrok.hrane[i].type.name + ": p - "+Math.round(obrok.hrane[i].getProtein()*mltp * 10.0) / 10.0+"g, c - "+Math.round(obrok.hrane[i].getCarbs()*mltp * 10.0) / 10.0+"g, f - "+Math.round(obrok.hrane[i].getFat()*mltp * 10.0) / 10.0+"g, w - "+Math.round(obrok.hrane[i].getWeight()*mltp * 10.0) / 10.0+"g");
			}
		}
			return;
	}
	public int getNumberOfIngredients() {
		return hrane.length;
	}
	public Food getIngredient(int index) {
		if (index>=hrane.length || index<0) return null;
		else return hrane[index];
	}
	
	private Meal obrok;
	private int weight=0;;
	public Meal(Meal obrok, int weight) {
		this.obrok = obrok;
		this.weight = weight;
	}
	//https://www.fer.unizg.hr/_download/repository/Zadaci_za_vjezbu_03.pdf
	
}
