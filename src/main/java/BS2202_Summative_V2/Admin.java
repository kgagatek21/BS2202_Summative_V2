package BS2202_Summative_V2;

import javax.persistence.*;

@Entity
public class Admin extends User
{

    public Admin(int id, String _username, String _password, String _fullName)
    {
        super(id, _username, _password, _fullName);

    }

    public Admin() {

    }

    public boolean isUserIsAdmin()
    {
        return true;
    }

}
