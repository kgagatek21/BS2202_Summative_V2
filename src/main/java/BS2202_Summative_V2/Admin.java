package BS2202_Summative_V2;

public class Admin extends User
{
    public Admin(String _username, String _password, String _fullName)
    {
        super(_username, _password, _fullName);

    }

    public boolean isAdmin()
    {
        return true;
    }

}
