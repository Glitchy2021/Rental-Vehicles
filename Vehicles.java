

public class Vehicles {
    
    private VehicleNode head;
    private VehicleNode current;
    public Vehicles()
    {
        this.head = null;
        this.current = null;

    } 

    public boolean isEmpty()
    {
        return head==null;
    }

    public void add(Vehicle v)
    {
        if(isEmpty())
        {
            head = new VehicleNode(v, null);
        }
        else{
            VehicleNode temptr = head;
            while(temptr.getNext() != null)
            {
                temptr = temptr.getNext();
            }
            temptr.setNext(new VehicleNode(v, null));
        }
    }
    public Vehicle getVin(String VIN)
    {
        reset();
        while(hasNext())
        {
            if(current.getValue().getVin().equals(VIN))
            {
                return current.getValue();
            }
            next();
        }
        return null;
    }

    public void reset()
    {
        current = head;
    }

    public boolean hasNext()
    {
        return current != null;
    }
    public Vehicle next()
    {
        Vehicle nextV = current.getValue();
        current = current.getNext();
        return nextV;
    }
}
