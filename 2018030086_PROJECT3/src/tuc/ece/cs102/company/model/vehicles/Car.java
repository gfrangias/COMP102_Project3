package tuc.ece.cs102.company.model.vehicles;

import tuc.ece.cs102.company.model.enumeration.Energy;


public class Car extends Passenger{
	private Energy energyType;
	private int doors;

	public Car(String plate, String model, int year, int mileage, int cost, int passengers, int cc, int doors,Energy energy) {
		super(plate, model, year, mileage, cost, passengers, cc);
		this.energyType = energy;
		this.doors = doors;
	}

	//Getters and Setters
	public Energy getEnergyType() {
		return energyType;
	}

	public void setEnergyType(Energy energyType) {
		this.energyType = energyType;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	//Other Methods
	public void print() {
		System.out.println("--Vehicle->Passenger->Car  "+ this.toString());
	}

	public String toString() {
		return "Lisense Plate: "+this.getLicensePlate()+ "  Model: "+this.getModel()+ "--\nYear Of First Use: "+this.getYearOfFirstUse() +"\nMileage in Km: "+this.getMileage()+ "\nRental Cost in Euros: "+this.getRentalCost()+ "\nMaximum Passengers: "+ this.getMaxPassengers()+ "\nCC: "+this.getCc()+"\nNumber of Doors: "+this.getDoors() +"\nEnergy Type: "+this.energyType+"\n";
	}
}
