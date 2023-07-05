package zadZaVjb4;

public class CargoVan extends Van {
	
	private double maxLoad; //u kg

	public CargoVan(String regNo, String model, int year, double price, double height, int noOfSeats, double maxLoad) {
		super(regNo, model, year, price, height, noOfSeats);
		this.maxLoad = maxLoad;
	}

	public double getMaxLoad() {
		return maxLoad;
	}

	public void setMaxLoad(double maxLoad) {
		this.maxLoad = maxLoad;
	}
	public double getPricePerDay() {
		return getPrice()*24.0*1.1;
		
	}

}
