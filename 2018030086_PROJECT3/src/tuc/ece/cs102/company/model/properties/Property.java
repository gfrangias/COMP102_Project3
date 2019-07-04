package tuc.ece.cs102.company.model.properties;

public abstract class Property {
	private String propertyCode;
	private String title;
	private int numOfRooms;
	private int numOfGuests;
	private int pricePerNight;
	
	public Property(String code, String title, int rooms, int guests, int price) {
		this.propertyCode = code;
		this.title = title;
		this.numOfRooms = rooms;
		this.numOfGuests = guests;
		this.pricePerNight = price;
	}

	public String getPropertyCode() {
		return propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumOfRooms() {
		return numOfRooms;
	}

	public void setNumOfRooms(int numOfRooms) {
		this.numOfRooms = numOfRooms;
	}

	public int getNumOfGuests() {
		return numOfGuests;
	}

	public void setNumOfGuests(int numOfGuests) {
		this.numOfGuests = numOfGuests;
	}

	public int getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
	public abstract void print();
	
	public abstract String toString();
}
