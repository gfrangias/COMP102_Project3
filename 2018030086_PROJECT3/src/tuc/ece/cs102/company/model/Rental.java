package tuc.ece.cs102.company.model;

import java.util.Date;

import tuc.ece.cs102.company.model.clients.Client;
import tuc.ece.cs102.company.model.vehicles.Vehicle;
import tuc.ece.cs102.util.DatePeriod;

public class Rental {
	private int rentalCode;
	private Client client;
	private Vehicle vehicle;
	private Date deliveryDate;
	private Date returnDate;
	private int rentalCost;
	private DatePeriod period;

	//Class constructors

	public Rental(int code, Client cl, Vehicle vehicle, Date dDate, Date rDate,int rCost) {
		this.rentalCode = code;
		this.client = cl;
		this.vehicle = vehicle;
		this.deliveryDate = dDate;
		this.returnDate = rDate;
		this.rentalCost = rCost;
	}


	//Getters and Setters
	public int getRentalCode() {
		return rentalCode;
	}

	public void setRentalCode(int rentalCode) {
		this.rentalCode = rentalCode;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getRentalCost() {
		return rentalCost;
	}

	public void setRentalCost(int rentalCost) {
		this.rentalCost = rentalCost;
	}

	public DatePeriod getPeriod() {
		return period;
	}

	public void setPeriod(DatePeriod period) {
		this.period = period;
	}
	

	//Other Methods
	//Method used to get (as String) the Renting Period of a Car	
	public String getRentingPeriod(){
		String result = "";
		result += "From: ";
		result += this.deliveryDate.toString();

		result += " Until: ";
		result += this.returnDate.toString();

		return result;	
	}

	public void print() {
		System.out.println(this.toString());
	}

	public String toString() {
		return "Rental Code: " + this.rentalCode+ " Renting Period: "+this.getRentingPeriod()+ " Rental Cost: "+this.getRentalCost();
	}	
}
