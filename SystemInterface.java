public class SystemInterface {

	private static CurrentRates agency_rates;
	private static Vehicles agency_vehicles;
	private static Transactions transactions_history;

	// used to init static variables (in place of a constructor)
	public static void initSystem(CurrentRates r, Vehicles v, Transactions t) {
		agency_rates = r;
		agency_vehicles = v;
		transactions_history = t;
	}

	public static boolean initialized()
	{
		return agency_rates!=null;
	}
	
// Note that methods makeReservation, cancelReservation and updateXXXRates return an
// acknowledgement of successful completion of the requested action (e.g. “Vehicle ABC123
// successfully reserved”). Method processReturnedVehicle returns the final cost for the returned 
// vehicle (e.g., “Total charge for VIN ABC123 for 3 days, 233 miles @  0.15/mile and daily
// insurance @ 14.95/day = $xxx.xx.)
	// Current Rates Related Methods
	public static String[ ] getCarRates() {
		 String[] Cr = new String[1];
		 Cr[0] = agency_rates.getCaRates().toString();
		 return Cr;
	 }
	public static String[ ] getSUVRates() {
		String[] SUVR = new String[1];
		SUVR[0] = agency_rates.getSUVRates().toString();
		return SUVR;
	}
	public static String[ ] getMinivanRates() {
		String[] MiniVanR = new String[1];
		MiniVanR[0] = agency_rates.getMiniVan().toString();
		return MiniVanR;
	 }

	public static String[ ] updateCarRates(VehicleRates r) {
		agency_rates.setCarRates(r);
		String[] Cr = new String[1];
		 Cr[0] = agency_rates.getCaRates().toString();
		 return Cr;
		
		 
	}
	public static String[ ] updateSUVRates(VehicleRates r) { 
		agency_rates.setSUVRates(r);
		String[] SUVR = new String[1];
		SUVR[0] = agency_rates.getSUVRates().toString();
		return SUVR;

	 }
	public static String[ ] updateMinivanRates(VehicleRates r) { 
		agency_rates.setMiniVanRates(r);
		String[] MiniVanR = new String[1];
		MiniVanR[0] = agency_rates.getSUVRates().toString();
		return MiniVanR;

	 }

public static String[ ] calcEstimatedRentalCost(RentalDetails details) { 
	String[] rent = new String[1];
	int type=0;
	if(details.getVehicleType().equals("1"))
	{
		type=1;
	}
	else
	{
		if(details.getVehicleType().equals("2"))
		{
			type =2;
		}
		else
		{
			if(details.getVehicleType().equals("3"))
			{
				type = 3;
			}
		}
	}

	double rent2;
	rent2 = agency_rates.calcEstimatedCost(type, details.getRentalPeriod(), details.getNumMilesDriven(), details.getInsuranceSelected());
	rent[0] = "Cost for "+ details.toString() + "\n$" +rent2;
	return rent;
	

 }
public static String[ ] processReturnedVehicle(String vin, int num_days_used, int num_miles_driven) { 
	double return1;
	boolean sure =agency_vehicles.getVin(vin).isReservation();

	return1 = agency_rates.calcActualCost(agency_vehicles.getVin(vin).getVehicleRates(), num_days_used, num_miles_driven,sure );
	String[] rent = new String[1];
	rent[0] = "Returned Vehicle for " + agency_vehicles.getVin(vin).toString()+"\n$"+return1;
	return rent;
 }

// Note that the rates to be used are retrieved from the VehicleRates object stored in the specific rented
// vehicle object, and the daily insurance option is retrieved from the Reservation object of the rented
// vehicle

	// Vehicle Related Methods
public static String[ ] getAvailCars() {
	int num_cars=0;
	Vehicle v;
	agency_vehicles.reset();
	while(agency_vehicles.hasNext())
	{
		v = agency_vehicles.next();
		if (v instanceof Car && !v.isReservation())
		{
			num_cars = num_cars+1;
		}

	}
	String [] avail_cars = new String[num_cars];
	int i =0;
	agency_vehicles.reset();
	while(agency_vehicles.hasNext())
	{
		v = agency_vehicles.next();
		if(v instanceof Car && !v.isReservation())
		{
			avail_cars[i++] = v.toString();
		}
	}
return avail_cars;


}
public static String[ ] getAvailSUVs() { 
	int num_SUV=0;
	Vehicle v;
	agency_vehicles.reset();
	while(agency_vehicles.hasNext())
	{
		v = agency_vehicles.next();
		if (v instanceof SUV && !v.isReservation())
		{
			num_SUV = num_SUV+1;
		}

	}
	String [] avail_SUV = new String[num_SUV];
	int i =0;
	agency_vehicles.reset();
	while(agency_vehicles.hasNext())
	{
		v = agency_vehicles.next();
		if(v instanceof SUV && !v.isReservation())
		{
			avail_SUV[i++] = v.toString();
		}
	}
return avail_SUV;

	


 }
public static String[ ] getAvailMinivans() { 

	int num_MiniV=0;
	Vehicle v;
	agency_vehicles.reset();
	while(agency_vehicles.hasNext())
	{
		v = agency_vehicles.next();
		if (v instanceof Minivan && !v.isReservation())
		{
			num_MiniV = num_MiniV+1;
		}

	}
	String [] avail_MiniV = new String[num_MiniV];
	int i =0;
	agency_vehicles.reset();
	while(agency_vehicles.hasNext())
	{
		v = agency_vehicles.next();
		if(v instanceof Minivan && !v.isReservation())
		{
			avail_MiniV[i++] = v.toString();
		}
	}
return avail_MiniV;

	



 }
public static String[ ] getAllVehicles() { 
	
	int num_V=0;
	Vehicle v;
	agency_vehicles.reset();
	while(agency_vehicles.hasNext())
	{
		v = agency_vehicles.next();
		if (v instanceof Vehicle && !v.isReservation())
		{
			num_V = num_V+1;
		}

	}
	String [] avail_V = new String[num_V];
	int i =0;
	agency_vehicles.reset();
	while(agency_vehicles.hasNext())
	{
		v = agency_vehicles.next();
		if(v instanceof Vehicle && !v.isReservation())
		{
			avail_V[i++] = v.toString();
		}
	}
return avail_V;


 }

public static String[ ] makeReservation(ReservationDetails details) { 
	
	String [] res = new String[1];
	String VIN = details.getVin();
	agency_vehicles.getVin(VIN).setReservation(details); 

	res[0] = agency_vehicles.getVin(VIN).toString();
	
	return res;


 }
public static String[ ] cancelReservation(String vin) { 
	String [] res2 = new String[1];
	agency_vehicles.getVin(vin).cancelReservation();
	res2[0] = agency_vehicles.getVin(vin).toString();
		
	

	return res2;


 }
public static String[ ] getReservation(String vin) { 
	String [] res2 = new String[1];
	res2[0] = agency_vehicles.getVin(vin).toString();
	return res2;


	
 }
public static String[ ] getAllReservations() { 
	int num_V=0;
	Vehicle v;
	agency_vehicles.reset();
	while(agency_vehicles.hasNext())
	{
		v = agency_vehicles.next();
		if (v.isReservation())
		{
			num_V = num_V+1;
		}

	}
	String [] avail_V = new String[num_V];
	int i =0;
	agency_vehicles.reset();
	while(agency_vehicles.hasNext())
	{
		v = agency_vehicles.next();
		if(v.isReservation())
		{
			avail_V[i++] = v.toString();
		}
	}
return avail_V;

 }


// transactions-related methods
public static String[ ] addTransaction() { 
	int num_T=0;
	Transaction trans;
	transactions_history.reset();
	while(transactions_history.hasNext())
	{
		
		trans = transactions_history.next();
		num_T= num_T+1;
		

	}
	String [] Trans_H = new String[num_T];
	int i =0;
	transactions_history.reset();
	while(transactions_history.hasNext())
	{
		trans = transactions_history.next();
		Trans_H[i++] = trans.toString();
	}
return Trans_H;

 }  
public static String[ ] getAllTransactions() { 
	int num_T=0;
	Transaction trans;
	transactions_history.reset();
	while(transactions_history.hasNext())
	{
		trans = transactions_history.next();
		if (trans instanceof Transaction)
		{
			num_T= num_T+1;
		}

	}
	String [] Trans_H = new String[num_T];
	int i =0;
	transactions_history.reset();
	while(transactions_history.hasNext())
	{
		trans = transactions_history.next();
		if(trans instanceof Transaction)
		{
			Trans_H[i++] = trans.toString();
		}
	}
return Trans_H;

	
 }  

}