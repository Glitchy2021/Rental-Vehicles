public class SUV extends Vehicle{

    private String description;
    private int mpg;
    private String vin;
    private int cargo;

    public SUV(String description, int mpg, String vin, int cargo)
    {
        super(description,mpg,vin);
        this.description = description;
        this.mpg = mpg;
        this.vin = vin;
        this.cargo = cargo;
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

    public int getCargo()
    {
        return cargo;
    }


    @Override
    public String toString() {
        return description + ": " + mpg + " mpg combined, VIN: " + vin + " Cargo: " + cargo;
    }
    
    
}
