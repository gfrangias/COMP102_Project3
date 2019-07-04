package tuc.ece.cs102.company.model.clients;

public abstract class Client {
	private String name;
	private int tin;
	private long phoneNumber;
	private String townOfOrigin;
	private String countryOfOrigin;

	public Client(String name, int tin, long phone, String town, String country) {
		this.name = name;
		this.tin = tin;
		this.phoneNumber = phone;
		this.townOfOrigin = town;
		this.countryOfOrigin = country;
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTin() {
		return tin;
	}

	public void setTin(int tin) {
		this.tin = tin;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTownOfOrigin() {
		return townOfOrigin;
	}

	public void setTownOfOrigin(String townOfOrigin) {
		this.townOfOrigin = townOfOrigin;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	//Other Methods
	public abstract void print();

	public abstract String toString();

}
