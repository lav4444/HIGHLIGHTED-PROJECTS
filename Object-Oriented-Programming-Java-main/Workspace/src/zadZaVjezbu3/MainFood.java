package zadZaVjezbu3;

public class MainFood {
public static void main(String[] args) {
	FoodType foodType = new FoodType("banana", 4, 93, 3);
	Food food = new Food(foodType, 110);
	System.out.println("protein: " + food.getProtein() + "\ncarbs: " +
	food.getCarbs() + "\nfat: " + food.getFat());
	System.out.println(food.toStringInGrams());
	
	System.out.println();
	System.out.println();
	
	FoodType banana = new FoodType("banana", 4, 93, 3); 
	Food oneBanana = new Food(banana, 110);
	FoodType grapes = new FoodType("grapes", 4, 94, 2); 
	Food grapeCluster = new Food(grapes, 151);
	Meal fruitSalad = new Meal(oneBanana, grapeCluster); 
	fruitSalad.printIngredients();
	System.out.println("*** printing ingredients");
	for (int i = -1; i <= fruitSalad.getNumberOfIngredients(); i++) {
	System.out.println("ingredient[" + i + "] = " + fruitSalad.getIngredient(i)); }
	
	System.out.println();
	System.out.println();
	
	FoodType cbanana = new FoodType("banana", 4, 93, 3); 
	Food coneBanana = new Food(banana, 110); 
	FoodType cgrapes = new FoodType("grapes", 4, 94, 2); 
	Food cgrapeCluster = new Food(grapes, 151); 
	Meal cfruitSalad = new Meal(oneBanana, grapeCluster); 
	System.out.println("* original meal:"); 
	fruitSalad.printIngredients(); 
	System.out.println("* new meal:"); 
	Meal doubleFruitSalad = new Meal(fruitSalad, 522); 
	doubleFruitSalad.printIngredients(); 
}

}
