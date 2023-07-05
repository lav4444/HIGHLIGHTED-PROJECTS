package zadZaVjb4;

public class Vehicle {
	
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Vehicle(String regNo, String model, int year, double price) {
		super();
		this.regNo = regNo;
		this.model = model;
		this.year = year;
		this.price = price;
	}
	private String regNo;
	private String model;
	private int year;
	private double price; //cijena po satu
	
	@Override 
	public String toString() {
		return "Model: "+getModel()+", Reg.Number: "+getRegNo()+", Year: "+ getYear()+", Price per hour: "+ getPrice();
	}
	public double getPricePerDay() {
		return price*24.0;
		
	}
	
	final double getPricePerMonth() {
		return getPricePerDay()*30;
	}
	static Vehicle getNewestVehicle(Vehicle...vozila) {
		int max = vozila[0].getYear();
		Vehicle najveci = vozila[0];
		for (int i=0; i<vozila.length; i++) {
			if (vozila[i].getYear()>max) {
				max = vozila[i].getYear();
				najveci = vozila[i];
			}
		}
		return najveci;
	}
	static void printAllVehiclesWithCargoSpaceGreaterThan(double uvijet, Vehicle...svaVozila) {
		System.out.println("Vehicles with cargo space greater than: "+uvijet+" litres:");
		boolean ima = false;
		for (int i=0; i<svaVozila.length; i++) {
			if ( svaVozila[i] instanceof Car) {
				if ( ((Car)svaVozila[i]).getCargoSpace() > uvijet ) {
					ima = true;
					System.out.println(" - "+ svaVozila[i].getModel()+": "+ ((Car) svaVozila[i]).getCargoSpace() );
				}
			} else if ( svaVozila[i] instanceof CargoVan) {
				if ( ((CargoVan) svaVozila[i]).getMaxLoad() > uvijet) {
					ima = true;
					System.out.println(" - "+ svaVozila[i].getModel()+": "+ ((CargoVan) svaVozila[i]).getMaxLoad() );
				}
				
			}
			
				
		}
		if (!ima) System.out.println("There are not vehicles with cargo space greater than "+uvijet+" litres");
	}
	
	

}
