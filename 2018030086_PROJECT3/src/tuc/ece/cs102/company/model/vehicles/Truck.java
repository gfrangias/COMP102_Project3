package tuc.ece.cs102.company.model.vehicles;

public class Truck extends Vehicle{
	private int maxPayload;
	private double width;
	private double height;

	public Truck(String plate, String model, int year, int mileage, int cost, int payload, double width, double height) {
		super(plate, model, year, mileage, cost);
		this.maxPayload = payload;
		this.width = width;
		this.height = height;
	}

	//Getters and Setters
	public int getMaxPayload() {
		return maxPayload;
	}

	public void setMaxPayload(int maxPayload) {
		this.maxPayload = maxPayload;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	//Other Methods
	public void print() {
		System.out.println("--Vehicle->Truck  "+ this.toString());
	}

	public String toString() {
		return "Lisense Plate: "+this.getLicensePlate()+ "  Model: "+this.getModel()+ "--\nYear Of First Use: "+this.getYearOfFirstUse() +"\nMileage in Km: "+this.getMileage()+ "\nRental Cost in Euros: "+this.getRentalCost()+ "\nMaximum Payload in Kg: "+ this.maxPayload+"\nWidth in m: "+ this.width+ "\nHeight in m: "+ this.height+"\n";
	}
}
