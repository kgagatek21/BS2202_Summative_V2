package BS2202_Summative_V2;

public class Item {

    protected String name;
    protected String length;
    protected String type;
    protected int noCopiesAvailable;
    protected int noCopiesLoaned;

    public Item(String _Name, String _Length, String _Type, int _NoOfAvailableCopies, int _NoCopiesLoaned)
    {
        this.name = _Name;
        this.length = _Length;
        this.type = _Type;
        this.noCopiesAvailable = _NoOfAvailableCopies;
        this.noCopiesLoaned = _NoCopiesLoaned;

    }

    public String getName() {return name;}

    public String getLength()
    {
        return length;
    }

    public String getType()
    {
        return type;
    }

    public int getNoCopiesAvailable()
    {
        return noCopiesAvailable;
    }

    public int getNoCopiesLoaned()
    {
        return noCopiesLoaned;
    }

}
