public class CurrentRates {

    private VehicleRates[] rates = new VehicleRates[3];

    public CurrentRates(VehicleRates Car, VehicleRates SUV, VehicleRates MiniVan)
    {
        this.rates[0]= Car;
        this.rates[1]= SUV;
        this.rates[2]= MiniVan;
    }

    public VehicleRates getCaRates()
    {
        return rates[0];
    }

    public VehicleRates getSUVRates()
    {
        return rates[1];
    }

    public VehicleRates getMiniVan()
    {
        return rates[2];
    }

    public void setCarRates(VehicleRates r)
    {
        rates[0] = r;
    }

    public void setSUVRates(VehicleRates r)
    {
        rates[1] = r;
    }

    public void setMiniVanRates(VehicleRates r)
    {
        rates[2] = r;
    }

    public double calcEstimatedCost(int vehicleType, TimePeriod estimatedRentalPeriod, int esitmatedNumMiles, boolean dailyInsur)
    {
        double cost;
        int time3 = estimatedRentalPeriod.getQulity();
        
        if(dailyInsur)
        {
            cost = esitmatedNumMiles * time3*rates[vehicleType-1].getDailyInsurRate();
            
            
            
        }
        else
        {
            cost = (double)esitmatedNumMiles * time3;
            
            

        }

        return cost;
    }

    public double calcActualCost(VehicleRates rates, int num_days_used, int NumMilesDriven, boolean dailyInsur)
    {
        double cost;
        if(dailyInsur)
        {
            cost = num_days_used * NumMilesDriven * rates.getDailyInsurRate();
            return cost;
        }
        else
        {
            cost = (double)num_days_used * NumMilesDriven;
            return cost;
        }
    }

    
}
