import java.util.Scanner;

public class AgencyRentalProgram {

    public static void main(String[ ] args) {
    
        // Provide Hard-coded Current Agency Rates
        
        CurrentRates agency_rates = new CurrentRates(new VehicleRates(20.25, 125.00, 300.00, 2000, 350),  // cars
        new VehicleRates(30.50,200.00,500.25,3000,380),  // SUVs
        new VehicleRates(55.75, 350.00, 770.60, 5000, 460)); //minivans
    
        // Create an Initially Empty Vehicles Collection, and Populate
        Vehicles agency_vehicles = new Vehicles();
        populate(agency_vehicles);    // supporting private static method (to be added)
    
        // Create Initially Empty Transactions Object
        Transactions transactions = new Transactions();
    
        // Establish User Interface
        Scanner input = new Scanner(System.in);
        UserInterface ui;
        boolean quit = false;
    
        // Create Requested UI and Begin Execution 
        while(!quit) {  // (allows switching between Employee and Manager user interfaces while running)
    
            ui = getUI(input);
    
            if(ui == null)
                quit = true;
            else {
                // Init System Interface with Agency Data (if not already initialized)
                if(!SystemInterface.initialized())
                      SystemInterface.initSystem(agency_rates, agency_vehicles, transactions);
    
                // Start User Interface
                ui.start(input);
            }
        }
    }
    
    public static UserInterface getUI(Scanner input) {
        boolean valid_selection = false;
        int selection;
        UserInterface UI=null;
    
        while(!valid_selection) {
            System.out.print("1-Employee, 2-Manager, 3-quit:");
    
            selection = input.nextInt();
            if(selection == 1) {
                UI = new EmployeeGUI();
                valid_selection = true;
            }
            else
            if(selection == 2) {
                UI= new ManagerUI();
                valid_selection = true;
            }
            else
            if(selection == 3) {
                UI= null;
                valid_selection = true;
            }
            else
            {
                System.out.println("Invalid selection");
            }
                
        }
        return UI;
    }


    public static Vehicles populate(Vehicles agency_vehicles)
    {       
            Vehicle car1 = new Car("Toyota Prius", 57, "ABD456");
            Vehicle car2 = new Car("Highlander Insight", 55, "DFE123");
            Vehicle car3 = new Car("Hyundai Elantra Hybrid", 53, "JKH857");

            Vehicle SUV1 = new SUV("Toyota RAVA4", 39, "DPF450",10);
            Vehicle SUV2 = new SUV("Ford Explorer Hybrid", 31, "WHC302",12);
            Vehicle SUV3 = new SUV("Honda Pilot Hybrid", 36, "KBS698",14);
            Vehicle SUV4 = new SUV("Lexus NX 450h+", 37, "GEK334",16);

            Vehicle MiniVan1 = new Minivan("Toyota Sienna", 36, "AGH890",30);
            Vehicle MiniVan2 = new Minivan("Chrysler Pacifica", 82, "BFJ386",32);
            Vehicle MiniVan3 = new Minivan("Honda Odyssey", 22, "KCM341",34);
            Vehicle MiniVan4 = new Minivan("Kia Carnival", 22, "THS580",36);

            agency_vehicles.add(car1);
            agency_vehicles.add(car2);
            agency_vehicles.add(car3);

            agency_vehicles.add(SUV1);
            agency_vehicles.add(SUV2);
            agency_vehicles.add(SUV3);
            agency_vehicles.add(SUV4);

            agency_vehicles.add(MiniVan1);
            agency_vehicles.add(MiniVan2);
            agency_vehicles.add(MiniVan3);
            agency_vehicles.add(MiniVan4);
            

        
        return agency_vehicles;
    }


}
    