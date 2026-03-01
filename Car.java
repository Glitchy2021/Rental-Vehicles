public class Car extends Vehicle {
    private String description;
    private int mpg;
    private String vin;

    public Car(String description, int mpg, String vin)
    {
        super(description,mpg,vin);
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


    @Override
    public String toString() {
        return description + ": " + mpg + " mpg combined, VIN " + vin;
    }
    
}
