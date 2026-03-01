public class VehicleNode {

    private Vehicle value;
    private VehicleNode next;

    public VehicleNode(Vehicle value,VehicleNode next)
    {
        this.value = value;
        this.next = next;
    }

    public Vehicle getValue()
    {
        return value;
    }

    public VehicleNode getNext()
    {
        return next;
    }

    public void setNext(VehicleNode next)
    {
        this.next = next;
    }
    
}
