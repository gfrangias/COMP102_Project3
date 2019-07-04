package tuc.ece.cs102.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import tuc.ece.cs102.company.model.Rental;
import tuc.ece.cs102.company.model.clients.Client;
import tuc.ece.cs102.company.model.clients.LegalPerson;
import tuc.ece.cs102.company.model.clients.NaturalPerson;
import tuc.ece.cs102.company.model.enumeration.Energy;
import tuc.ece.cs102.company.model.enumeration.Type;
import tuc.ece.cs102.company.model.properties.Apartment;
import tuc.ece.cs102.company.model.properties.Villa;
import tuc.ece.cs102.company.model.vehicles.Car;
import tuc.ece.cs102.company.model.vehicles.Bike;
import tuc.ece.cs102.company.model.vehicles.Truck;
import tuc.ece.cs102.company.model.vehicles.Vehicle;
import tuc.ece.cs102.company.sortedlists.PropertySortedList;
import tuc.ece.cs102.company.sortedlists.RentalCompanySortedList;
import tuc.ece.cs102.list.Node;
import tuc.ece.cs102.util.DatePeriod;
import tuc.ece.cs102.util.StandardInputRead;

public class RentalCompany {
	private String companyName;
	private int tin;
	private String headquarters;
	public RentalCompanySortedList vehicles;
	private RentalCompanySortedList clients;
	private RentalCompanySortedList rentals;
	private PropertySortedList properties;

	public RentalCompany() {
		companyName = "Chania Vehicle Rental Company";
		tin = 123456789;
		headquarters = "Chania, Greece";
		vehicles = new RentalCompanySortedList();
		clients = new RentalCompanySortedList();
		rentals = new RentalCompanySortedList();
		properties = new PropertySortedList();

		vehicles.insert(new VehicleItem(new Car("XNK5544","Mercedes C200",2012,120000,50,5,1800,4,Energy.Battery)));
		vehicles.insert(new VehicleItem(new Car("XNA1204","Honda Pilot",2019,5000,70,7,3000,5,Energy.Diesel)));
		vehicles.insert(new VehicleItem(new Car("XNM1345","Mercedes MiniBXS",2018,6000,100,12,3000,4,Energy.Diesel)));
		vehicles.insert(new VehicleItem(new Bike("XNO1706","Yamaha YZF-R3",2015,60500,45,2,600,Type.Touring)));
		vehicles.insert(new VehicleItem(new Bike("XNX9901","Kawasaki Ninja 300",2012,32000,30,2,300,Type.Cruiser)));
		vehicles.insert(new VehicleItem(new Truck("XNA1207","VolvoFH16",2017,90000,250,20000,3,4)));
		vehicles.insert(new VehicleItem(new Truck("XNA1208","ScaniaXD1",2018,80000,300,25000,3,3)));

		clients.insert(new ClientItem(new NaturalPerson("Nikos Arabatzis",123456789,3028210373L,"Chania","Greece")));
		clients.insert(new ClientItem(new NaturalPerson("Johanes Stevenson",987654321,4621097275L,"Stockholm","Sweden")));
		clients.insert(new ClientItem(new LegalPerson("Nick Malone",741258963,3536975589L,"Dublin","Ireland",10)));
		clients.insert(new ClientItem(new LegalPerson("Tim Roberg",258963147,3265738648L,"Brussels","Belgium",20)));

		rentals.insert(new RentalItem(new Rental(100,(Client)clients.search(123456789).getData(),(Vehicle)vehicles.search("XNK5544").getData(),StringToDate("03/04/2019"),StringToDate("22/04/2019"),950)));
		rentals.insert(new RentalItem(new Rental(101,(Client)clients.search(987654321).getData(),(Vehicle)vehicles.search("XNA1204").getData(),StringToDate("05/04/2019"),StringToDate("08/04/2019"),210)));
		rentals.insert(new RentalItem(new Rental(102,(Client)clients.search(741258963).getData(),(Vehicle)vehicles.search("XNO1706").getData(),StringToDate("05/06/2019"),StringToDate("15/06/2019"),405)));
		rentals.insert(new RentalItem(new Rental(103,(Client)clients.search(258963147).getData(),(Vehicle)vehicles.search("XNX9901").getData(),StringToDate("05/06/2019"),StringToDate("15/06/2019"),240)));
		rentals.insert(new RentalItem(new Rental(104,(Client)clients.search(123456789).getData(),(Vehicle)vehicles.search("XNA1207").getData(),StringToDate("05/06/2019"),StringToDate("14/06/2019"),2250)));
		rentals.insert(new RentalItem(new Rental(105,(Client)clients.search(987654321).getData(),(Vehicle)vehicles.search("XNA1208").getData(),StringToDate("07/06/2019"),StringToDate("15/06/2019"),2400)));
		rentals.insert(new RentalItem(new Rental(106,(Client)clients.search(741258963).getData(),(Vehicle)vehicles.search("XNK5544").getData(),StringToDate("05/06/2019"),StringToDate("15/06/2019"),450)));
		rentals.insert(new RentalItem(new Rental(103,(Client)clients.search(258963147).getData(),(Vehicle)vehicles.search("XNM1345").getData(),StringToDate("05/08/2019"),StringToDate("15/08/2019"),800)));
		
		properties.insert(new PropertyItem(new Villa("VLL0330","Villa Marina",4,8,560,106,60)));
		properties.insert(new PropertyItem(new Villa("VLL0440","Villa Roma",5,10,800,87,84)));
		properties.insert(new PropertyItem(new Apartment("APT9875","Samaria",2,4,125,3,true)));
	}

	//Getters and Setters
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getTin() {
		return tin;
	}
	public void setTin(int tin) {
		this.tin = tin;
	}
	public String getHeadquarters() {
		return headquarters;
	}
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	//Other Methods 
	//Method to turn String to Date
	public  Date StringToDate(String s) {
		Date d=new Date();
		try {
			SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
			d=sdf1.parse(s);
			return d;
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Vehicle searchForVehicle(String plate){
		VehicleItem vItem = (VehicleItem)vehicles.search(plate);
		if (vItem!=null){		
			return (Vehicle)vItem.getData();
		}else{
			return null;
		}
	}

	public Client searchForClient(int tin) {
		ClientItem clItem = (ClientItem)clients.search(tin);
		if(clItem!=null) {
			return (Client)clItem.getData();
		}else {
			return null;
		}
	}

	public void deleteVehicle(String plate) {
		VehicleItem vItem = (VehicleItem)vehicles.search(plate);
		if (vItem!=null){		
			vehicles.delete(vItem);
			System.out.println("The Vehicle's data were successfully deleted!");
		}else{
			System.out.println("Couldn't find this Vehicle!");
		}
	}

	public void deleteClient(int tin) {
		ClientItem clItem = (ClientItem)clients.search(tin);
		if(clItem!=null) {
			clients.delete(clItem);
			System.out.println("The Client's data were successfully deleted!");
		}else {
			System.out.println("Couldn't find this Client!");
		}
	}

	public void printVehiclesByCategory(String catClass) {
		vehicles.printAllInHierarchy(catClass);
	}

	public void addRental(Rental r) {
		this.rentals.insert(new RentalItem(r));
	}

	//Method to add a new Rental in the List
	public void addNewRental(VehicleItem vItem,ClientItem clItem,Vehicle v,DatePeriod renPer,Date dDate,Date rDate,boolean clientType) {
		int counter = 0;
		Node tmp = rentals.getFirst();
		while(tmp!=null) {
			RentalItem r = (RentalItem)tmp.getValue();
			Rental ren = (Rental)r.getData();
			if(r.getDatePeriod().overlaps(renPer) && v.getLicensePlate().equals(ren.getVehicle().getLicensePlate())) {
				counter=1;
				break;
			}
			tmp=tmp.getNext();
		}

		if(counter == 0) {
			int dayCost = v.getRentalCost();
			StandardInputRead reader = new StandardInputRead();
			int rCode = rentals.getLength() + 100;
			if(clientType) {
				LegalPerson lp = (LegalPerson) clItem.getData();
				int comDiscount = lp.getDiscount();
				int rCost = (dayCost * renPer.toDays()) -(comDiscount * dayCost * renPer.toDays()/100) ;
				Rental r =new Rental(rCode,lp,v,dDate,rDate,rCost);
				addRental(r);
				System.out.println("The rental was succesfully cataloged.");
			}else {
				try {
					if(Class.forName("tuc.ece.cs102.company.model.vehicles.Car").isInstance(vItem.getData())) {
						Car c = ((Car)v);
						if(c.getMaxPassengers()<=7) {
							NaturalPerson np = (NaturalPerson)clItem.getData();
							String answer = reader.readString("Would you like to make a discount?(answer with lowercase yes or no)\n");
							while(!(answer.equals("yes") || answer.equals("no"))){
								answer = reader.readString("Invalid answer!(answer with lowercase yes or no)\n");
							}
							int rCost = rentalCostCalculator(dayCost,renPer,answer);	
							Rental r =new Rental(rCode,np,v,dDate,rDate,rCost);
							addRental(r);
							System.out.println("The rental was succesfully cataloged.");
						}else {
							System.out.println("This Vehicle is for public use only and this Client is a Natural Person!");
						}
					}else {
						NaturalPerson np = (NaturalPerson)clItem.getData();
						String answer = reader.readString("Would you like to make a discount?(answer with lowercase yes or no)\n");
						while(!(answer.equals("yes") || answer.equals("no"))){
							answer = reader.readString("Invalid answer!(answer with lowercase yes or no)\n");
						}
						int rCost = rentalCostCalculator(dayCost,renPer,answer);	
						Rental r =new Rental(rCode,np,v,dDate,rDate,rCost);
						addRental(r);
						System.out.println("The rental was succesfully cataloged.");
					}
				}catch(ClassNotFoundException ex1) {
					System.out.println("");
				}
			}
		}else {
			System.out.println("This Vehicle is not available in this Time Period!");
		}
	}

	public void printRentalsBasedOnVehicle(String plate) {
		int counter = 0;
		Node tmp = rentals.getFirst();
		System.out.println("These are the Rentals of the Vehicle with License Plate: "+plate);
		for(int i=0; i<rentals.getLength(); i++) {
			RentalItem rItem = (RentalItem)tmp.getValue();
			Rental r = (Rental)rItem.getData();
			String rPlate = r.getVehicle().getLicensePlate();
			if(rPlate.equals(plate)) {
				System.out.print((counter+1)+". ");
				r.print();
				counter++;
			}
			tmp = tmp.getNext();
		}
	}

	public void printRentalsBasedOnClient(int tin) {
		int counter = 0;
		Node tmp = rentals.getFirst();
		System.out.println("These are the Rentals of the Client with T.I.N.: "+tin);
		for(int i=0; i<rentals.getLength(); i++) {
			RentalItem rItem = (RentalItem)tmp.getValue();
			Rental r = (Rental)rItem.getData();
			int rTin = r.getClient().getTin();
			if(rTin == tin) {
				System.out.print((counter+1)+". ");
				r.print();
				counter++;
			}
			tmp = tmp.getNext();
		}
	}

	public void printRentalsBasedOnDatePeriod(String sDate1, String sDate2) {
		int counter = 0;
		Node tmp = rentals.getFirst();
		Date date1 = StringToDate(sDate1);
		Date date2 = StringToDate(sDate2);
		DatePeriod renPer1 = new DatePeriod(date1,date2);
		System.out.println("These are the Rentals from "+sDate1+" to "+sDate2);
		for(int i=0; i<rentals.getLength(); i++) {
			RentalItem rItem = (RentalItem)tmp.getValue();
			Rental r = (Rental)rItem.getData();
			Date dDate = r.getDeliveryDate();
			Date rDate = r.getReturnDate();
			DatePeriod renPer2 = new DatePeriod(dDate,rDate);
			if(renPer1.overlaps(renPer2)) {
				System.out.print((counter+1)+". ");
				r.print();
				counter++;
			}
			tmp = tmp.getNext();
		}
	}

	public void addNewVehicle(int answer) {
		StandardInputRead reader = new StandardInputRead();
		String plate = reader.readString("Please Enter the Vehicle's License Plate Number: ");
		String model = reader.readString("Please Enter the Vehicle's Model: ");
		int year = reader.readPositiveInt("Please Enter the Vehicle's Year of First Use: ");
		int mileage = reader.readPositiveInt("Please Enter the Vehicle's Mileage in Km: ");
		int rCost = reader.readPositiveInt("Please Enter the Vehicle's Cost per Day in Euros: ");
		if(answer==1) {
			int maxPayload = reader.readPositiveInt("Please Enter the Max Payload in Kg: ");
			double width = (double)reader.readPositiveFloat("Please	Enter the Truck's Width: ");
			double height = (double)reader.readPositiveFloat("Please Enter the Truck's Height: ");
			vehicles.insert(new VehicleItem(new Truck(plate,model,year,mileage,rCost,maxPayload,width,height)));
			System.out.println("Truck successfully cataloged!");
		}else if(answer==2) {
			int maxPassengers = reader.readPositiveInt("Please Enter the Car's Max Passengers: ");
			int cc = reader.readPositiveInt("Please Enter the Car's cc: ");
			int doors = reader.readPositiveInt("Please enter the Car's Doors Number: ");

			int userOption = 0;
			while(userOption!=1 && userOption!=2 && userOption!=3) {
				RentalCompanyConsole.printMenu2();
				String userInput = reader.readString("What is the Energy Type of the Car?		<<Press a number to continue through the menu>>\n");
				if (userInput == null) {
					continue;
				}else {
					try {
						userOption = Integer.parseInt(userInput);
					} catch(NumberFormatException ex) {
						userOption = 0;
					}
				}

				switch (userOption) {
				case 0:
					continue;
				case 1:
					vehicles.insert(new VehicleItem(new Car(plate,model,year,mileage,rCost,maxPassengers,cc,doors,Energy.Diesel)));
					break;
				case 2:
					vehicles.insert(new VehicleItem(new Car(plate,model,year,mileage,rCost,maxPassengers,cc,doors,Energy.Gas)));
					break;
				case 3:
					vehicles.insert(new VehicleItem(new Car(plate,model,year,mileage,rCost,maxPassengers,cc,doors,Energy.Battery)));
					break;
				default:
					continue;
				}
			}
			System.out.println("Car successfully cataloged!");
		}else {
			int maxPassengers = reader.readPositiveInt("Please Enter the Bike's Max Passengers: ");
			while(maxPassengers>3) {
				System.out.println("You can't Enter a Bike with more than 3 Passengers!");
				maxPassengers = reader.readPositiveInt("Please Enter the Bike's Max Passengers: ");
			}
			int cc = reader.readPositiveInt("Please Enter the Bike's cc: ");
			int userOption = 0;
			while(userOption!=1 && userOption!=2 && userOption!=3 && userOption!=4) {
				RentalCompanyConsole.printMenu3();
				String userInput = reader.readString("What is the Type of the Bike?		<<Press a number to continue through the menu>>\n");
				if (userInput == null) {
					continue;
				}else {
					try {
						userOption = Integer.parseInt(userInput);
					} catch(NumberFormatException ex) {
						userOption = 0;
					}
				}

				switch (userOption) {
				case 0:
					continue;
				case 1:
					vehicles.insert(new VehicleItem(new Bike(plate,model,year,mileage,rCost,maxPassengers,cc,Type.Cruiser)));
					break;
				case 2:
					vehicles.insert(new VehicleItem(new Bike(plate,model,year,mileage,rCost,maxPassengers,cc,Type.Sport)));
					break;
				case 3:
					vehicles.insert(new VehicleItem(new Bike(plate,model,year,mileage,rCost,maxPassengers,cc,Type.Touring)));
					break;
				case 4:
					vehicles.insert(new VehicleItem(new Bike(plate,model,year,mileage,rCost,maxPassengers,cc,Type.On_Off)));
					break;
				default:
					continue;
				}
			}
			System.out.println("Bike successfully cataloged!");
		}
	}


	public void addNewClient(String answer) {
		StandardInputRead reader = new StandardInputRead();
		String name = reader.readString("Please Enter the Client's Full Name: ");
		int tin = reader.readPositiveInt("Please Enter the Client's T.I.N.: ");
		long phone = (long)reader.readPositiveFloat("Please Enter the Client's Phone Number: ");
		String town = reader.readString("Please Enter the Client's Town of Origin: ");
		String country = reader.readString("Please Enter the Client's Country of Origin: ");
		if(answer.equals("natural")){
			clients.insert(new ClientItem(new NaturalPerson(name,tin,phone,town,country)));
		}else {
			int discount = reader.readPositiveInt("Please Enter the desirable Discount for this Company: ");
			clients.insert(new ClientItem(new LegalPerson(name,tin,phone,town,country,discount)));
		}
	}

	//Method to calculate a new Rental's final Cost
	public int rentalCostCalculator(int dayCost, DatePeriod renPer, String answer) {
		StandardInputRead reader = new StandardInputRead();
		int rCost;
		if(answer.equals("yes")){
			int discount = reader.readPositiveInt("Enter the % Discount: ");
			rCost = (dayCost * renPer.toDays()) -(discount * dayCost * renPer.toDays()/100) ;																			
		}else{
			rCost = dayCost * renPer.toDays();
		}
		return rCost;
	}

	//Method for the user to enter new Rental info
	public void newRental() {
		StandardInputRead reader = new StandardInputRead();
		boolean clientType = false;
		String plate = reader.readString("Please enter the Vehicle's License Plate Number: ");
		int tin = reader.readPositiveInt("Please enter the Client's T.I.N.: ");
		System.out.println("Enter the dates in the dd/MM/yyyy format!");
		String delDate = reader.readString("Please enter the Rental's delivery date: ");
		String retDate = reader.readString("Please enter the Rental's return date: ");
		VehicleItem vItem = (VehicleItem)vehicles.search(plate);
		ClientItem clItem = (ClientItem)clients.search(tin);
		if(clItem==null || vItem==null) {
			System.out.println("This client and/or vehicle do(es) not exist in the data base!");
		}else {
			Vehicle v = (Vehicle)vItem.getData();
			Date dDate = StringToDate(delDate);
			Date rDate = StringToDate(retDate);
			DatePeriod renPer = new DatePeriod(dDate,rDate);
			try {
				if(Class.forName("tuc.ece.cs102.company.model.clients.LegalPerson").isInstance(clItem.getData())) {
					clientType = true;
				}else {
					clientType = false;
				}
			}catch(ClassNotFoundException ex) {
				System.out.println("");
			}
			this.addNewRental(vItem,clItem,v,renPer,dDate,rDate,clientType);
		}
	}
	
	public void printPropertiesByCategory(String catClass) {
		properties.printAllInHierarchy(catClass);
	}
}