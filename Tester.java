import java.util.Scanner;
public class Tester {
    

    public static void main(String[] args) {
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

        Vehicles vic = new Vehicles();
        vic.add(car1);
        vic.add(car2);
        vic.add(car3);

        vic.add(SUV1);
        vic.add(SUV2);
        vic.add(SUV3);
        vic.add(SUV4);

        vic.add(MiniVan1);
        vic.add(MiniVan2);
        vic.add(MiniVan3);
        vic.add(MiniVan4);

        vic.reset();
        while(vic.hasNext())
        {
            System.out.println(vic.next());
        }
        System.out.println("----------------------------------------------------");
        vic.reset();
        while(vic.hasNext())
        {
            System.out.println(vic.next().getDescription());
        }

        System.out.println("----------------------------------------------------");
        vic.reset();
        while(vic.hasNext())
        {
            System.out.println(vic.next().getMpg());
        }
        System.out.println("----------------------------------------------------");
        vic.reset();
        while(vic.hasNext())
        {
            System.out.println(vic.next().getVin());
        }

        System.out.println("----------------------------------------------------");
        System.out.println(vic.getVin("AGH890"));




        Transaction trans1 = new Transaction("123456789", "Michael", "1", "90", "500", "45,000");
        Transaction trans2 = new Transaction("000011110", "Alucard", "3", "20", "500", "10,000");
        Transaction trans3 = new Transaction("333333333", "Alexander", "2", "100", "500", "5,000");
        Transactions storeT = new Transactions();
        storeT.add(trans1);
        storeT.add(trans2);
        storeT.add(trans3);


        System.out.println("----------------------------------------------------");
        storeT.reset();
        while(storeT.hasNext())
        {
            System.out.println(storeT.next());
            
        }

        System.out.println("----------------------------------------------------");

        VehicleRates CarRates = new VehicleRates(20.25, 125.00, 300.00, 2000, 350);
        VehicleRates SUVRates = new VehicleRates(30.50,200.00,500.25,3000,380);
        VehicleRates MiniVanRates = new VehicleRates(55.75, 350.00, 770.60, 5000, 460);

        CurrentRates CurRates = new CurrentRates(CarRates,SUVRates,MiniVanRates);

        TimePeriod time = new TimePeriod('M', 4);

        


        System.out.println(CurRates.calcEstimatedCost(1, time, 2000, false));
        System.out.println("----------------------------------------------------");

        System.out.println(CurRates.calcActualCost(CarRates, 88, 2000, false));

        SystemInterface SF = new SystemInterface();
        SF.initSystem(CurRates, vic, storeT);
        System.out.println("----------------------------------------------------");

        System.out.println("Car Rate: ");

        for(String C: SF.getCarRates())
        {
            System.out.println("" + C);
        }
        System.out.println("SUV Rates:");
        for(String S: SF.getSUVRates())
        {
            System.out.println(""+ S);
        }
        System.out.println("MiniVan Rates: ");
        
        for(String M: SF.getMinivanRates())
        {
            System.out.println("" + M);
        }

        System.out.println("----------------------------------------------------");

        VehicleRates CarRates2 = new VehicleRates(100, 100, 100, 100, 100);
        SF.updateCarRates(CarRates2);
        System.out.println("Updated Car Rate: ");

        for(String C: SF.getCarRates())
        {
            System.out.println("" + C);
        }

        VehicleRates SUVRates2 = new VehicleRates(200, 200, 200, 200, 200);
        SF.updateSUVRates(SUVRates2);
        System.out.println("Updated SUV Rates:");
        for(String S: SF.getSUVRates())
        {
            System.out.println(""+ S);
        }

        VehicleRates MiniVanRates2 = new VehicleRates(300,300, 300, 300, 300);
        SF.updateMinivanRates(MiniVanRates2);
        System.out.println("Updated MiniVan Rates: ");
        
        for(String M: SF.getMinivanRates())
        {
            System.out.println("" + M);
        }
        System.out.println("----------------------------------------------------");
        RentalDetails rent = new RentalDetails("2", time, 1000, false);
        for(String rent2: SF.calcEstimatedRentalCost(rent))
        {
            System.out.println(" "+rent2);
        }
        for (String Pr: SF.processReturnedVehicle("DFE123", 90, 2000))
        {
            System.out.println("" + Pr);
        }


        System.out.println("----------------------------------------------------");
        System.out.println("All Cars: ");
        for(String AC: SF.getAvailCars())
        {
            System.out.println("" + AC);
        }
        System.out.println("\nAll SUVs: ");
        for(String SU: SF.getAvailSUVs())
        {
            System.out.println("" + SU);
        }
        System.out.println("\nAll MiniVans: ");
        for(String MV: SF.getAvailMinivans())
        {
            System.out.println("" + MV);
        }
        System.out.println("\nAll Vehicles: ");
        for(String VH: SF.getAllVehicles())
        {
            System.out.println("" + VH);
        }

        System.out.println("----------------------------------------------------");
        TimePeriod time2 = new TimePeriod('M', 3);
        ReservationDetails RD = new ReservationDetails("Mike Valentine", "00001111100000", time2, false, "AGH890");
        System.out.println("Making Reservation: ");
        for(String MR: SF.makeReservation(RD))
        {
            System.out.println("" + MR);
        }
        System.out.println("----------------------------------------------------");
        System.out.println("All Reservation: ");
        for(String AR: SF.getAllReservations())
        {
            System.out.println("" + AR);
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Cancel: ");
        for(String CR: SF.cancelReservation("AGH890"))
        {
            System.out.println(""+ CR);
        }
        System.out.println("----------------------------------------------------");


        
        for(String T: SF.addTransaction())
        {
            System.out.println(""+ T);
        }
        System.out.println("All Transaction: ");
        for(String T2: SF.getAllTransactions())
        {
            System.out.println("" + T2);
        }
        System.out.println("----------------------------------------------------");
        
// Scanner scan = new Scanner(System.in);
        
//         EmployeeGUI employee = new EmployeeGUI();
//         ManagerUI manager = new ManagerUI();
        
//         System.out.println("Is this a Employee(1) or an Manager(2)?");
//         int ans = scan.nextInt();
//         if (ans==1)
//         {
//             employee.start(scan);
//         }
//         else
//         {
//               if(ans==2)
//         {
//             manager.start(scan);
//         } 
//         }





    }
}
