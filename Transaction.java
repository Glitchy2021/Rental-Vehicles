
public class Transaction {

    private String creditcard_num;
    private String customer_name;
    private String vehicle_type;
    private String rental_period;
    private String miles_driven;
    private String rental_cost;

    public Transaction(String creditcard_num,String customer_name,String vehicle_type,String rental_period,String miles_driven,String rental_cost)
    {
        this.creditcard_num = creditcard_num;
        this.customer_name = customer_name;
        this.vehicle_type = vehicle_type;
        this.rental_period = rental_period;
        this.miles_driven = miles_driven;
        this.rental_cost = rental_cost;

    }

    public String toString()
    {
        return "Customer Name: " + customer_name + 
        " Credit Card Number: " + creditcard_num +
        " Vehicle Type: " + vehicle_type +
        " Rental Period: " + rental_period + 
        " Miles Driven: " + miles_driven +
        " Rental Cost: " + rental_cost;
    }
    
}
