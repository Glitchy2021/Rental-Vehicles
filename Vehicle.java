public abstract class Vehicle {
    private String description;
    private int mpg;
    private String vin;
    private ReservationDetails resv;
    private VehicleRates rates;
    
    public Vehicle(String description, int mpg, String vin)
    {
        this.description = description;
        this.mpg = mpg;
        this.vin = vin;
        
        
    }

    public String getDescription()
    {
        return description;
    }
    
    public int getMpg()
    {
        return mpg;
    }

    public String getVin()
    {
        return vin;
    }

    public ReservationDetails getReservation()
    {
        return resv;
    }

    public VehicleRates getVehicleRates()
    {
        return rates;
    }

    public boolean isReservation()
    {
        if (resv != null)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

    public void setReservation(ReservationDetails other)
    {
        resv = new ReservationDetails(other);
    }

    public void setQuotedRates(VehicleRates cost)
    {
        rates = new VehicleRates(cost);
    }

    public void cancelReservation()
    {
        resv = null;
    }

    public abstract String toString();

}
