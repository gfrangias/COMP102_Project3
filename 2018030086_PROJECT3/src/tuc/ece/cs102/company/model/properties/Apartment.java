package tuc.ece.cs102.company.model.properties;

public class Apartment extends Property{
	private int floor;
	private boolean balcony;
	
	public Apartment(String code, String title, int rooms, int guests, int price, int floor, boolean balcony) {
		super(code, title, rooms, guests, price);
		this.floor = floor;
		this.balcony = balcony;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public boolean isBalcony() {
		return balcony;
	}

	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}
	
	public String balconyYesNo(boolean balcony) {
		if(balcony) {
			return "Yes";
		}else {
			return "No";
		}
	}
	
	public void print() {
		System.out.println("--Property->Apartment  "+ toString());
	}
	
	public String toString() {
		return "Property Code: " + this.getPropertyCode()+ " Title: "+this.getTitle()+ "\nNumber of Rooms: "+this.getNumOfRooms()+"\tNumber of Guests: "+this.getNumOfRooms()+"\nPrice per Night: "+this.getPricePerNight()+"\nFloor: "+this.floor+"\tBalcony: "+balconyYesNo(this.balcony);
	}	

}
