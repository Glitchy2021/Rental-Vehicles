import java.util.Scanner;

public class EmployeeGUI implements UserInterface {
	
	// No constructor needed, calls static methods of the SystemInterface.
	// Method start begins a command loop that repeatedly: (a) displays a menu of options, 
      // (b) gets the selected option from the user, and (c) executes the corresponding command.

	private boolean quit = false;
 	public void start(Scanner input) {

	int selection;

	// command loop
	while(!quit) {
		displayMenu();
		selection = getSelection(input);
		execute(selection, input);
	}
      }
	
     // ------- private methods

      private void execute(int selection, Scanner input)
	{
    int veh_type;
	int num_miles_driven;
	int num_day_used;
	int day=0;
	String vin;  
 	String[] display_lines;
	RentalDetails rental_details=null;  
	ReservationDetails reserv_details=null;

	switch(selection) {

		// display rental rates
		case 1: veh_type = getVehicleType(input);
		display_lines=null;
				switch(veh_type) {
				    case 1: display_lines = SystemInterface.getCarRates(); break;
				    case 2: display_lines = SystemInterface.getSUVRates(); break;
			      	case 3: display_lines = SystemInterface.getMinivanRates(); break;
				}
				displayResults(display_lines);
				break;

		// display available vehicles
		case 2:	veh_type = getVehicleType(input);
		display_lines=null;
				switch(veh_type) {
				    case 1: display_lines = SystemInterface.getAvailCars(); break;
				    case 2: display_lines = SystemInterface.getAvailSUVs(); break;
			      	case 3: display_lines = SystemInterface.getAvailMinivans(); break;
				}
				displayResults(display_lines);
				break;
		// display estimated rental cost
		case 3:	rental_details = getRentalDetails(input);
				display_lines = SystemInterface.calcEstimatedRentalCost(rental_details);
				displayResults(display_lines);
				break;
		 		
		// make a reservation
		case 4:	reserv_details = getReservationDetails(input);
				display_lines = SystemInterface.makeReservation(reserv_details);
				displayResults(display_lines);
				break;
		// Displaying all reservations
		case 5: 
				display_lines = SystemInterface.getAllReservations();
				displayResults(display_lines);
				break;
		
		// cancel a reservation
		case 6:	vin = getVIN(input);
				display_lines = SystemInterface.cancelReservation(vin);
				displayResults(display_lines);
				break;

		// process returned vehicle
		case 7:	
				vin = getVIN(input);
				System.out.println("Enter number of miles");
				num_miles_driven = input.nextInt();
				if(rental_details.getRentalPeriod().getUnit()=='Y')
				{
					day =rental_details.getRentalPeriod().getQulity()*365;
				}
				else
				{
					if(rental_details.getRentalPeriod().getUnit()=='M')
					{
					day =rental_details.getRentalPeriod().getQulity()*30;
					}
				}
				num_day_used = day;
				display_lines = SystemInterface.processReturnedVehicle(vin,num_day_used,num_miles_driven);
				displayResults(display_lines);
				break;

		// quit program
		case 8: quit = true;
		break;
			}
	}

	private void displayMenu() {   
 	// displays the user options
	System.out.println("------------------------------------------------------");
	System.out.println("1:Rental Rates");
	System.out.println("2:Avaliable vehicles");
	System.out.println("3:Rental Cost");
	System.out.println("4:Make Reservation");
	System.out.println("5:Display a reservation");
	System.out.println("6:Cancel Reservation");
	System.out.println("7:Process retuns");
	System.out.println("8:Quit");
	System.out.println("------------------------------------------------------");

	

	}

	private int getSelection(Scanner input) {  
	System.out.print("Enter number:"); 
 	// prompts user for selection from menu (continues to prompt if selection < 1 or selection > 8)
	int selected = input.nextInt();
	if(selected < 1|| selected>8)
	{
		return 0;
	}
	else
	{
		return selected;
	}
	}
	private String getVIN(Scanner input){ 
	// prompts user to enter VIN for a given vehicle (does not do any error checking on the input) {    }
	System.out.println("Enter the VIN number: ");
	String Vin = input.next();
	return Vin;
}

	private int getVehicleType(Scanner input){ 
	// prompts user to enter 1, 2, or 3, and returns (continues to prompt user if invalid input given) {    }
	int num =0;
	boolean loop = true;
	System.out.println("Enter the type of car number (1=Car, 2=SUV, 3 Minivan): ");	
	while(loop)
	{
		num = input.nextInt();
		if(num<4)
		{
			loop = false;
		}
		else
		{
			System.out.println("Incorrect Number. Please try again");
			System.out.println("Enter the VIN number (1=Car, 2=SUV, 3=Minivan): ");
			num = input.nextInt();
		}
	}
	return num;
}

	private RentalDetails getRentalDetails(Scanner input) { 
	// prompts user to enter required information for an estimated rental cost (vehicle type, estimated  
 	// number of miles expected to be driven, expected rental period and optional insuranc, returning the
 	// result packaged as a RentalDetails object (to pass in method calls to the SystemInterface) {   }
	
		System.out.println("Enter Vehicle type");
		String veh_type2 = input.next();
		System.out.println("Enter the number of miles expected to be driven (expected): ");
		int miles = input.nextInt();

		System.out.println("Enter Rental period: ");
		System.out.print("Enter unit (Y,M,D): ");
		String uniy = input.next();
		char uni = uniy.charAt(0);
		System.out.print("Enter quality: ");
		int qual = input.nextInt();


		System.out.println("Do you have insursance (Y/N): ");
		String ans = input.nextLine();
		boolean insure;
		if(ans.equals("Y")|| ans.equals("y"))
		{
			insure = true;
		}
		else
		{
			insure = false;
		}
		TimePeriod  time = new TimePeriod(uni,qual);
		RentalDetails rent = new RentalDetails(veh_type2, time, miles, insure);
		
        
		return rent;

	}

	private ReservationDetails getReservationDetails(Scanner input){ 
	// prompts user to enter required information for making a reservation (VIN of vehicle to reserve, 
 	// credit card num, rental period, and optional insurance), returning the result packaged as a 
 	// ReservationDetails object (to pass in method calls to the SystemInterface)  {    }
		System.out.println("Enter name (No spaces): ");
		String name = input.next();
		System.out.println("Enter VIN: ");
		String vin = input.next();
		System.out.println("\nEnter Credit Card Number: ");
		String credit = input.next();

		System.out.println("Enter Rental period: ");
		System.out.print("Enter unit: ");
		String uniy = input.next();
		char uni = uniy.charAt(0);
		System.out.print("Enter quality: ");
		int qual = input.nextInt();


		System.out.println("Do you have insursance (Y/N): ");
		String ans = input.next();
		boolean insure;
		if(ans.equals("Y")|| ans.equals("y"))
		{
			insure = true;
		}
		else
		{
			insure = false;
		}
		TimePeriod  time = new TimePeriod(uni,qual);
		ReservationDetails RD = new ReservationDetails(name, credit, time, insure, vin);

		return RD;

	}

	private void displayResults(String[] lines) { 
	// displays the array of strings passed, one string per screen line {    }
		for (int a=0; a< lines.length; a++)
		{
			System.out.println((a+1) + ": " + lines[a]);
		}
	}
}

