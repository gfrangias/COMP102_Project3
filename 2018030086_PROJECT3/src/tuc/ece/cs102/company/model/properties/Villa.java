package tuc.ece.cs102.company.model.properties;

public class Villa extends Property{
	private int yardM2;
	private int poolM2;
	
	public Villa(String code, String title, int rooms, int guests, int price, int yard, int pool) {
		super(code, title, rooms, guests, price);
		this.yardM2 = yard;
		this.poolM2 = pool;
	}

	public int getYardM2() {
		return yardM2;
	}

	public void setYardM2(int yardM2) {
		this.yardM2 = yardM2;
	}

	public int getPoolM2() {
		return poolM2;
	}

	public void setPoolM2(int poolM2) {
		this.poolM2 = poolM2;
	}

	public void print() {
		System.out.println("--Property->Villa  "+ toString());
	}
	
	public String toString() {
		return "Property Code: " + this.getPropertyCode()+ " Title: "+this.getTitle()+ "\nNumber of Rooms: "+this.getNumOfRooms()+"\tNumber of Guests: "+this.getNumOfRooms()+"\nPrice per Night: "+this.getPricePerNight()+"\nYard Area in m^2: "+this.yardM2+"\tPool Area in m^2: "+this.poolM2;
	}	
}
