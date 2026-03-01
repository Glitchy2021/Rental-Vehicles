public class TimePeriod {

    private char unit;
    private int quality;

    public TimePeriod(char unit, int quality)
    {
        this.unit = unit;
        this.quality = quality;
    }

    public TimePeriod(TimePeriod time)
    {
        this.unit = time.getUnit();
        this.quality = time.getQulity();
    }
    
    public char getUnit()
    {
        return unit;
    }

    public int getQulity()
    {
        return quality;
    }

    public String toString()
    {
        return unit +
        ": " + quality;
    }
}
