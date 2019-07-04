package tuc.ece.cs102.company;

import tuc.ece.cs102.util.StandardInputRead;
import tuc.ece.cs102.company.model.clients.Client;
import tuc.ece.cs102.company.model.vehicles.Vehicle;


import tuc.ece.cs102.company.RentalCompany;

public class RentalCompanyConsole {
	private RentalCompany company;

	public RentalCompany getRentalCompany() {
		return company;
	}

	public void setRentalCompany(RentalCompany company) {
		this.company = company;
	}

	private StandardInputRead reader;
	public RentalCompanyConsole() {
		company = new RentalCompany();
		reader = new StandardInputRead();
	}

	public static void main(String[] args) {
		RentalCompanyConsole rcc = new RentalCompanyConsole();

		//Handle Choices 
		int userOption = 0;
		StandardInputRead reader = new StandardInputRead();
		while(userOption!=13) {
			printMenu1();
			String userInput = reader.readString("What would you like to do?		<<Press a number to continue through the menu>>\n");
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
				rcc.findVehicle();
				reader.readString("Press enter to continue...\n");
				break;
			case 2:
				rcc.deleteVehicle();
				reader.readString("Press enter to continue...\n");
				break;
			case 3:
				rcc.getRentalCompany().vehicles.print();
				reader.readString("Press enter to continue...\n");
				break;
			case 4:
				rcc.printVehiclesByCategory();
				reader.readString("Press enter to continue...\n");
				break;
			case 5:
				rcc.findClient();
				reader.readString("Press enter to continue...\n");
				break;
			case 6:
				rcc.deleteClient();
				reader.readString("Press enter to continue...\n");
				break;
			case 7:
				rcc.getCompany().newRental();
				reader.readString("Press enter to continue...\n");
				break;
			case 8:	
				rcc.printRentalsBasedOnVehicle();
				reader.readString("Press any key to continue...\n");
				break;
			case 9:		
				rcc.printRentalsBasedOnClient();
				reader.readString("Press any key to continue...\n");
				break;
			case 10:
				rcc.printRentalsBasedOnDatePeriod();
				reader.readString("Press any key to continue...\n");
				break;
			case 11:
				rcc.addNewVehicle();
				reader.readString("Press any key to continue...\n");
				break;
			case 12:
				rcc.addNewClient();
				reader.readString("Press any key to continue...\n");
				break;
				default:
				continue;
			}
		}	
	}

	public RentalCompany getCompany() {
		return company;
	}

	public void setCompany(RentalCompany company) {
		this.company = company;
	}

	//Main Menu
	public static void printMenu1() {
		System.out.println("             Rental Console");
		System.out.println("=========================================");
		System.out.println("1. Search Vehicle........................");
		System.out.println("2. Delete Vehicle Data...................");
		System.out.println("3. Print All Vehicles....................");
		System.out.println("4. Search Vehicles Based on Category.....");
		System.out.println("5. Search Client.........................");
		System.out.println("6. Delete Client Data....................");
		System.out.println("7. Create New Rental.....................");
		System.out.println("....Print Rentals........................");
		System.out.println("8. |Based on Vehicle.....................");
		System.out.println("9. |Based on Client......................");
		System.out.println("10.|Based on Date Period.................");
		System.out.println("11.Enter New Vehicle.....................");
		System.out.println("12.Enter New Client......................");
		System.out.println("13.Exit..................................");
		System.out.println("=========================================");
	}

	//Other Menus
	public static void printMenu2() {
		System.out.println("---------------Energy Type---------------");
		System.out.println("1. Diesel................................");
		System.out.println("2. Gas...................................");
		System.out.println("3. Battery...............................");
	}

	public static void printMenu3() {
		System.out.println("----------------Bike Type----------------");
		System.out.println("1. Cruiser...............................");
		System.out.println("2. Sport.................................");
		System.out.println("3. Touring...............................");
		System.out.println("4. On Off................................");
	}

	public static void printMenu4() {
		System.out.println("1. Truck.................................");
		System.out.println("2. Car...................................");
		System.out.println("3. Bike..................................");
		System.out.println("Enter the Vehicle's Category		<<Press a number to continue through the menu>>\n");
	}

	public static void printMenu5() {
		System.out.println("             Rental Console");
		System.out.println("============================================================");
		System.out.println("1. Calculate Guest Cost per Night Based on Property Type....");
		System.out.println("2. Exit.....................................................");
		System.out.println("============================================================");
	}
	//Other Methods
	public void findVehicle(){							
		String plate = reader.readString("Please enter the Vehicle's License Plate Number: ");					
		Vehicle v = company.searchForVehicle(plate);
		if (v == null){
			System.out.println("Couldn't find this Vehicle!");
		}else{
			v.print();
		}			
	}

	public void findClient() {
		int tin = reader.readPositiveInt("Please enter the Client's T.I.N.: ");
		Client cl = company.searchForClient(tin);
		if (cl == null) {
			System.out.println("Couldn't find this Client!");
		}else {
			cl.print();
		}
	}

	public void deleteVehicle() {
		String plate = reader.readString("Please enter the Vehicle's License Plate Number: ");
		company.deleteVehicle(plate);
	}

	public void deleteClient() {
		int tin = reader.readPositiveInt("Please enter the Client's T.I.N.: ");
		company.deleteClient(tin);
	}

	public void printVehiclesByCategory() {
		String category = reader.readString("What kind of Vehicles would you like to print? \n Type in one of the options: Truck, Car, Bike \n");
		while(!(category.equals("Truck") || category.equals("Car") || category.contentEquals("Bike"))) {
			 category = reader.readString("Invalid answer! \n Type in one of the options: Truck, Car, Bike \n");
		}
		company.printVehiclesByCategory("tuc.ece.cs102.company.model.vehicles."+category);
	}

	public void printRentalsBasedOnVehicle() {
		String plate = reader.readString("Please enter the Vehicle's License Plate Number: ");
		company.printRentalsBasedOnVehicle(plate);
	}

	public void printRentalsBasedOnClient() {
		int tin = reader.readPositiveInt("Please enter the Client's T.I.N.: ");
		company.printRentalsBasedOnClient(tin);
	}

	public void printRentalsBasedOnDatePeriod() {
		System.out.println("Enter the dates in the dd/MM/yyyy format!");
		String sDate1 = reader.readString("Print Rentals from: ");
		String sDate2 = reader.readString("until: ");
		company.printRentalsBasedOnDatePeriod(sDate1, sDate2);
	}

	public void addNewVehicle() {
		RentalCompanyConsole.printMenu4();
		int answer = reader.readPositiveInt("");
		while(answer<=0 || answer>3) {
			System.out.println("Please enter a valid answer!");
			RentalCompanyConsole.printMenu4();
			answer = reader.readPositiveInt("");
		}
		company.addNewVehicle(answer);
	}

	public void addNewClient() {
		String answer = reader.readString("Is the Client a Natural or a Legal Person?(answer with lowercase natural or legal)\n");
		while(!(answer.equals("natural") || answer.equals("legal"))){
			System.out.println("Please enter a valid answer!");
			answer = reader.readString("Is the Client a Natural or a Legal Person?(answer with lowercase natural or legal)\\n");
		}
		company.addNewClient(answer);
	}
	
	public void printPropertiesByCategory() {
		String answer = reader.readString("What type of Properties do you want to search for?(answer with  Villa or Apartment)\n");
		while (!(answer.equals("Villa") || answer.equals("Apartment"))) {
			System.out.println("Please enter a valid answer!");
			answer = reader.readString("What type of Properties do you want to search for?(answer with Villa or Apartment)\n");
		}
		company.printPropertiesByCategory(answer);
	}
}
