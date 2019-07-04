package tuc.ece.cs102.company.model.clients;

public class LegalPerson extends Client{
	private int discount;
	public LegalPerson(String name, int tin, long phone, String town, String country, int discount) {
		super(name, tin, phone, town, country);
		this.discount = discount;
	}

	//Getter and Setter
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	//Other Methods
	public void print() {
		System.out.println("Client->Legal Person  "+ this.toString());
	}

	public String toString() {
		return "Name: "+this.getName()+"  TIN: "+this.getTin() +"  Phone: "+this.getPhoneNumber() +"  Origin: "+this.getTownOfOrigin()+", "+this.getCountryOfOrigin()+"  Special Discount: "+this.discount+"%";
	}
}
