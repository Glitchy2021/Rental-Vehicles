

public class VehicleRates {
    private double daily_rate;
    private double weekly_rate;
    private double monthly_rate;
    private double per_mile_charge;
    private double daily_insurance;

    public VehicleRates(double daily_rate,double weekly_rate,double monthly_rate,double per_mile_charge,double daily_insurance)
    {
        this.daily_rate = daily_rate;
        this.weekly_rate = weekly_rate;
        this.monthly_rate = monthly_rate;
        this.per_mile_charge = per_mile_charge;
        this.daily_insurance = daily_insurance;
    }

    public VehicleRates(VehicleRates other)
    {
        this.daily_rate = other.getDailyRate();
        this.weekly_rate = other.getWeeklyRate();
        this.monthly_rate = other.getMonthlyRate();
        this.per_mile_charge = other.getMileageChrg();
        this.daily_insurance = other.getDailyInsurRate();
    }

    public double getDailyRate()
    {
        return daily_rate;
    }

    public double getWeeklyRate()
    {
        return weekly_rate;
    }

    public double getMonthlyRate()
    {
        return monthly_rate;
    }

    public double getMileageChrg()
    {
        return per_mile_charge;
    }

    public double getDailyInsurRate()
    {
        return daily_insurance;
    }

    public String toString()
    {
        return "Daily rate: " + daily_rate + 
        " Weekly Rate: " + weekly_rate + 
        " Monthly Rate: " + monthly_rate + 
        " Mileage charge: " + per_mile_charge + 
        " Daily Insurance: " + daily_insurance;
    }
}
