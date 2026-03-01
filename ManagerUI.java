import java.util.Scanner;
public class ManagerUI implements UserInterface{


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
      private void execute(int selection, Scanner input)
      {    
        int veh_type;  
        String ans;
        String[] display_lines;
        VehicleRates new_rates = null;
  
      switch(selection){
    

        case 1: 
        veh_type = getVehicleType(input);
		display_lines=null;
				switch(veh_type) {
				    case 1: display_lines = SystemInterface.getCarRates(); break;
				    case 2: display_lines = SystemInterface.getSUVRates(); break;
			      	case 3: display_lines = SystemInterface.getMinivanRates(); break;
				}
				displayResults(display_lines);
                System.out.println("Do you need to update current rate? (Y/N)");
                ans = input.nextLine();
                if(ans.equals("Y"))
                {
                
                veh_type = getVehicleType(input);
		        display_lines=null;
				switch(veh_type) {
				    case 1: 
                    new_rates = getVehicleRates(input);
                    SystemInterface.updateCarRates(new_rates);
                    display_lines = SystemInterface.getCarRates(); break;
				    case 2:
                    new_rates = getVehicleRates(input);
                    SystemInterface.updateSUVRates(new_rates);
                    display_lines = SystemInterface.getSUVRates(); 
                    break;
			      	case 3: 
                    new_rates = getVehicleRates(input);
                    SystemInterface.updateMinivanRates(new_rates);
                    display_lines = SystemInterface.getMinivanRates(); 
                    break;
				}
                }
        case 2:
        display_lines = SystemInterface.getAllVehicles();
        System.out.println("All Vechicles (Unreserved): ");
        displayResults(display_lines);
		break;

        case 3:
        display_lines = SystemInterface.getAllReservations();
        System.out.println("All Reservation: ");
        displayResults(display_lines);
        break;

        case 4:
        display_lines = SystemInterface.getAllTransactions();
        System.out.println("All Transactions: ");
        displayResults(display_lines);
        break;

        case 5:
        quit = true;
        break;
        }
        
  

    }
    


    private void displayMenu() {   
        // displays the user options
       System.out.println("------------------------------------------------------");
       System.out.println("1:Current Rates");
       System.out.println("2:Display Vehicles");
       System.out.println("3:Display Reservations");
       System.out.println("4:Display Transaction");
       System.out.println("5:Quit");
       System.out.println("------------------------------------------------------");

    }   
    private int getSelection(Scanner input) {  
        System.out.print("Enter number:"); 
         // prompts user for selection from menu (continues to prompt if selection < 1 or selection > 8)
        int selected = input.nextInt();
        if(selected < 1|| selected>5)
        {
            return 0;
        }
        else
        {
            return selected;
        }

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
    
    private VehicleRates getVehicleRates(Scanner input)
    {
        System.out.println("Enter Daily Rate: ");
        double daily = input.nextDouble();
        System.out.println("Enter Weekly Rate: ");
        double weekly = input.nextDouble();
        System.out.println("Enter Monthly Rate ");
        double monthly = input.nextDouble();
        System.out.println("Enter Per Miles Charge: ");
        double miles = input.nextDouble();
        System.out.println("Enter Daily Insurance: ");
        double dailyIn = input.nextDouble();

        
        return new VehicleRates(daily, weekly, monthly, miles, dailyIn);


    }
    
    
    
    private void displayResults(String[] lines) { 
        // displays the array of strings passed, one string per screen line {    }
            for (int a=0; a< lines.length; a++)
            {
                System.out.println((a+1) + ": " + lines[a]);
            }
        } 
        
    

}