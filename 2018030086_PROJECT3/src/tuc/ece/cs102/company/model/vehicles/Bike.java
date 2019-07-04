package tuc.ece.cs102.company.model.vehicles;

import tuc.ece.cs102.company.model.enumeration.Type;

public class Bike extends Passenger{
	private Type type;

	public Bike(String plate, String model, int year, int mileage, int cost, int passengers, int cc, Type type) {
		super(plate, model, year, mileage, cost, passengers, cc);
		this.type = type;
	}

	//Getter and Setter
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	//Other Methods
	public void print() {
		System.out.println("--Vehicle->Passenger->Bike  "+ this.toString());
	}

	public String toString() {
		return "Lisense Plate: "+this.getLicensePlate()+ "  Model: "+this.getModel()+ "--\nYear Of First Use: "+this.getYearOfFirstUse() +"\nMileage in Km: "+this.getMileage()+ "\nRental Cost in Euros: "+this.getRentalCost()+ "\nMaximum Passengers: "+ this.getMaxPassengers()+ "\nCC: "+this.getCc()+ "\nType: "+this.type+"\n";
	}
}
