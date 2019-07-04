package tuc.ece.cs102.company.model.vehicles;

public abstract class Vehicle {
	private String licensePlate;
	private String model;
	private int yearOfFirstUse;
	private int mileage;
	private int rentalCost;

	public Vehicle(	String plate, String model, int year, int mileage, int cost) {
		this.licensePlate = plate;
		this.model = model;
		this.yearOfFirstUse = year;
		this.mileage = mileage;
		this.rentalCost = cost;
	}

	//Getters and Setters
	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYearOfFirstUse() {
		return yearOfFirstUse;
	}

	public void setYearOfFirstUse(int yearOfFirstUse) {
		this.yearOfFirstUse = yearOfFirstUse;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getRentalCost() {
		return rentalCost;
	}

	public void setRentalCost(int rentalCost) {
		this.rentalCost = rentalCost;
	}

	//Other Methods
	public abstract void print();

	public abstract String toString();

}

