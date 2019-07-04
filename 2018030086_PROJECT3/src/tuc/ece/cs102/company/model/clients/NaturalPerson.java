package tuc.ece.cs102.company.model.clients;

public class NaturalPerson extends Client{

	public NaturalPerson(String name, int tin, long phone, String town, String country) {
		super(name, tin, phone, town, country);
	}

	//Methods
	public void print() {
		System.out.println("Client->Natural Person  "+ this.toString());
	}

	public String toString() {
		return "Name: "+this.getName()+"  TIN: "+this.getTin() +"  Phone: "+this.getPhoneNumber() +" Origin: "+this.getTownOfOrigin()+", "+this.getCountryOfOrigin();
	}
}
