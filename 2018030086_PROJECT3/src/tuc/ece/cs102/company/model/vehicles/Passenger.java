package tuc.ece.cs102.company.model.vehicles;

public class Passenger extends Vehicle{
	private int maxPassengers;
	private int cc;

	public Passenger(String plate, String model, int year, int mileage, int cost, int passengers, int cc) {
		super(plate, model, year, mileage, cost);
		this.maxPassengers = passengers;
		this.cc = cc;
	}

	//Getters and Setters
	public int getMaxPassengers() {
		return maxPassengers;
	}

	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	//Other Methods
	public void print() {
	}

	public String toString() {
		return null;
	}
}
