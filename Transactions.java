public class Transactions {

    private Transaction[] transactions;
    private int count = 0;
    private int Index =0;

    public Transactions()
    {
        transactions = new Transaction[100];
    }
    
    public void add(Transaction tran)
    {
        transactions[count] = tran;
        count++;
    }

    public void reset()
    {
        Index = 0;
    }

    public boolean hasNext()
    {
        return transactions[Index] != null;
    }
    public Transaction next()
    {
        return transactions[Index++];
    }
}
