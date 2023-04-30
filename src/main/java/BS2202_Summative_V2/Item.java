package BS2202_Summative_V2;

import javax.persistence.*;

@Entity
public class Item {

    protected  int itemID;

    protected String name;
    protected String length;
    protected String type;
    protected int noCopiesAvailable;
    protected int noCopiesLoaned;

    public Item(int _itemID, String _Name, String _Length, String _Type, int _NoOfAvailableCopies, int _NoCopiesLoaned)
    {
        itemID = _itemID;
        this.name = _Name;
        this.length = _Length;
        this.type = _Type;
        this.noCopiesAvailable = _NoOfAvailableCopies;
        this.noCopiesLoaned = _NoCopiesLoaned;

    }

    public Item() {

    }

    @Id
    public int getItemID() {
        return itemID;
    }
    public void setItemID(int _id) {itemID = _id;}

    public String getName() {return name;}
    public void setName(String _name) {name = _name;}

    public String getLength()
    {
        return length;
    }
    public void setLength(String _length) {length = _length;}
    public String getType()
    {
        return type;
    }
    public void setType(String _type) {type = _type;}

    public int getNoCopiesAvailable()
    {
        return noCopiesAvailable;
    }
    public void setNoCopiesAvailable(int number) {noCopiesAvailable = number;}

    public int getNoCopiesLoaned()
    {
        return noCopiesLoaned;
    }
    public void setNoCopiesLoaned(int number) {noCopiesLoaned = number;}

}
