public class ReservationDetails {
    
    private String customer_name;
    private String credit_card_num;
    private TimePeriod rental_period;
    private boolean insurance_selected;
    private String VIN;

    public ReservationDetails(String customer_name,String credit_card_num,TimePeriod rental_period, boolean insurance_selected, String VIN)
    {
        this.customer_name = customer_name;
        this.credit_card_num = credit_card_num;
        this.rental_period = rental_period;
        this.insurance_selected = insurance_selected;
        this.VIN = VIN;
    }

    public ReservationDetails(ReservationDetails rent2)
    {
        this.customer_name = rent2.getCustomerName();
        this.credit_card_num = rent2.getCreditCardNum();
        this.rental_period = rent2.getTimePeriod();
        this.insurance_selected = rent2.getInsurance();
        this.VIN = rent2.getVin();
    }

    public String getCustomerName()
    {
        return  customer_name;
    }

    public String getCreditCardNum()
    {
        return credit_card_num;
    }

    public TimePeriod getTimePeriod()
    {
        return rental_period;
    }

    public boolean getInsurance()
    {
        return insurance_selected;
    }

    public String getVin()
    {
        return VIN;
    }

    public String toString()
    {
        return "Customer Name: " + customer_name+ 
        " Credit card number: " + " Time period: " + 
        rental_period.toString() + " Insurance: " + insurance_selected
        +" Vin number: " + VIN;
    }
}
